package heap;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
/**
 * Class PriorityDriver tests the PriorityQueue
 * @author     Shawn Graven
 * @date       11/25/19
 *
 * @see PriorityQueue
 * @see Heap
 */
public class PriorityDriver{
	public static void main(final String[] args){
		final PriorityQueue<@NonNull
		Integer, @Nullable
		String> queue=new PriorityQueue<>(10);
		queue.add(3, "b");
		queue.add(2, "c");
		queue.add(-3, "h");
		queue.add(6, "-b");
		queue.add(4, "a");
		queue.add(-2, "g");
		queue.add(7, "-c");
		queue.add(0, "e");
		queue.add(1, "d");
		queue.add(5, "-a");
		queue.add(-1, "f");
		String value="";
		while(value!=null){
			System.out.println(queue);
			value=queue.remove();
			System.out.println(value);
		}
	}
}
