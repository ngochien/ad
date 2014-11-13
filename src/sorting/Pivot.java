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
public interface Pivot<E extends Comparable<E>> {

	E get(E[] a, int startIndex, int endIndex);
}
