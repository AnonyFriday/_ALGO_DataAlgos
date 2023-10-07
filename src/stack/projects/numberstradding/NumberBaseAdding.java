/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.projects.numberstradding;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;
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

	// For leading and trailing purpose 
	// 00 -> 0
	num1 = trimZeros(num1);
	num2 = trimZeros(num2);

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
	AtomicInteger carry = new AtomicInteger(0);
	while (!sOperand_1.isEmpty() || !sOperand_2.isEmpty()) {
	    d1 = sOperand_1.isEmpty() ? '0' : sOperand_1.pop();
	    d2 = sOperand_2.isEmpty() ? '0' : sOperand_2.pop();
	    add(carry, d1, d2, result);
	}

	String resultStr = "";
	while (!result.isEmpty()) {
	    resultStr += result.pop();
	}

	// 9 + 1 = '0', carry 1 => 10
	// 127 + 123 = '3'50 carry 0 => 350
	// 999 + 999 = '0'998 carry 1 => 10998
	// 57 + 74  = '3'1 carry 1 => 131
	// If the last result still have carry then add 1 to the result string
	if (carry.get() == 1) {
	    resultStr = "1" + resultStr;
	}

	return resultStr;
    }

    /**
     * Adding 2 character typed digit of the number
     *
     * @param carry: the current carry using atomic integer
     * @param d1: first digit
     * @param d2: second digit
     * @param result: pushing the new digit to the result stack
     */
    private static void add(AtomicInteger carry, char d1, char d2, StackByLinkedList<Character> result) {

	int num1 = Character.digit(d1, 10);
	int num2 = Character.digit(d2, 10);

	// incase of 4 => just return '4', carry = 0
	// incase of 14 => just return '4', carry = 1
	int sum = num1 + num2 + carry.get();
	if (sum >= 10) {

	    // set carry = 1 if sum >= 10, and reduce sum from 10s to 1s
	    carry.set(1);
	    sum %= 10;
	} else {

	    // set carry = 0 if sum < 10
	    carry.set(0);
	}

	result.push(Character.forDigit(sum, 10));
    }

    /**
     * Trimming zeros and space before executing the addition
     *
     * @param number: pre-formatted number
     * @return post formatted number
     */
    public static String trimZeros(String number) {
	final String fullZeros = "^[0]+$";
	final String leadingZeros = "^[0]+";

	// 000000 -> 
	if (number.matches(fullZeros)) {
	    return number.trim().replaceAll(fullZeros, "0");
	} else {
	    return number.trim().replaceAll(leadingZeros, "");
	}
    }

    public static void main(String[] args) {
	// Testing without carry
	System.out.println("Result: " + add("123", "123"));
	System.out.println("Result: " + add("000", "123"));
	System.out.println("Result: " + add("0", "123"));
	System.out.println("Result: " + add("01", "03"));
	System.out.println("Result: " + add("09", "0000000999"));
	System.out.println("Result: " + add("0000", "000000000"));

	// Testing with carry
	System.out.println("Result: " + add("1", "00000009"));
	System.out.println("Result: " + add("123", "127"));
	System.out.println("Result: " + add("57", "74"));
	System.out.println("Result: " + add("999", "9999"));
	System.out.println("Result: " + add("999", "1000"));
	System.out.println("Result: " + add("7", "4078"));
    }
}
