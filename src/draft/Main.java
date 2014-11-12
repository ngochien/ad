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

	private static int getDigit(int i, int d) {
		String s = String.valueOf(i);
		return s.charAt(d) - '0';
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Unten u = new Unten();
		u.methode();

		int i = 789456;
		for (int j = 0; j < 6; j++) {
			System.out.println(getDigit(i, j));
		}
	}

}
