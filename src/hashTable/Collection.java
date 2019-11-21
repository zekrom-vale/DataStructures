package hashTable;

import org.eclipse.jdt.annotation.Nullable;

public interface Collection <E>{
	boolean add(E value);

	boolean exists(E value);

	@Nullable
	E remove(E value);
}
