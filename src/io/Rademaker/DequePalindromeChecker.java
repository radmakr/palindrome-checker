package io.Rademaker;

/**
 * Implements the PalindromeChecker interface using a deque to test whether the given String is a palindrome or not
 * 
 * @author Thomas Rademaker
 * @version 4/15/2012
 *
 */
public abstract class DequePalindromeChecker implements PalindromeChecker
{
	protected DequeInterface<String> deque;
	
	/**
	 * Tests if a given string is a palidrome.
	 * @param String to be checked
	 * @return boolen. true if str is a palidrome and false otherwise.
	 */
	public boolean isPalindrome(String str)
	{
		fillDeque(str);
		boolean palindrome = true;
		int count = countLetters(str);
		String frontString, backString;
		
		if(count % 2 == 0){
					
			while((!deque.isEmpty()) && (palindrome)) {
				frontString = deque.removeFront();
				backString = deque.removeBack();
				
				if(!frontString.equalsIgnoreCase(backString)) {
					palindrome = false;
				}
			}
		}
		else {
			int index = 0;
			
			while((index < ((count - 1)/2)) && (palindrome)){
				frontString = deque.removeFront();
				backString = deque.removeBack();
				
				if(!frontString.equalsIgnoreCase(backString)) {
					palindrome = false;
				}
				
				index++;
			}
		}		
		
		return palindrome;
	}
	
	/**
	 * Fills the deque field with the current string given.
	 * Clears any previous objects first.
	 * @param String str. The string to fill the deque.
	 */
	private void fillDeque(String str)
	{
		clear();
		
		for(int i = 0; i < str.length(); i++){
			
			if(Character.isLetter(str.charAt(i))){
				deque.addToBack(Character.toString(str.charAt(i)));			
			}
		}
	}
	
	/**
	 * Clears the deque of all objects.
	 */
	private void clear()
	{
		deque.clear();
	}
	
	/**
	 * Counts the letters in the given string.
	 * Not all strings contain only letters so this counts just the letters in the string.
	 * @param String str. The string to be tested.
	 * @return an interger of the number of letters in the given string.
	 */
	private int countLetters(String str)
	{
		int counter = 0;
		
		for(int i = 0; i < str.length(); i++){
			
			if(Character.isLetter(str.charAt(i))){
				counter++;
			}
		}
		
		return counter;
	}

}

