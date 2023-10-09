/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.projects.maxmin;

/**
 *
 * @author duyvu
 */
public class MaxRecursion {

    public static int maxRecursion(int[] arr,
                                   int length) {

        // Base case
        if (length == 1) {
            return arr[0];
        }

        int maxNumber = maxRecursion(arr, length - 1);
        return maxNumber > arr[length - 1] ? maxNumber : arr[length - 1];
    }

    // Testing
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 3, 2, 1, 4, 100};
        System.out.println(maxRecursion(arr, arr.length));
    }
}
