package heap;

import org.eclipse.jdt.annotation.NonNull;

public class Heap <@NonNull
E extends Comparable<E>>{

	final private Object[] arr;
	private int size=0;

	/**
	* Creates a new Heap with the given capacity
	*/
	public Heap(final int capacity){
		this.arr=new Object[capacity];
	}
	
	/**
	* Adds the value to the heap
	* @param value The value to add
	* @return {@code true} if successful 
	*/
	public boolean add(final E value){
		if(this.arr[0]==null){
			this.arr[0]=value;
			this.size=1;
			return true;
		}
		//Don't insert if full
		if(this.size==this.arr.length) return false;
		//Insert at end and trickel up
		this.arr[this.size]=value;
		int parent=this.parent(this.size);
		int child=this.size++;
		while(this.get(parent).compareTo(this.get(child))<0){
			this.swap(parent, child);
			if(parent==0) break;
			child=parent;
			parent=this.parent(parent);
		}
		return true;
	}
	
	/**
	* @return the depth of the given index
	*/
	protected int depth(final int index){
		return (int)Math.ceil(Math.log(index+2)/Math.log(2))-1;
	}
	
	
	/**
	* @return the index from the right of the tree of the given index
	*/
	protected int fromRight(final int index){
		return index-(int)Math.pow(2, this.depth(index))+1;
	}
	
	/**
	* Returns the casted value of the index
	*/
	@SuppressWarnings("unchecked")
	protected E get(final int index) {
		return (E)this.getRaw(index);
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
	* @param index the index of the parent
	* @return the index of the left child (right is +1)
	*/
	protected int left(final int index){
		return 2*index+1;
	}
	
	/**
	* @param index the index of the child
	* @return the parent index of the child
	*/
	protected int parent(final int index){
		return (index-1)/2;
	}

	/**
	* Removes the top value in the heap
	* @return the removed vaule
	*/
	public E remove(){
		final E value=this.get(0);
		int parent=0;
		int child=1;
		while(this.getRaw(child)!=null){
			if(this.get(child).compareTo(this.get(child+1))>0){
				//Left Child is greater
				this.arr[parent]=this.getRaw(child);
				this.arr[child]=null;
				parent=child;
			}
			else{
				//Right Child is greater
				this.arr[parent]=this.getRaw(child+1);
				this.arr[child+1]=null;
				parent=child+1;
			}
			child=this.left(parent);
		}
		//TODO fix non complete tree
		return value;
	}
	
	/**
	* @param index the index of the parent
	* @return the index of the right child (left is -1)
	*/
	protected int right(final int index){
		return 2*(index+1);
	}
	
	/**
	* Swaps the two index values
	* @param index1 the first index to swap
	* @param index2 the seacond index to swap
	*/
	protected void swap(final int index1, final int index2){
		final Object obj=this.getRaw(index1);
		this.arr[index1]=this.getRaw(index2);
		this.arr[index2]=obj;
	}
}
