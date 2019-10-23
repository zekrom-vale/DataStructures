package linkedList;

import java.util.function.ObjLongConsumer;

// Allows Eclipse to perform null checks, this is ignored by the JVM
// Same with @Override and some other Annotations
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


/**
 * CircularLinkedList Class<br>
 * Defines a circular double linked list
 *
 * @author     Shawn Graven (Zekrom)
 *
 * @param  <E>
 *                 The type of the Linked list
 * @see        Node
 */
public class CircularLinkedList <@Nullable
E>{


	/**
	 * Main
	 *
	 * @param  args
	 *                                         Arguments
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	public static void main(final String[] args)
		throws LengthRootMishatchException{
		final CircularLinkedList<@Nullable
		Integer> list=new CircularLinkedList<>();
		list.insertNext(null, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		list.loopUntilNext((x, i)->{
			System.out.println(x.getPrevious()+", "+x+", "+x.getNext());
		}, 40);
		System.out.println(list);
		list.removeRootNext();
		System.out.println(list);
	}


	/*
	 * The root (or current) node of the CircularLinkedList, allowed to be null only if this.size==0
	 */
	@Nullable
	private Node<E> root=null;

	/*
	 * The current size of the LinkedList
	 */

	private long size=0;


	/**
	 * Returns a new CircularLinkedList
	 */
	public CircularLinkedList(){
		//Do nothing
	}


	/**
	 * Iterates for every element in the linked list in the order they are provided, going to the Next
	 * elements
	 *
	 * @param consumer
	 *                     The function to do for each element, no change is made to the value
	 */
	@SuppressWarnings("null")
	public void forEachNext(final ObjLongConsumer<Node<E>> consumer){
		Node<E> node=this.root;
		for(long i=0; i<this.size; i++){
			consumer.accept(node, i);
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
	public void forEachPrevious(final ObjLongConsumer<Node<E>> consumer){
		Node<E> node=this.root;
		for(long i=0; i<this.size; i++){
			consumer.accept(node, i);
			node=node.getPrevious();
		}
	}


	/**
	 * Returns the node of the index from the next elements, 0=root
	 *
	 * @param  index
	 *                   The index to get the node
	 * @return       The node of the index
	 */
	@SuppressWarnings("null")
	public @NonNull
	Node<E> getNodeNext(long index){
		//Throw an null pointer LengthRootMishatchException if the root is null
		//TODO extract method
		if(
			this.root==null
		) throw new NullPointerException(
				"getNodeLeft Encountered a null root"
				);
		index=index%this.size;	//Provide wrap around support
		//If the index is greater than half of the size call from the other side max computational complexity n->n/2
		if(index>this.size/2) return this.getNodePrevious(this.size-index-1);
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
	 * Returns the node of the index from the previous elements, 0=root
	 *
	 * @param  index
	 *                   The index to get the node
	 * @return       The node of the index
	 */
	@SuppressWarnings("null")
	public @NonNull
	Node<E> getNodePrevious(long index){
		//Throw an null pointer LengthRootMishatchException if the root is null
		//TODO extract method
		if(
			this.root==null
			) throw new NullPointerException(
				"getNodeRight Encountered a null root"
				);

		index=index%this.size;	//Provide wrap around support
		//If the index is greater than half of the size call from the other side max computational complexity n->n/2
		if(index>this.size/2) return this.getNodeNext(this.size-index-1);
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
	 * Inserts the value if there is only one value and <b>does not</b> shifts the root
	 *
	 * @param value
	 *                  The value to insert
	 */
	@SuppressWarnings("unused")
	protected void insert(final E value){
		new Node<>(this.root, value, this.root);
		this.size++;
	}

	/**
	 * Checks to see if the LinkedList is empty or has one element<br>
	 * Does <b>not shift</b> the root
	 *
	 * @param  value
	 *                                         The value to insert
	 * @return                             {@code true} if the value was inserted
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	protected boolean insertCheck(final E value)
		throws LengthRootMishatchException{
		if(this.insertIfEmpty(value)) return true;
		if(this.size==1){
			this.insert(value);
			return true;
		}
		return false;
	}

	/**
	 * Checks to see if the LinkedList is empty or has one element<br>
	 * <b>Shifts</b> the root
	 *
	 * @param  value
	 *                                         The value to insert
	 * @return                             {@code true} if the value was inserted
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	protected boolean insertCheckShift(final E value)
		throws LengthRootMishatchException{
		if(this.insertIfEmpty(value)) return true;
		if(this.size==1){
			this.insertShift(value);
			return true;
		}
		return false;
	}

	/**
	 * Inserts the value if the LinkedList is empty
	 *
	 * @param  value
	 *                                         The value to insert
	 * @return                             {@code true} if the value was inserted
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	@SuppressWarnings("null")
	protected boolean insertIfEmpty(final E value)
		throws LengthRootMishatchException{
		if(this.isEmpty()){
			this.root=new Node<>(value);
			this.root.setNext(this.root);
			this.root.setPrevious(this.root);
			this.size++;
			return true;
		}
		return false;
	}

	/**
	 * Inserts the value after the root
	 *
	 * @param  value
	 *                                         The value to insert
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	@SuppressWarnings({"unused", "null"})
	public void insertNext(final E value) throws LengthRootMishatchException{
		if(this.insertCheck(value)) return;
		new Node<>(this.root, value, this.root.getNext());
		this.size++;
	}

	/**
	 * Inserts the values at the root and the existing node is <b>not sifted</b> to the next
	 *
	 * @param  values
	 *                                         The values to insert
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	@SuppressWarnings("unchecked")
	public void insertNext(final E... values)
		throws LengthRootMishatchException{
		for(int i=0; i<values.length; i++){
			this.insertNext(values[i]);
		}
	}

	/**
	 * Inserts the value after the next based index
	 *
	 * @param  index
	 *                                         The index to insert the value (Inserts after)
	 * @param  value
	 *                                         The value to insert
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	@SuppressWarnings("unused")
	public void insertNext(final int index, final E value)
		throws LengthRootMishatchException{
		if(this.insertCheck(value)) return;
		@NonNull
		final Node<E> prev=this.getNodeNext(index);
		new Node<>(prev, value, prev.getNext());
		this.size++;
	}

	/**
	 * Inserts the value after the root
	 *
	 * @param  value
	 *                                         The value to insert
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	@SuppressWarnings({"unused", "null"})
	public void insertPrevious(final E value)
		throws LengthRootMishatchException{
		if(this.insertCheck(value)) return;
		new Node<>(this.root.getPrevious(), value, this.root);
		this.size++;
	}

	/***
	 * Inserts the value after the previous based index
	 *
	 * @param  index
	 *                                         The index to insert the value (Inserts after)
	 * @param  value
	 *                                         The value to insert
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	@SuppressWarnings("unused")
	public void insertPrevious(final int index, final E value)
		throws LengthRootMishatchException{
		if(this.insertCheck(value)) return;
		@NonNull
		final Node<E> next=this.getNodePrevious(index);
		new Node<>(next.getPrevious(), value, next);
		this.size++;
	}


	/**
	 * Inserts the value if there is only one value and <b>shifts</b> the root
	 *
	 * @param value
	 *                  The value to insert
	 */
	protected void insertShift(final E value){
		this.root=new Node<>(this.root, value, this.root);
		this.size++;
	}

	/**
	 * Inserts the value at the root and the existing node is sifted to the next
	 *
	 * @param  value
	 *                                         The value to insert
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	@SuppressWarnings("null")
	public void insertShiftNext(final E value)
		throws LengthRootMishatchException{
		if(this.insertCheckShift(value)) return;
		this.root=new Node<>(this.root.getPrevious(), value, this.root);
		this.size++;
	}


	/**
	 * Inserts the values at the root and the existing node is sifted to the next
	 *
	 * @param  values
	 *                                         The values to insert
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	@SuppressWarnings("unchecked")
	public void insertShiftNext(final E... values)
		throws LengthRootMishatchException{
		for(int i=0; i<values.length; i++){
			this.insertShiftNext(values[i]);
		}
	}


	/**
	 * Inserts the values at the root and the existing node is sifted to the previous
	 *
	 * @param  values
	 *                                         The values to insert
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	@SuppressWarnings("unchecked")
	public void insertShiftPrevious(final E... values)
		throws LengthRootMishatchException{
		for(final E value : values){
			this.insertShiftPrevious(value);
		}
	}

	/**
	 * Inserts the value at the root and the existing node is sifted to the previous
	 *
	 * @param  value
	 *                                         The value to insert
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	@SuppressWarnings("null")
	public void insertShiftPrevious(final E value)
		throws LengthRootMishatchException{
		if(this.insertCheckShift(value)) return;
		this.root=new Node<>(this.root, value, this.root.getNext());
		this.size++;
	}


	/**
	 * Tests if the linked list is empty
	 *
	 * @return                             The state of the array
	 * @throws LengthRootMishatchException
	 *                                         If the size and root node mismatch<br>
	 *                                         ie. {@code this.size==0 XOR this.root==null}
	 */
	public boolean isEmpty() throws LengthRootMishatchException{
		if(this.size==0&&this.root==null) return true;
		if(
			this.size==0||this.root==null
			) throw new LengthRootMishatchException();
		return false;
	}

	/**
	 * Loops until max-1
	 *
	 * @param  consumer
	 *                                         The function to do on each iteration
	 * @param  max
	 *                                         The amount of times to call the function
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	@SuppressWarnings("null")
	public void loopUntilNext(
		final ObjLongConsumer<Node<E>> consumer, final long max
		) throws LengthRootMishatchException{
		if(this.isEmpty()) return;
		@NonNull
		Node<E> node=this.root;
		for(long i=0; i<max; i++){
			consumer.accept(node, i);
			node=node.getNext();
		}
	}

	/**
	 * Removes the index from the left
	 *
	 * @param  index
	 *                   The index to remove
	 * @return       The removed value
	 */
	@SuppressWarnings("null")
	public E removeNext(final long index){
		if(this.root==null) return null;
		if(this.size==1){
			final Node<E> node=this.root;
			this.size=0;
			this.root=null;
			return node.getValue();
		}
		if(index==0) return this.removeRootNext();

		final Node<E> node=this.getNodeNext(index);
		node.delete();
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
	public E removePrevious(final long index){
		if(this.root==null) return null;
		if(this.size==1){
			final Node<E> node=this.root;
			this.size=0;
			this.root=null;
			return node.getValue();
		}
		if(index==0) return this.removeRootPrevious();

		final Node<E> node=this.getNodePrevious(index);
		node.delete();
		return node.getValue();
	}

	/**
	 * Removes the root element and shifts the root to the next
	 *
	 * @return The removed element
	 */
	@SuppressWarnings("null")
	public E removeRootNext(){
		if(this.root==null) return null;
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
	 * Removes the root element and shifts the root to the previous
	 *
	 * @return The removed element
	 */
	@SuppressWarnings("null")
	public E removeRootPrevious(){
		if(this.root==null) return null;
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
	 * Returns a string representation of the object
	 */
	@SuppressWarnings("null")
	@Override
	public String toString(){
		try{
			if(this.isEmpty()) return "CircularLinkedList[]";
		}
		catch(final LengthRootMishatchException e){
			e.printStackTrace();
		}

		final StringBuilder builder
		=new StringBuilder("CircularLinkedList[..., ");

		Node<E> node=this.root;
		for(int i=0; i<this.size; i++){
			builder.append(node).append(", ");
			node=node.getNext();
		}
		builder.append("...]");
		return builder.toString();
	}

}
