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

	public abstract void insertNext(E value);

	@SuppressWarnings("unchecked")
	public abstract void insertNext(E... value);

	public abstract boolean insertNext(long index, E value);

	public abstract void insertPrevious(E value);

	@SuppressWarnings("unchecked")
	public abstract void insertPrevious(E... value);

	public abstract boolean insertPrevious(long index, E value);

	public abstract E removeNext();

	public abstract E removeNext(long index);

	public abstract E removePrevious();

	public abstract E removePrevious(long index);


	@Override
	public abstract String toString();
}
