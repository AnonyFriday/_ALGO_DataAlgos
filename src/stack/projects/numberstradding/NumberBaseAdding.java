/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.projects.numberstradding;

import stack.theories.StackByLinkedList;

/**
 * Adding 2 number as the string using stack
 *
 * @author duyvu
 */
public class NumberBaseAdding {

    /**
     * A function to add 2 string typed number arithmetically and output the result as the string
     *
     * @param num1: string typed number 1
     * @param num2: string typed number 2
     * @return a result of 2 operands
     */
    public static String add(String num1, String num2) {

	// 1511 + 1591 = 3102
	// start extracting digit of 2 string from the right most
	// push each digit of both number to each operand's stack
	// when popping out is the 1s unit, adding together and increase carry by 1 if overflowing 10
	StackByLinkedList<Character> sOperand_1 = new StackByLinkedList<>();
	StackByLinkedList<Character> sOperand_2 = new StackByLinkedList<>();
	StackByLinkedList<Character> result = new StackByLinkedList<>();

	for (int i = 0; i < num1.length(); i++) {
	    sOperand_1.push(num1.charAt(i));
	}

	for (int i = 0; i < num2.length(); i++) {
	    sOperand_2.push(num2.charAt(i));
	}

	// Start extracting the character typed digit from both stack
	// case 1: if length are difference, assign 0 as default for the lesser
	// case 2: if length are equal, converting to digit and adding together
	// => while exxecute when at least 1 stack still have element
	char d1, d2;
	Integer carry = 0;
	while (!sOperand_1.isEmpty() || !sOperand_2.isEmpty()) {
	    d1 = sOperand_1.isEmpty() ? '0' : sOperand_1.pop();
	    d2 = sOperand_2.isEmpty() ? '0' : sOperand_2.pop();

	    add(carry, d1, d2, result);
	}

	String resultStr = "";
	while (!result.isEmpty()) {
	    resultStr += result.pop();
	}
//	result.displayyAll();

	return resultStr;
    }

    public static void add(Integer carry, char d1, char d2, StackByLinkedList<Character> result) {

	// By default, carry is 0
	int num1 = Character.digit(d1, 10);
	int num2 = Character.digit(d2, 10);

	// incase of 4 => just return '4', carry = 0
	// incase of 14 => just return '4', carry = 1
	int sum = num1 + num2 + carry;
	if (sum >= 10) {
	    carry = sum / 10;
	    sum %= 10;
	}

	result.push(Character.forDigit(sum, 10));
    }

    public static void main(String[] args) {
	// Testing without carry
//	System.out.println("Result: " + add("123", "123"));

	// Testing with carry
	System.out.println("Result: " + add("123", "127"));
//	System.out.println("Result: " + add("000", "127"));
//	System.out.println("Result: " + add("993", "127"));
//	System.out.println("Result: " + add("999", "1000"));
    }
}
