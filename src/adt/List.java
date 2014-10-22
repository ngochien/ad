/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

/**
 * Eine Liste besteht aus einer Folge von Objekten eines bestimmten Grundtyp. Elemente einer Liste
 * sind beginnend mit 0 durchnummeriert und können durch ihre Integer-Indizes zugegriffen werden.
 * Duplikate von Elementen sind erlaubt.
 * <p>
 * Das <tt>List</tt> Interface bietet Methoden zum Einfügen und Löschen von Elementen an gegebener
 * Position, zum Suchen von Elementen und zum Konkatenieren von zwei Listen.
 * <p>
 * 
 * @param <E> Der Grundtyp von Elementen in der Liste.
 *
 * @author Le
 * @author Nguyen
 */
public interface List<E> {

	/**
	 * Liefert Anzahl der Elementen in dieser Liste zurück.
	 * <p>
	 * 
	 * @return Anzahl der Elementen in dieser Liste.
	 */
	int size();

	/**
	 * Liefert <tt>true</tt> wenn dieser Liste keine Elemente enthält.
	 * <p>
	 * 
	 * @return <tt>true</tt> wenn dieser Liste keine Elemente enthält.
	 */
	boolean isEmpty();

	/**
	 * Fügt das gegebene Element an der gegebenen Position in diese Liste ein. Das aktuelle Element an
	 * dieser Position und alle folgenden Elemente werden nach rechts verschoben und ihre Indizes
	 * erhöhen sich um eins.
	 * <p>
	 * 
	 * @param index die Position, an der das gegebene Element eingefügt wird.
	 * @param element das einzufügene Element an der gegebenen Position.
	 */
	void insert(int index, E element);

	/**
	 * Löscht das Element an der gegebenen Position. Alle folgenden Elemente werden nach links
	 * verschoben und ihre Indizes verringern sich um eins.
	 * <p>
	 * 
	 * @param index die Position von dem zu löschenden Element.
	 */
	void delete(int index);

	/**
	 * Liefert die Position von dem ersten Vorkommen von dem gegebenen Element zurück. Falls diese
	 * Liste das gegebene Element nicht enthält, liefert -1 zurück.
	 * <p>
	 * 
	 * @param element das zu findene Element.
	 * @return die Position von dem ersten Vorkommen von dem gegebenen Element, oder -1, falls diese
	 *         Liste das gegebene Element nicht enthält.
	 */
	int find(E element);

	/**
	 * Liefert das Element an der gegebenen Position zurück.
	 *
	 * @param index die Position von dem zu findene Element.
	 * @return das Element an der gegebenen Position.
	 */
	E retrieve(int index);

	/**
	 *
	 * @param otherList
	 */
	void concat(List<E> otherList);
}
