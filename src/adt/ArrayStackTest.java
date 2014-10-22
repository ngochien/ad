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
 * Testfälle für die Klasse <tt>ArrayStack</tt>.
 *
 * @author Le
 * @author Nguyen
 */
public class ArrayStackTest {

	private ArrayStack<Integer> integerStack;
	private ArrayStack<String> emptyStringStack;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		integerStack = new ArrayStack<>(1000);
		for (int i = 0; i < 1000; i++) {
			integerStack.push(i);
		}

		emptyStringStack = new ArrayStack<>(1000);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		integerStack = null;
		emptyStringStack = null;
	}

	/**
	 * Test method for {@link adt.ArrayStack#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertFalse(integerStack.isEmpty());
		assertTrue(emptyStringStack.isEmpty());
	}

	/**
	 * Test method for {@link adt.ArrayStack#isFull()}.
	 */
	@Test
	public void testIsFull() {
		assertTrue(integerStack.isFull());
		assertFalse(emptyStringStack.isFull());
	}

	/**
	 * Test method for {@link adt.ArrayStack#push(java.lang.Object)}.
	 */
	@Test
	public void testPush() {
		for (int i = 0; i < 999; i++) {
			emptyStringStack.push(i + "");
		}
		assertFalse(emptyStringStack.isEmpty());
		assertFalse(emptyStringStack.isFull());

		emptyStringStack.push(999 + "");
		assertTrue(emptyStringStack.isFull());

		try {
			integerStack.push(null);
			fail("NullPointerException expected");
		} catch (NullPointerException exc) {
		}

		try {
			integerStack.push(1000);
			fail("IndexOutOfBoundsException expected");
		} catch (IndexOutOfBoundsException exc) {
		}
	}

	/**
	 * Test method for {@link adt.ArrayStack#pop()}.
	 */
	@Test
	public void testPop() {
		for (int i = 0; i < 999; i++) {
			integerStack.pop();
		}
		assertFalse(integerStack.isEmpty());
		assertFalse(integerStack.isFull());

		integerStack.pop();
		assertTrue(integerStack.isEmpty());

		try {
			emptyStringStack.pop();
			fail("IndexOutOfBoundsException expected");
		} catch (IndexOutOfBoundsException exc) {
		}
	}

	/**
	 * Test method for {@link adt.ArrayStack#top()}.
	 */
	@Test
	public void testTop() {
		for (int i = 999; i >= 0; i--) {
			assertEquals(i, (int) integerStack.top());
		}
		assertTrue(integerStack.isEmpty());
	}

}
