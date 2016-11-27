/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pangrams
 * 
 * @author Abhash Upadhyaya
 *
Roy wanted to increase his typing speed for programming contests. So, his friend 
advised him to type the sentence "The quick brown fox jumps over the lazy dog" 
repeatedly, because it is a pangram. (Pangrams are sentences constructed by using 
every letter of the alphabet at least once.)

After typing the sentence several times, Roy became bored with it. So he started 
to look for other pangrams.

Given a sentence s, tell Roy if it is a pangram or not.

Input Format
============
Input consists of a string s.

Constraints
===========
Length of s can be at most 10e3 (1<=|s|<=10e3) and it may contain spaces, lower case and upper case letters. 
Lower-case and upper-case instances of a letter are considered the same.

Output Format
=============
Output a line containing pangram if s is a pangram, otherwise output not pangram.

Sample Input
============

Input #1

We promptly judged antique ivory buckles for the next prize

Input #2

We promptly judged antique ivory buckles for the prize

Sample Output
=============

Output #1

pangram

Output #2

not pangram

Explanation
===========
In the first test case, the answer is pangram because the sentence contains 
all the letters of the English alphabet.

 *
 */

public class Pangrams {

	private static boolean[] result = new boolean[26];
	private static int counter = 26;
	private static final String PANGRAM = "pangram";
	private static final String NOT_PANGRAM = "not pangram";
	
	public static void main(String[] args) {

		try(Scanner userInput = new Scanner(System.in)) {
			
			String s = userInput.nextLine();
			punchChars(s);
			checkPangram();
		}
	}
	
	private static void punchChars(final String s) {
		
		for(char c : s.toCharArray()) {
			
			if(counter == 0)
				break;

			if(c>=65 && c<=90) {
				
				if(!result[c-65]){
					counter--;
					result[c-65] = true;
				}
				result[c-65] = true;
			}
			else if(c>=97 && c<=122) {
				
				if(!result[c-97]){
					counter--;
					result[c-97] = true;
				}
			}
		}
	}
	
	private static void checkPangram() {
		
		if(counter == 0)
			System.out.println(PANGRAM);
		else
			System.out.println(NOT_PANGRAM);
	}
}