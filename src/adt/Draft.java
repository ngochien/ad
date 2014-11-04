/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

		Stack<String> stack;

		Deque<String> deque;

		adt.List<Integer> l1 = new SinglyLinkedList<>();
		adt.List<Integer> l2 = new SinglyLinkedList<>();
		adt.List<String> l3 = new SinglyLinkedList<>();
		for (int i = 0; i < 10; i++) {
			l1.insert(i, i);
		}
		for (int i = 10; i < 30; i++) {
			l2.insert(i - 10, i);
		}

		l1.concat(l2);
		System.out.println(l1.size()); // assert = 20;
		for (int i = 0; i < l1.size(); i++) {
			System.out.print(l1.retrieve(i) + "-");
		}
		System.out.println();

		// l1.delete(5);
		l1.insert(5, 13);
		for (int i = 0; i < l1.size(); i++) {
			System.out.print(l1.retrieve(i) + "-");
		}
		System.out.println("\nSize: " + l1.size());

		l3.insert(0, "Hallo");
		// l1.concat(l3); // error!

		String s = "((2*(13-((9+6)*15)))-(8/(4-2)))";
		String[] sa = s.split("[^0-9]+");
		for (int i = 0; i < sa.length; i++) {
			System.out.println(sa[i]);
		}
		System.out.println(sa.length);
		System.out.println(sa[0].isEmpty());
		for (String string : sa) {
			System.out.println(string);
		}

		int[][] ai = new int[10][10];
		ai[5][6] = 20;
		System.out.println(ai[5][6]);
	}
}
