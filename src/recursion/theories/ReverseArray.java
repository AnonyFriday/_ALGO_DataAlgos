/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.theories;

/**
 *
 * @author duyvu
 */
public class ReverseArray {

    public static void reverseArray(int[] arr, int low, int high) {
	if (low > high) {
	    return;
	} else {
	    int temp = arr[low];
	    arr[low] = arr[high];
	    arr[high] = temp;
	    reverseArray(arr, low + 1, high - 1);
	}
    }

    public static void main(String[] args) {
	int[] list = new int[]{1, 2, 3, 5, 6, 7, 8, 9, 19};
	reverseArray(list, 0, list.length - 1);
    }
}
