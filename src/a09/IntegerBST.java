/**
 * 
 */
package a09;

/**
 * @author le
 *
 */
public class IntegerBST {

	private static class IntegerNode {
		int value, sum;
		IntegerNode left, right;

		IntegerNode(int value) {
			// assert value >= 0
			this.value = value;
			this.sum = value;
			this.left = null;
			this.right = null;
		}
	}

	private IntegerNode root;

	public IntegerBST() {
		this.root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * @return sum of all values in this binary search tree.
	 */
	public int sum() {
		return sum(root);
	}

	private int sum(IntegerNode node) {
		return node == null ? 0 : node.sum;
	}

	/**
	 * Insert the specified value into this BST.
	 * 
	 * @param value
	 */
	public void insert(int value) {
		root = insert(root, value);
	}

	private IntegerNode insert(IntegerNode root, int value) {
		if (root == null) {
			root = new IntegerNode(value);
			return root;
		}
		
		if (value < root.value) {
			root.left = insert(root.left, value);
		} else if (value > root.value) {
			root.right = insert(root.right, value);
		}

		root.sum = root.value + sum(root.left) + sum(root.right);

		return root;
	}

	/**
	 * @param min
	 * @param max
	 * @return sum of all values in this bst that are greater than (or equal to) min
	 * 			AND less than (or equal to) max.
	 */
	public int sum(int min, int max) {
		if (root == null) {
			return 0;
		}

		if (min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}

		IntegerNode minNode = ceiling(root, min);
		IntegerNode maxNode = floor(root, max);
		if (minNode == null || maxNode == null) {
			return 0;
		}

		IntegerNode lca = LCA(root, minNode, maxNode);

		int sum = sum(lca) - sum(minNode.left) - sum(maxNode.right);

		IntegerNode lessParent = lca;
		while (lessParent.value != minNode.value) {
			if (lessParent.value > minNode.value) {
				lessParent = lessParent.left;
			} else if (lessParent.value < minNode.value) {
				sum = sum - sum(lessParent.left) - lessParent.value;
				lessParent = lessParent.right;
			}
		}
		
		IntegerNode greaterParent = lca;
		while (greaterParent.value != maxNode.value) {
			if (greaterParent.value < maxNode.value) {
				greaterParent = greaterParent.right;
			} else if (greaterParent.value > maxNode.value) {
				sum = sum - sum(greaterParent.right) - greaterParent.value;
				greaterParent = greaterParent.left;
			}
		}

		return sum;
	}

	/**
	 * <Suchen von a_m>
	 *
	 * Returns the node n with the smallest value that greater than or equal to the
	 * given value x (n.value = min({n'.value | n'.value >= x}))
	 */
	private IntegerNode ceiling(IntegerNode root, int x) {
		// assert x >= 0 && root != null
		if (root == null) {
			return null;
		}
		if (root.value == x) {
			return root;
		} else if (x > root.value) {
			return ceiling(root.right, x);
		} else {
			IntegerNode t = ceiling(root.left, x);
			if (t != null) {
				return t;
			} else {
				return root;
			}
		}
	}

	/**
	 * <Suchen von a_M>
	 * 
	 * Returns the node n with the largest value that less than or equal to the
	 * given value x (n.value = max({n'.value | n'.value <= x}))
	 */
	private IntegerNode floor(IntegerNode root, int x) {
		// assert x >= 0 && root != null
		if (root == null) {
			return null;
		}
		if (root.value == x) {
			return root;
		} else if (x < root.value) {
			return floor(root.left, x);
		} else {
			IntegerNode t = floor(root.right, x);
			if (t != null) {
				return t;
			} else {
				return root;
			}
		}
	}

	/**
	 * Returns the LCA-Node of the two given nodes.
	 */
	private IntegerNode LCA(IntegerNode root, IntegerNode x, IntegerNode y) {
		// assert x, y are on this tree && root != null
		if (root == null) {
			return null;
		}

		if ((root.value >= x.value && root.value <= y.value)
				|| (root.value >= y.value && root.value <= x.value)) {
			return root;
		} else if (root.value > x.value && root.value > y.value) {
			return LCA(root.left, x, y);
		} else if (root.value < x.value && root.value < y.value) {
			return LCA(root.right, x, y);
		} else {
			throw new IllegalStateException("This line should never be reached");
		}
	}
	

	/*-***********************************************************************-*
	 *                                                                         *
	 *                         Only for testing purpose                        *
	 *                                                                         *
	 *-***********************************************************************-*/

	public int min(int x) {
		IntegerNode n = ceiling(root, x);
		return n == null ? 0 : n.value;
	}

	public int max(int x) {
		IntegerNode n = floor(root, x);
		return n == null ? 0 : n.value;
	}

	/**
	 * @param x
	 *            value of the one node
	 * @param y
	 *            value of the other one
	 * @return value of the LCA-Node
	 */
	public int valueLCA(int x, int y) {
		return valueLCA(root, x, y);
	}

	public int sumLCA(int x, int y) {
		return sumLCA(root, x, y);
	}

	private int valueLCA(IntegerNode root, int x, int y) {
		// assert x, y are on this tree && root != null

		if ((root.value >= x && root.value <= y)
				|| (root.value >= y && root.value <= x)) {
			return root.value;
		} else if (root.value > x && root.value > y) {
			return valueLCA(root.left, x, y);
		} else if (root.value < x && root.value < y) {
			return valueLCA(root.right, x, y);
		} else {
			throw new IllegalStateException("This line should never be reached");
		}
	}

	private int sumLCA(IntegerNode root, int x, int y) {
		// assert x, y are on this tree && root != null

		if (root == null) {
			return 0;
		}

		if ((root.value >= x && root.value <= y)
				|| (root.value >= y && root.value <= x)) {
			return root.sum;
		} else if (root.value > x && root.value > y) {
			return sumLCA(root.left, x, y);
		} else if (root.value < x && root.value < y) {
			return sumLCA(root.right, x, y);
		} else {
			throw new IllegalStateException("This line should never be reached");
		}
	}
}
