package io.Rademaker;

/**
 * Extends the DequePalindromeChecker class. Has a constructor that sets DequePalindromeChecker's protected fields to the 
 * appropriate linked nodes based implementations
 * 
 * @author Thomas Rademaker
 * @version 4/15/2012
 *
 */
public class LinkedDequePalindromeChecker extends DequePalindromeChecker
{
	/**
	 * Constructor for LinkedDequePalindromeChecker.
	 * Sets DequePalindromeChecker's protected field deque to be a LinkedDeque<String>.
	 */
	public LinkedDequePalindromeChecker()
	{
		deque = new LinkedDeque<String>();
	}

}
