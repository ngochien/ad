/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

/**
 * Eine Liste besteht aus einer Folge von Objekten eines bestimmten Grundtyp. Elemente in einer
 * Liste sind beginnend mit 0 durchnummeriert und können durch ihre Integer-Indizes zugegriffen
 * werden. Duplikate von Elementen sind erlaubt.
 *
 * Das <tt>List</tt> Interface bietet Methoden zum Einfügen und Löschen von Elementen an gegebener
 * Position, zum Suchen von Elementen und zum Konkatenieren von zwei Listen.
 *
 * @param <E> der Grundtyp von Elementen in dieser Liste.
 *
 * @author Le
 * @author Nguyen
 */
public interface List<E> {

	/**
	 * Liefert Anzahl der Elementen in dieser Liste zurück.
	 *
	 * @return Anzahl der Elementen in dieser Liste.
	 */
	int size();

	/**
	 * Liefert <tt>true</tt> wenn diese Liste keine Elemente enthält.
	 *
	 * @return <tt>true</tt> wenn diese Liste keine Elemente enthält.
	 */
	boolean isEmpty();

	/**
	 * Fügt das gegebene Element an der gegebenen Position in diese Liste ein. Das aktuelle Element an
	 * dieser Position und alle folgenden Elemente werden nach rechts verschoben und ihre Indizes
	 * erhöhen sich um eins.
	 *
	 * @param index die Position, an der das gegebene Element eingefügt wird.
	 * @param element das einzufügende Element an der gegebenen Position.
	 */
	void insert(int index, E element);

	/**
	 * Löscht das Element an der gegebenen Position. Alle folgenden Elemente werden nach links
	 * verschoben und ihre Indizes verringern sich um eins.
	 *
	 * @param index die Position von dem zu löschenden Element.
	 */
	void delete(int index);

	/**
	 * Liefert die Position von dem ersten Vorkommen von dem gegebenen Element zurück. Falls diese
	 * Liste das gegebene Element nicht enthält, liefert -1 zurück.
	 *
	 * @param element das zu findende Element.
	 * @return die Position von dem ersten Vorkommen von dem gegebenen Element, oder -1, falls diese
	 *         Liste das gegebene Element nicht enthält.
	 */
	int find(E element);

	/**
	 * Liefert das Element an der gegebenen Position zurück.
	 *
	 * @param index die Position von dem zu findende Element.
	 * @return das Element an der gegebenen Position.
	 */
	E retrieve(int index);

	/**
	 * Hängt alle Elemente in der gegebenen Liste ans Ende dieser Liste an. Die Reihenfolge von
	 * Elementen in der gegebenen Liste bleibt unverändert.
	 *
	 * @param otherList die Liste, deren Elemente ans Ende dieser Liste angehängt werden.
	 */
	void concat(List<E> otherList);
}
