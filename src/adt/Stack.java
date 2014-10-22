/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

/**
 * Der abstrakte Datentyp Stack realisiert einen LIFO-Speicher (Last-In-First-Out). Bei einem Stack
 * wird nur am Ende eingefügt und auch nur am Ende entnommen. Das Interface <tt>Stack</tt> bietet
 * also nur die Zugriffsfunktionen am obersten Ende.
 *
 * @param <E> der Grundtyp von Elementen in diesem Stack.
 *
 * @author Le
 * @author Nguyen
 */
public interface Stack<E> {

	/**
	 * Liefert <tt>true</tt> wenn der Stack keine Elemente enthält.
	 *
	 * @return <tt>true</tt> wenn der Stack keine Elemente enthält.
	 */
	boolean isEmpty();

	/**
	 * Legt das gegebene Element auf das oberste Ende des Stacks.
	 *
	 * @param element das einzufügende Element.
	 */
	void push(E element);

	/**
	 * Entnimmt das oberste Element des Stacks.
	 */
	void pop();

	/**
	 * Entnimmt das oberste Element des Stacks und liefert das herausgenommene Element zurück.
	 *
	 * @return das oberste Element des Stacks.
	 */
	E top();
}
