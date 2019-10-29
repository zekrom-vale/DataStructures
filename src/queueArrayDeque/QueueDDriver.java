/**
 *
 */
package queueArrayDeque;

/**
 * Class QueueDDriver<br>
 * Tests the {@link QueueD} class
 *
 * @author Shawn Graven
 * @date   10/14/19
 *
 */
public class QueueDDriver{

	/**
	 * Main method
	 *
	 * @param args
	 *                 Arguments
	 */
	public static void main(final String[] args){
		final QueueD<Integer> queueD=new QueueD<>(10, true);
		System.out.println(queueD.push(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
		queueD.print();
		//Empty out the Queue until it's empty
		while(!queueD.isEmpty()){
			System.out.println(queueD.pop());
			queueD.print();
			queueD.printRaw();
		}
	}

}
