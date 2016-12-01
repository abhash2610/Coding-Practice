/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/funny-string
 * 
 * @author Abhash Upadhyaya
 *
 */
public class FunnyStrings {
	
	private static final String FUNNY = "Funny";
	private static final String NOT_FUNNY = "Not Funny";

	public static void main(String[] args) {

		try(Scanner userInput = new Scanner(System.in)) {
			
			int totalInput = userInput.nextInt();
			
			while(totalInput-- > 0) {
				
				String str = userInput.next();
			
				if(str.length() <= 2)
					System.out.println("FUNNY");
				else
					System.out.println(checkIfFunny(str));
			}
		}
	}
	
	private static String checkIfFunny(final String userInput) {
		
		boolean isFunny = true;
		
		for(int startIdx=1, endIdx=userInput.length()-2; startIdx<userInput.length(); startIdx++, endIdx--) {
			
			if(Math.abs(userInput.charAt(startIdx)-userInput.charAt(startIdx-1))
					!= Math.abs(userInput.charAt(endIdx)-userInput.charAt(endIdx+1))) {
				
				isFunny = false;
				break;
			}
		}
		
		if(isFunny)
			return FUNNY;
		else
			return NOT_FUNNY;
	}
}