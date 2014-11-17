/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package sorting;

import java.util.Arrays;



/**
 *
 *
 * @author Le
 */
public class SortingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 100_00_00;
		int[] a = new int[n];
		int[] b = new int[n];
		Integer[] c = new Integer[n];
		int[] d = new int[n];

		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100 * n + 700 * n + 1);
			a[i] = x;
			b[i] = x;
			c[i] = x;
			d[i] = x;
		}

		long start1 = System.currentTimeMillis();
		new MixedSort().sort(a);
		long end1 = System.currentTimeMillis();
		System.out.println("Time MixedSort: " + (end1 - start1));

		long start3 = System.currentTimeMillis();
		new RadixSort().sort(a);
		long end3 = System.currentTimeMillis();
		System.out.println("Time RadixSort: " + (end3 - start3));

		long start2 = System.currentTimeMillis();
		Arrays.sort(b);
		long end2 = System.currentTimeMillis();
		System.out.println("Time SystemSort: " + (end2 - start2));

		long start = System.currentTimeMillis();
		new QuickSort<Integer>(new RandomPivot<Integer>()).sort(c);
		long end = System.currentTimeMillis();
		System.out.println("Time QuickSort: " + (end - start));
	}

}
