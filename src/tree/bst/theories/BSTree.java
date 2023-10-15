/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tree.bst.theories;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import tree.node.BSTNode;

/**
 *
 * @author duyvu
 * @param <T>
 */
public class BSTree<T extends Comparable<T>> {

    // ======================================
    // = Fields
    // ======================================
    public BSTNode<T> root;

    // ======================================
    // = Create Methods
    // ======================================
    /**
     * Recursively adding new root to the binary tree
     *
     * <br><br> If data less than root.data then recursively move to the left
     * <br><br> If data greater than root.data then recursively move to the right
     *
     * @param data
     * @param root
     * @return
     */
    private BSTNode addNode(BSTNode<T> root,
                            T data) {
        // Ending point, if reaching the left or right leave, return a root and attach to left or right
        // Create new root with added data and attach to the tree
        if (root == null) {
            return new BSTNode(data);
        }

        // Finding the position to add the data
        // if key = 0 means addinng the existed data, then return without addition
        int key = data.compareTo(root.data);

        if (key < 0) {
            root.left = addNode((BSTNode<T>) root.left, data);
        } else if (key > 0) {
            root.right = addNode((BSTNode<T>) root.right, data);
        }

        // Return back the root at each activation recall, like backtracking
        return root;
    }

    /**
     * Function Overloadding for addNode
     *
     * <br><br> If root is null then attach to the root, else calling addNode recursively
     *
     * @param newData
     * @param data
     * @return
     */
    public void addNode(T newData) {
        // If empty, make it a nsew node
        if (isEmpty()) {
            root = new BSTNode(newData);
        }

        // if not empty, then recursively adding new node as a leave  
        root = addNode(root, newData);
    }

    /**
     * Adding Node to the Binary Tree using iteration
     *
     * @param newData
     */
    public void addNodeIteration(T newData) {
        BSTNode newNode = new BSTNode(newData);

        // If empty then attach new node into it 
        if (isEmpty()) {
            this.root = newNode;
        } else {
            BSTNode prevNode = null;
            BSTNode currNode = this.root;

            // Finding the fix position for the new Data
            while (currNode != null) {

                // Attach the previous node to the current tracking node
                prevNode = currNode;

                // Comparing 2 object based on the compareTo function
                int key = currNode.data.compareTo(newData);

                if (key > 0) {
                    currNode = (BSTNode) currNode.left;
                } else if (key < 0) {
                    currNode = (BSTNode) currNode.right;
                } else {
                    // Indicate the node is existes, dont need to add into the tree
                    return;
                }
            }

            // Set the previous left or right to the new data node itself
            if (prevNode.data.compareTo(newData) > 0) {
                prevNode.left = new BSTNode(newData);
            } else {
                prevNode.right = new BSTNode(newData);
            }
        }
    }

    // ======================================
    // = Read Methods
    // ======================================
    /**
     * Depth First Search using preorder recursion
     *
     * @param data: a given data
     * @return a traversal list
     */
    public List<T> preOrderRecursion() {
        ArrayList<T> resultList = new ArrayList<>();
        preOrderRecursion(resultList, this.root);
        return resultList;
    }

    private void preOrderRecursion(ArrayList<T> resultList,
                                   BSTNode root) {
        if (root == null) {
            return;
        }

        // Traversingthe list at order Middle -> Left -> Right
        resultList.add((T) root.data);
        preOrderRecursion(resultList, (BSTNode) root.left);
        preOrderRecursion(resultList, (BSTNode) root.right);
    }

    /**
     * Depth First Search Using Preorder Iteration
     *
     * @param data: passed data to form a root
     * @return a list of traversal lists
     */
    public List<T> preOrderIteration() {

        ArrayList<T> resultList = new ArrayList();
        Stack<BSTNode> stk = new Stack();

        stk.push(this.root);

        // when there are still 
        while (!stk.isEmpty() && this.root != null) {
            BSTNode currNode = stk.pop();

            resultList.add((T) currNode.data);

            if (currNode.left != null) {
                stk.push((BSTNode) currNode.left);
            }
            if (currNode.right != null) {
                stk.push((BSTNode) currNode.right);
            }
        }

        // Pattern Root, Left, Right
        return resultList;
    }

