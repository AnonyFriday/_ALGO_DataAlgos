/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.selfbalancedbst.avl;

import tree.bst.theories.BSTree;
import tree.node.AVLNode;

/**
 * If Balance Factor in {-1, 0, 1} then the tree is balance
 * If balance Factor out of the above scope then apply L,R,LR,RL rotation
 *
 *
 * Node of AVL
 * - left, right, data
 * - height: attach the current height of the p node
 *
 * Fundamental Function of the AVL trees
 * - 4 rotations (L, R, LR, RL)
 * - calculate balance factor (recalculate after insertion and deletion)
 * - get height of node p
 *
 * @author duyvu
 */
public class AVLTree<T extends Comparable<T>> {

    // ======================================
    // = Fields
    // ======================================
    public AVLNode root;

    // ======================================
    // = Create Methods
    // ======================================
    public AVLNode addNode(AVLNode<T> root,
                           T data) {

        // if root is null then return new created root
        if (root == null) {
            return new AVLNode<>(data);
        }

        // if data < root, add to left 
        // if data > right, add to right
        if (data.compareTo(root.data) > 0) {
            root.right = addNode(root.right, data);
        } else if (data.compareTo(root.data) < 0) {
            root.left = addNode(root.left, data);
        } else {
            return root;
        }

        /**
         * Backtracking section
         * - Recalculate Height, balance factor at each node after return the recursive all
         */
        // Set the height of this root
        root.setHeight(root.left, root.right);

        // Recalculate the balance factor
        int balanceFactor = calculateBalanceFactor(this.root);

        /**
         * Check which rotation will be applied for the current balance factor subtree
         * - balanceFactor
         */
//        if (balanceFactor > 1 && data.compareTo(root.right.data) > 0) {
//            return leftRotation(root);
//        } else if (balanceFactor < -1 && data.compareTo(root.left.data) < 0) {
//            return rightRotation(root);
//        } else if (balanceFactor > 1 && data.compareTo(root.right.data) < 0) {
//            return null // FIXING
//        } else if (balanceFactor < -1 && data.compareTo)

        return root;
    }

    public void addNode(T data) {
        this.root = addNode(this.root, data);
    }

    // ======================================
    // = Helper methods
    // ======================================
    /**
     * Calculate the balanceFactor of the currentNode
     *
     * @param root
     * @return right height - left height
     */
    public int calculateBalanceFactor(AVLNode<T> root) {
        if (root == null) {
            return 0;
        }
        return root.right.height - root.left.height;
    }

    public AVLNode leftRotation(AVLNode<T> root) {
        return null;
    }

    public AVLNode rightRotation(AVLNode<T> root) {
        return null;
    }
}
