/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.heap.theories;

import java.util.ArrayList;
import tree.node.HeapNode;
import utilities.HelperFunctions;

/**
 * A class to implement Binary Heap
 *
 * @author duyvu
 */
public class HeapTree {

    // ======================================
    // = Fields
    // ======================================
    private HeapNode[] buffer;
    private final int DEFAULT_SIZE = 1024;	// default size is 1024 bytes
    private int size;

    // ======================================
    // = Constructors
    // ======================================
    public HeapTree() {
        buffer = new HeapNode[DEFAULT_SIZE];
        size = 0;
    }

    // ======================================
    // = Create Methods
    // ======================================
    /**
     * Add new data to the array including heaptified method
     *
     * @param data
     */
    public void insert(Comparable data) {

        // If the heap is full
        if (size >= DEFAULT_SIZE) {
            return;
        }

        // Create new node based on given data
        HeapNode newNode = new HeapNode(data);

        // If the array is empty
        if (size == 0) {
            buffer[0] = newNode;
        } else {
            // Adding to the end then comparing the father
            /* e.g. 30 20 21 99 0| 25 -> add 25 to the heap
             *       0  1  2  3 4  5
             *                     newIdx
             *                     data
             *
             * e.g. 30 20 21 99 0| 21 -> add 25 to the heap
             *       0  1  2  3 4  5
             *             newIdx
             *                     data
             * 
             * e.g. 30 20 25 99 0| 21 -> add 25 to the heap
             *       0  1  2  3 4  5
             *             newIdx
             *                     data
             */
            // father = floor(idxChild / 2) 
            int newIdx = size;

            // If data > father, then move down father
            while (newIdx > 0
                    && data.compareTo(this.buffer[parentIdx(newIdx)].data) > 0) {

                // Move the father less than the child to the right
                // Go to the next father
                buffer[newIdx] = buffer[parentIdx(newIdx)];
                newIdx = parentIdx(newIdx);
            }

            // Attach the newNode to the final newIdx
            this.buffer[newIdx] = newNode;
        }

        // Increate the size after adding
        this.size++;
    }

    /**
     * Build heap from the array
     *
     * @param arr
     */
    public void insertArr(Comparable... arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    // ======================================
    // = Delete Methods
    // ======================================
    /**
     * Delete A top of the heap
     *
     * <br><br>Swap the first and last of the heap
     * <br><br>Reduce the size - 1
     * <br><br>Heapify the array by comparing the new root to its children
     *
     * @return
     */
    public HeapNode deleteNode() {
        // If size is empty then return nothing
        if (isEmpty()) {
            return null;
        }

        // 1. Remove the first root data of the array
        // 2. Deduct the length of array, and add the deletedNode to the size of the array
        HeapNode removedNode = new HeapNode(buffer[0].data);
        HelperFunctions.swap(buffer, 0, size - 1);
        size--;

        // After insertted the node. check the left and right child
        // Stop the iteration after reaching the size
        int currParent = 0;
        int largest = -1;
        int left = -1;
        int right = -1;

        while (true) {

            /**
             * e.g.
             * parentIdx: 1 (default largestIdx)
             * left : 1 * 2 + 1 =
             */
            largest = currParent;
            left = leftIdx(currParent);
            right = rightIdx(currParent);

            // if left > largest and have left child, set to left
            if (left < size && buffer[left].data.compareTo(buffer[largest].data) > 0) {
                largest = left;
            }

            // if right > largest and have right child, set to right
            if (right < size && buffer[right].data.compareTo(buffer[largest].data) > 0) {
                largest = right;
            }

            // If largest has change, maen we swap it
            if (largest != currParent) {
                HelperFunctions.swap(buffer, largest, currParent);
                currParent = largest;
            } else {

                // If they are the same means parent is the largest now
                break;
            }
        }

        // Return the node after being deleted
        return removedNode;
    }
// ======================================
// = Helper Methods
// ======================================

    /**
     * Left child index
     *
     * @param i passed parent index
     *
     * @return
     */
    private int leftIdx(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    /**
     * Right child index
     *
     * @param i passed parent index
     *
     * @return
     */
    private int rightIdx(int parentIdx) {
        return 2 * parentIdx + 2;
    }

    /**
     * Return the parent index
     *
     * @param childIdx
     *
     * @return
     */
    private int parentIdx(int childIdx) {
        return (childIdx - 1) / 2;
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
        return this.size == 0;
    }

    /**
     * Print the tree in In Order matter
     *
     * @param prefix
     * @param arr
     * @param index
     */
    public void printInOrderTree(String prefix, HeapNode[] arr, int index) {
        if (index < size && (arr[index] != null)) {
            printInOrderTree("\t" + prefix, arr, rightIdx(index));
            System.out.println(prefix + arr[index].data.toString());
            printInOrderTree("\t" + prefix, arr, leftIdx(index));
        }
    }

    public void printHeapSort(Comparable... arr) {
        insertArr(arr);

        printAll();
        System.out.println("");
        printInOrderTree("|___", buffer, 0);

        while (size != 0) {
            System.out.println("Delete Node: " + deleteNode().data);
            System.out.println("------------------------------------");
            printAll();
            System.out.println("");
            printInOrderTree("|___", buffer, 0);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = buffer[i].data;
            System.out.println(arr[i]);
        }
    }

    /**
     * Print all the array
     *
     * @param args
     */
    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[i].data.toString() + " ");
        }
    }

    public static void main(String[] args) {
        HeapTree tree = new HeapTree();

        // Heapify
        Integer[] arr = new Integer[]{99, 98, 97, 0, 10, 20, 30, 25, 5, 40, 35};
//        tree.insertArr(arr);
//
//        tree.printInOrderTree("\t", tree.buffer, 0);
//        tree.printAll();
//        System.out.println("Tree size: " + tree.size);
//
//        // After Delete
//        System.out.println("\n\nNode deleted: " + tree.deleteNode().data);
//        System.out.println("\n\nNode deleted: " + tree.deleteNode().data);
//        System.out.println("\n\nNode deleted: " + tree.deleteNode().data);
//        System.out.println("\n\nNode deleted: " + tree.deleteNode().data);
//        System.out.println("\n\nNode deleted: " + tree.deleteNode().data);
//        System.out.println("\n\nNode deleted: " + tree.deleteNode().data);
//        System.out.println("\n\nNode deleted: " + tree.deleteNode().data);
//        System.out.println("\n\nNode deleted: " + tree.deleteNode().data);

        tree.printHeapSort(arr);
//        tree.printInOrderTree("\t", tree.buffer, 0);
//        tree.printAll();
//        System.out.println("Tree size: " + tree.size);
    }
}
