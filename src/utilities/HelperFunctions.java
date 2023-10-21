/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import tree.node.HeapNode;

/**
 *
 * @author duyvu
 */
public interface HelperFunctions {

    // Print all element within the array
    public static <E extends Comparable<E>> void printArr(E[] arr) {
	for (E el : arr) {
	    System.out.println(el);
	}
    }

    // Swapping function
    public static <E> void swap(E[] arr, int iLeft, int iRight) {
	E temp = arr[iLeft];
	arr[iLeft] = arr[iRight];
	arr[iRight] = temp;
    }
}
