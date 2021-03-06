package singleLinkedList;

import java.util.Scanner;

public class SingleLinkedList {
	private Node start;

	public SingleLinkedList() {
		// set start to null while creating new list
		start = null;
	}

	public void displayLinkedList() {
		Node p; // pointer ref
		// if list is empty
		if (start == null) {
			System.out.println("List is empty...");
			return;
		}
		System.out.println("List is...");

		// set p to start
		p = start;
		// move the p ref to every node and print the data
		while (p != null) {
			System.out.print(p.info + " ");
			p = p.link;
		}
		System.out.println();
	}

	public void getSize() {
		Node p; // pointer ref
		int count = 0;
		// if list is empty
		if (start == null) {
			System.out.println("List is empty");
			return;
		}

		// set p to start
		p = start;
		// move the p ref to every node and increment the count
		while (p != null) {
			count++;
			p = p.link;
		}
		System.out.println("Size of the list -> " + count);
	}

	public boolean search(int val) {
		Node p; // pointer ref
		int position = 1;

		p = start;
		while (p != null) {
			if (p.info == val) {
				break;
			}
			p = p.link;
			position++;
		}

		// p is null when it reaches the end of the list
		if (p == null) {
			System.out.println("Value is not found in the list..");
			return false;
		} else {
			System.out.println("Value is found at position " + position + " in the list");
			return true;
		}
	}

	public void createList() {
		int i, n, data;
		Scanner scan = new Scanner(System.in);

		try {

			System.out.println("Enter the number of nodes: ");
			n = scan.nextInt();

			if (n == 0)
				return;

			for (i = 1; i <= n; i++) {
				System.out.println("Enter the element to be inserted: ");
				data = scan.nextInt();
				insertAtEnd(data);
			}
		} finally {
			scan.close();
		}
	}

	public void insertAtEnd(int data) {
		Node p; // pointer ref
		Node temp = new Node(data); // new node to be inserted

		// if list is empty
		if (start == null) {
			start = temp;
			return;
		}

		// set p to start
		p = start;
		// move the p ref to last node
		while (p.link != null)
			p = p.link;

		p.link = temp;
	}

	public void insertInBeginning(int data) {
		Node temp = new Node(data); // new node to be inserted

		// first element is start. so set temp.link to first element (start)
		temp.link = start;
		// set start to temp to make temp as first element
		start = temp;
	}

	public void insertAfter(int data, int x) {
		Node p; // pointer ref

		//set p to start
		p = start;
		// loop through the end to find the value x
		while (p != null) {
			if (p.info == x) {
				break; // break when value is found
			}
			p = p.link;
		}

		// p will be null if the whole list is traversed and x is not found
		if (p == null) {
			System.out.println(x + " not present in the list");
		} else {
			Node temp = new Node(data); // new node to be inserted

			// since it is after p, after of p is in p.link
			// therefore set temp.link to after of p (p.link)
			temp.link = p.link;

			// p.link will now become before of temp
			// therefore set p.link to temp
			p.link = temp;
		}
	}

	public void insertBefore(int data, int x) {
		Node temp;

		// if list is empty
		if (start == null) {
			System.out.println("List is empty..");
			return;
		}

		// if x is in the first node, new node is to be inserted before first node
		if (x == start.info) {
			temp = new Node(data);

			temp.link = start;
			start = temp;
			return;
		}

		// find reference to predecessor of node containing x

		Node p = start;
		while (p.link != null) {
			if (p.link.info == x)
				break;
			p = p.link;
		}

		if (p.link == null) {
			System.out.println(x + " not present int the list");
		} else {
			temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
		}

	}

	public void insertAtPosition(int data, int k) {
		Node temp;
		int i;

		// if k=1 is start of node
		if (k == 1) {
			temp = new Node(data);
			temp.link = start;
			start = temp;
			return;
		}

		Node p = start;
		// find reference to k-1 node
		for (i = 1; i < k - 1 && p != null; i++)
			p = p.link;

		if (p == null) {
			System.out.println("You can insert only upto " + i + "th position");
		} else {
			temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
		}
	}

