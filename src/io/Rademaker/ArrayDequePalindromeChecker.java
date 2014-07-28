package io.Rademaker;

/**
 * Extends the DequePalindromeChecker class. Has a constructor that sets DequePalindromeChecker's protected fields to the 
 * appropriate array based implementations.
 *  
 * @author Thomas Rademaker
 * @version 4/15/2012
 *
 */
public class ArrayDequePalindromeChecker extends DequePalindromeChecker
{
	/**
	 * Constructor for ArrayDequePalindromeChecker.
	 * Sets DequePalindromeChecker's protected field deque to be an ArrayDeque<String>.
	 */
	public ArrayDequePalindromeChecker()
	{
		deque = new ArrayDeque<String>();
	}

}
