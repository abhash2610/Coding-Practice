/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/camelcase
 * 
 * @author Abhash Upadhyaya
 *
 */
public class CamelCase {

	public static void main(String[] args) {

		try(Scanner in = new Scanner(System.in)) {
			
			String s = in.next();
			
			System.out.println(noOfWords(s));
		}
	}
	
	private static int noOfWords(final String s) {
		
		int words = 0;
		if(s.length() > 0)
			words = 1;
		
//		return s.split("[A-Z]").length;
		
		for(char c : s.toCharArray()) {
			if(c >= 65 && c <= 90)
				words++;
		}
		
		return words;
	}
}