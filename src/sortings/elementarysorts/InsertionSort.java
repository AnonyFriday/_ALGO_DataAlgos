/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortings.elementarysorts;

import utilities.HelperFunctions;
import static sortings.elementarysorts.SelectionSort.selectionSort;

/**
 *
 * @author duyvu
 */
public class InsertionSort {

    /**
     * Insert sorting don't use the swapping algorithm
     * 
     * Time: 
     *
     * @param <E>
     * @param arr
     */
    public static <E extends Comparable<E>> void insertionSort(E[] arr) {

        // If the arr is empty then return nothing
        if (arr.length <= 1) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            E key = arr[i];

            // Determine the right position of key by decrement
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Put key to the right position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 3, 7, 5, 1, 6, 8, 9, 2};
        insertionSort(arr);
        HelperFunctions.printArr(arr);
    }
}
