/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.BinaryTree;

/**
 *
 * @author duyvu
 */
public class Node<E> {

    private E data;
    protected Node left;
    protected Node right;

    public Node(E data) {
	this.data = data;
    }

    // Getters & Setters
    public E getData() {
	return data;
    }

    public void setData(E data) {
	this.data = data;
    }
}
