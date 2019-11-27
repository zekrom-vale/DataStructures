package hashTable;

import java.lang.reflect.Array;
import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Class HashTable resolves colission by inserting the value into an expandable container<br>
 * This implimenttation does not use any container in specific but it must impliment {@code hashTable.Collection<?>}<br>
 * This allows the HashTable to use it self, whitch may use it self, and any other container instead of just stuck to one
 * @param <E> The type stored in the hash table
 * @param <S> The collection that will be used to contain the values inserted
 */
public class HashTable <@NonNull
E, S extends Collection<E>> implements Collection<E>{

	public static final String METHOD="Chaining";
	private final S[] arr;
	/**
	 * The method returning a new S object<br>
	 * Does not call the constructor as it is imposible to tell how many and what arguments are required
	 */
	@NonNull
	private final Supplier<S> supplier;

	/**
	 * Creates a new HashTable<br>
	 * Note, redundent useage of generics will pop up.  Unfortunetly this is incorect and will throw an error if removed
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
		//Check if the entery is null as they are instatated on the fly to save space
		if(this.arr[index]==null) return false;
		//If it does have a container call it's exists function
		return this.arr[index].exists(value);
	}

	/**
	 * Hashes the value by calling the respective hashcode method and adjusts for capacity
	 * @param value The value to hash
	 * @return The corrected hash value
	 */
	private int hashCode(final E value){
		//Override of hash code for strings
		if(value instanceof String){
			final String string=(String)value;
			int hash=0;
			final int prime=32, shift='a';
			for(int i=0; i<string.length(); i++){
				hash=(hash*prime+string.charAt(i)-shift)%(this.arr.length-1);
			}
			System.out.println(hash);
			return Math.abs(hash);
		}
		//Otherwise call the hashCode method, make it positive, and cut to size of the array
		//String did have cases where a negative value did appear so that is why there is the abs method
		return Math.abs(value.hashCode()%this.arr.length);
		//Math.abs(Integer.MIN_VALUE)==Integer.MIN_VALUE so must do mod first
	}

	/**
	 * Removes the given value
	 * @param value the value to remove
	 * @return {@code true} if the value exists and was deleted, {@code false} if it does not exist
	 */
	@Override
	public @Nullable
	E remove(final E value){
		final int index=this.hashCode(value);
		if(this.arr[index]==null) return null;
		return this.arr[index].remove(value);
	}

	/**
	 * Converts the HashTable into a string<br>
	 * More complicated for the DoubleHashDriver
	 * @return A string representation of the hash table
	 */
	@Override
	public String toString(){
		final StringBuilder builder=new StringBuilder();
		builder.append("HashTable [");
		for(final S s : this.arr){
			//Format for a new line if nested will not run for the single hashTable
			if(s instanceof HashTable<?, ?>) builder.append('\t');
			if(s!=null) builder.append(s);
			if(s instanceof HashTable<?, ?>) builder.append(",\n");
			else builder.append(" ,");
		}
		//Could have resolved the extra "," at the end but runing out of time
		builder.append("]");
		return builder.toString();
	}
}
