/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list.projects.flower;

/**
 *
 * @author duyvu
 */
public class DLL_FlowerList {

    // ====================================
    // = Fields
    // ====================================
    private DLL_Node head;
    private DLL_Node tail;

    // ====================================
    // = Constructor
    // ====================================
    /**
     * Default Constructor
     */
    public DLL_FlowerList() {
        head = tail = null;
    }

    // ====================================
    // = Methods
    // ====================================
    /**
     * Check if the list is null or not
     *
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }

    // ====================================
    // = Create Methods
    // ====================================
    /**
     * Add first node to the list O(1)
     *
     * @param f: an flower object
     * @return true if add successfully
     */
    public boolean addFirst(Flower f) {

        // Encapsulate a flower in a node
        DLL_Node newNode = new DLL_Node(f);

        // If list is null then set head = tail = newNode
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            // NULL <-- newNode <--> head
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;         // Pointing head to the newNode
        }
        return true;
    }

    /**
     * Add last node to the list O(1)
     *
     * @param f: an flower object
     * @return true if add successfully
     */
    public boolean addLast(Flower f) {
        // Encapsulate a flower in a node
        DLL_Node newNode = new DLL_Node(f);

        // If list is null then set head = tail = null
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            // NULL tail <--> newNode --> NULL
            newNode.next = null;
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        return true;
    }

    /**
     * Add new node before the given node
     *
     * @param p: given node
     * @param f: new data object
     * @return
     */
    public boolean addBeforeNode(DLL_Node p,
                                 Flower f) {
        if (this.isEmpty() || p == head) {
            return addFirst(f);
        } else {
            DLL_Node newNode = new DLL_Node(f);
            DLL_Node before = p.prev;

            // before <--> newNode <--> p
            before.next = newNode;
            p.prev = newNode;
            newNode.prev = before;
            newNode.next = p;
        }
        return true;
    }

    /**
     * Add new node after the given node
     *
     * @param p: given node
     * @param f: given object Flower
     * @return true if adding successfully
     */
    public boolean addAfterNode(DLL_Node p,
                                Flower f) {
        if (this.isEmpty() || p == tail) {
            return addLast(f);
        } else {
            DLL_Node newNode = new DLL_Node(f);
            DLL_Node after = p.next;

            // p <--> newNode <--> after
            p.next = newNode;
            after.prev = newNode;
            newNode.prev = p;
            newNode.next = after;
        }
        return true;
    }

    // ====================================
    // = Search Methods
    // ====================================
    /**
     * Searching the Node using flower name
     *
     * @param flowerName
     * @return
     */
    public DLL_Node search(String flowerName) {
        if (this.isEmpty()) {
            return null;
        }

        Flower targetFlower = new Flower(flowerName);
        DLL_Node targetNode = null;

        // Loop until the targetNode has been founded
        while (targetNode != null) {

            // If found succesfull, then return the element immediately
            if (targetNode.getFlower().equals(targetFlower)) {
                return targetNode;
            } else {
                targetNode = targetNode.next;
            }
        }

        return targetNode;
    }

    // ====================================
    // = Remove Methods
    // ====================================
    /**
     * Remove the first Node
     *
     * @return a removed node
     */
    public DLL_Node removeFirst() {
        if (isEmpty()) {
            return null;
        }

        DLL_Node removedNode = head;

        if (head == tail) {
            // List only has 1 item
            head = tail = null;
        } else {
            // NULL <-- removed <--> next

            // Cutoff the link betweeen removed and next node
            DLL_Node nextNode = head.next;
            removedNode.next = null;
            nextNode.prev = null;
            head = nextNode;
        }

        return removedNode;
    }

    /**
     * Remove the last Node
     *
     * @return a removed node
     */
    public DLL_Node removeLast() {
        if (isEmpty()) {
            return null;
        }

        DLL_Node removedNode = tail;

        if (head == tail) {
            head = tail = null;
        } else {
            // prev <--> removed --> null
            DLL_Node prevNode = tail.prev;

            // Cutoff the link between removed and prev node
            prevNode.next = null;
            removedNode.prev = null;
            tail = prevNode;
        }
        return removedNode;
    }

    /**
     * Remove the given node from the list
     *
     * @param node: given node
     * @return a removed node
     */
    public DLL_Node remove(DLL_Node node) {
        if (isEmpty()) {
            return null;
        }
        if (node == head) {
            return removeFirst();
        }
        if (node == tail) {
            return removeLast();
        }

        // prev <--> node <--> next
        DLL_Node prevNode = node.prev;
        DLL_Node nextNode = node.next;

        // Set the link between prev and next, cutoff the link from node to both sides
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.next = null;
        node.prev = null;

        return node;
    }

    /**
     * Remove the flower name
     *
     * @param flowerName
     * @return a removed node containing a flower name
     */
    public DLL_Node remove(String flowerName) {
        // If empty then return nothing
        if (isEmpty()) {
            return null;
        }

        // Search the node having the flower name first 
        DLL_Node removedNode = this.search(flowerName);
        if (removedNode == head) {
            return removeFirst();
        }
        if (removedNode == tail) {
            return removeLast();
        }

        // If removedNode is null than return null, else return the removed node
        return removedNode != null ? remove(removedNode) : null;
    }
}
