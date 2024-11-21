import tkinter as tk
from tkinter import ttk, messagebox,filedialog
import numpy as np
import pandas as pd
import threading
import matplotlib.pyplot as plt

# 定义进程数据结构
class Process:
    def __init__(self, pid, arrival_time, burst_time, priority, process_type):
        self.pid = pid
        self.arrival_time = arrival_time
        self.burst_time = burst_time
        self.remaining_time = burst_time
        self.priority = priority
        self.type = process_type
        self.waiting_time = 0
        self.turnaround_time = 0


# 调度算法实现
def round_robin(processes, time_slice):
    time = 0
    completed = 0
    result = []
    n = len(processes)
    context_switch_count = 0
    last_process = None
    ready_queue = []  # 添加就绪队列

    # 按到达时间排序
    sorted_processes = sorted(processes, key=lambda x: x.arrival_time)

    while completed < n:
        # 检查新到达的进程
        for p in sorted_processes:
            if p.arrival_time <= time and p.remaining_time > 0 and p not in ready_queue:
                ready_queue.append(p)

        if not ready_queue:
            time += 1
            continue

        # 获取当前进程
        current_process = ready_queue.pop(0)

        # 检查上下文切换
        if last_process is not None and last_process != current_process:
            context_switch_count += 1

        # 执行进程
        time_slice_used = min(current_process.remaining_time, time_slice)
        result.append((current_process.pid, time, time + time_slice_used))
        time += time_slice_used
        current_process.remaining_time -= time_slice_used

        # 如果进程完成
        if current_process.remaining_time == 0:
            current_process.completion_time = time
            current_process.turnaround_time = current_process.completion_time - current_process.arrival_time
            current_process.waiting_time = current_process.turnaround_time - current_process.burst_time
            completed += 1
        else:
            ready_queue.append(current_process)

        last_process = current_process

    return result, context_switch_count


def preemptive_shortest_job_first(processes):
    time = 0
    completed = 0
    n = len(processes)
    result = []
    context_switch_count = 0
    last_process = None  # To track context switches

    # Sort processes by arrival time initially
    processes = sorted(processes, key=lambda x: x.arrival_time)
    available_processes = []
    
    while completed < n:
        # Add newly arrived processes to the available list
        available_processes += [p for p in processes if p.arrival_time == time and p.remaining_time > 0]

        # Select the process with the shortest remaining time
        if available_processes:
            available_processes = sorted(available_processes, key=lambda x: x.remaining_time)
            current_process = available_processes[0]

            # Check for context switch
            if last_process is not None and last_process != current_process:
                context_switch_count += 1

            # Execute the process for 1 unit of time
            start_time = time
            time += 1
            current_process.remaining_time -= 1
            end_time = time

            # Record the process execution segment for visualization
            result.append((current_process.pid, start_time, end_time))

            # If the process completes, update turnaround and waiting time, and remove from available list
            if current_process.remaining_time == 0:
                current_process.turnaround_time = time - current_process.arrival_time
                current_process.waiting_time = current_process.turnaround_time - current_process.burst_time
                completed += 1
                available_processes.remove(current_process)

            # Update the last executed process
            last_process = current_process
        else:
            # No process available, move time forward
            time += 1

    return result, context_switch_count

    time = 0
    completed = 0
    result = []
    context_switch_count = 0  # Initialize context switch count
    while completed < len(processes):
        available_processes = [p for p in processes if p.arrival_time <= time and p.remaining_time > 0]
        if not available_processes:
            time += 1
            continue
        current_process = min(available_processes, key=lambda x: x.burst_time)
        start_time = time
        time += current_process.burst_time
        current_process.remaining_time = 0
        current_process.turnaround_time = time - current_process.arrival_time
        current_process.waiting_time = current_process.turnaround_time - current_process.burst_time
        result.append((current_process.pid, start_time, time))  # start and end time
        completed += 1
    return result, context_switch_count  # Ensure both values are returned


