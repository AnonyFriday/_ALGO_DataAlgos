/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package search.randomwalksearch;

/**
 * Tim (x,y) de tmp(x,y) = 4 - (x^2 + y^2) max in range[-2,2]
 * <br><br>Solve by using iteration -> systematic approach
 * <br><br>Viec chia mang tap so thuc goi la vi phan hoa (so hoa) tap so
 *
 * @author duyvu
 */
public class WalkSearchIteration {

    public static double f(double x, double y) {
	return 4 - (x * x + y * y);
    }

    public static void main(String[] args) {
	double min = -2.0, max = 2.0;
	int n = 100000;
	double delta = (max - min) / n;
	double result = f(min, min);     // f0
	double tmp;

	double xTemp = min, yTemp = min; // store the right value

	// new result
	for (double x = min; x <= max; x = x + delta) {
	    for (double y = min; y <= max; y = y + delta) {
		tmp = f(x, y);
		if (result < tmp) {
		    result = tmp;
		    xTemp = x;
		    yTemp = y;
		}
	    }
	}

	System.out.println("Result: (" + xTemp + "," + yTemp + "): " + result);

    }
}
