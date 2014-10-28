/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package complexity;

/**
 * @author Le
 * @author Nguyen
 */
public class AlgorithmTest {

	public static void main(String[] args) {

		System.out.format("%25s%20s%20s\n", "Algorithmus", "Problemgröße", "Aufwand");

		// System.out.println("-----------------------------------------------------------------");
		// for (int i = 1; i <= 35000; i*=2) {
		// Algorithm.simpleTrialDivision(i);
		// }
		//
		// System.out.println("-----------------------------------------------------------------");
		// for (int i = 1; i <= 35000; i *= 2) {
		// Algorithm.improvedTrialDivision(i);
		// }
		//
		// System.out.println("-----------------------------------------------------------------");
		// for (int i = 1; i <= 35000; i *= 2) {
		// Algorithm.sieb(i);
		// }
		//
		// System.out.println("-----------------------------------------------------------------");
		// for (int i = 1; i <= 35000; i *= 2) {
		// Algorithm.isPrime(i);
		// }

		for (int h = 0; h <= 30; h++) {
			Algorithm.reset();
			// System.out.println(Algorithm.recursivePascal(49, 43));
			long[] a = Algorithm.recursivePascalLine(h);
			// System.out.println(Integer.MAX_VALUE);
			System.out.println("Rekursiver, intuitiver Ansatz: " + Algorithm.getCount());
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " - ");
			}
			System.out.println();

			Algorithm.reset();
			long[] a1 = Algorithm.iterativePascal(h);
			// System.out.println(Long.MAX_VALUE);
			System.out.println("Iterativ: " + Algorithm.getCount());
			for (int i = 0; i < a1.length; i++) {
				System.out.print(a1[i] + " - ");
			}
			System.out.println();

			Algorithm.reset();
			long[] a2 = Algorithm.getPascal(h);
			// System.out.println(Long.MAX_VALUE);
			System.out.println("Verbessert Rekursiv: " + Algorithm.getCount());
			for (int i = 0; i < a2.length; i++) {
				System.out.print(a2[i] + " - ");
			}
			System.out.println();

			Algorithm.reset();
			long[] a3 = Algorithm.bestPascalEver(h);
			// System.out.println(Long.MAX_VALUE);
			System.out.println("Schnellste: " + Algorithm.getCount());
			for (int i = 0; i < a3.length; i++) {
				System.out.print(a3[i] + " - ");
			}
			System.out.println();
		}
		Algorithm.reset();
		long[][] aa = new long[101][101];
		System.out.println(Algorithm.get(aa, 25, 7));
		System.out.println("Counter: " + Algorithm.getCount());
	}
}
