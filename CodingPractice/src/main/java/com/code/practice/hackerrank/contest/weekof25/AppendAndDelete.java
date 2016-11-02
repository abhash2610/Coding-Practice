/**
 * 
 */
package com.code.practice.hackerrank.contest.weekof25;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w25/challenges/append-and-delete
 * 
 * @author Abhash Upadhyaya
 * 
 * 

You have a string, s, of lowercase English alphabetic letters. 
You can perform two types of operations on s:

    1. Append a lowercase English alphabetic letter to the end of the string.
    2. Delete the last character in the string. Performing this operation on an empty string
       results in an empty string.

Given an integer, k, and two strings, s and t, determine whether or not you can convert s to t
by performing exactly k of the above operations on s. If it's possible, print Yes; otherwise, print No.

Input Format

The first line contains a string, s, denoting the initial string.
The second line contains a string, t, denoting the desired final string.
The third line contains an integer, k, denoting the desired number of operations.

Constraints
1<=s<=100
1<=t<=100
1<=k<=100

    s and t consist of lowercase English alphabetic letters.

Output Format

Print Yes if you can obtain string t by performing exactly k operations on s; otherwise, print No.

Sample Input 0

hackerhappy
hackerrank
9

Sample Output 0

Yes

Explanation 0

We perform 5 delete operations to reduce string s to hacker. Next, we perform 4 append
operations (i.e., r, a, n, and k), to get hackerrank. Because we were able to 
convert s to t by performing exactly k=9 operations, we print Yes.

Sample Input 1

aba
aba
7

Sample Output 1

Yes

Explanation 1

We perform delete 4 operations to reduce string s to the empty string (recall that, though
the string will be empty after 3 deletions, we can still perform a delete operation on an
empty string to get the empty string). Next, we perform 3 append operations (i.e., a, b, and a).
Because we were able to convert s to t by performing exactly k=7 operations, we print Yes.
 *
 */
public class AppendAndDelete {

	public static void main(String[] args) {
		
		try(Scanner userInput = new Scanner(System.in)) {
			
	        String s = userInput.next().toLowerCase();
	        String t = userInput.next().toLowerCase();
	        int k = userInput.nextInt();
	        
	        int sLen = s.length();
	        int tLen = t.length();
	        
	        if(s.equals("")) {
	        	if(tLen <= k)
	        		System.out.println("Yes");
	        	else
	        		System.out.println("No");	
	        }
	        else if(sLen == tLen) {
	        	
	        	if(s.equals(t)) {
	        		
	        		if(k >= tLen*2 || k%2 ==0)
	        			System.out.println("Yes");
	        		else
	        			System.out.println("No");
	        	}
	        	else
	        		check(s, sLen, t, tLen, k);
	        }
	        else
	        	check(s, sLen, t, tLen, k);
		}
	}
	
	private static void check(String s, int sLen, String t, int tLen, int k) {
		
		int loopCtr = Math.min(sLen, tLen);
		int commonLen = 0;
		int minSteps = 0;
		
		for(int i=0; i<loopCtr; i++) {
			
			if(s.charAt(i) != t.charAt(i))
				break;
			
			commonLen++;
		}
		
		minSteps = sLen - commonLen + tLen - commonLen;
		
		if(minSteps == k || ((sLen + tLen) <= k))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}