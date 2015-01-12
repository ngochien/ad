/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package optimization;

import java.util.Arrays;

/**
 * Stock optimizer implements Optimizer... Or better generic??? Interface Optimizable etc.
 *
 * @author Le
 */
public class Optimizer {

	long rcounter;
	long dcounter;
	Stock[] stocks;
	Stock[] choices;

	public Optimizer(Stock... stocks) {
		this.stocks = new Stock[stocks.length];
		choices = new Stock[stocks.length];
		this.stocks = Arrays.copyOf(stocks, this.stocks.length);
	}

	// should be private as a helper. A wrapper method needed!
	public int recursive(int numOfChoices, int capital) {
		if (numOfChoices < 0) {
			return 0;
		}

		if (stocks[numOfChoices].price > capital) {
			rcounter++;
			return recursive(numOfChoices - 1, capital);
		}

		rcounter += 2;
		return Math.max(
				recursive(numOfChoices - 1, capital),
				recursive(numOfChoices - 1, capital - stocks[numOfChoices].price) +
				stocks[numOfChoices].value());
	}

	public int dynamic(int numOfChoices, int capital) {
		dcounter = 0;
		int[][] m = new int[numOfChoices + 1][capital + 1];
		for (int i = 1; i <= numOfChoices; i++) {
			for (int j = 0; j <= capital; j++) {
				if (stocks[i - 1].price <= j) {
					dcounter += 2;
					m[i][j] =
							Math.max(m[i - 1][j], m[i - 1][j - stocks[i - 1].price] + stocks[i - 1].value());
				} else {
					dcounter++;
					m[i][j] = m[i - 1][j];
				}
			}
		}
		return m[stocks.length][capital];
	}
}
