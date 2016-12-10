/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;

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
		
		StringBuilder sb = new StringBuilder();
		sb.append(str.charAt(0));
		int minCost = 1;
		int strLength = str.length();
		
		for(int i=1; i<str.length(); i++) {
			
			int j = i + 1;
			while(j<=strLength && sb.indexOf(str.substring(i, j)) != -1) {
				j++;
			}
			
			if(j == (i + 1)) {
				minCost++;
			}
			else {
				j--;
				i = j;
			}
			
			sb.append(str.substring(i, j));
		}
		
		return minCost;
	}
}