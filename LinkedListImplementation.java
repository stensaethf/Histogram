/**
 * LinkedListImplementation.java
 * A Java program for the implementation of a list using linked nodes
 * Created by Frederik Roenn Stensaeth (and partially Javier Moran)
 * 05.11.14
 */

import java.util.Iterator;

/** Class for the implementation of a list using linked nodes. */
public class LinkedListImplementation<T> implements List<T> {
    private Node first_node = null;
    /** Class for Nodes. Nodes keep track of value and what is the next 
     * node. */
    private class Node {
        /** T variable val is the value a node holds. */
        public T val;
        /** Node variable next is the next node in the chain. */
        public Node next;
        /** Creates an instance of the node. */
        private Node(T value) {
            val = value;
            next = null;
        }
    }

    /** Adds newItem to the end of the list. */
    public void add(T newItem) {
        Node node = new Node(newItem);
        Node current = first_node;
        if(first_node == null) {
            first_node = node;
        } else {
            // Traverses the chain to find the end.
            for(int i = 1; i < length(); i++) {
                current = current.next;
            }
            current.next = node;
        }
    }
    
    /** Adds newItem at the given index.
     * Adds newItem at index newPosition, and shifts each item at or beyond
     * that index to the next higher index.
     *   Note that L.add(L.length(), x) is a valid call, and its effect is
     * equivalent to L.add(x).
     * Postcondition: The item at newPosition is newItem.
     * @return false if newPosition is out of bounds.  For this method (and
     *   only this method), the length of the list is considered in bounds.
     */
    public boolean add(int newPosition, T newItem) {
        // Checks if newPosition is valid.
        if(newPosition > this.length() || newPosition < 0) {
            return false;
        }
        Node node = new Node(newItem);
        Node current = first_node;
        Node prior = null;
        Node after = null;
        // Adds node at the beginning of chain.
        if(newPosition == 0) {
            node.next = first_node;
            first_node = node;
        // Adds node at the end of chain.
        } else if(newPosition == this.length()) {
            this.add(newItem);
        } else {
            // Traverses the chain and inserts new node at newPosition in 
            //chain.
            for(int i = 0; i < newPosition + 1; i++) {
                if(i == newPosition - 1) {
                    prior = current;
                } else if(i == newPosition) {
                    after = current;
                }
                current = current.next;
            }
            prior.next = node;
            node.next = after;
        }
        return true;
    }
    
    /** Removes the item at the given index.
     * Removes the item at the given index, shifts each item beyond that
     * index to the next lower index.
     * @return the removed item, or null if position is out of bounds.
     */
    public T remove(int position) {
        // Checks if position is valid.
        if(this.length() - 1 < position || position < 0) {
            return null;
        }
        Node current = first_node;
        Node prior = null;
        Node after = null;
        Node target = null;
        // Sets first node to be second node and returns value of current if 
        //position is zero.
        if(position == 0) {
            first_node = current.next;
            return current.val;
        }
        // Traverses the chain and sets next node of node prior to postion to 
        //node after position.
        for(int i = 0; i < length(); i++) {
            if(i == position - 1) {
                prior = current;
            } else if(i == position + 1) {
                after = current;
            } else if(i == position) {
                target = current;
            }
            current = current.next;
        }
        prior.next = after;
        return target.val;
    }
    
    /** Removes all items from the list. */
    public void clear() {
        first_node = null;
    }
    
    /** Returns the item at a given index.
     * @return the item, or null if position is out of bounds.
     */
    public T at(int position) {
        Node current = first_node;
        // Checks if position is valid.
        if(position < 0 || position >= length()) {
            return null;
        // If position is zero, returns value of first node.
        } else if(position == 0) {
            return first_node.val;
        }
        // Traveses the chain until position and returns the value of the
        //desired position.
        for(int i = 0; i < position; i++) {
            current = current.next;
        }
        return current.val;
    }
    
    /** Replaces the item at a given index.
     * @return false if newPosition is out of bounds.
     */
    public boolean replace(int position, T newItem) {
        // Checks if positon is valid.
        if(this.length() - 1 < position || position < 0) {
            return false;
        }
        Node current = first_node;
        int count = 0;
        // Traverses the chain until position and sets value of node at
        //position to newItem.
        while(count < position) {
            current = current.next;
            count++;
        }
        current.val = newItem;
        return true;
    }
    
    /** Returns true if the list contains the target item. */
    public boolean contains(T targetItem) {
        Node current = first_node;
        // Traverses the chain and checks if targetItem is the value of a node.
        while(current != null) {
            if(current.val.equals(targetItem)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /** Returns the length of the list: the number of items stored in it. */
    public int length() {
        Node current = first_node;
        int count = 0;
        // If chain is empty returns 0.
        if(first_node == null) {
            return count;
        } else {
            // Traverses the chain and increments count.
            while(current != null) {
                current = current.next;
                count++;
            }
        }
        return count;
    }
    
    /** Returns true if the list has no items stored in it. */
    public boolean isEmpty() {
        if(first_node == null) {
            return true;
        }
        return false;
    }
    
    /** Returns an array version of the list.  Note that, for technical reasons,
     * the type of the items contained in the list can't be communicated
     * properly to the caller, so an array of Objects gets returned.
     * @return an array of length length(), with the same items in it as are
     *         stored in the list, in the same order.
     */
    public Object[] toArray() {
        Object[] temporary = new Object[this.length()];
        Node current = first_node;
        // Copies items from ArrayList over to array.
        for(int i = 0; i < this.length(); i++) {
            temporary[i] = current.val;
            current = current.next;
        }
        return temporary;
    }
    
    /** Returns an iterator that begins just before index 0 in this list. */
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Unsupported method");
    }
}