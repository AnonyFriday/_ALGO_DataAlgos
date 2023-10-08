/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue.theories;

/**
 * A queue implemented by using circular array to overcome
 * the inefficient shifting of the traditional array
 *
 *
 *
 * @author duyvu
 * @param <E>
 */
public class QueueByCircularArray<E> implements QueueADT<E> {

    // instanace variables
    private Object[] array;	// generic array used for storage
    private int front;	// index of the front element
    private int rear;	// index of the rear element
    private int size;	// current number of elements

    // Create the class variables
    private final int DEFAULT_CAPACITY;

    // Default Constructor
    public QueueByCircularArray() { // constructs queue with default capacity
        this(100);
    }

    // Constructor having capacity
    public QueueByCircularArray(int capacity) {
        array = new Object[capacity];
        this.DEFAULT_CAPACITY = capacity;
        size = 0;
        front = rear = -1;
    }

    /**
     * Enqueue by forwarding the rear by modular arithmetic
     *
     * <br><br> Enhancing forward the rear to enqueue the element
     * <br><br> isEmpty(), isFull(), normal case
     *
     * @param x: added element
     * @throws IllegalStateException
     */
    @Override
    public void enqueue(E x) {

        // First element in the queue
        // e.g. |x| | | | |
        if (isEmpty()) {
            front = rear = 0;
            array[front] = x;
        } else if (isFull()) {  // When rear == front, notify the queue is full
            System.out.println("Queue is full");
            return;
        } else { // Other scenario, we just forward the rear and add element to it
            rear = ((rear + 1) % array.length);
            array[rear] = x;
        }

        // Increase the size of the queue
        size++;
    }

    /**
     * Dequeue the element by enhancing the front
     *
     * <br><br> isEmpty(), only 1 element, normal case
     */
    @Override
    public void dequeue() {
        // When the queue is empty
        if (isEmpty()) {
            System.out.println("The queue is empty. Cannot dequeue");
            return;

            // when front equals to rear, meaning only 1 element
        } else if (front == rear) {
            array[front] = null;
            front = rear = -1;

            // set the current is null and forward the front
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
            return (E) array[front];
        }
    }

    @Override
    public E getRear() {
        if (this.isEmpty()) {
            return null;
        } else {
            return (E) array[rear];
        }
    }

    public boolean isFull() {
        // first | | | | | last   
        // | | | | | first | last | | 

        // Old version using (read + 1) % size == front
        return (front == 0 && rear == - 1) ||
               front == rear + 1;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
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
