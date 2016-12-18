/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;

/**
 * @author Abhash Upadhyaya
 *
 */
public class GemStones {

	private static final int[] uniqueAlphabets = new int[26];
	
	public static void main(String[] args) {

		try(Scanner userInput = new Scanner(System.in)) {
			
			int totalRocks = userInput.nextInt();
			
			int counter = totalRocks;
			while(counter-- > 0) {
				String rock = userInput.next();
				
				processRock(rock);
			}
			System.out.println(getGemStones(totalRocks));
		}
	}
	
	private static void processRock(final String rock) {
		
		boolean[] isAlphaPresent = new boolean[26];
		char[] letters = rock.toCharArray();
		
		for(char alpha : letters) {
			
			int index = alpha - 97;
			if(!isAlphaPresent[index]) {
				isAlphaPresent[index] = true;
				uniqueAlphabets[index]++;
			}
		}
	}
	
	private static int getGemStones(int totalRocks) {
		
		int gemStones = 0;
		
		for(int aplhaOccurrence : uniqueAlphabets) {
			if(aplhaOccurrence == totalRocks)
				gemStones++;
		}
		
		return gemStones;
	}
}