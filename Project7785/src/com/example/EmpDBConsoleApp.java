package com.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

/**
 * EmpDBConsoleApp - rewritten as an RMI Client
 */
public class EmpDBConsoleApp {

    static Scanner scanner = new Scanner(System.in);
    static EmpRemote empRemote;

    static final String RESET = "\u001B[0m";
    static final String GREEN = "\u001B[32m";
    static final String RED = "\u001B[31m";

    public static void main(String[] args) {
        try {
            // Connect to RMI Registry to locate the remote object
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            empRemote = (EmpRemote) registry.lookup("EmpService");

            String choice = "";
            while (!choice.equals("6")) {
                System.out.println("""
                        \nEmployee Database System (RMI Client)
                        =================================================
                        1. Show All Employees
                        2. Find an employee by ID
                        3. Add a new employee
                        4. Delete an employee
                        5. Update an employee
                        6. Exit
                        =================================================
                        Enter your choice: """);
                choice = scanner.nextLine();

                switch (choice) {
                    case "1" -> showAllEmployees();
                    case "2" -> findEmployeeByNo();
                    case "3" -> addNewEmployee();
                    case "4" -> deleteEmployee();
                    case "5" -> updateEmployee();
                    case "6" -> System.exit(0);
                    default -> System.out.println(RED + "Enter a valid choice between 1 and 6" + RESET);
                }
            }
        } catch (Exception e) {
            System.out.println(RED + "Client exception: " + e.getMessage() + RESET);
            e.printStackTrace();
        }
    }

    public static void showAllEmployees() {
        try {
            List<EMP> employees = empRemote.getAllEmployees();
            employees.forEach(emp -> System.out.println(GREEN + emp + RESET));
        } catch (Exception e) {
            System.out.println(RED + "Error retrieving employees." + RESET);
            e.printStackTrace();
        }
    }

    public static void findEmployeeByNo() {
        try {
            System.out.println("Enter employee No. to find:");
            String eno = scanner.nextLine();
            EMP emp = empRemote.findEmployeeById(eno);

            if (emp != null) {
                System.out.println(GREEN + emp + RESET);
            } else {
                System.out.println(RED + "No employee found with No.: " + eno + RESET);
            }
        } catch (Exception e) {
            System.out.println(RED + "Error finding employee." + RESET);
            e.printStackTrace();
        }
    }

    public static void addNewEmployee() {
        try {
            System.out.println("Enter new employee No.:");
            String eno = scanner.nextLine();
            System.out.println("Enter new employee name:");
            String ename = scanner.nextLine();
            System.out.println("Enter new employee title:");
            String title = scanner.nextLine();

            int result = empRemote.addNewEmployee(eno, ename, title);
            if (result == 1) {
                System.out.println(GREEN + "Employee added successfully." + RESET);
            } else {
                System.out.println(RED + "Failed to add employee." + RESET);
            }
        } catch (Exception e) {
            System.out.println(RED + "Error adding new employee." + RESET);
            e.printStackTrace();
        }
    }

    public static void deleteEmployee() {
        try {
            System.out.println("Enter employee No. to delete:");
            String eno = scanner.nextLine();
            int result = empRemote.deleteEmployee(eno);
            if (result == 1) {
                System.out.println(GREEN + "Employee deleted successfully." + RESET);
            } else {
                System.out.println(RED + "No employee found with No.: " + eno + RESET);
            }
        } catch (Exception e) {
            System.out.println(RED + "Error deleting employee." + RESET);
            e.printStackTrace();
        }
    }

    public static void updateEmployee() {
        try {
            System.out.println("Enter employee No. to update:");
            String eno = scanner.nextLine();
            System.out.println("Enter new employee name:");
            String ename = scanner.nextLine();
            System.out.println("Enter new employee title:");
            String title = scanner.nextLine();

            int result = empRemote.updateEmployee(eno, ename, title);
            if (result == 1) {
                System.out.println(GREEN + "Employee updated successfully." + RESET);
            } else {
                System.out.println(RED + "Failed to update employee." + RESET);
            }
        } catch (Exception e) {
            System.out.println(RED + "Error updating employee." + RESET);
            e.printStackTrace();
        }
    }
}
