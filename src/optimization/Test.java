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
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 int capital = 150;

		Stock lego = new Stock("Lego", 33, 0.7f);
		Stock monster = new Stock("Monster", 38, -0.1f);
		Stock firma = new Stock("Firma", 94, 0.6f);
		Stock panzer = new Stock("Panzer", 62, 0.8f);
		Stock enterprise = new Stock("Enterprise", 28, 0.2f);
		Stock stern = new Stock("Stern", 20, 1.1f);
		Stock astra = new Stock("Astra", 58, -0.5f);
		Stock maritime = new Stock("Maritime", 48, 0.4f);

		Optimizer opt = new Optimizer(lego, monster, firma, panzer, enterprise, stern, astra, maritime);
		
		opt.printRecursive(capital);
		
		opt.printDynamic(8, capital);		
	}

}
