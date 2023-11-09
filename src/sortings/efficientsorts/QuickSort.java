/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortings.efficientsorts;

import utilities.HelperFunctions;

/**
 * Quicksort
 * - A devide and conquer algorithm
 * - 4 configuration of the pivot value:
 * left, (done)
 * right, (done)
 * random, (not yet)
 * middle (done)
 *
 * - 2 implementations
 * lomuto (right) - slower
 * hoare (left) (could be right, random) - faster
 *
 * @author duyvu
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> {

    // ==========================================
    // == Quicksort using Lomore 
    // ==========================================
    /**
     * Quick sort
     *
     * <br><br>Implement quicksort using end value
     *
     * @param arr
     * @param start
     * @param end
     */
    public void quickSortLomore(T[] arr,
                                int start,
                                int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            QuickSort.this.quickSortLomore(arr, start, pivot - 1);
            QuickSort.this.quickSortLomore(arr, pivot + 1, end);
        }
    }

    /**
     * Overloading the function quick sort
     *
     * @param arr
     */
    public void quickSortLomore(T[] arr) {
        QuickSort.this.quickSortLomore(arr, 0, arr.length - 1);
    }

    /**
     * A function to calculate the pivot after sorting the subarray
     * <br><br> Choosing the pivot as the first index
     *
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int partition(T[] arr,
                         int left,
                         int right) {

        // Choosing the pivot as the first index
        // Assuming that the pivot index starting at left
        // Choosing the pivot on the right 
        int pivotIdx = left;
        T pivotValue = arr[right];

        // Iterating from left to right,
        // If arr[(left + right) / 2] < pivot, to establish the pivot in the middle of < and >
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

    // ==========================================
    // == Quicksort using Hoare 
    // ==========================================
    public void quickSortHoare(T[] arr,
                               int start,
                               int end) {

        // Choose the pivot at left, right, random, middle by your choice
        int pIndex = start;
        T pivotValue = arr[pIndex];

        // Just after the pivot
        int lower = start + 1;
        int upper = end;

        // 
        while (lower <= upper) {
            // increasement i until a[i] >= p then pause
            while (lower <= upper && arr[lower].compareTo(pivotValue) < 0) {
                lower++;
            }

            // decrement j until a[j] <= p then pause
            while (lower <= upper && arr[upper].compareTo(pivotValue) >= 0) {
                upper--;
            }

            // swapping i and j to correct a[i] < pIndex < a[j]
            if (lower < upper) {
                HelperFunctions.swap(arr, lower++, upper--);

                // if i >= j, it means from pivotValue to i: less than pivot
                // from i to high: greater than pivot
            } else {
                lower++;
            }
        }

        // upper is the suitable position for the pivot (a[first])
        // so we swap j with pivot 
        HelperFunctions.swap(arr,
                             pIndex,
                             upper);

        // upper has been fixed with the value, no more swaping for it 
        if (start < upper - 1) {
            quickSortHoare(arr, start, upper - 1); // sort left subarray
        }
        if (upper + 1 < end) {
            quickSortHoare(arr, upper + 1, end);
        }
    }

    public void quickSortHoare(T[] arr) {
        quickSortHoare(arr, 0, arr.length - 1);
    }
// ==========================================
// == Helper Function
// ==========================================

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

    // Testing Purpose
    public static void main(String[] args) {
        QuickSort<Integer> test = new QuickSort<>();

        Integer[] arr = new Integer[]{7, 4, 8, 7, 2, 3, 7, 7, 7, 7, 1, 3, 5, 7, 7, 7, 7, 0, 10};
//        test.quickSortRandomPivot(arr);

        // Quicksort using left, right index
//        test.quickSortLomore(arr);
        test.quickSortHoare(arr);
        test.displayArr(arr);
    }
}
