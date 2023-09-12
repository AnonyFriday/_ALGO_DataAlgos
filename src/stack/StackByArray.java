/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

/**
 * Array-based Stack <br>
 *
 * A stack implemented by Array-based could draw a detrimental resolve on full capacity
 *
 * @author duyvu
 */
public class StackByArray<E> implements StackADT<E> {

    // Attributes
    public static final int CAPACITY;
    private E[] array;
    private int top;

    /**
     * Setting up the static block (static initializer) running at runtime
     */
    static {
        CAPACITY = 3;
    }

    // Default Constructor
    public StackByArray() {
        this(CAPACITY);
    }

    /**
     * Parameterized Constructor
     *
     * @param capacity
     */
    public StackByArray(int capacity) {
        this.array = (E[]) new Object[capacity];
        this.top = -1;
    }

    /**
     * Reverse an array passed to this stack
     *
     * @param <E>: any Objects
     * @param a: a passed array to this function
     */
    public static <E> void reverse(E[] a) {
        StackADT<E> buffer = new StackByArray<>(a.length);
        for (int i = 0; i < a.length; i++) {
            buffer.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = buffer.pop();
        }
    }

    /**
     * Check the stack size
     *
     * @return size of the stack
     */
    @Override
    public int size() {
        return this.top + 1;
    }

    /**
     * Check the stack's emptiness
     *
     * @return true if the stack is empty, otherwise return false
     */
    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * Pushing new element to the stack
     *
     * @param e: a new element being pushed to the top of the stack
     */
    @Override
    public void push(E e) {

        // If the array is full, then we stop pushing new element
        if (this.array.length == this.size()) {
            throw new IllegalStateException("Stack is full");
        }

        // Increment the pointer top by 1 and add element to the ith index
        this.array[++this.top] = e;
    }

    /**
     * Popping the top of the stack
     *
     * @return
     */
    @Override
    public E pop() {

        if (this.isEmpty()) {
            return null;
        }

        E removedElement = this.array[top];
        this.array[top--] = null;
        return removedElement;
    }

    /**
     * Peeking the top of the stack
     *
     * @return
     */
    @Override
    public E peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.array[top];
    }
}
