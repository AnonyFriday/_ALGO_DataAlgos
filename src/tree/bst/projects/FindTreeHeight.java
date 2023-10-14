/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.bst.projects;

import java.util.LinkedList;
import java.util.Queue;
import tree.bst.theories.BSTree;
import tree.node.BSTNode;

/**
 *
 * @author duyvu
 */
public class FindTreeHeight {

    /**
     * Finding max height tree by using iteration
     *
     * <br><br>At each level, Applying the level order traversal (BFS)
     *
     * <br><br>After detecting the null node, increment the height by 1
     *
     *
     * @param root
     * @return
     */
    public static int maxHeightTreeIteration(BSTNode root) {

        // If the tree is empty then return 0
        if (root == null) {
            return 0;
        }

        // Counting the total of nodes in the tree by applying breadth first search
        int height = 0;
        Queue<BSTNode> tmpQueue = new LinkedList<>();

        BSTNode currNode = root;

        /**
         * 12
         * 9 100
         * 1 101
         * 0 2 102
         * 1000
         *
         * after 12, level 1, height = 1
         * after 9, 100, level 2, height = 2
         * after 1, 101, level 3, height = 3
         * after 0,2,102, level 4, height = 4
         * after 1000, level 5, height = 5
         */
        tmpQueue.add(currNode);

        while (!tmpQueue.isEmpty()) {

            // Extract No. of nodes in queue
            int nodesInALevel = tmpQueue.size();

            // Looping until reaching the right most node at each level
            while (nodesInALevel-- > 0) {
                currNode = tmpQueue.remove();

                // At each node, adding left and right at next level if not nullF
                if (currNode.left != null) {
                    tmpQueue.add((BSTNode) currNode.left);
                }

                if (currNode.right != null) {
                    tmpQueue.add((BSTNode) currNode.right);
                }
            }

            height++;
        }

        return height;
    }

    public static int maxHeightTreeRecursion(BSTNode root) {

        // If empty then return the height = 0
        if (root == null) {
            return 0;
        }

        int maxHeightLeft = maxHeightTreeRecursion((BSTNode) root.left) + 1;
        int maxHeightRight = maxHeightTreeRecursion((BSTNode) root.right) + 1;
        return Math.max(maxHeightLeft, maxHeightRight);
    }

    // This class is for testing
    public static void main(String[] args) {
        BSTree<Integer> tree = new BSTree<>();
        tree.addNode(12);
        tree.addNode(9);
        tree.addNode(1);
        tree.addNode(100);
        tree.addNode(101);
        tree.addNode(102);
        tree.addNodeIteration(2);
        tree.addNodeIteration(0);
        tree.addNodeIteration(1000);
        BSTree.print("\t\t", tree.root);

        System.out.println("Count: " + maxHeightTreeIteration(tree.root));

        System.out.println("Count Recursion: " + maxHeightTreeRecursion(tree.root));
    }
}
