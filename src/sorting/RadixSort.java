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
public class RadixSort {

	public void sort(int[] a) {
		int n = a.length;
		int[] tmp = new int[n];
		sort(a, 0, n - 1, 0, tmp);
	}

	// return dth character of s, -1 if d = length of string
	private int getDigit(int i, int d) {
		String s = String.valueOf(i);
		return s.charAt(d) - '0';
	}

	// sort from a[lo] to a[hi], starting at the dth character
	private void sort(int[] a, int left, int right, int d, int[] tmp) {

		// cutoff to insertion sort for small subarrays
		if (right < left) {
			// insertion(a, left, right, d);
			return;
		}

		// compute frequency counts
		int[] count = new int[12];
		for (int i = left; i <= right; i++) {
			int c = getDigit(a[i], d);
			count[c + 2]++;
		}

		// transform counts to indicies
		for (int r = 0; r <= 10; r++) {
			count[r + 1] += count[r];
		}

		// distribute
		for (int i = left; i <= right; i++) {
			int c = getDigit(a[i], d);
			tmp[count[c + 1]++] = a[i];
		}

		// copy back
		for (int i = left; i <= right; i++) {
			a[i] = tmp[i - left];
		}

		// recursively sort for each character
		for (int r = 0; r < 10; r++) {
			sort(a, left + count[r], left + count[r + 1] - 1, d + 1, tmp);
		}
	}

	// insertion sort a[lo..hi], starting at dth character
	private void insertion(int[] a, int left, int right, int d) {
		for (int i = left; i <= right; i++) {
			for (int j = i; j > left && getDigit(a[j], d) < getDigit(a[j - 1], d); j--) {
				exch(a, j, j - 1);
			}
		}
	}

	// exchange a[i] and a[j]
	private static void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// is v less than w, starting at character d
	// private static boolean less(String v, String w, int d) {
	// // assert v.substring(0, d).equals(w.substring(0, d));
	// for (int i = d; i < Math.min(v.length(), w.length()); i++) {
	// if (v.charAt(i) < w.charAt(i)) {
	// return true;
	// }
	// if (v.charAt(i) > w.charAt(i)) {
	// return false;
	// }
	// }
	// return v.length() < w.length();
	// }

}
