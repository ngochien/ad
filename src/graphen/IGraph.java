/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package graphen;

import java.util.List;

/**
 * Representation eines generischen Graphs.
 *
 * @author Philipp Jenke
 *
 */
public interface IGraph<T> {

	/**
	 * Knoten zufügen
	 */
	public void addKnoten(Knoten<T> node);

	/**
	 * Kante einfügen. Da es sich um einen ungerichteten Graph handelt, ist die
	 * Reihenfolge der Knoten nicht relevant.
	 *
	 * @param firstNode
	 *            Erstes Ende der Kante.
	 * @param secondNode
	 *            Zweites Ende der Kante.
	 */
	public void addKante(Knoten<T> start, Knoten<T> ende, double wert);

	/**
	 * Getter.
	 */
	public int getAnzahlKnoten();

	/**
	 * Getter.
	 */
	public int getAnzahlKanten();

	/**
	 * Getter.
	 */
	public Knoten<T> getKnoten(int nodeIndex);

	/**
	 * Liefert eine Liste der Nachbarn eines Knotens (es gibt also eine Kante
	 * zwischen den beiden Knoten).
	 */
	public List<Knoten<T>> getNachbarn(Knoten<T> node);

	/**
	 * Liefert eine Liste der Indices der Nachbarn eines Knotens (es gibt also
	 * eine Kante zwischen den beiden Knoten).
	 */
	public List<Integer> getNachbarIndices(int nodeIndex);

	/**
	 * Liefert das Gewicht der Kante von Knoten startIndex zu Knoten zielIndex.
	 * Liefert Double.NEGATIVE_INFINITY falls die Kante nicht existiert.
	 */
	public double getKantenGewicht(int startIndex, int zielIndex);

	/**
	 * Liefert das Gewicht der Kante von Knoten startIndex zu Knoten zielIndex.
	 * Liefert Double.NEGATIVE_INFINITY falls die Kante nicht existiert.
	 */
	public double getKantenGewicht(Knoten<T> startKnoten, Knoten<T> zielKnoten);

	/**
	 * Setzen des Wertes des Gewichts der Kanten zwischen den beiden Knoten.
	 */
	public void setzeGewicht(Knoten<T> startKnoten,
			Knoten<T> zielKnoten, double gewicht);

	/**
	 * Liefert wahr, falls die Kante bereits im Graphen ist, ansonsten falsch.
	 * Zum Vergleich der Kanten wird der Wert ignoriert.
	 */
	public boolean kanteExistiert(Knoten<T> startKnoten, Knoten<T> endKnoten);
}
