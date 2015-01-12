/**
 * 
 */
package graphen;

import baum.BinarySearchTree;

/**
 * @author le
 *
 */
public class KeyValueBST<K, V extends Comparable<V>> {

	private class Node<S, W> {
		S key;
		W value;
		Node<S, W> left;
		Node<S, W> right;
		Node(S key, W value) {
			this.key = key;
			this.value = value;
		}
	}
	
	Node<K, V> root;
	
	public boolean isEmpty() {
		return root == null;
	}
	
	// value wird sortiert beim zufügen, nicht key
	public void insert(K key, V value) {
		root = insert(root, new Node<K, V>(key, value));
	}

	private Node<K, V> insert(Node<K, V> root, Node<K, V> x) {
		if (root == null) {
			return x;
		}
		if (root.key.equals(x.key)) {
			root.value = x.value;
			return root;
		}
		if (root.value.compareTo(x.value) > 0) {
			root.left = insert(root.left, x);
		} else {
			root.right = insert(root.right, x);
		}
		return root;
	}
	
	// löschen des knotens mit dem kleinsten value und return dessen key
	public K deleteMin() {
		if (root == null) {
			return null;
		}
		K min = min(root).key;
		root = deleteMin(root);
		return min;
	}
	
	private Node<K, V> deleteMin(Node<K, V> root) {	
		if (root.left == null) {
			return root.right;
		}
		root.left = deleteMin(root.left);
		return root;
	}

	private Node<K,V> min(Node<K, V> root) {
		if (root.left == null) {
			return root;
		} else {
			return min(root.left);
		}
		
	}
}