    /**
     * Depth First Search Using Post order Recursion
     *
     * @return a list after traversing
     */
    public List<T> postOrderRecursion() {
        ArrayList<T> resultList = new ArrayList<>();
        postOrderRecursion(resultList, this.root);
        return resultList;
    }

    private void postOrderRecursion(ArrayList<T> resultList,
                                    BSTNode root) {
        if (root == null) {
            return;
        }

        // Traversingthe list at order Middle -> Left -> Right
        postOrderRecursion(resultList, (BSTNode) root.left);
        postOrderRecursion(resultList, (BSTNode) root.right);
        resultList.add((T) root.data);
    }

    /**
     * Depth First Search Using post order iteration
     *
     * @return
     */
//    public List<T> postOrderIteration() {
//	ArrayList<T> resultList = new ArrayList();
//	Stack<BTNode> stk = new Stack();
//	
//	BTNode currNode = this.root;
//
//	//     5 
//	//   1    4
//	//      2   3
//	// output: 0 2
//	// Push to stack with the order 5 1 4
//	// 
//	while (!stk.isEmpty() || currNode != null) {
//	    
//	   // Start from the left-most first
//	   while (currNode.left != null) {
//	       stk.push(currNode);
//	       currNode = currNode.left;
//	   }
//	   
//	   currNode = stk.pop();
//	   resultList.add((T) currNode);
//	   
//	   currNode = currNode.right;
//	}
//	
//	return resultList;
//    }
    /**
     * Depth First Search Using Inorder Recursion
     *
     * @return a list of inorder recursion
     */
    public List<T> inOrderRecursion() {
        ArrayList<T> resultList = new ArrayList<>();
        inOrderRecursion(resultList, this.root);
        return resultList;
    }

    private void inOrderRecursion(ArrayList<T> resultList,
                                  BSTNode root) {
        if (root == null) {
            return;
        }

        // Traversingthe list at order Middle -> Left -> Right
        inOrderRecursion(resultList, (BSTNode) root.left);
        resultList.add((T) root.data);
        inOrderRecursion(resultList, (BSTNode) root.right);
    }

    /**
     * Depth First Search using inorder iteration
     *
     * @return a traversal list
     */
    public List<T> inOrderIteration() {

        ArrayList<T> resultList = new ArrayList();
        Stack<BSTNode> stk = new Stack();

        BSTNode currNode = this.root;

        while (!stk.isEmpty() || currNode != null) {

            //     12 
            //   1    30
            // 0   2
            // output: 0 1 2 12 30
            // push the 12, then 1 then 0
            // when reaching left = null, then pop it and print to the screen
            // move to the right and then move to left, if nothing then return 
            if (currNode != null) {
                stk.push(currNode);
                currNode = (BSTNode) currNode.left;
            } else {
                currNode = stk.pop();
                resultList.add((T) currNode.data);
                currNode = (BSTNode) currNode.right;
            }
        }

        return resultList;
    }

    /**
     * Breath First Search - Using Queue to solve the problem
     *
     * @return
     */
    public List<T> breadthFirstTraversal() {

        ArrayList<T> resultList = new ArrayList<>();
        Queue<BSTNode> tmpQueue = new LinkedList<>();

        if (isEmpty()) {
            return resultList;
        }

        BSTNode currNode = this.root;
        tmpQueue.add(currNode);

        while (!tmpQueue.isEmpty()) {
            currNode = tmpQueue.remove();
            resultList.add((T) currNode.data);

            // Adding both left and right of the current node to the list if found
            if (currNode.left != null) {
                tmpQueue.add((BSTNode) currNode.left);
            }

            if (currNode.right != null) {
                tmpQueue.add((BSTNode) currNode.right);
            }
        }

        return resultList;
    }

    // ======================================
    // = Delete Methods (0,1,2 child nodes)
    // ======================================
    /**
     * Count children of the terminal nodes
     *
     * @param tNode
     * @return
     */
    public int countChildrenOfTerminal(BSTNode tNode) {

        // No children
        if (tNode.left == null && tNode.right == null) {
            return 0;
        }

        // If 2 child, then return 2
        if (tNode.left != null && tNode.right != null) {
            return 2;
        } else {

            // Return 1 if only 1 child
            return 1;
        }
    }

