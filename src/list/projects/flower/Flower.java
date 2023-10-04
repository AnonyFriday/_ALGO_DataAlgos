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
    private String name;
    private String original;
    private int price;

    // ====================================
    // = Constructor
    // ====================================
    /**
     * Constructor for finding flower by name
     *
     * @param name
     */
    public Flower(String name) {
        this.name = name;
    }

    /**
     * Constructor for loading data
     *
     * @param name
     */
    public Flower(String name,
                  String original,
                  int price) {
        this.name = name;
        this.original = original;
        this.price = price;
    }

    // ====================================
    // = Methods
    // ====================================
    /**
     * For finding Flower by name
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return this.name.equalsIgnoreCase(((Flower) obj).getName());
    }

    /**
     * String representation of the Flower object
     *
     * @return string
     */
    @Override
    public String toString() {
        return name + ", " + original + ", " + price;
    }

    // ====================================
    // = Setters & Getters
    // ====================================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
