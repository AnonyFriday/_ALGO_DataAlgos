/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.circular;

/** A demo of using Circular Linked List and some of its methods
 *
 *
 * @author duyvu
 */
class Node<E> {

    private E data;
    private Node nextNode;

    public Node(E data) {
        this.data = data;
    }

    // getters & setters for nextNode variables
    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    // getters & setters for the data variables
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}

public class CircularTesting<E> {

    // instance variables of the CircularlyLinkedList
    private Node<E> tail;       // we store tail (but not head)
    private int size;           // number of nodes in the list

    public CircularTesting() {  // constructs an initially empty list 
        size = 0;
        tail = null;
    }

    // access methods group
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return (E) tail.getNextNode().getData();    // the head is *after* the tail
    }

    public E last() {  // return the last element
        if (isEmpty()) {
            return null;
        }
        return tail.getData();
    }

    // update methods group
    public void rotate() {
        if (tail != null) {                 // if empty, do nothing
            tail = tail.getNextNode();      // the old head becomes the new tail
        }
    }

    public void addFirst(E e) {

        // If the list is empty
        if (this.isEmpty()) {
            // Linking to itself circularly
            tail = new Node<>(e);
            tail.setNextNode(tail);
        } else {
            Node<E> newNode = new Node<>(e);
            newNode.setNextNode(tail.getNextNode());
            tail.setNextNode(newNode);
        }
        size++;
    }

    public void addLast(E e) {      // add elements to the end of the list
        addFirst(e);                // insert new element at front of list
        tail = tail.getNextNode();  // now new element becomes the tail                                      
    }

    // remove methods group
    public E removeFirst() {    // remove and return the first element
        if (isEmpty()) {        // if the list is empty
            return null;
        }
        Node<E> temp = tail.getNextNode();
        if (size == 1) {        // Only 1 node in the list
            tail = null;
        } else {
            tail.setNextNode(temp.getNextNode());
        }
        size--;
        return temp.getData();
    }

    public E removeAtIndex(int pos) {   // 1th is considered a baseindex
        if (this.isEmpty() || pos > size || pos <= 0) {
            return null;
        }
        if (pos == 1) {             // Remove the first if the pos = 0
            return removeFirst();
        } else {
            Node<E> headNode = this.tail.getNextNode();
            Node<E> nextHeadNode = headNode.getNextNode();

            // Iterating untill the nextHeadNode is the target
            for (int i = 0; i < pos - 2; i++) {
                headNode = headNode.getNextNode();
                nextHeadNode = headNode.getNextNode();
            }

            // Handle the case of deleting last node to assign tail to the new node
            if (pos == size) {
                this.tail = nextHeadNode.getNextNode();
            }

            // Linking the tail to the head node
            headNode.setNextNode(nextHeadNode.getNextNode());
            return headNode.getData();
        }
    }

    // traverse
    public void printList() {
        if (this.isEmpty()) { // if the list is empty, return nothing
            return;
        }

        Node<E> temp = this.tail;
        do {
            System.out.println(temp.getData() + "->");   // print the first base case
            temp = temp.getNextNode();
        } while (temp != this.tail);
    }
}
