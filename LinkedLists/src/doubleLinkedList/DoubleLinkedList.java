package doubleLinkedList;

import java.util.Scanner;

public class DoubleLinkedList {
	private Node start;

	public DoubleLinkedList() {
		start = null;
	}

	public void displayList() {
		Node p; // pointer 
		if (start == null) {
			System.out.println("List is empty");
			return;
		}
		p = start; //	initialize pointer to first node
		System.out.println("List is :\n");
		while (p != null) { //	traverse till end of list
			System.out.print(p.info + " ");
			p = p.next;
		}
		System.out.println();
	}

	public void insertInBeginning(int data) {
		Node temp = new Node(data);
		temp.next = start;
		start.prev = temp;
		start = temp;
	}

	public void insertInEmptyList(int data) {
		Node temp = new Node(data);
		start = temp;
	}

	public void insertAtEnd(int data) {
		Node temp = new Node(data);
		Node p = start;
		while (p.next != null) {
			p = p.next;
		}
		p.next = temp;
		temp.prev = p;
	}

	public void createList() {
		int i, n, data;
		Scanner scan = new Scanner(System.in);

		try {
			System.out.println("Enter the number of nodes: ");
			n = scan.nextInt();
			if (n == 0)
				return;

			System.out.println("Enter the first element to be inserted: ");
			data = scan.nextInt();
			insertInEmptyList(data);

			for (i = 2; i < n; i++) {
				System.out.println("Enter the next element to be inserted: ");
				data = scan.nextInt();
				insertAtEnd(data);
			}

		} finally {
			scan.close();
		}
	}

	public void insertAfter(int data, int x) {
		Node temp = new Node(data);
		Node p = start;
		while (p != null) {
			if (p.info == x)
				break;
			p = p.next;
		}
		if (p == null) {
			System.out.println(x + " not present in the list");
		} else {
			temp.prev = p;
			temp.next = p.next;
			if (p.next != null)
				p.next.prev = temp; // should not be done when p refers to last node in the list
			p.next = temp;
		}
	}

	public void insertBefore(int data, int x) {
		// if list is empty
		if (start == null) {
			System.out.println("List is empty");
			return;
		}

		// if x is in beginning of the list
		if (start.info == x) {
			Node temp = new Node(data);
			temp.next = start;
			start.prev = temp;
			start = temp;
			return;
		}

		Node p = start;
		while (p != null) {
			if (p.info == x)
				break;
			p = p.next;
		}
		if (p == null) {
			System.out.println(x + " not present in the list");
		} else {
			Node temp = new Node(data);
			temp.prev = p.prev;
			temp.next = p;
			p.prev.next = temp;
			p.prev = temp;
		}

	}

}
