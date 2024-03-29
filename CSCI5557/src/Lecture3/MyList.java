package Lecture3;

import java.util.Collection;

public interface MyList<E> extends Collection<E>{

	  /** Add a new element at the specified index in this list */
	  public void add(int index, E e);

	  /** Return the element from this list at the specified index */
	  public E get(int index);

	  /** Return the index of the first matching element in this list.
	   *  Return -1 if no match. */
	  public int indexOf(Object e);

	  /** Return the index of the last matching element in this list
	   *  Return -1 if no match. */
	  public int lastIndexOf(E e);

	  /** Remove the element at the specified position in this list
	   *  Shift any subsequent elements to the left.
	   *  Return the element that was removed from the list. */
	  public E remove(int index);

	  /** Replace the element at the specified position in this list
	   *  with the specified element and returns the new set. */
	  public E set(int index, E e);
	  
	  @Override /** Add a new element at the end of this list */
	  public default boolean add(E e) {
	    add(size(), e);
	    return true;
	  }
	
	
	
}
