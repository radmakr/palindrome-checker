package io.Rademaker;

import java.util.Arrays;

/**
 * Implementation of the StackInterface<T> ADT using an array.
 * 
 * @author Thomas Rademaker
 * @version 4/15/2012
 */
public class ArrayStack<T> implements StackInterface<T> 
{
	private T[] stack;
	private int topIndex;
	private static final int DEFAULT_INITIAL_CAPACITY = 50;
	
	/**
	 * Creates an ArrayStack using the DEFAULT_INITIAL_CAPACITY field
	 */
	public ArrayStack()
	{
		this(DEFAULT_INITIAL_CAPACITY);		
	}
	
	/**
	 * Creates a stack using an array
	 * @param int initialCapcity. The initial capacity of the stack
	 */
	public ArrayStack(int initialCapacity)
	{
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[initialCapacity];
		stack = tempStack;
		topIndex = -1;
	}
	
	/**
	 * Adds a new entry to the top of this stack.
	 * @param newEntry  an object to be added to the stack
	 */
	public void push(T newEntry)
	{
		ensureCapacity();
		topIndex++;
		stack[topIndex] = newEntry;
	}
	
	/**
	 * Doubles the size of the array if the array is full.
	 */
	private void ensureCapacity()
	{
		if(topIndex == stack.length - 1)
			stack = Arrays.copyOf(stack, 2 * stack.length);
	}
	
	/**
	 * Removes and returns this stack's top entry.
	 * @return either the object at the top of the stack or, if the
	 * stack is empty before the operation, null
	 */
	public T pop()
	{
		T top = null;
		
		if(!isEmpty()) {
			top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
		}
		
		return top;
	}
	
	/**
	 * Retrieves this stacks top entry.
	 * @return either the object at the top of the stack or null if
	 * the stack is empty
	 */
	public T peek()
	{
		if(!isEmpty())
			return stack[topIndex];
		
		return null;
	}
	
	/**
	 * Detects whether this stack is empty.
	 * @return true if the stack is empty
	 */
	public boolean isEmpty()
	{
		return topIndex < 0;
	}
	
	/**
	 * Removes all entries from this stack
	 */
	public void clear()
	{
		while(!isEmpty())
			pop();
	}
	

}
