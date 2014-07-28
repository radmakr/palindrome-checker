package io.Rademaker;

/**
 * Extends the SQPalindromeChecker class. Has a constructor that sets SQPalindromeChecker's protected fields to the 
 * appropriate array based implementations.
 * 
 * @author Thomas Rademaker
 * @version 2/15/2012
 */
public class ArraySQPalindromeChecker extends SQPalindromeChecker
{
	/**
	 * Constructor for ArraySQPalindromeChecker.
	 * Sets SQPalindromeChecker's protected field queue to be an ArrayQueue<String>
	 * and stack to ArrayStack<String>
	 */
	public ArraySQPalindromeChecker()
	{
		queue = new ArrayQueue<String>();
		stack = new ArrayStack<String>();
	}

}