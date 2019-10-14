package stack;

/**
 * Defines the Delim class to check delimiters
 * 
 * @author Zekrom
 *
 */
public class Delim{
	/**
	 * Checks if all delimiters have a matching pair
	 *
	 * @param  string
	 *                    The string to test
	 * @return        {@code true} if valid {@code false} otherwise
	 */
	public static boolean check(final String string){
		final Stack<Character> stack=new Stack<>();
		for(int i=0; i<string.length(); i++){
			final char c=string.charAt(i);
			if(c=='{'||c=='['||c=='(') stack.push(c);
			if(c=='}'||c==']'||c==')'){
				if(stack.peek()==null) return false;
				final char k=stack.peek();
				if(
					(k=='{'&&c=='}')||(k=='['&&c==']')||(k=='('&&c==')')
					){
					stack.pop();
				}
				else return false;
			}
		}
		return stack.isEmpty();
	}

	/**
	 * @param args
	 *                 Command line arguments
	 */
	public static void main(final String[] args){
		System.out.println(Delim.check("132{123]312(fsd)"));
		System.out.println(Delim.check("132{123}312(fsd)"));
		System.out.println(Delim.check("132{123}312(fsd){s"));
		System.out.println(Delim.check("132{123}312(fsd){{}"));
		System.out.println(Delim.check("132};{"));
	}

}
