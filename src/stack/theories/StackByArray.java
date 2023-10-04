/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.theories;

/**
 * Array-based Stack <br>
 *
 * A stack implemented by Array-based could draw a detrimental resolve on full capacity
 *
 * @author duyvu
 */
public class StackByArray<E> implements StackADT<E> {

    // ====================================
    // = Fields
    // ====================================
    public static final int CAPACITY;
    private E[] array;
    private int top;

    // ====================================
    // = Constructors
    // ====================================
    /**
     * Setting up the static block (static initializer) running at runtime
     */
    static {
        CAPACITY = 100;
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

    // ====================================
    // = Methods
    // ====================================
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
     * Matching Parentheses in a string
     * e.g."[vu kim duy]"
     *
     * | [( | and ) -> if 1 pair is matched, then take out the ( at the stack
     *
     * @param <E>
     * @param expression
     * @return
     */
    public static <E> boolean matchingParenthese(String expression) {

        // Initialize the variables 
        final String opening = "{[(";
        final String closing = "}])";

        // Initialize the buffer for storing opening parathenese
        StackByArray<Character> buffer = new StackByArray<>();
        for (char c : expression.toCharArray()) {

            // bottom [......
            // bottom ....... -> pop [ and compare ] in closing
            if (opening.indexOf(c) != -1) {
                buffer.push(c);
            } // Extracting the character from the string and comparing if matching is found 
            else if (closing.indexOf(c) != -1) {

                // Assume that if the current buffer is null then we turn false since there is nothing for comparision
                if (buffer.isEmpty()) { // In case there is no opening parenthesis due to the missing the left one then return false
                    return false;
                }

                // Checking if the } in the closing matching with the { located in the buffer 
                // { at index 0 in opening == } at index 0 in closing
                // If they are a pair {} or 1 == 1
                if (closing.indexOf(c) != opening.indexOf(buffer.pop())) {
                    // |.....{ | == -> 1 == 1
                    // |.....}|
                    return false;
                }
            }
        }

        // If the whole process resolves in the empty Stack, which means the expression is true
        return buffer.isEmpty();
    }

    /**
     * Checking if the array is full or not
     *
     * @return true if the array is full, otherwise return false
     */
    public boolean isFull() {
        return top == (CAPACITY - 1);
    }

    /**
     * Display all element within the stack
     */
    public void displayAll() {
        for (int i = 0; i < size(); i++) {
            System.out.println(array[i]);
        }
    }

    // ====================================
    // = Methods implemented from Interface
    // ====================================
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
     * @return a newly pushed element
     */
    @Override
    public E push(E e) {
        // If the array is full, then we stop pushing new element
        if (isFull()) {
            return null;
        }

        // Increment the pointer top by 1 and add element to the ith index
        this.array[++this.top] = e;
        return e;
    }

    /**
     * Popping the top of the stack
     *
     * @return
     */
    @Override
    public E pop() {
        // If the stack is empty then no popping
        if (this.isEmpty()) {
            return null;
        }

        // Remove the top of the stack
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

        // If the stack is empty then no peeking
        if (this.isEmpty()) {
            return null;
        }
        return this.array[top];
    }

    /**
     * Clear the stack immediately
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    // Testing
    public static void main(String[] args) {
        StackByArray<Integer> stackArray = new StackByArray<Integer>();

        // Testing push()
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);
        stackArray.displayAll();

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Testing reverisng the array using Array-based Stack
        StackByArray.reverse(arr);

        // Testing matchingParenthese function
        System.out.println("Matching Parentheses: " + StackByArray.matchingParenthese("{[[{}]]}8988"));

        // Testing pop()
        stackArray.pop();
        stackArray.pop();
//        stackArray.pop();
//        stackArray.pop();

        System.out.println("Top Element: " + stackArray.peek());

    }
}