	public void deleteFirstNode() {
		// if list is empty, do nothing and return
		if (start == null) {
			System.out.println("List is empty..");
			return;
		} else {
			// set start to next element of start (start.link)
			start = start.link;
		}
	}

	public void deleteLastNode() {
		// if list is empty, do nothing and return
		if (start == null) {
			System.out.println("List is empty..");
			return;
		}

		// if there is only one element (start.link == null), set start to null and return
		if (start.link == null) {
			start = null;
			return;
		}

		Node p = start; // pointer ref
		// loop till last but one node
		while (p.link.link != null) {
			p = p.link;
		}
		p.link = null;
	}

	public void deleteNode(int x) {
		// if list is empty, do nothing and return
		if (start == null) {
			System.out.println("List is empty..");
			return;
		}

		// if x is in first node
		if (start.info == x) {
			start = start.link;
			return;
		}

		// delete in between list or at the end of the list
		Node p = start; // pointer ref
		// loop till last node
		while (p.link != null) {
			if (p.link.info == x)
				break;
			p = p.link;
		}

		if (p.link == null) {
			// reached end of list
			System.out.println("Element x " + " not in the list");
		} else {
			p.link = p.link.link;
		}
	}

	public void reverseList() {
		Node prev, p, next;

		prev = null;
		p = start;
		while (p != null) {
			next = p.link;
			p.link = prev;
			prev = p;
			p = next;
		}
		start = prev;
	}

	public void bubbleSortData() {
		Node p, q, end;

		// set end to end of list. 
		// loop till end comes to second node -> start.link
		// every iteration, set end to p
		for (end = null; end != start.link; end = p) {
			// begin list from p = start
			// loop till end
			// move p to next node -> p.link
			for (p = start; p.link != end; p = p.link) {
				// set q to next node of p
				q = p.link;
				// compare info
				if (p.info > q.info) {
					// swap info
					int temp = p.info;
					p.info = q.info;
					q.info = temp;
				}
			}
		}
	}

	public void bubbleSortLinks() {
		Node end, r, p, q, temp;
		// set end to end of list. 
		// loop till end comes to second node -> start.link
		// every iteration, set end to p
		for (end = null; end != start.link; end = p) {
			// begin list from p = start
			// loop till end
			// move p to next node -> p.link, set r to q
			for (r = p = start; p.link != end; r = q, p = p.link) {
				// set q to next node of p
				q = p.link;
				// compare info
				if (p.info > q.info) {
					p.link = q.link;
					q.link = p;
					if (p != start) {
						r.link = q;
					} else {
						start = q;
					}
					temp = p;
					p = q;
					q = temp;
				}
			}
		}
	}

	public SingleLinkedList merge1(SingleLinkedList list) {
		SingleLinkedList mergeList = new SingleLinkedList();
		mergeList.start = merge1(start, list.start);
		return mergeList;
	}

	private Node merge1(Node p1, Node p2) {
		Node startM;

		// for first item compare info of p1 and p2
		if (p1.info <= p2.info) {
			// create mergedList with first node from info of p1
			startM = new Node(p1.info);
			p1 = p1.link;
		} else {
			// create mergedList with first node from info of p2
			startM = new Node(p2.info);
			p2 = p2.link;
		}

		Node pM = startM;

		while (p1 != null && p2 != null) {
			if (p1.info <= p2.info) {
				pM.link = new Node(p1.info);
				p1 = p1.link;
			} else {
				pM.link = new Node(p2.info);
				p2 = p2.link;
			}
			pM = pM.link;
		}

		// if second list has finished and elements left in first list
		while (p1 != null) {
			pM.link = new Node(p1.info);
			p1 = p1.link;
			pM = pM.link;
		}

		// if first list has finished and elements left in second list
		while (p2 != null) {
			pM.link = new Node(p2.info);
			p2 = p2.link;
			pM = pM.link;
		}
		return startM;
	}
}
