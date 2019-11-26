package hashProbe;

import org.eclipse.jdt.annotation.NonNull;

import hashTable.RandomString;

/**
 * @author Zekrom
 * @see    String#hashCode
 */
public class Driver{

	public static void main(final String[] args){
		final HashProbe<@NonNull
		String> hash=new HashProbe<>(39);
		@NonNull
		final String[] strings=new RandomString('a', 'z', 20).strings(20);
		for(final String s : strings){
			hash.add(s);
			System.out.println(hash);
		}
		for(final String s : strings){
			System.out.println(hash.exists(s));
		}
		System.out.println(hash.exists("asd"));


		for(final String s : strings){
			System.out.println(hash.remove(s));
			System.out.println(hash);
		}
	}

}
