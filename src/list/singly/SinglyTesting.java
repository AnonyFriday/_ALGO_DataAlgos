/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.singly;

/** Create the Node
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
     * @param node
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
     * Traverse the whole link list
     */
    public void traverse() {

        // Create a pointer pointing to head
        Node pointer = head;

        // Traversing until reaching null pointer at the tail
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
