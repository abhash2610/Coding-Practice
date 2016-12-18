/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-love-letter-mystery
 * 
 * @author Abhash Upadhyaya
 *
 */
public class TheLoveLetterMystery {

	public static void main(String[] args) {

		try(Scanner userInput = new Scanner(System.in)) {
			
			int testCases = userInput.nextInt();
			
			while(testCases-- > 0) {
				String encryptedPalindrome = userInput.next();
				
				System.out.println(getMinOperations(encryptedPalindrome));
			}
		}
	}
	
	private static int getMinOperations(final String encryptedPalindrome) {
		
		char[] charArr = encryptedPalindrome.toCharArray();
		int requiredOperations = 0;
		
		for(int i=0, j=charArr.length-1; i<j; i++, j--) {
			
			if(charArr[i] != charArr[j]) {
				int diff = charArr[i] - charArr[j];
				requiredOperations = requiredOperations + Math.abs(diff);
			}
		}
		
		return requiredOperations;
	}
}