    /**
     * Delete zero child of the deletedNode
     *
     * @param fatherNode
     * @param deletedNode
     * @return
     */
    public BSTNode deleteZeroChild(BSTNode fatherNode,
                                   BSTNode deletedNode) {

        // root
        if (deletedNode == root && fatherNode == null) {
            root = null;
        } else {
            // terminal -> deletedNode
            if (fatherNode.left == deletedNode) {
                fatherNode.left = null;
            } else {
                fatherNode.right = null;
            }
        }
        return deletedNode;
    }

    /**
     * Delete a target node having 1 child
     *
     *
     * <br><br>If the node is a root, then just delete it
     * <br><br>If the node is a terminal node having 1 child, then remove it,
     * <br><br>attach the link from the father to its child based on left or right
     *
     * @param deletedNode
     * @return
     */
    public BSTNode deleteOneChild(BSTNode fatherNode,
                                  BSTNode deletedNode) {

        // If the deletedNode is the root
        // deletedNode -> child
        if (deletedNode == root) {
            root = (root.left != null)
                   ? (BSTNode) root.left
                   : (BSTNode) root.right;
        } else {

            // Father -> deletedNode -> Child
            BSTNode grandChild = (deletedNode.left != null)
                                 ? (BSTNode) deletedNode.left
                                 : (BSTNode) deletedNode.right;
            if (fatherNode.right == deletedNode) {
                fatherNode.right = grandChild;
            } else {
                fatherNode.left = grandChild;
            }
        }

        return deletedNode;
    }

    /**
     * Delete the 2 child of deletedNode by using Coping technique
     *
     * @param deletedNode
     * @return
     */
    public BSTNode deleteTwoChildByCoping(BSTNode deletedNode) {

        // Find the predecessor, father of the left subtree under the deleted Node
        BSTNode rightMostFather = deletedNode;
        BSTNode rightMost = (BSTNode) deletedNode.left;

        while (rightMost.right != null) {
            rightMostFather = rightMost;
            rightMost = (BSTNode) rightMost.right;
        }

        // Copying the rightMost to the deletedNode
        /* 
         *          3
         *      1             5  <-- delete
         *        rMost --> 4    8
         * e.g. delete 5, rightMost = 4, rightMostFather = 5
         * 
         *          3
         *      1          4
         * rev rMost --> 4    8
         * using delete noChild, or oneChild
         */
        deletedNode.data = rightMost.data;

        // Remove the rMost node
        int childs = countChildrenOfTerminal(rightMost);

        // Remove if the rMost has 1 child or 0 child
        if (childs == 0) {
            return deleteZeroChild(rightMostFather, rightMost);
        } else {
            return deleteOneChild(rightMostFather, rightMost);
        }
    }

//    /**
//     * Delete the 2 child of deletedNode by using Merging technique
//     *
//     * <br><br>The merging will probably increase the height of the tree
//     *
//     * @param deletedNode
//     * @return
//     */
//    public BSTNode deleteTwoChildByMerging(BSTNode deletedNode) {
//
//    }

    // ======================================
    // = Additional Methods
    // ======================================
    /**
     * Print out the tree in horizontal format representation
     *
     * @param prefix: adding the prefix decoration in front of the tree
     * @param node
     */
    public static void print(String prefix,
                             BSTNode node) {

        // Applying 
        if (node != null) {
            print(prefix + "\t", (BSTNode) node.right);
            System.out.println(prefix + "|-- " + node.data.toString());
            print(prefix + "\t", (BSTNode) node.left);
        }
    }

    /**
     * Check if the tree is empty or not
     *
     * @return true if empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Testing Area
     *
     * @param args
     */
    public static void main(String[] args) {

        BSTree<Integer> tree = new BSTree<>();
        int[] arr = new int[]{7, 1, 0, 8, 9, 2, 15, 6, 13, 14, 5};

        for (int i = 0; i < arr.length; i++) {
            tree.addNode(arr[i]);
        }

        System.out.println(tree.breadthFirstTraversal());

        print("", tree.root);
    }
}
