package problem2;

import problem1.ArrayDeque;

/**
 * Class QueueD<br>
 * Implements the Queue Based on the {@link ArrayDeque}
 *
 * @author     Shawn Graven
 * @date       10/14/19
 *
 * @param  <E>
 *                 The type of the elements
 */
public class QueueD <E>{
	ArrayDeque<E> deque;


	/**
	 * Creates a new QueueD based on {@link ArrayDeque}
	 *
	 * @param capcaity
	 *                     The maximum amount of values the Queue can hold
	 */
	public QueueD(final int capcaity){
		this.deque=new ArrayDeque<>(capcaity);
	}

	/**
	 * Creates a new QueueD based on {@link ArrayDeque}
	 *
	 * @param capcaity
	 *                      The maximum amount of values the Queue can hold
	 * @param autoFlush
	 *                      Automatically set used values to null for garbage collection<br>
	 *                      Recommended for large objects
	 */
	public QueueD(final int capcaity, final boolean autoFlush){
		this.deque=new ArrayDeque<>(capcaity, autoFlush);
	}

	/**
	 * Is the Queue empty?
	 * @return A boolean indicating if the QueueD is empty
	 * @see    problem1.ArrayDeque#isEmpty()
	 */
	public boolean isEmpty(){
		return this.deque.isEmpty();
	}

	/**
	 * Is the Queue full?
	 * @return A boolean indicating if the QueueD is full (ie no values can be inserted)
	 * @see    problem1.ArrayDeque#isFull()
	 */
	public boolean isFull(){
		return this.deque.isFull();
	}

	/**
	 * Returns the next value without removing it
	 * @return The next value to be removed
	 * @see    problem1.ArrayDeque#peekRight()
	 */
	public E peek(){
		return this.deque.peekRight();
	}

	/**
	 * Removes the next element and returns it
	 * @return The removed value
	 * @see    problem1.ArrayDeque#deleteLeft()
	 */
	public E pop(){
		return this.deque.deleteLeft();
	}

	/**
	 * Prints the Queue as it interpreted
	 *
	 * @see problem1.ArrayDeque#print()
	 */
	public void print(){
		this.deque.print();
	}

	/**
	 * Prints the array holding the data raw
	 */
	public void printRaw(){
		this.deque.printRaw();

	}

	/**
	 * Adds the given values
	 * @param  values The values to insert, first one is first in
	 * @return The amount of elements inserted
	 * @see           problem1.ArrayDeque#insertRight(java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	public int push(final E... values){
		return this.deque.insertRight(values);
	}

	/**
	 * @param  value
	 *                   The value to add
	 * @return       Success of the insertion
	 * @see          problem1.ArrayDeque#insertRight(java.lang.Object)
	 */
	public boolean push(final E value){
		return this.deque.insertRight(value);
	}

	/**
	 * @return The size of the QueueD
	 * @see problem1.ArrayDeque#size()
	 */
	public int size(){
		return this.deque.size();
	}

	/**
	 * @return The string representation of the Queue
	 * @see    problem1.ArrayDeque#toString()
	 */
	@Override
	public String toString(){
		return this.deque.toString();
	}
}
