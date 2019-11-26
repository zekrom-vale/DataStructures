package heap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
* Class PriorityQueue composition (Has-A) Heap<br>
* Impliments the Priority Queue via a Heap of KeyValue pairs
* @param <K> The Key type that sorts the PriorityQueue
* @param <V> The value to store in the PriorityQueue
*/
public class PriorityQueue <@NonNull
K extends Comparable<K>, @Nullable
V>{
	/**
	* The Heap the stores the KeyValue pair
	*/	
	final private Heap<KeyValue<K, V>> heap;


	/**
	* Creates a new PriorityQueue with a given capacity
	* @param capacity the maxumum size of the PriorityQueue, insertion fails whin inserting this may times
	*/
	public PriorityQueue(final int capacity){
		this.heap=new Heap<>(capacity);
	}

	/**
	* Adds the KeyValue pair to the PriorityQueue
	* @param key The key that determines the order of removal
	* @param value The value to be assosaited with the key
	* @return {@code true} if it was inserted successfuly, {@code false} if there is no space in the PriorityQueue
	*/
	public boolean add(final K key, final V value){
		return this.heap.add(new KeyValue<>(key, value));
	}

	/**
	* Removes the top most valuse based on it's key
	* @return the value removed or {@code null} if it is empty
	*/
	@SuppressWarnings("null")
	public V remove(){
		return this.heap.isEmpty()?null:this.heap.remove().getValue();
	}

	/**
	* Returns a string representation of the PriorityQueue
	* @return String
	* @see Heap#toString()
	*/
	@Override
	public String toString(){
		return this.heap.toString();
	}
}
