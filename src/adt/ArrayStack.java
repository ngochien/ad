/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

/**
 * Array-Implementierung von dem Interface <tt>Stack</tt>. Ein <tt>ArrayStack</tt> hat eine maximale
 * Größe, die beim Erzeugen des Stacks angegeben werden muss.
 *
 * @author Le
 * @author Nguyen
 */
public class ArrayStack<E> implements Stack<E> {

	/**
	 * Ein Array als interner Speicher des Stacks.
	 */
	private E elements[];

	/**
	 * Index von dem obersten Ende des Stacks.
	 */
	private int topIndex;

	/**
	 * Erzeugt einen leerten Stack mit der angegebenen maximalen Größe.
	 *
	 * @param max maximale Größe des Stacks.
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int max) {
		elements = (E[]) new Object[max];
		topIndex = 0;
	}

	/**
	 * Liefert <tt>true</tt> wenn der Stack keine Elemente enthält.
	 *
	 * @return <tt>true</tt> wenn der Stack keine Elemente enthält.
	 */
	@Override
	public boolean isEmpty() {
		return topIndex <= 0;
	}

	/**
	 * Liefert <tt>true</tt> wenn Anzahl der Elementen in diesem Stack gleich die maximale Größe ist.
	 *
	 * @return
	 */
	public boolean isFull() {
		return topIndex >= elements.length;
	}

	/**
	 * Legt das gegebene Element auf das oberste Ende des Stacks.
	 *
	 * @param element das einzufügende Element.
	 * @throws NullPointerException falls das gegebene Element <tt>null</tt> ist.
	 * @throws IndexOutOfBoundsException falls der Stack voll ist.
	 */
	@Override
	public void push(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (isFull()) {
			throw new IndexOutOfBoundsException();
		}

		elements[topIndex] = element;
		topIndex++;
	}

	/**
	 * Entnimmt das oberste Element des Stacks.
	 *
	 * @throws IndexOutOfBoundsException falls der Stack leer ist.
	 */
	@Override
	public void pop() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		topIndex--;
	}

	/**
	 * Entnimmt das oberste Element des Stacks und liefert das herausgenommene Element zurück.
	 *
	 * @throws IndexOutOfBoundsException falls der Stack leer ist.
	 * @return das oberste Element des Stacks.
	 */
	@Override
	public E top() {
		pop();
		return elements[topIndex];
	}

}
