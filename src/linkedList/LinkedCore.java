package linkedList;

import org.eclipse.jdt.annotation.Nullable;

/**
 * LinkedCore defines an abstract class to implement standard methods
 * 
 * @author     Shawn Graven (Zekrom)
 * @date       10/24/19
 *
 * @param  <E>
 *                 The type of the LinkedList
 */
public abstract class LinkedCore <@Nullable
E>{
	/**
	 * The size of the LinkedList
	 */
	protected long size;

	/**
	 * Gets the head based index element
	 *
	 * @param  index
	 *                   The index to get the value at
	 * @return       The value at the index
	 */
	public E getHead(final long index){
		return this.getNodeHead(index).getValue();
	}

	/**
	 * Gets the head based index element
	 *
	 * @param  index
	 *                   The index to get the value at
	 * @return       The Node at the index
	 */
	public abstract Node<E> getNodeHead(final long index);

	/**
	 * Gets the tail based index element
	 *
	 * @param  index
	 *                   The index to get the value at
	 * @return       The Node at the index
	 */
	public abstract Node<E> getNodeTail(final long index);

	/**
	 * Gets the size of the Linked List
	 *
	 * @return The size
	 */
	public long getSize(){
		return this.size;
	}

	/**
	 * Gets the tail based index element
	 *
	 * @param  index
	 *                   The index to get the value at
	 * @return       The value at the index
	 */

	public E getTail(final long index){
		return this.getNodeTail(index).getValue();
	}

	/**
	 * Inserts the value at the head of the LinkedList
	 *
	 * @param value
	 *                  The value to insert
	 */
	public abstract void insertHead(E value);

	/**
	 * Inserts the values at the head of the LinkedList
	 *
	 * @param values
	 *                   The values to insert
	 */
	@SuppressWarnings("unchecked")
	public abstract void insertHead(E... values);

	/**
	 * Inserts the value at the head based index of the LinkedList
	 *
	 * @param  index
	 *                   The index to insert after
	 * @param  value
	 *                   The value to insert
	 * @return       Success of the operation
	 */
	public abstract boolean insertHead(long index, E value);


	/**
	 * Inserts the values at the tail of the LinkedList
	 *
	 * @param value
	 *                  The value to insert
	 */
	public abstract void insertTail(E value);

	/**
	 * Inserts the values at the tail of the LinkedList
	 *
	 * @param values
	 *                   The values to insert
	 */
	@SuppressWarnings("unchecked")
	public abstract void insertTail(E... values);

	/**
	 * Inserts the value at the tail based index of the LinkedList
	 *
	 * @param  index
	 *                   The index to insert after
	 * @param  value
	 *                   The value to insert
	 * @return       Success of the operation
	 */
	public abstract boolean insertTail(long index, E value);

	/**
	 * Tests if the list is empty
	 * @return A boolean indicating if it is empty
	 */
	public boolean isEmpty(){
		return this.size==0;
	}

	/**
	 * Prints the LinkedList to the console
	 */
	public void print(){
		System.out.println(this);
	}

	/**
	 * Removes the head of the LinkedList
	 *
	 * @return The removed value
	 */
	public abstract E removeHead();

	/**
	 * Removes the value at the head based index of the LinkedList
	 *
	 * @param  index
	 *                   The index to remove
	 * @return       The removed value
	 */
	public abstract E removeHead(long index);

	/**
	 * Removes the tail of the LinkedList
	 *
	 * @return The removed value
	 */
	public abstract E removeTail();

	/**
	 * Removes the value at the tail based index of the LinkedList
	 *
	 * @param  index
	 *                   The index to remove
	 * @return       The removed value
	 */
	public abstract E removeTail(long index);

	/**
	 * Converts the LinkedList into a list of items in a string
	 */
	@Override
	public abstract String toString();
}
