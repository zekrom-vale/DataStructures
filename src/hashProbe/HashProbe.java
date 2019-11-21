package hashProbe;

import java.util.Arrays;

import org.eclipse.jdt.annotation.NonNull;

public class HashProbe <@NonNull
E>{
	public final static String METHOD="linear probe";
	private final Object[] arr;


	public HashProbe(final int capacity){
		this.arr=new Object[capacity];
	}

	public boolean add(final E value){
		final int hash=value.hashCode()%this.arr.length;
		return this.add(value, hash, hash-1);
	}

	private boolean add(final E value, int hash, final int stop){
		//wrap if >= this.arr.length
		hash%=this.arr.length;
		if(this.arr[hash]==null){
			this.arr[hash]=value;
			return true;
		}
		if(hash!=stop) return this.add(value, hash+1, stop);
		return false;
	}

	public boolean exists(final E value){
		return this.getIndex(value)!=-1;
	}

	private int getIndex(final E value){
		int index=value.hashCode()%this.arr.length;
		final int start=index-1;
		for(; this.arr[index]!=null; index++){
			final byte test=this.getIndexInner(value, index, start);
			if(test!=-1) return test==0?-1:index;
		}
		for(index=0; this.arr[index]!=null; index++){
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
		if(value.equals(this.arr[index])) return 1;
		//If this value is null
		if(this.arr[index]==null) return 0;
		//If at last index
		if(index==start) return 0;
		return -1;
	}

	public boolean remove(final E value) {
		final int index=this.getIndex(value);
		if(index==-1)return false;
		this.arr[index]=null;
		//Warning may detach clusters
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
