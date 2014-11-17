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
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

	private long counter = 0;
	private PivotSeeker<T> pivotSeeker;

	public QuickSort(PivotSeeker<T> pivotSeeker) {
		this.pivotSeeker = pivotSeeker;
	}

	public QuickSort() {
	}

	@Override
	public void sort(T[] a) {
		counter = 0;
		sort(a, 0, a.length - 1);
		System.out.format("%20s%30s\n", a.length, counter);
	}

	private void sort(T[] a, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int rechts = startIndex;
		int links = endIndex;
		T pivotElement = pivotSeeker.get(a, startIndex, endIndex);
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

	private void swap(T[] a, int i, int j) {
		if (i != j) {
			counter++;
			T tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}

	public void sort(int[] a) {
		counter = 0;
		sort(a, 0, a.length - 1);
		System.out.format("%%10s%20s%30s\n", "QuickSort", a.length, counter);
	}

	private void sort(int[] a, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int rechts = startIndex;
		int links = endIndex;
		int pivotElement = a[(int) (Math.random() * (endIndex - startIndex)) + startIndex];

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

		sort(a, startIndex, links);
		sort(a, rechts, endIndex);
	}

	private void swap(int[] a, int i, int j) {
		if (i != j) {
			counter++;
			int tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
	}
}
