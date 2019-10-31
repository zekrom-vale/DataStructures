package problem1;

import org.eclipse.jdt.annotation.Nullable;

/**
 * Driver class tests the {@link CircularLinkedList}
 * 
 * @author Shawn Graven (Zekrom)
 * @date   10/23/19
 */
public class Driver{
	/**
	 * Main
	 *
	 * @param  args
	 *                                         Arguments
	 */
	public static void main(final String[] args){
		final CircularLinkedList<@Nullable
		Integer> list=new CircularLinkedList<>();
		list.insertTail(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		list.loopUntilHead((x, i)->{
			System.out.println(x.getPrevious()+", "+x+", "+x.getNext());
		}, 40);
		System.out.println(list);
		System.out.println(list.getSize());
		list.removeHead();
		System.out.println(list);
		System.out.println(list.getSize());
	}
}
