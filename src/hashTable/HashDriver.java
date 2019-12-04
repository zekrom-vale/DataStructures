package hashTable;

import org.eclipse.jdt.annotation.NonNull;

import tree.BianarySearchTree;

public class HashDriver{
	public static void main(final String[] args){
		@SuppressWarnings("unused")
		final
		HashTable<@NonNull
		String, BianarySearchTree<@NonNull
		String>> hashTable=new HashTable<>(3, ()->{
			return new BianarySearchTree<@NonNull String>();
		});

		final RandomString randomString=new RandomString('a', 'z', 10);
		for(final String s : randomString.strings(30)){
			hashTable.add(s);
			System.out.println(hashTable);
		}
	}
}