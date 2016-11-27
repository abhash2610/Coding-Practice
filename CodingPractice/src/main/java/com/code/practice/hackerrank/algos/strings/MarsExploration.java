/**
 * 
 */
package com.code.practice.hackerrank.algos.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/mars-exploration
 * 
 * @author Abhash Upadhyaya
 *
 */
public class MarsExploration {

	public static void main(String[] args) {
        
		try(Scanner in = new Scanner(System.in)) {
			
			String S = in.next();
			
			int alteredCharCount = 0;
			
			for(int i=0; i<S.length(); i+=3) {
				
				if(S.charAt(i) != 'S')
					alteredCharCount++;
				
				if(S.charAt(i+1) != 'O')
					alteredCharCount++;
				
				if(S.charAt(i+2) != 'S')
					alteredCharCount++;
			}
			
			System.out.println(alteredCharCount);
		}
    }
}
