package linkedList;

import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;

// Allows Eclipse to perform null checks, this is ignored by the JVM
// Same with @Override and some other Annotations
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;


/**
 * CircularLinkedList Class<br>
 * Defines a circular double linked list
 *
 * @author     Shawn Graven (Zekrom)
 * @date       10/29/19
 *
 * @param  <E>
 *                 The type of the Linked list
 * @see        Node
 * @see        LinkedCore
 *
 * @see        <br>
 * @see        #insertHead(Object)
 * @see        #insertShiftHead(Object)
 * @see        #insertTail(Object)
 * @see        #insertShiftTail(Object)
 *
 * @see        <br>
 * @see        #removeHead()
 * @see        #removeHead(long)
 * @see        #removeTail()
 * @see        #removeTail(long)
 *
 * @see        <br>
 * @see        #findHead(Predicate)
 * @see        #findTail(Predicate)
 * @see        #print()
 *
 * @see        <br>
 * @see        #shiftNext()
 * @see        #shiftPrevious()
 *
 * @see        <br>
 * @see        #getHead(long)
 * @see        #getNodeHead(long)
 * @see        #getTail(long)
 * @see        #getNodeTail(long)
 * @see        #getRoot()
 * @see        #getNodeRoot()
 *
 * @see        <br>
 * @see        #toString()
 * @see        #print()
 *
 */
