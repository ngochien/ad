package sorting;

/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */

/**
 *
 *
 * @author Le
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

	@Override
	public void sort(T[] a) {
		sort(a, 0, a.length - 1);
	}

	private void sort(T[] a, int l, int r) {
		for (int i = l; i < r; i++) {
			T tmp = a[i + 1];
			int j;
			for (j = i; j >= l && tmp.compareTo(a[j]) < 0; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = tmp;
		}
	}

}
