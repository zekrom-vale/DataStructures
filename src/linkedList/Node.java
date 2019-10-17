package linkedList;

import org.eclipse.jdt.annotation.Nullable;

/**
 * Defines a linked list node with forward and backwards reference
 *
 * @author     Zekrom
 *
 * @param  <E>
 *                 The type of the linked list node
 */
@SuppressWarnings("hiding")
public class Node <@Nullable
E>{
	/**
	 * The next Node
	 */
	private Node<E> next;
	/**
	 * The previous Node
	 */
	private Node<E> previous;
	/**
	 * The value of the Node
	 */
	private E value;


	/**
	 * Constructs a node with no previous or next value
	 *
	 * @param value
	 *                  The value to add
	 */
	public Node(final E value){
		this(value, null);
	}

	/**
	 * Constructs a node with no next value
	 *
	 * @param value
	 *                  The value to add
	 * @param node
	 *                  The previous Node
	 */
	public Node(final E value, final Node<E> node){
		this.value=value;
		this.previous=node;
		this.next=null;
		if(node!=null) node.next=this;
	}


	/**
	 * Constructs a node with no previous value
	 *
	 * @param value
	 *                  The value to add
	 * @param node
	 *                  The previous Node
	 */
	public Node(final Node<E> node, final E value){
		this.value=value;
		this.next=node;
		this.previous=null;
		if(node!=null) node.previous=this;
	}

	public Node(final Node<E> prev, final E value, final Node<E> next){
		this.value=value;
		this.next=next;
		this.previous=prev;
		if(next!=null) next.previous=this;
		if(prev!=null) prev.next=this;
	}

	/**
	 * @return the next
	 */
	public Node<E> getNext(){
		return this.next;
	}

	/**
	 * @return the previous
	 */
	public Node<E> getPrevious(){
		return this.previous;
	}

	/**
	 * @return the value
	 */
	public E getValue(){
		return this.value;
	}

	/**
	 * @param next
	 *                 the next to set
	 */
	public void setNext(final Node<E> next){
		this.next=next;
	}

	/**
	 * @param preveious
	 *                      the previous to set
	 */
	public void setPrevious(final Node<E> preveious){
		this.previous=preveious;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(final E value){
		this.value=value;
	}
	/**
	 * @return A string representation of the value
	 */
	@Override
	public String toString(){
		if(this.value==null) return "null";
		return this.value.toString();
	}
}
