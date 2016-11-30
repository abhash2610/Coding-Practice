/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/caesar-cipher-1
 * 
 * @author Abhash Upadhyaya
 *
 */
public class CaesarCipher {

	public static void main(String[] args) {
		
        try(Scanner in = new Scanner(System.in)) {
        	
	        int n = in.nextInt();
	        String s = in.next();
	        int k = in.nextInt();
	        
	        System.out.println(encryptString(s, k%26));
        }
    }
	
	private static String encryptString(final String unencrypted, int move) {
		
		StringBuilder sb = new StringBuilder(unencrypted);
		
		for(int idx=0; idx<sb.length();idx++) {
			
			int charAtIdx = sb.charAt(idx);
			int movedChar = charAtIdx;
			
			if(charAtIdx>=65 && charAtIdx<=90) {
				movedChar = charAtIdx + move;
				if(movedChar > 90)
					movedChar = 64 + movedChar%90;
			}
			else if(charAtIdx>=97 && charAtIdx<=122) {
				movedChar = charAtIdx + move;
				if(movedChar > 122)
					movedChar = 96 + movedChar%122;
			}
			else
				continue;
			
			sb.setCharAt(idx, (char)movedChar);
		}
		
		return sb.toString();
	}
}