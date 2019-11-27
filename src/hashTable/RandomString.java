package hashTable;

import java.util.Random;

/**
 * Class RandomString generates a random string given the range and max length
 *
 * @author Shawn Graven
 * @date   11/26/19
 */
public class RandomString{
	private final int delta;
	private final int maxSize;
	private final int offset;
	private final Random random=new Random();


	/**
	 * Creates a new RandomString Generator
	 *
	 * @param min
	 *                    The minimum character value
	 * @param max
	 *                    The maximum character value
	 * @param maxSize
	 *                    The maximum size of the string
	 */
	public RandomString(final int min, final int max, final int maxSize){
		this.offset=min;
		this.delta=max-min;
		this.maxSize=maxSize;
	}

	/**
	 * @return A random character
	 */
	private char genChar(){
		return (char)(this.random.nextInt(this.delta)+
			this.offset);
	}

	/**
	 * Generates a random string
	 * 
	 * @return The random string
	 */
	public String string(){
		final StringBuilder builder=new StringBuilder(this.delta);
		for(int i=(this.random.nextInt(this.maxSize)); i>=0; i--){
			builder.append(this.genChar());
		}
		return builder.toString();
	}

	/**
	 * Randomly generates a number of strings
	 * 
	 * @param  ammount
	 *                     The amount to generate
	 * @return         An array of random strings
	 */
	public String[] strings(final int ammount){
		final String[] strings=new String[ammount];
		for(int i=0; i<ammount; i++){
			strings[i]=this.string();
		}
		return strings;
	}
}
