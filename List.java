import java.util.Iterator;
/** 
 * An interface for the List ADT.
 * 
 * @param <T> The type of data that the list stores.
 * 
 * @author Jadrian Miles
 */
public interface List<T> extends Iterable<T> {
    /** Adds newItem to the end of the list. */
    public void add(T newItem);
    
    /** Adds newItem at the given index.
     * Adds newItem at index newPosition, and shifts each item at or beyond
     * that index to the next higher index.
     *   Note that L.add(L.length(), x) is a valid call, and its effect is
     * equivalent to L.add(x).
     * Postcondition: The item at newPosition is newItem.
     * @return false if newPosition is out of bounds.  For this method (and only
     *   this method), the length of the list is considered in bounds.
     */
    public boolean add(int newPosition, T newItem);
    
    /** Removes the item at the given index.
     * Removes the item at the given index, shifts each item beyond that index
     * to the next lower index.
     * @return the removed item, or null if position is out of bounds.
     */
    public T remove(int position);
    
    /** Removes all items from the list. */
    public void clear();
    
    /** Returns the item at a given index.
     * @return the item, or null if position is out of bounds.
     */
    public T at(int position);
    
    /** Replaces the item at a given index.
     * @return false if newPosition is out of bounds.
     */
    public boolean replace(int position, T newItem);
    
    /** Returns true if the list contains the target item. */
    public boolean contains(T targetItem);
    
    /** Returns the length of the list: the number of items stored in it. */
    public int length();
    
    /** Returns true if the list has no items stored in it. */
    public boolean isEmpty();
    
    /** Returns an array version of the list.  Note that, for technical reasons,
     * the type of the items contained in the list can't be communicated
     * properly to the caller, so an array of Objects gets returned.
     * @return an array of length length(), with the same items in it as are
     *         stored in the list, in the same order.
     */
    public Object[] toArray();
    
    /** Returns an iterator that begins just before index 0 in this list. */
    public Iterator<T> iterator();
}
