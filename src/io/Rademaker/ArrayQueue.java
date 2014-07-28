package io.Rademaker;

/**
 * Implements the QueueInterface<T> ADT using an array
 * 
 * @author Thomas Rademaker
 * @version 4/15/2012
 * @param <T>
 */
public class ArrayQueue<T> implements QueueInterface<T>
{
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private static final int DEFAULT_INITIAL_CAPACITY = 50;
	
	/**
	 * Constructs the ArrayQueue using the DEFAULT_INITIAL_CAPACITY field
	 */
	public ArrayQueue()
	{
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	/**
	 * Constructs a queue using an array
	 * @param int initialCapacity. The queue's initial size
	 */
	public ArrayQueue(int initialCapacity)
	{
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[initialCapacity + 1];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;
	}
	
	/**
	 * Adds a new entry to the back of this queue.
	 * @param newEntry  an object to be added
	 */
	public void enqueue(T newEntry)
	{
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = newEntry;
	}
	
	/**
	 * Doubles the size of the array queue if it is full
	 */
	private void ensureCapacity()
	{
		if(frontIndex == ((backIndex + 2) % queue.length)) {
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[2 * oldSize];
			queue = tempQueue;
			
			for(int i = 0; i < oldSize - 1; i++) {
				queue[i] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
			}
			
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
	}
	
	/**
	 * Removes and returns the entry at the front of this queue.
	 * @return either the object at the front of the queue or, if the
	 * queue is empty before the operation, null
	 */
	public T dequeue()
	{
		T front = null;
		
		if(!isEmpty()){
			front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
		}
		
		return front;
	}
	
	/**
	 * Retrieves the entry at the front of this queue.
	 * @return either the object at the front of the queue or, if the
	 * queue is empty, null
	 */
	public T getFront()
	{
		if(!isEmpty())
			return queue[frontIndex];
		
		return null;
	}
	
	/**
	 * Detects whether this queue is empty.
	 * @return true if the queue is empty, or false otherwise
	 */
	public boolean isEmpty()
	{
		return frontIndex == ((backIndex + 1) % queue.length);
	}
	
	/**
	 * Removes all entries from this queue.
	 */
	public void clear()
	{
		while(!isEmpty())
			dequeue();
	}

}