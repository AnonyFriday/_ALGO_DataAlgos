/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.projects.softdrink;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyvu
 */
public class SLL_SoftDrink implements FileHandling<SoftDrink> {

    // ====================================
    // = Fields
    // ====================================
    private SLL_Node head, tail;

    // ====================================
    // = Constructor
    // ====================================
    public SLL_SoftDrink() {
        head = tail = null;
    }

    // ====================================
    // = Methods
    // ====================================
    /**
     * Check if the Linked List is null or not
     *
     * @return true or false if null
     */
    public boolean isEmpty() {
        return head == null;
    }

    // TODO: reverse function in error
    public void reverse() {
        if (this.isEmpty()) {
            return;
        }

        // Create 3 pointers to handle before, after, current pointer
        SLL_Node pPrev = null, pCurr = head, pNext = pCurr.next;

        // loop until the pCurr is null
        while (pCurr != null) {
            // Linking backward
            pCurr.next = pPrev;

            // Shifting previous and current after linking
            pPrev = pCurr;
            pCurr = pNext;

            if (pCurr != null) {
                pNext = pCurr.next;
            }
        }

        // Update head and tail
        pCurr = head;
        head = tail;
        tail = pCurr;
    }

    // ====================================
    // = Create Methods
    // ====================================
    /**
     * Add first node to the singly linked list
     *
     * @param drink
     */
    public void addFirst(SoftDrink drink) {
        SLL_Node node = new SLL_Node(drink);

        // If empty then assign head and tail to node
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;       // Link the new node to the head
            head = node;            // now, the new node is the head
        }
    }

    /**
     * Add last node to the singly linked list
     *
     * @param drink
     */
    public void addLast(SoftDrink drink) {
        SLL_Node node = new SLL_Node(drink);

        // If empty then assign head and tail to node
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;       // link the new node to the tail
            tail = node;            // now, the new node is the tail
        }
    }

    // ====================================
    // = Search Methods
    // ====================================
    /**
     * Searching the SoftDrink using linear search O(n)
     *
     * @param productionLine
     * @return a SoftDrink
     */
    public SoftDrink search(String productionLine) {

        // If empty then return null
        if (this.isEmpty()) {
            return null;
        }

        SLL_Node p = head;

        // O(n) in Time complexity
        while (p != null) {
            if (p.getData().getProductLine().equals(productionLine)) {
                return p.getData();
            }
            // Keep increment untill getting the result
            p = p.next;
        }

        // If not found then return null
        return null;
    }

    // ====================================
    // = Read Methods
    // ====================================
    private void visit(SLL_Node node) {
        System.out.println(node.getData().toString() + "\n");
    }

    /**
     * Print all node within the list
     */
    public void printAll() {
        if (this.isEmpty()) {
            System.out.println("EMPTY LIST.");
        } else {
            for (SLL_Node p = head; p != null; p = p.next) {
                visit(p);
            }
        }
    }

    // ====================================
    // = Delete Methods
    // ====================================
    /**
     * Remove based on given productLine
     *
     * @param productLine
     * @return
     */
    public SoftDrink remove(String productLine) {

        // If the list is empty then return null
        if (isEmpty()) {
            return null;
        }

        SoftDrink removeData = null;
        SoftDrink cmpTarget = new SoftDrink(productLine);

        // Initialize pointer to keeptrack
        SLL_Node pPrev = null, pDel = head;

        // Loop until found the node
        while (pDel != null && !pDel.getData().equals(cmpTarget)) {
            pPrev = pDel;
            pDel = pDel.next;
        }

        // if element is in the list
        if (pDel != null) {
            removeData = pDel.getData();
            if (pDel == head) {         // if at head
                if (head == tail) {     // if only 1 element
                    head = tail = null;
                } else {
                    head = head.next;
                }
            } else if (pDel == tail) { // if at tail
                pPrev.next = null;
                tail = pPrev;
            } else {
                pPrev.next = pDel.next;  // removing a middle node
            }
        }

        // If not found then return null
        return removeData;
    }

    /**
     * Remove the last node of the linked list
     *
     * @return a removed object SoftDrink
     */
    public SoftDrink removeLast() {
        if (isEmpty()) {
            return null;
        }

        SLL_Node pCurr = head;
        SLL_Node pRemoved = tail;

        // If only 1 element
        if (head != null && head.next == null) {
            head = tail = null;
        } else {

            // Loop until found the node before the tail
            while (pCurr.next != tail) {
                pCurr = pCurr.next;
            }

            // Set the tail to the previous node
            pCurr.next = null;
            tail = pCurr;
        }

        return pRemoved.getData();
    }

    /**
     * Remove the first node of the linked list
     *
     * @return an object SoftDrink
     */
    public SoftDrink removeFirst() {
        if (isEmpty()) {
            return null;
        }

        SLL_Node pRemoved = head;

        // If only 1 element
        if (head != null && head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
        }

        return pRemoved.getData();
    }

    // ====================================
    // = Implemented from File Handling
    // ====================================
    /**
     * Normalize the line of file to the SoftDrink object
     *
     * @param line: a line from a file
     * @return a new Soft Drink object
     */
    @Override
    public SoftDrink createObjectFromLine(String line) {
        StringTokenizer stk = new StringTokenizer(line, ",");

        String productLine = stk.nextToken().trim();
        String company = stk.nextToken().trim();
        int volumne = Integer.parseInt(stk.nextToken().trim());
        int price = Integer.parseInt(stk.nextToken().trim());
        return new SoftDrink(productLine, company, volumne, price);
    }

    /**
     * Reading a file containing SoftDrink to the list
     *
     * @param filename
     */
    @Override
    public void readObjectsFromFile(String filename) {
        FileReader fr = null;
        BufferedReader bf = null;
        try {
            fr = new FileReader(filename);
            bf = new BufferedReader(fr);

            // Reading a line (no empty line) and add to the linked list
            String line;
            while ((line = bf.readLine()) != null && !line.isBlank()) {
                this.addFirst(createObjectFromLine(line));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SLL_SoftDrink.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SLL_SoftDrink.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            // Close the connection of FileReader and BufferedReader
            try {
                fr.close();
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(SLL_SoftDrink.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param filename
     */
    @Override
    public void writeObjectsToFile(String filename) {

    }

    public static void main(String[] args) throws IOException {
        SLL_SoftDrink list = new SLL_SoftDrink();

        list.readObjectsFromFile(".\\src\\list\\projects\\softdrink\\data\\source.txt");

        // Test print a list
//        list.printAll();

        // Test reverse
//        list.reverse();
//        list.printAll();
        // Test add first, add last
        list.addFirst(new SoftDrink("Chim", "Chim", 10000, 1000));
        list.addLast(new SoftDrink("Chim", "Chim", 10000, 1000));

        list.printAll();
    }
}
