/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.bst.projects.aquariumfish;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import tree.bst.projects.CountNodes;
import tree.bst.projects.FindTreeHeight;
import tree.bst.projects.MaximumValueInBTree;
import tree.bst.projects.MinimumValueInTree;
import static tree.bst.projects.aquariumfish.BSTAquariumFileOperation.BFS_file;
import tree.bst.theories.BSTree;
import tree.bst.theories.BSTNode;

/**
 * The Aquarium Tree using Binary Search Tree as the storage
 *
 * @author duyvu
 */
public class BSTAquarium extends BSTree<AquariumFish> {

    // ======================================
    // = Create methods
    // ======================================
    /**
     * Adding fishes to the tree based on the addNode function
     *
     * @param fishes
     */
    public void addFishes(AquariumFish... fishes) {
        for (AquariumFish fish : fishes) {
            addNode(fish);
        }
    }

    // ======================================
    // = Search methods
    // ======================================
    /**
     * Searching the fish recursively
     *
     * @param root
     * @param fish
     *
     * @return
     */
    public BSTNode searchFishRecur(BSTNode root,
            AquariumFish fish) {

        // If root is null then return null
        if (root == null) {
            return null;
        }

        // Comparing based on key
        int key = fish.compareTo((AquariumFish) root.data);

        // key = 0 then return the current node that = fish
        if (key == 0) {
            return root;
        } else if (key < 0) {
            return searchFishRecur((BSTNode) root.left, fish);
        } else {
            return searchFishRecur((BSTNode) root.right, fish);
        }
    }

    /**
     * Searching the fish iteratively
     *
     * @param fish
     *
     * @return
     */
    public BSTNode searchFishIterative(AquariumFish fish) {

        // If the tree is empty then simply return null
        if (this.isEmpty()) {
            return null;
        }

        BSTNode targetNode = this.root;
        while (targetNode != null) {
            int key = fish.compareTo((AquariumFish) targetNode.data);

            // Check the key, if equal then return, if not then advancing to the next 
            // left or right node
            if (key == 0) {
                break;
            } else if (key < 0) {
                targetNode = (BSTNode) targetNode.left;
            } else {
                targetNode = (BSTNode) targetNode.right;
            }
        }

        return targetNode;
    }

    // ======================================
    // = Delete methods
    // ======================================
    /**
     * Delete a fish by using coping technique
     *
     * @param fish
     *
     * @return
     */
    public BSTNode deleteFish(AquariumFish fish) {
        BSTNode node = search(fish);
        super.deleteNodeByCopying(node);
        return node;
    }

    // Testing 
    public static void main(String[] args) {
        BSTAquarium aqua = new BSTAquarium();
        AquariumFish[] arr = new AquariumFish[]{
            new AquariumFish("B"),
            new AquariumFish("G"),
            new AquariumFish("A"),
            new AquariumFish("K"),
            new AquariumFish("Z"),
            new AquariumFish("F"),
            new AquariumFish("W"),
            new AquariumFish("E"),
            new AquariumFish("R")};

        // Testing Add
        aqua.addFishes(arr);
        BSTree.printAlignedHorizontally(aqua.root, "\t");

        // Testing Search Recursively
        System.out.println(aqua.searchFishRecur(aqua.root, new AquariumFish("K")).data);
        System.out.println(aqua.searchFishRecur(aqua.root, new AquariumFish("a")));

        // Testing Search Iteratively
        System.out.println(aqua.searchFishIterative(new AquariumFish("K")).data);
        System.out.println(aqua.searchFishIterative(new AquariumFish("a")));

        // Checking remove
        System.out.println(aqua.deleteFish(new AquariumFish("B"))); // delete root       
        System.out.println(aqua.deleteFish(new AquariumFish("A"))); // delete A (0 node)
        System.out.println(aqua.deleteFish(new AquariumFish("G"))); // delete G (2 node)
        System.out.println(aqua.deleteFish(new AquariumFish("E"))); // delete E (0 node)
        System.out.println(aqua.deleteFish(new AquariumFish("F"))); // delete G (1 node)
        System.out.println(aqua.deleteFish(new AquariumFish("K"))); // delete K (1 node)
        BSTree.printAlignedHorizontally(aqua.root, "\t");

        // Testing File
//        BSTAquariumFileOperation.BFS_file(aqua.root);
        BSTAquariumFileOperation.inorder_file(aqua.root);

        // Check Min, Max, Height, Number of nodes
        System.out.println("Nodes: " + CountNodes.countNodes(aqua.root));
        System.out.println("Max " + MaximumValueInBTree.getMaxValueIterative(aqua.root));
        System.out.println("Min " + MinimumValueInTree.getMinValue(aqua.root));
        System.out.println("Height: " + FindTreeHeight.maxHeightTreeIteration(aqua.root));
        System.out.println("Height: " + FindTreeHeight.maxHeightTreeRecursion(aqua.root));
    }
}
