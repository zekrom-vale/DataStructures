package hashTable;

import org.eclipse.jdt.annotation.NonNull;

import tree.BianarySearchTree;

/**
 * Class DoubleHashDriver tests the stacking feature of the HashTable by creating HashTables of HashTables of BianarySearchTrees<br>
 * This is a little to convoluted for most users to use, but it's posible
 *
 * @author     Shawn Graven
 * @date       11/26/19
 *
*/
public class DoubleHashDriver{

	public static void main(final String[] args){
		HashTable<@NonNull String, HashTable<@NonNull String, BianarySearchTree<@NonNull String>>> hashTable;
		hashTable=new HashTable<>(10, ()->{
			return new HashTable<@NonNull String, BianarySearchTree<@NonNull String>>(
				4, ()->new BianarySearchTree<@NonNull String>()
				);
		});
		final RandomString randomString=new RandomString('a', 'z', 10);
		final String[] strings=randomString.strings(30);
		for(final String s : strings){
			hashTable.add(s);
			System.out.println(hashTable);
		}
	}

}
