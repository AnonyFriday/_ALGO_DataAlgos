/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue.theories;

/**
 *
 * @author duyvu
 * @param <E>
 */
public class QueueByCircularArray<E> implements QueueADT<E> {

    // instanace variables
    private E[] array;	// generic array used for storage
    private int front;	// index of the front element
    private int rear;	// index of the rear element
    private int size;	// current number of elements

    // Create the class variables
    private static final int DEFAULT_CAPACITY = 100;

    // Default Constructor
    public QueueByCircularArray() { // constructs queue with default capacity
	this(DEFAULT_CAPACITY);	    // 
    }

    // Constructor having capacity
    public QueueByCircularArray(int capacity) {
	array = (E[]) new Object[capacity];
	size = 0;
	front = rear = -1;
    }

    /**
     * Enqueue by forwarding the rear by modular arithmetic
     *
     * <br><br>Enhancing forward the rear to enqueue the element
     *
     * @param x: added element
     * @throws IllegalStateException
     */
    @Override
    public void enqueue(E x) {

	// First element in the queue
	// e.g. |x| | | | |
	if (front == -1 && rear == -1) {
	    front = rear = 0;
	    array[rear] = x;
	} else if (((rear + 1) % array.length) == front) {  // When rear == front, then throw the queue is full
	    System.out.println("Queue is full");
	    return;
	} else { // Other scenario, we just forward the rear
	    rear = ((rear + 1) % array.length);
	    array[rear] = x;
	}

	// Increase the size of the queue
	size++;
    }

    /**
     * Dequeue the element by enhancing the front
     *
     */
    @Override
    public void dequeue() {
	// When the queue is empty
	if (front == -1 && rear == -1) {
	    System.out.println("The queue is empty. Cannot dequeue");
	    return;
	} else if (front == rear) { // when front equals to rear, meaning that the queue is empty
	    array[front] = null;
	    front = rear = -1;
	} else {
	    array[front] = null;
	    front = (front + 1) % array.length;
	}
	size--;
    }

    @Override
    public E getFront() {
	if (this.isEmpty()) {
	    return null;
	} else {
	    return array[front];
	}
    }

    @Override
    public E getRear() {
	if (this.isEmpty()) {
	    return null;
	} else {
	    return array[rear];
	}
    }

    @Override
    public boolean isFull() {
	return size == array.length;
    }

    @Override
    public boolean isEmpty() {
	return size == 0;
    }

    @Override
    public int size() {
	return size;
    }

//    |     |    |     |     |   |   |
//           rear	front  
    @Override
    public void displayAll() {
	if (isEmpty()) {
	    System.out.println("Queue is empty");
	} else {
	    int i = front;
	    while (i != rear) {
		System.out.println(array[i] + " ");
		i = (i + 1) % array.length;
	    }
	    System.out.println(array[i]);
	}
    }

    // Main method for testing
    public static void main(String[] args) {
	QueueByCircularArray<Integer> queue = new QueueByCircularArray<>(10);

	// Queue testing
	queue.enqueue(2);
	queue.enqueue(-1);
	queue.enqueue(5);
	queue.enqueue(6);
	queue.enqueue(7);
	queue.enqueue(6);
	queue.enqueue(100);

	// Dequeue testing
	queue.dequeue();
	queue.dequeue();
	queue.dequeue();
	queue.dequeue();
	queue.dequeue();

	queue.displayAll();
    }
}
