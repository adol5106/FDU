package Lecture6;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		
		Queue<String> queueOne = new LinkedList<>();
		
		
		queueOne.offer("Red");
		queueOne.offer("Green");
		queueOne.offer("Blue");
		queueOne.offer("White");
		
		System.out.println(queueOne.poll());
		System.out.println(queueOne.poll());
		System.out.println(queueOne.peek());
		System.out.println(queueOne.poll());
		System.out.println(queueOne.poll());

		
		MyQueue<String> queueTwo = new MyQueue<>();
		queueTwo.enqueue("Red");
		queueTwo.enqueue("Green");
		queueTwo.enqueue("Blue");
		queueTwo.enqueue("White");
		
		System.out.println(queueTwo.contains("Blueeeee"));
		
		System.out.println(queueTwo.dequeue().toUpperCase());
		System.out.println(queueTwo.dequeue());
		System.out.println(queueTwo.dequeue());
		System.out.println(queueTwo.dequeue());
	
		
		PriorityQueue<Integer> myPriorityQueue2 = new PriorityQueue<>(Comparator.reverseOrder());
		
		myPriorityQueue2.offer(23);
		myPriorityQueue2.offer(45);
		myPriorityQueue2.offer(11);
		myPriorityQueue2.offer(99);
		
		System.out.println(myPriorityQueue2.poll());
		System.out.println(myPriorityQueue2.poll());
		System.out.println(myPriorityQueue2.poll());
		System.out.println(myPriorityQueue2.poll());
		
		PriorityQueue<String> myPriorityQueue3 = new PriorityQueue<>(new CustomComparator());
		
		myPriorityQueue3.offer("Pete");
		myPriorityQueue3.offer("Cathy");
		myPriorityQueue3.offer("Hellen");
		myPriorityQueue3.offer("Kim");
		
		System.out.println(myPriorityQueue3.poll());
		System.out.println(myPriorityQueue3.poll());
		System.out.println(myPriorityQueue3.poll());
		System.out.println(myPriorityQueue3.poll());
		
		
		
		Employee employee1 = new Employee("Peter",23345.78);
		Employee employee2 = new Employee("Jane",13345.78);
		Employee employee3 = new Employee("Cathy",43345.78);
		Employee employee4 = new Employee("Hellen",53345.78);
		
		PriorityQueue<Employee> myPriorityQueue4=new PriorityQueue<>();
		
		myPriorityQueue4.offer(employee1);
		myPriorityQueue4.offer(employee2);
		myPriorityQueue4.offer(employee3);
		myPriorityQueue4.offer(employee4);
		
		System.out.println(myPriorityQueue4.poll().getName());
		System.out.println(myPriorityQueue4.poll().getSalary());
		System.out.println(myPriorityQueue4.poll().getName());
		System.out.println(myPriorityQueue4.poll().getSalary());
		
		MyPriorityQueue<String> myPriorityQueue5 = new MyPriorityQueue<>();
		myPriorityQueue5.enqueue("Pete");
		myPriorityQueue5.enqueue("Cathy");
		myPriorityQueue5.enqueue("Hellen");
		myPriorityQueue5.enqueue("Kim");
		myPriorityQueue5.enqueue("Jane");
		
		System.out.println(myPriorityQueue5.dequeue());
		System.out.println(myPriorityQueue5.dequeue());
		System.out.println(myPriorityQueue5.dequeue());
		System.out.println(myPriorityQueue5.dequeue());
		System.out.println(myPriorityQueue5.dequeue());
		
	}

}
