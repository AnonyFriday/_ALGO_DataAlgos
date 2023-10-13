/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tree.theories.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author duyvu
 * @param <T>
 */
public class BTree<T extends Comparable<T>> {

    // ======================================
    // = Fields
    // ======================================
    BTNode<T> root;

    // ======================================
    // = Related Methods
    // ======================================
    public static void print(String prefix, BTNode node) {

	// Applying 
	if (node != null) {
	    print(prefix + "\t", node.right);
	    System.out.println(prefix + "|-- " + node.getData());
	    print(prefix + "\t", node.left);
	}
    }

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
    private BTNode addNode(T data,
	    BTNode<T> root) {
	// Ending point, if reaching the left or right leave, return a root and attach to left or right
	// Create new root with added data and attach to the tree
	if (root == null) {
	    return new BTNode<>(data);
	}

	if (data.compareTo(root.getData()) < 0) {
	    root.left = addNode(data, root.left);
	} else {
	    root.right = addNode(data, root.right);
	}

	return root;
    }

    /**
     * Function Overloadding for addNode
     *
     * <br><br> If root is null then attach to the root, else calling addNode recursively
     *
     * @param data
     * @return
     */
    public boolean addNode(T data) {
	// If empty, make it a nsew node
	if (isEmpty()) {
	    root = new BTNode<>(data);
	    return true;
	}

	// if not empty, then recursively adding new node as a leave  
	return addNode(data, root) != null;
    }

    public void addNodeIteration(T data) {

	// If empty then attach new node into it 
	if (isEmpty()) {
	    this.root = new BTNode(data);
	} else {
	    BTNode prevNode = this.root;
	    BTNode currNode = this.root;

	    while (currNode != null) {
		switch (currNode.getData().compareTo(data)) {
		    case 1:
			prevNode = currNode;
			currNode = currNode.left;
			break;
		    case -1:
			prevNode = currNode;
			currNode = currNode.right;
			break;
		    default:
			return;
		}
	    }

	    if (prevNode.getData().compareTo(data) == 1) {
		prevNode.left = new BTNode(data);
	    } else {
		prevNode.right = new BTNode(data);
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

    private void preOrderRecursion(ArrayList<T> resultList, BTNode root) {
	if (root == null) {
	    return;
	}

	// Traversingthe list at order Middle -> Left -> Right
	resultList.add((T) root.getData());
	preOrderRecursion(resultList, root.left);
	preOrderRecursion(resultList, root.right);
    }

    /**
     * Depth First Search Using Preorder Iteration
     *
     * @param data: passed data to form a root
     * @return a list of traversal lists
     */
    public List<T> preOrderIteration() {

	ArrayList<T> resultList = new ArrayList();
	Stack<BTNode> stk = new Stack();

	stk.push(this.root);

	// when there are still 
	while (!stk.isEmpty() && this.root != null) {
	    BTNode currNode = stk.pop();

	    resultList.add((T) currNode.getData());

	    if (currNode.left != null) {
		stk.push(currNode.left);
	    }
	    if (currNode.right != null) {
		stk.push(currNode.right);
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

    private void postOrderRecursion(ArrayList<T> resultList, BTNode root) {
	if (root == null) {
	    return;
	}

	// Traversingthe list at order Middle -> Left -> Right
	postOrderRecursion(resultList, root.left);
	postOrderRecursion(resultList, root.right);
	resultList.add((T) root.getData());
    }

    /**
     * Depth First Search Using post order iteration
     * @return 
     */
    public List<T> postOrderIteration() {
	ArrayList<T> resultList = new ArrayList();
	Stack<BTNode> stk = new Stack();
	
	BTNode currNode = this.root;

	//     5 
	//   1    4
	//      2   3
	// output: 0 2
	// Push to stack with the order 5 1 4
	// 
	while (!stk.isEmpty() || currNode != null) {
	    
	   // Start from the left-most first
	   while (currNode.left != null) {
	       stk.push(currNode);
	       currNode = currNode.left;
	   }
	   
	   currNode = stk.pop();
	   resultList.add((T) currNode);
	   
	   currNode = currNode.right;
	}
	
	return resultList;
    }

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

    private void inOrderRecursion(ArrayList<T> resultList, BTNode root) {
	if (root == null) {
	    return;
	}

	// Traversingthe list at order Middle -> Left -> Right
	inOrderRecursion(resultList, root.left);
	resultList.add((T) root.getData());
	inOrderRecursion(resultList, root.right);
    }

    /**
     * Depth First Search using inorder iteration
     *
     * @return a traversal list
     */
    public List<T> inOrderIteration() {

	ArrayList<T> resultList = new ArrayList();
	Stack<BTNode> stk = new Stack();

	BTNode currNode = this.root;

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
		currNode = currNode.left;
	    } else {
		currNode = stk.pop();
		resultList.add((T) currNode.getData());
		currNode = currNode.right;
	    }
	}

	return resultList;
    }

    /**
     * Check if the tree is empty or not
     *
     * @return true if empty
     */
    public boolean isEmpty() {
	return root == null;
    }

    public static void main(String[] args) {
	BTree<Integer> tree = new BTree<>();
	tree.addNode(12);
	tree.addNode(9);
	tree.addNode(1);
	tree.addNode(100);
	tree.addNode(101);
	tree.addNode(102);
	tree.addNodeIteration(2);
	tree.addNodeIteration(0);

	System.out.println(tree.preOrderIteration());
	System.out.println(tree.postOrderRecursion());
	System.out.println(tree.inOrderRecursion());
	System.out.println(tree.inOrderIteration());

	print("", tree.root);
    }

}
