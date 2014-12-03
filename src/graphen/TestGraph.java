package graphen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testklasse für das IGraph Interface.
 *
 * @author Philipp Jenke
 *
 */
public class TestGraph {

	/**
	 * Erzeugen der Instanz, die getestet werden soll - hier:
	 * GraphAdjazenzListe.
	 */
	private static IGraph<String> getInstance() {
		return new GraphAdjazenzListe<String>();
	}

	@Test
	public void testGraph() {
		// Leerer Graph
		IGraph<String> graph = getInstance();
		assertEquals(0, graph.getAnzahlKnoten());
		assertEquals(0, graph.getAnzahlKanten());

		// Ein Element
		Knoten<String> A = new Knoten<String>("A");
		graph.addKnoten(A);
		assertEquals(1, graph.getAnzahlKnoten());
		assertEquals(0, graph.getNachbarn(A).size());
		assertEquals(0, graph.getAnzahlKanten());

		// Zwei Elemente
		Knoten<String> B = new Knoten<String>("B");
		graph.addKnoten(B);
		assertFalse(graph.kanteExistiert(A, B));
		assertEquals(2, graph.getAnzahlKnoten());
		double gewichtAB = 22.0;
		graph.addKante(A, B, gewichtAB);
		assertEquals(1, graph.getAnzahlKanten());
		assertTrue(graph.kanteExistiert(A, B));
		assertEquals(1, graph.getNachbarn(A).size());
		assertTrue(graph.getNachbarn(A).contains(B));
		assertEquals(1, graph.getNachbarn(B).size());
		assertTrue(graph.getNachbarn(B).contains(A));
		assertEquals(gewichtAB, graph.getKantenGewicht(A, B), 1e-4);
		assertEquals(gewichtAB, graph.getKantenGewicht(B, A), 1e-4);
		double neuesGewichtAB = 12.5;
		graph.setzeGewicht(A, B, neuesGewichtAB);
		assertEquals(neuesGewichtAB, graph.getKantenGewicht(A, B), 1e-4);
		assertEquals(neuesGewichtAB, graph.getKantenGewicht(B, A), 1e-4);
	}

}
