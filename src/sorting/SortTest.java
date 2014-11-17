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
public class SortTest {

	private int n = 1_00_00_00;

	/**
	 * Test method for {@link sorting.QuickSort#radixSort(E[])}.
	 */
	@Test
	public void testQuickSort() {

		// Random-Array erstellen
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			int x = (int) (Math.random() * 101) * a.length + 700 * a.length;
			a[i] = x;
		}

		// Eine Kopie um nachher zu prüfen
		int[] aCopy = Arrays.copyOf(a, a.length);

		// Den Original-Array mit QuickSort sortieren
		new QuickSort().sort(a);

		// Den Kopie-Array mit Java-Bibliothek soriteren
		Arrays.sort(aCopy);

		// Beide müssen gleich sein!!!
		assertTrue(Arrays.equals(a, aCopy));

		for (int i = 0; i < a.length; i++) {
			assertTrue(a[i] == aCopy[i]);
		}
	}

	@Test
	public void testRadixSort() {

		// Random-Array erstellen
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			int x = (int) (Math.random() * 101) * a.length + 700 * a.length;
			a[i] = x;
		}

		// Eine Kopie um nachher zu prüfen
		int[] aCopy = Arrays.copyOf(a, a.length);

		// Den Original-Array mit QuickSort sortieren
		new RadixSort().sort(a);

		// Den Kopie-Array mit Java-Bibliothek soriteren
		Arrays.sort(aCopy);

		// Beide müssen gleich sein!!!
		assertTrue(Arrays.equals(a, aCopy));

		for (int i = 0; i < a.length; i++) {
			assertTrue(a[i] == aCopy[i]);
		}
	}

	@Test
	public void testInsertionSort() {

		// Random-Array erstellen
		Character[] a = new Character[1000];
		for (int i = 0; i < a.length; i++) {
			int x = (int) (Math.random() * 1000 + 1);
			a[i] = (char) x;
		}

		// Eine Kopie um nachher zu prüfen
		Character[] aCopy = Arrays.copyOf(a, a.length);

		// Den Original-Array mit QuickSort sortieren
		new InsertionSort<Character>().sort(a);

		// Den Kopie-Array mit Java-Bibliothek soriteren
		Arrays.sort(aCopy);

		// Beide müssen gleich sein!!!
		assertTrue(Arrays.equals(a, aCopy));

		for (int i = 0; i < a.length; i++) {
			assertTrue(a[i].equals(aCopy[i]));
		}
	}

	@Test
	public void testMixedSort() {

		// Random-Array erstellen
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			int x = (int) (Math.random() * 101) * a.length + 700 * a.length;
			a[i] = x;
		}

		// Eine Kopie um nachher zu prüfen
		int[] aCopy = Arrays.copyOf(a, a.length);

		// Den Original-Array mit QuickSort sortieren
		// new MixedSort().sort(a);
		SortCompetition.mixedSort(a);

		// Den Kopie-Array mit Java-Bibliothek soriteren
		Arrays.sort(aCopy);

		// Beide müssen gleich sein!!!
		assertTrue(Arrays.equals(a, aCopy));

		for (int i = 0; i < a.length; i++) {
			assertTrue(a[i] == aCopy[i]);
		}
	}

}
