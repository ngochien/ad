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
 * @author Le
 */
public class Algorithm {
	public static int counter = 0;

	public static boolean[] bruteforceFindPrimeNumber(int n) {
		boolean isPrimeNumber[] = new boolean[n];
		int i, j;
		int counter = 0;
		for (i = 0; i < n; i++) {
			isPrimeNumber[i] = true;
		}
		for (i = 2; i < n; i++) {
			for (j = 2; j < n; j++) {
				counter++;
				if (i % j == 0 && j != i) {
					isPrimeNumber[j] = false;
				}
			}
		}
		System.out.println("" + counter);
		return isPrimeNumber;
	}

	public static void func() {
		counter++;
	}

	public static void problem_rekursiv(int n) {
		if (n == 1) {
			// System.out.println(counter);
			return; // kein Rechenschritt
		}
		if (n % 2 != 0) {
			n = n - 1;
		}
		func(); // ein Rechenschritt
		problem_rekursiv(n / 2);
		problem_rekursiv(n / 2);
	}

	public static int sum(int n) {
		if (n == 1) {
			return 1;
		}
		counter++;
		return n + sum(n - 1);
	}

}
