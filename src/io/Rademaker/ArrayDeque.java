package io.Rademaker;

/**
 * Implementation of the DequeInterface<T> interface using an Array
 * 
 * @author Thomas Rademaker
 * @version 4/20/2012
 */
public class ArrayDeque<T> implements DequeInterface<T>
{
	private T[] deque;
	private int frontIndex;
	private int backIndex;
	private static final int DEFAULT_INITIAL_CAPACITY = 50;
	
	/**
	 * ArrayDeque constructor that uses the DEFAULT_INITIAL_CAPACITY field
	 */
	public ArrayDeque()
	{
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	/**
	 * ArrayDeque constructor that creates a deque with an array.
	 * @param int initialCapacity. An integer that is used as the initial capacity for the deque.
	 */
	public ArrayDeque(int initialCapacity)
	{
		@SuppressWarnings("unchecked")
		T[] tempDeque = (T[]) new Object[initialCapacity + 1];
		deque = tempDeque;
		frontIndex = 0;
		backIndex = initialCapacity;
	}
	
	/**
	 * Adds an object to the front of the deque.
	 * @param T newEntry. The new object to be added.
	 */
	public void addToFront(T newEntry)
	{
		ensureCapacity();
		
		if(frontIndex == 0)
			frontIndex = deque.length - 1;
		else
			frontIndex = frontIndex - 1;
		
		deque[frontIndex] = newEntry;
	}
	
	/**
	 * Adds an object to the back of the deque.
	 * @param T newEntry. The new object to be added.
	 */
	public void addToBack(T newEntry)
	{
		ensureCapacity();
		backIndex = (backIndex + 1) % deque.length;
		deque[backIndex] = newEntry;
	}
	
	/**
	 * Doubles the size of the array deque if it is full
	 */
	private void ensureCapacity()
	{
		if(frontIndex == ((backIndex + 2) % deque.length)) {
			T[] oldDeque = deque;
			int oldSize = oldDeque.length;
			
			@SuppressWarnings("unchecked")
			T[] tempDeque = (T[]) new Object[2 * oldSize];
			deque = tempDeque;
			
			for(int i = 0; i < oldSize - 1; i++) {
				deque[i] = oldDeque[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
	}
	
	/**
	 * Removes an object from the front of the deque.
	 * @return T. The object that is removed.
	 */
	public T removeFront()
	{
		T front = null;
		
		if(!isEmpty()){
			front = deque[frontIndex];
			deque[frontIndex] = null;
			frontIndex = (frontIndex + 1) % deque.length;
		}
		
		return front;
	}
	
	/**
	 * Removes an object from the back of the deque.
	 * @return T. The object that is removed.
	 */
	public T removeBack()
	{
		T back = null;
		
		if(!isEmpty()) {
			back = deque[backIndex];
			deque[backIndex] = null;
			
			if(backIndex == 0)
				backIndex = deque.length - 1;
			else
				backIndex = (backIndex - 1);
		}
		
		return back;
	}
	
	/**
	 * Returns the item at the front of the deque.
	 * @return T. The item in the front.
	 */
	public T getFront()
	{
		if(!isEmpty())
			return deque[frontIndex];
		
		return null;
	}
	
	/**
	 * Returns the item at the back of the deque.
	 * @return T. The item in the back.
	 */
	public T getBack()
	{
		if(!isEmpty())
			return deque[backIndex];
		
		return null;
	}
	
	/**
	 * Checks to see if the deque is empty.
	 * @return boolean. True if the deque is empty and false otherwise. 
	 */
	public boolean isEmpty()
	{
		return frontIndex == ((backIndex + 1) % deque.length);
	}
	
	/**
	 * Removes all of the items from the deque.
	 */
	public void clear()
	{
		while(!isEmpty())
			removeBack();
	}

}
