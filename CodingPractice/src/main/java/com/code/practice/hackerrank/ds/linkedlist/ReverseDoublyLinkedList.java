/**
 * 
 */
package com.code.practice.hackerrank.ds.linkedlist;

/**
 * https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list
 * 
 * @author Abhash Upadhyaya
 *
 */
public class ReverseDoublyLinkedList {

	public static void main(String[] args) {

		Node head = null;
		Node node1 = new Node();
		node1.data = 1;

		head = node1;

		Node node2 = new Node();
		node2.data = 2;

		node1.next = node2;
		node2.prev = node1;

		Node node3 = new Node();
		node3.data = 3;

		node2.next = node3;
		node3.prev = node2;

		printList(head);
		System.out.println();

		Node node = Reverse(head);
		printList(node);
	}

	private static Node Reverse(Node head) {

		if (head == null)
			return head;
		if (head.next == null) {
			head.prev = null;
			return head;
		} else {

			Node newHead = Reverse(head.next);

			head.next.next = head;

			if (head.prev == null)
				head.next = null;

			head.prev = head.next;

			return newHead;
		}
	}

	private static void printList(Node head) {

		Node traversalNode = head;

		while (traversalNode != null) {
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
