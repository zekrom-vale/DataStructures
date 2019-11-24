package heap;

import org.eclipse.jdt.annotation.NonNull;

public class Heap <@NonNull
E extends Comparable<E>>{

	final private Object[] arr;
	private int size=0;


	public Heap(final int capacity){
		this.arr=new Object[capacity];
	}

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
		return (E)this.getRaw(index);
	}

	/**
	 * @param child
	 * @return
	 */
	protected Object getRaw(final int index){
		return index<this.arr.length?this.arr[index]:null;
	}

	protected int left(final int index){
		return 2*index+1;
	}

	protected int parent(final int index){
		return (index-1)/2;
	}

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

	protected int right(final int index){
		return 2*(index+1);
	}

	protected void swap(final int index1, final int index2){
		final Object obj=this.getRaw(index1);
		this.arr[index1]=this.getRaw(index2);
		this.arr[index2]=obj;
	}
}
