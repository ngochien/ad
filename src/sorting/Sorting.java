/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package sorting;

/**
 *
 *
 * @author Le
 */
public class Sorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("                    QuickSort                    ");
		System.out.println("-------------------------------------------------");
		System.out.format("%20s%45s\n", "n", "Anzahl der Vergleiche und Swap-Operationen:");

		System.out.println("Average Case: ");
		System.out.println("\nZufaelliges Pivot-Element");
		for (int i = 1; i <= 1000000; i *= 10) {
			QuickSort<Integer> s = new QuickSort<>(new RandomPivot<Integer>());
			Integer[] a = new Integer[i];
			for (int j = 0; j < a.length; j++) {
				a[j] = (int) (Math.random() * i);
			}
			s.sort(a);
		}

		System.out.println("\nLetztes Element als Pivot");
		for (int i = 1; i <= 1000000; i *= 10) {
			QuickSort<Integer> s = new QuickSort<>(new LastAsPivot<Integer>());
			Integer[] a = new Integer[i];
			for (int j = 0; j < a.length; j++) {
				a[j] = (int) (Math.random() * i);
			}
			s.sort(a);
		}

		System.out.println("\nMedian von dem ersten, mittleren und letzten Element als Pivot");
		for (int i = 1; i <= 1000000; i *= 10) {
			QuickSort<Integer> s = new QuickSort<>(new LastAsPivot<Integer>());
			Integer[] a = new Integer[i];
			for (int j = 0; j < a.length; j++) {
				a[j] = (int) (Math.random() * i);
			}
			s.sort(a);
		}

		System.out.println("Worst Case von \"Zufaelliges Pivot-Element\"");
		for (int i = 1; i <= 10000; i *= 10) {
			QuickSort<Integer> s = new QuickSort<>(new LastAsPivot<Integer>());
			Integer[] a = new Integer[i];
			for (int j = 0; j < a.length; j++) {
				a[j] = j;
			}
			s.sort(a);
		}

		System.out.println("Best Case von \"Three-Median-Pivot\"");
		for (int i = 1; i <= 1000000; i *= 10) {
			QuickSort<Integer> s = new QuickSort<>(new ThreeMedianPivot<Integer>());
			Integer[] a = new Integer[i];
			for (int j = 0; j < a.length; j++) {
				a[j] = j;
			}
			s.sort(a);
		}

		// System.out.println("Pivotverfahren testen");
		// for (int i = 1; i <= 1000000; i *= 10) {
		// QuickSort s = new QuickSort();
		// int[] a = new int[i];
		// for (int j = 0; j < a.length; j++) {
		// a[j] = (int) (Math.random() * i);
		// }
		// System.out.format("%d - %d - %d\n", a[0], a[(a.length - 1) / 2],
		// a[a.length - 1]);
		// System.out.println("Pivot: " + s.findPivot(a, 0, a.length - 1));
		// System.out.format("%d - %d - %d\n", a[0], a[(a.length - 1) / 2],
		// a[a.length - 1]);
		// System.out.println();
		// }
	}
}
