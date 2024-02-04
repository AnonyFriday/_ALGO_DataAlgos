/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.theories.singly;

/**
 * Simulating the Linked List of Value
 *
 * @author duyvu
 */
public class SinglyLinkedList<E extends Comparable<E>> {

    // =============================
    // == Fields
    // =============================
    public Node head;
    public Node tail;
    private int size;

    // =============================
    // == Constructors
    // =============================
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // =============================
    // == Adding Method Groups
    // =============================
    /**
     * Adding the first element to the empty list
     *
     * @param node
     */
    private void addIfListEmpty(E x) {
        Node newNode = new Node(x);

        // If node is the first element in the array
        if (newNode != null) {
            head = tail = newNode;
            this.size++;
        }
    }

    /**
     * Add Node to head of the list
     *
     * @param node
     */
    public void addFirst(E x) {

        // If the list is empty
        if (this.isEmpty()) {
            addIfListEmpty(x);
        } else {

            // If the list is not empty
            Node newNode = new Node(x);
            newNode.nextNode = this.head;
            this.head = newNode;

            // Increment number of nodes by 1
            this.size++;
        }
    }

    /**
     * Add the Node to the end of the list
     * <p>
     * The tail reference is pointing to the last object Node Set the nextNode
     * of the last object Node to the newly added Node Set the tail reference
     * pointing to the newly added Node
     *
     * @param node: newly created node
     */
    public void addLast(E x) {

        // If the list is empty
        if (this.isEmpty()) {
            addIfListEmpty(x);
        } else {

            // If the list is not empty
            Node newNode = new Node(x);
            this.tail.nextNode = newNode;
            this.tail = newNode;

            // Increment number of nodes by 1
            this.size++;
        }
    }

    /**
     * Adding Node to the specific position
     *
     * @param node
     * @param pos
     */
    public void add(E x, int pos) {
        int idx = pos - 1;  // start from index 0, not 1

        // when no elements, adding to the list
        if (this.isEmpty()) {
            this.addIfListEmpty(x);
            return;
        } else if (idx == 0) {
            this.addFirst(x);
            return;
        } else if (idx == this.size) {
            this.addLast(x);
            return;
        } else if (idx > this.size || idx < 0) {
            return;
        }

        Node temp = this.head;
        Node newNode = new Node(x);
        int count = 1;             // prev of the inserted => -1, not 0

        // finding the previous node of the inserted position
        while (count < idx && temp != null) {
            temp = temp.nextNode;
            count++;
        }

        // Switching a referecne of temp node and next node
        newNode.nextNode = temp.nextNode;
        temp.nextNode = newNode;
        this.size++;
    }

    // =============================
    // == Reverse Method Groups
    // =============================
    /**
     * Reverse the list using 3 pointers
     */
    public void reverseNodes() {

        // If having no or only 1 element, return null
        if (this.isEmpty() || this.size == 1) {
            return;
        }

        // Create 3 pointers to reverse the list
        Node pCurr = this.head;
        Node pPrev = null;
        Node pNext = this.head.nextNode;

        // A -> B -> C -> D -> NULL
        // Head           Tail
        // NULL <- A <- B <- C <- D
        //         Tail           Head
        while (pCurr != null) {
            pCurr.nextNode = pPrev;
            pPrev = pCurr;
            pCurr = pNext;

            // Incase pNext equals to null, so that it cannot 
            // extract nextNode at the end
            if (pNext != null) {
                pNext = pNext.nextNode;
            }
        }

        // Linking back tail and head
        this.tail = this.head;
        this.head = pPrev;
    }

    /**
     * Instead of reversing the nodes, we reverse the data on node
     */
    public void reverseData() {

        int leftIdx = 0;
        int rightIdx = this.size - 1;

        for (; leftIdx < rightIdx; leftIdx++, rightIdx--) {
            Node pLeft = get(leftIdx + 1); // e.g. get(position) -> index 0 = position 1
            Node pRight = get(rightIdx + 1);

            // Swapping first and last
            E tmp = (E) pLeft.getData();
            pLeft.setData(pRight.getData());
            pRight.setData(tmp);
        }
    }

