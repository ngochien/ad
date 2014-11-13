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

	public void sort(long[] a, int n, int k) {
		long[] tmp = new long[a.length];
		int counter = 0;
		int mod = 10;
		int dev = 1;
		for (int i = k + 2; i >= 0; i--) {
			// counting ...
			int count[] = new int[10 + 1];
			for (int j = 0; j < a.length; j++) {
				// get last digit of a[j]
				int c = (int) (a[j] % mod / dev);
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
				int c = (int) (a[j] % mod / dev);
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
		System.out.format("%15s%30s\n", a.length, counter);
	}
}