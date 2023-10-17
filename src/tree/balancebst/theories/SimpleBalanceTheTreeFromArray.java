/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.balancebst.theories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author duyvu
 */
public abstract class SimpleBalanceTheTreeFromArray {

    /**
     * Generate the a tree-array stored by using the algorimth o binary search
     *
     * <br><br> After conducting this function, inserting each node of this array
     * <br><br> by calling addNode() in the bstree class
     *
     * @param <T>
     * @param result
     * @param data
     * @param first
     * @param last
     * @return
     */
    private static <T> void balance(List<T> result, T data[], int first, int last) {

	if (first <= last) {
	    int middle = (last + first) / 2;
	    result.add(data[middle]);
	    balance(result, data, first, middle - 1);
	    balance(result, data, middle + 1, last);
	}
    }

    public static <T> List<T> balance(T data[]) {
	ArrayList<T> list = new ArrayList<>();
	balance(list, data, 0, data.length - 1);
	return list;
    }

    public static void main(String[] args) {

	// Generate the complete binary tree stored at the array
	Integer[] list = new Integer[]{5, 1, 9, 8, 7, 0, 2, 3, 4, 6};
	Arrays.sort(list, 0, list.length - 1);

	System.out.println(balance(list));
    }
}