    // =============================
    // == Remove Method Groups
    // =============================
    /**
     * Remove first element of the linked list
     * <br>
     * Create a temp node pointing to the next Node, while setting the current
     * to null and setting back the head to temp afterward
     */
    public void removeFirst() {
        if (this.isEmpty()) {
            return;
        }

        // contains only 1 node
        if (head.nextNode == null) {
            head = tail = null;
            this.size--;
            return;
        }

        // Create a temp node poining to the next Node after Head Node
        Node temp = this.head.nextNode;

        // Set the current head node = null 
        // In fact, if no pointer points to the Object, the Object will be terminated by the Garbage Collector
//        this.head = null;
        // Set the back of the head node to the next node
        this.head = temp;
        this.size--;
    }

    /**
     * Remove last element of the linked list
     * <p>
     * Create a temp node pointing to the backward Node, while setting the
     * current tail to null and setting it to temp afterward
     */
    public void removeLast() {
        if (this.isEmpty()) {
            return;
        }

        // contains only 1 node
        if (this.head.nextNode == null) {
            this.head = this.tail = null;
            this.size--;
            return;
        }

        // Iterating until reaching the next-to-tail node
        Node temp = this.head;
        while (temp.nextNode != this.tail) {
            temp = temp.nextNode;
        }

        // Setting null to deference the next node, release the last Object to GC
        this.tail = temp;
        this.tail.nextNode = null;
        this.size--;
    }

    public void removeAt(int pos) {

        // Does not remove when the list is empty
        int idx = pos - 1;

        if (this.isEmpty() || idx < 0 || idx >= this.size) {
            return;
        } else if (idx == 0) {
            this.removeFirst();
            return;
        } else if (idx == this.size - 1) {
            this.removeLast();
            return;
        }

        // Track the node before the target node
        Node temp = this.head;

        int count = 0;

        while (count < idx - 1 && temp != null) {
            temp = temp.nextNode;
            count++;
        }

        // Linking from 1 to 3, emit 2
        Node tempAfter = temp.nextNode;
        temp.nextNode = tempAfter.nextNode;
    }

    // =============================
    // == Search Method Groups
    // =============================
    /**
     * Search the Element using the Iterative Approach
     *
     * @param x : Represent the value or the Object (forcing to override the
     *          comparable function for the case of Object)
     *
     * @return the first position found in the linked list（0 base position)
     */
    public int searchReturnPos(E x) {

        // Predefine exceptions to ignore only 1 element and 0 element
        if (isEmpty()) {
            return -1;
        }

        Node pNode = this.head;
        int pos = 0;
        while (pNode != null) {
            if (pNode.getData().equals(x)) {
                return pos;
            }

            pos++;
            pNode = pNode.nextNode;
        }
        return pos + 1;
    }

    /**
     * Search the Element using Recursive Approach
     *
     * <br>**Using Function Overloading to achieve the default function's
     * parameters in Java**
     *
     * @param x: Represent the value or the Object (forcing to override the
     *           comparable function for the case of Object)
     *
     * @return the first position found in the linked list（0 base position)
     */
    public int searchReturnPosRecursive(E x) {
        return searchReturnPosRecursive(this.head, x);
    }

    private int searchReturnPosRecursive(Node node, E x) {
        // Entry point to exit if reach the end of list
        if (node == null) {
            return -1;
        }

        // Entry point to exit if the node has been found 
        if (node.getData().equals(x)) {
            return 0;
        }

        // Recursive finding on position
        int pos = searchReturnPosRecursive(node.nextNode, x);

        // If not found, return -1, backtracking
        if (pos != -1) {

            // If found, increase the pos by backtracking since pos starting at index 1
            return pos + 1;
        }

        return pos;
    }

    /**
     * Searching the node based on given data
     *
     * @param x
     *
     * @return
     */
    public Node searchReturnNode(E x) {
        Node pNode = this.head;
        while (pNode != null && !pNode.getData().equals(x)) {
            pNode = pNode.nextNode;
        }

        return pNode;
    }

    /**
     * Get Node at the current index
     *
     * @param idx
     *
     * @return
     */
    public Node get(int position) {

        int idx = position - 1; // starting from index 0, not 1

        if (isEmpty()) {
            return null;
        } else if (idx < 0 || idx >= this.size) {
            return null;
        } else if (idx == 0) {
            return this.head;
        } else if (idx == this.size - 1) {
            return this.tail;
        }

        // counting from the head
        Node pNode = this.head;
        int count = 0;
        while (count < idx && pNode != null) {
            count++;
            pNode = pNode.nextNode;
        }
        return pNode;
    }

