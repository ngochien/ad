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
 * @author Le Nguyen
 */
public class SortCompetition {

	public static void blockSort(int[] a) {
		int[] count = new int[a.length + 1];
		int[] aux = new int[a.length];

		// counting
		for (int i = 0; i < a.length; i++) {
			int x = (a[i] - 700 * a.length) / 100;
			if (x == a.length) {
				x--;
			}
			count[x + 1]++;
		}

		// compute index from count[]
		for (int i = 0; i < count.length - 1; i++) {
			count[i + 1] += count[i];
		}

		// distribute to aux[]
		for (int i = 0; i < a.length; i++) {
			int x = (a[i] - 700 * a.length) / 100;
			if (x == a.length) {
				x--;
			}
			aux[count[x]++] = a[i];
		}

		// copy back
		for (int i = 0; i < a.length; i++) {
			a[i] = aux[i];
		}

		insertionSort(a, 0, a.length - 1);
	}

	public static void insertionSort(int[] a) {
		insertionSort(a, 0, a.length - 1);
	}

	private static void insertionSort(int[] a, int l, int r) {
		for (int i = l; i <= r - 1; i++) {
			int tmp = a[i + 1];
			int j = i;
			while (j >= 0 && tmp < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = tmp;
		}
	}

	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	private static void quickSort(int[] a, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}

		int rechts = startIndex;
		int links = endIndex;
		int pivotElement = a[startIndex + (endIndex - startIndex) / 2];

		while (rechts <= links) {
			while (a[rechts] - pivotElement < 0) {
				rechts++;
			}
			while (a[links] - pivotElement > 0) {
				links--;
			}
			if (rechts <= links) {
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
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}

	public static void radixSort(int[] a) {
		radixSort(a, (int) Math.log10(a.length));
		// System.out.format("%10s%20s%30s\n", "RadixSort:", a.length, counter);
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
			}

			// compute index from count
			for (int j = 0; j < count.length - 1; j++) {
				count[j + 1] += count[j];
			}

			// distribute to tmp
			for (int j = 0; j < a.length; j++) {
				int c = a[j] % mod / dev;
				tmp[count[c]++] = a[j];
			}

			// copy back
			for (int j = 0; j < a.length; j++) {
				a[j] = tmp[j];
			}

			mod *= 10;
			dev *= 10;
		}
	}
}
