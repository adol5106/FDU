package Lecture6;

public class MyQueue<E>{
	  private java.util.LinkedList<E> list 
	    = new java.util.LinkedList<E>();

	  public void enqueue(E e) {
	    list.addLast(e);
	  }

	  public E dequeue() {
	    return list.removeFirst();
	  }

	  public int getSize() {
	    return list.size();
	  }

	  public boolean contains(E e) {
		  return list.contains(e);
		  
	  }
	  
	  
	  @Override
	  public String toString() {
	    return "Queue: " + list.toString();
	  }
	  
	  
	  
	}
