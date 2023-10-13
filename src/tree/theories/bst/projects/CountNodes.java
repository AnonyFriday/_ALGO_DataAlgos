/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.theories.bst.projects;

import java.util.LinkedList;
import java.util.Queue;
import tree.theories.bst.theories.BTNode;
import tree.theories.bst.theories.BTree;

/**
 *
 * @author duyvu
 */
public class CountNodes {

    /**
     * Counting number of nodes within the tree
     *
     * @param root: given root
     * @return no. of nodes
     */
    public static int countNodes(BTNode root) {

	// If the tree is empty then return 0
	if (root == null) {
	    return 0;
	}

	// Counting the total of nodes in the tree by applying breadth first search
	int count = 0;
	Queue<BTNode> tmpQueue = new LinkedList<>();

	BTNode currNode = root;
	tmpQueue.add(currNode);

	while (!tmpQueue.isEmpty()) {
	    currNode = tmpQueue.remove();
	    count++;

	    // Adding both left and right of the current node to the list if found
	    if (currNode.left != null) {
		tmpQueue.add(currNode.left);
	    }

	    if (currNode.right != null) {
		tmpQueue.add(currNode.right);
	    }
	}

	return count;
    }

    /**
     * Testing purpose
     *
     * @param args
     */
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

	System.out.println("Count: " + countNodes(tree.root));
    }
}
