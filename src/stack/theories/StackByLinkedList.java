/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.theories;

import java.util.LinkedList;
import list.theories.singly.SinglyTesting;

/**
 * Create a new design pattern
 *
 * @author duyvu
 * @param <E>
 */
public class StackByLinkedList<E> extends LinkedList<E> implements StackADT<E> {

    // Plot the SinglyLinkedList as the core of StackADT
//    private SinglyTesting<E> list;
    /**
     * Default Constructor <br>
     *
     * A newly created stack based on the initial empty singly linked list
     */
    public StackByLinkedList() {
	super();
    }

    @Override
    public void push(E e) {
	this.addFirst(e);
    }

    @Override
    public E pop() {
	return this.removeFirst();
    }

    @Override
    public E peek() {
	return this.peekFirst();
    }

    /**
     * Tests if every opening tag has a matching closing tag in HTML string.
     *
     * @param html
     * @return true if all of html tags has been matched or not
     */
    public boolean isHTMLMatched(String html) {
	StackADT<String> buffer = new StackByLinkedList<>();

	int left = html.indexOf("<");

	while (left != -1) {
	    int right = html.indexOf(">", left + 1); // Find the next right matching
	    if (right == -1) {				// If does not match, return false
		return false;
	    }

	    // Extract the sub-string between <...> and push into the stack
	    // e.g. <html> -> html
	    String tag = html.substring(left + 1, right);

	    // Pusing the opening tag
	    // e.g. <html></html>, -> push only html, not the /html from the closing tag
	    if (!tag.startsWith("/")) {
		buffer.push(tag);
	    } // Checking the closing tag with opening tag in the stack
	    else {

		// If the buffer is false, meanning that the opening did not detected, then return false
		if (buffer.isEmpty()) {
		    return false;
		}

		// e.g. /html -> html, extract the html only 
		// e.g [html, body -> pop -> body then comparing with body
		// if not matched, then return false
		if (!tag.substring(1).equals(buffer.pop())) {
		    return false;
		}
	    }

	    // Find the next left matching, after the first right tag
	    // e.g. <html>..... < -> this one
	    left = html.indexOf("<", right + 1);
	}

	return buffer.isEmpty();
    }

    public void displayyAll() {
	for (Object el : this) {
	    System.out.println(el);
	}
    }

    // Main class for testing
    public static void main(String[] args) {
	StackByLinkedList<Integer> stack = new StackByLinkedList<>();

	// Testing the stack 
	stack.push(1);
	stack.push(2);
	stack.push(3);
	stack.push(4);
	stack.push(5);
	stack.push(99);

	stack.pop();
	stack.displayyAll();

	// Testing the problem tested on the stackbylinkedlist
	System.out.println("isHTMLTagsMatched: " + stack.isHTMLMatched("<html></html>"));
	System.out.println("isHTMLTagsMatched: " + stack.isHTMLMatched("<html><body></html>"));
	System.out.println("isHTMLTagsMatched: " + stack.isHTMLMatched("<html><body</html>"));
	System.out.println("isHTMLTagsMatched: " + stack.isHTMLMatched("<html><body><body></html>"));
	System.out.println("isHTMLTagsMatched: " + stack.isHTMLMatched("<html><body></body></html>"));
	System.out.println("isHTMLTagsMatched: " + stack.isHTMLMatched("<html><body></></html>"));
    }
}
