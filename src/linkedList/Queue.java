package linkedList;

import org.eclipse.jdt.annotation.Nullable;

public class Queue<@Nullable E>{
	
	private CircularLinkedList<E>=new CircularLinkedList<>();
	
	public Queue(){
		//Do nothing
	}
	
	public void push(E value){
		this.list.insertHead(value);
	}
	
	public E pop(){
		return this.list.removeTail();
	}
	
	public E peek(){
		return list.getTail(0);
	}
}
