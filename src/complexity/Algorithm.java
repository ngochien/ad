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

	private static long counter = 0;

	public static void simpleTrialDivision(int n) {
		boolean isPrime[] = new boolean[n];
		int i, j;
		counter = 0;
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
		counter = 0;
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
		counter = 0;
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
		counter = 0;
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
}
