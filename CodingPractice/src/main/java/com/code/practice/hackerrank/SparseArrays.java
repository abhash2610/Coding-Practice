/**
 * 
 */
package com.code.practice.hackerrank;

import java.util.Scanner;

/**
 * @author Abhash Upadhyaya
 *	
 *
 *

https://www.hackerrank.com/challenges/sparse-arrays

There are N strings. Each string's length is no more than 20 characters. 
There are also Q queries. For each query, you are given a string, and you 
need to find out how many times this string occurred previously.

Input Format

The first line contains N, the number of strings.
The next N lines each contain a string.
The N + 2nd line contains Q, the number of queries.
The following Q lines each contain a query string. 

Sample Input

4
aba
baba
aba
xzxb
3
aba
xzxb
ab

Constraints

1<=N<=1000
1<=Q<=1000
1<=length of any string<=20

Sample Output

2
1
0

Explanation

Here, "aba" occurs twice, in the first and third string. The string "xzxb" occurs once
 in the fourth string, and "ab" does not occur at all.

*/

public class SparseArrays {

	public static void main(String[] args) {

		try(Scanner userInput = new Scanner(System.in)) {
		
			int N = userInput.nextInt();
			
			if(N > 0) {
			
				String[] stringArr = new String[N];
				for(int i=0; i<N; i++) {
					stringArr[i] = userInput.next();
				}
				
				int Q = userInput.nextInt();
				if(Q > 0) {
					
					int[] queryCounterResultArr = new int[Q];
					for(int j=0; j<Q; j++) {
						
						String queryString = userInput.next();
						
						int queryCounter = 0;
						for(int i=0; i<N; i++) {
							if(stringArr[i].equals(queryString))
								queryCounter++;
						}
						
						queryCounterResultArr[j] = queryCounter;
					}
					
					for(int j=0; j<Q; j++) {
						System.out.println(queryCounterResultArr[j]);
					}
				}
			}
		}
	}
}