/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.theories.simplestack;

/**
 *
 * @author duyvu
 */
public class Node<E> {

    // ======================================
    // = Fields
    // ======================================
    private E info;
    Node nextNode;

    // ======================================
    // = Constructor
    // ======================================
    Node(E info,
         Node next) {
        this.info = info;
        this.nextNode = next;
    }

    Node(E info) {
        this(info, null);
    }

    // ======================================
    // = Getters & Setters
    // ======================================
    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }
}
