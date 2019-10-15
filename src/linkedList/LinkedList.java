package linkedList;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class LinkedList <E>{
	private Node<E> left=null;
	private Node<E> right=null;


	public LinkedList(){
		//Do nothing
	}

	/**
	 * Loops through all elements
	 * @param consumer The method to execute on each value
	 */
	public void forEachLeft(final Consumer<E> consumer){
		Node<E> node=this.left;
		while(node!=null){
			consumer.accept(node.getValue());
			node=node.getNext();
		}
	}

	/**
	 * Loops through all elements and replace the value
	 * @param op The method to execute on each value
	 */
	public void forEachLeft(final UnaryOperator<E> op){
		Node<E> node=this.left;
		while(node!=null){
			node.setValue(op.apply(node.getValue()));
			node=node.getNext();
		}
	}


	/**
	 * Loops through all elements
	 * @param consumer The method to execute on each value
	 */
	public void forEachRight(final Consumer<E> consumer){
		Node<E> node=this.right;
		while(node!=null){
			consumer.accept(node.getValue());
			node=node.getPrevious();
		}
	}

	/**
	 * Loops through all elements and replace the value
	 * @param op The method to execute on each value
	 */
	public void forEachRight(final UnaryOperator<E> op){
		Node<E> node=this.right;
		while(node!=null){
			node.setValue(op.apply(node.getValue()));
			node=node.getPrevious();
		}
	}

	private void insert(final E value){
		this.left=new Node<>(value);
		this.right=this.left;
	}

	/**
	 * Inserts the value at the beginning
	 *
	 * @param value
	 *                  The value to insert
	 */
	public void insertLeft(final E value){
		if(this.left==null){
			this.insert(value);
			return;
		}
		this.left=new Node<>(this.left, value);
	}

	/**
	 * Inserts the value at the end
	 *
	 * @param value
	 *                  The value to insert
	 */
	public void insertRight(final E value){
		if(this.left==null){
			this.insert(value);
			return;
		}
		this.right=new Node<>(value, this.right);
	}


	/**
	 * Removes the first element
	 *
	 * @return The removed element
	 */
	public E removeLeft(){
		final Node<E> value=this.left;
		this.left=this.left.getNext();
		this.left.setPrevious(null);
		value.setNext(null);
		return value.getValue();
	}


	/**
	 * Removes the first element
	 *
	 * @return The removed element
	 */
	public E removeRight(){
		final Node<E> value=this.right;
		this.right=this.right.getPrevious();
		this.right.setNext(null);
		value.setPrevious(null);
		return value.getValue();
	}


	/**
	 * Returns the string representation of the LinkedList
	 */
	@Override
	public String toString(){
		if(this.left==null) return "LinkedList[]";
		Node<E> node=this.left;
		final StringBuilder builder=new StringBuilder();
		builder.append("LinkedList[");
		while(node.getNext()!=null){
			builder.append(node).append(", ");
			node=node.getNext();
		}
		builder.append(node);
		builder.append("]");
		return builder.toString();
	}
}
