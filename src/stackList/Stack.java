package stackList;

import org.eclipse.jdt.annotation.Nullable;

import linkedList.CircularLinkedList;

/**
 * Class Stack implements a stack based on the {@link CircularLinkedList} class
 *
 * @author     Shawn Graven
 * @date       10/28/19
 *
 * @param  <E>
 *                 The type of the stack
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
	 * Creates a new stack
	 *
	 * @param values
	 *                   The values to insert
	 */
	@SafeVarargs
	public Stack(final E... values){
		this.list.insertShiftHead(values);
	}

	/**
	 * @return {@code true} if the stack is empty
	 * @see linkedList.CircularLinkedList#isEmpty()
	 */
	public boolean isEmpty(){
		return this.list.isEmpty();
	}

	/**
	 * Returns the next element with out removing it
	 *
	 * @return The next element
	 */
	public E peek(){
		//The element to remove is at the root
		return this.list.getRoot();
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
	 * Prints the Stack
	 */
	public void print(){
		System.out.println(this);
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

	/**
	 * Returns a string representation of the Stack
	 */
	@Override
	public String toString(){
		if(this.list.isEmpty()) return "Stack[]";

		final StringBuilder builder=new StringBuilder("Stack[");
		this.list.forEachNext((x, i)->{
			builder.append(x);
			if(i!=this.list.getSize()-1) builder.append(", ");

		});
		builder.append(']');
		return builder.toString();
	}
}
