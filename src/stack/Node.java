package stack;

public class Node <E>{
	private Node<E> next;
	private Node<E> previous;
	private E value;


	public Node(final E value){
		this(value, null);
	}

	public Node(final E value, final Node<E> node){
		this.value=value;
		this.previous=node;
		this.next=null;
		if(node!=null) node.setNext(this);
	}

	/**
	 * @return the next
	 */
	public Node<E> getNext(){
		return this.next;
	}

	/**
	 * @return the previous
	 */
	public Node<E> getPrevious(){
		return this.previous;
	}

	/**
	 * @return the value
	 */
	public E getValue(){
		return this.value;
	}

	/**
	 * @param next
	 *                 the next to set
	 */
	public void setNext(final Node<E> next){
		this.next=next;
	}

	/**
	 * @param preveious
	 *                      the previous to set
	 */
	public void setPrevious(final Node<E> preveious){
		this.previous=preveious;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(final E value){
		this.value=value;
	}
}
