/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package sorting;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 *
 *
 * @author Le Nguyen
 */
public class QuickSortTest {

	/**
	 * Test method for {@link sorting.QuickSort#sort(E[])}.
	 */
	@Test
	public void testSort() {

		// Random-Array erstellen
		Character[] a = new Character[1000];
		for (int i = 0; i < a.length; i++) {
			int x = (int) (Math.random() * 1000 + 1);
			a[i] = (char) x;
		}

		// Eine Kopie um nachher zu prüfen
		Character[] aCopy = Arrays.copyOf(a, a.length);

		// Den Original-Array mit QuickSort sortieren
		new QuickSort<Character>(new RandomPivot<Character>()).sort(a);

		// Den Kopie-Array mit Java-Bibliothek soriteren
		Arrays.sort(aCopy);

		// Beide müssen gleich sein!!!
		assertTrue(Arrays.equals(a, aCopy));

		for (int i = 0; i < a.length; i++) {
			assertTrue(a[i].equals(aCopy[i]));
		}
	}

}
