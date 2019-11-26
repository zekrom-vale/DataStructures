package heap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

@SuppressWarnings("hiding")
public class KeyValue <@NonNull
K extends Comparable<K>, @Nullable
V> implements Comparable<KeyValue<K, V>>{
	private K key;
	private V value;


	public KeyValue(final K key, final V value){
		this.setKey(key);
		this.setValue(value);
	}

	@Override
	public int compareTo(final KeyValue<K, V> kV){
		return this.key.compareTo(kV.key);
	}

	/**
	 * @return the key
	 */
	public K getKey(){
		return this.key;
	}

	/**
	 * @return the value
	 */
	public V getValue(){
		return this.value;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(final K key){
		this.key = key;
	}

	/**
	 * @param value
	 *                  the value to set
	 */
	public void setValue(final V value){
		this.value=value;
	}

	@Override
	public String toString(){
		return "["+this.key+":"+this.value+"]";
	}
}
