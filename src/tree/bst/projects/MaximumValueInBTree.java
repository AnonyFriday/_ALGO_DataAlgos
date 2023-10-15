/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.bst.projects;

import tree.bst.theories.BSTree;
import tree.bst.theories.BSTree;
import static tree.bst.theories.BSTree.print;
import tree.node.BSTNode;

/**
 *
 * @author duyvu
 */
public class MaximumValueInBTree {

    /**
     * Since the BST is an ordered tree from left to right
     *
     * The maximum will be on the right
     *
     * @param <T>  Any class being wrapped in the BSTNode
     * @param root A root of bstree
     * @return a max node
     */
    public static <T> T getMaxValue(BSTNode root) {

        // If empty then return null
        if (root == null) {
            return null;
        }

        // If only 1 node, return the right most node
        if (root.right == null) {
            return (T) root.data;
        }

        return getMaxValue((BSTNode) root.right);
    }

    /**
     * Getting the right most value in the tree using recursive approach
     *
     * @param <T>
     * @param root
     * @return
     */
    public static <T> T getMaxValueIterative(BSTNode root) {

        // If empty then return null
        if (root == null) {
            return null;
        }

        BSTNode currNode = root;
        while (currNode.right != null) {
            currNode = (BSTNode) currNode.right;
        }
        return (T) currNode.data;
    }

    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree<>();
        int[] arr = new int[]{7, 1, 0, 8, 9, 2, 15, 6, 13, 14, 5, 1000};

        for (int i = 0; i < arr.length; i++) {
            tree.addNodeIteration(arr[i]);
        }

        print("", tree.root);
        System.out.println("Max: " + getMaxValue(tree.root).toString());
        System.out.println("Max: " + getMaxValueIterative(null));
    }
}
