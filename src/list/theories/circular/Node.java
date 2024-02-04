/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list.theories.circular;

/**
 * A demo of using Circular Linked List and some of its methods
 *
 *
 * @author duyvu
 */
public class Node<E> {

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
