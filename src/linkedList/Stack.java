package linkedList;

import org.eclipse.jdt.annotation.Nullable;

/**
 * Class Stack implements a stack based on the {@link CircularLinkedList} class
 * 
 * @author     Shawn Graven
 * @date       10/28/19
 *
 * @param  <E>
 */
public class Stack<@Nullable E>{
	private final CircularLinkedList<E> list=new CircularLinkedList<>();


	/**
	 * Creates a new stack
	 */
	public Stack(){
		//Do nothing
	}

	/**
	 * Returns the next element with out removing it
	 *
	 * @return The next element
	 */
	public E peek(){
		return this.list.getHead(0);
	}

	/**
	 * Removes the next element
	 *
	 * @return The element removed
	 */
	public E pop(){
		return this.list.removeHead();
	}

	/**
	 * Inserts the value into the stack
	 *
	 * @param value
	 *                  the value to insert
	 */
	public void push(final E value){
		this.list.insertShiftHead(value);
	}
}
