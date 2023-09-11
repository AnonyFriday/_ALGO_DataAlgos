/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.circular;

/**
 *
 * @author duyvu
 */
public class Main {

    public static void main(String[] args) {
        CircularTesting<String> list = new CircularTesting<>();

        // Test Adding into the Circular Single Linked List
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");

        System.out.println("First: " + list.first());
        System.out.println("Last: " + list.last());
        list.printList();

        // Rotate the circular Linked List
        list.rotate();
        System.out.println("First: " + list.first());
        System.out.println("Last: " + list.last());
        list.printList();
    }
}
