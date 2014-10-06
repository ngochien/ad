/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Le
 */
public class Draft {

	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			System.out.println(i);
		}
		List<String> l = new LinkedList<>();
		ArrayList<String> ar;
		// System.out.println(l.equals(null));
		SinglyLinkedList<String> sl = new SinglyLinkedList<>();
		System.out.println(sl.getClass().getName().equals("adt.SinglyLinkedList"));
		System.out.println(!(sl instanceof SinglyLinkedList<?>));
	}
}
