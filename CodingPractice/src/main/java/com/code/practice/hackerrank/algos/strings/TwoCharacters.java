/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/two-characters
 * 
 * @author Abhash Upadhyaya
 *
 */
public class TwoCharacters {

	public static void main(String[] args) {

		try(Scanner in = new Scanner(System.in)) {
	        int len = in.nextInt();
	        String s = in.next();
	        
	        if(len > 1)
	        	System.out.println(processString(s));
	        else
	        	System.out.println("0");
		}
	}
	
	private static int processString(final String input) {
		
		Set<Character> charSet = new HashSet<Character>();
		int maxLength = 0;
//		String longestAltString = "";
		
		for(char c : input.toCharArray()) {
			charSet.add(c);
		}
		
		if(charSet.size() == 1) {
			return 0;
		}
		else {
			Character[] charArray = new Character[charSet.size()];
			charSet.toArray(charArray);
			
			for(int i=0; i<charArray.length-1; i++) {
				for(int j=i+1; j<charArray.length; j++) {
					String pattern = "[^" + charArray[i] + charArray[j] + "]";
					
					String outputStr = input.replaceAll(pattern, "");
					
					if(isAlternateCharStr(outputStr, charArray[i], charArray[j])) {
						
						if(outputStr.length() > maxLength) {
							maxLength = outputStr.length();
//							longestAltString = outputStr;
						}
					}
				}
			}
		}
		
		return maxLength;
	}
	
	private static boolean isAlternateCharStr(String altStr, Character first, Character second) {
		
		String dblFirst = "" + first + first;
		
		if(altStr.indexOf(dblFirst) == -1) {
			
			String dblSecond = "" + second + second;
			if(altStr.indexOf(dblSecond) == -1) {
				return true;
			}
		}
		
		return false;
	}
}