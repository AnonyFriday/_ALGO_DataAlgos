/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.bst.projects;

import static tree.bst.projects.MinimumValueInTree.getMinValue;
import tree.bst.theories.BSTree;
import tree.bst.theories.BSTree;
import tree.bst.theories.BSTNode;
import tree.bst.projects.aquariumfish.Fish;
import static tree.bst.theories.BSTree.printAlignedHorizontally;

/**
 *
 * @author duyvu
 */
public class SearchOnTree {

    public static <T> BSTNode searchNode(BSTNode root,
                                         T target) {

        // If root is null or reaching the base case, then return null;
        if (root == null) {
            return null;
        }

        // If root = target, then return the target
        if (root.data.equals(target)) {
            return root;
        }

        int key = root.data.compareTo(target);

        // root < target
        if (key < 0) {
            return searchNode((BSTNode) root.right, target);
        }

        // root > target
        return searchNode((BSTNode) root.left, target);
    }

    public static void main(String[] args) {
        BSTree<Fish> tree = new BSTree<>();
        Fish[] arr = new Fish[]{
            new Fish("A", 7),
            new Fish("A", 1),
            new Fish("A", 1000),
            new Fish("A", 3000),
            new Fish("A", -1),
            new Fish("A", -13),
            new Fish("A", 34),
            new Fish("A", 20),
            new Fish("A", -1)};

        for (Fish fish : arr) {
            tree.addNode(fish);
        }

        BSTree.printAlignedHorizontally(tree.root, "\t");

        // Not found Node
        System.out.println("Node: " + searchNode(tree.root, new Fish("A", 15)));

        // Found Node
        System.out.println("Node: " + searchNode(tree.root, new Fish("A", -13)).data);
    }
}
