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
public class QuickSort implements Sort {

	private long counter;

	/*
	 * (non-Javadoc)
	 *
	 * @see sorting.Sort#sort(int[])
	 */
	@Override
	public void sort(int[] a) {
		sort(a, 0, a.length - 1);
		System.out.format("%15s%30s\n", a.length, counter);
	}

	private void sort(int[] a, int links, int rechts) {
		if (links >= rechts) {
			return;
		}
		int auf = links;
		int ab = rechts;
		int pivot = findPivot(a, links, rechts);

		while (auf <= ab) {
			counter++;
			while (a[auf] < pivot) {
				counter++;
				auf++;
			}
			while (a[ab] > pivot) {
				counter++;
				ab--;
			}
			if (auf <= ab) {
				counter++;
				swap(a, auf, ab);
				auf++;
				ab--;
			}
		}

		sort(a, links, ab);
		sort(a, auf, rechts);
	}

	public int findPivot(int[] a, int links, int rechts) {
		// 1. Pivotsuchverfahren
		// return a[rechts];

		// 2. Pivotsuchverfahren
		int mitte = (links + rechts) / 2;
		int min = links;
		if (a[mitte] < a[min]) {
			counter++;
			min = mitte;
		}
		if (a[rechts] < a[min]) {
			counter++;
			min = rechts;
		}
		swap(a, links, min);
		if (a[mitte] > a[rechts]) {
			counter++;
			swap(a, mitte, rechts);
		}
		return a[mitte];
		// 3. Pivotsuchverfahren
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
