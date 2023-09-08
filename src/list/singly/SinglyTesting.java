/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.singly;

/** Create the Node for the List data structure
 *
 * @author duyvu
 */
class Node<T> {

    private T data;
    protected Node nextNode;

    // Parameterized Constructor
    public Node(T data) {
        this.data = data;
        nextNode = null;
    }

    // Getters & Setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

/**
 * Simulating the Linked List of Value
 *
 * @author duyvu
 */
public class SinglyTesting {

    private Node head;
    private Node tail;
    private int count;

    /**
     * At first, initialize the head
     */
    public SinglyTesting() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Adding the first element to the empty list
     *
     * @param node
     */
    private void addIfListEmpty(Node node) {

        // If node is the first element in the array
        head = node;
        tail = node;
        node.nextNode = null;
    }

    /**
     * Add Node to head of the list
     *
     * @param node
     */
    public void addFirst(Node node) {
        // If the node is null
        if (node == null) {
            return;
        }

        // If the list is empty
        if (this.isEmply()) {
            addIfListEmpty(node);
        } else {
            node.nextNode = this.head;
            this.head = node;
        }
        this.count++;
    }

    /**
     * Add the Node the end of the list
     *
     * The tail reference is pointing to the last object Node
     * Set the nextNode of the last object Node to the newly added Node
     * Set the tail reference pointing to the newly added Node
     *
     * @param node: newly created node
     */
    public void addLast(Node node) {
        if (node == null) {
            return;
        }

        // If the list is empty
        if (this.isEmply()) {
            addIfListEmpty(node);
        } else {
            this.tail.nextNode = node;
            this.tail = node;
        }

        // Increment number of nodes by 1
        this.count++;
    }

    /**
     * Remove first element of the linked list
     * <br>
     * Create a temp node pointing to the next Node, while setting the current to null and setting back the head to temp afterward
     */
    public void removeFirst() {
        if (this.isEmply()) {
            return;
        }

        // Create a temp node poining to the next Node after Head Node
        Node temp = this.head.nextNode;

        // Set the current head node = null 
        // In fact, if no pointer points to the Object, the Object will be terminated by the Garbage Collector
//        this.head = null;
        // Set the back the head node to the next node
        this.head = temp;
    }

    /** Remove last element of the linked list
     *
     * Create a temp node pointing to the backward Node, while setting the current tail to null and setting it to temp afterward
     * */
    public void removeLast() {
        if (this.isEmply()) {
            return;
        }

        // contains only 1 node
        if (this.head.nextNode == null) {
            this.head = null;
        }

        // Iterating until reaching the next-to-tail node
        Node temp = this.head;
        while (temp.nextNode != this.tail) {
            temp = temp.nextNode;
        }

        this.tail = temp;
        this.tail.nextNode = null; // Setting null to deference the next node, release the last Object to GC
    }

    // TODO: insert at given position
    
    
    
    
    
    /** Search the Element using the Iterative Approach
     *
     * @param <T> : Represent any Object
     * @param x : Represent the value or the Object (forcing to override the comparable function for the case of Object)
     * @return the first position found in the linked list（0 base position)
     */
    public <T> int searchIterativeApproach(T x) {

        // Predefine exceptions to ignore only 1 element and 0 element
        if (this.head == null) {
            return -1;
        }
        if (this.head.nextNode == null) {
            return 0;
        }

        Node pointer = this.head;
        int pos = 0;
        while (pointer != null) {
            if (pointer.getData().equals(x)) {
                return pos;
            } else {
                pos++;
                pointer = pointer.nextNode;
            }
        }
        return pos;
    }

    /** Search the Element using Recursive Approach
     *
     * <br>**Using Function Overloading to achieve the default function's parameters in Java**
     *
     * @param <T>: Represent any Object
     * @param x: Represent the value or the Object (forcing to override the comparable function for the case of Object)
     * @return the first position found in the linked list（0 base position)
     */
    public <T> int searchRecursiveApproach(T x) {
        return searchRecursiveApproach(this.head, x);
    }

    private <T> int searchRecursiveApproach(Node node, T x) {
        // Entry point to exit if reach the end of list
        if (node == null) {
            return -1;
        }

        // Entry point to exit if the node has been found 
        if (node.getData().equals(x)) {
            return 0;
        }

        // Recursive finding on position
        int pos = searchRecursiveApproach(node.nextNode, x);

        // Are not found
        if (pos == -1) {
            return -1; // If not found, return -1
        } else {
            return pos + 1; // If found, increse the pos by one for each calling function
        }
    }

    /**
     * Traverse the whole link list
     */
    public void traverse() {

        // Create a pointer pointing to head
        Node pointer = head;

        // Traversing until reaching null pointer at the tail
        // - pointing to the next object Node stored inside the pointer.nextNode
        while (pointer != null) {
            System.out.println("Node: " + pointer.getData());
            pointer = pointer.nextNode;
        }
    }

    /**
     * Check if the singly testing is empty or not.
     *
     * @return true if the head is empty
     */
    public boolean isEmply() {
        return head == null;
    }

    /**
     * Clear the list
     */
    public void clear() {
        head = tail = null;
    }
}
