package graphen;

public class Test {

	public static void main(String[] args) {

		for (int i = 10; i <= 100000; i*= 10) {
			GraphAdjazenzListe<Integer> ig = GraphFactory.randomIntGraph(i, i);
			long start = System.nanoTime();
			new Dijkstra<>(ig, 0);
			long end = System.nanoTime();
			System.out.println(i + "\t\t" + (end-start));
		}		
		
		GraphAdjazenzListe<String> sg = new GraphAdjazenzListe<>();
		
		Knoten<String> a = new Knoten<String>("A");
		Knoten<String> b = new Knoten<String>("B");
		Knoten<String> c = new Knoten<String>("C");
		Knoten<String> d = new Knoten<String>("D");
		Knoten<String> e = new Knoten<String>("E");
		Knoten<String> f = new Knoten<String>("F");
		Knoten<String> g = new Knoten<String>("G");
		
		sg.addKnoten(a);
		sg.addKnoten(b);
		sg.addKnoten(c);
		sg.addKnoten(d);
		sg.addKnoten(e);
		sg.addKnoten(f);
		sg.addKnoten(g);
		
		sg.addKante(a, b, 4.0);
		sg.addKante(a, g, 5.0);
		sg.addKante(a, f, 10.0);
		sg.addKante(f, g, 4.0);
		sg.addKante(g, b, 2.0);
		sg.addKante(c, b, 7.0);
		sg.addKante(g, c, 1.0);
		sg.addKante(f, e, 3.0);
		sg.addKante(g, e, 8.0);
		sg.addKante(c, d, 12.0);
		sg.addKante(e, d, 4.0);
		sg.addKante(a, b, 4.0);
		
		System.out.println(sg);
		
		Dijkstra<String> dij = new Dijkstra<>(sg, 0);
		System.out.println(dij.costTo(1));
		System.out.println(dij.costTo(2));
		System.out.println(dij.costTo(3));
		System.out.println(dij.costTo(4));
		System.out.println(dij.costTo(5));
		System.out.println(dij.costTo(6));
	}

}
