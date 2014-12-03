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
public class StaticBST<T extends Comparable<T>> implements BinarySearchTree<T> {

	private Object[] elements;

	/**
	 *
	 */
	public StaticBST(int height) {
		int capacity = (int) Math.pow(2, height + 1);
		elements = new Object[capacity];
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see baum.BinarySearchTree#insert(java.lang.Comparable)
	 */
	@Override
	public void insert(T data) {
		insert(1, data);
	}

	@SuppressWarnings("unchecked")
	private void insert(int rootIndex, T data) {
		if (rootIndex >= elements.length) {
			throw new IndexOutOfBoundsException("Der Baum ist voll");
		}

		if (elements[rootIndex] == null) {
			elements[rootIndex] = data;
			return;
		}

		if (((T) elements[rootIndex]).compareTo(data) > 0) {
			insert(2 * rootIndex, data);
		} else if (((T) elements[rootIndex]).compareTo(data) < 0) {
			insert(2 * rootIndex + 1, data);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see baum.BinarySearchTree#preorder()
	 */
	@Override
	public void preorder() {
		preorder(1);
	}

	private void preorder(int rootIndex) {
		if (rootIndex >= elements.length) {
			throw new IndexOutOfBoundsException("Der Baum ist voll");
		}
		if (elements[rootIndex] == null) {
			return;
		}
		System.out.print(elements[rootIndex] + " - ");
		preorder(2 * rootIndex);
		preorder(2 * rootIndex + 1);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see baum.BinarySearchTree#inorder()
	 */
	@Override
	public void inorder() {
		inorder(1);
	}

	private void inorder(int rootIndex) {
		if (rootIndex >= elements.length) {
			throw new IndexOutOfBoundsException("Der Baum ist voll");
		}
		if (elements[rootIndex] == null) {
			return;
		}
		inorder(2 * rootIndex);
		System.out.print(elements[rootIndex] + " - ");
		inorder(2 * rootIndex + 1);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see baum.BinarySearchTree#postorder()
	 */
	@Override
	public void postorder() {
		postorder(1);
	}

	private void postorder(int rootIndex) {
		if (rootIndex >= elements.length) {
			throw new IndexOutOfBoundsException("Der Baum ist voll");
		}
		if (elements[rootIndex] == null) {
			return;
		}
		postorder(2 * rootIndex);
		postorder(2 * rootIndex + 1);
		System.out.print(elements[rootIndex] + " - ");
	}
}
