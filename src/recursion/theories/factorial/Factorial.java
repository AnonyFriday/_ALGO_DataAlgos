/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.theories.factorial;

/**
 *
 * @author duyvu
 */
public class Factorial {

    public static int factorial(int x) {
	if (x <= 0) {
	    return 1;
	}

	return factorial(x - 1) * x;
    }

    public static void main(String[] args) {
	System.out.println(factorial(-1));
    }
}
