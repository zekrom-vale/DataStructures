/**
 *
 */
package problem1;

import linkedList.Node;

/**
 * @author Zekrom
 *
 */
public class Deque <E>{
	/**
	 * Always returns false at it will never be full (Unless out of memory)
	 * @return {@code false}
	 */
	public static boolean isFull(){
		return false;
	}
	private Node<E> leftNode=null;


	private Node<E> rightNode=null;

	public Deque(){
		//Start out empty
	}

	/**
	 * Inserts the value replacing all Nodes
	 * @param value The value to add to the right and left
	 */
	private void insert(final E value){
		this.rightNode=new Node<>(value);
		this.leftNode=this.rightNode;
	}

	/**
	 * Inserts a value to the end of the Deque (ie the last next)
	 *
	 * @param value
	 *                  The value to insert to the end
	 */
	public void insertLeft(final E value){
		if(this.leftNode==null){
			this.insert(value);
			return;
		}
		this.leftNode=new Node<>(this.leftNode, value);
	}

	/**
	 * Inserts a value to the start of the Deque (ie the last previous)
	 *
	 * @param value
	 *                  The value to insert to the end
	 */
	public void insertRight(final E value){
		if(this.rightNode==null){
			this.insert(value);
			return;
		}
		this.rightNode=new Node<>(this.rightNode, value);
	}


	/**
	 * @return A boolean indicating if it is empty
	 */
	public boolean isEmpty(){
		return this.leftNode==null||this.rightNode==null;
	}

	/**
	 * Removes the first element of the Deque (ie the last previous)
	 *
	 * @return The removed value
	 */
	public E removeLeft(){
		if(this.leftNode==null) return null;
		final E value=this.leftNode.getValue();
		this.leftNode=this.leftNode.getNext();
		this.rightNode.setPrevious(null);	//Cut ties to removed element
		//Removed Node will be doped and does not need to be nullified
		return value;
	}

	/**
	 * Removes the last element of the Deque (ie the last next)
	 *
	 * @return The removed value
	 */
	public E removeRight(){
		if(this.rightNode==null) return null;
		final E value=this.rightNode.getValue();
		this.rightNode=this.rightNode.getPrevious();
		this.rightNode.setNext(null);	//Cut ties to removed element
		//Removed Node will be doped and does not need to be nullified
		return value;
	}
}
