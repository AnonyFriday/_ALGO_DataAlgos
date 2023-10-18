/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.node;

/**
 *
 * @author duyvu
 */
public class AVLNode<T extends Comparable<T>> {

    // ======================================
    // = Fields
    // ======================================
    public AVLNode<T> left, right;
    public T data;
    public int height;  // height of the right subtree - height of the left subtree

    // ======================================
    // = Fields
    // ======================================
    public AVLNode(T data) {
        this.left = this.right = null;
        this.data = data;
        this.height = 1;
    }

    public void setHeight(AVLNode<T> leftRoot,
                          AVLNode<T> rightRoot) {

        // Get the height of from the left and right subtree
        int lHeight = leftRoot == null ? 0 : leftRoot.height;
        int rHeight = rightRoot == null ? 0 : rightRoot.height;

        // Return the max height from left and right
        this.height = Math.max(lHeight, rHeight) + 1;
    }
}
