/**
 * 
 */
package hashing;

/**
 * @author le
 *
 */
public class RunTimeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// nicht von der Anzahl der Schlüssel-Wert-Paare abhängt
		for (int numOfPairs = 100; numOfPairs < 1_00_00_00_0; numOfPairs *= 10) {

			HashTable hashTable = new HashTable(numOfPairs * 2);

			for (int pair = 0; pair < numOfPairs; pair++) {
				String key = "";
				int keyLength = (int) (Math.random() * 20);
				for (int i = 0; i < keyLength; i++) {
					key += (char) (int) (Math.random() * 256);
				}
				hashTable.add(key, pair + "");
			}

			hashTable.add("deutschland", "de");
			
			hashTable.get("deutschland");
			
		}

		// // sondern von dem Verh¨ altnis <Anzahl Schl¨ usselWert-Paare>/<L¨
		// ange des Hash-Arrays>
		for (int numOfPairs = 100; numOfPairs < 1_00_00_000; numOfPairs *= 10) {

			int sizes = 100;
			HashTable hashTable = new HashTable(sizes);

			for (int pair = 0; pair < numOfPairs; pair++) {
				String key = "";
				int keyLength = (int) (Math.random() * 20);
				for (int i = 0; i < keyLength; i++) {
					key += (char) (int) (Math.random() * 256);
				}
				hashTable.add(key, pair + "");
			}
			hashTable.add("deutschland", "de");

			
			hashTable.get("deutschland");
			
		}
	}

}
