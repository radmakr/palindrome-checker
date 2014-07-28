package io.Rademaker;

/**
 * Implements the PalindromeChecker interface using a stack and a queue to test whether the given String is a palindrome or not
 * 
 * @author Thomas Rademaker
 * @version 4/15/2012
 *
 */
public abstract class SQPalindromeChecker implements PalindromeChecker
{
	protected StackInterface<String> stack;
	protected QueueInterface<String> queue;
	
	/**
	 * Tests if a given string is a palidrome.
	 * @param String to be checked
	 * @return boolen. true if str is a palidrome and false otherwise.
	 */
	public boolean isPalindrome(String str)
	{
		buildQueue(str);
		fillStack(str);
		int counter = countLetters(str);
		boolean palindrome = true;
		String queueString, stackString;
		
		int index = 0;
		while((index < counter) && (palindrome)){
			queueString = queue.dequeue();
			stackString = stack.pop();
			
			if(!queueString.equalsIgnoreCase(stackString)){
				palindrome = false;
			}
			
			index++;
		}
		
		return palindrome;
		
	}
	
	/**
	 * Creates a queue with the given string
	 * @param String str. The string used to create a queue
	 */
	private void buildQueue(String str)
	{
		clearQueue();
		
		for(int i = 0; i < str.length(); i++){
			
			if(Character.isLetter(str.charAt(i))){
				queue.enqueue(Character.toString(str.charAt(i)));				
			}
		}
	}
	
	/**
	 * Creates a stack with the given string
	 * @param String str. The string used to create the stack
	 */
	private void fillStack(String str)
	{
		clearStack();
		
		for(int i = 0; i < str.length(); i++){
			
			if(Character.isLetter(str.charAt(i))){
				stack.push(Character.toString(str.charAt(i)));				
			}
		}
		
	}
	
	/**
	 * Empties the entire stack
	 */
	private void clearStack()
	{
		stack.clear();
	}
	
	/**
	 * Empties the entire queue
	 */
	private void clearQueue()
	{
		queue.clear();
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
