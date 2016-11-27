/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/alternating-characters
 * 
 * @author Abhash Upadhyaya
 *
 *
Shashank likes strings in which consecutive characters are different. 
For example, he likes ABABA, while he doesn't like ABAA. Given a string 
containing characters A and B only, he wants to change it into a string he likes. 
To do this, he is allowed to delete the characters in the string.

Your task is to find the minimum number of required deletions.

Input Format
============

The first line contains an integer T, i.e. the number of test cases.
The next T lines contain a string each.

Output Format
=============

For each test case, print the minimum number of deletions required.

Constraints
===========

1<=T<=10
1<=length of string<=10e5

Sample Input
============

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB

Sample Output
=============

3
4
0
0
4

Explanation
===========

AAAA => A, 3 deletions
BBBBB => B, 4 deletions
ABABABAB => ABABABAB, 0 deletions
BABABA => BABABA, 0 deletions
AAABBB => AB, 4 deletions because to convert it to AB we need to delete 2 A's and 2 B's
 *
 */
public class AlternatingCharacters {

	public static void main(String[] args) {

		try(Scanner userInput = new Scanner(System.in)) {
			
			int t = userInput.nextInt();
			while(t-- > 0) {
				
				String s = userInput.next();
				
				if(s.length() <= 1)
					System.out.println(0);
				else
					printDeletionsRequired(s);
			}
		}
	}
	
	private static void printDeletionsRequired(final String s) {
		
		int deletionCounter = 0;
		char[] charStringArray = s.toCharArray();
		Stack<Character> charStack = new Stack<Character>();
		charStack.add(charStringArray[0]);
		
		for(int i=1; i<charStringArray.length; i++) {
			
			char c = charStringArray[i];
			if(charStack.peek() == c)
				deletionCounter++;
			else
				charStack.push(c);
		}
		
		System.out.println(deletionCounter);
	}
}