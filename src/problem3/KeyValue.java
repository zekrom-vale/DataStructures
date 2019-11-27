package problem3;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
* Class KeyValue wraps the key and value inside of an object allowing it to be used in any container without modification
 *
 * @author     Shawn Graven
 * @date       11/25/19
 *
* @param <K> They Key type, must impliment {@code Comparable<K>}
* @param <V> The Value type, due to wraping it allows this value to be null
*/
@SuppressWarnings("hiding")
public class KeyValue <@NonNull
K extends Comparable<K>, @Nullable
V> implements Comparable<KeyValue<K, V>>{
	/**
	* The Key of the KeyValue
	*/
	private K key;
	/**
	* The Value of the KeyValue
	*/
	private V value;

	/**
	* Creates a new KeyValue pair
	* @param key the key determining the order
	* @param value the value assosiated with the key
	*/
	public KeyValue(final K key, final V value){
		this.setKey(key);
		this.setValue(value);
	}
	
	/**
	* Utility method that compares the keys of two KeyValue objects
	*/
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

	/**
	* @return A string representation of the KeyValue pair
	*/
	@Override
	public String toString(){
		return "["+this.key+":"+this.value+"]";
	}
}
