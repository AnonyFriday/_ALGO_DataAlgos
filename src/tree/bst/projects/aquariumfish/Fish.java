/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.bst.projects.aquariumfish;

/**
 *
 * @author duyvu
 */
public class Fish implements Comparable<Fish> {

    // ======================================
    // = Fields
    // ======================================
    private String name;
    private int fins;

    // ======================================
    // = Constructor
    // ======================================
    public Fish(String name) {
        this.name = name;
    }

    public Fish(String name,
                int fins) {
        this.name = name;
        this.fins = fins;
    }

    // ======================================
    // = Override Functions
    // ======================================
    @Override
    public String toString() {
        return "(" + this.name + ", " + this.fins + ")";
    }

    @Override
    public int compareTo(Fish t) {
        return this.fins - t.fins;
    }

    @Override
    public boolean equals(Object obj) {
        return this.fins == ((Fish) obj).fins;
    }
}
