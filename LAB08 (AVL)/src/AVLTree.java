import java.io.*;

public class AVLTree<T extends Comparable<? super T>> extends BST<T> {

	protected int height;

	public AVLTree() {
		super();
		height = -1;
	}

	public AVLTree(BSTNode<T> root) {
		super(root);
		height = -1;
	}

	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(BSTNode<T> node) {
		if (node == null)
			return -1;
		else
			return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	private AVLTree<T> getLeftAVL() {
		AVLTree<T> leftsubtree = new AVLTree<T>(root.left);
		return leftsubtree;
	}

	private AVLTree<T> getRightAVL() {
		AVLTree<T> rightsubtree = new AVLTree<T>(root.right);
		return rightsubtree;
	}

	protected int getBalanceFactor() {
		if (isEmpty())
			return 0;
		else
			return getRightAVL().getHeight() - getLeftAVL().getHeight();
	}

	public void insertAVL(T el) {
		super.insert(el);
		this.balance();
	}

	protected void balance() {
		if (!isEmpty()) {
			getLeftAVL().balance();
			getRightAVL().balance();

			adjustHeight();

			int balanceFactor = getBalanceFactor();

			if (balanceFactor == -2) {
				System.out.println("Balancing node with el: " + root.el);
				if (getLeftAVL().getBalanceFactor() < 0)
					rotateRight();
				else
					rotateLeftRight();
			}

			else if (balanceFactor == 2) {
				System.out.println("Balancing node with el: " + root.el);
				if (getRightAVL().getBalanceFactor() > 0)
					rotateLeft();
				else
					rotateRightLeft();
			}
		}
	}

	protected void adjustHeight() {
		if (isEmpty())
			height = -1;
		else
			height = 1 + Math.max(getLeftAVL().getHeight(), getRightAVL().getHeight());
	}

	protected void rotateRight() {
		System.out.println("RIGHT ROTATION");
		// Q1
		BSTNode<T> tempNode = root.right;
		root.right = root.left;
		root.left = root.right.left;
		root.right.left = root.right.right;
		root.right.right = tempNode;

		T val = (T) root.el;
		root.el = root.right.el;
		root.right.el = val;

		getRightAVL().adjustHeight();
		adjustHeight();
	}

	protected void rotateLeft() {
		System.out.println("LEFT ROTATION");
		BSTNode<T> tempNode = root.left;
		root.left = root.right;
		root.right = root.left.right;
		root.left.right = root.left.left;
		root.left.left = tempNode;

		T val = (T) root.el;
		root.el = root.left.el;
		root.left.el = val;

		getLeftAVL().adjustHeight();
		adjustHeight();
	}

	protected void rotateLeftRight() {
		System.out.println("Double Rotation...");
		// Q1
		getLeftAVL().rotateLeft();
		getLeftAVL().adjustHeight();
		this.rotateRight();
		this.adjustHeight();
	}

	protected void rotateRightLeft() {
		System.out.println("Double Rotation...");
		getRightAVL().rotateRight();
		getRightAVL().adjustHeight();
		this.rotateLeft();
		this.adjustHeight();
	}

//--------------------------deleteAVL method-----------------------
// For deletion we have 3 cases:
// 
// Case 1: tree stays balanced
//	 We do nothing
//	
// Case 2: deletion from right subtree causes imbalance:
//	 BF(node) == -2 && BF(node.left) == -1: SRR
//	 BF(node) == -2 && BF(node.left) ==  1: DLRR
//	 BF(node) == -2 && BF(node.left) ==  0: SRR
//	 BF(node) ==  2 && BF(node.left) ==  0: SLR
//	
// Case 3: deletion from left subtree causes imbalance:
//	 BF(node) ==  2 && BF(node.right) ==  1: SLR
//	 BF(node) ==  2 && BF(node.right) == -1: DRLR
//	 BF(node) ==  2 && BF(node.right) ==  0: SLR
//	 BF(node) == -2 && BF(node.right) ==  0: SLR

	public void deleteAVL(T el) {
		// I couldn't finish this method but the approach I was thinking was:

		// checking each element's balance factor after deletion && check which
		// subtree it was deleted from.

		// after that if there is imbalance it would check the left or right child's
		// balance factor (depends on the subtree side).

		// Then it would perform the proper rotation.
		
		deleteByCopying(el);
		balance();
	}

}