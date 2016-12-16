/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/game-of-thrones
 * 
 * @author Abhash Upadhyaya
 *
 */
public class GameOfThrones1 {

	public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
       
        String ans = isAnyAnagramPalindrome(inputString);
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        System.out.println(ans);
        myScan.close();
    }
	
	private static String isAnyAnagramPalindrome(final String str) {
		
		int[] alphabetCountArray = new int[26];
		char[] inputCharArray = str.toCharArray();
		int strLength = inputCharArray.length;
//		boolean isOddLength = strLength%2 == 0 ? false : true;
		int oddOccurrenceCounter = 0;

		for(int i=0; i<strLength; i++) {
			
			int charAsciiValue = inputCharArray[i];
			alphabetCountArray[charAsciiValue - 97]++;
		}
		
		for(int j=0; j<alphabetCountArray.length; j++) {
			
			if(alphabetCountArray[j]%2 != 0)
				oddOccurrenceCounter++;
			
			if(oddOccurrenceCounter > 1)
				break;
		}
		
		/*if(oddOccurrenceCounter > 1)
			return "NO";
		else {
			if(isOddLength) {
				if(oddOccurrenceCounter == 1)
					return "YES";
				else
					return "NO";
			}
			else
				return "YES";
		}*/
		
		return oddOccurrenceCounter<=1?"YES":"NO";
	}
}
