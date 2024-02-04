/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.theories;

import java.util.LinkedList;
import list.theories.singly.SinglyLinkedList;

/**
 * Create a new design pattern
 *
 * @author duyvu
 * @param <E>
 */
public class StackByLinkedList<E> implements StackADT<E> {

    // ====================================
    // = Fields
    // ====================================
    // Plot the SinglyLinkedList as the core of StackADT
    private LinkedList<E> list;

    // ====================================
    // = Constructors
    // ====================================
    /**
     * Default Constructor <br>
     *
     * A newly created stack based on the initial empty singly linked list
     */
    public StackByLinkedList() {
        list = new LinkedList<E>();
    }

    // ====================================
    // = Methods implemented from Interface
    // ====================================
    @Override
    public E push(E e) {
        list.addFirst(e);
        return e;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return list.peekFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        this.clear();
    }

    // ====================================
    // = Methods 
    // ====================================
    public void displayyAll() {
        for (E el : list) {
            System.out.println(el);
        }
    }

    /**
     * Tests if every opening tag has a matching closing tag in HTML string.
     *
     * @param html
     * @return true if all of html tags has been matched or not
     */
    public static boolean isHTMLMatched(String html) {
        // Create a stack to handle tag
        StackADT<String> buffer = new StackByLinkedList<>();

        // <html> : start with <
        // </html>: start with <
        int left = html.indexOf("<");

        while (left != -1) {

            // Check if having closing open paren
            int right = html.indexOf(">", left + 1); // Find the next right matching
            if (right == -1) {				// If does not match, return false
                return false;
            }

            // Extract the sub-string between <...> and push into the stack
            // e.g. <html> -> html
            String tag = html.substring(left + 1, right);
            if (tag == null) {
                return false;                           // If not having tag, return false
            }

            // If html -> push into the buffer
            // If /html -> comparing with the html on top
            if (!tag.startsWith("/")) {
                buffer.push(tag);
            } else {

                // If the buffer is false, meanning that the opening did not detected, then return false
                if (buffer.isEmpty()) {
                    return false;
                }

                // e.g. /html -> html, extract the html only at the 1 st index
                // e.g [html, body -> pop -> body then comparing with body
                if (!tag.substring(1).equals(buffer.pop())) {
                    return false;
                }
            }

            // Find the next left matching, after the first right tag
            // e.g. <html>..... < -> this one
            left = html.indexOf("<", right + 1);
        }

        // return true if no tag in the buffer
        return buffer.isEmpty();
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
        System.out.println("isHTMLTagsMatched: " + StackByLinkedList.isHTMLMatched("<html></html>"));
        System.out.println("isHTMLTagsMatched: " + StackByLinkedList.isHTMLMatched("<html><body></html>"));
        System.out.println("isHTMLTagsMatched: " + StackByLinkedList.isHTMLMatched("<html><body</html>"));
        System.out.println("isHTMLTagsMatched: " + StackByLinkedList.isHTMLMatched("<html><body><body></html>"));
        System.out.println("isHTMLTagsMatched: " + StackByLinkedList.isHTMLMatched("<html><body></body></html>"));
        System.out.println("isHTMLTagsMatched: " + StackByLinkedList.isHTMLMatched("<html><body></></html>"));
    }

}
