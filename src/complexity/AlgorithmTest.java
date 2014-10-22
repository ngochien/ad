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
public class AlgorithmTest {

	public static void main(String[] args) {

		System.out.format("%25s%20s%20s\n", "Methode", "Problemgröße", "Aufwand");

		System.out.println("-----------------------------------------------------------------");
		for (int i = 1; i <= 35000; i*=2) {
			Algorithm.simpleTrialDivision(i);
		}

		System.out.println("-----------------------------------------------------------------");
		for (int i = 1; i <= 35000; i *= 2) {
			Algorithm.improvedTrialDivision(i);
		}

		System.out.println("-----------------------------------------------------------------");
		for (int i = 1; i <= 35000; i *= 2) {
			Algorithm.sieb(i);
		}

		System.out.println("-----------------------------------------------------------------");
		for (int i = 1; i <= 35000; i *= 2) {
			Algorithm.isPrime(i);
		}
	}

}
