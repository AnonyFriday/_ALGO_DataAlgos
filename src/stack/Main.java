/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

/**
 *
 * @author duyvu
 */
public class Main {

    public static void main(String[] args) {

	// Testing Stack implemented by Array
	StackByArray<Integer> stackArray = new StackByArray<Integer>();
	Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

	// Testing reverisng the array using Array-based Stack
	StackByArray.reverse(arr);
	System.out.println(arr);

	stackArray.push(1);
	stackArray.push(2);
	stackArray.push(3);

	System.out.println("Matching Parentheses: " + StackByArray.matchingParenthese("{[[{}]]}8988"));

	stackArray.pop();
	stackArray.pop();
//        stackArray.pop();
//        stackArray.pop();

	System.out.println("Top Element: " + stackArray.peek());

    }
}
