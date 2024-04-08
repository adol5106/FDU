package Assignment3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import Lecture6.MyPriorityQueue;


//Name: Qingyun Zhang   ID:2095754

public class ListDriver {

	public static void main(String[] args) {
		//Question 1
	    String[] months = {"January", "Februray","March", "April","May", "June","July","August","September","October","November","December"
	    };
	    
	    System.out.println("All months in an array of strings:");
	    for(String month:months) {
	    	System.out.print(month+" ");
	    }
        System.out.println();
	    
	    //Question 2
	    ArrayList<String> monthList = new ArrayList<String>(); 
	    
	    while (monthList.size()<6) {
	      int month = (int)(Math.random()*6);
	      if (!monthList.contains(months[month]))
	         monthList.add(months[month]);
	    }
	    System.out.println("Random months listed in an Array list:");
	    System.out.println(monthList);

	    
	    //Question 3
		Stack<String> monthStack = new Stack<>();
		
		while(monthStack.size()<6) {
			int index = (int)(Math.random()*6);
			if(!monthStack.contains(monthList.get(index)))
				monthStack.push(monthList.get(index));
			
		}
		System.out.println("Random months listed in a stack:");
		System.out.println(monthStack);
		
		//Question 4
		Queue<Integer> queueMonth = new LinkedList<>();

		while(queueMonth.size()<6) {
			int monthIndex = 1+(int)(Math.random()*6);
			if(!queueMonth.contains(monthIndex))
				queueMonth.offer(monthIndex);
			
		}
		System.out.println("Random months number listed in a queue:");
		System.out.println(queueMonth);
		
		//Question 5
		Heap<String> heapMonth = new Heap<String>();
		while(heapMonth.getSize()<6) {
			int index = (int)(Math.random()*6);
			if(!heapMonth.contains(monthStack.get(index)))
				heapMonth.add(monthStack.get(index));

		}
		System.out.println("Random months listed in a heap:");
		heapMonth.printHeap();
		System.out.println();
		
		
		//Question 6
		PriorityQueue<String> monthPriorityQueue = new PriorityQueue<>();
		while(monthPriorityQueue.size()<6) {
			int mIndex = (int)(Math.random()*6);
			if(!monthPriorityQueue.contains(heapMonth.fetch(mIndex)))
				monthPriorityQueue.offer(heapMonth.fetch(mIndex));
		}
		System.out.println("Random months listed in a priority queue:");
		System.out.println(monthPriorityQueue);
		
		
		
		
		
		
		
	

	}}
