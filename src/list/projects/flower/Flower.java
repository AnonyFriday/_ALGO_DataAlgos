/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.projects.flower;

/**
 *
 * @author duyvu
 */
public class Flower {

    // ====================================
    // = Fields
    // ====================================
    String name;
    String original;
    int price;

    // ====================================
    // = Constructor
    // ====================================
    
    /**
     * Create constructor flower
     * @param name 
     */
    public Flower(String name) {
        this.name = name;
    }

    public Flower(String name,
                  String original,
                  int price) {
        this.name = name;
        this.original = original;
        this.price = price;
    }

}
