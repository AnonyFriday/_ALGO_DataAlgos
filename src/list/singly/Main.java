/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.singly;

/**
 *
 * @author duyvu
 */
public class Main {

    public static void main(String[] args) {

        // Initialize the Singly Linked List
        SinglyTesting list = new SinglyTesting();

        list.addFirst(new Node(10));
        list.addFirst(new Node(10));
        list.addFirst(new Node(10));
        list.addFirst(new Node(99));
        list.addLast(new Node(20));
        list.addLast(new Node(20));
        list.addLast(new Node(20));
        list.addLast(new Node(99));

        // Testing Traverse
        list.traverse();

        // Searching value 
        System.out.println("First position: " + list.searchIterativeApproach(20));

        // Clear the linked list
//        list.clear();
    }
}
