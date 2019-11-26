package hashTable;

import java.util.Random;

public class RandomString{
	private final int delta;
	private final int maxSize;
	private final int offset;
	private final Random random=new Random();

	public RandomString(final int min, final int max, final int maxSize){
		this.offset=min;
		this.delta=max-min;
		this.maxSize=maxSize;
	}

	private char genChar(){
		return (char)(this.random.nextDouble()*this.delta+
			this.offset);
	}

	public String string(){
		final StringBuilder builder=new StringBuilder(this.delta);
		for(int i=(int)(this.random.nextDouble()*this.maxSize); i>=0; i--){
			builder.append(this.genChar());
		}
		return builder.toString();
	}

	public String[] strings(final int ammount){
		final String[] strings=new String[ammount];
		for(int i=0; i<ammount; i++){
			strings[i]=this.string();
		}
		return strings;
	}
}
