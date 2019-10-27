package linkedList;

import org.eclipse.jdt.annotation.NonNull;
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
	 * Swaps the two nodes
	 *
	 * @param node1
	 *                  The first node to swap
	 * @param node2
	 *                  The second node
	 */
	public static <@Nullable E>void swap(@NonNull
		final Node<E> node1, @NonNull
		final Node<E> node2){
		final Node<E> next=node1.next;
		final Node<E> prev=node1.previous;
		node1.setBi(node2.previous, node2.next);
		node2.setBi(prev, next);
	}
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
		this.value=value;
		this.previous=null;
		this.next=null;
	}


	/**
	 * Constructs a node with no previous value
	 *
	 * @param value
	 *                  The value to add
	 * @param node
	 *                  The next Node
	 */
	public Node(final E value, final Node<E> node){
		this.value=value;
		this.next=node;
		this.previous=null;
		if(node!=null) node.previous=this;
	}


	/**
	 * Constructs a node with no next value
	 *
	 * @param value
	 *                  The value to add
	 * @param node
	 *                  The previous Node
	 */
	public Node(final Node<E> node, final E value){
		this.value=value;
		this.previous=node;
		this.next=null;
		if(node!=null) node.next=this;
	}

	/**
	 * Constructs a node
	 *
	 * @param value
	 *                  The value to add
	 * @param prev
	 *                  The previous Node
	 * @param next
	 *                  The next Node
	 */
	public Node(final Node<E> prev, final E value, final Node<E> next){
		this.value=value;
		this.next=next;
		this.previous=prev;
		if(next!=null) next.previous=this;
		if(prev!=null) prev.next=this;
	}

	/**
	 * Removes the node and attaches previous and next elements together
	 *
	 * @return The removed value
	 */
	public E delete(){
		if(this.previous!=null)this.previous.next=this.next;
		if(this.next!=null)this.next.previous=this.previous;
		return this.value;
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
	 * @param preveious the previous to set
	 * @param next the next to set
	 */
	public void set(final Node<E> preveious, final Node<E> next) {
		this.previous=preveious;
		this.next=next;
	}

	/**
	 * @param previous
	 *                      the previous to set
	 * @param next
	 *                      the next to set
	 */
	public void setBi(final Node<E> previous, final Node<E> next){
		this.setBiNext(next);
		this.setBiPrevious(previous);
	}


	/**
	 * @param next
	 *                      the next to set
	 */
	public void setBiNext(final Node<E> next){
		this.next=next;
		if(next!=null)this.next.previous=this;
	}

	/**
	 * @param previous
	 *                     the previous to set
	 */
	public void setBiPrevious(final Node<E> previous){
		this.previous=previous;
		if(previous!=null) this.previous.next=this;
	}

	/**
	 * @param next
	 *                 the next to set
	 */
	public void setNext(final Node<E> next){
		this.next=next;
	}

	/**
	 * @param previous
	 *                      the previous to set
	 */
	public void setPrevious(final Node<E> previous){
		this.previous=previous;
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
	@SuppressWarnings("null")
	@Override
	public String toString(){
		if(this.value==null) return "null";
		return this.value.toString();
	}
}
