package stackList;

import org.eclipse.jdt.annotation.Nullable;

/**
 * Driver class, tests the {@link Stack} class
 *
 * @author Shawn Graven
 * @date   10/29/19
 */
public class Driver{
	/**
	 * Main method
	 *
	 * @param args
	 *                 Arguments
	 */
	public static void main(final String[] args){
		final Stack<@Nullable
		Integer> stack=new Stack<>(1, 2, 3, 4, 5, 6, 7, 8, 9);
		stack.push(-10);
		stack.push(-11);
		stack.push(-12);
		stack.print();
		//Remove each element and print it out
		while(!stack.isEmpty()){
			System.out.println(stack.peek());
			System.out.println(stack.pop());
			stack.print();
		}
		System.out.println(stack.pop());
	}
}
