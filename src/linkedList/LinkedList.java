package linkedList;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


public class LinkedList <@Nullable
E>{
	@Nullable
	private Node<E> left=null;
	@Nullable
	private Node<E> right=null;


	public LinkedList(){
		//Do nothing
	}

	public E deleteLeft(final int index){
		if(index==0) return this.removeLeft();

		Node<E> prev=this.left;
		int i=0;
		while(prev!=null&&i<index-1){
			prev=prev.getNext();
			i++;
		}
		if(prev==null) return null;

		final Node<E> node=prev.getNext(), next=node.getNext();
		prev.setNext(next);
		if(next!=null) return this.removeRight();
		return node.getValue();
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

	public E getLeft(final int index){

		Node<E> node=this.left;
		int i=0;
		while(node!=null&&i<index){
			node=node.getNext();
			i++;
		}
		if(node==null) return null;
		return node.getValue();
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

	@SuppressWarnings("unused")
	public boolean insertLeftAfter(final int index, final E value){

		if(index==-1){
			this.insertLeft(value);
			return true;
		}

		Node<E> prev=this.left;
		int i=0;
		while(prev!=null&&i<index){
			prev=prev.getNext();
			i++;
		}
		if(prev==null) return false;
		final Node<E> next=prev.getNext();
		if(next==null){
			this.right=new Node<>(prev, value);
			return true;
		}
		new Node<>(prev, value, next);
		return true;
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
	@SuppressWarnings("null")
	public E removeLeft(){
		if(this.left==null) return null;
		final E value=this.left.getValue();
		this.left=this.left.getNext();
		if(this.left==null){
			this.right=null;
			return value;
		}
		this.left.setPrevious(null);
		return value;
	}


	/**
	 * Removes the first element
	 *
	 * @return The removed element
	 */
	@SuppressWarnings("null")
	public E removeRight(){
		if(this.right==null) return null;
		final E value=this.right.getValue();
		this.right=this.right.getPrevious();
		if(this.right==null){
			this.right=null;
			return value;
		}
		this.right.setNext(null);
		return value;
	}

	public E searchLeft(final @NonNull
		E value){

		Node<E> node=this.left;
		while(node!=null){
			if(value.equals(node.getValue()));
			node=node.getNext();
		}
		return null;
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
