package com.linkedlist;

/**
 * 
 * Single Linked List
 * 
 * @author Lian
 *
 * @param <E>
 */
public class SinglyLinkedList<E> {

	private Node<E> head, tail;
	protected long size;

	public SinglyLinkedList() {
		super();
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * Adds an element into the linkedlist
	 * 
	 * @param data
	 */
	public void add(E data) {
		if (data == null) {
			throw new NullPointerException("Cannot add null data!");
		}
		if (!isEmpty()) { // adding subsequent nodes
			Node<E> current = this.tail;
			this.tail = new Node<E>(data, null);
			current.next = this.tail;
		} else { // adding the first node
			this.tail = new Node<E>(data, null);
			this.head = this.tail;
		}

		size++;
	}

	/**
	 * Remove an element
	 * 
	 * @param data
	 * @return
	 */
	public boolean remove(E data) {
		if (isEmpty()) {
			throw new IllegalStateException("Cannot remove() from an empty list!");
		}

		boolean hasRemoved = false;

		// set both pointers to head to start with
		Node<E> prev = this.head;
		Node<E> curr = this.head;

		// loop until last node is reached or data is found
		while (curr.next != null || curr == this.tail) {

			// data is found
			if (curr.data.equals(data)) {
				// remove the last remaining node
				if (size == 1) {
					this.head = null;
					this.tail = null;
				}
				// remove the first node
				else if (curr.equals(this.head)) {
					this.head = this.head.next;
				}
				// remove the last node
				else if (curr.equals(this.tail)) {
					this.tail = prev;
					this.tail.next = null;
				}
				// remove the node in the middle.
				else {
					prev.next = curr.next;
				}

				size--;
				hasRemoved = true;
				break;
			}

			// move to next node
			prev = curr;
			curr = prev.next;
		}
		return hasRemoved;
	}

	/**
	 * 
	 * Remove the tail element from a linkedlist
	 * 
	 * @return
	 */
	public E removeLast() {
		Node<E> tail = getTail();
		E data = tail.getData();
		remove(data);
		return data;
	}

	private boolean isEmpty() {
		return size == 0;
	}

	public Node<E> getHead() {
		return head;
	}

	public Node<E> getTail() {
		return tail;
	}

	public long getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "\nhead --> " + head + "\ntail --> " + tail + "\nsize --> " + size;
	}

}