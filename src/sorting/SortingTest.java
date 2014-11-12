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

		int[] objs = new int[100000];
		int n = objs.length;
		for (int i = 0; i < n; i++) {
			objs[i] = (int) (Math.random() * (800 * n - 700 * n)) + 700 * n;
		}
		int[] a = Arrays.copyOf(objs, n);

		long start = System.currentTimeMillis();
		new RadixSort().sort(objs);
		long end = System.currentTimeMillis();
		System.out.println("Time RadixSort: " + (end - start));

		long start1 = System.currentTimeMillis();
		new QuickSort().sort(a);
		long end1 = System.currentTimeMillis();
		System.out.println("Time QuickSort: " + (end1 - start1));

		// for (int i : objs) {
		// System.out.println(i);
		// try {
		// new FileWriter(new File("/home/h13n/Desktop/array.txt"), true).write(i);
		// ;
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
	}

}
