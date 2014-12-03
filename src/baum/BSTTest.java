/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package baum;

/**
 *
 *
 * @author Le
 */
public class BSTTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		BinarySearchTree<Integer> bst = new StaticBST<>(5);
		BinarySearchTree<Integer> bst = new DynamicBST<>();
		
		bst.insert(23);
		bst.insert(42);
		bst.insert(5);
		bst.insert(3);
		bst.insert(112);
		bst.insert(112);
		bst.insert(22);
		bst.insert(66);

		System.out.print("Preorder: "); bst.preorder();
		System.out.println();
		System.out.print("Inorder: "); bst.inorder();
		System.out.println();
		System.out.print("Postorder: "); bst.postorder();
	}

}
