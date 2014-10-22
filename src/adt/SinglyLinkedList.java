/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

/**
 * @author Le
 */
public class SinglyLinkedList<E> implements List<E> {

	private int size = 0;

	private Node<E> head;

	public SinglyLinkedList() {
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void insert(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid index: " + index + " Size: " + size);
		}

		Node<E> newNode = new Node<E>(element);
		if (isEmpty()) {
			head = newNode;
		} else if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			System.out.print("INSERT an element at position " + index + " - ");
			Node<E> node = node(index - 1);
			newNode.next = node.next;
			node.next = newNode;
		}
		size++;
	}

	@Override
	public void delete(int index) {
		checkElementIndex(index);

		if (index == 0) {
			head = head.next;
		} else {
			System.out.print("DELETE element at position " + index + " - ");
			Node<E> node = node(index - 1);
			node.next = node.next.next;
		}
		size--;
	}

	@Override
	public int find(E element) {
		if (element == null) {
			throw new NullPointerException("Element is null");
		}

		System.out.print("FIND an element - ");

		int index = 0;
		for (Node<E> x = head; x != null; x = x.next) {
			if (x.element.equals(element)) {
				System.out.println(index + " operations");
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
	public E retrieve(int index) {
		checkElementIndex(index);

		System.out.print("RETRIEVE element at position " + index + " - ");

		return node(index).element;
	}

	private Node<E> node(int index) {
		// assert index >= 0 && index < size

		Node<E> node = head;
		int numOfOperations = 0;
		for (int i = 0; i < index; i++) {
			node = node.next;
			numOfOperations++;
		}
		System.out.println(numOfOperations + " Operations");
		return node;
	}

	private void checkElementIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index: " + index + "Size: " + size);
		}
	}

	@Override
	public void concat(List<E> otherList) {
		if (otherList == null) {
			throw new NullPointerException("otherList is null");
		}
		if (!(otherList instanceof SinglyLinkedList<?>)) {
			throw new IllegalArgumentException("Not supported");
		}

		if (!otherList.isEmpty()) {
			Node<E> x = ((SinglyLinkedList<E>) otherList).head;
			if (isEmpty()) {
				head = x;
			} else {
				node(size - 1).next = x;
			}
			size += otherList.size();
		}

	}

	public void concat1(List<E> otherList) {
		if (otherList == null) {
			throw new NullPointerException("otherList is null");
		}

		if (!otherList.isEmpty()) {
			Node<E> x = new Node<E>(otherList.retrieve(0));
			Node<E> pointer = x;
			for (int i = 0; i < otherList.size() - 1; i++) {
				pointer.next = new Node<E>(otherList.retrieve(i + 1));
				pointer = pointer.next;
			}
			if (isEmpty()) {
				head = x;
			} else {
				node(size - 1).next = x;
			}
			size += otherList.size();
		}
	}

	private Object[] toArray() {
		Object[] result = new Object[size];
		int i = 0;
		for (Node<E> x = head; x != null; x = x.next) {
			result[i++] = x.element;
		}
		System.out.println("Number of operations :" + i);
		return result;
	}

	private static class Node<E> {
		E element;
		Node<E> next;

		Node(E element) {
			if (element == null) {
				throw new NullPointerException("Element is null");
			}
			this.element = element;
			this.next = null;
		}
	}
}
