package heap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class PriorityQueue <@NonNull
K extends Comparable<K>, @Nullable
V>{
	final private Heap<KeyValue<K, V>> heap;


	public PriorityQueue(final int capacity){
		this.heap=new Heap<>(capacity);
	}

	public boolean add(final K key, final V value){
		return this.heap.add(new KeyValue<>(key, value));
	}

	@SuppressWarnings("null")
	public V remove(){
		return this.heap.isEmpty()?null:this.heap.remove().getValue();
	}

	@Override
	public String toString(){
		return this.heap.toString();
	}
}
