/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/beautiful-binary-string
 * 
 * @author Abhash Upadhyaya
 *
 */
public class BeautifulBinaryString {

	public static void main(String[] args) {

		try(Scanner in = new Scanner(System.in)) {
	        int n = in.nextInt();
	        String B = in.next();
	        
	        if(n > 2)
	        	System.out.println(makeBeautifulString(B));
	        else
	        	System.out.println(0);
		}
	}
	
	private static int makeBeautifulString(String str) {
		
		StringBuilder sb = new StringBuilder(str);
		
		int changeNeeded = 0;
		int index = -1;
		
		while((index = sb.indexOf("010")) != -1) {
			
			sb.setCharAt(index+2, '1');
			changeNeeded++;
		}
		
		return changeNeeded;
	}
}