def priority_scheduling(processes):
    time = 0
    completed = 0
    result = []
    context_switch_count = 0
    last_process = None  # To track context switches

    # Sort processes by arrival time initially
    processes = sorted(processes, key=lambda x: (x.arrival_time, x.priority))

    while completed < len(processes):
        # Get available processes (those that have arrived and are not yet completed)
        available_processes = [p for p in processes if p.arrival_time <= time and p.remaining_time > 0]

        if available_processes:
            # Select the process with the highest priority (lowest priority number)
            current_process = min(available_processes, key=lambda x: x.priority)

            # Check for context switch
            if last_process is not None and last_process != current_process:
                context_switch_count += 1  # Increment context switch count

            # Execute the selected process until completion
            start_time = time
            time += current_process.remaining_time
            end_time = time
            current_process.remaining_time = 0  # Mark as completed
            current_process.turnaround_time = end_time - current_process.arrival_time
            current_process.waiting_time = current_process.turnaround_time - current_process.burst_time

            # Record the process execution time for visualization
            result.append((current_process.pid, start_time, end_time))

            # Update completed count and last process
            completed += 1
            last_process = current_process
        else:
            # If no process is available, move time forward
            time += 1

    return result, context_switch_count


# 显示调度结果
def display_schedule(result):
    canvas.delete("all")
    x_offset = 10
    y_offset = 50

    # 绘制时间轴
    max_time = max([end for _, _, end in result])
    for t in range(0, max_time + 1):
        x = x_offset + t * 20  # 每个时间点间隔20像素
        canvas.create_line(x, y_offset + 30, x, y_offset + 60, fill="black")  # 刻度线
        canvas.create_text(x, y_offset + 70, text=str(t), anchor=tk.N)  # 时间标记

    # 绘制进程块
    color_map = ["#4CAF50", "#FF9800", "#2196F3", "#FF5722", "#9C27B0", "#795548"]  # 不同进程颜色
    for i, (pid, start, end) in enumerate(result):
        x_start = x_offset + start * 20
        x_end = x_offset + end * 20
        color = color_map[pid % len(color_map)]

        # 绘制进程矩形
        canvas.create_rectangle(x_start, y_offset, x_end, y_offset + 20, fill=color)
        canvas.create_text((x_start + x_end) / 2, y_offset + 10, text=f"P{pid}", fill="white")

        # 使用不同颜色标记起始和结束时间
        # 起始时间用绿色圆圈，结束时间用红色圆圈
        canvas.create_oval(x_start - 5, y_offset - 15, x_start + 5, y_offset - 5, fill="green")  # 起始时间标记
        canvas.create_text(x_start, y_offset - 20, text=f"{start}", fill="green", anchor=tk.S)  # 起始时间标签

        canvas.create_oval(x_end - 5, y_offset - 15, x_end + 5, y_offset - 5, fill="red")  # 结束时间标记
        canvas.create_text(x_end, y_offset - 20, text=f"{end}", fill="red", anchor=tk.S)  # 结束时间标签


# 开始调度
def start_scheduling():
    processes = []

    # 检查所有输入框是否已填且为数字
    for i in range(len(arrival_entries)):
        try:
            arrival_time = int(arrival_entries[i].get())
            burst_time = int(burst_entries[i].get())
            priority = int(priority_entries[i].get())
            processes.append(Process(i + 1, arrival_time, burst_time, priority))
        except ValueError:
            # 弹出错误提示框
            messagebox.showerror("Input Error", f"Please enter valid numbers for Process {i + 1}.")
            return

    # 处理 Round Robin 的时间片
    if algorithm_choice.get() == "Round Robin":
        try:
            time_slice = int(time_slice_entry.get())
        except ValueError:
            # 如果时间片无效，弹出错误框
            messagebox.showerror("Input Error", "Please enter a valid time slice for Round Robin.")
            return
        result = round_robin(processes, time_slice)
    elif algorithm_choice.get() == "Shortest Job First":
        result = preemptive_shortest_job_first(processes)
    elif algorithm_choice.get() == "Priority Scheduling":
        result = priority_scheduling(processes)
    else:
        # 如果没有选择算法，弹出错误框
        messagebox.showerror("Input Error", "Please select a scheduling algorithm.")
        return

    display_schedule(result)

