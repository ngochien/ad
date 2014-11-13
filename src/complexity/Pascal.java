/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package complexity;

/**
 *
 *
 * @author Le Nguyen
 */
public class Pascal {

	private static long counter = 0;

	private static long getElement(long[][] pascal, int line, int column) {
		if (column == 0 || column == line) {
			return 1;
		}
		if (pascal[line][column] == 0) {
			counter++;
			pascal[line][column] = getElement(pascal, line - 1, column) + getElement(pascal, line - 1, column - 1);
		}
		return pascal[line][column];
	}

	/**
	 * @param line
	 * @return
	 */
	public static long[] recursive(int line) {
		counter = 0;
		long[][] pascal = new long[line + 1][line + 1];
		for (int column = 0; column <= line; column++) {
			pascal[line][column] = getElement(pascal, line, column);
		}
		System.out.format("%20s%10s%30s\n", "Rekursive Berechnung", line, counter);
		return pascal[line];
	}

	/**
	 * @param line
	 * @return
	 */
	public static long[] iterative(int line) {
		counter = 0;
		long[][] pascal = new long[line + 1][];
		for (int i = 0; i <= line; i++) {
			pascal[i] = new long[i + 1];
			pascal[i][0] = 1;
			pascal[i][i] = 1;
		}
		for (int i = 2; i <= line; i++) {
			for (int column = 1; column < i; column++) {
				counter++;
				pascal[i][column] = pascal[i - 1][column] + pascal[i - 1][column - 1];
			}
		}
		System.out.format("%20s%10s%30s\n", "Iterative Berechnung", line, counter);
		return pascal[line];
	}

	/**
	 * @param line
	 * @return
	 */
	public static long[] binomial(int line) {
		counter = 0;
		long[] pascal = new long[line + 1];
		pascal[0] = 1;
		for (int column = 1; column <= line; column++) {
			counter++;
			pascal[column] = pascal[column - 1] * (line - column + 1) / column;
		}
		System.out.format("%20s%10s%30s\n", " Binomialkoeffizient", line, counter);
		return pascal;
	}
}
