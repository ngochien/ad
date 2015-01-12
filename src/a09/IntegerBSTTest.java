/**
 * 
 */
package a09;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author le
 *
 */
public class IntegerBSTTest {

	IntegerBST bst;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bst = new IntegerBST();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		bst = null;
	}

	/**
	 * Test method for {@link a09.IntegerBST#IntegerBST()}.
	 */
	@Test
	public void testIntegerBST() {;
		assertTrue(bst.isEmpty());
	}

	/**
	 * Test method for {@link a09.IntegerBST#insert(int)}.
	 */
	@Test
	public void testInsert() {
		bst.insert(8);
		assertFalse(bst.isEmpty());
		assertTrue(bst.sum() == 8);
		
		bst.insert(4);
		assertTrue(bst.sum() == 12);
		
		bst.insert(12);
		System.out.println(bst.sum());
		assertTrue(bst.sum() == 24);
		
		bst.insert(2);
		System.out.println(bst.sum());
		assertTrue(bst.sum() == 26);
		
		bst.insert(6);
		System.out.println(bst.sum());
		assertTrue(bst.sum() == 32);
		
		bst.insert(10);
		System.out.println(bst.sum());
		assertTrue(bst.sum() == 42);
		
		bst.insert(14);
		System.out.println(bst.sum());
		assertTrue(bst.sum() == 56);
		
		bst.insert(14);
		System.out.println(bst.sum());
		assertTrue(bst.sum() == 56);
	}
	
	@Test
	public void testLCA() {
		bst.insert(8);		
		bst.insert(4);				
		bst.insert(12);				
		bst.insert(2);		
		bst.insert(6);
		bst.insert(10);		
		bst.insert(14);
		bst.insert(14);
		assertFalse(bst.isEmpty());
		
		assertEquals(bst.valueLCA(2, 14), 8);
		assertEquals(bst.sumLCA(2, 14), 56);
		
		assertEquals(bst.valueLCA(2, 10), 8);
		assertEquals(bst.sumLCA(2, 10), 56);
		
		assertEquals(bst.valueLCA(2, 12), 8);
		assertEquals(bst.sumLCA(2, 12), 56);
		
		assertEquals(bst.valueLCA(2, 8), 8);
		
		assertEquals(bst.valueLCA(2, 6), 4);
		assertEquals(bst.sumLCA(2, 6), 12);
		
		assertEquals(bst.valueLCA(2, 4), 4);
		
		assertEquals(bst.valueLCA(4, 6), 4);
		assertEquals(bst.sumLCA(4, 6), 12);
		
		assertEquals(bst.valueLCA(10, 12), 12);
		assertEquals(bst.sumLCA(12, 10), 36);
		
		assertEquals(bst.valueLCA(14, 8), 8);
		assertEquals(bst.valueLCA(14, 10), 12);
		assertEquals(bst.valueLCA(6, 12), 8);
	}
	
	@Test
	public void testMin() {
		bst.insert(8);		
		bst.insert(4);				
		bst.insert(12);				
		bst.insert(2);		
		bst.insert(6);
		bst.insert(10);		
		bst.insert(14);
		bst.insert(14);
		assertFalse(bst.isEmpty());
		
		assertEquals(bst.min(0), 2);
		assertEquals(bst.min(1), 2);
		assertEquals(bst.min(2), 2);
		assertEquals(bst.min(3), 4);
		assertEquals(bst.min(4), 4);
		assertEquals(bst.min(5), 6);
		assertEquals(bst.min(6), 6);
		assertEquals(bst.min(7), 8);
		assertEquals(bst.min(8), 8);
		assertEquals(bst.min(9), 10);
		assertEquals(bst.min(10), 10);
		assertEquals(bst.min(11), 12);
		assertEquals(bst.min(12), 12);
		assertEquals(bst.min(13), 14);
		assertEquals(bst.min(14), 14);
		assertEquals(bst.min(15), 0);
	}
	
	@Test
	public void testMax() {
		bst.insert(8);		
		bst.insert(4);				
		bst.insert(12);				
		bst.insert(2);		
		bst.insert(6);
		bst.insert(10);		
		bst.insert(14);
		bst.insert(14);
		assertFalse(bst.isEmpty());
		
		assertEquals(bst.max(0), 0);
		assertEquals(bst.max(1), 0);
		assertEquals(bst.max(2), 2);
		assertEquals(bst.max(3), 2);
		assertEquals(bst.max(4), 4);
		assertEquals(bst.max(5), 4);
		assertEquals(bst.max(6), 6);
		assertEquals(bst.max(7), 6);
		assertEquals(bst.max(8), 8);
		assertEquals(bst.max(9), 8);
		assertEquals(bst.max(10), 10);
		assertEquals(bst.max(11), 10);
		assertEquals(bst.max(12), 12);
		assertEquals(bst.max(13), 12);
		assertEquals(bst.max(14), 14);
		assertEquals(bst.max(15), 14);
	}

	@Test
	public void testSum() {
		bst.insert(1);
		bst.insert(8);		
		bst.insert(4);				
		bst.insert(12);				
		bst.insert(2);		
		bst.insert(6);
		bst.insert(10);		
		bst.insert(14);
		bst.insert(15);
		bst.insert(16);
		bst.insert(3);
		bst.insert(5);
		bst.insert(7);
		bst.insert(9);
		bst.insert(11);
		bst.insert(13);
		assertFalse(bst.isEmpty());
		
		assertEquals(bst.sum(5, 12), 68);
		assertEquals(bst.sum(8, 9), 17);
		assertEquals(bst.sum(5, 10), 45);
		assertEquals(bst.sum(0, 1), 1);
		assertEquals(bst.sum(0, 2), 3);
		assertEquals(bst.sum(2, 8), 35);
		assertEquals(bst.sum(8, 7), 15);
		assertEquals(bst.sum(2, 3), 5);
		assertEquals(bst.sum(2, 6), 20);
		assertEquals(bst.sum(-5, 9), 45);
		assertEquals(bst.sum(14, 11), 50);
		assertEquals(bst.sum(3, 9), 42);
		assertEquals(bst.sum(11, 8), 38);
		assertEquals(bst.sum(16, 18), 16);
		assertEquals(bst.sum(16, -1), 136);
		assertEquals(bst.sum(9, 8), 17);
	}
	
	@Test
	public void testRuntime() {
		for (int i = 0; i < 1000; i++) {
			bst.insert((int) (Math.random() * Integer.MAX_VALUE + 1));
		}
		
		assertFalse(bst.isEmpty());
//		System.out.println(bst.sum(0, 10));
	}
}
