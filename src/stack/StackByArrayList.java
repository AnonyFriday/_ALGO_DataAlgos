/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

import java.util.ArrayList;

/**
 *
 * @author duyvu
 */
public class StackByArrayList<E> extends ArrayList implements StackADT<E> {

    @Override
    public boolean isEmpty() {
	return this.size() == 0;
    }

    @Override
    public void push(E e) {
	this.add(e);
    }

    @Override
    public E pop() {
	if (this.isEmpty()) {
	    return null;
	}
	return (E) this.remove(this.size() - 1);
    }

    @Override
    public E peek() {
	if (this.isEmpty()) {
	    return null;
	}
	return (E) this.get(this.size() - 1);
    }

    public void printAll() {
	for (Object el : this) {
	    System.out.println(el);
	}
    }

    // Main class for testing
    public static void main(String[] args) {
	StackByArrayList<Integer> stack = new StackByArrayList<>();
	stack.push(1);
	stack.push(2);
	stack.push(3);
	stack.push(4);
	stack.push(5);
	stack.push(6);
	stack.pop();

	stack.printAll();

	System.out.println("Size: " + stack.size());
    }

}
