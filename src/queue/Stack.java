package queue;

import org.eclipse.jdt.annotation.Nullable;

import linkedList.CircularLinkedList;

public class Stack <@Nullable
E>{
	CircularLinkedList<E> list=new CircularLinkedList<>();


	public Stack(){
		//Do nothing
	}

	/**
	 * @return
	 * @see    linkedList.LinkedCore#getSize()
	 */
	public long getSize(){
		return this.list.getSize();
	}

	/**
	 * @param value
	 * @see         linkedList.CircularLinkedList#insertShiftHead(java.lang.Object)
	 */
	public void insert(@Nullable
		final E value){
		this.list.insertShiftHead(value);
	}

	/**
	 * @return
	 * @see    linkedList.CircularLinkedList#isEmpty()
	 */
	public boolean isEmpty(){
		return this.list.isEmpty();
	}

	/**
	 * @return
	 * @see linkedList.CircularLinkedList#removeHead()
	 */
	public @Nullable
	E remove(){
		return this.list.removeHead();
	}
}
