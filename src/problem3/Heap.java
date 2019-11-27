package problem3;

import java.util.Arrays;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Class Heap<br>
 * A loosely sorted max heap based on the array<br>
 * Does not support a KeyValue pair directly but can be done via composition
 *
 * @author     Shawn Graven
 * @date       11/25/19
 *
 * @param  <E>
 *                 The type of the heap, must implement {@link Comparable}
 * @see        #add(Comparable)
 * @see        #remove()
 * @see        #isEmpty()
 * @see        #left(int)
 * @see        #right(int)
 * @see        #parent(int)
 * @see        KeyValue
 * @see        PriorityQueue
 */
public class Heap <@Nullable
E extends Comparable<E>>{

	/**
	 * @param index the index of the parent
	 * @return the index of the left child (right is +1)
	 */
	protected static int left(final int index){
		return 2*index+1;
	}
	/**
	 * @param index the index of the child
	 * @return the parent index of the child
	 */
	protected static int parent(final int index){
		return (index-1)/2;
	}

	/**
	 * @param index the index of the parent
	 * @return the index of the right child (left is -1)
	 */
	protected static int right(final int index){
		return 2*(index+1);
	}

	final private Object[] arr;

	private int size=0;


	/**
	 * Creates a new Heap with the given capacity
	 *
	 * @param capacity
	 *                     The maximum capacity of the heap
	 */
	public Heap(final int capacity){
		this.arr=new Object[capacity];
	}

	/**
	 * Adds the value to the heap
	 * @param value The value to add
	 * @return {@code true} if successful
	 */
	@SuppressWarnings("null")
	public boolean add(@NonNull
		final E value){
		//Simply set arr[0] to value if empty
		if(this.arr[0]==null){
			this.arr[0]=value;
			this.size=1;
			return true;
		}
		//Don't insert if full
		if(this.size==this.arr.length) return false;
		//Insert at end and trickle up
		this.arr[this.size]=value;
		int parent=Heap.parent(this.size);
		int child=this.size++;
		while(this.get(parent).compareTo(this.get(child))<0){
			//Swap if out of order
			this.swap(parent, child);
			if(parent==0) break;
			child=parent;
			parent=Heap.parent(child);
		}
		return true;
	}

	/**
	 * @return the depth of the given index
	 */
	protected int depth(final int index){
		//Does not support log base 2 so using the base change formula ln(x)/ln(n)=log_n(x)
		return (int)Math.ceil(Math.log(index+2)/Math.log(2))-1;
	}

	/**
	 * @return the index from the right of the tree of the given index
	 */
	protected int fromRight(final int index){
		//The first node in the row is 2^depth, knowing this we can calculate how far from the right the node is
		return index-(int)Math.pow(2, this.depth(index))+1;
	}

	/**
	 * Returns the casted value of the index
	 */
	@SuppressWarnings("unchecked")
	protected E get(final int index) {
		return (E)this.getRaw(index);//Imposible externaly to get an error
	}

	/**
	 * Returns the uncasted object for the given index
	 * @param index The index to find
	 * @return The uncasted object
	 */
	protected Object getRaw(final int index){
		return index<this.arr.length?this.arr[index]:null;
	}

	/**
	 * Checks if the Heap is empty
	 * @return {@code true} if there is no data in the Heap, {@code false} if there is some data
	 */
	public boolean isEmpty(){
		return this.size==0;
	}

	/**
	 * Removes the top value in the heap
	 * @return the removed value
	 */
	@SuppressWarnings({"null"})
	public @Nullable
	E remove(){
		//Don't do anything if empty
		if(this.isEmpty()) return null;
		//Simplify the steps if there is only one value as no chaecks are required
		if(this.size==1){
			final E value=this.get(--this.size);
			this.arr[0]=null;
			return value;
		}
		final E value=this.get(0);
		//Insert last value into root
		this.arr[0]=this.getRaw(this.size-1);
		this.arr[--this.size]=null;
		//Trickle down
		int parent=0;
		int child=1;
		while(child<this.size){//Loop only if child is within bounds
			System.out.println(this);
			if(
				this.get(child+1)!=null&&
				this.get(child).compareTo(this.get(child+1))<0
				){
				//Right Child is greater (Shift to point to the right child)
				//Check if it exists
				if(this.getRaw(++child)==null) return value;
			}
			//Otherwise Left Child is greater (No shift required)
			if(this.get(child).compareTo(this.get(parent))<=0){
				//Done swapping
				return value;
			}
			//Swap
			this.swap(parent, child);
			//Get the next parent and child
			parent=child;
			child=Heap.left(parent);
		}
		System.out.println(this);
		return value;
	}

	/**
	 * @return the size
	 */
	public int size(){
		return this.size;
	}

	/**
	 * Swaps the two index values
	 *
	 * @param index1
	 *                   the first index to swap
	 * @param index2
	 *                   the second index to swap
	 */
	protected void swap(final int index1, final int index2){
		final Object obj=this.getRaw(index1);
		this.arr[index1]=this.getRaw(index2);
		this.arr[index2]=obj;
	}

	/**
	 * Converts the Object into a string representation
	 * @return a string representation of the Heap
	 */
	@Override
	public String toString(){
		//Why define your own code when they define it!
		return "Heep "+Arrays.toString(this.arr);
	}
}
