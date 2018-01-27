package singleLinkedList;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int choice, data, k, x;
		Scanner scan = new Scanner(System.in);
		SingleLinkedList list = new SingleLinkedList();

		list.createList();
		try {
			while (true) {
				System.out.println("1. Display list");
				System.out.println("2. Count the number of nodes");
				System.out.println("3. Search for an element");
				System.out.println("4. Insert in empty list/Insert in beginning of the list");
				System.out.println("5. Insert a node at the end of the list");
				System.out.println("6. Insert a node after a specified node");
				System.out.println("7. Insert a node before a specified node");
				System.out.println("8. Insert a node at a given position");
				System.out.println("9. Delete first node");
				System.out.println("10. Delete last node");
				System.out.println("11. Delete any node");
				System.out.println("12. Reverse the list");
				System.out.println("13. Bubble sort by exchanging data");
				System.out.println("14. Bubble sort by exchanging links");
				System.out.println("15. MergeSort");
				System.out.println("16. Insert Cycle");
				System.out.println("17. Detect Cycle");
				System.out.println("18. Remove Cycle");
				System.out.println(("19. Quit"));

				System.out.println("Enter your choice: ");
				choice = scan.nextInt();

				if (choice == 19)
					break;
				switch (choice) {
					case 1:
						list.displayLinkedList();
						break;
					case 2:
						list.getSize();
						break;
					case 3:
						System.out.println("Enter the element to be searched: ");
						data = scan.nextInt();
						list.search(data);
						break;
					case 4:
						System.out.println("Enter the element to be inserted: ");
						data = scan.nextInt();
						list.insertInBeginning(data);
						break;
					case 5:
						System.out.println("Enter the element to be inserted: ");
						data = scan.nextInt();
						list.insertAtEnd(data);
						break;
					case 6:
						System.out.println("Enter the element to be inserted: ");
						data = scan.nextInt();
						System.out.println("Enter the element after which to insert: ");
						x = scan.nextInt();
						list.insertAfter(data, x);
						break;
					case 7:
						System.out.println("Enter the element to be inserted: ");
						data = scan.nextInt();
						System.out.println("Enter the element before which to insert: ");
						x = scan.nextInt();
						list.insertBefore(data, x);
						break;
					case 8:
						System.out.println("Enter the element to be inserted: ");
						data = scan.nextInt();
						System.out.println("Enter the position at which to insert: ");
						x = scan.nextInt();
						list.insertAtPosition(data, x);
						break;
					case 9:
						list.deleteFirstNode();
						break;
					case 10:
						list.deleteLastNode();
						break;
					case 11:
						System.out.println("Enter the element to be deleted: ");
						data = scan.nextInt();
						list.deleteNode(data);
						break;
					case 12:
						list.reverseList();
						break;
					case 13:
						list.bubbleSortData();
						break;
					case 14:
						list.bubbleSortLinks();
						break;
				}
			}
		} finally {
			scan.close();
		}
	}

}
