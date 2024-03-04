package Lecture5;

import java.util.ArrayList;

public class GenericStack<E> {
	  private ArrayList<E> list = new ArrayList<>();  //data member

	  public GenericStack() {
		  //super();
		  
	  }
	  
	  public GenericStack(ArrayList<E> list) {
		  super();
		  this.list=list;
		  
	  }
	  
	  
	  
	  public int getSize() {
	    return list.size();
	  }

	  public E peek() {
	    return list.get(getSize() - 1);
	  }

	  public void push(E o) {
	    list.add(o);
	  }

	  public E pop() {
	    E o = list.get(getSize() - 1);
	    list.remove(getSize() - 1);
	    return o;
	  }

	  public boolean isEmpty() {
	    return list.isEmpty();
	  }
	  
	  //public int search(E o) {
		  //int count=0;
		 //for (E i:list) {
			  //if (o==i)
				  //return list.size()-count;
						 
		      //count++;
		  
	  //}
		  //return -1;
//}
	  
	  public boolean search(E o) {
		  return list.contains(o);
		  
	  }
	  
	  
	  
	  @Override
	  public String toString() {
	    return "stack: " + list.toString();
	  }
}
