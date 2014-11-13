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
public class QuickSort<E extends Comparable<E>> implements Sort<E> {

	private long counter = 0;
	private Pivot<E> pivot;

	public QuickSort(Pivot<E> pivot) {
		this.pivot = pivot;
	}

	@Override
	public void sort(E[] a) {
		counter = 0;
		sort(a, 0, a.length - 1);
		System.out.format("%20s%30s\n", a.length, counter);
	}

	private void sort(E[] a, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int rechts = startIndex;
		int links = endIndex;
		E pivotElement = pivot.get(a, startIndex, endIndex);
		while (rechts <= links) {
			counter++;
			while (a[rechts].compareTo(pivotElement) < 0) {
				counter++;
				rechts++;
			}
			while (a[links].compareTo(pivotElement) > 0) {
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

		sort(a, startIndex, links);
		sort(a, rechts, endIndex);
	}

	private void swap(E[] a, int i, int j) {
		if (i != j) {
			counter++;
			E tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}
}
