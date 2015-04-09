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
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Optimizer Stock optimizer implements Optimizer... Or better generic???
 * Interface Optimizable etc.
 * 
 * @author 
 *         http://wwwiti.cs.uni-magdeburg.de/iti_db/lehre/algds0506/handout13.pdf
 */
public class Optimizer {

	long rcounter;
	long dcounter;
	Stock[] stocks;

	public Optimizer(Stock... stocks) {
		this.stocks = new Stock[stocks.length];
		this.stocks = Arrays.copyOf(stocks, this.stocks.length);
	}

	private void print(List<Stock> choosen) {
		System.out.println("Gewinn: " + sumValue(choosen));
		for (Stock s : choosen) {
			System.out.println(s.name + ": " + s.value());
		}
	}

	public void printRecursive(int capital) {
		List<Stock> choosen = recursive(0, capital,
				new LinkedList<Stock>());
		print(choosen);
	}

	private List<Stock> recursive(int objNr, int capital, List<Stock> choosen) {
		if (objNr >= stocks.length) {
			return choosen;
		}

		// Berechne Wert ohne den aktuellen Gegenstand
		List<Stock> no = new LinkedList<Stock>(choosen);
		no = recursive(objNr + 1, capital, no);

		// Berechne Wert mit dem aktuellen Gegenstand, wenn noch Platz dafür ist
		if (stocks[objNr].price <= capital) {
			List<Stock> yes = new LinkedList<Stock>(choosen);
			yes.add(stocks[objNr]);
			yes = recursive(objNr + 1, capital - stocks[objNr].price, yes);
			if (sumValue(yes) > sumValue(no)) {
				return yes;
			}
		}

		return no;
		
	}

	private int sumValue(List<Stock> stock) {
		int sum = 0;
		for (Stock s : stock) {
			sum += s.value();
		}
		return sum;
	}

	public void printDynamic(int numOfChoices, int capital) {
		List<Stock> choosen = new LinkedList<>();
		int[][] matrix = new int[numOfChoices + 1][capital + 1];
		for (int i = 1; i <= numOfChoices; i++) {
			for (int j = 0; j <= capital; j++) {
				matrix[i][j] = matrix[i - 1][j];
				if (stocks[i - 1].price <= j) {
					if (matrix[i][j] < matrix[i - 1][j - stocks[i - 1].price] + stocks[i - 1].value()) {
						matrix[i][j] = matrix[i - 1][j - stocks[i - 1].price] + stocks[i - 1].value();
						choosen.add(stocks[i - 1]);
					}
				}
			}
		}
		System.out.println(matrix[stocks.length][capital]);
		print(choosen);
		// return matrix[stocks.length][capital];
	}
}
