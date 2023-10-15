/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.bst.projects.aquariumfish;

/**
 *
 * @author duyvu
 */
public class AquariumFish implements Comparable<AquariumFish> {

    // ======================================
    // = Fields
    // ======================================
    String name;
    int rate;
    int price;

    // ======================================
    // = Constructor
    // ======================================
    /**
     * Constructor for comparison
     *
     * @param name
     */
    public AquariumFish(String name) {
        this.name = name;
    }

    /**
     * Constructor for initialization
     *
     * @param name
     * @param rate
     * @param price
     */
    public AquariumFish(String name,
                        int rate,
                        int price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    // ======================================
    // = Helper Methods
    // ======================================
    /**
     * Comparing by names
     *
     * @param t
     * @return
     */
    @Override
    public int compareTo(AquariumFish t) {
        return this.name.compareTo(t.name);
    }

    /**
     * String representation of the object
     *
     * @return
     */
    @Override
    public String toString() {
        return name + ", " + rate + ", " + price;
    }
}
