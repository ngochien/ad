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

		// int nrOfTests = 1;
		//
		// for (int n = 10; n <= 1_000000; n *= 10) {
		//
		// long[] runtimeMixedSort = new long[nrOfTests];
		// long[] runtimeQuickSort = new long[nrOfTests];
		// long[] runtimeRadixSort = new long[nrOfTests];
		//
		// for (int i = 0; i < nrOfTests; i++) {
		//
		// // int[] h = { 7975, 7739, 7138, 7485, 7614, 7336, 7852, 7569, 7058, 7272 };
		//
		// int[] a1 = new int[n];
		// int[] a2 = new int[n];
		// int[] a3 = new int[n];
		//
		// for (int j = 0; j < n; j++) {
		// int x = (int) (Math.random() * 100 * n + 700 * n + 1);
		// a1[j] = x;
		// a2[j] = x;
		// a3[j] = x;
		// }
		//
		// long start1 = System.nanoTime();
		// SortCompetition.mixedSort(a1);
		// long end1 = System.nanoTime();
		// runtimeMixedSort[i] = end1 - start1;
		//
		// long start2 = System.nanoTime();
		// SortCompetition.quickSort(a2);
		// long end2 = System.nanoTime();
		// runtimeQuickSort[i] = end2 - start2;
		//
		// long start3 = System.nanoTime();
		// SortCompetition.radixSort(a3);
		// long end3 = System.nanoTime();
		// runtimeRadixSort[i] = end3 - start3;
		// }
		//
		// System.out.format("%10s%20s%30s millis\n", "MixedSort:", n, average(runtimeMixedSort));
		// System.out.format("%10s%20s%30s millis\n", "QuickSort:", n, average(runtimeQuickSort));
		// System.out.format("%10s%20s%30s millis\n", "RadixSort:", n, average(runtimeRadixSort));
		// System.out.println("----------------------------------------------------------------");
		// }

		int n = 1000000;
		int[] mixed = new int[n];
		int[] quick = new int[n];
		int[] radix = new int[n];
		int[] m = new int[n];

		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100 * n + 700 * n + 1);
			mixed[i] = x;
			quick[i] = x;
			radix[i] = x;
			m[i] = x;
		}

		long sM = System.currentTimeMillis();
		SortCompetition.mSort(m);
		long eM = System.currentTimeMillis();
		System.out.println("Time MSort: " + (eM - sM));

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

		// for (int i : mixed) {
		// System.out.print(i + " - ");
		// }
		// System.out.println();
	}

	private static long average(long[] a) {
		long sum = 0;
		for (long i : a) {
			sum += i;
		}
		return sum / a.length;
	}
}
