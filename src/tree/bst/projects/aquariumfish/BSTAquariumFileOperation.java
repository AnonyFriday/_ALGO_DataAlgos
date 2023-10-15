/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.bst.projects.aquariumfish;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import tree.node.BSTNode;

/**
 *
 * @author duyvu
 */
public abstract class BSTAquariumFileOperation {
    
    public static Scanner sc = new Scanner(System.in);

    /**
     * Print out the node to the screen
     *
     * @param node
     */
    public static void visit(BSTNode node) {
        System.out.println(node);
    }

    /**
     * Print out the node to the file using PrintWriter
     *
     * @param pw
     * @param node
     */
    public static void visit_file(PrintWriter pw,
                                  BSTNode node) {
        try {
            pw.println(node.data.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Breadth First Search to the file
     *
     * @param pw
     * @param root
     */
    public static void BFS_file(PrintWriter pw,
                                BSTNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
        
        Queue<BSTNode> queue = new LinkedList();
        queue.add(root);
        
        BSTNode currNode;
        
        while (!queue.isEmpty()) {

            // Extract the node and print to the file
            currNode = queue.poll();
            visit_file(pw, root);

            // Expanding to left and right
            if (currNode.left != null) {
                queue.add((BSTNode) root.left);
            } else if (currNode.right != null) {
                queue.add((BSTNode) root.right);
            }
        }

        // Close PrintWriter after printing the entire tree
        pw.close();
    }

    /**
     * Inorder traversal to print the output to file
     *
     * @param pw
     * @param root
     */
    public static void inorder_file(PrintWriter pw,
                                    BSTNode root) {

        // if nothing than printout the tree is empty
        if (root != null) {            
            inorder_file(pw, (BSTNode) root.left);
            visit_file(pw, root);
            inorder_file(pw, (BSTNode) root.right);
        }        
    }
}
