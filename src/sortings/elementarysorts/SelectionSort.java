/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortings.elementarysorts;

import java.util.Arrays;
import java.util.Objects;
import utilities.HelperFunctions;

/**
 * Selection Sort
 * - Big O: N^2
 * - Space: N
 * - Auxiliary: 1
 * @author duyvu
 */
public class SelectionSort {

    public static <E extends Comparable<E>> void selectionSort(E[] arr) {

	// If the array is null then return nothing
	if (arr.length == 0) {
	    return;
	}

	// Looping to find the max comparing to the currentMax
	for (int i = 0; i < arr.length - 1; i++) {
	    int iMax = i;
	    for (int j = i + 1; j < arr.length; j++) {
		if (arr[iMax].compareTo(arr[j]) > 0) {
		    iMax = j;
		}
	    }

	    // If iMax is difference than the original pivot, then swap
	    if (iMax != i) {
		HelperFunctions.swap(arr, iMax, i);
	    }
	}
    }

    // Getting the minimum index of the string
    public static <E extends Comparable<E>> int getMinIndex(E arr[], int first, int last) {
	int minIdx = first;
	for (int i = first + 1; i <= last; i++) {
	    if (arr[minIdx].compareTo(arr[i]) > 0) {
		minIdx = i;
	    }
	}
	return minIdx;
    }

    // Testing Selection Sort
    public static void main(String[] args) {
	Integer[] arr = new Integer[]{4, 3, 7, 5, 1, 6, 8, 9, 2};
	selectionSort(arr);
	HelperFunctions.printArr(arr);
    }
}
