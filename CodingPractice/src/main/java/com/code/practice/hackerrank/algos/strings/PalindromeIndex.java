/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/palindrome-index
 * 
 * @author Abhash Upadhyaya
 *
 */
public class PalindromeIndex {

	public static void main(String[] args) {

		try(Scanner userInput = new Scanner(System.in)) {
			
			int testCases = userInput.nextInt();
			
			while(testCases-- > 0) {
				String palindrome = userInput.next();
				
				System.out.println(makePalindrome(palindrome));
				
			}
		}
	}
	
	private static int makePalindrome(final String palindrome) {
		
		for(int i=0, j=palindrome.length()-1; i<j; i++, j--) {
			
			if(palindrome.charAt(i) != palindrome.charAt(j)) {
				
				String testPalindrome = palindrome.substring(0,i) + palindrome.substring(i+1);
				
				if(isPalindrome(testPalindrome)) {
					return i;
				}
				else
					return j;
			}
		}
		
		return -1;
	}
	
	private static boolean isPalindrome(final String possiblePalindrome) {
		
		char[] palindromeCharArr = possiblePalindrome.toCharArray();
		boolean isPalindrome = true;
		
		for(int i=0, j=palindromeCharArr.length-1; i<j; i++, j--) {
			if(palindromeCharArr[i] != palindromeCharArr[j]) {
				isPalindrome = false;
				break;
			}
		}
		
		return isPalindrome;
	}
}