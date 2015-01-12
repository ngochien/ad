/**
 * 
 */
package graphen;

/**
 * @author le
 *
 */
public class GraphFactory {

	// Duplicates of vertices are allowed
	// Parallel edges and self-loops may be present
	public static GraphAdjazenzListe<Integer> randomIntGraph(int vertices, int edges) {
		GraphAdjazenzListe<Integer> graph = new GraphAdjazenzListe<>();
		for (int vertex = 0; vertex < vertices; vertex++) {
			int element = (int) (Math.random() * vertices);
			graph.addKnoten(new Knoten<Integer>(element));
		}
		
		Knoten<Integer> start = graph.getKnoten((int) (Math.random() * vertices));
		Knoten<Integer> end = graph.getKnoten((int) Math.random() * vertices);
		for (int edge = 0; edge < edges; edge++) {			
//			while (graph.kanteExistiert(start, end)) {
//				start = graph.getKnoten((int) (Math.random() * vertices));
//				end = graph.getKnoten((int) (Math.random() * vertices));
//			}
			graph.addKante(start, end, Math.random());
		}
		return graph;
	}
}
