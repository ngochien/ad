/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package optimization;

/**
 *
 *
 * @author Le
 */
public class Runtime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int capital = 5000;
		Optimizer opt;
		for (int i = 10; i < 1000000; i *= 5) {
			capital = i / 10;
			opt = new Optimizer(Runtime.stocks(i, capital));

			 long startRecursive = System.nanoTime();
			 opt.recursive(i - 1, capital);
			 long endRecursive = System.nanoTime();
			 System.out.print(opt.rcounter + "          " + i);
			 System.out.println();

//			long startDynamic = System.nanoTime();
//			opt.dynamic(i, capital);
//			long endDynamic = System.nanoTime();
//			System.out.print(i + "     " + opt.dcounter);
//			System.out.println();
		}
	}

	/** generate randomly n stocks. maxPrice should be less than or equal to capital! */
	public static Stock[] stocks(int n, int maxPrice) {
		Stock[] stocks = new Stock[n];

		String name;
		int price;
		float performance;

		for (int i = 0; i < n; i++) {
			name = "Stock Nr. " + i;
			price = (int) (Math.random() * maxPrice);
			performance = (float) (Math.random() * -1.0f + Math.random() * 11.0f);
			stocks[i] = new Stock(name, price, performance);
		}

		return stocks;
	}
}