# 增加新的函数：根据类型自动设置 burst time
def set_burst_time(entry, process_type):
    if process_type == "CPU-intensive":
        entry.delete(0, tk.END)
        entry.insert(0, "10")  # 假设 CPU密集型进程的默认 burst time 较大
    elif process_type == "I/O-intensive":
        entry.delete(0, tk.END)
        entry.insert(0, "3")   # 假设 I/O密集型进程的默认 burst time 较小
    elif process_type == "Mixed":
        entry.delete(0, tk.END)
        entry.insert(0, "6")   # 混合型进程的默认 burst time 适中

# 计算公平性指标
def calculate_fairness_metrics(processes):
    waiting_times = [p.waiting_time for p in processes]
    average_waiting_time = np.mean(waiting_times)
    waiting_time_std_dev = np.std(waiting_times)
    return average_waiting_time, waiting_time_std_dev

# 计算 CPU 利用率
def calculate_cpu_utilization(total_execution_time, total_time):
    cpu_utilization = (total_execution_time / total_time) * 100
    return cpu_utilization


# GUI 设置
# 创建主窗口
root = tk.Tk()
root.title("Process Scheduling Simulation")

# Set the default window size (width x height)
root.geometry("1000x870")  # Adjust the size as needed

# 创建一个外层 Canvas 和滚动条
outer_frame = tk.Frame(root)
outer_frame.pack(fill="both", expand=True)

canvas = tk.Canvas(outer_frame)
scrollable_frame = tk.Frame(canvas)

# 添加垂直滚动条
v_scrollbar = tk.Scrollbar(outer_frame, orient="vertical", command=canvas.yview)
canvas.configure(yscrollcommand=v_scrollbar.set)

v_scrollbar.pack(side="right", fill="y")
canvas.pack(side="left", fill="both", expand=True)

# 将 scrollable_frame 放入 Canvas 中
canvas.create_window((0, 0), window=scrollable_frame, anchor="nw")

# 更新 Canvas 的滚动区域
def configure_canvas(event):
    canvas.configure(scrollregion=canvas.bbox("all"))

scrollable_frame.bind("<Configure>", configure_canvas)





# 在 scrollable_frame 内部添加您的所有组件
tk.Label(scrollable_frame, text="Process Scheduling Algorithm Simulation", font=("Arial", 16)).pack(pady=10)
algorithm_choice = tk.StringVar(value="Round Robin")
algorithms = ["Round Robin", "Shortest Job First", "Priority Scheduling"]
tk.OptionMenu(scrollable_frame, algorithm_choice, *algorithms).pack(pady=5)

# 例如，一个包含进程设置的框架
frame = tk.Frame(scrollable_frame)
frame.pack(pady=10, fill="x", expand=True)

# 示例内容添加
arrival_entries = []
burst_entries = []
priority_entries = []
type_choices = []
process_count = 3  # 起始进程数 # Start from 3 since we're manually adding the first three processes

# Initialize process IDs and selected process variable
process_ids = ["Process 1", "Process 2", "Process 3"]
selected_process = tk.StringVar(root)
selected_process.set(process_ids[0])  # Default selection for remove menu

# Create dropdown menu for selecting process to remove
remove_option_menu = tk.OptionMenu(root, selected_process, *process_ids)
remove_option_menu.pack()

# 绑定鼠标滚轮事件 (Windows 下使用 <MouseWheel>)
def on_mousewheel(event):
    canvas.yview_scroll(int(-1 * (event.delta / 120)), "units")

canvas.bind_all("<MouseWheel>", on_mousewheel)

# 设置 burst time 根据类型
def set_burst_time(entry, process_type):
    if process_type == "CPU-intensive":
        entry.delete(0, tk.END)
        entry.insert(0, "10")
    elif process_type == "I/O-intensive":
        entry.delete(0, tk.END)
        entry.insert(0, "3")
    elif process_type == "Mixed":
        entry.delete(0, tk.END)
        entry.insert(0, "6")


# Function to update the dropdown menu for removing processes
def update_remove_option():
    remove_option_menu["menu"].delete(0, "end")
    for pid in process_ids:
        remove_option_menu["menu"].add_command(label=pid, command=tk._setit(selected_process, pid))


