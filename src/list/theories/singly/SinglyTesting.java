/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.theories.singly;

/**
 * Create the Node for the List data structure
 *
 * @author duyvu
 */
class Node<E> {

    private E data;
    protected Node nextNode;

    // Parameterized Constructor
    public Node(E data) {
	this.data = data;
	nextNode = null;
    }

    // Getters & Setters
    public E getData() {
	return data;
    }

    public void setData(E data) {
	this.data = data;
    }
}

/**
 * Simulating the Linked List of Value
 *
 * @author duyvu
 */
public class SinglyTesting<E> {

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

    // =============================
    // == Adding Method Groups
    // =============================
    /**
     * Adding the first element to the empty list
     *
     * @param node
     */
    private void insertIfListEmpty(Node node) {

	// If node is the first element in the array
	head = node;
	tail = node;
	node.nextNode = null;
	this.count++;
    }

    /**
     * Add Node to head of the list
     *
     * @param node
     */
    public void insertFirst(Node node) {
	// If the node is null
	if (node == null) {
	    return;
	}

	// If the list is empty
	if (this.isEmply()) {
	    insertIfListEmpty(node);
	} else {
	    node.nextNode = this.head;
	    this.head = node;

	    // Increment number of nodes by 1
	    this.count++;
	}
    }

    /**
     * Add the Node the end of the list
     *
     * The tail reference is pointing to the last object Node Set the nextNode of the last object Node to the newly
     * added Node Set the tail reference pointing to the newly added Node
     *
     * @param node: newly created node
     */
    public void insertLast(Node node) {
	if (node == null) {
	    return;
	}

	// If the list is empty
	if (this.isEmply()) {
	    insertIfListEmpty(node);
	} else {
	    this.tail.nextNode = node;
	    this.tail = node;

	    // Increment number of nodes by 1
	    this.count++;
	}
    }

    /**
     * Adding Node to the specific position
     *
     * @param node
     * @param pos
     */
    public void add(Node node,
	    int pos) {
	// when no elements, adding to the list
	if (this.isEmply()) {
	    this.insertIfListEmpty(node);
	    return;
	} else if (pos == 0) {
	    this.insertFirst(node);
	    return;
	} else if (pos == this.count - 1) {
	    this.insertLast(node);
	    return;
	} else if (pos >= this.count) {
	    return;
	}

	// seting the temp node before the target position
	Node temp = this.head;
	while (pos > 1) {
	    temp = temp.nextNode;
	    pos--;
	}

	// Switching a referecne of temp node and next node
	node.nextNode = temp.nextNode;
	temp.nextNode = node;
	this.count++;
    }

    // =============================
    // == Reverse Method Groups
    // =============================
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

    // =============================
    // == Remove Method Groups
    // =============================
    /**
     * Remove first element of the linked list
     * <br>
     * Create a temp node pointing to the next Node, while setting the current to null and setting back the head to temp
     * afterward
     */
    public void removeFirst() {
	if (this.isEmply()) {
	    return;
	}

	// contains only 1 node
	if (this.head.nextNode == null) {
	    this.head = null;
	    this.count--;
	    return;
	}

	// Create a temp node poining to the next Node after Head Node
	Node temp = this.head.nextNode;

	// Set the current head node = null 
	// In fact, if no pointer points to the Object, the Object will be terminated by the Garbage Collector
//        this.head = null;
	// Set the back the head node to the next node
	this.head = temp;
	this.count--;
    }

    /**
     * Remove last element of the linked list
     *
     * Create a temp node pointing to the backward Node, while setting the current tail to null and setting it to temp
     * afterward
     *
     */
    public void removeLast() {
	if (this.isEmply()) {
	    return;
	}

	// contains only 1 node
	if (this.head.nextNode == null) {
	    this.head = null;
	    this.count--;
	    return;
	}

	// Iterating until reaching the next-to-tail node
	Node temp = this.head;
	while (temp.nextNode != this.tail) {
	    temp = temp.nextNode;
	}

	this.tail = temp;
	this.tail.nextNode = null; // Setting null to deference the next node, release the last Object to GC
	this.count--;
    }

    public void removeAt(int pos) {

	// Does not remove when the list is empty
	if (this.isEmply()) {
	    return;
	} else if (pos == 0) {
	    this.removeFirst();
	    return;
	} else if (pos == this.count - 1) {
	    this.removeLast();
	    return;
	}

	// Track the node before the target node
	Node temp = this.head;
	Node tempAfter = temp.nextNode;
	while (pos > 2) {
	    temp = temp.nextNode;
	    tempAfter = tempAfter.nextNode;
	    pos--;
	}

	temp.nextNode = tempAfter.nextNode;
    }

    // =============================
    // == Search Method Groups
    // =============================
    /**
     * Search the Element using the Iterative Approach
     *
     * @param x : Represent the value or the Object (forcing to override the comparable function for the case of Object)
     * @return the first position found in the linked list（0 base position)
     */
    public int searchIterativeApproach(E x) {

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

    /**
     * Search the Element using Recursive Approach
     *
     * <br>**Using Function Overloading to achieve the default function's parameters in Java**
     *
     * @param x: Represent the value or the Object (forcing to override the comparable function for the case of Object)
     * @return the first position found in the linked list（0 base position)
     */
    public int searchRecursiveApproach(E x) {
	return searchRecursiveApproach(this.head, x);
    }

    private int searchRecursiveApproach(Node node,
	    E x) {
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

    // =============================
    // == Utilities Method Groups
    // =============================
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

    /**
     * Return the total nodes of the linked list
     *
     * @return
     */
    public int size() {
	return this.count;
    }
}
