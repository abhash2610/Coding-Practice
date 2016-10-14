/**
 * 
 */
package com.code.practice.hackerrank.ds.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/simple-text-editor
 * 
 * @author Abhash Upadhyaya
 *

In this challenge, you must implement a simple text editor. Initially, your editor 
contains an empty string, S. You must perform Q operations of the following 4 types:

   1. append (W)- Append string W to the end of S.
   2. delete (k)- Delete the last k characters of S.
   3. print (k)- Print the kth character of S.
   4. undo ()- Undo the last (not previously undone) operation of type 1 or 2, reverting S to the 
    			state it was in prior to that operation.

Input Format

The first line contains an integer, Q, denoting the number of operations.
Each line i of the Q subsequent lines (where 1<=i<Q) defines an operation to be performed. 
Each operation starts with a single integer, t(where t is between [1-4]), denoting a type of operation as 
defined in the Problem Statement above. If the operation requires an argument, t is followed 
by its space-separated argument. For example, if t=1 and W="abcd", line i will be 1 abcd.

Constraints

1<=Q<=10e6
1<=k<=|S|

    The sum of the lengths of all W in the input <= 10e6.
    All input characters are lowercase English letters.
    It is guaranteed that the sequence of operations given as input is possible to perform.

Output Format

Each operation of type 3 must print the kth character on a new line.

Sample Input

8
1 abc
3 3
2 3
1 xy
3 2
4 
4 
3 1

Sample Output

c
y
a


 */
public class SimpleTextEditor {

	private static final StringBuilder text = new StringBuilder();
	private static final Stack<String> undoStack = new Stack<String>();
	
	public static void main(String[] args) {
		
		try(BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
			
			int totalOperations = Integer.parseInt(userInput.readLine());
			
			for(int i=0; i<totalOperations; i++) {
				processInput(userInput.readLine(), false);
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
	}
	
	private static void processInput(final String userOperation, boolean isUndoOperation) {
		
		char operationType = userOperation.charAt(0);
		
		switch(operationType) {
		
			case '1' : 	String toBeAppended = userOperation.substring(2);
						text.append(toBeAppended);
						if(!isUndoOperation)
							undoStack.push("2 " + toBeAppended.length());
						break;
						
			case '2' : 	int charsToBeDeleted = Integer.parseInt(userOperation.substring(2));
						int deletingPosition = text.length()-charsToBeDeleted;
						String lastNChars = text.substring(deletingPosition);
						text.delete(deletingPosition, text.length());
						if(!isUndoOperation)
							undoStack.push("1 " + lastNChars);
						break;
						
			case '3' : 	int charToPrintIndex = Integer.parseInt(userOperation.substring(2)) - 1;
						System.out.println(text.charAt(charToPrintIndex));
						break;
						
			case '4' : 	if(!undoStack.empty()) {
							processUndoOperation(undoStack.pop());
						}
						break;
		}
	}
	
	private static void processUndoOperation(final String undoOperation) {
		
		processInput(undoOperation, true);
	}
}