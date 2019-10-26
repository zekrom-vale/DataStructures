package linkedList;

@SuppressWarnings("javadoc")
public abstract class LinkedCore <E>{
	private long size;


	/**
	 * Gets the size of the Linked List
	 *
	 * @return The size
	 */
	public long getSize(){
		return this.size;
	}

	public abstract void insertHead(E value);

	@SuppressWarnings("unchecked")
	public abstract void insertHead(E... value);

	public abstract boolean insertHead(long index, E value);

	public abstract void insertTail(E value);

	@SuppressWarnings("unchecked")
	public abstract void insertTail(E... value);

	public abstract boolean insertTail(long index, E value);

	public abstract E removeHead();

	public abstract E removeHead(long index);

	public abstract E removeTail();

	public abstract E removeTail(long index);


	@Override
	public abstract String toString();
	
	public abstract Node<E> getHeadNode(final long index);
	
	public E getHead(final long index){
		this.getHeadNode(index).getValue();
	}
	
	public abstract Node<E> getTailNode(final long index);
	
	public E getTail(final long index){
		this.getTailNode(index).getValue();
	}
}
