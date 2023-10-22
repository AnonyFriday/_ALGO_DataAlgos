/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph.theories;

import java.util.LinkedList;

/**
 *
 * @author duyvu
 */
public class CustomQueue<T> extends LinkedList<T> {

    // Constructor
    public boolean isEmpty() {
        return this.isEmpty();
    }

    public void enqueue(T el) {
        this.add(el);
    }

    public T dequeue() {
        return this.removeFirst();
    }
}
