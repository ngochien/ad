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
 * @author Le, Nguyen
 */
public interface BinarySearchTree<T extends Comparable<T>> {

	public void insert(T data);

	public void preorder();

	public void inorder();

	public void postorder();
}
