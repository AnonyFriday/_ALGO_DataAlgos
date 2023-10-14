/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.node;

/**
 * This is an abstract class of TreeNode in all type of trees
 *
 * @author duyvu
 * @param <T>
 */
public abstract class TNode<T extends Comparable<T>> {

    // ======================================
    // = Fields
    // ======================================
    public T data;
    public TNode<T> left;
    public TNode<T> right;

    // ======================================
    // = Constructor for inheritance
    // ======================================
    public TNode(T data) {
        this.data = data;
        left = right = null;
    }

    // ======================================
    // = Getters & Setters
    // ======================================
    // For simplicity, I dont apply the encapsulation technique as the data protection
    // The main's class objective is to give access to all attributes for demonstrating algorithms
}
