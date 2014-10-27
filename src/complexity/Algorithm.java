/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package complexity;

/**
 * @author Le
 * @author Nguyen
 */
public class Algorithm {

	public static int counter = 0;

	public static void simpleTrialDivision(int n) {
		boolean isPrime[] = new boolean[n];
		int i, j;
		int counter = 0;
		for (i = 0; i < n; i++) {
			isPrime[i] = true;
		}
		for (i = 2; i < n; i++) {
			for (j = 2; j < n; j++) {
				counter++;
				if (i % j == 0 && j != i) {
					isPrime[i] = false;
				}
			}
		}
		System.out.format("%25s%20s%20s\n", "Langsames Primzahl-Suchen", n, counter);
	}

	public static void improvedTrialDivision(int n) {
		boolean isPrime[] = new boolean[n];
		int i, j;
		int counter = 0;
		for (i = 0; i < n; i++) {
			isPrime[i] = true;
		}
		for (i = 2; i < n; i++) {
			for (j = 2; j < i; j++) {
				counter++;
				if (i % j == 0 && j != i) {
					isPrime[i] = false;
				}
			}
		}
		System.out.format("%25s%20s%20s\n", "Schnelles Primzahl-Suchen", n, counter);
	}

	public static void sieb(int n) {
		boolean isPrime[] = new boolean[n];
		int i, j;
		int counter = 0;
		for (i = 0; i < n; i++) {
			isPrime[i] = true;
		}
		for (i = 2; i < Math.sqrt(n); i++) {
			if (isPrime[i] == true) {
				for (j = 2; i * j < n; j++) {
					counter++;
					isPrime[i * j] = false;
				}
			}
		}
		System.out.format("%25s%20s%20s\n", "Sieb des Eratosthenes", n, counter);
	}

	public static boolean isPrime(int n) {
		int counter = 0;
		boolean result = true;
		if (n > 2 && n % 2 == 0) {
			result = false;
		}
		for (int i = 3; i < n; i += 2) {
			counter++;
			if (n % i == 0) {
				result = false;
			}
		}
		System.out.format("%25s%20s%20s\n", "Primzahleigenschaft testen", n, counter);
		return result;
	}

	public static int recursivePascal(int line, int column) {
		if (column == 0 || column == line) {
			// counter++;
			return 1;
		}
		// column = Math.min(column, line - column);
		counter++;
		return recursivePascal(line - 1, column - 1) + recursivePascal(line - 1, column);
	}

	public static int[] recursivePascalLine(int line) {
		int[] a = new int[line + 1];
		for (int i = 0; i <= line; i++) {
			a[i] = recursivePascal(line, i);
		}
		return a;
	}

}
