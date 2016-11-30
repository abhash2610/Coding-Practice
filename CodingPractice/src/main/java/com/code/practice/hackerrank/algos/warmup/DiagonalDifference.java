/**
 * 
 */
package com.code.practice.hackerrank.algos.warmup;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference
 * 
 * @author Abhash Upadhyaya
 *
 */
public class DiagonalDifference {

	public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
	        int n = in.nextInt();
	        int a[][] = new int[n][n];
	        for(int a_i=0; a_i < n; a_i++){
	            for(int a_j=0; a_j < n; a_j++){
	                a[a_i][a_j] = in.nextInt();
	            }
	        }
	        
	        diagonalDifference(a);
        }
    }
    
    private static void diagonalDifference(int[][] a) {
        
        int diff = 0;
        for(int row=0, col=a[0].length-1; row<a.length; row++, col--) {
            diff = diff + a[row][row] - a[col][row];
        }
        
        System.out.println(Math.abs(diff));
    }
}
