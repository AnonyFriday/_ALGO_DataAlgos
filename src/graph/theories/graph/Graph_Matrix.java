/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graph.theories.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    /**
     * BF Traversal for connected graph in file
     *
     * @param filename
     * @param startVIdx
     * @param visited
     */
    void BF_TraversalAllDisconnected_File(String filename,
                                          int startVIdx) {

        try {
            // Random Access File
            RandomAccessFile rf = new RandomAccessFile(filename, "rw");
            Queue<Integer> queue = new LinkedList<>();
            // Queue and visitted for the BFS algorithms
            boolean[] visited = this.createVisittedArray();

            // Write the title to the file 
            // In Windows, a new line is denoted using “\r\n”
            rf.writeBytes("BF traversal from the vertex " + vSet[startVIdx] + ": \r\n");

            for (int vCol = startVIdx; vCol < this.nVertices; vCol++) {
                if (visited[startVIdx] == false) {

                    // Add first element and write to the file 
                    queue.add(startVIdx);
                    visited[startVIdx] = true;

                    while (!queue.isEmpty()) {

                        // Remove the top of the queue
                        int currVIdx = queue.remove();
                        fvisit(currVIdx, rf);

                        for (int i = 0; i < nVertices; i++) {

                            // Checking if those nodes are visited or not, if not, adding to queue
                            if (this.adjMatrix[currVIdx][i] != 0 && visited[i] == false) {
                                queue.add(i);
                                visited[i] = true;
                            }
                        }
                    }
                }
            }

            // Close the file
            rf.writeBytes("\r\n");
            rf.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Graph_Matrix.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Graph_Matrix.class.getName()).log(Level.SEVERE, null, ex);
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
                                boolean[] visited
    ) {

        // Printing vertex
        visited[currVIdex] = true;
        this.printVertex(currVIdex); // changing to fvisit if printing to file

        // Go to the row of current Vertex, get the first posible path
        for (int i = 0; i < nVertices; i++) {
            if (visited[i] == false && this.adjMatrix[currVIdex][i] > 0) {

                // visit the next vertex when connecting with vIdx
                DFS_TraversalConnected(i, visited);
            }
        }
    }

    /**
     * Function Overloadding for DFS
     *
     * @param startVIdx
     */
    void DFS_TraversalConnected(int startVIdx
    ) {
        boolean[] visited = this.createVisittedArray();
        DFS_TraversalConnected(startVIdx, visited);
    }

    /**
     * Traversing all disconnected graph
     *
     * @param startVIdx
     */
    void DFS_TraversalAllDisconnectedGraph(int startVIdx
    ) {

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

    private RandomAccessFile createFile(String fname) throws Exception {
        File f = new File(fname);
        if (f.exists()) {
            f.delete();     // if the file exist then we return it 
        }
        RandomAccessFile rf = new RandomAccessFile(f, "rw");
        return rf;
    }

    public void fvisit(int idx,
                       RandomAccessFile f) {
        try {
            f.writeBytes(vSet[idx] + " ");
        } catch (IOException ex) {
            Logger.getLogger(Graph_Matrix.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

        // Testing BF an DFS Traversal
//        matrix.BF_TraversalConnected(1);
//        matrix.BF_TraversalAllDisconnectedGraph(2);
//        matrix.DFS_TraversalConnected(1);
//        matrix.DFS_TraversalAllDisconnectedGraph(4);
        // Testing BFS to file
        matrix.BF_TraversalAllDisconnected_File("E:\\Learning\\FPT\\2022_Semester-3\\CSD201\\AdvancedTopic\\Algorithms\\DataAlgos\\src\\graph\\theories\\graph\\data\\OUTPUT_BFS.txt", 0);
//        matrix.BF_TraversalConnected(0);
        matrix.BF_TraversalAllDisconnectedGraph(0);
    }
}
