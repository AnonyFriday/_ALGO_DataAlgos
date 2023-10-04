/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.theories;

/** Stack
 *
 * Follow the procedure LIFO
 *
 *
 * Application on Matching delimiters
 *
 * @author duyvu
 */
public interface StackADT<E> {

    /**
     * Return the number of elements in the stack
     *
     * @return number of elements in stack
     */
    public int size();

    /**
     * Check if the stack is empty or not
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Insert an element at the top of the stack
     *
     * @param e the element to be inserted
     */
    public E push(E e);

    /**
     * Remove and returns the top element from the stack
     *
     * @return element removed (or null if empty)
     */
    public E pop();

    /**
     * Return but not remove the element from the top
     *
     * @return element from the top of the stack
     */
    public E peek();

    /**
     * Clear the stack
     */
    public void clear();
}
