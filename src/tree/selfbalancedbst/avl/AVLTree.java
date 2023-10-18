/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.selfbalancedbst.avl;

import tree.bst.theories.BSTree;
import tree.node.AVLNode;
import tree.node.BSTNode;

/**
 * If Balance Factor in {-1, 0, 1} then the tree is balance If balance Factor out of the above scope then apply
 * L,R,LR,RL rotation
 *
 *
 * Node of AVL - left, right, data - height: attach the current height of the p node
 *
 * Fundamental Function of the AVL trees - 4 rotations (L, R, LR, RL) - calculate balance factor (recalculate after
 * insertion and deletion) - get height of node p
 *
 * @author duyvu
 * @param <T>
 */
public class AVLTree<T extends Comparable<T>> {

    // ======================================
    // = Fields
    // ======================================
    public AVLNode root;

    // ======================================
    // = Create Methods
    // ======================================
    public AVLNode addNode(AVLNode<T> node,
	    T data) {

	/**
	 * 1. Insertion
	 */
	// if node is null then return new created node
	if (node == null) {
	    return new AVLNode<>(data);
	}

	// if data < node, add to left 
	// if data > right, add to right
	if (data.compareTo(node.data) > 0) {
	    node.right = addNode(node.right, data);
	} else if (data.compareTo(node.data) < 0) {
	    node.left = addNode(node.left, data);
	} else {
	    return node;
	}

	/**
	 * 2. Calculate Height and update balance factor
	 * Backtracking section - Recalculate Height, balance factor at each node after return the recursive all
	 */
	// Set the height of this node
	node.setHeight(node.left, node.right);

	// Recalculate the balance factor of the current node
	int balanceFactor = getBalance(node.left, node.right);

	/**
	 * 3. Rotating
	 * Check which rotation will be applied for the current balance factor subtree - balanceFactor - Checking the
	 * balanceFactor > 1 or < -1
	 * - 4 scenario
	 * - If > 1:
	 * - if newInserted > root.right then left rotation
	 * - if newInserted < root.left then right -> left rotation
	 *
	 * - If < -1:
	 * - if newInserted < root.left then right rotation
	 * - if newInserted > root.right then left -> right rotation
	 */
	// - Case for left rotation first 
	if (balanceFactor > 1) {
	    if (data.compareTo(node.right.data) > 0) { // case left rotating
		return leftRotation(node);
	    } else {
		node.right = rightRotation(node.right);
		return leftRotation(node);
	    }

	    // [ERROR]
//	    else if (data.compareTo(node.left.data) < 0) { // case of right rotating
//		node.right = rightRotation(node.right);
//		return leftRotation(node);
//	    }
	    // - Case for right rotation first
	} else if (balanceFactor < -1) {
	    if (data.compareTo(node.left.data) < 0) {
		return rightRotation(node);
	    } else {
		node.left = leftRotation(node.left);
		return rightRotation(node);
	    }

//	    else if (data.compareTo(node.right.data) > 0) {
//		node.left = leftRotation(node.left);
//		return rightRotation(node);
//	    }
	}

	return node;
    }

    public void addNode(T data) {
	this.root = addNode(this.root, data);
    }

    public void addNodes(T... datas) {
	for (T data : datas) {
	    addNode(data);
	}
    }

    // ====================================== 
    // = Helper methods 
    // ====================================== 
    /**
     * Calculate the balanceFactor of the currentNode
     *
     * @param root
     * @return return the balance factor of the tree
     */
    public int getBalance(AVLNode<T> leftRoot, AVLNode<T> rightRoot) {
	// Get the height of from the left and right subtree
	int lHeight = leftRoot == null ? 0 : leftRoot.height;
	int rHeight = rightRoot == null ? 0 : rightRoot.height;

	return rHeight - lHeight;
    }

    /**
     * Left rotation
     * <br><br>Counting only three node starting from the unbalanced node
     *
     * @param root
     * @param passed node that is unbalanced
     * @return a new root node
     */
    public AVLNode leftRotation(AVLNode<T> root) {
	AVLNode rightRoot = root.right;
	AVLNode leftOfRightRoot = rightRoot.left;

	// Rotating
	rightRoot.left = root;
	root.right = leftOfRightRoot;

	// Update Height at each Node
	root.setHeight(root.left, root.right);
	rightRoot.setHeight(rightRoot.left, rightRoot.right);

	return rightRoot;
    }

    /**
     * Right rotation
     * <br><br>Counting only three node starting from the unbalanced node
     *
     * @param root
     * @return
     */
    public AVLNode rightRotation(AVLNode<T> root) {
	AVLNode leftRoot = root.left;
	AVLNode rightOfLeftRoot = leftRoot.right;

	// Rotating
	leftRoot.right = root;
	root.left = rightOfLeftRoot;

	// Update Height
	root.setHeight(root.left, root.right);
	leftRoot.setHeight(leftRoot.left, leftRoot.right);

	return leftRoot;
    }

    public static void printAlignedHorizontally(AVLNode node,
	    String prefix) {

	// Applying 
	if (node != null) {
	    printAlignedHorizontally(node.right, prefix + "\t");
	    System.out.println(prefix + "|-- " + node.data.toString());
	    printAlignedHorizontally(node.left, prefix + "\t");
	}
    }

    /**
     * Testing Function
     *
     * @param args
     */
    public static void main(String[] args) {
	AVLTree tree = new AVLTree();
	Integer[] list = new Integer[]{1, 10, 9, 8, 6, 5, 4, 3, 2, 1, -1, -2, -3, -4, -5};

	// Checking If the tree is balanced
	tree.addNodes(list);
	tree.printAlignedHorizontally(tree.root, "\t");
	System.out.println("Root: " + tree.root.data);

    }
}
