/**
 * ArrayListImplementation.java
 * A Java program for the implementation of a list using an array.
 * Created by Frederik Roenn Stensaeth and Javier Moran Lemus. 
 * 05.11.14
 */

import java.util.Iterator;
import java.util.Arrays;

/** Class for the implementation of a list using an array. */
public class ArrayListImplementation<T> implements List<T> {
    private T[] array;
    private Integer size = 0;
    /** Creates an Instance of the array. */
    public ArrayListImplementation() {
        @SuppressWarnings("unchecked")
          T[] temporary_array = (T[]) new Object[8];
          array = temporary_array;
    }

    /** Adds newItem to the end of the list. */
    public void add(T newItem) {
        ensureCapacity();
        array[size] = newItem;
        size++;
    }
    
    /** Adds newItem at the given index.
     * Adds newItem at index newPosition, and shifts each item at or beyond
     * that index to the next higher index.
     *   Note that L.add(L.length(), x) is a valid call, and its effect is
     * equivalent to L.add(x).
     * Postcondition: The item at newPosition is newItem.
     * @return false if newPosition is out of bounds.  For this method (and only
     *   this method), the length of the list is considered in bounds.
     */
    public boolean add(int newPosition, T newItem) {
        ensureCapacity();
        // Checks if newPosition is a valid index.
        if(newPosition == size || !indexOutOfBounds(newPosition)) {
            // Moves all items at index newPosition and after to the next index 
            //to make room for new item.
            for(int i = size; i > newPosition; i--) {
                array[i] = array[i - 1];
            }
            array[newPosition] = newItem;
            size++;
            return true;
        }
        return false;
    }
    
    /** Removes the item at the given index.
     * Removes the item at the given index, shifts each item beyond that index
     * to the next lower index.
     * @return the removed item, or null if position is out of bounds.
     */
    public T remove(int position) {
        if(!indexOutOfBounds(position)) {
            T target = array[position];
            // Moves all items at index position and after to the previous
            //index.
            for(int i = position; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            size--;
            return target;
        }
        return null;
    }
    
    /** Removes all items from the list. */
    public void clear() {
        for(int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
    
    /** Returns the item at a given index.
     * @return the item, or null if position is out of bounds.
     */
    public T at(int position) {
        if(!indexOutOfBounds(position)) {
            return array[position];
        }
        return null;
    }
    
    /** Replaces the item at a given index.
     * @return false if newPosition is out of bounds.
     */
    public boolean replace(int position, T newItem) {
        if(!indexOutOfBounds(position)) {
            array[position] = newItem;
        }
        return false;
    }
    
    /** Returns true if the list contains the target item. */
    public boolean contains(T targetItem) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(targetItem)) {
                return true;
            }
        }
        return false;
    }
    
    /** Returns the length of the list: the number of items stored in it. */
    public int length() {
        return size;
    }
    
    /** Returns true if the list has no items stored in it. */
    public boolean isEmpty() {
        if(size > 0) {
            return false;
        }
        return true;
    }
    
    /** Returns an array version of the list.  Note that, for technical reasons,
     * the type of the items contained in the list can't be communicated
     * properly to the caller, so an array of Objects gets returned.
     * @return an array of length length(), with the same items in it as are
     *         stored in the list, in the same order.
     */
    public Object[] toArray() {
        @SuppressWarnings("unchecked")
          T[] tmp = (T[]) new Object[size];
        for(int i = 0; i < size; i++) {
            tmp[i] = array[i];
        }
        return tmp;
    }
    
    /** Returns an iterator that begins just before index 0 in this list. */
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Unsopperted Method");
    }

    /** Returns true if the position provided is less than 0,
    * or greater than the size of the list. */
    private boolean indexOutOfBounds(int position) {
        if(position > size - 1 || position < 0) {
            return true;
        }
        return false;
    }

    /** Makes sure that there is enough space for an extra item in the array,
    * if there is not, creates and returns an array of double size. */
    private void ensureCapacity() {
        if(array.length == size) {
            @SuppressWarnings("unchecked")
              T[] tmp = (T[]) new Object[size * 2];
            for(int i = 0; i < tmp.length; i++) {
                if(i < size) {
                    tmp[i] = array[i];
                } else {
                    tmp[i] = null;
                }
            }
            array = tmp;
        }
    }
}