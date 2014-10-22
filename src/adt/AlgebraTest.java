/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 *
 * @author Le
 * @author Nguyen
 */
public class AlgebraTest {

	/**
	 * Test method for {@link adt.Algebra#algebraicExpression(java.lang.String)}.
	 */
	@Test
	public void testAlgebraicExpression() {
		String expression = "((2 * (13 - ((9 + 6) * 15))) - (8 / (4 - 2)))";
		assertEquals(-428, Algebra.algebraicExpression(expression));
		String s1 = "((6 * (4 + 2)) + (5 - 1))";
		assertEquals(40, Algebra.algebraicExpression(s1));
		String s2 = "(((1 + 2) * 3) - (7 * 8))";
		assertEquals(-47, Algebra.algebraicExpression(s2));
	}

}
