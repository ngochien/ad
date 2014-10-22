/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

/**
 *
 *
 * @author Le
 */
public class ComplexityTest {

	public static void main(String[] args) {

		System.out.format("%10s%10s%25s\n", "Methode", "Position", "Anzahl der Operationen");

		List<Integer> integerList = new SinglyLinkedList<>();

		System.out.println("--------------------------------------------------------------");
		for (int i = 0; i < 1024; i++) {
			integerList.insert(i, i);
		}

		System.out.println("--------------------------------------------------------------");
		for (int i = 1; i < 1024; i *= 2) {
			integerList.find(i);
		}

		System.out.println("--------------------------------------------------------------");
		for (int i = 1; i < 1024; i *= 2) {
			integerList.retrieve(i);
		}

		System.out.println("--------------------------------------------------------------");
		List<Integer> otherList = new SinglyLinkedList<>();
		for (int i = 0; i < 10; i++) {
			otherList.insert(i, i);
		}
		integerList.concat(otherList);

		System.out.println("--------------------------------------------------------------");
		for (int i = 1; i < 1024; i *= 2) {
			integerList.delete(1023 - i);
		}
	}

}
