/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.theories.binarytree;

/**
 *
 * @author duyvu
 */
public class Fish {

    // ======================================
    // = Fields
    // ======================================
    private String name;
    private String fins;

    // ======================================
    // = Constructor
    // ======================================
    public Fish(String name) {
	this.name = name;
    }

    public Fish(String name,
	    String fins) {
	this.name = name;
	this.fins = fins;
    }

    @Override
    public String toString() {
	return "(" + this.name + ", " + this.fins + ")";
    }
}
