/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tree.bst.theories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import tree.balancebst.theories.SimpleBalanceTheTreeFromArray;
import tree.balancebst.theories.DSWTesting;

/**
 *
 * @author duyvu
 * @param <E>
 */
public class BSTree<E extends Comparable<E>> {

    // ======================================
    // = Fields
    // ======================================
    public BSTNode root;

    // ======================================
    // = Create Methods
    // ======================================
    /**
     * Recursively adding new root to the binary tree
     *
     * <br><br> If data less than root.data then recursively move to the left
     * <br><br> If data greater than root.data then recursively move to the
     * right
     *
     * @param data
     * @param root
     *
     * @return
     */
    private BSTNode addNode(BSTNode<E> root,
            E data) {
        // Ending point, if reaching the left or right leave, return a root and attach to left or right
        // Create new root with added data and attach to the tree
        if (root == null) {
            return new BSTNode(data);
        }

        // Finding the position to add the data
        // if key = 0 means addinng the existed data, then return without addition
        int key = data.compareTo(root.data);

        if (key < 0) {
            root.left = addNode(root.left, data);
        } else if (key > 0) {
            root.right = addNode(root.right, data);
        }

        // Return back the root at each activation recall, like backtracking
        return root;
    }

    /**
     * Function Overloadding for addNode
     *
     * <br><br> If root is null then attach to the root, else calling addNode
     * recursively
     *
     * @param newData
     * @param data
     *
     * @return
     */
    public void addNode(E newData) {
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
    public void addNodeIteration(E newData) {
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
                    currNode = currNode.left;
                } else if (key < 0) {
                    currNode = currNode.right;
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

    /**
     * Add multiple nodes in a single pass
     *
     * @param groups
     */
    public void addNodes(Comparable<E>... groups) {
        for (Comparable data : groups) {
            this.addNode((E) data);
        }
    }

    // ======================================
    // = Search Methods
    // ======================================
    /**
     * Searching node based on given data
     *
     * @param node
     * @param data
     *
     * @return
     */
    public BSTNode search(BSTNode<E> node,
            E data) {

        if (node == null) {
            return null;
        }

        // if equals then return directly
        if (data.compareTo(node.data) == 0) {
            return node;
        }

        // Finding nodes based on the data comparision
        if (data.compareTo(node.data) > 0) {
            return search(node.right, data);
        } else if (data.compareTo(node.data) < 0) {
            return search(node.left, data);
        }

        return null;
    }

    /**
     * Searching
     *
     * @param data
     *
     * @return
     */
    public BSTNode search(E data) {
        return search(this.root, data);
    }

    // ======================================
    // = Pre-order Methods
    // ======================================
    /**
     * Depth First Search using preorder recursion
     *
     * @param data: a given data
     *
     * @return a traversal list
     */
    public List<E> preOrderRecursion() {
        ArrayList<E> resultList = new ArrayList<>();
        preOrderRecursion(resultList, this.root);
        return resultList;
    }

    private void preOrderRecursion(ArrayList<E> resultList,
            BSTNode root) {
        if (root == null) {
            return;
        }

        // Traversingthe list at order Middle -> Left -> Right
        resultList.add((E) root.data);
        preOrderRecursion(resultList, (BSTNode) root.left);
        preOrderRecursion(resultList, (BSTNode) root.right);
    }

    /**
     * Depth First Search Using Preorder Iteration
     *
     * @param node
     * @param data: passed data to form a root
     *
     * @return a list of traversal lists
     */
    public List<E> preOrderIteration(BSTNode node) {

        ArrayList<E> resultList = new ArrayList();
        Stack<BSTNode> stack = new Stack();

        BSTNode cNode = node;
        stack.add(cNode);

        // when there are still 
        while (!stack.isEmpty()) {
            BSTNode currNode = stack.pop();

            // Adding to the list result
            resultList.add((E) currNode.data);

            if (currNode.right != null) {
                stack.push((BSTNode) currNode.right);
            }

            if (currNode.left != null) {
                stack.push((BSTNode) currNode.left);
            }
        }

        // Pattern Root, Left, Right
        return resultList;
    }

    /**
     * Finding node nth when conducting pre order
     *
     * @param pNode
     * @param position
     *
     * @return
     */
    public BSTNode preOrderFindNodeNth(BSTNode pNode, int position) {

        // If position <= 0, return null
        if (position <= 0 || this.isEmpty()) {
            return null;
        }

        // root - left - right
        int count = 0;
        int idx = position - 1; // dealing with index 0
        Stack<BSTNode> stack = new Stack<>();

        stack.add(pNode);

        // looping until count = 4 then stop
        while (!stack.isEmpty()) {
            BSTNode node = stack.pop();

            // At right first so that left will be pop out from the top
            if (count == idx) {
                return node;
            } else {
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
                count++;
            }
        }
        return null;
    }
    // ======================================
    // = Post-order Methods
    // ======================================

    /**
     * Depth First Search Using Post order Recursion
     *
     * @return a list after traversing
     */
    public List<E> postOrderRecursion() {
        ArrayList<E> resultList = new ArrayList<>();
        postOrderRecursion(resultList, this.root);
        return resultList;
    }

    /**
     * Post order using recursiong approach
     *
     * @param resultList
     * @param root
     */
    private void postOrderRecursion(ArrayList<E> resultList,
            BSTNode root) {
        if (root == null) {
            return;
        }

        // Traversingthe list at order Middle -> Left -> Right
        postOrderRecursion(resultList, (BSTNode) root.left);
        postOrderRecursion(resultList, (BSTNode) root.right);
        resultList.add((E) root.data);
    }

    /**
     * Finding node nth using post order traversal recursion (inefficient due to the static variable)
     */
    static int count = 0;

    public BSTNode postOrderFindNodeNth(BSTNode node, int position) {

        if (node == null) {
            return null;
        }

        BSTNode left = postOrderFindNodeNth(node.left, position);
        BSTNode right = postOrderFindNodeNth(node.right, position);

        count++;
        if (count == position) {
            return node;
        }

        return left != null ? left : right;
    }

    public List<E> postOrderIteration(BSTNode node) {
        Stack<BSTNode> stack = new Stack<>();
        ArrayList<E> result = new ArrayList<>();

        BSTNode cNode = node;
        BSTNode prevNode = null;

        while (!stack.isEmpty() || cNode != null) {
            while (cNode != null) {
                stack.add(cNode);
                cNode = cNode.left;
            }

            /**
             * 12
             * 4 20
             * 1 3
             */
            // Peek the top of the stack
            BSTNode peekNode = stack.peek();

            // Check if the node has right or not
            // Tracking the previous visited node 
            if (peekNode.right != null && prevNode != peekNode.right) {
                cNode = peekNode.right; // If has right, then set cNode to right and keep expanding to left
            } else {
                result.add((E) peekNode.data);
                prevNode = stack.pop();
            }
        }

        return result;
    }

    /**
     * Finding node nth using post order iterative
     *
     * @param node
     * @param position
     *
     * @return
     */
    public BSTNode postOrderIterativeFindNodeNth(BSTNode node, int position) {
        if (position < 1 || this.isEmpty()) {
            return null;
        }

        // Handling width index 0 only
        int idx = position - 1;
        int count = 0;

        Stack<BSTNode> stack = new Stack<>();
        BSTNode cNode = node;
        BSTNode prevNode = null;

        while (!stack.isEmpty() || cNode != null) {
            while (cNode != null) {
                stack.add(cNode);
                cNode = cNode.left;
            }

            // Checking the top of the stack
            BSTNode peekNode = stack.peek();

            if (peekNode.right != null && peekNode.right != prevNode) {
                cNode = peekNode.right;
            } else {
                prevNode = stack.pop();
                if (count == idx) {
                    return prevNode;
                }
                count++;
            }
        }

        // If not found then return null
        return null;
    }

    // ======================================
    // = In-order Methods
    // ======================================
    /**
     * Depth First Search Using Inorder Recursion
     *
     * @return a list of inorder recursion
     */
    public List<E> inOrderRecursion() {
        ArrayList<E> resultList = new ArrayList<>();
        inOrderRecursion(resultList, this.root);
        return resultList;
    }

    private void inOrderRecursion(ArrayList<E> resultList,
            BSTNode root) {
        if (root == null) {
            return;
        }

        // Traversingthe list at order Middle -> Left -> Right
        inOrderRecursion(resultList, (BSTNode) root.left);
        resultList.add((E) root.data);
        inOrderRecursion(resultList, (BSTNode) root.right);
    }

    /**
     * Depth First Search using inorder iteration
     *
     * @param node
     *
     * @return a traversal list
     */
    public List<E> inOrderIteration(BSTNode node) {

        ArrayList<E> resultList = new ArrayList();
        Stack<BSTNode> stack = new Stack();

        BSTNode currNode = node;

        while (!stack.isEmpty() || currNode != null) {

            //     12 
            //   1    30
            // 0   2
            // output: 0 1 2 12 30
            // push the 12, then 1 then 0
            // when reaching to the deepest left = null, then pop it and print to the screen
            // move to the right and then move to left, if nothing then return 
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }

            currNode = stack.pop();
            resultList.add((E) currNode.data);

            // Moving to the right
            currNode = currNode.right;
        }

        return resultList;
    }

    /**
     * Find node at nth when conducting inorder traversal
     *
     * @param node
     * @param position
     *
     * @return
     */
    public BSTNode inOrderFindNodeNth(BSTNode node, int position) {

        Stack<BSTNode> stack = new Stack();

        // Working on index 0 only
        int idx = position - 1;
        int count = 0;

        BSTNode pNode = node;
        stack.push(node);

        while (!stack.isEmpty()) {

            //     12 
            //   1    30
            // 0   2
            // output: 0 1 2 12 30
            // push the 12, then 1 then 0
            // when reaching left = null, then pop it and print to the screen
            // move to the right and then move to left, if nothing then return 
            while (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            }

            // Left -> Mid -> Right
            // Return the node nth
            pNode = stack.pop();
            if (count == idx) {
                return pNode;
            }

            // Moving to the right
            pNode = pNode.right;
            count++;
        }

        // If notfound then return null
        return null;
    }

// ======================================
    // = Breadth Methods
    // ======================================
    /**
     * Breath First Search - Using Queue to solve the problem
     *
     * @return
     */
    public List<E> breadthFirstTraversal() {

        ArrayList<E> resultList = new ArrayList<>();
        Queue<BSTNode> tmpQueue = new LinkedList<>();

        if (isEmpty()) {
            return resultList;
        }

        BSTNode currNode = this.root;
        tmpQueue.add(currNode);

        while (!tmpQueue.isEmpty()) {
            currNode = tmpQueue.remove();
            resultList.add((E) currNode.data);

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
    // = Delete By Coyping (0,1,2 child nodes)
    // ======================================
    public void deleteNodeByCopying(BSTNode target) {

        // If empty then return nothing
        if (this.isEmpty()) {
            return;
        }

        // Find the Node and the parent node
        BSTNode parNode = findParentNode(target);
        BSTNode cNode = target;

        // Check terminal nodes of the target node
        int children = countTerminalNode(cNode);
        switch (children) {
            case 0:
                deleteNodeNoTerminal(cNode, parNode);
                break;
            case 1:
                deleteNodeOneTerminal(cNode, parNode);
                break;
            case 2:
                deleteNodeTwoTerminals(cNode);
                break;
        }

    }

    /**
     * Find the parent node of the passed node
     *
     * @param target
     *
     * @return
     */
    public BSTNode findParentNode(BSTNode target) {
        BSTNode pNode = null;
        BSTNode cNode = this.root;

        // Looping until reaching the near end 
        // (not shooting the cNode out to null)
        while (cNode != null) {
            int key = target.data.compareTo(cNode.data);
            if (key == 0) {        // If found then return pNode
                return pNode;
            } else {
                pNode = cNode;      // If pNode = cNode
                if (key > 0) {      // If pNode > target, move to the right
                    cNode = cNode.right;
                } else if (key < 0) {  // else move to the left
                    cNode = cNode.left;
                }
            }
        }

        // return the parent node of the passed node
        return null;
    }

    /**
     * Count number of terminal node from the given node
     *
     * @param target
     *
     * @return
     */
    public int countTerminalNode(BSTNode target) {
        if (target.left != null && target.right != null) {
            return 2;
        } else if (target.left != null || target.right != null) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Delete the node without terminal nodes
     *
     * @param target
     * @param father
     */
    private void deleteNodeNoTerminal(BSTNode target, BSTNode father) {
        if (father.left == target) {
            father.left = null;
        } else {
            father.right = null;
        }
    }

    /**
     * Delete the node with one terminal node
     *
     * @param target
     * @param father
     */
    private void deleteNodeOneTerminal(BSTNode target, BSTNode father) {

        BSTNode grandChild = target.left != null
                ? target.left
                : target.right;

        if (father.left == target) {
            father.left = grandChild;
        } else {
            father.right = grandChild;
        }
    }

    /**
     * Delete Node having 2 children by infix successor or infix predecessor
     *
     * @param target
     */
    private void deleteNodeTwoTerminals(BSTNode target) {
        deleteByInorderPredecessor(target);
//        deleteByInorderSuccessor(target);
    }

    /**
     * Delete target having 2 children by infix predecessor
     *
     * @param target
     */
    private void deleteByInorderPredecessor(BSTNode target) {
        BSTNode parNode = target;
        BSTNode currNode = target.left;

        // Find the infix predecessor of the target
        while (currNode.right != null) {
            parNode = currNode;
            currNode = currNode.right;
        }

        // Swap the target info with infix predecessor infor
        target.data = currNode.data;

        // Check the children of the currNode after swapping with target
        int children = countTerminalNode(currNode);
        switch (children) {
            case 0:
                deleteNodeNoTerminal(currNode, parNode);
                break;
            case 1:
                deleteNodeOneTerminal(currNode, parNode);
                break;
        }
    }

    /**
     * Delete the target having 2 children by Infix Successor
     *
     * @param target
     */
    private void deleteByInorderSuccessor(BSTNode target) {
        BSTNode parNode = target;
        BSTNode currNode = target.right;

        // Find the infix successor  of the target
        while (currNode.left != null) {
            parNode = currNode;
            currNode = currNode.left;
        }

        // Swap the target info with infix predecessor infor
        target.data = currNode.data;

        // Check the children of the currNode after swapping with target
        int children = countTerminalNode(currNode);
        switch (children) {
            case 0:
                deleteNodeNoTerminal(currNode, parNode);
                break;
            case 1:
                deleteNodeOneTerminal(currNode, parNode);
                break;
        }
    }

    // ======================================
    // = Rotate Methods (NO Parent)
    // ======================================
    public void rorateRight(BSTNode node) {

        // If nothing on the left, return null since cannot not rotate
        if (node.left == null) {
            return;
        }
        
        /**
         * FA                           FA
         *      90                          34
         *  34        95           ->              90
         *     35   91   100                    35     95
         *                                           91   100
         * Create a virtual moved subtree, attach all child of leftnode to its
         * and attach the virtual subtree to the right after
         */
        BSTNode movedSubTree = new BSTNode(node.data);
        movedSubTree.left = node.left.right;
        movedSubTree.right = node.right;
        
        // Assign back the value to the rotated node
        node.data = node.left.data;
        node.left = node.left.left;
        node.right = movedSubTree;
        
    }

    public void rotateLeft(BSTNode node) {

    }

    // ======================================
    // = Utility Methods
    // ======================================
    /**
     * Print out the tree in horizontal format representation
     *
     * @param prefix: adding the prefix decoration in front of the tree
     * @param node
     */
    public static void printAlignedHorizontally(BSTNode node,
            String prefix) {

        // Applying 
        if (node != null) {
            printAlignedHorizontally((BSTNode) node.right, prefix + "\t");
            System.out.println(prefix + "|-- " + node.data.toString());
            printAlignedHorizontally((BSTNode) node.left, prefix + "\t");
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
     * Clear the tree
     */
    public void clear() {
        root = null;
    }

    /**
     * Testing Area
     *
     * @param args
     */
    public static void main(String[] args) {

        BSTree<Integer> tree = new BSTree<>();
        Integer[] arr = new Integer[]{5, 1, 9, 8, 7, 0, 2, 3, 4, 6};

        // Tesing Adding and traversal algorithm
        for (int i = 0; i < arr.length; i++) {
            tree.addNode(arr[i]);
        }

        System.out.println(tree.breadthFirstTraversal());

        // Testing conducting a height-balanced tree
        Arrays.sort(arr);
        List<Integer> list = SimpleBalanceTheTreeFromArray.balance(arr);
        for (int i = 0; i < arr.length; i++) {
            tree.addNode(list.get(i));
        }

        printAlignedHorizontally(tree.root, "\t");

        // Testing Searching 
        System.out.println("Node 700: " + tree.search(700));
        System.out.println("Node 0: " + tree.search(0).data);

        System.out.println("Preorder: " + tree.preOrderIteration(tree.root));
        System.out.println("Inorder: " + tree.inOrderIteration(tree.root));
        System.out.println("Postorder: " + tree.postOrderIteration(tree.root));

        // Finding 4th in preoreder, inorder, postorder
        System.out.println("4th preorder: " + tree.preOrderFindNodeNth(tree.root, 4).data);
        System.out.println("6th inorder: " + tree.inOrderFindNodeNth(tree.root, 6).data);
        System.out.println("8th postorder: " + tree.postOrderFindNodeNth(tree.root, 8).data);
        System.out.println("8th postorder iter: " + tree.postOrderIterativeFindNodeNth(tree.root, 8).data);

        // Checking delete node
        tree.deleteNodeByCopying(tree.search(6));
        printAlignedHorizontally(tree.root, "\t");
        
        // Checking the rotate left and right
        BSTNode node = tree.search(5);
        tree.rorateRight(node);
        printAlignedHorizontally(tree.root, "\t");

    }
}
