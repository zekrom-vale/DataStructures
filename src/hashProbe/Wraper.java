package hashProbe;

import org.eclipse.jdt.annotation.Nullable;

public class Wraper <@Nullable
E>{
	public E value;


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

	public boolean isNull(){
		return this.value==null;
	}

	public void setNull(){
		this.value=null;
	}

	@Override
	public String toString(){
		if(this.isNull()) return "*";
		return this.value.toString();
	}
}