# Manually add the first three processes
for i in range(3):
    row = i

    process_id = process_ids[i]
    tk.Label(frame, text=f"{process_id} Arrival Time:").grid(row=row, column=0, padx=5, pady=5, sticky="e")
    arrival_entry = tk.Entry(frame)
    arrival_entry.grid(row=row, column=1, padx=5, pady=5, sticky="w")
    arrival_entries.append(arrival_entry)

    tk.Label(frame, text=f"{process_id} Burst Time:").grid(row=row, column=2, padx=5, pady=5, sticky="e")
    burst_entry = tk.Entry(frame)
    burst_entry.grid(row=row, column=3, padx=5, pady=5, sticky="w")
    burst_entries.append(burst_entry)

    tk.Label(frame, text=f"{process_id} Priority:").grid(row=row, column=4, padx=5, pady=5, sticky="e")
    priority_entry = tk.Entry(frame)
    priority_entry.grid(row=row, column=5, padx=5, pady=5, sticky="w")
    priority_entries.append(priority_entry)

    tk.Label(frame, text=f"{process_id} Type:").grid(row=row, column=6, padx=5, pady=5, sticky="e")
    type_var = tk.StringVar(value="CPU-intensive")
    type_menu = ttk.OptionMenu(frame, type_var, "CPU-intensive", "CPU-intensive", "I/O-intensive", "Mixed")
    type_menu.grid(row=row, column=7, padx=5, pady=5, sticky="w")
    type_choices.append(type_var)

# Function to add a new process
def add_process():
    global process_count
    process_count += 1
    process_id = f"Process {process_count}"
    process_ids.append(process_id)

    # Add labels and entries for the new process
    row = process_count - 1

    tk.Label(frame, text=f"{process_id} Arrival Time:").grid(row=row, column=0, padx=5, pady=5, sticky="e")
    arrival_entry = tk.Entry(frame)
    arrival_entry.grid(row=row, column=1, padx=5, pady=5, sticky="w")
    arrival_entries.append(arrival_entry)

    tk.Label(frame, text=f"{process_id} Burst Time:").grid(row=row, column=2, padx=5, pady=5, sticky="e")
    burst_entry = tk.Entry(frame)
    burst_entry.grid(row=row, column=3, padx=5, pady=5, sticky="w")
    burst_entries.append(burst_entry)

    tk.Label(frame, text=f"{process_id} Priority:").grid(row=row, column=4, padx=5, pady=5, sticky="e")
    priority_entry = tk.Entry(frame)
    priority_entry.grid(row=row, column=5, padx=5, pady=5, sticky="w")
    priority_entries.append(priority_entry)

    tk.Label(frame, text=f"{process_id} Type:").grid(row=row, column=6, padx=5, pady=5, sticky="e")
    type_var = tk.StringVar(value="CPU-intensive")
    type_menu = ttk.OptionMenu(frame, type_var, "CPU-intensive", "CPU-intensive", "I/O-intensive", "Mixed")
    type_menu.grid(row=row, column=7, padx=5, pady=5, sticky="w")
    type_choices.append(type_var)

    # Refresh the remove option menu
    update_remove_option()






# 重新构建进程输入行并填充数据
def rebuild_process_entries(saved_data):
    # 清除现有的控件
    for widget in frame.winfo_children():
        widget.destroy()

    # 清空当前输入列表
    arrival_entries.clear()
    burst_entries.clear()
    priority_entries.clear()
    type_choices.clear()

    # 重新生成控件并填充保存的数据
    for i, data in enumerate(saved_data):
        process_id = data['id']

        tk.Label(frame, text=f"{process_id} Arrival Time:").grid(row=i, column=0, padx=5, pady=5, sticky="e")
        arrival_entry = tk.Entry(frame)
        arrival_entry.grid(row=i, column=1, padx=5, pady=5, sticky="w")
        arrival_entry.insert(0, data["arrival"])  # 填充保存的到达时间数据
        arrival_entries.append(arrival_entry)

        tk.Label(frame, text=f"{process_id} Burst Time:").grid(row=i, column=2, padx=5, pady=5, sticky="e")
        burst_entry = tk.Entry(frame)
        burst_entry.grid(row=i, column=3, padx=5, pady=5, sticky="w")
        burst_entry.insert(0, data["burst"])  # 填充保存的服务时间数据
        burst_entries.append(burst_entry)

        tk.Label(frame, text=f"{process_id} Priority:").grid(row=i, column=4, padx=5, pady=5, sticky="e")
        priority_entry = tk.Entry(frame)
        priority_entry.grid(row=i, column=5, padx=5, pady=5, sticky="w")
        priority_entry.insert(0, data["priority"])  # 填充保存的优先级数据
        priority_entries.append(priority_entry)

        tk.Label(frame, text=f"{process_id} Type:").grid(row=i, column=6, padx=5, pady=5, sticky="e")
        type_var = tk.StringVar(value=data["type"])
        type_menu = ttk.OptionMenu(frame, type_var, data["type"], "CPU-intensive", "I/O-intensive", "Mixed")
        type_menu.grid(row=i, column=7, padx=5, pady=5, sticky="w")
        type_choices.append(type_var)

    # 更新 `process_ids` 列表，使其与 `saved_data` 保持一致
    process_ids.clear()
    process_ids.extend([data["id"] for data in saved_data])



