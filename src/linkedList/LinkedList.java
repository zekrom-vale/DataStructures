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
E>extends LinkedCore<E>{
	/**
	 * Main method
	 *
	 * @param args
	 *                 Arguments
	 */
	public static void main(final String[] args){
		final LinkedList<@Nullable
		Integer> list=new LinkedList<>();
		list.insertHead(3);
		System.out.println(list);
		list.insertHead(5);
		System.out.println(list);
		list.insertHead(0, 7);
		System.out.println(list);
		list.removeHead();
		System.out.println(list);
	}
	@Nullable
	private Node<E> left=null;
	@Nullable
	private Node<E> right=null;

	/**
	 * Returns a new linked list
	 */
	public LinkedList(){
		//Do nothing
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
	public E getHead(final int index){
		return this.getNodeHead(index).getValue();
	}


	/**
	 * Returns the node of the index from the left
	 *
	 * @param  index
	 *                   The index to get the node
	 * @return       The node of the index
	 */

	@Override
	@SuppressWarnings("null")
	public Node<E> getNodeHead(final long index){
		if(index>=this.size) return null;
		if(index>this.size/2) return this.getNodeTail(this.size-index-1);
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

	@Override
	@SuppressWarnings("null")
	public Node<E> getNodeTail(final long index){
		if(index>=this.size) return null;
		if(index>this.size/2) return this.getNodeHead(this.size-index-1);
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
	public E getTail(final int index){
		return this.getNodeTail(index).getValue();
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
	@Override
	public void insertHead(final E value){
		if(this.left==null){
			this.insert(value);
			return;
		}
		this.left=new Node<>(value, this.left);
		this.size++;
	}

	/**
	 * Inserts the value at the beginning
	 *
	 * @param values
	 *                   The values to insert
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void insertHead(final E... values){
		for(final E value : values){
			this.insertHead(value);
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
	@Override
	@SuppressWarnings("unused")
	public boolean insertHead(final long index, final E value){

		if(index==-1){
			this.insertHead(value);
			return true;
		}

		final Node<E> prev=this.getNodeHead(index);
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
	@Override
	public void insertTail(@Nullable
		final E value){
		if(this.right==null){
			this.insert(value);
			return;
		}
		this.right=new Node<>(this.right, value);
		this.size++;
	}


	/**
	 * Inserts values at the end
	 *
	 * @param values
	 *                   The values to insert at the end
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void insertTail(@Nullable
		final E... values){
		for(final E value : values){
			this.insertTail(value);
		}
	}

	/**
	 * Inserts the value after the right based index
	 * @param index The index to insert the value (Inserts after)
	 * @param value The value to insert
	 * @return Success of insertion
	 */
	@Override
	@SuppressWarnings("unused")
	public boolean insertTail(final long index, final E value){

		if(index==-1){
			this.insertTail(value);
			return true;
		}

		final Node<E> next=this.getNodeTail(index);
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
	@Override
	@SuppressWarnings("null")
	public E removeHead(){

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
	@Override
	public E removeHead(final long index){
		if(index==0) return this.removeHead();
		if(index==this.size-1) this.removeTail();

		final Node<E> node=this.getNodeTail(index);
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
	@Override
	public E removeTail(){
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
	@Override
	public E removeTail(final long index){
		if(index==0) return this.removeTail();
		if(index==this.size-1) this.removeHead();

		final Node<E> node=this.getNodeHead(index);
		if(node==null)return null;
		node.delete();
		return node.getValue();
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
