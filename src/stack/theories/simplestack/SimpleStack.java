/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.theories.simplestack;

/**
 *
 * @author duyvu
 */
public class SimpleStack<E extends Comparable<E>> {

    // ======================================
    // = Fields
    // ======================================
    private Node head;

    // ======================================
    // = Constructor
    // ======================================
    public SimpleStack() {
        this.head = null;
    }

    // ======================================
    // = Utility Methods
    // ======================================
    /**
     * Push element from the top of the stack
     *
     * @param info
     */
    public void push(E info) {
        Node p = new Node(info);
        if (isEmpty()) {
            this.head = p;
        } else {
            p.nextNode = this.head;
            head = p;
        }
    }

    /**
     * Pop out the top of the stack
     *
     * @return element being popped out
     */
    public E pop() {
        if (isEmpty()) {
            return null;
        }

        // Return the top node
        Node topNode = this.head;
        this.head = topNode.nextNode;
        return (E) topNode.getInfo();
    }

    /**
     * Viewing the top without removing it
     *
     * @return
     */
    public E top() {
        if (isEmpty()) {
            return null;
        }
        Node topNode = this.head;
        return (E) topNode.getInfo();
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
