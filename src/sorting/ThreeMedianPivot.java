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
public class ThreeMedianPivot<E extends Comparable<E>> implements Pivot<E> {

	@Override
	public E get(E[] a, int startIndex, int endIndex) {
		int mitte = (startIndex + endIndex) / 2;
		int min = startIndex;
		if (a[mitte].compareTo(a[min]) < 0) {
			min = mitte;
		}
		if (a[endIndex].compareTo(a[min]) < 0) {
			min = endIndex;
		}
		swap(a, startIndex, min);
		if (a[mitte].compareTo(a[endIndex]) > 0) {
			swap(a, mitte, endIndex);
		}
		return a[mitte];
	}

	private void swap(E[] a, int i, int j) {
		if (i != j) {
			E tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}
}
