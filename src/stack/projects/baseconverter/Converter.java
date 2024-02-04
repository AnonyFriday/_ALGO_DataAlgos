/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.projects.baseconverter;

import java.util.Stack;

/**
 *
 * @author duyvu
 */
public abstract class Converter {

    public static String converter(int n,
	    int base) {

	String result = "";
	Stack<Integer> number = new Stack<>();

	/*
         * 12 % 2 = 6, 0
         * 6 % 2 = 3, 0
         * 3 % 2 = 1, 1
         * 1 % 2 = 1, 0 => stop when remainder = 0
	 */
	// Accept only base greater than 2 and n >= 0
	do {
	    int remainder = n % base;
	    number.push(remainder);
	    n /= base;
	} while (n > 0 && base >= 2);

	// Popping to the string
	// If the stack dont have any digits, return false;
	while (!number.isEmpty()) {

	    // 15 -> F in base 16
//            result += Integer.toString(number.pop(), base);
	    result += Character.forDigit(number.pop(), base);
	}
	return result;
    }

    // Testing
    public static void main(String[] args) {
	System.out.println("Base 2: " + Converter.converter(1000, 2));
	System.out.println("Base 4: " + Converter.converter(1000, 4));
	System.out.println("Base 5: " + Converter.converter(1000, 5));
	System.out.println("Base 8: " + Converter.converter(1000, 8));
	System.out.println("Base 16: " + Converter.converter(1000, 16));
    }
}
