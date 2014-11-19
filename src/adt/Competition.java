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
 * @author Le Nguyen
 */
public class Competition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final int MAX_NUMBER_OF_OBJECTS = 1_00_00_00;
		final int NUMBER_OF_TESTS = 100;
		final int MIN_KEY_FACTOR = 700;
		final int MAX_KEY_FACTOR = 800;

		long[] runtimeBlockSort = new long[NUMBER_OF_TESTS];
		long[] runtimeQuickSort = new long[NUMBER_OF_TESTS];

		System.out.format("%10s%20s%30s\n", "Algorithmus", "Anzahl der Objekte",
				"Rechenzeit in Nanosekunden");
		System.out.println("----------------------------------------------------------------");

		for (int numOfObjects = 10; numOfObjects <= MAX_NUMBER_OF_OBJECTS; numOfObjects *= 10) {

			final int minKey = MIN_KEY_FACTOR * numOfObjects;
			final int maxKey = MAX_KEY_FACTOR * numOfObjects;

			for (int testNr = 0; testNr < NUMBER_OF_TESTS; testNr++) {

				int[] a1 = new int[numOfObjects];
				int[] a2 = new int[numOfObjects];

				for (int i = 0; i < numOfObjects; i++) {
					int randomNumber = (int) (Math.random() * (maxKey - minKey) + minKey + 1);
					a1[i] = randomNumber;
					a2[i] = randomNumber;
				}

				long startOfQuickSort = System.nanoTime();
				SortCompetition.quickSort(a1);
				long endOfQuickSort = System.nanoTime();
				runtimeQuickSort[testNr] = endOfQuickSort - startOfQuickSort;

				long startOfBlockSort = System.nanoTime();
				SortCompetition.blockSort(a2);
				long endOfBlockSort = System.nanoTime();
				runtimeBlockSort[testNr] = endOfBlockSort - startOfBlockSort;
				// System.out.println(Arrays.equals(a1, a2));
			}

			System.out.format("%10s%20s%30s\n", "QuickSort", numOfObjects,
					average(runtimeQuickSort));
			System.out.format("%10s%20s%30s\n", "BlockSort", numOfObjects,
					average(runtimeBlockSort));
			System.out.println("----------------------------------------------------------------");
		}
	}

	private static long average(long[] a) {
		long sum = 0;
		for (long i : a) {
			sum += i;
		}
		return sum / a.length;
	}
}
