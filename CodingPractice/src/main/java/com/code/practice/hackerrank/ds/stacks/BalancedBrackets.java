/**
 * 
 */
package com.code.practice.hackerrank.ds.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/balanced-brackets
 * 
 * @author Abhash Upadhyaya
 *

A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket
 (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) 
 of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched.
For example, {[(])} is not balanced because the contents in between { and } are not balanced.
The pair of square brackets encloses a single, unbalanced opening bracket, (, and 
the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is considered to be balanced 
if the following conditions are met:

    * It contains no unmatched brackets.
    * The subset of brackets enclosed within the confines of a matched pair of 
      brackets is also a matched pair of brackets.

Given n strings of brackets, determine whether each sequence of brackets is balanced.
If a string is balanced, print YES on a new line; otherwise, print NO on a new line.

Input Format

The first line contains a single integer, n, denoting the number of strings.
Each line i of the subsequent n lines consists of a single string, s, denoting a sequence of brackets.

Constraints

	* 1<=n<=10e3
	* 1<=lens<=10e3, where lens is the length of the sequence.
    				 Each character in the sequence will be a bracket (i.e., {, }, (, ), [, and ]).

Output Format

For each string, print whether or not the string of brackets is balanced on a new line. 
If the brackets are balanced, print YES; otherwise, print NO.

Sample Input

3
{[()]}
{[(])}
{{[[(())]]}}

Sample Output

YES
NO
YES

 *
 */
public class BalancedBrackets {

	private static final String YES = "YES";
	private static final String NO = "NO";
	
	public static void main(String[] args) {

		try(Scanner userInput = new Scanner(System.in)) {
			
			int n = userInput.nextInt();
			
			if(n > 0 || n > 1000) {
				for(int i=0; i<n; i++) {
					String seq = userInput.next();
					areBracketsBalanced(seq);
				}
			}
			else
				System.out.println(NO);
		}
	}
	
	private static void areBracketsBalanced(final String seq) {
		
		int seqLength = seq.length();
		boolean isBalanced = true;
		Stack<Character> bracketStack = new Stack<Character>();
		
		if(seqLength%2 == 1 || seqLength > 1000) {
			isBalanced = false;
		}
		else {

			for(int i=0; i<seqLength; i++) {
				
				char bracket = seq.charAt(i);
				
				if(bracket == '(' || bracket == '{' || bracket == '[')
					bracketStack.push(bracket);
				else {
					if(bracketStack.empty()) {
						isBalanced = false;
						break;
					}
					char bracketFromStack = bracketStack.pop(); 
					if(bracket == ')' && bracketFromStack != '(') {
						isBalanced = false;
						break;
					}
					if(bracket == '}' && bracketFromStack != '{') {
						isBalanced = false;
						break;
					}
					if(bracket == ']' && bracketFromStack != '[') {
						isBalanced = false;
						break;
					}
				}
			}
		}
		
		if(isBalanced && bracketStack.empty())
			System.out.println(YES);
		else
			System.out.println(NO);
	}
}