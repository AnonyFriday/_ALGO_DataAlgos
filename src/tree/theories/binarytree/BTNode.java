/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.theories.binarytree;

/**
 *
 * @author duyvu
 */
public class BTNode<T extends Comparable<T>> {

    // ======================================
    // = Fields
    // ======================================
    private T data;
    protected BTNode<T> left;
    protected BTNode<T> right;

    // ======================================
    // = Constructor
    // ======================================
    public BTNode(T data) {
	this.data = data;
    }

    // ======================================
    // = Getters & Setters
    // ======================================
    public T getData() {
	return data;
    }

    public void setData(T data) {
	this.data = data;
    }

}
