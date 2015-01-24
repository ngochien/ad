/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package optimization;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Optimizer Stock optimizer implements Optimizer... Or better generic???
 * Interface Optimizable etc.
 * 
 * @author
 */
public class Optimizer {

	long rcounter;
	long dcounter;
	Stock[] stocks;
	Set<Stock> choosen;

	public Optimizer(Stock... stocks) {
		this.stocks = new Stock[stocks.length];
		this.stocks = Arrays.copyOf(stocks, this.stocks.length);
		choosen = new HashSet<>();
	}

	public void printL() {
		for (Stock s : stocks) {
			System.out.println(s.name + " - " + s.price + ": " + s.value());
		}
	}
	
	// wrapper
	public int recursive(int numOfChoices, int capital) {
		if (numOfChoices < 0) {
			return 0;
		}

		if (stocks[numOfChoices].price > capital) {
			rcounter++;
			return recursive(numOfChoices - 1, capital);
		}

		rcounter += 1;

		int no = recursive(numOfChoices - 1, capital);
		int yes = recursive(numOfChoices - 1, capital - stocks[numOfChoices].price)
					+ stocks[numOfChoices].value();
		if (yes >= no) {
			choosen.add(stocks[numOfChoices]);
			
		} else {
			choosen.remove(stocks[numOfChoices]);
		}

		return Math.max(yes, no);
		// return Math.max(
		// recursive(numOfChoices - 1, capital),
		// recursive(numOfChoices - 1, capital
		// - stocks[numOfChoices].price)
		// + stocks[numOfChoices].value());
	}

	public void print() {
		for (Stock s : choosen) {
			System.out.println(s.name + ": " + s.value());
		}
	}

	public int dynamic(int numOfChoices, int capital) {
		choosen.removeAll(choosen);
		dcounter = 0;
		int[][] m = new int[numOfChoices + 1][capital + 1];
		for (int i = 1; i <= numOfChoices; i++) {
			for (int j = 0; j <= capital; j++) {
				if (stocks[i - 1].price <= j) {
					dcounter += 2;
					m[i][j] = Math.max(m[i - 1][j], m[i - 1][j
							- stocks[i - 1].price]
							+ stocks[i - 1].value());
					
					if (m[i - 1][j- stocks[i - 1].price] + stocks[i - 1].value() <= m[i - 1][j]) {
						choosen.add(stocks[i-1]);
					} else {
						choosen.remove(stocks[i-1]);
					}
					
				} else {
					dcounter++;
					m[i][j] = m[i - 1][j];
				}
			}
		}
		return m[stocks.length][capital];
	}
	
	public void printd() {
		for (Stock s : choosen) {
			System.out.println(s.name + ": " + s.value());
		}
	}
}
