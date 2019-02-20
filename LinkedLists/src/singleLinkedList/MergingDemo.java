package singleLinkedList;

public class MergingDemo {

	public static void main(String[] args) {
		SingleLinkedList list1 = new SingleLinkedList();
		SingleLinkedList list2 = new SingleLinkedList();

		list1.createList();
		list2.createList();

		list1.bubbleSortData();
		list2.bubbleSortData();

		System.out.println("First List -> ");
		list1.displayLinkedList();
		System.out.println("Second List -> ");
		list2.displayLinkedList();

		SingleLinkedList list3;

		list3 = list1.merge1(list2);

		System.out.println("Merged List -> ");
		list3.displayLinkedList();

		System.out.println("First List -> ");
		list1.displayLinkedList();
		System.out.println("Second List -> ");
		list2.displayLinkedList();

		//list3 = list1.merge2(list2);
		System.out.println("Merged List -> ");
		list3.displayLinkedList();

		System.out.println("First List -> ");
		list1.displayLinkedList();
		System.out.println("Second List -> ");
		list2.displayLinkedList();

	}

}
