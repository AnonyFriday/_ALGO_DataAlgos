/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.theories.search;

/**
 * Binary Search tree using Recursive algorithm
 *
 * <br><br> Calculate the median mid = (low + high)/ 2
 * <br><br> Calculate the binary search tree using recursion solution
 *
 *
 *
 * @author duyvu
 */
public class BinarySearch {

    public static boolean binarySerach(int[] data, int target) {
	return binarySearch(data, target, 0, data.length - 1);
    }

    public static boolean binarySearch(int[] data, int target, int low, int high) {

	// If low > high, which means the search is out of bound
	if (low > high) {
	    return false;
	} else {
	    int mid = (low + high) / 2;

	    // If found, return true
	    if (target == data[mid]) {
		return true;
	    }

	    // Recursively calling binarySearch to find true or false
	    if (target < data[mid]) {
		return binarySearch(data, target, low, mid - 1);
	    } else {
		return binarySearch(data, target, mid + 1, high);
	    }
	}
    }

    public static void main(String[] args) {
	int[] list = new int[]{1, 2, 5, 6, 8, 9, 10, 100, 101};
	System.out.println(binarySerach(list, 102));
    }
}
