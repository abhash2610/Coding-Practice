/**
 * 
 */
package com.code.practice.hackerrank.ds.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/maximum-element
 * 
 * @author Abhash Upadhyaya
 *
 * 
 *         https://www.hackerrank.com/challenges/maximum-element
 * 
 *         You have an empty sequence, and you will be given N queries. Each
 *         query is one of these three types:
 * 
 *         1 x -Push the element x into the stack. 2 -Delete the element present
 *         at the top of the stack. 3 -Print the maximum element in the stack.
 * 
 *         Input Format
 * 
 *         The first line of input contains an integer, N. The next lines each
 *         contain an above mentioned query. (It is guaranteed that each query
 *         is valid.)
 * 
 * 
 *         Constraints
 * 
 *         1<=N<=10e5
 *         1<=x<=10e9
 *         1<=type<=3
 * 
 * 
 *         Output Format
 * 
 *         For each type query, print the maximum element in the stack on a new
 *         line.
 * 
 *         Sample Input
 * 
 *         10
 *         1 97
 *         2
 *         1 20
 *         2
 *         1 26
 *         1 20
 *         2
 *         3
 *         1 91
 *         3
 * 
 *         Sample Output
 * 
 *         26
 *         91
 * 
 */

public class MaximumElement {

	public static void main(String[] args) {

		try (Scanner inp = new Scanner(System.in)) {
			
			int N = inp.nextInt();
			Stack<Integer> stack = new Stack<>();
			Stack<Integer> largest_stack = new Stack<>();
			largest_stack.push(Integer.MIN_VALUE);

			for (int i = 1; i <= N; i++) {
				int query = inp.nextInt();

				if (query == 1) {
					int newtop = inp.nextInt();
					stack.push(newtop);

					if (stack.peek() >= largest_stack.peek()) {
						largest_stack.push(stack.peek());
					}
				}

				if (query == 2) {
					if (stack.peek() == largest_stack.peek()) {
						largest_stack.pop();
					}

					stack.pop();
				}

				if (query == 3) {
					System.out.println(largest_stack.peek());
				}
			}
		}
	}
}