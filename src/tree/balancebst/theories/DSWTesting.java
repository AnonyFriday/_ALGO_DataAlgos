/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tree.balancebst.theories;

import tree.bst.theories.BSTNode;

/**
 * [UNDONE]
 *
 * @author duyvu
 */
public interface DSWTesting {

    /**
     * Rotate Right,
     *
     * @param Gp    grandparent node
     * @param Par   parent node
     * @param Child child node
     */
    public abstract void rotateRight(BSTNode Gp,
	    BSTNode Par,
	    BSTNode Child);

    /**
     * Rotate left
     *
     * @param Gp    grandparent node
     * @param Par   parent node
     * @param Child child node
     */
    public abstract void rotateLeft(BSTNode Gp,
	    BSTNode Par,
	    BSTNode Child);

    /**
     * Create Right backbone to become the right-redgr
     */
    void createBackBone();
}
