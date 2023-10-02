/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.theories.sum;

/**
 *
 * @author duyvu
 */
public class LinearSum {

    /**
     * Linear Sum
     *
     * <br><br> Big O(n)
     * <br><br> Auxiliary Space O(n)
     *
     * @param data: an array of data
     * @param n: number of elements
     * @return return an aggregation of sum based on the array
     *
     */
    public static int linearSum(int[] data, int n) {
	if (n <= 0) {
	    return 0;
	} else {
	    return linearSum(data, n - 1) + data[n - 1];
	}
    }

    public static void main(String[] args) {
	int[] data = new int[]{1, 2, 3};

	System.out.println("Sum: " + linearSum(data, 3));
    }
}
