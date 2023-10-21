/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.heap.theories;

import java.util.ArrayList;
import tree.node.HeapNode;
import utilities.HelperFunctions;

/**
 * An array implementation of the heap tree
 *
 * @author duyvu
 */
public class HeapTree {

    // ======================================
    // = Fields
    // ======================================
    private HeapNode[] buffer;
    private final int DEFAULT_SIZE = 1024;	// default size is 1024 bytes
    private int length;

    // ======================================
    // = Constructors
    // ======================================
    public HeapTree() {
	buffer = new HeapNode[DEFAULT_SIZE];
	length = 0;
    }

    // ======================================
    // = Create Methods
    // ======================================
    /**
     * Add new data to the array including heaptified method
     *
     * @param newData
     */
    public void addNode(Comparable newData) {

	// Create new node based on given data
	HeapNode newNode = new HeapNode(newData);

	// If the array is empty
	if (length == 0) {
	    buffer[0] = newNode;
	} else {
	    // Adding to the end then comparing the father
	    /* e.g. 30 20 21 | 25 -> add 25 to the heap
                     0  1  2    3
                                newIdx
				newData
	     */
	    // father = floor(index / 2) 
	    int newNodeIdx = length;

	    // Keep pushing the idx for newData to the position upto the right
	    // If data > father, then move down father
	    while (newNodeIdx > 0
		    && newData.compareTo(this.buffer[newNodeIdx / 2].data) > 0) {
		this.buffer[newNodeIdx] = this.buffer[newNodeIdx / 2];		// Move the father less than the child to the right
		newNodeIdx = newNodeIdx / 2;					// Go to the next father
	    }

	    // Attach the newNode to the final newNodeIdx
	    this.buffer[newNodeIdx] = newNode;
	}

	// Increate the length after adding
	this.length++;
    }

    // ======================================
    // = Delete Methods
    // ======================================
    /**
     * Delete A top of the heap
     *
     * <br><br>Put the removedNode after the length of the array
     *
     * @param newData
     * @return
     */
    public HeapNode deleteNode() {
	// If length is empty then return nothing
	if (this.length == 0) {
	    return null;
	}

	// Remove the first root data of the array
	HeapNode removedNode = new HeapNode(buffer[0].data);
	this.buffer[0] = this.buffer[length - 1];   // Copy the last node to the root

	// After insertted the node. check the left and right child
	// Stop the iteration after reaching the size
	int currNewNodeIdx = 0;
	int childNewNodeIdx = currNewNodeIdx * 2 + 1; // first child

	while (childNewNodeIdx < this.length) {
	    // If child > first but second > child, then choose second
	    if (buffer[currNewNodeIdx].data.compareTo(buffer[childNewNodeIdx].data) > 0
		    && buffer[currNewNodeIdx].data.compareTo(buffer[childNewNodeIdx + 1].data) < 0) {
		childNewNodeIdx++;
	    }

	    if (buffer[currNewNodeIdx].data.compareTo(buffer[childNewNodeIdx].data) < 0) {
		HelperFunctions.swap(buffer, currNewNodeIdx, childNewNodeIdx);

		// Current node now will be the child node
		currNewNodeIdx = childNewNodeIdx;
		childNewNodeIdx = currNewNodeIdx * 2;
	    } else {
		// If curr > both childrens then it's correct now 
		break;
	    }
	}

	// Deduct the leng of array, and add the deletedNode 
	// and put removedNode after the length of array in buffer
	buffer[length] = removedNode;
	length--;

	// Return the node after being deleted
	return removedNode;
    }

    // ======================================
    // = Helper Methods
    // ======================================
    /**
     *
     * @return
     */
    public int size() {
	return this.length;
    }

    // ======================================
    // = Sort Methods
    // ======================================
    /**
     * <br><br>Create heap for 'n' elements
     * <br><br>Delete 'n' element in log2(n) time
     */
    /**
     * Determine if the array is empty
     *
     * @return
     */
    public boolean isEmpty() {
	return this.length == 0;
    }

    /**
     * Print the tree in In Order matter
     *
     * @param prefix
     * @param arr
     * @param index
     */
    public void printInOrderTree(String prefix, HeapNode[] arr, int index) {
	if (index < length && (arr[index] != null)) {
	    printInOrderTree("\t" + prefix, arr, index * 2 + 2);
	    System.out.println(prefix + arr[index].data.toString());
	    printInOrderTree("\t" + prefix, arr, index * 2 + 1);
	}
    }

    /**
     * Print all the array
     *
     * @param args
     */
    public void printAll() {
	for (int i = 0; i < length; i++) {
	    System.out.print(buffer[i].data.toString() + " ");
	}
    }

    public static void main(String[] args) {
	HeapTree tree = new HeapTree();
	tree.addNode(1);
	tree.addNode(10);
	tree.addNode(200);
	tree.addNode(2);
	tree.addNode(2);
	tree.addNode(0);
	tree.addNode(99);
	tree.addNode(97);
	tree.addNode(99999);

	// Before Delete
	System.out.println("Tree size: " + tree.size());
	tree.printInOrderTree("\t", tree.buffer, 0);
	tree.printAll();

	// After Delete
	System.out.println("\n\nNode deleted: " + tree.deleteNode().data);
	System.out.println("\n\nNode deleted: " + tree.deleteNode().data);
	System.out.println("\n\nNode deleted: " + tree.deleteNode().data);
	System.out.println("\n\nNode deleted: " + tree.deleteNode().data);
	System.out.println("\n\nNode deleted: " + tree.deleteNode().data);
	System.out.println("\n\nNode deleted: " + tree.deleteNode().data);

	System.out.println("Tree size: " + tree.size());
	tree.printInOrderTree("\t", tree.buffer, 0);
	tree.printAll();
    }
}
