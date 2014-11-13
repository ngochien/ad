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
public class PascalTest {

	public static void main(String[] args) {

		System.out.println("                   Pascal-Dreieck                   ");
		System.out.println("----------------------------------------------------");
		System.out.format("%20s%15s%40s\n", "Algorithmus", "Problemgröße",
				"Zähler (Anzahl der Rechenschritte)");

		for (int line = 0; line <= 5000; line += 1000) {
			Pascal.recursive(line);
		}
		System.out.println();
		for (int line = 0; line <= 5000; line += 1000) {
			Pascal.iterative(line);
		}
		System.out.println();
		for (int line = 0; line <= 5000; line += 1000) {
			Pascal.binomial(line);
		}
	}
}
