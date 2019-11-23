package heap;

import org.eclipse.jdt.annotation.NonNull;

import hashTable.Collection;

public class Heap <@NonNull
E extends Comparable<E>> implements Collection<E>{

	final private Object[] arr;
	private int size=0;


	public Heap(final int capacity){
		this.arr=new Object[capacity];
	}

	@Override
	public boolean add(final E value){
		if(this.arr[0]==null){
			this.arr[0]=value;
			this.size=1;
			return true;
		}
		if(this.size==this.arr.length) return false;
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
	protected int depth(final int index){
		return (int)Math.ceil(Math.log(index+2)/Math.log(2))-1;
	}

	protected int fromRight(final int index){
		return index-(int)Math.pow(2, this.depth(index))+1;
	}

	@SuppressWarnings("unchecked")
	protected E get(final int index) {
		return (@NonNull E)this.arr[index];
	}

	protected int left(final int index){
		return 2*index+1;
	}

	protected int parent(final int index){
		return (index-1)/2;
	}

	protected int right(final int index){
		return 2*(index+1);
	}

	protected void swap(final int index1, final int index2){
		final Object obj=this.arr[index1];
		this.arr[index1]=this.arr[index2];
		this.arr[index2]=obj;
	}
}
