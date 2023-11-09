/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortings.efficientsorts;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Mergesort
 * - Developed by John von Neuman
 *
 * @author duyvu
 * @param <E>
 */
public class MergeSort<E extends Comparable<E>> {

    /**
     * The function to divide into 2 subarrays
     *
     * @param arr
     * @param left
     * @param right
     */
    public void mergeSort(Object arr[],
                          int left,
                          int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // After divide and split into sub array, now backtracking 
            // and conquer those into the sorted array
            merge(arr, left, mid, right);
        }
    }

    /**
     * The function to conquer by merging 2 separated array into the new sorted array
     *
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    public void merge(Object arr[],
                      int start,
                      int mid,
                      int end) {

        // Create the temp array for sorting from start to end position
        Object[] temp = new Object[end - start + 1];

        /**
         * idxLeft idxRight
         * [_______________]____________]
         * left mid right
         * idxSortedArr
         * [______________________________]
         */
        // Preset
        int firstArrIdx, secondArrIdx, sortedIdx;
        firstArrIdx = start;
        secondArrIdx = mid + 1;
        sortedIdx = 0;

        // Looping through both array, and place to sorted array
        while (firstArrIdx <= mid && secondArrIdx <= end) {

            // If value on start less than value on end, put start to temp
            if (((Comparable) arr[firstArrIdx]).compareTo(((Comparable) arr[secondArrIdx])) < 0) {
                temp[sortedIdx++] = arr[firstArrIdx++];
            } // If value end greater or equal to start, put end to temp
            else {
                temp[sortedIdx++] = arr[secondArrIdx++];
            }
        }

        // Put remaining to the temp
        while (firstArrIdx <= mid) {
            temp[sortedIdx++] = arr[firstArrIdx++];
        }

        // Put remaining to the temp
        while (secondArrIdx <= end) {
            temp[sortedIdx++] = arr[secondArrIdx++];
        }

        // Copy the temp to the original array
        sortedIdx = 0;
        for (int i = start; i <= end; i++) {
            arr[i] = temp[sortedIdx++];
        }
    }

    /**
     * Main function for testing
     *
     * @param args
     */
    /**
     * Main function for testing
     *
     * @param args
     */
    public static void main(String[] args) {
        MergeSort<Integer> merge = new MergeSort<>();
        Integer[] arr = new Integer[]{4, 7, 0, 1, 3, 2, 10};

        merge.mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "");
        }
    }
}
