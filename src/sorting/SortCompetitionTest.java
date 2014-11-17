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

	private static int n = 10000;
	private static int[] mixed = new int[n];
	private static int[] radix = new int[n];
	private static int[] quick = new int[n];
	private static int[] system = new int[n];

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * 100 * n + 700 * n + 1);
			mixed[i] = x;
			radix[i] = x;
			quick[i] = x;
			system[i] = x;
		}
	}

	/**
	 * Test method for {@link sorting.SortCompetition#mixedSort(int[])}.
	 */
	@Test
	public void testMixedSort() {
		int[] copy = Arrays.copyOf(mixed, n);

		SortCompetition.mixedSort(mixed);
		Arrays.sort(copy);

		assertTrue(Arrays.equals(mixed, copy));
	}

	@Test
	public void testQuickSort() {
		int[] copy = Arrays.copyOf(quick, n);

		SortCompetition.quickSort(quick);
		Arrays.sort(copy);

		assertTrue(Arrays.equals(quick, copy));
	}

	@Test
	public void testRadixSort() {
		int[] copy = Arrays.copyOf(radix, n);

		SortCompetition.radixSort(radix);
		Arrays.sort(copy);

		assertTrue(Arrays.equals(radix, copy));
	}

}
