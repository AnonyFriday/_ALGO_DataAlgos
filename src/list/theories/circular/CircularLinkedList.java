/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.theories.circular;

public class CircularLinkedList<E> {

    // =============================
    // == Fields
    // =============================
    private Node<E> tail;       // we store tail (but not head)
    private int size;           // number of nodes in the list

    // =============================
    // == Constructor
    // =============================
    public CircularLinkedList() {  // constructs an initially empty list 
        size = 0;
        tail = null;
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

    // =============================
    // == Adding Methods
    // =============================
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

    
    // =============================
    // == Remove Methods
    // =============================
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

    // =============================
    // == Utility Methods
    // =============================
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Testing
    public static void main(String[] args) {
        CircularLinkedList<String> list = new CircularLinkedList<>();

        // Test Adding into the Circular Single Linked List
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");
        list.addLast("100");

        System.out.println("First: " + list.first());
        System.out.println("Last: " + list.last());
//        list.removeFirst();
        list.removeAtIndex(4);
        list.printList();

//        // Rotate the circular Linked List
//        list.rotate();
//        System.out.println("First: " + list.first());
//        System.out.println("Last: " + list.last());
//        list.printList();
    }
}
