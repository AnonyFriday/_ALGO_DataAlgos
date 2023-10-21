/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortings.efficientsorts;

import utilities.HelperFunctions;

/**
 *
 * @author duyvu
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> {

    /**
     * Quick sort
     *
     * @param arr
     * @param low
     * @param high
     */
    public void quickSort(T[] arr, int low, int high) {
	if (low < high) {
	    int pivot = partition(arr, low, high);
	    quickSort(arr, low, pivot - 1);
	    quickSort(arr, pivot + 1, high);
	}
    }

    /**
     * Overloading the function quick sort
     *
     * @param arr
     */
    public void quickSort(T[] arr) {
	quickSort(arr, 0, arr.length - 1);
    }

    /**
     * A function to calculate the pivot after sorting the subarray
     * <br><br> Choosing the pivot as the first index
     *
     *
     * @param arr
     * @param array
     * @param left
     * @param right
     * @return
     */
    public int partition(T[] arr, int left, int right) {

	// Choosing the pivot as the first index
	// Assuming that the pivot index starting at left
	int pivotIdx = left;
	T pivotValue = arr[right];

	// Iterating from left to right,
	// If arr[left] < pivot, to establish the pivot in the middle of < and >
	// e.g. less ... | pivot | greater ...
	for (int i = left; i < right; i++) {
	    if (arr[i].compareTo(pivotValue) < 0) {
		HelperFunctions.swap(arr, i, pivotIdx);
		pivotIdx++;
	    }
	}

	// swapping pivotIdx to the right at the end
	HelperFunctions.swap(arr, pivotIdx, right);
	return pivotIdx;
    }

    /**
     * Display all elements within the array
     *
     * @param arr
     */
    public void displayArr(T[] arr) {
	for (T el : arr) {
	    System.out.print(el + " ");
	}
	System.out.println("");
    }

    // Testing
    public static void main(String[] args) {
	QuickSort<Integer> test = new QuickSort<>();

	Integer[] arr = new Integer[]{4, 8, 2, 1, 3, 5, 0, 10};
	test.quickSort(arr);

	test.displayArr(arr);
    }
}

/**
 * P = 9
 * 3 5 8 2 5 10 1
 * 3 > (1) -> 1 5 8 2 5 10 3
 * 5 > (1) -> 1
 *
 */
