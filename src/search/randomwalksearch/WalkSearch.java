/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package search.randomwalksearch;

import java.util.Random;

/**
 * Bài tập - finding a point having minimum sum of lengths to 3 vertices of a triangle
 */
/**
 * Tim (x,y) de tmp(x,y) = 4 - (x^2 + y^2) max in range[-2,2]
 * <br><br>Solve by using iteration -> systematic approach
 * <br><br>Viec chia mang tap so thuc goi la vi phan hoa (so hoa) tap so
 *
 * @author duyvu
 */
public class WalkSearch {

    private static Random rd = new Random(System.currentTimeMillis());

    public static double f(double x, double y) {
	return 4.0 - (x * x + y * y);
    }

    // Tìm trị mới từ trị hiện hành và có xem xét tìm xa
    // 90% tim gan, 10% tim xa
    // Tìm gần 10% quanh trị hiện tại
    // Tìm xa
    public static double randomWalk(double curVal) {
	boolean near = rd.nextDouble() <= 0.9;
	if (near) {
	    double dd = 0.1 * 4;
	    double newVal = (curVal - dd / 2) + dd * rd.nextDouble();
	    return newVal >= -2.0 ? newVal : -2.0;
	} else {
	    // tim xa
	    return -2.0 + 4.0 * rd.nextDouble();
	}
    }

    public static void main(String[] args) {
	double min = -2.0, max = 2.0;

	double x = min, y = min;
	double xTemp = x, yTemp = y; // store the right value

	double result = f(min, min);     // f0
	double tmp;			    // ket qua moi 
	int n = 100000;

	// Calculate time complexity
	long t = System.nanoTime();

	int curLoop = 0;
	while (curLoop < n) {
	    // Tim xt, yt moi va tmp moi
	    double probability = rd.nextDouble();
	    if (probability < 0.33) {            // giữ x thay y
		xTemp = x;
		yTemp = randomWalk(y);
	    } else if (probability < 0.66) {     // giữ y thay x
		xTemp = randomWalk(x);
		yTemp = y;
	    } else {                             // thay cả x, y
		xTemp = randomWalk(x);
		yTemp = randomWalk(y);
	    }

	    tmp = f(xTemp, yTemp);

	    if (result < tmp) {
		result = tmp;
		x = xTemp;
		y = yTemp;
	    }

	    curLoop++;
	}

	long dt = System.nanoTime() - t;
	System.out.println("Result: (" + xTemp + "," + yTemp + "): " + result);
	System.out.println("Time taken: " + dt + " ns");

    }
}
