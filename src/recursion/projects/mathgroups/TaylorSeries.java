/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.projects.mathgroups;

/**
 * Calculate the Taylor Series
 *
 *
 * e^x = Series of (Power of (x) / Factorial of x) with x terms
 *
 *
 * Create 3 recursion sum, factorial, pow for the above taylor series
 *
 * @author duyvu
 */
public class TaylorSeries {

    public static double power(double x, int y) {
	if (y == 0) {
	    return 1;
	} else {
	    double firstHalf = power(x, y / 2);
	    double result = firstHalf * firstHalf;

	    if (y % 2 == 1) {
		result *= x;
	    }
	    return result;
	}
    }

    public static double fac(int x) {
	if (x == 0) {
	    return 1;
	}
	return fac(x - 1) * x;
    }

    // DISCLAIMER
    // This technique requires a function to caluclate fac and power
    // Inefficient
    public static double taylorSeries(int x, int nTerms) {
	if (x == 0) {
	    return 1;
	} else {
	    double result = 0;
	    for (int i = 0; i <= nTerms; i++) {
		result += (power(x, i) / fac(i));
	    }
	    return result;
	}
    }

    // Efficient solution
    // Notice that everytime returning the taylor series, it's a form of power(x,n) / fac(n)
    // WHy don't we just create 2 static p and f variable to keep track the result 
    public static double taylorSeries2Wrapper(int x, int nTerms) {
	int power = 1, fac = 1;
	return taylorSeries2(x, nTerms, power, fac);
    }

    private static double taylorSeries2(int x, int nTerms, int power, int fac) {
	if (nTerms == 0) {
	    return 1;
	} else {
	    // If nterms = 0 then return 1
	    // if nterms = 1 then recursive and calulate
	    double r = taylorSeries2(x, nTerms - 1, power, fac);
	    power = power * x;
	    fac = fac * nTerms;
	    return r + power / fac;
	}
    }

    public static void main(String[] args) {

//	System.out.println(fac(2));
//	System.out.println(power(2, 3));
	System.out.println(taylorSeries(4, 100));
	System.out.println(taylorSeries(4, 100));
    }
}
