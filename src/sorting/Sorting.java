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

		System.out.format("%15s%45s\n", "n", "Anzahl der Vergleiche und Swap-Operationen:");

		// System.out.println("Average Case: ");
		// for (int i = 1; i <= 1000000; i *= 10) {
		// QuickSort s = new QuickSort();
		// int[] a = new int[i];
		// for (int j = 0; j < a.length; j++) {
		// a[j] = (int) (Math.random() * i);
		// }
		// s.sort(a);
		// }
		//
		// System.out.println("Worst Case: ");
		// for (int i = 1; i <= 1000000; i *= 10) {
		// QuickSort s = new QuickSort();
		// int[] a = new int[i];
		// for (int j = 0; j < a.length; j++) {
		// a[j] = j;
		// }
		// s.sort(a);
		// }

		for (int i = 1; i <= 1000000; i *= 10) {
			QuickSort s = new QuickSort();
			int[] a = new int[i];
			for (int j = 0; j < a.length; j++) {
				a[j] = (int) (Math.random() * i);
			}
			System.out.format("%d - %d - %d\n", a[0], a[(a.length - 1) / 2], a[a.length - 1]);
			System.out.println("Pivot: " + s.findPivot(a, 0, a.length - 1));
			System.out.format("%d - %d - %d\n", a[0], a[(a.length - 1) / 2], a[a.length - 1]);
			System.out.println();
		}
	}
}
