package io.Rademaker;

/**
 * Implementation of the StackInterface<T> ADT using a linked list of nodes
 * 
 * @author Thomas Rademaker
 * @version 4/15/2012
 * @param <T>
 */
public class LinkedStack<T> implements StackInterface<T> 
{
	private Node topNode;
	
	/**
	 * Creates an empty stack
	 */
	public LinkedStack()
	{
		topNode = null;
	}
	
	/**
	 * Adds a new entry to the top of this stack.
	 * @param newEntry  an object to be added to the stack
	 */
	public void push(T newEntry)
	{
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	}
	
	/**
	 * Removes and returns this stack's top entry.
	 * @return either the object at the top of the stack or, if the
	 * stack is empty before the operation, null
	 */
	public T pop()
	{
		T top = peek();
		
		if(topNode != null)
			topNode = topNode.getNextNode();
		
		return top;
	}
	
	/**
	 * Retrieves this stacks top entry.
	 * @return either the object at the top of the stack or null if
	 * the stack is empty
	 */
	public T peek()
	{
		if(topNode != null)
			return topNode.getData();
		
		return null;
	}
	
	/**
	 * Detects whether this stack is empty.
	 * @return true if the stack is empty
	 */
	public boolean isEmpty()
	{
		return topNode == null;
	}
	
	/**
	 * Removes all entries from this stack
	 */
	public void clear()
	{
		topNode = null;
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
//		private void setNextNode(Node node)
//		{
//			next = node;
//		}
	}

}
