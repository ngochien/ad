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
public class SortCompetition {

	private static long counter = 0;

	public static void mixedSort(int[] a) {
		counter = 0;

		int n = a.length;


		intList[] blocks = new intList[n];
		for (int i = 0; i < n; i++) {
			blocks[i] = new intList();
			counter++;
		}

		int minKey = 700 * n;
		for (int i = 0; i < n; i++) {
			int blockIndex = (a[i] - minKey) / 100;
			if (blockIndex == n) {
				blockIndex--;
			}
			blocks[blockIndex].add(a[i]);
			counter++;
		}

		int position = 0;
		for (int i = 0; i < n; i++) {
			while (blocks[i].head != null) {
				a[position++] = blocks[i].removeFirst();
				counter++;
			}
			counter++;
		}

		// Insertion sort over the whole array
		for (int i = 0; i < n - 1; i++) {
			int tmp = a[i + 1];
			int j = i;
			while (j >= 0 && tmp < a[j]) {
				a[j + 1] = a[j];
				j--;
				counter++;
			}
			a[j + 1] = tmp;
			counter++;
		}

		System.out.format("%10s%20s%30s\n", "MixedSort:", n, counter);
	}

	public static void quickSort(int[] a) {
		counter = 0;
		quickSort(a, 0, a.length - 1);
		System.out.format("%10s%20s%30s\n", "QuickSort:", a.length, counter);
	}

	private static void quickSort(int[] a, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int rechts = startIndex;
		int links = endIndex;
		int pivotElement = a[startIndex + (endIndex - startIndex) / 2];

		while (rechts <= links) {
			counter++;
			while (a[rechts] - pivotElement < 0) {
				counter++;
				rechts++;
			}
			while (a[links] - pivotElement > 0) {
				counter++;
				links--;
			}
			if (rechts <= links) {
				counter++;
				swap(a, rechts, links);
				rechts++;
				links--;
			}
		}

		quickSort(a, startIndex, links);
		quickSort(a, rechts, endIndex);
	}

	private static void swap(int[] a, int i, int j) {
		if (i != j) {
			counter++;
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}

	public static void radixSort(int[] a) {
		counter = 0;
		radixSort(a, (int) Math.log10(a.length));
		System.out.format("%10s%20s%30s\n", "RadixSort:", a.length, counter);
	}

	private static void radixSort(int[] a, int k) {
		int[] tmp = new int[a.length];
		int mod = 10;
		int dev = 1;
		for (int i = k + 2; i >= 0; i--) {
			// counting ...
			int count[] = new int[10 + 1];
			for (int j = 0; j < a.length; j++) {
				// get last digit of a[j]
				int c = a[j] % mod / dev;
				count[c + 1]++;
				counter++;
			}

			// compute index from count
			for (int j = 0; j < count.length - 1; j++) {
				count[j + 1] += count[j];
				counter++;
			}

			// distribute to tmp
			for (int j = 0; j < a.length; j++) {
				int c = a[j] % mod / dev;
				tmp[count[c]++] = a[j];
				counter++;
			}

			// copy back
			for (int j = 0; j < a.length; j++) {
				a[j] = tmp[j];
				counter++;
			}

			mod *= 10;
			dev *= 10;
		}
	}

	private static class intList {
		int size;
		Node head;

		void add(int k) {
			Node node = new Node(k);
			if (size == 0) {
				head = node;
			} else {
				Node x = head;
				while (x.next != null) {
					x = x.next;
				}
				x.next = node;
			}
			size++;
		}

		int removeFirst() {
			int x = head.key;
			head = head.next;
			size--;
			return x;
		}

		static class Node {
			int key;
			Node next;

			Node(int k) {
				key = k;
			}
		}
	}
}
