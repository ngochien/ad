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
public interface Sort<T extends Comparable<T>> {

	void sort(T[] a);
}
