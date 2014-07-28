package io.Rademaker;

import java.util.Scanner;
/**
 * A main method to run the palindrome checker.
 * This program takes user input and tests whether or not it is a palindrome.
 * 
 * @author Thomas Rademaker
 * @version 4/27/2012
 *
 */
public class Driver 
{
	/**
	 * Main method to run the palindrome checker
	 */
	public static void main(String args[])
	{
		boolean useSQPC = true;  //When this is true the SQPalindromeChecker will be used to implement this main method.
		                          //When this is false the DequePalindromeChecker will be used.
		boolean useADPC = true;   //When this is true and useSQPC is false the ArrayDequePalindromeChecker will be used.
		                          //When this is false and useSQPC is false the LinkedDequePalindromeChecker will be used.
		boolean useASQPC = true; //When this is true and useSQPC is true the ArraySQPalindromeChecker will be used.
		                          //When this is false and useSQPC is true the LinkedSQPalindromeChecker will be used. 
		System.out.println("Enter a string to check if it is a palindrome: ");
		boolean finished = false;
		
		while(!finished)
			finished = run(useSQPC, useADPC, useASQPC);
	}
	
	/**
	 * CheckPalindrome checks a string to see if it is a palindrome.
	 * It uses a scanner to test user input.
	 * @param boolean sq. Used to create the palindromeChecker. (See method type())
	 * @param boolean a. Used to create the palindromeChecker. (See method type())
	 * @return boolean returns true if the user is finished and false otherwise. (See method answer())
	 */
	private static boolean checkPalindrome(boolean sq, boolean a)
	{
		PalindromeChecker pc = type(sq, a);		
		Scanner sc = new Scanner(System.in);
		boolean finished = false;
		String str;
		
		while(!finished){
			str = sc.nextLine();
		
		    if(pc.isPalindrome(str) == true){
		    	System.out.println(str + " is a palindrome.");
		    	System.out.println("Try again? (yes/no)");
		    	finished = answer(sc.nextLine());
		    }
		    else { 
		    	System.out.println(str + " is NOT a palindrome.");
		    	System.out.println("Try again? (yes/no)");
		    	finished = answer(sc.nextLine());
		    }

		}
		
		return finished;
	}
	
	/**
	 * Checks the string for a yes or no answer. If a yes or no answer is not given, 
	 * the user is prompted to give an answer of yes or no.
	 * @param String to be checked.
	 * @return boolean. True if no is entered and false otherwise.
	 */
	private static boolean answer(String answer)
	{
		boolean finished = false;
		Scanner sc = new Scanner(System.in);
		
		if(answer.trim().equalsIgnoreCase("no")){
    		System.out.println("Goodbye");
    		finished = true;
    	}
		
		if(answer.trim().equalsIgnoreCase("yes")){
			System.out.println("Enter a string to check if it is a palindrome: ");
		}
		
		if(!answer.trim().equalsIgnoreCase("yes") && !answer.trim().equalsIgnoreCase("no")){
			System.out.println("You must enter 'yes' or 'no'");
			System.out.println("Try again? (yes/no)");
			finished = answer(sc.nextLine());
			
		}
		
		return finished;
	}
	
	/**
	 * Determinds which type of PalindromeChecker to create.
	 * @param boolean sq. True value is a PalindromeChecker that uses a stack and a queue and false is with a deque.
	 * @param boolean a. True value is a PalindromeChecker implemented with arrays and false is implemented with linked nodes.
	 * @return A PalindromeChecker is returned.
	 */
	private static PalindromeChecker type(boolean sq, boolean a)
	{
		PalindromeChecker pc;
		
		if(sq)
			
			if(a)
				pc = new ArraySQPalindromeChecker();
			else
				pc = new LinkedSQPalindromeChecker();
		else
			
			if(a)
				pc = new ArrayDequePalindromeChecker();
			else
				pc = new LinkedDequePalindromeChecker();
		
		return pc;
	}
	
	/**
	 * Takes three boolean paramaters to determine the type of PalindromeChecker to use to test for a palindrome.
	 * @param boolean useSQPC. If true a SQPalindromeChecker is used. False a DequePalindromeChecker is used.
	 * @param boolean useADPC Only relevant iff useSQPC is true. Then, if true an ArraySQPalindromeChecker is used. False a LinkedPalindromeChecker is used.
	 * @param boolean useASQPC Only relevant iff useSQPC is false. Then, if true an ArrayDequePalindromeChecker is used. False a LinkedPalindromeChecker is used.
	 * @return boolean returns true if the user is finished and false otherwise. (See method answer())
	 */
	public static boolean run(boolean useSQPC, boolean useADPC, boolean useASQPC)
	{
		boolean finished = false;
		
		if(useSQPC){

			if(useASQPC){
				finished = checkPalindrome(true, true);
			}
			else{
				finished = checkPalindrome(true, false);
			}
		}
		else{ 
			if(useADPC){
				finished = checkPalindrome(false, true);
			}
			else{
				finished = checkPalindrome(false, false);
			}
		}
		
		return finished;
	}
}