@SuppressWarnings("javadoc")
public class CircularLinkedList <@Nullable
E>extends LinkedCore<E>{

	/*
	 * The root (or current) node of the CircularLinkedList, allowed to be null only if this.size==0
	 */
	@Nullable
	private Node<E> root=null;

	/**
	 * Returns a new CircularLinkedList
	 */
	public CircularLinkedList(){
		//Do nothing
	}


	/**
	 * Returns a new CircularLinkedList
	 *
	 * @param values
	 *                   The values to insert
	 */
	@SafeVarargs
	public CircularLinkedList(final E... values){
		this.insertTail(values);
	}


	/**
	 * Loops through the CircularArrayList until an element is found
	 * @param consumer The function to test the value
	 * @return The value or {@code null}
	 */
	@SuppressWarnings("null")
	public E findHead(final Predicate<E> consumer){

		if(this.isEmpty()) return null;
		@NonNull
		Node<E> node=this.root;
		for(long i=0; i<this.size; i++){
			if(consumer.test(node.getValue()))return node.getValue();
			node=node.getNext();
		}
		return null;
	}

	/**
	 * Loops through the CircularArrayList until an element is found in reverse
	 * @param consumer The function to test the value
	 * @return The value or {@code null}
	 */
	@SuppressWarnings("null")
	public E findTail(final Predicate<E> consumer){

		if(this.isEmpty()) return null;
		@NonNull
		Node<E> node=this.root;
		for(long i=0; i<this.size; i++){
			if(consumer.test(node.getValue()))return node.getValue();
			node=node.getPrevious();
		}
		return null;
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
	 * Iterates for every element in the linked list in the order they are provided, going to the Tail
	 * elements
	 *
	 * @param consumer
	 *                     The function to do for each element, no change is made to the value
	 */
	@SuppressWarnings("null")
	public void forEachTail(final ObjLongConsumer<Node<E>> consumer){
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
	@Override
	@SuppressWarnings("null")
	public @NonNull
	Node<E> getNodeHead(long index){
		this.nullPointer();
		index=index%this.size;	//Provide wrap around support
		//If the index is greater than half of the size call from the other side max computational complexity n->n/2
		if(index>this.size/2) return this.getNodeTail(this.size-index-1);
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
	 * Gets the root node
	 * @return The node of the root
	 */
	public Node<E> getNodeRoot(){
		return this.root;
	}

	/**
	 * Returns the node of the index from the Tail elements, 0=root
	 *
	 * @param  index
	 *                   The index to get the node
	 * @return       The node of the index
	 */
	@Override
	@SuppressWarnings("null")
	public @NonNull
	Node<E> getNodeTail(long index){
		this.nullPointer();

		index=index%this.size;	//Provide wrap around support
		//If the index is greater than half of the size call from the other side max computational complexity n->n/2
		if(index>this.size/2) return this.getNodeHead(this.size-index-1);
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
	 * Gets the root node value
	 * @return the value of the root node, {@code null} if there is no root
	 */
	@SuppressWarnings("null")
	public E getRoot(){
		if(this.isEmpty())return null;
		return this.root.getValue();
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
	 */
	protected boolean insertCheck(final E value){
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
	 */
	protected boolean insertCheckShift(final E value){
		if(this.insertIfEmpty(value)) return true;
		if(this.size==1){
			this.insertShift(value);
			return true;
		}
		return false;
	}


	/**
	 * Inserts the value after the root
	 *
	 * @param  value
	 *                                         The value to insert
	 */
	@SuppressWarnings({"unused", "null"})
	@Override
	public void insertHead(final E value){
		if(this.insertCheck(value)) return;
		new Node<>(this.root, value, this.root.getNext());
		this.size++;
	}

	/**
	 * Inserts the values at the root and the existing node is <b>not sifted</b> to the next<br>
	 * Same as the flowing code
	 *
	 * <pre>
	 * <code>
	 * CircularLinkedList&lt;E&gt; list=new CircularLinkedList<>();
	 * E values={...};
	 * for(int i=0; i&lt;values.length; i++){
	 * 	list.insertHead(values[i]);
	 * }
	 * </code>
	 * <code>
	 * CircularLinkedList&lt;E&gt; list=new CircularLinkedList<>();
	 * list.insertShiftHead({...});
	 * list.shiftPrevious();
	 * </code>
	 * </pre>
	 *
	 *
	 * @param values
	 *                   The values to insert
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void insertHead(final E... values){
		for(int i=0; i<values.length; i++){
			this.insertHead(values[i]);
		}
	}

	/**
	 * Inserts the value after the Head based index
	 *
	 * @param  index
	 *                   The index to insert the value (Inserts after)
	 * @param  value
	 *                   The value to insert
	 * @return       A boolean indicating success
	 */
	@Override
	@SuppressWarnings("unused")
	public boolean insertHead(final long index, final E value){
		if(this.insertCheck(value)) return false;
		@NonNull
		final Node<E> prev=this.getNodeHead(index);
		new Node<>(prev, value, prev.getNext());
		this.size++;
		return true;
	}

	/**
	 * Inserts the value if the LinkedList is empty
	 *
	 * @param  value
	 *                                         The value to insert
	 * @return                             {@code true} if the value was inserted
	 */
	@SuppressWarnings("null")
	protected boolean insertIfEmpty(final E value){
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
	 * Inserts the value at the root and the existing node is sifted to the Head
	 *
	 * @param  value
	 *                                         The value to insert
	 */
	@SuppressWarnings("null")
	public void insertShiftHead(final E value){
		if(this.insertCheckShift(value)) return;
		this.root=new Node<>(this.root.getPrevious(), value, this.root);
		this.size++;
	}


	/**
	 * Inserts the values at the root and the existing node is sifted to the Head<br>
	 * Same as the flowing code
	 *
	 * <pre>
	 * <code>
	 * CircularLinkedList&lt;E&gt; list=new CircularLinkedList<>();
	 * E values={...};
	 * for(int i=0; i&lt;values.length; i++){
	 * 	list.insertShiftHead(values[i]);
	 * }
	 * </code>
	 * <code>
	 * CircularLinkedList&lt;E&gt; list=new CircularLinkedList<>();
	 * list.insertHead({...});
	 * list.shiftNext();
	 * </code>
	 * </pre>
	 *
	 * @param  values
	 *                                         The values to insert
	 */
	@SuppressWarnings("unchecked")
	public void insertShiftHead(final E... values){
		for(int i=0; i<values.length; i++){
			this.insertShiftHead(values[i]);
		}
	}

	/**
	 * Inserts the values at the root and the existing node is sifted to the Tail<br>
	 * Same as the flowing code
	 *
	 * <pre>
	 * <code>
	 * CircularLinkedList&lt;E&gt; list=new CircularLinkedList<>();
	 * E values={...};
	 * for(int i=0; i&lt;values.length; i++){
	 * 	list.insertShiftTail(values[i]);
	 * }
	 * </code>
	 * <code>
	 * CircularLinkedList&lt;E&gt; list=new CircularLinkedList<>();
	 * list.insertTail({...});
	 * list.shiftPrevious();
	 * </code>
	 * </pre>
	 *
	 * @param  values
	 *                                         The values to insert
	 */
	@SuppressWarnings("unchecked")
	public void insertShiftTail(final E... values){
		for(final E value : values){
			this.insertShiftTail(value);
		}
	}

	/**
	 * Inserts the value at the root and the existing node is sifted to the Tail
	 *
	 * @param  value
	 *                                         The value to insert
	 */
	@SuppressWarnings("null")
	public void insertShiftTail(final E value){
		if(this.insertCheckShift(value)) return;
		this.root=new Node<>(this.root, value, this.root.getNext());
		this.size++;
	}


	/**
	 * Inserts the values at the root and the existing node is <b>not sifted</b> to the Tail<br>
	 * Same as the flowing code
	 *
	 * <pre>
	 * <code>
	 * CircularLinkedList&lt;E&gt; list=new CircularLinkedList<>();
	 * E values={...};
	 * for(int i=0; i&lt;values.length; i++){
	 * 	list.insertTail(values[i]);
	 * }
	 * </code>
	 * <code>
	 * CircularLinkedList&lt;E&gt; list=new CircularLinkedList<>();
	 * list.insertShiftTail({...});
	 * list.shiftNext();
	 * </code>
	 * </pre>
	 *
	 * @param values
	 *                   The values to insert
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void insertTail(final E... values){
		for(int i=0; i<values.length; i++){
			this.insertTail(values[i]);
		}
	}

	/**
	 * Inserts the value after the root
	 *
	 * @param  value
	 *                                         The value to insert
	 */
	@Override
	@SuppressWarnings({"unused", "null"})
	public void insertTail(final E value){
		if(this.insertCheck(value)) return;
		new Node<>(this.root.getPrevious(), value, this.root);
		this.size++;
	}

	/***
	 * Inserts the value after the Tail based index
	 *
	 * @param  index
	 *                   The index to insert the value (Inserts after)
	 * @param  value
	 *                   The value to insert
	 * @return       A boolean indicating success
	 */
	@Override
	@SuppressWarnings("unused")
	public boolean insertTail(final long index, final E value){
		if(this.insertCheck(value)) return false;
		@NonNull
		final Node<E> next=this.getNodeTail(index);
		new Node<>(next.getPrevious(), value, next);
		this.size++;
		return true;
	}

	/**
	 * Tests if the linked list is empty
	 *
	 * @return                             The state of the array
	 */
	@Override
	public boolean isEmpty(){
		try{

			if(this.size==0&&this.root==null) return true;
			if(
				this.size==0||this.root==null
				) throw new LengthRootMishatchException();
		}
		catch(final LengthRootMishatchException e){
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Loops until max-1
	 *
	 * @param  consumer
	 *                                         The function to do on each iteration
	 * @param  max
	 *                                         The amount of times to call the function
	 */
	@SuppressWarnings("null")
	public void loopUntilHead(
		final ObjLongConsumer<Node<E>> consumer, final long max
		){
		if(this.isEmpty()) return;
		@NonNull
		Node<E> node=this.root;
		for(long i=0; i<max; i++){
			consumer.accept(node, i);
			node=node.getNext();
		}
	}

	/**
	 * Loops until max-1
	 *
	 * @param  consumer
	 *                                         The function to do on each iteration
	 * @param  max
	 *                                         The amount of times to call the function
	 */
	@SuppressWarnings("null")
	public void loopUntilTail(
		final ObjLongConsumer<Node<E>> consumer, final long max
		){
		if(this.isEmpty()) return;
		@NonNull
		Node<E> node=this.root;
		for(long i=0; i<max; i++){
			consumer.accept(node, i);
			node=node.getPrevious();
		}
	}

	/**
	 * Check if the root is not null, if it is null throw an error
	 *
	 * @throws NullPointerException
	 *                                  E
	 */
	protected void nullPointer() throws NullPointerException{
		//Throw an null pointer Exception if the root is null
		//TODO extract method
		if(
			this.root==null
			) throw new NullPointerException(
				"Encountered a null root"
				);
	}

	/**
	 * Removes the root element and shifts the root to the Head
	 *
	 * @return The removed element
	 */
	@Override
	@SuppressWarnings("null")
	public E removeHead(){
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
	 * Removes the head based index
	 *
	 * @param  index
	 *                   The index to remove
	 * @return       The removed value
	 */
	@Override
	@SuppressWarnings("null")
	public E removeHead(final long index){
		if(this.root==null) return null;
		if(this.size==1){
			final Node<E> node=this.root;
			this.size=0;
			this.root=null;
			return node.getValue();
		}
		if(index==0) return this.removeHead();

		final Node<E> node=this.getNodeHead(index);
		node.delete();
		return node.getValue();
	}

	/**
	 * Removes the root element and shifts the root to the Tail
	 *
	 * @return The removed element
	 */
	@Override
	@SuppressWarnings("null")
	public E removeTail(){
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
	 * Removes the tail based index
	 *
	 * @param  index
	 *                   The index to remove
	 * @return       The removed value
	 */
	@Override
	@SuppressWarnings("null")
	public E removeTail(final long index){
		if(this.root==null) return null;
		if(this.size==1){
			final Node<E> node=this.root;
			this.size=0;
			this.root=null;
			return node.getValue();
		}
		if(index==0) return this.removeTail();

		final Node<E> node=this.getNodeTail(index);
		node.delete();
		return node.getValue();
	}

	/**
	 * Shifts the root to the next element
	 */
	@SuppressWarnings("null")
	public void shiftNext(){
		if(this.isEmpty())return;
		this.root=this.root.getNext();
	}


	/**
	 * Shifts the root to the next element at index
	 *
	 * @param  index
	 *                                         The index to get the node
	 */
	public void shiftNext(final long index){
		if(this.isEmpty()) return;
		this.root=this.getNodeHead(index);
	}


	/**
	 * Shifts the root to the previous element
	 */
	@SuppressWarnings("null")
	public void shiftPrevious(){
		if(this.isEmpty()) return;
		this.root=this.root.getPrevious();
	}

	/**
	 * Shifts the root to the previous element at index
	 *
	 * @param  index
	 *                                         The index to get the node
	 */
	public void shiftPrevious(final long index){
		if(this.isEmpty()) return;
		this.root=this.getNodeTail(index);
	}

	/**
	 * Swaps the nodes at the head based index
	 *
	 * @param   index1
	 *                     First index to swap
	 * @param   index2
	 *                     Second index to swap
	 * @apiNote        Not optimized
	 */
	public void swapHead(final long index1, final long index2){
		Node.swap(this.getNodeHead(index1), this.getNodeHead(index2));
	}

	/**
	 * Swaps the nodes at the tail based index
	 *
	 * @param   index1
	 *                     First index to swap
	 * @param   index2
	 *                     Second index to swap
	 * @apiNote        Not optimized
	 */
	public void swapTail(final long index1, final long index2){
		Node.swap(this.getNodeTail(index1), this.getNodeTail(index2));
	}

	/**
	 * Returns a string representation of the object
	 */
	@SuppressWarnings("null")
	@Override
	public String toString(){
		if(this.isEmpty()) return "CircularLinkedList[]";

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
