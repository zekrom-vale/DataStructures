package linkedList;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


/**
 * CircularLinkedList Class<br>
 * Defines a circular double linked list
 *
 * @author     Zekrom
 *
 * @param  <E>
 *                 The type of the Linked list
 */
public class CircularLinkedList <@Nullable
E>{


	public static void main(final String[] args) throws Exception{
		final CircularLinkedList<@Nullable Integer> list=new CircularLinkedList<>();
		list.insertNext(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		list.loopUntilNext((x, i)->{
			System.out.println(x.getPrevious()+", "+x+", "+x.getNext());
		}, 40);
	}
	@Nullable
	private Node<E> root=null;

	/*
	 * Not using Right
	 */

	private long size=0;

	/**
	 * Returns a new CircularLinkedList
	 */
	public CircularLinkedList(){
		//Do nothing
	}


	/**
	 * @param value
	 * @throws Exception
	 */
	@SuppressWarnings("null")
	protected boolean check(final E value) throws Exception{
		if(this.isEmpty()) {
			this.root=new Node<>(value);
			this.root.setNext(this.root);
			this.root.setPrevious(this.root);
			this.size++;
			return true;
		}
		if(this.size==1){
			this.insert(value);
			return true;
		}
		return false;
	}

	/**
	 * Removes the first element
	 *
	 * @return The removed element
	 */
	@SuppressWarnings("null")
	public E deleteLeft(){
		if(this.root==null)return null;
		@NonNull
		final Node<E> node=this.root;
		if(this.size==1){
			this.size=0;
			this.root=null;
			return node.getValue();
		}
		this.root=this.root.getNext();
		node.delete();
		this.size--;
		return node.getValue();
	}

	/**
	 * Removes the index from the left
	 *
	 * @param  index
	 *                   The index to remove
	 * @return       The removed value
	 */
	@SuppressWarnings("null")
	public E deleteLeft(final long index){
		if(this.root==null) return null;
		if(this.size==1){
			final Node<E> node=this.root;
			this.size=0;
			this.root=null;
			return node.getValue();
		}
		if(index==0) return this.deleteLeft();

		final Node<E> node=this.getNodeLeft(index);
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
		if(this.root==null)return null;
		@NonNull
		final Node<E> node=this.root;
		if(this.size==1){
			this.size=0;
			this.root=null;
			return node.getValue();
		}
		this.root=this.root.getPrevious();
		node.delete();
		this.size--;
		return node.getValue();
	}

	/**
	 * Removes the index from the right
	 *
	 * @param  index
	 *                   The index to remove
	 * @return       The removed value
	 */
	@SuppressWarnings("null")
	public E deleteRight(final long index){
		if(this.root==null) return null;
		if(this.size==1){
			final Node<E> node=this.root;
			this.size=0;
			this.root=null;
			return node.getValue();
		}
		if(index==0) return this.deleteRight();

		final Node<E> node=this.getNodeRight(index);
		node.delete();
		return node.getValue();
	}

	/**
	 * Iterates for every element in the linked list in the order they are provided, going to the Next
	 * elements
	 *
	 * @param consumer
	 *                     The function to do for each element, no change is made to the value
	 */
	@SuppressWarnings("null")
	public void forEachNext(final Consumer<E> consumer){
		Node<E> node=this.root;
		for(int i=0; i<this.size; i++){
			consumer.accept(node.getValue());
			node=node.getNext();
		}
	}

	/**
	 * Iterates for every element in the linked list in the order they are provided, going to the
	 * Previous elements
	 *
	 * @param consumer
	 *                     The function to do for each element, no change is made to the value
	 */
	@SuppressWarnings("null")
	public void forEachPrevious(final Consumer<E> consumer){
		Node<E> node=this.root;
		for(int i=0; i<this.size; i++){
			consumer.accept(node.getValue());
			node=node.getPrevious();
		}
	}

	/**
	 * Returns the node of the index from the left
	 *
	 * @param  index
	 *                   The index to get the node
	 * @return       The node of the index
	 */
	@SuppressWarnings("null")
	protected @NonNull
	Node<E> getNodeLeft(long index){
		if(
			this.root==null
			) throw new NullPointerException("getNodeLeft Encountered a null root");
		index=index%this.size;
		if(index>this.size/2) return this.getNodeRight(this.size-index-1);
		@NonNull
		Node<E> prev=this.root;
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
	protected @NonNull
	Node<E> getNodeRight(long index){
		if(
			this.root==null
			) throw new NullPointerException(
				"getNodeRight Encountered a null root"
				);

		index=index%this.size;
		if(index>this.size/2) return this.getNodeLeft(this.size-index-1);
		@NonNull
		Node<E> next=this.root;
		int i=0;
		while(i<index){
			next=next.getPrevious();
			i++;
		}
		return next;
	}

	/**
	 * Inserts the value if there is only one value
	 *
	 * @param value
	 *                  The value to insert
	 */
	protected void insert(final E value){
		this.root=new Node<>(this.root, value, this.root);
		this.size++;
	}


	/**
	 * Inserts the value at the root and the existing node is sifted to the next
	 *
	 * @param value
	 *                  The value to insert
	 * @throws Exception
	 */
	@SuppressWarnings("null")
	public void insertNext(final E value) throws Exception{
		if(this.check(value))return;
		this.root=new Node<>(this.root, value, this.root.getNext());
		this.size++;
	}

	/**
	 * Inserts the values at the root and the existing node is sifted to the next
	 *
	 * @param  values
	 *                       The values to insert
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void insertNext(final E... values) throws Exception{
		for(final E value : values){
			this.insertNext(value);
		}
	}


	/**
	 * Inserts the value after the next based index
	 *
	 * @param  index
	 *                       The index to insert the value (Inserts after)
	 * @param  value
	 *                       The value to insert
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public void insertNext(final int index, final E value) throws Exception{
		if(this.check(value)) return;
		@NonNull
		final Node<E> prev=this.getNodeLeft(index);
		new Node<>(prev, value, prev.getNext());
		this.size++;
	}

	/**
	 * Inserts the values at the root and the existing node is sifted to the previous
	 *
	 * @param  values
	 *                       The values to insert
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void insertPrevious(final E... values) throws Exception{
		for(final E value : values){
			this.insertPrevious(value);
		}
	}

	/**
	 * Inserts the value at the root and the existing node is sifted to the previous
	 *
	 * @param  value
	 *                       The value to insert
	 * @throws Exception
	 */
	@SuppressWarnings("null")
	public void insertPrevious(final E value) throws Exception{
		if(this.check(value)) return;
		this.root=new Node<>(this.root.getPrevious(), value, this.root);
		this.size++;
	}

	/***
	 * Inserts the value after the previous based index
	 *
	 * @param  index
	 *                       The index to insert the value (Inserts after)
	 * @param  value
	 *                       The value to insert
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public void insertPrevious(final int index, final E value) throws Exception{
		if(this.check(value)) return;
		@NonNull
		final Node<E> next=this.getNodeRight(index);
		new Node<>(next.getPrevious(), value, next);
		this.size++;
	}

	/**
	 * Tests if the linked list is empty
	 *
	 * @return           The state of the array
	 * @throws Exception
	 */
	public boolean isEmpty() throws Exception{
		if(this.size==0&&this.root==null) return true;
		if(this.size==0||this.root==null) throw new Exception();
		return false;
	}

	/**
	 * Loops until max-1
	 *
	 * @param  consumer
	 *                       The function to do on each iteration
	 * @param  max
	 *                       The amount of times to call the function
	 * @throws Exception
	 */
	@SuppressWarnings("null")
	public void loopUntilNext(
		final BiConsumer<Node<E>, Long> consumer, final long max
		) throws Exception{
		if(this.isEmpty()) return;
		@NonNull
		Node<E> node=this.root;
		for(long i=0; i<max; i++){
			consumer.accept(node, i);
			node=node.getNext();
		}
	}

	/**
	 * Returns a string representation of the object
	 */
	@SuppressWarnings("null")
	@Override
	public String toString(){
		try{
			if(this.isEmpty()) return "CircularLinkedList[]";
		}
		catch(final Exception e){
			e.printStackTrace();
		}

		final StringBuilder builder=new StringBuilder();

		Node<E> node=this.root;
		for(int i=0; i<this.size; i++){
			builder.append(node).append(", ");
			node=node.getNext();
		}
		builder.append("...]");
		return builder.toString();
	}

}
