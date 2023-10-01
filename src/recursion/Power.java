/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion;

/**
 *
 * @author duyvu
 */
public class Power {

    /**
     *
     * Big O(n)
     *
     * Space O(n)
     *
     * e.g. x^y
     */
    public static double powerLinear(double x, int y) {
	if (y == 0) {
	    return 1;
	} else {
	    return powerLinear(x, y - 1) * x;
	}
    }

    /**
     * If y is even x^(n/2) * x^(n/2) = x^n if y is odd
     *
     * If y is odd x^(n-1/2) * x^(n-1/2) * x = x^n
     *
     * if y == 0 then x = 1
     *
     *
     *
     * Big O (logn) single cutting the y in half at each activation record
     *
     *
     *
     * @param x
     * @param y
     * @return
     */
    public static double powerDouble(double x, int y) {
	if (y == 0) {
	    return 1;
	}

	// a first half of recursion 
	double firstHalf = powerDouble(x, y / 2);
	double result = firstHalf * firstHalf;

	// If x is odd than add the extra x into it
	if (y % 2 == 1) {
	    result *= x;
	}
	return result;
    }

    /**
     * Same performance as the above solution but difference approach
     *
     * @param x
     * @param y
     * @return
     */
    public static double powerDouble2(double x, int y) {
	if (y == 0) {
	    return 1;
	}

	// If y is even
	if (y % 2 == 0) {
	    return powerDouble2(x * x, y / 2);
	} else {
	    return x * powerDouble2(x * x, y / 2);
	}

    }

    public static void main(String[] args) {
	System.out.println("Power: " + powerLinear(12.5, 4));
	System.out.println("Power: " + powerDouble(12.5, 4));
	System.out.println("Power: " + powerDouble2(12.5, 4));

    }
}
