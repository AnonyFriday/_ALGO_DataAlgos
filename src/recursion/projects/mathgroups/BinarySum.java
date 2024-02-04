/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.projects.mathgroups;

/**
 *
 * @author duyvu
 */
public class BinarySum {

    /**
     * Split the array in half and aggregate it together
     *
     * @param data
     * @param low
     * @param high
     * @return
     */
    public static int binarySum(int[] data, int low, int high) {

	// if low is greater than high, then return as 0
	if (low > high) {
	    return 0;

	    // 1 element than return immediately 
	} else if (low == high) {
	    return data[low];
	} else {
	    int mid = (low + high) / 2;
	    return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
	}
    }

    public static void main(String[] args) {
	int[] arr = new int[]{1, 2, 3, 4};
	System.out.println(binarySum(arr, 0, arr.length - 1));
    }
}
