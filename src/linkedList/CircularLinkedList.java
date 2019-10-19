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
public class CircularLinkedList<@Nullable E> extends LinkedList <E>{
	
	/*
	* Not using Right
	*/
	
	/**
	 * Returns a new CircularLinkedList
	 */
	public CircularLinkedList(){
		//Do nothing
	}
	
	/**
	 * Removes the first element
	 *
	 * @return The removed element
	 */
	@Override
	public E deleteLeft(){
		if(this.left==null)return null;
		Node<E> node=this.left;
		if(this.size==1){
			this.size=0;
			this.left=null;
			return node.getValue();
		}
		this.left=this.left.getNext();
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
	@Override
	public E deleteLeft(final long index){
		if(this.size==1){
			Node<E> node=this.left;
			this.size=0;
			this.left=null;
			return node.getValue();
		}
		if(index==0) return this.deleteLeft();

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
	@Override
	@SuppressWarnings("null")
	public E deleteRight(){
		if(this.left==null)return null;
		Node<E> node=this.left;
		if(this.size==1){
			this.size=0;
			this.left=null;
			return node.getValue();
		}
		this.left=this.left.getPrevious();
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
	@Override
	public E deleteRight(final long index){
		if(this.size==1){
			Node<E> node=this.left;
			this.size=0;
			this.left=null;
			return node.getValue();
		}
		if(index==0) return this.deleteRight();

		final Node<E> node=this.getNodeRight(index);
		if(node==null)return null;
		node.delete();
		return node.getValue();
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
	protected @NonNull Node<E> getNodeRight(final long index){
		index=index%this.size;
		if(index>this.size/2) return this.getNodeLeft(this.size-index-1);
		@NonNull
		Node<E> next=this.left;
		int i=0;
		while(i<index){
			next=next.getPrevious();
			i++;
		}
		return next;
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
	protected @NonNull Node<E> getNodeLeft(final long index){
		index=index%this.size;
		/*
		* //What happens if I do this?
		* super.getNodeLeft(index%this.size);
		* //Does it call LinkedList.getNodeRight() or CircularLinkedList.getNodeRight() <- What I want?
		*/
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
	
	

	protected void insert(final E value){
		this.left=new Node<>(value);
		this.left.setNext(this.left);
		this.left.setPrevious(this.left);
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
		this.left=new Node<>(this.left, value, this.left.getNext());
		this.size++;
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
		if(index==-1||this.left==null){
			this.insert(value);
			return true;
		}
		@NonNull
		final Node<E> prev=this.getNodeLeft(index);
		new Node<>(prev, value, prev.getNext());
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
			return;
		}
		this.left=new Node<>(this.left.getPrevious(), value, this.left);
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
		if(index==-1||this.left==null){
			this.insert(value);
			return true;
		}
		@NonNull
		final Node<E> next=this.getNodeRight(index);
		new Node<>(next.getPrevious(), value, next);
		this.size++;
		return true;
	}
}
