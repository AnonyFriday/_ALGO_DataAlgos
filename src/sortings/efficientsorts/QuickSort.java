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
     * <br><br>
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
     * Quicksort using random Pivot technique to reduce the case of sorted array
     * @param arr
     * @param left
     * @param right 
     */
    public void quickSortRandomPivot(T[] arr, int left, int right) {
	if (left < right) {
	    generateRandomPivotIndex(arr, left,	right);
	    int pivotIdx = partition(arr, left, right);
	    quickSortRandomPivot(arr, left, pivotIdx - 1);
	    quickSortRandomPivot(arr, pivotIdx + 1, right);
	}
    }
    
    /**
     * Overloadding the function of quickSortRandomPivot
     * @param arr 
     */
    public void quickSortRandomPivot(T[] arr) {
	quickSortRandomPivot(arr, 0, arr.length - 1);
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
	// Choosing the pivot on the right 
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

    public void generateRandomPivotIndex(T[] arr, int left, int right) {
	int randomIdx = (int) (Math.random() * ((right - left + 1)) + left);
	HelperFunctions.swap(arr, randomIdx, right);
    }

    // Testing
    public static void main(String[] args) {
	QuickSort<Integer> test = new QuickSort<>();

	Integer[] arr = new Integer[]{4, 8, 2, 1, 3, 5, 0, 10};
//	test.quickSort(arr);
	
	test.quickSortRandomPivot(arr);
	test.displayArr(arr);
    }
}
