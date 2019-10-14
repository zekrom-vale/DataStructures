package stack;

import linkedList.Node;

/**
 * Stack/LIFO/FILO Data Structure<br>
 * Defines the Stack Data Structure and implements it with a linked list node
 *
 * @author     Shawn Graven (Zekrom)
 * @date       10/3/19
 *
 * @param  <E>
 *                 The type of the stack
 * @see        Node
 */
@SuppressWarnings("hiding")
public class Stack <E>{
	/**
	 * Always {@code false} as it has no limit, due to implementing the linked list {@link Node}
	 *
	 * @return {@code false}
	 */
	public static boolean isFull(){
		return false;
	}


	/**
	 * The root node that keeps the data attached to the stack
	 */
	Node<E> node=null;


	/**
	 * Creates a new stack
	 */
	public Stack(){
		//No action needed, inited to null
	}
	/**
	 * @return If the stack is empty return {@code true} else {@code false}
	 */
	public boolean isEmpty(){
		return this.node==null;
	}

	/**
	 * Returns the top element without removing it
	 *
	 * @return The top most element
	 */
	public E peek(){
		if(this.node==null) return null;
		return this.node.getValue();
	}

	/**
	 * Removes the top element and returns it
	 *
	 * @return The removed element
	 */
	public E pop(){
		if(this.node==null) return null;
		final E value=this.node.getValue();
		this.node=this.node.getPrevious();
		if(this.node!=null) this.node.setNext(null);
		return value;
	}

	/**
	 * Adds the given value to the stack
	 *
	 * @param value
	 *                  The value to add
	 */
	public void push(final E value){
		this.node=new Node<>(value, this.node);
	}

	/**
	 * Adds the given values to the stack<br>
	 * Puts the first elements in first than the last ones, making the last one the top of the stack
	 *
	 * @param values
	 *                   The values to add
	 */
	@SuppressWarnings("unchecked")
	public void push(final E... values){
		for(int i=0; i<values.length; i++){
			this.push(values[i]);
		}
	}
	/**
	 * @return the contents of the Stack as a string
	 */
	@Override
	public String toString(){
		if(this.node==null)return "Stack []";
		Node<E> node=this.node;
		final StringBuilder builder=new StringBuilder();
		builder.append("Stack [");
		while(node.getNext()!=null){
			builder.append(node).append(" ,");
			node=node.getNext();
		}
		builder.append(node).append("]");
		return builder.toString();
	}
}
