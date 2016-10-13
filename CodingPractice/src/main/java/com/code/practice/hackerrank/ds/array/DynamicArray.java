package com.code.practice.hackerrank.ds.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/dynamic-array
 * 
 * @author Abhash Upadhyaya
 *
 *
 *
 Create a list, seqList, of N empty sequences, where each sequence is indexed from 0 to N-1.
 The elements within each of the sequences also use 0-indexing.
 
 Create an integer, lastAns, and initialize it to 0.
 
 The 2 types of queries that can be performed on your list of sequences (seqList) are described below:
        Query: 1 x y
            Find the sequence, seq, at index (x XOR lastAns) % N) in seqList.
            Append integer y to sequence seq.
        Query: 2 x y
            Find the sequence, seq, at index (x XOR lastAns) % N) in seqList.
            Find the value of element y%size in seq(where size is the size of seq) and 
            assign it to lastAns.
            Print the new value of lastAns on a new line

Task
Given N, Q, and Q queries, execute each query.


Input Format

The first line contains two space-separated integers, N(the number of sequences) and 
Q(the number of queries), respectively.
Each of the Q subsequent lines contains a query in the format defined above.


Constraints
1<=N,Q<=10e5
1<=x,y<=10e9
It is guaranteed that query type 2 will never query an empty sequence or index.


Output Format

For each type 2 query, print the updated value of lastAns on a new line.

Sample Input

2 5
1 0 5
1 1 7
1 0 3
2 1 0
2 1 1

Sample Output

7
3

 */
public class DynamicArray {
	
	public static void main(String[] args) {
		
		try(Scanner userInput = new Scanner(System.in)) {
			
			int sizeOfSeqList = userInput.nextInt();
			
			@SuppressWarnings("unchecked")
			List<Integer>[] seqList = new ArrayList[sizeOfSeqList];
			int lastAns = 0;
			
			int totalQueries = userInput.nextInt();
			
			for(int i=0; i<totalQueries; i++) {
				
				int typeOfQuery = userInput.nextInt();
				int x = userInput.nextInt();
				int y = userInput.nextInt();
				int seq = findSequence(x, lastAns, sizeOfSeqList);
						
				switch(typeOfQuery) {
					
					case 1 : 	if(seqList[seq] == null)
									seqList[seq] = new ArrayList<Integer>();
								
								seqList[seq].add(y);
								break;
					case 2 : 	int lastIndex = seqList[seq].size();
								int valueFromSeq = seqList[seq].get(y%lastIndex);
								lastAns = valueFromSeq;
								System.out.println(lastAns);
								break;
				}
			}
		}
	}
	
	private static int findSequence(int x, int lastAns, int N) {
		
		return ((x ^ lastAns) % N);
	}
}