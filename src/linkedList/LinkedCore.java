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

	abstract public void insertNext(E value);

	abstract public void insertNext(E... value);

	abstract public boolean insertNext(long index, E value);

	abstract public void insertPrevious(E value);

	abstract public void insertPrevious(E... value);

	abstract public boolean insertPrevious(long index, E value);

	abstract public E removeNext();

	abstract public E removeNext(long index);

	abstract public E removePrevious();

	abstract public E removePrevious(long index);


	@Override
	abstract public String toString();
}
