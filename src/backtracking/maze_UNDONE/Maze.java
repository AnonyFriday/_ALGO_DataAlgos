/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backtracking.maze_UNDONE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyvu
 */
/**
 * Denote the notation of the cell
 *
 * @author duyvu
 */
public class Maze {

    // ======================================
    // = Fields
    // ======================================
    // Setting notation for the cell;
    private final char entryChar, destChar, emptyChar, wallChar;

    private int rows, cols;     // size of the maze
    private Cell[][] cells;       // an entire m x n map
    private Cell entryCell;     // an entry cell
    private Cell destCell;      // a final destination

    private boolean isCompleted;    // Check if the maze has been solve completed or not
    private boolean isSucceeded;    // Check if the maze can be solved or not

    // ======================================
    // = Constructor
    // ======================================
    /**
     * Constructor for default cell's label
     */
    public Maze() {
        entryChar = 'E';
        destChar = 'M';
        emptyChar = '0';
        wallChar = '1';
    }

    /**
     * Constructor for default cell's label
     *
     * @param entryChar
     * @param destChar
     * @param emptyChar
     * @param wallChar
     */
    public Maze(char entryChar,
                char destChar,
                char emptyChar,
                char wallChar) {
        this.entryChar = entryChar;
        this.destChar = destChar;
        this.emptyChar = emptyChar;
        this.wallChar = wallChar;
    }

    // ======================================
    // = Read
    // ======================================
    /**
     * Printing the entire cells of the maze
     */
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println(cells[i][j].value);
            }
        }
    }

    // ======================================
    // = Files
    // ======================================
    public void loadFromFile(String filename) {

        FileReader fr = null;
        BufferedReader bf = null;
        try {
            // Check if the file is exist or not
            File file = new File(filename);
            if (!file.exists()) {
                throw new RuntimeException("File not found. Please try again.");
            }

            // A stream for reading files
            fr = new FileReader(file);       // read 1 unicode
            bf = new BufferedReader(fr);  // read a whole line

            String line;
            ArrayList<String> mazeList = new ArrayList<>(); // containg each line within the file's maze

            while ((line = bf.readLine()) != null) {
                line = line.trim();
                mazeList.add(line);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Construct the maze from the mazeList imported from the file
     *
     * @param mazeList
     * @return
     */
    public boolean constructMazeFromMazeList(List<String> mazeList) {
        this.rows = mazeList.size();                    // number of rows based on list size
        this.cols = mazeList.get(0).length();       // number of 1 element's size
        this.cells = new Cell[rows][cols];              // Construct m x n maze

        // Iterate the list and create each cell
        for (int i = 0; i < rows; i++) {
            String line = mazeList.get(i);          // 101M10110101
            for (int j = 0; j < cols; j++) {

                char cellValue = line.charAt(j);    // 101M10110101, index 3 => M

                // Add new cell to the maze
                Cell cell = new Cell(rows, cols, cellValue);

                // Check if the that cell is a block or not, entry, desc
                if (cellValue == wallChar) {
                    cell.setAWall();
                } else if (cellValue == entryChar) {
                    this.entryCell = cell;
                } else if (cellValue == destChar) {
                    this.destCell = cell;
                }

                // Adding cell to the maze
                this.cells[i][j] = cell;
            }
        }

        // if not found entryCell and destCell than the maze cannoit be complete
        return this.entryCell != null && this.destCell != null;
    }
}
