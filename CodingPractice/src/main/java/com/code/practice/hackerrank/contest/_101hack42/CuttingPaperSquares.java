/**
 * 
 */
package com.code.practice.hackerrank.contest._101hack42;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/101hack42/challenges/p1-paper-cutting/submissions/code/7461121
 * 
 * @author Abhash Upadhyaya
 *
 */
public class CuttingPaperSquares {

	public static void main(String[] args) {
		
		try(Scanner in = new Scanner(System.in)) {
			
	        long n = in.nextInt();
	        long m = in.nextInt();
	        
	        long result = n*m - 1;
	        
	        System.out.println(result);
		}
	}
}
