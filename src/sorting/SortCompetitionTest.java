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

import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 *
 * @author Le
 */
public class SortCompetitionTest {

	private static int NUMBER_OF_OBJECTS = 10_00_00;

	private static int[] a1 = new int[NUMBER_OF_OBJECTS];
	private static int[] a2 = new int[NUMBER_OF_OBJECTS];
	private static int[] a3 = new int[NUMBER_OF_OBJECTS];
	private static int[] a4 = new int[NUMBER_OF_OBJECTS];

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		for (int i = 0; i < NUMBER_OF_OBJECTS; i++) {
			int randomNumber = (int) (Math.random() * 100 * NUMBER_OF_OBJECTS + 700 * NUMBER_OF_OBJECTS + 1);
			a1[i] = randomNumber;
			a2[i] = randomNumber;
			a3[i] = randomNumber;
			a4[i] = randomNumber;
		}
	}

	@Test
	public void testBlockSort() {
		int[] copy = Arrays.copyOf(a1, NUMBER_OF_OBJECTS);

		SortCompetition.blockSort(a1);
		Arrays.sort(copy);

		assertTrue(Arrays.equals(a1, copy));
	}

	@Test
	public void testQuickSort() {
		int[] copy = Arrays.copyOf(a2, NUMBER_OF_OBJECTS);

		SortCompetition.quickSort(a2);
		Arrays.sort(copy);

		assertTrue(Arrays.equals(a2, copy));
	}

	@Test
	public void testInsertionSort() {
		int[] copy = Arrays.copyOf(a3, NUMBER_OF_OBJECTS);

		SortCompetition.insertionSort(a3);
		Arrays.sort(copy);

		assertTrue(Arrays.equals(a3, copy));
	}

	@Test
	public void testRadixSort() {
		int[] copy = Arrays.copyOf(a4, NUMBER_OF_OBJECTS);

		SortCompetition.radixSort(a4);
		Arrays.sort(copy);

		assertTrue(Arrays.equals(a4, copy));
	}
}
