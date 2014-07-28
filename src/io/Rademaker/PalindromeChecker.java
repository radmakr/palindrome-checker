package io.Rademaker;

/**
 * An interface for how a paindrome checker class should be.
 * It must include a method isPalindrome that takes a String parameter and returns a boolean value.
 * 
 * @author Thomas Rademaker
 * @version 4/15/2012
 *
 */
public interface PalindromeChecker
{
	/**
	 * Tests if a given string is a palidrome.
	 * @param String to be checked
	 * @return boolen. true if str is a palidrome and false otherwise.
	 */
	public boolean isPalindrome(String str);

}