package hashTable;

import java.util.Arrays;

import org.eclipse.jdt.annotation.NonNull;

import tree.BianarySearchTree;

public class Driver{

	public static void main(final String[] args){
		HashTable<@NonNull String, HashTable<@NonNull String, BianarySearchTree<@NonNull String>>> hashTable;
		hashTable=new HashTable<>(10, ()->{
			return new HashTable<@NonNull String, BianarySearchTree<@NonNull String>>(
				4, ()->new BianarySearchTree<@NonNull String>()
				);
		});
		RandomString randomString=new RandomString(0x61, 0x7A, 10);
		final String[] strings=randomString.strings(30);
		System.out.println(Arrays.toString(strings));
		for(final String s : strings){
			hashTable.add(s);
			System.out.println(hashTable);
		}
	}

}
