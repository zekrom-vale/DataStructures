package arrayDeque;

/**
 * Driver class<br>
 * Defines a main method that tests the {@link ArrayDeque} class
 *
 * @author Shawn Graven
 * @date   10/10/19
 *
 */
public class Driver{

	/**
	 * @param args
	 *                 Arguments
	 */
	public static void main(final String[] args){
		final ArrayDeque<Integer> deque=new ArrayDeque<>(10);
		deque.insertRight(2, 3, 4, 5, 6, 7, 8);
		System.out.println(deque);

		System.out.println(deque.deleteRight());
		deque.print();

		System.out.println(deque.deleteLeft());
		deque.print();

		System.out.println(deque.insertLeft(-1, -2, -3, -4, -5, -6));

		deque.print();
		deque.printRaw();

		System.out.println(deque.size());

		while(!deque.isEmpty()){
			System.out.println(deque.deleteLeft());
			deque.print();

			System.out.println(deque.deleteRight());
			deque.print();
		}

		deque.flush();
		deque.printRaw();
	}

}
