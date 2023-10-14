/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.bst.projects;

import java.util.LinkedList;
import java.util.Queue;
import static tree.bst.projects.CountNodes.countNodes;
import tree.bst.theories.BTNode;
import tree.bst.theories.BTree;

/**
 *
 * @author duyvu
 */
public class FindTreeHeight {

    public static int maxHeightTree(BTNode root) {

        // If the tree is empty then return 0
        if (root == null) {
            return 0;
        }

        // Counting the total of nodes in the tree by applying breadth first search
        int height = 0;
        Queue<BTNode> tmpQueue = new LinkedList<>();

        BTNode currNode = root;
        tmpQueue.add(currNode);

        while (!tmpQueue.isEmpty()) {
            currNode = tmpQueue.remove();

            // If the queue is empty then increment the height to 1
            if (tmpQueue.isEmpty()) {
                height++;
            }

            // Adding both left and right of the current node to the list if found
            if (currNode.left != null) {
                tmpQueue.add(currNode.left);
            }

            if (currNode.right != null) {
                tmpQueue.add(currNode.right);
            }
        }

        return height;
    }

    public static int maxHeightTreeRecursion(BTNode root) {

        // If empty then return the height = 0
        if (root == null) {
            return 0;
        }

        int maxHeightLeft = maxHeightTreeRecursion(root.left) + 1;
        int maxHeightRight = maxHeightTreeRecursion(root.right) + 1;
        return Math.max(maxHeightLeft, maxHeightRight);
    }

    // This class is for testing
    public static void main(String[] args) {
        BTree<Integer> tree = new BTree<>();
        tree.addNode(12);
        tree.addNode(9);
        tree.addNode(1);
        tree.addNode(100);
        tree.addNode(101);
        tree.addNode(102);
        tree.addNodeIteration(2);
        tree.addNodeIteration(0);
        tree.addNodeIteration(1000);
        BTree.print("\t\t", tree.root);

        System.out.println("Count: " + maxHeightTree(tree.root));

        System.out.println("Count Recursion: " + maxHeightTreeRecursion(tree.root));
    }
}
