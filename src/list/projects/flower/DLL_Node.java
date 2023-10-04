/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.projects.flower;

/**
 *
 * @author duyvu
 */
public class DLL_Node {

    // ====================================
    // = Fields
    // ====================================
    private Flower flower;
    protected DLL_Node next;
    protected DLL_Node prev;

    // ====================================
    // = Constructor
    // ====================================
    /**
     * Constructor for adding new node to the list
     *
     * @param flower
     */
    public DLL_Node(Flower flower) {
        this.flower = flower;
        next = prev = null;
    }

    // ====================================
    // = Getters & Setters
    // ====================================
    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }
}
