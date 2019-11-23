package hashTable;

import java.lang.reflect.Array;
import java.util.function.Supplier;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class HashTable <@NonNull
E, S extends Collection<E>> implements Collection<E>{

	public static final String METHOD="Chaining";
	private final S[] arr;
	@NonNull
	private final Supplier<S> supplier;


	@SuppressWarnings({"unchecked", "null"})
	public HashTable(final int capacity, @NonNull
		final Supplier<@NonNull
		S> supplier){
		this.supplier=supplier;
		this.arr=(S[])Array.newInstance(supplier.get().getClass(), capacity);
	}

	@Override
	public boolean add(final E value){
		final int index=this.hashCode(value);
		if(this.arr[index]==null) this.arr[index]=this.supplier.get();
		return this.arr[index].add(value);
	}

	@Override
	public boolean exists(final E value){
		final int index=this.hashCode(value);
		if(this.arr[index]==null) return false;
		return this.arr[index].exists(value);
	}

	/**
	 * @param value
	 * @return
	 */
	private int hashCode(final E value){
		return Math.abs(value.hashCode())%this.arr.length;
	}

	@Override
	public @Nullable
	E remove(final E value){
		final int index=this.hashCode(value);
		if(this.arr[index]==null) return null;
		return this.arr[index].remove(value);
	}

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
