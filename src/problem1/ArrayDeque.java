package problem1;

/**
 * Driver ArrayDeque<br>
 * Creates a Deque object implementing the circular array
 *
 * @author     Shawn Graven
 * @date       10/10/19
 *
 * @param  <E>
 *                 The type of the ArrayDeque
 * @see        #ArrayDeque(int, boolean)
 * @see        #insertLeft(Object)
 * @see        #insertRight(Object)
 * @see        #deleteLeft()
 * @see        #deleteRight()
 * @see        #peekLeft()
 * @see        #peekRight()
 *
 * @see        Driver
 */
@SuppressWarnings("hiding")
public class ArrayDeque <E>{
	/**
	 * The array containing the values
	 */
	private final Object[] arr;
	private final boolean autoFlush;
	/**
	 * The left pointer of the ArrayDeque
	 */
	private int left;
	/**
	 * The right pointer of the ArrayDeque
	 */
	private int right;

	/**
	 * The current size of the ArrayDeque
	 */
	private int size=0;


	/**
	 * Creates a new ArrayDeque object
	 *
	 * @param capcaity
	 *                     the amount of elements the Deque can hold
	 */
	public ArrayDeque(final int capcaity){
		this(capcaity, false);
	}

	/**
	 * Creates a new ArrayDeque object
	 *
	 * @param capcaity
	 *                      the amount of elements the Deque can hold
	 * @param autoFlush
	 *                      Automatically set used values to null for garbage collection<br>
	 *                      Recommended for large objects
	 */
	public ArrayDeque(final int capcaity, final boolean autoFlush){
		this.autoFlush=autoFlush;
		this.left=capcaity/2;
		this.right=this.left-1;
		this.arr=new Object[capcaity];
	}

	/**
	 * Deletes the left element
	 *
	 * @return The removed element
	 */
	@SuppressWarnings("unchecked")
	public E deleteLeft(){
		if(this.isEmpty())return null;
		final E element=(E)this.arr[this.left];
		if(this.autoFlush) this.arr[this.left]=null;
		this.size--;
		if(++this.left==this.arr.length)this.left=0;
		return element;
	}

	/**
	 * Deletes the right element
	 *
	 * @return The removed element
	 */
	@SuppressWarnings("unchecked")
	public E deleteRight(){
		if(this.isEmpty()) return null;
		this.size--;
		final E element=(E)this.arr[this.right];
		if(this.autoFlush) this.arr[this.right]=null;
		if(this.right--==0) this.right=this.arr.length-1;
		return element;
	}

	/**
	 * Resets the Deque without actually clearing out the objects
	 *
	 * @see #flush()
	 */
	public void dump(){
		this.left=this.arr.length/2;
		this.right=this.left-1;
		this.size=0;
	}

	/**
	 * Clears all discarded values without effecting the valid Deque
	 */
	public void flush(){
		if(this.left<=this.right){
			for(int i=0; i<this.left; i++){
				this.arr[i]=null;
			}
			for(int i=this.right+1; i<this.arr.length; i++){
				this.arr[i]=null;
			}
		}
		else{
			for(int i=this.right+1; i<this.left; i++){
				this.arr[i]=null;
			}
		}
	}

	/**
	 * Clears out all object references
	 *
	 * @see #dump()
	 */
	public void flushAll(){
		this.dump();
		for(int i=0; i<this.arr.length; i++){
			this.arr[i]=null;
		}
	}

	/**
	 * Inserts the element on the left
	 *
	 * @param  value
	 *                   The value to add
	 *
	 * @return       A boolean indicating success
	 */
	@SuppressWarnings("unchecked")
	public boolean insertLeft(final E value){
		if(this.isFull()) return false;
		this.size++;
		if(this.left--==0) this.right=this.arr.length-1;
		this.arr[this.left]=value;
		return true;
	}

