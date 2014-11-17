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
public class RandomPivot<T extends Comparable<T>> implements PivotSeeker<T> {

	@Override
	public T get(T[] a, int startIndex, int endIndex) {
		return a[(int) (Math.random() * (endIndex - startIndex)) + startIndex];
	}

}
