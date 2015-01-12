package graphen;

/**
 * 
 */

/**
 * @author le
 *
 */
public class Dijkstra<T> {

	private Knoten<T>[] predecessors;
	private double[] costs;
	private boolean[] marked;
	private KeyValueBST<Integer, Double> r; // Die Randmenge R - Irgendeine
											// Datenstruktur, die Methode zum
											// Löschen des kleinsten Elements
											// bietet.

	@SuppressWarnings("unchecked")
	public Dijkstra(IGraph<T> graph, int source) {
		predecessors = new Knoten[graph.getAnzahlKnoten()];
		costs = new double[graph.getAnzahlKnoten()];
		marked = new boolean[graph.getAnzahlKnoten()];

		for (int i = 0; i < costs.length; i++) {
			costs[i] = Double.POSITIVE_INFINITY;
		}
		predecessors[source] = graph.getKnoten(source);
		costs[source] = 0.0;
		// marked[source] = true;

		r = new KeyValueBST<>();
		r.insert(source, costs[source]);
		for (int vertex : graph.getNachbarIndices(source)) {
			r.insert(vertex, costs[vertex]);
		}

		while (!r.isEmpty()) {
			int v = r.deleteMin(); // entferne den Knoten mit dem
									// minimalen-Kosten zu source und return
									// dessen key zurück
			marked[v] = true;
			for (int k : graph.getNachbarIndices(v)) {
				if (!marked[k]) {
					if (costs[k] > costs[v] + graph.getKantenGewicht(v, k)) {
						costs[k] = costs[v] + graph.getKantenGewicht(v, k);
					}
					r.insert(k, costs[k]);
				}
				/*
				 * TODO: für jeden dieser Knoten κ finde heraus, ob κ.cost >
				 * ν.cost + c(ν, κ). Wenn dem so ist, dann setze κ.cost = ν.cost
				 * + c(ν, κ) und κ.pred = ν. 3. nimm κ in R mit auf.
				 */
			}
		}
	}

	public double costTo(int target) {
		return costs[target];
	}
}
