/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/reduced-string
 * 
 * @author Abhash Upadhyaya
 *
 */
public class SuperReducedString {

	public static void main(String[] args) {
		
		try(Scanner userInput = new Scanner(System.in)) {
			
			String s = userInput.next();
			
			System.out.println(reduceString(s));
		}
	}
	
	private static String reduceString(final String s) {
		
		StringBuilder sb = new StringBuilder(s);
		
		for(int index=1; index<sb.length();) {
			
			if(sb.charAt(index-1) == sb.charAt(index)) {
				sb.delete(index-1, index+1);
				
				if(index > 1)
					index--;
			}
			else
				index++;
		}
		
		if(sb.length() == 0)
			return "Empty String";
		else
			return sb.toString();
	}
}