/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue.theories;

import list.theories.singly.Node;
import list.theories.singly.SinglyTesting;

/**
 *
 * @author duyvu
 */
public class QueueByLinkedList<E> implements QueueADT<E> {

    private SinglyTesting<E> list = new SinglyTesting<>();

    @Override
    public void enqueue(E x) {
        Node node = new Node(x);
        list.insertLast(node);
    }

    @Override
    public void dequeue() {
        list.removeFirst();
    }

    @Override
    public E getFront() {
        return (E) list.head.getData();
    }

    @Override
    public E getRear() {
        return (E) list.tail.getData();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmply();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
