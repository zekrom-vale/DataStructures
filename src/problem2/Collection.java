package problem2;

import org.eclipse.jdt.annotation.Nullable;
/**
 * Interface Collection creates a shared interface that can be used with the HashTable
 *
 * @author     Shawn Graven
 * @date       11/23/19
 *
 * @param <E> The type of the value it holds
*/
public interface Collection <E>{
	boolean add(E value);

	boolean exists(E value);

	@Nullable
	E remove(E value);
}
