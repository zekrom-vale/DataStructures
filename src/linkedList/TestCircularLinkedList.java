package linkedList;

import org.eclipse.jdt.annotation.Nullable;

/**
 * @author Shawn Graven (Zekrom)
 * @date   10/23/19
 */
public class TestCircularLinkedList{
	/**
	 * Main
	 *
	 * @param  args
	 *                                         Arguments
	 * @throws LengthRootMishatchException
	 *                                         E
	 */
	public static void main(final String[] args)
		throws LengthRootMishatchException{
		final CircularLinkedList<@Nullable
		Integer> list=new CircularLinkedList<>();
		list.insertPrevious(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		list.loopUntilNext((x, i)->{
			System.out.println(x.getPrevious()+", "+x+", "+x.getNext());
		}, 40);
		System.out.println(list);
		list.removeRootNext();
		System.out.println(list);
	}
}
