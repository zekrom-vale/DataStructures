package hashProbe;

import org.eclipse.jdt.annotation.NonNull;

import hashTable.RandomString;

/**
 * Class Driver tests LinearProbeHashTable
 *
 * @author Shawn Graven
 * @date   11/26/19
 * @see    String#hashCode
 */
public class Driver{

	public static void main(final String[] args){
		final HashProbe<@NonNull
		String> hash=new HashProbe<>(39);
		@SuppressWarnings("null")
		@NonNull
		final String[] strings=new RandomString('a', 'z', 20).strings(20);
		for(final String s : strings){
			hash.add(s);
			System.out.println(hash);
		}
		for(final String s : strings){
			System.out.print(hash.exists(s)?"Exists:   ":"Does not: ");
			System.out.println(s);
		}
		System.out.print(hash.exists("!@#$%^&*()_+")?"Exists:   ":"Does not: ");
		System.out.println("!@#$%^&*()_+");


		for(final String s : strings){
			System.out.println(hash.remove(s));
			System.out.println(hash);
		}
	}

}
