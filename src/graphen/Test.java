package graphen;

public class Test {

	public static void main(String[] args) {

		GraphAdjazenzListe<Integer> g = GraphFactory.randomIntGraph(100000, 10000);
		System.out.println(g.getAnzahlKanten());
		System.out.println(g.getAnzahlKnoten());
	}

}
