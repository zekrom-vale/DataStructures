package hashProbe;

import java.util.Arrays;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * HashProbe implements linear probing to solve collision with hash tables<br>
 * Wraps values in a warper to solve removal declustering rather than using a magic value<br>
 * Not efficient
 *
 * @author     Shawn Graven
 * @date       11/26/19
 *
 * @param  <E>
 *                 The type of the HashProbe
 */
public class HashProbe <@NonNull
E>{
	public final static String METHOD="linear probe";
	private final Wraper<@Nullable
	Object>[] arr;


	/**
	 * Creates a new HashProbe
	 * 
	 * @param capacity
	 *                     The size of the hash array, can only fit up to that much
	 */
	@SuppressWarnings("unchecked")
	public HashProbe(final int capacity){
		this.arr=new Wraper[capacity];
	}

	/**
	 * Inserts the value into the HashProbe
	 * 
	 * @param  value
	 *                   The value to add
	 * @return       {@code true} if successful {@code false} if full
	 */
	public boolean add(final E value){
		final int hash=this.hashCode(value);
		return this.add(new Wraper<>(value), hash, hash-1);
	}

	/**
	 * Internal add method
	 * 
	 * @param  value
	 *                   The warped value to add
	 * @param  hash
	 *                   The current index to insert at
	 * @param  stop
	 *                   When to stop
	 * @return       success
	 */
	private boolean add(final Wraper<@Nullable
		Object> value, int hash, final int stop){
		//wrap if >= this.arr.length
		hash%=this.arr.length;
		if(this.arr[hash]==null){
			this.arr[hash]=value;
			return true;
		}
		if(this.arr[hash].isNull()){
			//Reuse warper
			this.arr[hash].value=value;
			return true;
		}
		if(hash!=stop) return this.add(value, hash+1, stop);
		return false;
	}

	public boolean exists(final E value){
		return this.getIndex(value)!=-1;
	}

	private int getIndex(final E value){
		int index=this.hashCode(value);
		final int start=index-1;
		for(; this.arr[index]!=null; index++){
			if(this.arr[index].isNull()) continue;
			final byte test=this.getIndexInner(value, index, start);
			if(test!=-1) return test==0?-1:index;
		}
		for(index=0; this.arr[index]!=null; index++){
			if(this.arr[index].isNull()) continue;
			final byte test=this.getIndexInner(value, index, start);
			if(test!=-1) return test==0?-1:index;
		}
		return -1;
	}

	/**
	 * @param value
	 * @param index
	 * @param start
	 */
	private byte getIndexInner(final E value, final int index, final int start){
		if(this.arr[index].equals(value)) return 1;
		//If this value is null
		if(this.arr[index]==null) return 0;
		//If at last index
		if(index==start) return 0;
		return -1;
	}

	/**
	 * @param value The value to hash
	 * @return The adjusted hash code
	 */
	protected int hashCode(final E value){
		if(value instanceof String){
			final String string=(String)value;
			int hash=0;
			final int prime=32, shift=0x61;
			for(int i=0; i<string.length(); i++){
				hash=(hash*prime+string.charAt(i)-shift)%this.arr.length;
			}
			return hash;
		}
		return Math.abs(value.hashCode())%this.arr.length;
	}

	public boolean remove(final E value) {
		final int index=this.getIndex(value);
		if(index==-1)return false;
		this.arr[index].setNull();
		return true;
	}

	@Override
	public String toString(){
		final StringBuilder builder=new StringBuilder();
		builder.append("HashProbe ");
		builder.append(Arrays.toString(this.arr));
		return builder.toString();
	}
}
