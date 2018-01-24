package com.linkedlist;

public class LinkedListTest {

	/**
	 * Remove all element in the linkedlist that is great than a target value
	 * 
	 * @param linkedList
	 * @param targetData
	 */
	static public void removeGreaterThanTarget(SinglyLinkedList<Integer> linkedList, int targetData) {

		Node<Integer> current = linkedList.getHead();
		
		if (current != null && current.getData().intValue() > targetData) {
			linkedList.remove(current.getData().intValue());
		}
		
		// Loop until last element is reached
		while (current.getNext() != null) {
			current = current.getNext();
			if (current.getData().intValue() > targetData) {
				linkedList.remove(current.getData().intValue());
			}
		}

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();

		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		
		// Original linked list
		System.out.println(" Original linked list --> " + linkedList);

		// Remove the tail element from a linkedlist
		linkedList.removeLast();
		System.out.println("\nAfter removed the tail element from a linkedlist -->" + linkedList);

		int targetData = 2;
		removeGreaterThanTarget(linkedList, targetData);
		System.out.println("\nAfter remove all element in the linkedlist that is great than a target value  "
				+ targetData + "  -->" + linkedList);
	}
}