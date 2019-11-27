package problem1;

import org.eclipse.jdt.annotation.Nullable;

/**
 * Class Wraper wraps an object allowing it to be null without actually being null<br>
 * This is a way to avoid magic values and to implement it with generics
 *
 * @author     Shawn Graven
 * @date       11/26/19
 *
 * @param  <E>
 *                 The type that is wraped
 */
@SuppressWarnings("hiding")
public class Wraper <@Nullable
E>{
	/**
	 * The value to be stored, this is not encapsulated to to provide easy access
	 */
	public E value;


	/**
	 * Creates a new wraper of the value
	 *
	 * @param value
	 *                  The value to wrap
	 */
	public Wraper(final E value){
		this.value=value;
	}

	@Override
	@SuppressWarnings("null")
	public boolean equals(final Object obj){
		if(this.value==null||obj==null)return false;
		return this.value.equals(obj);
	}

	@SuppressWarnings("null")
	public boolean equals(final Wraper<E> obj){
		if(this.value==null||obj.value==null)return false;
		return this.value.equals(obj.value);
	}

	/**
	 * Returns the hash code of the value
	 */
	@SuppressWarnings("null")
	@Override
	public int hashCode(){
		if(this.value==null) return 0;
		return this.value.hashCode();
	}

	/**
	 * @return weather or no the value is null
	 */
	public boolean isNull(){
		return this.value==null;
	}

	/**
	 * Sets the value to null
	 */
	public void setNull(){
		this.value=null;
	}

	@Override
	public String toString(){
		if(this.isNull()) return "*";
		return this.value.toString();
	}
}
