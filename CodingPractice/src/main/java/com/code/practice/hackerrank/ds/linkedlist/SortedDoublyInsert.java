/**
 * 
 */
package com.code.practice.hackerrank.ds.linkedlist;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list
 * 
 * @author Abhash Upadhyaya
 *
 *
You’re given the pointer to the head node of a sorted doubly linked list and an integer to insert into the list.
Create a node and insert it into the appropriate position in the list such that its order is maintained.
The head node might be NULL to indicate that the list is empty.

Input Format

Complete the Node* SortedInsert(Node* head, int data) method which takes two arguments - the head of the sorted,
doubly linked list and the value to insert. You should NOT read any input from stdin/console.

Output Format

Create a node with the given data and insert it into the given list, making sure that the new list is also sorted.
Then return the head node of the updated list. Do NOT print anything to stdout/console.

Sample Input

NULL , data = 2  
NULL <-- 2 <--> 4 <--> 6 --> NULL  , data = 5

Sample Output

NULL <-- 2 --> NULL
NULL <-- 2 <--> 4 <--> 5 <--> 6 --> NULL

 *
 */
public class SortedDoublyInsert {

	public static void main(String[] args) {
		
		Node head1 = null;
		head1 = SortedInsert(head1, 2);
		head1 = SortedInsert(head1, 1);
		head1 = SortedInsert(head1, 4);
		head1 = SortedInsert(head1, 3);
		printList(head1);
		
		System.out.println();
		
		Node head2 = null;
		head2 = SortedInsert(head2, 1);
		head2 = SortedInsert(head2, 4);
		head2 = SortedInsert(head2, 2);
		head2 = SortedInsert(head2, 3);
		head2 = SortedInsert(head2, 7);
		head2 = SortedInsert(head2, 6);
		head2 = SortedInsert(head2, 9);
		head2 = SortedInsert(head2, 10);
		printList(head2);
	}
	
	private static Node SortedInsert(Node head,int data) {
		  
	    Node newNode = new Node();
	    newNode.data = data;
	    newNode.prev = null;
	    newNode.next = null;

	    if(head == null)
	        head = newNode;
	    else {
	        Node prevNode = null;
	        Node traversalNode = head;
	        while(traversalNode != null && traversalNode.data < newNode.data) {
	            prevNode = traversalNode;
	            traversalNode = traversalNode.next;
	        }

	        newNode.next = traversalNode;
	        newNode.prev = prevNode;

	        if(prevNode == null)
	            head = newNode;
	        else
	        	prevNode.next = newNode;
	        
	        if(traversalNode != null)
	        	traversalNode.prev = newNode;
	    }

	    return head;
	}
	
	private static void printList(Node head) {
		
		Node traversalNode = head;
		
		while(traversalNode != null) {
			System.out.print(traversalNode.data + " ");
			traversalNode = traversalNode.next;
		}
	}
	
	private static class Node {
		int data;
		Node prev;
	    Node next;
	}
}