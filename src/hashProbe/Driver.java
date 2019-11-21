package hashProbe;

import org.eclipse.jdt.annotation.NonNull;

/**
 * @author Zekrom
 * @see    String#hashCode
 */
public class Driver{

	public static void main(final String[] args){
		final HashProbe<@NonNull
		String> hash=new HashProbe<>(8);
		@NonNull
		final String[] strings={"abc", "bcd", "", "cde", "xyz", "zdw"};
		for(final String s : strings){
			hash.add(s);
			System.out.println(hash);
		}
		for(final String s : strings){
			System.out.println(hash.exists(s));
		}
		System.out.println(hash.exists("asd"));
	}

}
