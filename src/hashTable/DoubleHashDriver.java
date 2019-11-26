package hashTable;

import org.eclipse.jdt.annotation.NonNull;

import tree.BianarySearchTree;

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
