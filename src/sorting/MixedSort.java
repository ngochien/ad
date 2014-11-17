/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package sorting;

import java.util.LinkedList;

/**
 *
 *
 * @author Le
 */
public class MixedSort {

	private long counter = 0;
	private LinkedList<Integer>[] blocks;

	@SuppressWarnings("unchecked")
	public void sort(int[] a) {

		blocks = new LinkedList[a.length];
		for (int i = 0; i < blocks.length; i++) {
			counter++;
			blocks[i] = new LinkedList<Integer>();
		}

		int minKey = 700 * a.length;

		for (int i = 0; i < a.length; i++) {
			counter++;
			int blockNr = (a[i] - minKey) / 100;
			if (blockNr == a.length) {
				blockNr--;
			}
			blocks[blockNr].add(a[i]);
		}

		int pos = 0;
		for (int i = 0; i < blocks.length; i++) {
			counter++;
			while (!(blocks[i].isEmpty())) {
				counter++;
				a[pos++] = blocks[i].removeFirst();
			}
		}

		int i, tmp, j;
		for (i = 0; i < a.length - 1; i++) {
			counter++;
			tmp = a[i + 1];
			for (j = i; j >= 0 && tmp - a[j] < 0; j--) {
				counter++;
				a[j + 1] = a[j];
			}
			a[j + 1] = tmp;
		}

		System.out.format("%20s%30s\n", a.length, counter);
	}

	private void insertionSort(int[] a, int l, int r) {
		for (int i = l; i < r; i++) {
			int tmp = a[i + 1];
			int j;
			for (j = i; j >= l && tmp - a[j] < 0; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = tmp;
		}
	}
}
