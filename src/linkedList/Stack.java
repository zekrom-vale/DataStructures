package linkedList;

import org.eclipse.jdt.annotation.Nullable;

public class Stack<@Nullable E>{
	private final CircularLinkedList<E> list=new CircularLinkedList<>();
	
	public Stack(){
		//Do nothing
	}
	
	public void push(E value){
		list.insertShiftHead(value);
	}
	
	public E pop(){
		return list.removeHead();
	}
	
	public E peek(){
		return list.getHead(0);
	}
}
