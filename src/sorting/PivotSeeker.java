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
public interface PivotSeeker<T extends Comparable<T>> {

	T get(T[] a, int startIndex, int endIndex);
}
