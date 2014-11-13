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
public class LastAsPivot<E extends Comparable<E>> implements Pivot<E> {

	@Override
	public E get(E[] a, int startIndex, int endIndex) {
		return a[endIndex];
	}

}