    /**
     * Find max data within the linked list
     *
     * @return
     */
    public Node findMaxData() {
        if (isEmpty()) {
            return null;
        }

        Node maxNode, pNode;
        maxNode = pNode = head;

        while (pNode != null) {
            E pData = (E) pNode.getData();
            E maxData = (E) maxNode.getData();

            // If data > max, assign to max
            if (pData.compareTo(maxData) > 0) {
                maxNode.setData(pData);
            }

            pNode = pNode.nextNode;
        }

        // Return the maxNode
        return maxNode;
    }

    // =============================
    // == Sort Methods
    // =============================
    /**
     * Sorting the linked list using selection sort with condition
     *
     * <br><br>If sorting on condition, change the swapping [CONDITION]
     *
     * @return
     */
    public void sortOnCondition(int lowerBound, int higherBound) {

        // Return nothing if the bound is over the element of the list
        if (lowerBound < 1 || higherBound > this.size) {
            return;
        }

        // Initialize the essential variables
        Node currNode = this.head;
        Node compNode = null;

        // working on the index = 0, not the position 1th
        int countOuter = lowerBound - 1;
        int countInner = 0;

        while (countOuter <= higherBound - 1) {

            // Assign node to the next value
            compNode = currNode.nextNode;
            countInner = countOuter + 1;

            // Swapping using bubble sort
            while (countInner <= higherBound) {
                E data1 = (E) currNode.getData();
                E data2 = (E) compNode.getData();

                // Swapping based on [CONDITION]
                if (data1.compareTo(data2) > 0) {
                    E tmp = data1;
                    currNode.setData(data2);
                    compNode.setData(tmp);
                }

                // Forwarding compNode to the next element
                compNode = compNode.nextNode;
                countInner++;
            }
            currNode = currNode.nextNode;
            countOuter++;
        }
    }

    /**
     * Sorting the list on condition without bound (Selection Sort)
     */
    public void sortOnCondition() {
        if (isEmpty() || head.nextNode == null) {
            return;
        }

        Node outerNode = this.head;
        Node innerNode = null;

        while (outerNode.nextNode != null) {

            innerNode = outerNode.nextNode;
            while (innerNode != null) {

                if (((E) outerNode.getData()).compareTo((E) innerNode.getData()) > 0) {
                    E tmpObj = (E) outerNode.getData();
                    outerNode.setData(innerNode.getData());
                    innerNode.setData(tmpObj);
                }
                innerNode = innerNode.nextNode;
            }
            outerNode = outerNode.nextNode;
        }
    }

    // =============================
    // == Utilities Method Groups
    // =============================
    /**
     * Check if the singly testing is empty or not.
     *
     * @return true if the head is empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Clear the list
     */
    public void clear() {
        head = tail = null;
    }

    /**
     * Return the total nodes of the linked list
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * Traverse the whole link list
     */
    public void traversal() {

        // Create a pointer pointing to head
        Node pNode = head;

        // Traversing until reaching null pointer at the tail
        // - pointing to the next object Node stored inside the pointer.nextNode
        while (pNode != null) {
            System.out.println("Node: " + pNode.getData());
            pNode = pNode.nextNode;
        }
    }

    /**
     * Testing Purpose
     *
     * @param args
     */
    public static void main(String[] args) {

        // Initialize the Singly Linked Lis
        SinglyLinkedList list = new SinglyLinkedList();

        // Testing Add
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(7);
        list.addFirst(3);
        list.addLast(4);
        list.addLast(7);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(7);

        list.add(9999, 5);

//        // Testing get
//        System.out.println("El at position 3: " + list.get(5).getData());
//
//        // Sorting
//        list.sortOnCondition(1, list.size);
//        list.traversal();
//
//        // Testing Search
//        System.out.println("Position of value 3210: " + list.searchReturnPos(3210));
//        System.out.println("Position of value 3210: " + list.searchReturnPosRecursive(3210));
//        System.out.println(" " + list.searchReturnNode(1).getData());
//
//        // Testing remove
//        list.removeAt(0);
//        list.traversal();
//
//        // Testing reverse nodes
//        list.reverseNodes();
//        list.traversal();
//
//        // Testing reverse data on nodes
//        list.reverseData();
//        list.traversal();
//
//        // Testing find max data
//        System.out.println("Max data: " + list.findMaxData().getData());
        // Testing sorting
        list.sortOnCondition();
//        list.sortOnCondition(1, 10);
        list.traversal();
    }
}
