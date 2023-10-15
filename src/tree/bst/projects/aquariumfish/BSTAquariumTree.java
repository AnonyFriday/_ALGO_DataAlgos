/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.bst.projects.aquariumfish;

import tree.bst.theories.BSTree;
import tree.node.BSTNode;
import tree.node.Fish;

/**
 * The Aquarium Tree using Binary Search Tree as the storage
 *
 * @author duyvu
 */
public class BSTAquariumTree extends BSTree<AquariumFish> {

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

    // Testing 
    public static void main(String[] args) {
        BSTAquariumTree aqua = new BSTAquariumTree();
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
        BSTree.print("\t", aqua.root);

        // Testing Search Recursively
        System.out.println(aqua.searchFishRecur(aqua.root, new AquariumFish("K")).data);
        System.out.println(aqua.searchFishRecur(aqua.root, new AquariumFish("a")));

        // Testing Search Iteratively
        System.out.println(aqua.searchFishIterative(new AquariumFish("K")).data);
        System.out.println(aqua.searchFishIterative(new AquariumFish("a")));
    }
}
