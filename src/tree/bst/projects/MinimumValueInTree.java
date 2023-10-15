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
public class MinimumValueInTree {

    /**
     * Since the BST is an ordered tree from left to right
     *
     * The minimum will be on the right
     *
     * @param <T>      Any class being wrapped in the BSTNode
     * @param root     A root of bstree
     * @param prevNode a previous node before a root
     * @return a min node
     */
    public static <T> T getMinValue(BSTNode root) {

        // If empty then return null
        if (root == null) {
            return null;
        }

        // If only 1 root, then return a root
        if (root.left == null) {
            return (T) root.data;
        }

        return getMinValue((BSTNode) root.left);
    }

    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree<>();
        int[] arr = new int[]{7, 1, 0, -99, 8, 9, 2, 15, 6, 13, 14, 5, 1000};

        for (int i = 0; i < arr.length; i++) {
            tree.addNodeIteration(arr[i]);
        }

        print("", tree.root);
        System.out.println("Min: " + getMinValue(tree.root).toString());
        System.out.println("Min: " + getMinValue(null));

    }
}
