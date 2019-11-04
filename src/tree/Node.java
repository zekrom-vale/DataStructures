package tree;

import org.eclipse.jdt.annotation.NonNull;

@SuppressWarnings("hiding")
public class Node <@NonNull
E extends Comparable<E>>{
	Node<E> left;
	Node<E> right;

	E value;


	public Node(final E value){
		this(null, value, null);
	}

	public Node(final E value, final Node<E> right){
		this(null, value, right);
	}

	public Node(final Node<E> left, final E value){
		this(left, value, null);
	}

	public Node(final Node<E> left, final E value, final Node<E> right){
		this.right=right;
		this.value=value;
		this.left=left;
	}

	/**
	 * @return the left
	 */
	public Node<E> getLeft(){
		return this.left;
	}
	/**
	 * @return the right
	 */
	public Node<E> getRight(){
		return this.right;
	}


	/**
	 * @return the value
	 */
	public E getValue(){
		return this.value;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(final Node<E> left){
		this.left=left;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(final Node<E> right){
		this.right=right;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(final E value){
		this.value=value;
	}
}
