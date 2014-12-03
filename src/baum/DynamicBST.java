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
public class DynamicBST<T extends Comparable<T>> implements BinarySearchTree<T> {

	private class Node<E> {
		private E data;
		private Node<E> left;
		private Node<E> right;

		private Node(E data) {
			this.data = data;
		}
	}

	private Node<T> root;

	/*
	 * (non-Javadoc)
	 *
	 * @see baum.BinarySearchTree#insert(java.lang.Comparable)
	 */
	@Override
	public void insert(T data) {
		root = insert(root, new Node<T>(data));
	}

	private Node<T> insert(Node<T> root, Node<T> x) {
		if (root == null) {
			return x;
		}

		if (root.data.compareTo(x.data) > 0) {
			root.left = insert(root.left, x);
		} else if (root.data.compareTo(x.data) < 0) {
			root.right = insert(root.right, x);
		}
		return root;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see baum.BinarySearchTree#preorder()
	 */
	@Override
	public void preorder() {
		preorder(root);
	}

	private void preorder(Node<T> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " - ");
		preorder(root.left);
		preorder(root.right);
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see baum.BinarySearchTree#inorder()
	 */
	@Override
	public void inorder() {
		inorder(root);
	}

	private void inorder(Node<T> root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " - ");
		inorder(root.right);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see baum.BinarySearchTree#postorder()
	 */
	@Override
	public void postorder() {
		postorder(root);
	}

	private void postorder(Node<T> root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " - ");
	}

}
