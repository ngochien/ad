/**
 * 
 */
package hashing;

import java.util.LinkedList;

/**
 * @author le
 *
 */
public class HashTable {
	
	private static long counter = 0;

	private LinkedList<Pair<String, String>>[] hashTable;

	@SuppressWarnings("unchecked")
	public HashTable(int size) {
		hashTable = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			hashTable[i] = new LinkedList<Pair<String, String>>();
		}
	}

	public void add(String key, String value) {
		hashTable[hash(key)].add(new Pair<>(key, value));
	}

	public String get(String key) {
		counter = 0;
		for (Pair<String, String> pair : hashTable[hash(key)]) {
			counter++;
			if (pair.getKey().equals(key)) {
				System.out.println(counter);
				return pair.getValue();
			}
		}
		System.out.println(counter + " miss");
		return null;
 	}
	
	private int hash(String key) {
		return (key.hashCode() & 0x7fffffff) % hashTable.length;
	}
}
