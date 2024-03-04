package Assignment2;

import java.util.Collection;
import java.util.Iterator;

public class MyArrayList<E> implements MyList<E>{
	
	//data members
	


	public static final int INITIAL_CAPACITY = 16;
	private E[] data = (E[])new Object[INITIAL_CAPACITY];
	private int size = 0; // Number of elements in the list


	
	
	  @Override /** Add a new element at the specified index */
	  public void add(int index, E e) {   
	    // Ensure the index is in the right range
	    if (index < 0 || index > size)
	      throw new IndexOutOfBoundsException
	        ("Index: " + index + ", Size: " + size);
	    
	    ensureCapacity();

	    // Move the elements to the right after the specified index
	    for (int i = size - 1; i >= index; i--)
	      data[i + 1] = data[i];

	    // Insert new element to data[index]
	    data[index] = e;

	    // Increase size by 1
	    size++;
	  } // See https://liveexample.pearsoncmg.com/dsanimation/Figure24_4.html

	  /** Create a new larger array, double the current size + 1 */
	  private void ensureCapacity() {
	    if (size >= data.length) {
	      E[] newData = (E[])(new Object[size * 2 + 1]);
	      System.arraycopy(data, 0, newData, 0, size);
	      data = newData;
	    }
	  }
	
	  @Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}


  
	

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}


	@Override /** Return the element at the specified index */
	  public E get(int index) {
	    checkIndex(index);
	    return data[index];
	  }
	
	  private void checkIndex(int index) {
		    if (index < 0 || index >= size)
		      throw new IndexOutOfBoundsException
		        ("Index: " + index + ", Size: " + size);
		  }
		  

	@Override
	public int indexOf(Object e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}


	  @Override /** Replace the element at the specified position 
	   *  in this list with the specified element. */
	  public E set(int index, E e) {
	    checkIndex(index);
	    E old = data[index];
	    data[index] = e;
	    return old;
	  }
	
	
	  @Override
	  public String toString() {
	    StringBuilder result = new StringBuilder("[");

	    for (int i = 0; i < size; i++) {
	      result.append(data[i]);
	      if (i < size - 1) result.append(", ");
	    }

	    return result.toString() + "]";
	  }
	  @Override /** Override iterator() defined in Iterable */
	  public java.util.Iterator<E> iterator() {
	    return new ArrayListIterator();
	  }
	 
	  private class ArrayListIterator 
	      implements java.util.Iterator<E> {
	    private int current = 0; // Current index 

	    @Override
	    public boolean hasNext() {
	      return current < size;
	    }

	    @Override
	    public E next() {
	      return data[current++];
	    }

	    @Override // Remove the element returned by the last next()
	    public void remove() {
	      if (current == 0) // next() has not been called yet
	        throw new IllegalStateException(); 
	      MyArrayList.this.remove(--current);
	    }
	  }
	    
	  
}
