/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/string-construction
 * 
 * @author Abhash Upadhyaya
 *
 */
public class StringConstruction {

	public static void main(String[] args) {

		try(Scanner in = new Scanner(System.in)) {
			
			int n = in.nextInt();
			for(int a0 = 0; a0 < n; a0++){
				String s = in.next();
				System.out.println(constructString(s));
	        }
		}
	}
	
	private static int constructString(final String str) {
		
		Set<Character> charSet = new HashSet<Character>();
		charSet.add(str.charAt(0));
		int minCost = 1;
		
		for(int i=1; i<str.length(); i++) {
			
			char c = str.charAt(i);
			if(!isCharPresent(charSet, c)) {
				charSet.add(c);
				minCost++;
			}
		}
		
		return minCost;
	}
	
	private static boolean isCharPresent(final Set<Character> charSet, final Character c) {
		
		return charSet.contains(c);
	}
}