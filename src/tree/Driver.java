package tree;

import org.eclipse.jdt.annotation.NonNull;

public class Driver{

	public static void main(final String[] args){
		final BianarySearchTree<@NonNull
		Integer> tree=new BianarySearchTree<>();
		tree.insert(50, 70, 30, 80, 34, 32, 9, 47, 18);
		System.out.println(tree);
	}

}
