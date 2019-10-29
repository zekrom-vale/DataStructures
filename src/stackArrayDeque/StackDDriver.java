package stackArrayDeque;

/**
 * Class QueueDDriver<br>
 * Tests the {@link StackD} class
 *
 * @author Shawn Graven
 * @date   10/14/19
 *
 */
public class StackDDriver{

	/**
	 * Main method
	 *
	 * @param args
	 *                 Arguments
	 */
	public static void main(final String[] args){
		final StackD<Integer> stackD=new StackD<>(10, true);
		System.out.println(stackD.push(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
		stackD.print();
		//Empty out the stack
		while(!stackD.isEmpty()){
			System.out.println(stackD.pop());
			stackD.print();
			stackD.printRaw();
		}
	}

}
