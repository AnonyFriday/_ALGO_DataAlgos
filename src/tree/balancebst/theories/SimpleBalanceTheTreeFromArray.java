/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.balancebst.theories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tree.bst.theories.BSTNode;
import tree.bst.theories.BSTree;
import utilities.HelperFunctions;

/**
 *
 * @author duyvu
 */
public abstract class SimpleBalanceTheTreeFromArray {

    // ======================================
    // = Balance BST Passing Array
    // ======================================
    /**
     * Generate the a tree-array stored by adding middle to the array
     *
     * <br><br> After conducting this function, inserting each node of this
     * array
     * <br><br> by calling addNode() in the bstree class
     *
     * @param <T>
     * @param result
     * @param data
     * @param first
     * @param last
     *
     * @return
     */
    private static <T> void constructBalancedBST(List<T> result, T data[], int first, int last) {
        if (first <= last) {
            int middle = (last + first) / 2;
            result.add(data[middle]);
            constructBalancedBST(result, data, first, middle - 1);
            constructBalancedBST(result, data, middle + 1, last);
        }
    }
    
    public static <T> List<T> balanceBST(T data[]) {
        ArrayList<T> list = new ArrayList<>();
        constructBalancedBST(list, data, 0, data.length - 1);
        return list;
    }

    // ======================================
    // = Balance BST Passing Node
    // ======================================
    /**
     * Construct the Balanced BST based on sorted list
     *
     * @param <T>
     * @param inOrderList
     * @param start
     * @param end
     *
     * @return
     */
    private static <T> BSTNode constructBalancedBST(List<T> inOrderList, int start, int end) {
        
        if (start > end) {
            return null;
        }

        // Construct the mid index as the root node
        int mid = (start + end) / 2;
        BSTNode root = new BSTNode((Comparable) inOrderList.get(mid));
        root.left = constructBalancedBST(inOrderList, start, mid - 1);
        root.right = constructBalancedBST(inOrderList, mid + 1, end);
        
        return root;
    }

    /**
     * Main function to call for balancing the BST
     *
     * @param <T>
     * @param node
     *
     * @return
     */
    public static <T> BSTNode balanceBST(BSTNode node) {
        if (node == null) {
            return null;
        }
        List<T> inOrderList = new ArrayList<>();
        convertInorder(node, inOrderList);
        return constructBalancedBST(inOrderList, 0, inOrderList.size() - 1);
    }

    /**
     * Convert the unbalance tree by traversing inorder and add data to the list
     * <br><br>The purpose is to sort the array
     *
     * @param <T>
     * @param node
     * @param inorderList
     */
    private static <T> void convertInorder(BSTNode node, List<T> inOrderList) {
        if (node != null) {
            convertInorder(node.left, inOrderList);
            inOrderList.add((T) node.data);
            convertInorder(node.right, inOrderList);
        }
    }
    
    // Testing
    public static void main(String[] args) {

        // Generate the complete binary tree stored at the array
        Integer[] list = new Integer[]{5, 1, 9, 8, 7, 0, 2, 3, 4, 6};

        // Create unbalanced binary tree
        BSTree tree = new BSTree();
        tree.addNodes(list);

        // The tree is not construct yet
        BSTree.printAlignedHorizontally(tree.root, "|__");

        // Construct the tree
        tree.root = balanceBST(tree.root);
        BSTree.printAlignedHorizontally(tree.root, "__");
    }
}
