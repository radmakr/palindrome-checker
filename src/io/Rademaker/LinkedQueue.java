package io.Rademaker;

/**
 * Implements the QueueInterface<T> ADT using a linked list of nodes
 * 
 * @author Thomas Rademaker
 * @version 4/15/2012
 */
public class LinkedQueue<T> implements QueueInterface<T> 
{
	private Node firstNode;
	private Node lastNode;
	
	/**
	 * Creates an empty queue
	 */
	public LinkedQueue()
	{
		firstNode = null;
		lastNode = null;
	}
	
	/**
	 * Adds a new entry to the back of this queue.
	 * @param newEntry  an object to be added
	 */
	public void enqueue(T newEntry)
	{
		Node newNode = new Node(newEntry, null);
		
		if(isEmpty())
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		
		lastNode = newNode;
	}
	
	/**
	 * Removes and returns the entry at the front of this queue.
	 * @return either the object at the front of the queue or, if the
	 * queue is empty before the operation, null
	 */
	public T dequeue()
	{
		T front = null;
		
		if(!isEmpty()) {
			front = firstNode.getData();
			firstNode = firstNode.getNextNode();
			
			if(firstNode == null)
				lastNode = null;
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
			return firstNode.getData();
		
		return null;
	}
	
	/**
	 * Detects whether this queue is empty.
	 * @return true if the queue is empty, or false otherwise
	 */
	public boolean isEmpty()
	{
		return (firstNode == null) && (lastNode == null);
	}
	
	/**
	 * Removes all entries from this queue.
	 */
	public void clear()
	{
		firstNode = null;
		lastNode = null;
	}
	
	/**
	 * Class for nodes
	 *
	 */
	private class Node
	{
		private T data;
		private Node next;
		
		/**
		 * Creates a node that points to null
		 * @param dataPortion to be added to the new node
		 */
		private Node(T dataPortion)
		{
			this(dataPortion, null);
		}
		
		/**
		 * creates a new node
		 * @param data to be added to the new node
		 * @param nextNode. The node that this node will be linked to
		 */
		private Node(T data, Node nextNode)
		{
			this.data = data;
			next = nextNode;
		}
		
		/**
		 * Returns the data in the node
		 * @return T. The object being returned
		 */
		private T getData()
		{
			return data;
		}
		
		/**
		 * Sets the data in the node
		 * @param newData. The new object being set in the node
		 */
//		private void setData(T newData)
//		{
//			data = newData;
//		}
//		
		/**
		 * Returns the next node in the link
		 * @return Node. The next node in the link being returned
		 */
		private Node getNextNode()
		{
			return next;
		}
		
		/**
		 * Sets the next node in the link
		 * @param node the node to be set as the next node in the link
		 */
		private void setNextNode(Node node)
		{
			next = node;
		}
	}	
}