/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

import sorting.SortCompetition;

/**
 *
 *
 * @author Le
 */
public class Competition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 1000000;
		int[] mixed = new int[n];
		int[] quick = new int[n];
		int[] radix = new int[n];
		int[] system = new int[n];

		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * (800 * n - 700 * n) + 700 * n + 1);
			mixed[i] = x;
			quick[i] = x;
			radix[i] = x;
			system[i] = x;
		}

		long sQuick = System.currentTimeMillis();
		SortCompetition.quickSort(quick);
		long eQuick = System.currentTimeMillis();
		System.out.println("Time QuickSort: " + (eQuick - sQuick));

		long sMixed = System.currentTimeMillis();
		SortCompetition.mixedSort(mixed);
		long eMixed = System.currentTimeMillis();
		System.out.println("Time MixedSort: " + (eMixed - sMixed));

		long sRadix = System.currentTimeMillis();
		SortCompetition.radixSort(radix);
		long eRadix = System.currentTimeMillis();
		System.out.println("Time RadixSort: " + (eRadix - sRadix));

		// for (int i : quick) {
		// System.out.println(i);
		// }
		// System.out.println();
	}

}
