/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.node;

/**
 * A node demonstrating a binary heap data structure
 *
 * @author duyvu
 * @param <T>
 */
public class HeapNode<T extends Comparable<T>>{

    // ======================================
    // = Fields
    // ======================================
    public T data;

    // ======================================
    // = Constructors
    // ======================================
    public HeapNode(T data) {
	this.data = data;
    }
}
