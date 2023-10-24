/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.bst.theories;

import tree.node.TNode;

/**
 *
 * @author duyvu
 * @param <E>
 */
public class BSTNode<E extends Comparable<E>> {

    // ======================================
    // = Fields
    // ======================================
    public E data;
    public BSTNode<E> left;
    public BSTNode<E> right;

    // ======================================
    // = Constructor for inheritance
    // ======================================
    public BSTNode(E data) {
        this.data = data;
        left = right = null;
    }

    // ======================================
    // = Getters & Setters
    // ======================================
    // For simplicity, I dont apply the encapsulation technique as the data protection
    // The main's class objective is to give access to all attributes for demonstrating algorithms
}
