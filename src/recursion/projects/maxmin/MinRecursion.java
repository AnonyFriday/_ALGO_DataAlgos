/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.projects.maxmin;

/**
 *
 * @author duyvu
 */
public class MinRecursion {

    public static int minRecursion(int[] arr,
                                   int length) {
        if (length == 1) {
            return arr[0];
        }

        // Recursively reaching the end of length == 1
        // after returning value at index 0, comparing with index 1
        int minNum = minRecursion(arr, length - 1);
        return minNum < arr[length - 1] ? minNum : arr[length - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 3, 2, 1, 4, 100};
        System.out.println(minRecursion(arr, arr.length));
    }
}
