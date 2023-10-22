/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph.theories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 *
 * @author duyvu
 */
public class Graph_Matrix {

    // ======================================
    // = Fields
    // ======================================
    private int nVertices;       // No. of vertices
    private int[][] adjMatrix;   // The Adj Matrix plotted from file 
    private char[] vSet;         // vertices name. e.g. ABCDEFG... bydefault

    // ======================================
    // = Constructor
    // ======================================
    /** '
     * Vertices's name assigned with alphabets from A -> Z by default
     */
    public Graph_Matrix() {
        // e.g. "ABCDEFGHIJKLMNOP...Z"
        for (char i = 'A'; i <= 'Z'; i++) {
            vSet[i - 'A'] = i;
        }
    }

    /**
     * Custom Vertices's name assigned by the user
     *
     * @param vertexName
     */
    public Graph_Matrix(String vertexName) {
        vSet = vertexName.toCharArray();
    }

    // ======================================
    // = Helper Functions
    // ======================================
    /**
     * Create visitied array for BFS and DFS
     *
     * @return a visited array
     */
    public boolean[] createVisittedArray() {
        boolean[] visitted = new boolean[nVertices];
        Arrays.fill(visitted, false);
        return visitted;
    }

    /**
     * Print vertex to the screen 
     * @param i 
     */
    public void printVertex(int i) {
        System.out.println(this.vSet[i] + " ");
    }

    // ======================================
    // = Getters & Setters
    // ======================================
    public void displayAdjMatrix() {
        // Assign each value to the physical matrix
        for (int i = 0; i < nVertices; i++) {
            System.out.format("%03d", this.vSet[i]);
        }
        System.out.println("");

        // Assign physical matrix
        for (int i = 0; i < nVertices; i++) {

            // Print label of each columns
            System.out.format("%03d", this.vSet[i]);

            // Print row's value of each column
            for (int j = 0; j < nVertices; j++) {
                System.out.format("%03d", this.adjMatrix[i][j]);
            }

            // Move to the next line
            System.out.println("");
        }
    }

    /**
     * Set the Adjacency Matrix
     *
     * @param m
     */
    public void setAdjMatrix(int[][] m) {
        this.nVertices = m.length;                      // No. Vertices
        this.adjMatrix = new int[nVertices][nVertices]; // assign no. cols and no. rows

        // Assign each value to the physical adjMatrix
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                this.adjMatrix[i][j] = m[i][j];
            }
        }
    }
}
