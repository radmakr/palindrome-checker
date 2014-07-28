package io.Rademaker;

/**
 * Implementation of the DequeInterface<T> interface using linked nodes
 * 
 * @author Thomas Rademaker
 * @version 4/15/2012
 * @param <T>
 */
public class LinkedDeque<T> implements DequeInterface<T>
{
	private DLNode firstNode;
	private DLNode lastNode;
	
	/**
	 * Constructs and empty deque
	 */
	public LinkedDeque()
	{
		firstNode = null;
		lastNode = null;
	}
	
	/**
	 * Adds a new entry to the front of this deque.
	 * @param newEntry  an object to be added
	 */
	public void addToFront(T newEntry)
	{
		DLNode newNode = new DLNode(null, newEntry, firstNode);
		
		if(isEmpty())
			lastNode = newNode;
		else
			firstNode.setPreviousNode(newNode);
		
		firstNode = newNode;
	}
	
	/**
	 * Adds a new entry to the back of this deque.
	 * @param newEntry  an object to be added
	 */
	public void addToBack(T newEntry)
	{
		DLNode newNode = new DLNode(lastNode, newEntry, null);
		
		if(isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		
		lastNode = newNode;
	}
	
	/**
	 * Removes and returns the entry at the front of this deque.
	 * @return either the object at the front of the deque or, if the
	 * deque is empty before the operation, null
	 */
	public T removeFront()
	{
		T front = null;
		
		if(!isEmpty()) {
			front = firstNode.getData();
			firstNode = firstNode.getNextNode();
			
			if(firstNode == null)
				lastNode = null;
			else
				firstNode.setPreviousNode(null);
		}
		
		return front;
	}
	
	/**
	 * Removes and returns the entry at the back of this deque.
	 * @return either the object at the back of the deque or, if the
	 * deque is empty before the operation, null
	 */
	public T removeBack()
	{
		T back = null;
		
		if(!isEmpty()) {
			back = lastNode.getData();
			lastNode = lastNode.getPreviousNode();
			
			if(lastNode == null)
				firstNode = null;
			else
				lastNode.setNextNode(null);
		}
		
		return back;
	}
	
	/**
	 * Retrieves the entry at the front of this deque.
	 * @return either the object at the front of the deque or, if the
	 * deque is empty, null
	 */
	public T getFront()
	{
		if(!isEmpty())
			return firstNode.getData();
		
		return null;
	}
	
	/**
	 * Retrieves the entry at the back of this deque.
	 * @return either the object at the back of the deque or, if the
	 * deque is empty, null
	 */
	public T getBack()
	{
		if(!isEmpty())
			return lastNode.getData();
		
		return null;
	}
	
	/**
	 * Detects whether this deque is empty.
	 * @return true if the deque is empty, or false otherwise
	 */
	public boolean isEmpty()
	{
		return (firstNode == null) && (lastNode == null);
	}
	
	/**
	 * Removes all entries from this deque.
	 */
	public void clear()
	{
		while(!isEmpty())
			removeFront();
	}
	
	/**
	 * Class of Doubly linked nodes
	 */
	private class DLNode
	{
		private T data;
		private DLNode next;
		private DLNode previous;
		
		/**
		 * Creates a node with no previous or next node
		 * @param dataPortion to be added to the node.
		 */
		private DLNode(T dataPortion)
		{
			this(null, dataPortion, null);
		}
		
		/**
		 * Creates a new node.
		 * @param previousNode is the previous node to link to
		 * @param data is the object to be added to the node
		 * @param nextNode is the next node to be linked to
		 */
		private DLNode(DLNode previousNode, T data, DLNode nextNode)
		{
			this.data = data;
			next = nextNode;
			previous = previousNode;
		}
		
		/**
		 * Returns the data in the node
		 * @return T. The object in the node
		 */
		private T getData()
		{
			return data;
		}
		
		/**
		 * Sets the data in the node
		 * @param newData is the new data to set in the node
		 */
//		private void setData(T newData)
//		{
//			data = newData;
//		}
		
		/**
		 * Returns the next node in the link
		 * @return DLNode. The next node
		 */
		private DLNode getNextNode()
		{
			return next;
		}
		
		/**
		 * Returns the previous node in the link
		 * @return DLNode. The previous node.
		 */
		private DLNode getPreviousNode()
		{
			return previous;
		}
		
		/**
		 * Sets the next node in the link
		 * @param node. The node to set as the next node.
		 */
		private void setNextNode(DLNode node)
		{
			next = node;
		}
		
		/**
		 * Sets the previous node in the link
		 * @param node. The node to set as the previous node.
		 */
		 private void setPreviousNode(DLNode node)
		 {
			 previous = node;
		 }
	}
}
