/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package draft;

/**
 * @author Le
 */
public class Main {

	private static int getDigit(long i, int n, int d) {
		int x = 1;
		for (int k = 1; k < n - d; k++) {
			x *= 10;
		}
		long j = (i / x) % 10;
		return (int) j;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Unten u = new Unten();
		u.methode();

		int i = 12345678;
		for (int j = 0; j < 8; j++) {
			System.out.println(getDigit(i, 8, j));
		}
	}

}
