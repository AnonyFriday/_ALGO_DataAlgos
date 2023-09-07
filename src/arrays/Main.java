/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrays;

/**
 *
 * @author duyvu
 */
public class Main implements LeetCodeProblemInterface{

    public static void main(String[] args) {
	StaticArrayLab<Integer> array = new StaticArrayLab<>(20, 2, 3, 4, 5);

	// Add the element to the array
	array.add(10, 4);
	array.add(10, 3);
	array.add(10, array.length);
	array.add(10, array.length);
	array.add(10, array.length);
	array.add(10, array.length);
	array.add(10, 0);

	array.show();

//	 Remove the element from the array
	array.removeAt(4);
	array.show();
	
	// Remove all occurence of 10 from the array
	System.out.println("\nRemoved: " + array.removeOccurence(10));
	array.show();
    }

    @Override
    public int prop_27_removeOccurences(int[] arr, int val) {
	throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
