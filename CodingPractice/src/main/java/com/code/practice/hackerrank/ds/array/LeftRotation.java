/**
 * 
 */
package com.code.practice.hackerrank.ds.array;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation
 * 
 * @author Abhash Upadhyaya
 *

A left rotation operation on an array of size n shifts each of the array's elements 1
unit to the left. For example, if 2 left rotations are performed on array [1,2,3,4,5], 
then the array would become [3,4,5,1,2].

Given an array of n integers and a number, d, perform d left rotations on the array. 
Then print the updated array as a single line of space-separated integers.


Input Format

The first line contains two space-separated integers denoting the respective values of 
(the number of integers) and (the number of left rotations you must perform).
The second line contains space-separated integers describing the respective elements of
 the array's initial state.
 

Constraints

1<=n<=10e5
1<=d<=n
1<=a[i]<=10e6


Output Format

Print a single line of n space-separated integers denoting the final state of the array
after performing d left rotations.


Sample Input

5 4
1 2 3 4 5

Sample Output

5 1 2 3 4

Explanation

When we perform d=4 left rotations, the array undergoes the following sequence of changes:

[1,2,3,4,5] -> [2,3,4,5,1] -> [3,4,5,1,2] -> [4,5,1,2,3] -> [5,1,2,3,4]

Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.
 */

public class LeftRotation {

	public static void main(String[] args) {

		try(Scanner userInput = new Scanner(System.in)) {
		
			int sizeOfArray = userInput.nextInt();
			int noOfRotations = userInput.nextInt();
			
			int[] array = new int[sizeOfArray];
			
			for(int i=0; i<sizeOfArray; i++) {
				array[i] = userInput.nextInt();
			}
			
			leftRotateArrayAndPrint(array, noOfRotations, sizeOfArray);
		}
	}
	
	private static void leftRotateArrayAndPrint(final int[] array, int noOfRotations, int sizeOfArray) {

		// will hold the rotated elements 
		int[] leftRotatedArray = new int[sizeOfArray];
		
		for(int i=0, j=noOfRotations; i<sizeOfArray; i++, j++) {
			leftRotatedArray[i] = array[j%sizeOfArray];
		}
		for(int i=0; i<sizeOfArray; i++) {
			System.out.print(leftRotatedArray[i] + " ");
		}
	}
}