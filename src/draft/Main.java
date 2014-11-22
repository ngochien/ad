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

	private static void badSwap(int a, int b) {
//		System.out.println(a + " " + b);
		int tmp = a;
		a = b;
		b  = tmp;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Unten u = new Unten();
		u.methode();

		int nn = 12345678;
		for (int j = 0; j < 8; j++) {
			// System.out.println(getDigit(nn, 8, j));
		}

		long[] objs = new long[100];
		int n = objs.length;
		for (int i = 0; i < n; i++) {
			objs[i] = (int) (Math.random() * (800 * n - 700 * n)) + 700 * n;
		}
		for (long i : objs) {
			System.out.println(i);
		}
		int a = 10; int b = 20;
		System.out.println("Pass by what?");
		badSwap(a, b);
		System.out.println(a + " " + b);
	}

}
