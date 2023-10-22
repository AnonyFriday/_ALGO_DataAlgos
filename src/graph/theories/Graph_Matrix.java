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
     *
     * @param i
     */
    public void printVertex(int i) {
        System.out.print(this.vSet[i] + " ");
    }

    // ======================================
    // = BFS
    // ======================================
    /**
     * Traversing the connected graph only
     *
     * @param vIdx
     */
    void BF_TraversalConnected(int startVIdx,
                               boolean[] visitted) {
        try {
            // Queue and visitted for the BFS algorithms
            CustomQueue<Integer> queue = new CustomQueue<>();

            // Add the first vIdx to the list (dealing with the vertice's index, not the char)
            queue.enqueue(startVIdx);
            visitted[startVIdx] = true;

            while (!queue.isEmpty()) {
                int v = queue.dequeue(); // dequeue
                this.printVertex(v);   // print the vertext to the screen

                // Looping from A -> I, exporing all possible children of current vertice
                for (int i = 0; i < this.nVertices; i++) {
                    int edge = this.adjMatrix[v][i];
                    if (edge != 0 && visitted[i] == false) { // enqueue only no visitted
                        queue.enqueue(i);
                        visitted[i] = true; // Mark if the vertice is visitted
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Something went wrong. Please try again.");
        }
    }

    /**
     * Breadth First Search Traversing all vertices of the graph
     * (including disconnected graph
     */
    void BF_TraversalConnected(int startVIdx) {
        // Queue and visitted for the BFS algorithms
        boolean[] visitted = this.createVisittedArray();
        BF_TraversalConnected(startVIdx, visitted);
    }

    /**
     * Breadth First Search for traversing the disconnected graph
     *
     * @param startVIdx
     */
    void BF_TraversalAllDisconnectedGraph(int startVIdx) {
        // Queue and visitted for the BFS algorithms
        boolean[] visitted = this.createVisittedArray();

        for (int vCol = startVIdx; vCol < this.nVertices; vCol++) {
            // If the vertice is not visitted, then add to the queue for exploring
            if (visitted[vCol] == false) {
                BF_TraversalConnected(vCol, visitted);
            }
        }
    }

    // ======================================
    // = DFS
    // ======================================
    /**
     * Depth First Search traversing the connected graph only
     *
     * @param vIdx
     * @param visitted
     */
    void DFS_TraversalConnected(int currVIdex,
                                boolean[] visitted) {

        // Printing vertex
        visitted[currVIdex] = true;
        this.printVertex(currVIdex);

        // Go to the row of current Vertex, get the first posible path
        for (int i = 0; i < nVertices; i++) {
            if (visitted[i] == false && this.adjMatrix[currVIdex][i] > 0) {

                // visit the next vertex when connecting with vIdx
                DFS_TraversalConnected(i, visitted);
            }
        }
    }

    /**
     * Function Overloadding for DFS
     *
     * @param startVIdx
     */
    void DFS_TraversalConnected(int startVIdx) {
        boolean[] visitted = this.createVisittedArray();
        DFS_TraversalConnected(startVIdx, visitted);
    }

    /**
     * Traversing all disconnected graph
     *
     * @param startVIdx
     */
    void DFS_TraversalAllDisconnectedGraph(int startVIdx) {

        boolean[] visitted = this.createVisittedArray();

        // Loop app vertices from start to the end of the set
        for (int i = startVIdx; i < nVertices; i++) {
            if (visitted[i] == false) {
                DFS_TraversalConnected(i, visitted);
            }
        }
    }
    // ======================================
    // = File Groups
    // ======================================
    
    
    // ======================================
    // = Getters & Setters
    // ======================================

    public void displayAdjMatrix() {
        // Assign each value to the physical matrix
        System.out.format("     ");
        for (int i = 0; i < nVertices; i++) {
            System.out.format("[%c] ", this.vSet[i]);
        }
        System.out.format("\n---------------------------------------");
        System.out.println("");

        // Assign physical matrix
        for (int i = 0; i < nVertices; i++) {

            // Print label of each columns
            System.out.format("[%c]", this.vSet[i]);

            // Print row's value of each column
            for (int j = 0; j < nVertices; j++) {
                System.out.format("%4d", this.adjMatrix[i][j]);
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

    public static void main(String[] args) {

        // Testing physical matrix 
        int[][] arr = new int[][]{{0, 0, 0, 0, 1, 1, 1, 0, 1},
                                  {0, 0, 0, 0, 0, 0, 1, 0, 0},
                                  {0, 0, 0, 0, 0, 0, 0, 1, 0},
                                  {0, 0, 0, 0, 0, 0, 0, 1, 0},
                                  {1, 0, 0, 0, 0, 1, 0, 0, 1},
                                  {1, 0, 0, 0, 1, 0, 0, 0, 1},
                                  {1, 1, 0, 0, 0, 0, 0, 0, 0},
                                  {0, 0, 1, 1, 0, 0, 0, 0, 0},
                                  {1, 0, 0, 0, 1, 1, 0, 0, 0}};

        Graph_Matrix matrix = new Graph_Matrix("ABCDEFGHI");
        matrix.setAdjMatrix(arr);
        matrix.displayAdjMatrix();

        // Testing BF Traversal
//        matrix.BF_TraversalConnected(1);
//        matrix.BF_TraversalAllDisconnectedGraph(2);
        matrix.DFS_TraversalConnected(1);
//        matrix.DFS_TraversalAllDisconnectedGraph(4);
    }
}
