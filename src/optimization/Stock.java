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
public class Stock {

	String name;
	int price;
	float performance;

	/**
	 * @param name
	 * @param price
	 * @param performance
	 */
	public Stock(String name, int price, float performance) {
		this.name = name;
		this.price = price;
		this.performance = performance;
	}

	/** value after 1 year */
	public int value() {
		return (int) (price + price * performance);
	}
}
