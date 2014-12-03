/**
 * 
 */
package a09;

/**
 * @author le
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IntegerBST tree = new IntegerBST();
		for (int i = 10; i <= 1000000; i *= 10) {
			for (int j = 0; j < i; j++) {
				tree.insert((int) (Math.random() * 10 * i + 50 * i + 1));
			}
			long start = System.nanoTime();
			tree.sum(0, Integer.MAX_VALUE);
			long end = System.nanoTime();
			long time = end-start;
			System.out.println(i + "                    " + time);
		}

	}

}