# 删除选定的进程输入行
# 示例：在获取 Entry 的值时捕获异常并显示错误框
# Function to remove the selected process
def remove_process():
    try:
        selected_pid = selected_process.get()
        if selected_pid in process_ids:
            index = process_ids.index(selected_pid)

            # 保存现有进程的数据
            saved_data = []
            for i in range(len(arrival_entries)):
                if i != index:  # 跳过要删除的进程
                    data = {
                        "id": process_ids[i],
                        "arrival": arrival_entries[i].get(),
                        "burst": burst_entries[i].get(),
                        "priority": priority_entries[i].get(),
                        "type": type_choices[i].get()
                    }
                    saved_data.append(data)

            # 从列表中移除被删除的进程
            process_ids.pop(index)
            arrival_entries.pop(index)
            burst_entries.pop(index)
            priority_entries.pop(index)
            type_choices.pop(index)

            # 更新进程计数
            global process_count
            process_count -= 1

            # 重新生成界面并填充剩余进程的数据
            rebuild_process_entries(saved_data)
            update_remove_option()  # 更新删除选项
        else:
            messagebox.showwarning("Warning", "Please select a valid process to remove.")
    except Exception as e:
        messagebox.showerror("Error", f"An error occurred: {str(e)}")




# 布局按钮的框架
button_frame = tk.Frame(root)
button_frame.pack(fill="x", pady=10)

# 左侧按钮
left_button_frame = tk.Frame(button_frame)
left_button_frame.pack(side="left", padx=10)

# Buttons to add and remove processes
add_process_button = tk.Button(root, text="Add Process", command=add_process)
add_process_button.pack(pady=5)

remove_process_button = tk.Button(root, text="Remove Process", command=remove_process)
remove_process_button.pack(pady=5)

# 右侧按钮
right_button_frame = tk.Frame(button_frame)
right_button_frame.pack(side="right", padx=10)

# Add a new frame for displaying process turnaround and waiting times
process_times_frame = tk.Frame(scrollable_frame)
process_times_frame.pack(fill="x", padx=20, pady=10)

# 在主界面启动调度计算的函数
def start_scheduling_thread():
    # 在新线程中启动计算
    threading.Thread(target=start_scheduling).start()

start_button = tk.Button(right_button_frame, text="Start Scheduling", command=lambda: start_scheduling())
start_button.pack(pady=5)

# 初始化时添加三个进程输入行
for _ in range(3):
    add_process()

# 时间片输入框，只在 Round Robin 算法下可用
tk.Label(root, text="Time Slice (for Round Robin):").pack()
time_slice_entry = tk.Entry(root)
time_slice_entry.pack()

# Canvas 显示区
canvas = tk.Canvas(root, width=800, height=150, bg="white")
canvas.pack(pady=10)

# New Frame for Metrics Display under Timeline
metrics_panel = tk.Frame(root)
metrics_panel.pack(pady=10)

# 显示分析结果的标签
metrics_frame = tk.Frame(scrollable_frame)
metrics_frame.pack(pady=10)

avg_waiting_time_label = tk.Label(metrics_panel, text="Average Waiting Time: N/A")
avg_waiting_time_label.pack()

waiting_time_std_dev_label = tk.Label(metrics_panel, text="Waiting Time Standard Deviation: N/A")
waiting_time_std_dev_label.pack()

