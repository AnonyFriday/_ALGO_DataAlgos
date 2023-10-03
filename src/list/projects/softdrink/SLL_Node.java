/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.projects.softdrink;

/**
 *
 * @author duyvu
 */
public class SLL_Node {

    // ====================================
    // = Fields
    // ====================================
    private SoftDrink data; // a soft drink
    protected SLL_Node next;      // reference to the next node in a singly linked list

    // ====================================
    // = Constructor
    // ====================================
    public SLL_Node(SoftDrink data) {
        this.data = data;
        this.next = null;
    }

    // ====================================
    // = Methods
    // ====================================
    // ====================================
    // = Getters & Setters
    // ====================================
    public SoftDrink getData() {
        return data;
    }

    public void setData(SoftDrink data) {
        this.data = data;
    }

}
