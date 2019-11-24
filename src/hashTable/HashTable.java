package hashTable;

import java.lang.reflect.Array;
import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class HashTable <@NonNull
E, S extends Collection<E>> implements Collection<E>{

	public static final String METHOD="Chaining";
	private final S[] arr;
	/**
	* The method returning a new S object
	*/
	@NonNull
	private final Supplier<S> supplier;

	/**
	* Creates a new HashTable
	* @param capacity the size of the array to create, should be prime
	* @param supplier a method that returns a new container
	* @apinote supplier will be called at the start to get the class of the type
	*/
	@SuppressWarnings({"unchecked", "null"})
	public HashTable(final int capacity, @NonNull
		final Supplier<@NonNull
		S> supplier){
		this.supplier=supplier;
		this.arr=(S[])Array.newInstance(supplier.get().getClass(), capacity);
	}

	/**
	* Inserts a new element into the hash table
	* @param value The value to add
	* @return {@code true} if there is room to insert
	*/
	@Override
	public boolean add(final E value){
		final int index=this.hashCode(value);
		if(this.arr[index]==null) this.arr[index]=this.supplier.get();
		return this.arr[index].add(value);
	}

	/**
	* Checks if the value exists in the hash table
	*/
	@Override
	public boolean exists(final E value){
		final int index=this.hashCode(value);
		if(this.arr[index]==null) return false;
		return this.arr[index].exists(value);
	}

	/**
	 * Hashes the value by calling the respective hashcode method and adjusts for capacity
	 * @param value The value to hash
	 * @return The corrected hash value
	 */
	private int hashCode(final E value){
		return Math.abs(value.hashCode())%this.arr.length;
	}

	/**
	* Removes the given value
	* @param value the value to remove
	* @return {@code true} if the value exists and was deleted
	*/
	@Override
	public @Nullable
	E remove(final E value){
		final int index=this.hashCode(value);
		if(this.arr[index]==null) return null;
		return this.arr[index].remove(value);
	}

	/**
	* @return A string representation of the hash table
	*/
	@Override
	public String toString(){
		final StringBuilder builder=new StringBuilder();
		builder.append("HashTable [");
		for(final S s : this.arr){
			if(s instanceof HashTable<?, ?>) builder.append('\t');
			if(s!=null) builder.append(s);
			if(s instanceof HashTable<?, ?>) builder.append(",\n");
			else builder.append(" ,");
		}
		builder.append("]");
		return builder.toString();
	}
}