cpu_utilization_label = tk.Label(metrics_panel, text="CPU Utilization: N/A")
cpu_utilization_label.pack()

context_switch_label = tk.Label(metrics_panel, text="Context Switch Count: N/A")
context_switch_label.pack()

avg_response_time_label = tk.Label(metrics_panel, text="Average Response Time: N/A")
avg_response_time_label.pack()

avg_turnaround_time_label = tk.Label(metrics_panel, text="Average Turnaround Time: N/A")
avg_turnaround_time_label.pack()

throughput_label = tk.Label(metrics_panel, text="Throughput: N/A")
throughput_label.pack()


def calculate_average_response_time(processes):
    total_response_time = sum(p.waiting_time for p in processes)
    return total_response_time / len(processes) if processes else 0

def calculate_average_turnaround_time(processes):
    total_turnaround_time = sum(p.turnaround_time for p in processes)
    return total_turnaround_time / len(processes) if processes else 0

def calculate_throughput(processes, total_time):
    return len(processes) / total_time if total_time > 0 else 0


# Define Export to Excel function
def export_to_excel(results, processes):
    if not results or not processes:
        messagebox.showwarning("Warning", "No valid scheduling results to export.")
        return

    # 将调度结果按 PID 分组，提取所需信息
    summary_data = {}
    for pid, start, end, *_ in results:
        if pid not in summary_data:
            summary_data[pid] = {
                "PID": pid,
                "Start Time": start,
                "End Time": end,
                "Waiting Time": None,  # 后续填充
                "Turnaround Time": None  # 后续填充
            }
        else:
            summary_data[pid]["End Time"] = end

    # 计算每个进程的 Waiting Time 和 Turnaround Time
    for process in processes:
        pid = process.pid
        summary_data[pid]["Waiting Time"] = process.waiting_time
        summary_data[pid]["Turnaround Time"] = process.turnaround_time

    # 转换为列表以便导出到 Excel
    excel_data = list(summary_data.values())

    # 将调度结果转换为 DataFrame
    df = pd.DataFrame(excel_data)

    # 打开保存对话框，让用户选择保存路径
    file_path = filedialog.asksaveasfilename(defaultextension=".xlsx", filetypes=[("Excel files", "*.xlsx")])
    if not file_path:
        return

    # 保存 DataFrame 为 Excel 文件
    writer = pd.ExcelWriter(file_path, engine='xlsxwriter')
    df.to_excel(writer, index=False, sheet_name='Scheduling Results')

    workbook = writer.book
    worksheet = writer.sheets['Scheduling Results']

    # 保存时间线图表为图像文件
    timeline_image_path = "timeline_chart.png"
    save_timeline_chart_as_image(timeline_image_path)

    # 将图像插入到 Excel 文件
    worksheet.insert_image('H2', timeline_image_path)

    # 使用 close() 而不是 save() 来保存文件
    writer.close()
    messagebox.showinfo("Export Success", f"Results successfully saved to {file_path}")

def save_timeline_chart_as_image(image_path):
    # 在时间线图表中显示的代码基础上，添加保存为图像的逻辑
    plt.figure(figsize=(10, 3))
    x_offset = 10
    y_offset = 50

    max_time = max([end for _, _, end in scheduling_results])
    for t in range(0, max_time + 1):
        x = x_offset + t * 20
        plt.plot([x, x], [y_offset + 30, y_offset + 60], color="black")
        plt.text(x, y_offset + 70, str(t), ha="center", fontsize=8)

    # 绘制进程块
    color_map = ["#4CAF50", "#FF9800", "#2196F3", "#FF5722", "#9C27B0", "#795548"]
    for i, (pid, start, end) in enumerate(scheduling_results):
        x_start = x_offset + start * 20
        x_end = x_offset + end * 20
        color = color_map[pid % len(color_map)]
        plt.fill_between([x_start, x_end], y_offset, y_offset + 20, color=color, label=f"P{pid}")
        plt.text((x_start + x_end) / 2, y_offset + 10, f"P{pid}", ha="center", color="white")

    plt.axis('off')
    plt.savefig(image_path, bbox_inches='tight')
    plt.close()



