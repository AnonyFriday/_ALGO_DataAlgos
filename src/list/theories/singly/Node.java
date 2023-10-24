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
public class Node<E> {

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
