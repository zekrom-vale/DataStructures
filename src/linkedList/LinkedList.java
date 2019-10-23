package linkedList;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


/**
 * LinkedList Class<br>
 * Defines a double linked list
 *
 * @author     Zekrom
 *
 * @param  <E>
 *                 The type of the Linked list
 */
public class LinkedList <@Nullable
E>extends LinkedCore{
	/**
	 * Main method
	 *
	 * @param args
	 *                 Arguments
	 */
	public static void main(final String[] args){
		final LinkedList<@Nullable
		Integer> list=new LinkedList<>();
		list.insertLeft(3);
		System.out.println(list);
		list.insertLeft(5);
		System.out.println(list);
		list.insertLeft(0, 7);
		System.out.println(list);
		list.removeLeft();
		System.out.println(list);
	}
	@Nullable
	private Node<E> left=null;
	@Nullable
	private Node<E> right=null;

	private long size=0;



	/**
	 * Returns a new linked list
	 */
	public LinkedList(){
		//Do nothing
	}


	/**
	 * Removes the first element
	 *
	 * @return The removed element
	 */
	public E deleteLeft(){
		if(this.left==null) return null;
		@Nullable
		final
		Node<E> node=this.left;
		this.left=node.getNext();
		final E value=node.delete();
		if(this.left==null){
			this.right=null;
			this.size=0;
			return value;
		}
		this.size--;
		return value;
	}

	/**
	 * Removes the index from the left
	 *
	 * @param  index
	 *                   The index to remove
	 * @return       The removed value
	 */
	public E deleteLeft(final long index){
		if(index==0) return this.deleteLeft();
		if(index==this.size-1) this.deleteRight();

		final Node<E> node=this.getNodeLeft(index);
		if(node==null)return null;
		node.delete();
		return node.getValue();
	}

	/**
	 * Removes the first element
	 *
	 * @return The removed element
	 */
	@SuppressWarnings("null")
	public E deleteRight(){

		if(this.right==null) return null;
		@Nullable
		final
		Node<E> node=this.right;
		this.right=node.getPrevious();
		final E value=node.delete();
		if(this.right==null){
			this.left=null;
			this.size=0;
			return value;
		}
		this.size--;
		return value;
	}

	/**
	 * Removes the index from the right
	 *
	 * @param  index
	 *                   The index to remove
	 * @return       The removed value
	 */
	public E deleteRight(final long index){
		if(index==0) return this.deleteRight();
		if(index==this.size-1) this.deleteLeft();

		final Node<E> node=this.getNodeRight(index);
		if(node==null)return null;
		node.delete();
		return node.getValue();
	}

	/**
	 * Loops through all elements
	 * @param consumer The method to execute on each value
	 */
	public void forEachLeft(final Consumer<Node<E>> consumer){
		Node<E> node=this.left;
		while(node!=null){
			consumer.accept(node);
			node=node.getNext();
		}
	}


	/**
	 * Loops through all elements and replace the value
	 * @param op The method to execute on each value
	 */
	public void forEachLeft(final UnaryOperator<Node<E>> op){
		Node<E> node=this.left;
		while(node!=null){
			node.setValue(op.apply(node).getValue());
			node=node.getNext();
		}
	}


	/**
	 * Loops through all elements
	 * @param consumer The method to execute on each value
	 */
	public void forEachRight(final Consumer<Node<E>> consumer){
		Node<E> node=this.right;
		while(node!=null){
			consumer.accept(node);
			node=node.getPrevious();
		}
	}

	/**
	 * Loops through all elements and replace the value
	 * @param op The method to execute on each value
	 */
	public void forEachRight(final UnaryOperator<Node<E>> op){
		Node<E> node=this.right;
		while(node!=null){
			node.setValue(op.apply(node).getValue());
			node=node.getPrevious();
		}
	}

	/**
	 * Returns the value at the given index
	 *
	 * @param  index
	 *                   The index to get
	 * @return       The value at the index
	 */
	public E getLeft(final int index){
		return this.getNodeLeft(index).getValue();
	}


	/**
	 * Returns the node of the index from the left
	 *
	 * @param  index
	 *                   The index to get the node
	 * @return       The node of the index
	 */

	@SuppressWarnings("null")
	public Node<E> getNodeLeft(final long index){
		if(index>=this.size) return null;
		if(index>this.size/2) return this.getNodeRight(this.size-index-1);
		@NonNull
		Node<E> prev=this.left;
		int i=0;
		while(i<index){
			prev=prev.getNext();
			i++;
		}
		return prev;
	}

	/**
	 * Returns the node of the index from the right
	 *
	 * @param  index
	 *                   The index to get the node
	 * @return       The node of the index
	 */

	@SuppressWarnings("null")
	public Node<E> getNodeRight(final long index){
		if(index>=this.size) return null;
		if(index>this.size/2) return this.getNodeLeft(this.size-index-1);
		@NonNull
		Node<E> next=this.right;
		int i=0;
		while(i<index){
			next=next.getPrevious();
			i++;
		}
		return next;
	}

	/**
	 * Returns the value at the given index
	 * @param index The index to get
	 * @return The value at the index
	 */
	public E getRight(final int index){
		return this.getNodeRight(index).getValue();
	}

	/**
	 * Inserts the value when size is zero
	 *
	 * @param value
	 *                  The value to insert
	 */
	protected void insert(final E value){
		this.left=new Node<>(value);
		this.right=this.left;
		this.size++;
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
		this.size++;
	}

	/**
	 * Inserts the value at the beginning
	 *
	 * @param values
	 *                   The values to insert
	 */
	@SuppressWarnings("unchecked")
	public void insertLeft(final E... values){
		for(final E value : values){
			this.insertLeft(value);
		}
	}

	/**
	 * Inserts the value after the left based index
	 *
	 * @param  index
	 *                   The index to insert the value (Inserts after)
	 * @param  value
	 *                   The value to insert
	 * @return       Success of insertion
	 */
	@SuppressWarnings("unused")
	public boolean insertLeft(final int index, final E value){

		if(index==-1){
			this.insertLeft(value);
			return true;
		}

		final Node<E> prev=this.getNodeLeft(index);
		if(prev==null) return false;
		final Node<E> next=prev.getNext();
		if(next==null){
			this.right=new Node<>(prev, value);
			this.size++;
			return true;
		}
		new Node<>(prev, value, next);	//Object not unused
		this.size++;
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
			this.size++;
			return;
		}
		this.right=new Node<>(value, this.right);
		this.size++;
	}

	/**
	 * Inserts the value after the right based index
	 * @param index The index to insert the value (Inserts after)
	 * @param value The value to insert
	 * @return Success of insertion
	 */
	@SuppressWarnings("unused")
	public boolean insertRight(final int index, final E value){

		if(index==-1){
			this.insertRight(value);
			return true;
		}

		final Node<E> next=this.getNodeRight(index);
		if(next==null) return false;
		final Node<E> prev=next.getPrevious();
		if(prev==null){
			this.right=new Node<>(value, next);
			this.size++;
			return true;
		}
		new Node<>(prev, value, next);
		this.size++;
		return true;
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
			this.size--;
			return value;
		}
		this.left.setPrevious(null);
		this.size--;
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
			this.size--;
			return value;
		}
		this.right.setNext(null);
		this.size--;
		return value;
	}

	/**
	 * Finds the value in the Linked List from the left
	 *
	 * @param  function
	 *                      The function to test the value
	 *
	 * @return          The value matching according to the function
	 */
	public E searchLeft(final Predicate<Node<E>> function){

		Node<E> node=this.left;
		while(node!=null){
			if(function.test(node)) return node.getValue();
			node=node.getNext();
		}
		return null;
	}


	/**
	 * @return the size
	 */
	public long size(){
		return this.size;
	}

	/**
	 * Returns the string representation of the LinkedList
	 */
	@SuppressWarnings("null")
	@Override
	public String toString(){
		if(this.size==0) return "LinkedList[]";
		@NonNull
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