	/**
	 * Inserts the list of values to the right<br>
	 * <pre>
	 * <code>
	 *
	 * ArrayDeque<Integer> deque=new ArrayDeque<>(10);
	 * deque.insertLeft(1, 2, 3, 4);
	 * ----
	 * ArrayDeque<Integer> deque=new ArrayDeque<>(10);
	 * deque.insertLeft(1);
	 * deque.insertLeft(2);
	 * deque.insertLeft(3);
	 * deque.insertLeft(4);
	 * </code>
	 * </pre>
	 * @param values The values to insert
	 * @return The number of items inserted
	 */
	@SuppressWarnings("unchecked")
	public int insertLeft(final E ... values){
		int i=0;
		for(;i<values.length; i++){
			if(!this.insertLeft(values[i]))return i;
		}
		return i;
	}

	/**
	 * Inserts an element to the right
	 *
	 *
	 * @param  value
	 *                   The value to insert
	 * @return       Success as a boolean
	 */
	public boolean insertRight(final E value){
		if(this.isFull()) return false;
		this.size++;
		if(++this.right==this.arr.length) this.right=0;
		this.arr[this.right]=value;
		return true;
	}


	/**
	 * Inserts the list of values to the right<br>
	 * <pre>
	 * <code>
	 *
	 * ArrayDeque<Integer> deque=new ArrayDeque<>(10);
	 * deque.insertRight(1, 2, 3, 4);
	 * ----
	 * ArrayDeque<Integer> deque=new ArrayDeque<>(10);
	 * deque.insertRight(1);
	 * deque.insertRight(2);
	 * deque.insertRight(3);
	 * deque.insertRight(4);
	 * </code>
	 * </pre>
	 * @param values The values to insert
	 * @return The number of items inserted
	 */
	@SuppressWarnings("unchecked")
	public int insertRight(final E ... values){
		int i=0;
		for(;i<values.length; i++){
			if(!this.insertRight(values[i]))return i;
		}
		return i;
	}

	/**
	 * Tests if the ArrayDeque is empty
	 *
	 * @return A boolean indicating if an element can't be removed
	 */
	public boolean isEmpty(){
		return this.size==0;
	}

	/**
	 * Tests if the ArrayDeque is full
	 *
	 * @return A boolean indicating if an element can't be inserted
	 */
	public boolean isFull(){
		return this.size==this.arr.length;
	}

	/**
	 * Returns the left element without removing it
	 * @return The left element
	 */
	@SuppressWarnings("unchecked")
	public E peekLeft(){
		if(this.isEmpty())return null;
		return (E)this.arr[this.left];
	}

	/**
	 * Returns the right element without removing it
	 * @return The right element
	 */
	@SuppressWarnings("unchecked")
	public E peekRight(){
		if(this.isEmpty())return null;
		return (E)this.arr[this.right];
	}

	/**
	 * Prints the ArrayDeque to the console
	 */
	public void print(){
		System.out.println(this);
	}

	/**
	 * Prints the ArrayDeque as it is implemented in the array
	 */
	public void printRaw() {
		System.out.println(this.toStringRaw());
	}

	public int size(){
		return this.size;
	}

	/**
	 * Prints a string representation of the ArrayDeque
	 */
	@Override
	public String toString(){
		if(this.isEmpty()) return "ArrayDeque []";
		final StringBuilder builder=new StringBuilder();
		builder.append("ArrayDeque [");
		if(this.left<=this.right){
			for(int i=this.left; i<this.right; i++){
				builder.append(this.arr[i]).append(", ");
			}
		}
		else{
			for(int i=this.left; i<this.arr.length; i++){
				builder.append(this.arr[i]).append(", ");
			}
			for(int i=0; i<this.right; i++){
				builder.append(this.arr[i]).append(", ");
			}
		}
		builder.append(this.arr[this.right]).append("]");
		return builder.toString();
	}

	/**
	 * Returns the array implementing the ArrayDeque <b>raw</b><br>
	 * Only for debugging {@link #flush()} and the wrap cases
	 *
	 * @return The raw array
	 */
	public String toStringRaw(){
		if(this.arr.length==0)return "ArrayDeque(Raw)[]";
		final StringBuilder builder=new StringBuilder();
		builder.append("ArrayDeque(Raw)[");
		for(int i=0; i<this.arr.length-1; i++){
			builder.append(this.arr[i]).append(", ");
		}
		builder.append(this.arr[this.arr.length-1]);
		builder.append("]");
		return builder.toString();
	}
}
