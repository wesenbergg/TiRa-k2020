package btree;

/**
 * @author Boriss
 *
 */
@SuppressWarnings("PMD.ShortClassName")
public class Node {
	/**
	 */
	private String data;
	/**
	 */
	private BinaryTree left;
	/**
	 */
	private BinaryTree right;

	/**
	 * @param value
	 */
	public Node(final String value) {
		data = value;
		left = null;
		right = null;
	}
	/**
	 * @param value
	 * @param left
	 * @param right
	 */
	public Node(final String value, final BinaryTree left, final BinaryTree right) {
		data = value;
		this.left = left;
		this.right = right;
	}
	public String getData() {
		return data;
	}
	public BinaryTree getLeft() {
		return left;
	}
	public BinaryTree getRight() {
		return right;
	}
	public void setData(final String data) {
		this.data = data;
	}
	public void setLeft(final BinaryTree tree) {
		left = tree;
	}
	public void setRight(final BinaryTree tree) {
		right = tree;
	}
}