/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testfälle für die Klasse <tt>SinglyLinkedList</tt> (einfach verkettete Liste).
 *
 * @author Le
 * @author Nguyen
 */
public class SinglyLinkedListTest {

	private List<Integer> integerList;
	private List<String> emptyStringList;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		integerList = new SinglyLinkedList<>();
		for (int i = 0; i < 10; i++) {
			integerList.insert(i, i);
		}

		emptyStringList = new SinglyLinkedList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		integerList = null;
		emptyStringList = null;
	}

	/**
	 * Test method for {@link adt.SinglyLinkedList#size()}.
	 */
	@Test
	public void testSize() {
		assertEquals(10, integerList.size());
		assertEquals(0, emptyStringList.size());
	}

	/**
	 * Test method for {@link adt.SinglyLinkedList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertFalse(integerList.isEmpty());
		assertTrue(emptyStringList.isEmpty());
	}

	/**
	 * Test method for {@link adt.SinglyLinkedList#insert(int, java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		integerList.insert(10, 10);
		assertEquals(11, integerList.size());
		assertEquals(10, integerList.find(10));

		emptyStringList.insert(0, "a");
		assertEquals(1, emptyStringList.size());
		assertEquals(0, emptyStringList.find("a"));

		emptyStringList.insert(0, "b");
		assertEquals(2, emptyStringList.size());
		assertEquals(0, emptyStringList.find("b"));
		assertEquals(1, emptyStringList.find("a"));
	}

	/**
	 * Test method for {@link adt.SinglyLinkedList#delete(int)}.
	 */
	@Test
	public void testDelete() {
		integerList.delete(0);
		assertEquals(9, integerList.size());
		assertEquals(0, integerList.find(1));

		for (int i = 0; i < 9; i++) {
			integerList.delete(0);
		}
		assertEquals(0, integerList.size());
		assertTrue(integerList.isEmpty());

		try {
			emptyStringList.delete(0);
			fail("IndexOutOfBoundsException expected");
		} catch (IndexOutOfBoundsException exc) {
		}
	}

	/**
	 * Test method for {@link adt.SinglyLinkedList#find(java.lang.Object)}.
	 */
	@Test
	public void testFind() {
		for (int i = 0; i < 10; i++) {
			assertEquals(i, integerList.find(i));
		}

		assertEquals(-1, integerList.find(10));

		try {
			integerList.find(null);
			fail("NullPointerException expected");
		} catch (NullPointerException exc) {
		}
	}

	/**
	 * Test method for {@link adt.SinglyLinkedList#retrieve(int)}.
	 */
	@Test
	public void testRetrieve() {
		for (int i = 0; i < 10; i++) {
			assertEquals(i, (int) integerList.retrieve(i));
		}

		try {
			emptyStringList.retrieve(0);
			fail("IndexOutOfBoundsException expected");
		} catch (IndexOutOfBoundsException exc) {
		}
	}

	/**
	 * Test method for {@link adt.SinglyLinkedList#concat(adt.List)}.
	 */
	@Test
	public void testConcat() {
		List<Integer> otherList = null;
		try {
			integerList.concat(otherList);
			fail("NullPointerException");
		} catch (NullPointerException exc) {
		}

		otherList = integerList;
		try {
			integerList.concat(otherList);
			fail("IllegalArgumentException");
		} catch (IllegalArgumentException exc) {
		}

		otherList = new SinglyLinkedList<>();
		integerList.concat(otherList);
		assertEquals(10, integerList.size());

		for (int i = 0; i < 10; i++) {
			otherList.insert(i, i);
		}
		integerList.concat(otherList);
		assertEquals(20, integerList.size());
		assertEquals(0, (int) integerList.retrieve(0));
		assertEquals(9, (int) integerList.retrieve(9));
		assertEquals(0, (int) integerList.retrieve(10));
		assertEquals(9, (int) integerList.retrieve(19));

	}

}
