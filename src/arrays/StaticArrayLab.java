/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrays;

import java.util.Arrays;

/**
 *
 * @author duyvu
 */
public class StaticArrayLab<T> {

    // Initialize variables
    protected final T[] buffer;
    protected int capacity;
    protected int length;

    private static final int DEFAULT_CAPACITY = 100000;

    public StaticArrayLab() {
	this(DEFAULT_CAPACITY, null);
    }

    /**
     * Initialize the array through ellipsis operator
     *
     * @param capacity
     * @param buffer
     */
    @SafeVarargs
    public StaticArrayLab(int capacity, T... buffer) {
	if (capacity <= 0) {
	    this.buffer = (T[]) new Object[DEFAULT_CAPACITY];
	    this.length = 0;
	    this.capacity = DEFAULT_CAPACITY;
	} else if (buffer.length == 0) {
	    this.buffer = (T[]) new Object[capacity];
	    this.length = 0;
	    this.capacity = capacity;
	} else {
	    this.buffer = Arrays.copyOf(buffer, capacity);
	    this.length = buffer.length;
	    this.capacity = capacity;
	}
    }

    /**
     * Checking if the static array having spare spaces or not
     *
     * @return true if enough space, elsereturn false
     */
    private boolean isEnoughLocation() {
	return this.length < this.capacity;
    }

    // Adding element to random index from the array
    public boolean add(T el, int index) {
	if (this.isEnoughLocation()) {

	    // Take O(1) when inserting at the end
	    if ((index == (this.length - 1))) {
		this.buffer[length] = el;

	    } // Take O(n) when inserting at random position
	    else {
		int i = this.length - 1;
		while (i > index - 1) {
		    this.buffer[i + 1] = this.buffer[i];
		    i--;
		}
		this.buffer[index] = el;
	    }

	    // Update the current length
	    this.length++;

	    return true;
	}
	return false;
    }

    /**
     * Remove element at random index from the array
     *
     * @param index
     * @return true if removing is successful, else return false
     */
    public boolean removeAt(int index) {
	if (index >= this.length) {
	    return false;
	}

	int i = index + 1;
	while (i < this.length) {
	    this.buffer[i - 1] = this.buffer[i];
	    i++;
	}
	this.buffer[this.length - 1] = null;

	// Update the current size
	this.length--;
	return true;
    }

    // Remove all the occurrence of the elements from the array
    public int removeOccurence(T value) {

	int countRemoved = 0;

	int i = 0;
	while (i < this.length) {

	    // Handle the case of consecutive targets
	    // If they keep sitting together, keep removing else increase the next index
	    if (this.buffer[i].equals(value) || this.buffer[i].equals(this.buffer[i + 1])) {
		removeAt(i);
		countRemoved++;
	    } else {
		i++;
	    }
	}
	return countRemoved;
    }

    /**
     * Traversing the array
     */
    public void show() {
	System.out.println("\n");
	for (T el : this.buffer) {
	    System.out.print(el + " ");
	}
    }

    public static void main(String[] args) {
	StaticArrayLab<Integer> array = new StaticArrayLab<>(20, 2, 3, 4, 5);

	// Add the element to the array
	array.add(10, 4);
	array.add(10, 3);
	array.add(10, array.length);
	array.add(10, array.length);
	array.add(10, array.length);
	array.add(10, array.length);
	array.add(10, 0);

	array.show();

//	 Remove the element from the array
	array.removeAt(4);
	array.show();

	// Remove all occurence of 10 from the array
	System.out.println("\nRemoved: " + array.removeOccurence(10));
	array.show();
    }
}
