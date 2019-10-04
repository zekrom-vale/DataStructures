package stack;

import linkedList.Node;

public class Stack <E>{
	Node<E> node=null;


	public Stack(){}

	public boolean isEmpty() {
		return this.node==null;
	}

	public boolean isFull(){
		return false;
	}

	public E peek(){
		if(this.node==null) return null;
		return this.node.getValue();
	}

	public E pop(){
		if(this.node==null) return null;
		final E value=this.node.getValue();
		this.node=this.node.getPrevious();
		if(this.node!=null) this.node.setNext(null);
		return value;
	}

	public void push(final E value){
		this.node=new Node<>(value, this.node);
	}
}