# 开始调度并计算分析结果
def start_scheduling():
    global scheduling_results, processes  # Ensure these variables are accessible globally

    processes = []  # 重置 processes 列表
    total_time = 0
    context_switch_count = 0

    # 遍历所有进程输入行，获取输入并验证有效性
    for i in range(len(arrival_entries)):
        try:
            arrival_time_str = arrival_entries[i].get()
            burst_time_str = burst_entries[i].get()
            priority_str = priority_entries[i].get()
            if not arrival_time_str or not burst_time_str or not priority_str:
                continue

            arrival_time = int(arrival_time_str)
            burst_time = int(burst_time_str)
            priority = int(priority_str)
            process_type = type_choices[i].get()

            processes.append(Process(i + 1, arrival_time, burst_time, priority, process_type))

        except ValueError:
            messagebox.showerror("Input Error", f"Please enter valid numbers for Process {i + 1}.")
            return
        except Exception as e:
            messagebox.showerror("Error", f"An error occurred: {str(e)}")
            return

    if not processes:
        messagebox.showwarning("Warning", "No valid processes to schedule.")
        return

    # 调度算法选择
    try:
        if algorithm_choice.get() == "Round Robin":
            try:
                time_slice = int(time_slice_entry.get())
            except ValueError:
                messagebox.showerror("Input Error", "Please enter a valid time slice for Round Robin.")
                return
            result, context_switch_count = round_robin(processes, time_slice)

        elif algorithm_choice.get() == "Shortest Job First":
            result, context_switch_count = preemptive_shortest_job_first(processes)

        elif algorithm_choice.get() == "Priority Scheduling":
            result, context_switch_count = priority_scheduling(processes)

        else:
            messagebox.showerror("Input Error", "Please select a scheduling algorithm.")
            return

    except Exception as e:
        messagebox.showerror("Error", f"An error occurred while scheduling: {str(e)}")
        return

    # 在 Canvas 上显示调度结果
    try:
        display_schedule(result)
    except Exception as e:
        messagebox.showerror("Error", f"An error occurred while displaying the schedule: {str(e)}")
        return

    # 将调度结果存储为全局变量，以便导出
    scheduling_results = result

    # 计算并显示调度指标
    try:
        total_execution_time = sum([p.burst_time for p in processes])
        total_time = max([end for _, _, end in result])
        avg_waiting_time, waiting_time_std_dev = calculate_fairness_metrics(processes)
        cpu_utilization = calculate_cpu_utilization(total_execution_time, total_time)
        avg_response_time = calculate_average_response_time(processes)
        avg_turnaround_time = calculate_average_turnaround_time(processes)
        throughput = calculate_throughput(processes, total_time)

        for widget in metrics_panel.winfo_children():
            widget.destroy()

        tk.Label(metrics_panel, text=f"Average Waiting Time: {avg_waiting_time:.2f}").pack()
        tk.Label(metrics_panel, text=f"Waiting Time Standard Deviation: {waiting_time_std_dev:.2f}").pack()
        tk.Label(metrics_panel, text=f"CPU Utilization: {cpu_utilization:.2f}%").pack()
        tk.Label(metrics_panel, text=f"Context Switch Count: {context_switch_count}").pack()
        tk.Label(metrics_panel, text=f"Average Response Time: {avg_response_time:.2f}").pack()
        tk.Label(metrics_panel, text=f"Average Turnaround Time: {avg_turnaround_time:.2f}").pack()
        tk.Label(metrics_panel, text=f"Throughput: {throughput:.2f} processes/unit time").pack()

        for i, p in enumerate(processes):
            process_info = f"Process {p.pid}: Turnaround Time = {p.turnaround_time}, Waiting Time = {p.waiting_time}"
            tk.Label(metrics_panel, text=process_info, anchor="w").pack(anchor="w")

    except Exception as e:
        messagebox.showerror("Error", f"An error occurred while calculating metrics: {str(e)}")

# Add Export Button
export_button = tk.Button(root, text="Export to Excel", command=lambda: export_to_excel(scheduling_results, processes))
export_button.pack(pady=10)

# Ensure scheduling_results and processes are available
scheduling_results = None
processes = []


# 启动主循环
root.mainloop()


