/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortings.elementarysorts;

import utilities.HelperFunctions;
import static sortings.elementarysorts.InsertionSort.insertionSort;

/**
 *
 * @author duyvu
 */
public class BubbleSort {

    /**
     * Sorting algorithm using bubble sort
     * <br><br>- In-place Algorithm
     * <br><br>- Time Complexity: O(n^2)
     * <br><br>- Space Complexity: O(1)
     *
     * @param <E> Type of elements passed to the array
     * @param arr passed array to the function
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] arr) {

        // If the array is empty or having only 1 value
        if (arr.length <= 1) {
            return;
        }

        boolean isSwapped = false;
        for (int i = 0; i < arr.length; i++) {

            // Check if those data are sorted or not
            isSwapped = false;

            // Bubble sort to the rightmost of the array
            // - i - 1 so that those sorted doesnot have to be in sorting process again 
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) < 0) {
                    HelperFunctions.swap(arr, j, j + 1);
                    isSwapped = true;
                }
            }

            // If the array is sorted
            if (isSwapped == false) {
                break;
            }
        }
    }

    // Testing Function
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{4, 3, 7, 5, 1, 6, 8, 9, 2};
        bubbleSort(arr);
        HelperFunctions.printArr(arr);
    }
}
