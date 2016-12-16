/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/anagram
 * 
 * @author Abhash Upadhyaya
 *
 */
public class Anagram {

	public static void main(String[] args) {

		try(Scanner userInput = new Scanner(System.in)) {
			
			int testCases = userInput.nextInt();
			
			while(testCases-- > 0) {
				
				String str = userInput.next();
				
				System.out.println(changeNeededForAnagram(str));
			}
		}
	}
	
	private static int changeNeededForAnagram(final String str) {
		
		int[] alphabets = new int[26];
		int strLength = str.length();
		int changesNeeded = 0;
		
		if(strLength%2 == 1)
			return -1;
		
		for(int i=0, j=strLength-1; i<j; i++, j--) {
			int charAsciiValueIndex = (int)str.charAt(i) - 97;
			alphabets[charAsciiValueIndex]++;
			
			charAsciiValueIndex = str.charAt(j) - 97;
			alphabets[charAsciiValueIndex]--;
		}
		
		for(int k=0; k<alphabets.length; k++) {
			
			if(alphabets[k] > 0) {
				changesNeeded = changesNeeded + alphabets[k];
			}
		}
		
		return changesNeeded;
	}
}
