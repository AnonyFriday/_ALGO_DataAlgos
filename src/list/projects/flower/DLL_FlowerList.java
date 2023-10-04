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
}
