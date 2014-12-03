/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package graphen;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a generic (unordered) graph.
 *
 * @author Philipp Jenke
 *
 */

public class GraphAdjazenzListe<T> implements IGraph<T> {

	/**
	 * Innere Klasse, um eine Kante zu repräsentieren.
	 *
	 * @author Philipp Jenke
	 *
	 */
	private class Kante {
		/**
		 * Wert der Kante
		 */
		private double wert = Double.POSITIVE_INFINITY;

		/**
		 * Index des anderen Endes der Kante.
		 */
		private int zielKnoten = -1;

		/**
		 * Konstruktor.
		 */
		public Kante(int zielKnoten, double wert) {
			this.zielKnoten = zielKnoten;
			this.wert = wert;
		}

		/**
		 * Getter.
		 */
		public double getWert() {
			return wert;
		}

		/**
		 * Getter.
		 */
		public int getZielKnotenIndex() {
			return zielKnoten;
		}

		/**
		 * Setter.
		 */
		public void setGewicht(double gewicht) {
			this.wert = gewicht;
		}
	}

	/**
	 * Liste der Knoten im Graphen
	 */
	private final List<Knoten<T>> knoten = new ArrayList<Knoten<T>>();

	/**
	 * Liste der Kanten-Listen. Es gibt so viele Kanten-Listen, wie es Knoten
	 * gibt. Jede Kanten-Liste ist wieder eine Liste in dem Fall von Kanten, die
	 * von dem ensprechenden Knoten ausgehen.
	 */
	private final List<List<Kante>> kanten = new ArrayList<List<Kante>>();

	/**
	 * Konstruktor.
	 */
	public GraphAdjazenzListe() {

	}

	@Override
	public void addKnoten(Knoten<T> node) {
		knoten.add(node);
	}

	@Override
	public void addKante(Knoten<T> start, Knoten<T> ende, double wert) {

		int firstNodeIndex = knoten.indexOf(start);
		int secondNodeIndex = knoten.indexOf(ende);

		while (kanten.size() <= firstNodeIndex
				|| kanten.size() <= secondNodeIndex) {
			kanten.add(new ArrayList<Kante>());
		}

		if (firstNodeIndex >= 0 && secondNodeIndex >= 0) {
			kanten.get(firstNodeIndex).add(new Kante(secondNodeIndex, wert));
			kanten.get(secondNodeIndex).add(new Kante(firstNodeIndex, wert));
		}
	}

	@Override
	public int getAnzahlKnoten() {
		return knoten.size();
	}

	@Override
	public int getAnzahlKanten() {
		int anzahlKanten = 0;
		for (List<Kante> kantenListe : kanten) {
			anzahlKanten += kantenListe.size();
		}
		// Jeder Kante kommt doppelt vor, daher /2.
		return anzahlKanten / 2;
	}

	@Override
	public Knoten<T> getKnoten(int nodeIndex) {
		return knoten.get(nodeIndex);
	}

	@Override
	public List<Knoten<T>> getNachbarn(Knoten<T> node) {
		List<Knoten<T>> neighbors = new ArrayList<Knoten<T>>();
		int index = knoten.indexOf(node);
		if (index < 0) {
			return neighbors;
		}
		List<Integer> n = getNachbarIndices(index);
		for (Integer i : n) {
			neighbors.add(knoten.get(i));
		}
		return neighbors;
	}

	@Override
	public List<Integer> getNachbarIndices(int nodeIndex) {
		List<Integer> neighbors = new ArrayList<Integer>();
		if (nodeIndex < 0 || nodeIndex >= kanten.size()) {
			return neighbors;
		}
		for (Kante edge : kanten.get(nodeIndex)) {
			neighbors.add(edge.getZielKnotenIndex());
		}
		return neighbors;
	}

	@Override
	public double getKantenGewicht(int startIndex, int zielIndex) {
		for (Kante edge : kanten.get(startIndex)) {
			if (zielIndex == edge.getZielKnotenIndex()) {
				return edge.getWert();
			}
		}
		return Double.NEGATIVE_INFINITY;
	}

	@Override
	public double getKantenGewicht(Knoten<T> startKnoten, Knoten<T> zielKnoten) {
		return getKantenGewicht(knoten.indexOf(startKnoten),
				knoten.indexOf(zielKnoten));
	}

	@Override
	public void setzeGewicht(Knoten<String> startKnoten,
			Knoten<String> zielKnoten, double gewicht) {

		int indexStartKnoten = knoten.indexOf(startKnoten);
		int indexZielKnoten = knoten.indexOf(zielKnoten);

		Kante kanteStartZiel = getKante(indexStartKnoten, indexZielKnoten);
		if (kanteStartZiel != null) {
			kanteStartZiel.setGewicht(gewicht);
		}
		Kante kanteZielStart = getKante(indexZielKnoten, indexStartKnoten);
		if (kanteZielStart != null) {
			kanteZielStart.setGewicht(gewicht);
		}
	}

	/**
	 * Liefert die Kante zwischen dem Start- und Zielknotenindex. Liefert null,
	 * wenn die Kante nicht gefunden wurde.
	 */
	private Kante getKante(int indexStartKnoten, int indexZielKnoten) {

		if (indexStartKnoten < 0 || indexStartKnoten >= kanten.size()
				|| indexZielKnoten < 0 || indexZielKnoten >= kanten.size()) {
			return null;
		}

		for (Kante kante : kanten.get(indexStartKnoten)) {
			if (kante.getZielKnotenIndex() == indexZielKnoten) {
				return kante;
			}
		}
		return null;
	}

	@Override
	public boolean kanteExistiert(Knoten<T> startKnoten, Knoten<T> endKnoten) {
		int startIndex = knoten.indexOf(startKnoten);
		int endIndex = knoten.indexOf(endKnoten);
		return getKante(startIndex, endIndex) != null;
	}

	@Override
	public String toString() {
		return "Graph (AdjazenzListe), #Knoten: " + getAnzahlKnoten()
				+ ", #Kanten: " + getAnzahlKanten();
	}
}
