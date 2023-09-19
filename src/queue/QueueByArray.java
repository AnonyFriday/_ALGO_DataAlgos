/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue;

import arrays.StaticArrayLab;
import java.util.Arrays;

/**
 *
 * @author duyvu
 * @param <E>
 */
public class QueueByArray<E> extends StaticArrayLab<E> implements QueueADT<E> {

    // Queue's Variable
    protected int head, tail;

    // Supply default 10
    public QueueByArray() {
	super(10);
    }

    public QueueByArray(int capacity, E... buffer) {
	super(capacity, buffer);
	head = tail = -1;
    }

    @Override
    public void enqueue(E x) {
	if (isEmpty()) {
	    return;
	}
	this.buffer[length - 1] = x;
	length++;
    }

    @Override
    public void dequeue(E x) {
	if (isEmpty()) {
	    return;
	}
	for (int i = 0; i < this.length - 1; i++) {
	    this.buffer[i] = this.buffer[i + 1];
	}
	this.length--;
    }

    @Override
    public int getFront() {
	if (isEmpty()) {
	    return -1;
	} else {
	    return 0;
	}
    }

    @Override
    public int getRear() {
	if (isEmpty()) {
	    return -1;
	} else {
	    return this.length - 1;
	}
    }

    @Override
    public boolean isFull() {
	return (this.length == this.capacity);
    }

    @Override
    public boolean isEmpty() {
	return this.length == 0;
    }

    @Override
    public int size() {
	return this.length;
    }

    @Override
    public void displayAll() {
	for (int i = 0; i < this.length; i++) {
	    System.out.println(this.buffer[i]);
	}
    }

    // Main entry for testing
    public static void main(String[] args) {
	QueueByArray<Integer> queue = new QueueByArray<>(100, 1, 2, 3, 4, 5);

	queue.displayAll();
    }

}
