package linkedList;

public abstract class LinkedCore{
	private long size;


	/**
	 * Gets the size of the Linked List
	 *
	 * @return The size
	 */
	public long getSize(){
		return this.size;
	}

	@Override
	abstract public String toString();
}
