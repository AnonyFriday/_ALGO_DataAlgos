/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backtracking.maze_UNDONE;

/**
 * A cell within a maze, it might have
 * row
 * col
 * isBlocked
 * visited
 * previous
 *
 * @author duyvu
 */
public class Cell {

    protected int row;                // denote the y coordinator
    protected int col;                // denote the x coordinator
    protected char value;             // 1, M, T, 0
    protected boolean isBlocked;      // a wall or not
    protected boolean isVisited;      // has been visited or not 
    protected Cell previous;          // previous cell visited

    // ======================================
    // = Constructor
    // ======================================
    /**
     * Initialize the value
     *
     * @param row
     * @param col
     * @param value
     */
    public Cell(int row,
                int col,
                char value) {
        this.row = row;
        this.col = col;
        this.value = value;
        isBlocked = false;          // an open cell by default
        isVisited = false;          // not visited by default
        previous = null;            // does not attach to any node by default
    }

    // Set a cell to be a wall
    public void setAWall() {
        this.isBlocked = isBlocked;
    }

    // Set a cell that it has been visited
    public void setVisited() {
        this.isVisited = true;
    }

    // Check if the cell can be visited or not 
    public boolean canBeVisited() {
        return !this.isBlocked && !this.isVisited;
    }

    // Override the string
    @Override
    public String toString() {
        return String.format("(%d, %d, %c)", row, col, value);
    }
}
