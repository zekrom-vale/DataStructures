package tree;

import java.util.function.Consumer;

import org.eclipse.jdt.annotation.NonNull;

public class BianarySearchTree <@NonNull
E extends Comparable<E>>{
	private static <@NonNull
	E extends Comparable<E>> boolean
	isBianarySearchTree(final Node<E> root){
		return BianarySearchTree.isMin(
			root.getLeft(), root.getValue()
			)&&BianarySearchTree.isMax(
				root.getRight(), root.getValue()
				)&&BianarySearchTree.isBianarySearchTree(root.getRight())&&
			BianarySearchTree.isBianarySearchTree(root.getLeft());
	}

	private static <@NonNull
	E extends Comparable<E>> boolean isMax(final Node<E> root, final E value){
		if(root==null) return true;
		return root.getValue().compareTo(value)>=0&&BianarySearchTree
			.isMax(root.getLeft(), value)&&
			BianarySearchTree.isMax(root.getRight(), value);
	}

	private static <@NonNull
	E extends Comparable<E>> boolean
	isMin(final Node<E> root, final E value){
		if(root==null) return true;
		return root.getValue().compareTo(value)<0&&BianarySearchTree
			.isMin(root.getLeft(), value)&&
			BianarySearchTree.isMin(root.getRight(), value);
	}

	private final Node<E> root=null;


	public void forEach(final Consumer<E> consumer){
		this.forEach(this.root, consumer);
	}

	private void forEach(final Node<E> node, final Consumer<E> consumer){
		if(node==null) return;
		this.forEach(node.getLeft(), consumer);
		consumer.accept(node.getValue());
		this.forEach(node.getRight(), consumer);
	}

	private void forEachPost(final Node<E> node, final Consumer<E> consumer){

		if(node==null) return;
		this.forEachPost(node.getLeft(), consumer);
		this.forEachPost(node.getRight(), consumer);
		consumer.accept(node.getValue());
	}

	private void forEachPre(final Node<E> node, final Consumer<E> consumer){

		if(node==null)return;
		consumer.accept(node.getValue());
		this.forEachPre(node.getLeft(), consumer);
		this.forEachPre(node.getRight(), consumer);
	}
}

