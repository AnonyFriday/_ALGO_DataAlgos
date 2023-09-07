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
    private final T[] buffer;
    private final int capacity;
    public int length;

    /**
     * Initialize the array through ellipsis operator
     *
     * @param capacity
     * @param buffer
     */
    @SafeVarargs
    public StaticArrayLab(int capacity, T... buffer) {
	if (buffer.length < 0) {
	    throw new IllegalArgumentException("Do no provide values for dummy argument.");
	}
	this.buffer = Arrays.copyOf(buffer, capacity);
	this.capacity = capacity;
	this.length = buffer.length;
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
}
