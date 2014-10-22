/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

/**
 * Einfach verkettete Liste, deren Elemente nicht <tt>null</tt> sein dürfen.
 * Bei allen Operationen werden einfach verketteten Listen immer vom Anfang
 * bis zu einer bestimmten Position durchgelaufen.
 *
 * @param <E> der Grundtyp von Elementen in dieser Liste.
 *
 * @author Le
 * @author Nguyen
 */
public class SinglyLinkedList<E> implements List<E> {

	private int size = 0;

	/**
	 * Zeiger auf den ersten Knoten von dieser Liste.
	 */
	private Node<E> head;

	/**
	 * Erzeugt eine leere Liste.
	 */
	public SinglyLinkedList() {
	}

	/**
	 * Liefert Anzahl der Elementen in dieser Liste zurück.
	 *
	 * @return Anzahl der Elementen in dieser Liste.
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Liefert <tt>true</tt> wenn diese Liste keine Elemente enthält.
	 *
	 * @return <tt>true</tt> wenn diese Liste keine Elemente enthält.
	 */
	@Override
	public boolean isEmpty() {
		return head == null && size <= 0;
	}

	/**
	 * Fügt das gegebene Element an der gegebenen Position in diese Liste ein. Das aktuelle Element an
	 * dieser Position und alle folgenden Elemente werden nach rechts verschoben und ihre Indizes
	 * erhöhen sich um eins.
	 *
	 * Komplexität: O(n), denn im schlimmsten Fall (Einfügen eines Elements am Ende der Liste) muss
	 * diese Liste komplett vom Anfang bis zum Ende durchgelaufen werden.
	 *
	 * @param index die Position, an der das gegebene Element eingefügt wird.
	 * @param element das einzufügende Element an der gegebenen Position.
	 * @throws NullPointerException falls das gegebene Element <tt>null</tt> ist.
	 * @throws IndexOutOfBoundsException falls die gegebene Position ungültig ist.
	 *           <code>(index < 0 || index > size)</code>
	 */
	@Override
	public void insert(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Invalid index: " + index + " Size: " + size);
		}

		System.out.format("%10s%10s", "INSERT", index);

		Node<E> newNode = new Node<E>(element);
		if (isEmpty()) {
			head = newNode;
			System.out.format("%25s\n", 1);
		} else if (index == 0) {
			newNode.next = head;
			head = newNode;
			System.out.format("%25s\n", 1);
		} else {
			Node<E> node = node(index - 1);
			newNode.next = node.next;
			node.next = newNode;
		}
		size++;
	}

	/**
	 * Löscht das Element an der gegebenen Position. Alle folgenden Elemente werden nach links
	 * verschoben und ihre Indizes verringern sich um eins.
	 *
	 * Komplexität: O(n), denn im schlimmsten Fall (Löschen des letzten Elements der Liste) muss diese
	 * Liste komplett vom Anfang bis zum Ende durchgelaufen werden.
	 *
	 * @param index die Position von dem zu löschenden Element.
	 * @throws IndexOutOfBoundsException falls die gegebene Position ungültig ist.
	 *           <code>(index < 0 || index >= size)</code>
	 */
	@Override
	public void delete(int index) {
		checkElementIndex(index);

		System.out.format("%10s%10s", "DELETE", index);

		if (index == 0) {
			head = head.next;
			System.out.format("%25s\n", 1);
		} else {
			Node<E> node = node(index - 1);
			node.next = node.next.next;
		}
		size--;
	}

	/**
	 * Liefert die Position von dem ersten Vorkommen von dem gegebenen Element zurück. Falls diese
	 * Liste das gegebene Element nicht enthält, liefert -1 zurück.
	 *
	 * Komplexität: O(n), denn im schlimmsten Fall (das gesuchte Element ist nicht vorhanden) muss
	 * diese Liste komplett vom Anfang bis zum Ende durchgelaufen werden.
	 *
	 * @param element das zu findende Element.
	 * @return die Position von dem ersten Vorkommen von dem gegebenen Element, oder -1, falls diese
	 *         Liste das gegebene Element nicht enthält.
	 * @throws NullPointerException falls das gegebene Element <tt>null</tt> ist.
	 */
	@Override
	public int find(E element) {
		if (element == null) {
			throw new NullPointerException("Element is null");
		}

		int index = 0;
		for (Node<E> x = head; x != null; x = x.next) {
			if (x.element.equals(element)) {
				System.out.format("%10s%10s%25s\n", "FIND", "", index);
				return index;
			}
			index++;
		}
		System.out.format("%10s%10s%25s\n", "FIND", "", index);
		return -1;
	}

	/**
	 * Liefert das Element an der gegebenen Position zurück.
	 *
	 * Komplexität: O(n), denn im schlimmsten Fall (Finden des letzten Elements) muss diese Liste
	 * komplett vom Anfang bis zum Ende durchgelaufen werden.
	 *
	 * @param index die Position von dem zu findende Element.
	 * @return das Element an der gegebenen Position.
	 * @throws IndexOutOfBoundsException falls die gegebene Position ungültig ist.
	 *           <code>(index < 0 || index >= size)</code>
	 */
	@Override
	public E retrieve(int index) {
		checkElementIndex(index);

		System.out.format("%10s%10s", "RETRIEVE", index);

		return node(index).element;
	}

	/**
	 * Liefert den Knoten an der gegebenen Position zurück.
	 */
	private Node<E> node(int index) {
		// assert index >= 0 && index < size

		Node<E> node = head;
		int counter = 1;
		for (int i = 1; i <= index; i++) {
			node = node.next;
			counter++;
		}
		System.out.format("%25s\n", counter);
		return node;
	}

	/**
	 * Prüft ob die gegebene Position eine gültige Position von einem vorhandenen Element ist.
	 */
	private void checkElementIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index: " + index + " Size: " + size);
		}
	}

	/**
	 * Hängt alle Elemente in der gegebenen Liste ans Ende dieser Liste an. Die Reihenfolge von
	 * Elementen in der gegebenen Liste bleibt unverändert.
	 *
	 * Komplexität: O(n), denn diese Liste muss komplett vom Anfang bis zum Ende durchgelaufen werden.
	 *
	 * @param otherList die Liste, deren Elemente ans Ende dieser Liste angehängt werden.
	 * @throws NullPointerException falls die gegebene Liste <tt>null</tt> ist.
	 * @throws IllegalArgumentException falls die gegebene List dieselbe Liste wie diese ist.
	 */
	@Override
	public void concat(List<E> otherList) {
		if (otherList == null) {
			throw new NullPointerException("otherList is null");
		}
		if (this == otherList) {
			throw new IllegalArgumentException("Cannot concat the same list");
		}

		if (!otherList.isEmpty()) {
			/* Bildet eine Knotenkette aus Elementen von dem gegebenen Liste. */
			Node<E> x = new Node<E>(otherList.retrieve(0));
			Node<E> pointer = x;
			for (int i = 1; i < otherList.size(); i++) {
				pointer.next = new Node<E>(otherList.retrieve(i));
				pointer = pointer.next;
			}
			/* Hängt diese Knotenkette ans Ende dieser Liste. */
			System.out.format("%10s%10s", "CONCAT", "");
			if (isEmpty()) {
				head = x;
			} else {
				node(size - 1).next = x;
			}
			size += otherList.size();
		}
	}

	/**
	 * Jeder Knoten enthält ein Element und einen Zeiger auf den nächsten Knoten.
	 */
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
