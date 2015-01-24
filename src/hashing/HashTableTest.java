package hashing;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HashTableTest {
	
	HashTable hashTab;
	
	String de = "Deutschland";
	String fr = "Frankreich";
	String usa = "United States";
	String cn = "China";
	String uk = "England";
	
	@Before
	public void setUp() throws Exception {
		hashTab = new HashTable(500);
		hashTab.add(de, "DE");
		hashTab.add(fr, "FR");
		hashTab.add(usa, "USA");
		hashTab.add(cn, "CN");
		hashTab.add(uk, "UK");
	}

	@After
	public void tearDown() throws Exception {
		hashTab = new HashTable(5);
	}

	@Test
	public void testGet() {		
		assertEquals("DE", hashTab.get(de));
		assertEquals("FR", hashTab.get(fr));
		assertEquals("USA", hashTab.get(usa));
		assertEquals("CN", hashTab.get(cn));
		assertEquals("UK", hashTab.get(uk));
		
		assertEquals(null, hashTab.get("NO"));
	}

}
