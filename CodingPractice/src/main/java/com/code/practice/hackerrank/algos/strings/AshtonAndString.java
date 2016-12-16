/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/ashton-and-string
 * 
 * @author Abhash Upadhyaya
 *
 */
public class AshtonAndString {

	private static Set<String> strPermutationSet = null;
	
	public static void main(String[] args) {

		try(Scanner userInput = new Scanner(System.in)) {
			
			int totalTests = userInput.nextInt();
			
			while(totalTests-- > 0) {
				
				String testString = userInput.next();
				int kthCharPosition = userInput.nextInt() - 1; 
				
				strPermutationSet = new TreeSet<String>();
//				permuteString(testString);
				findAllSubstrings(testString);
//				System.out.println(strPermutationSet);
				System.out.println(concatSetAndGetKthChar(kthCharPosition));
			}
		}
	}
	
	private static void findAllSubstrings(final String testString) {
		
		for(int i=0; i<=testString.length(); i++) {
			for(int j=i+1; j<=testString.length(); j++) {
				strPermutationSet.add(testString.substring(i, j));
			}
		}
	}
	
	/*private static void permuteString(final String testString) {
		
		for(int i=0; i<=testString.length(); i++) {
			for(int j=i+1; j<=testString.length(); j++) {
				permute("", testString.substring(i, j));
			}
		}
	}
	
	private static void permute(String prefix, String str) {
		
		int strLen = str.length();
		if(strLen == 1) {
			if(!isStringPermutationPresent(prefix + str))
				strPermutationSet.add(prefix + str);
		}
		else {
			for(int i=0; i<strLen; i++) {
				permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1));
			}
		}
	}
	
	private static boolean isStringPermutationPresent(final String permutedString) {
		return strPermutationSet.contains(permutedString);
	}*/
	
	private static char concatSetAndGetKthChar(int kthCharPosition) {
		
		char kthCharacter = ' ';
		int stringLengthCounter = 0;
		Iterator<String> setIter = strPermutationSet.iterator();
		while(setIter.hasNext()) {
			
			String permutedStr = setIter.next();
			if(permutedStr.length() + stringLengthCounter < kthCharPosition) {
				stringLengthCounter = stringLengthCounter + permutedStr.length();
			}
			else {
				kthCharacter = permutedStr.charAt(kthCharPosition - stringLengthCounter);
				break;
			}
		}
		
		return kthCharacter;
	}
}
