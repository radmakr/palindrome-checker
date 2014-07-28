package io.Rademaker;

/**
 * Extends the SQPalindromeChecker class. Has a constructor that sets SQPalindromeChecker's protected fields to the 
 * appropriate linked list of nodes based implementations.
 * 
 * @author Thomas Rademaker
 * @version 4/15/2012
 *
 */
public class LinkedSQPalindromeChecker extends SQPalindromeChecker
{
	/**
	 * Constructor for LinkedSQPalindromeChecker.
	 * Sets SQPalindromeChecker's protected field queue to be a LinkedQueue<String>
	 * and stack to LinkedStack<String>
	 */
	public LinkedSQPalindromeChecker()
	{
		queue = new LinkedQueue<String>();
		stack = new LinkedStack<String>();
	}
	

}
