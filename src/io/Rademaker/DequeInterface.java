package io.Rademaker;

/**
 * An interface for the ADT deque
 * 
 * @author Thomas Rademaker
 * @version 4/15/2012
 */
public interface DequeInterface<T> 
{
	/**
	 * Adds a new entry to the front of this deque.
	 * @param newEntry  an object to be added
	 */
	public void addToFront(T newEntry);
	
	/**
	 * Adds a new entry to the back of this deque.
	 * @param newEntry  an object to be added
	 */
	public void addToBack(T newEntry);
	
	/**
	 * Removes and returns the entry at the front of this deque.
	 * @return either the object at the front of the deque or, if the
	 * deque is empty before the operation, null
	 */
	public T removeFront();
	
	/**
	 * Removes and returns the entry at the back of this deque.
	 * @return either the object at the back of the deque or, if the
	 * deque is empty before the operation, null
	 */
	public T removeBack();
	
	/**
	 * Retrieves the entry at the front of this deque.
	 * @return either the object at the front of the deque or, if the
	 * deque is empty, null
	 */
	public T getFront();
	
	/**
	 * Retrieves the entry at the back of this deque.
	 * @return either the object at the back of the deque or, if the
	 * deque is empty, null
	 */
	public T getBack();
	
	/**
	 * Detects whether this deque is empty.
	 * @return true if the deque is empty, or false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Removes all entries from this deque.
	 */
	public void clear();
	
} // end DequeInterface

