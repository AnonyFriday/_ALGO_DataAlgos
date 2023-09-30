/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package queue;

/**
 *
 * @author duyvu
 */
public interface QueueADT<E> {

    // Take the first element that comes first
    public abstract void enqueue(E x);

    // Take the last elemet that comes last
    public abstract void dequeue();

    // Get the first element without removing it
    public abstract E getFront();

    // Get the last element without removing it
    public abstract E getRear();

    // Check whether it's full or not
    public abstract boolean isFull();

    // Check whether it's empty or not
    public abstract boolean isEmpty();

    // Check the total size of the queue
    public abstract int size();

    public abstract void displayAll();
}
