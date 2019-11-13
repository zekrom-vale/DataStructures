package tree;

import java.util.function.Consumer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Class BianarySearchTree
 *
 * @author     Zekrom
 *
 * @param  <E>
 *                 The type of the BianarySearchTree
 * @see        #countNodes()
 * @see        #countLeaves()
 * @see        #height()
 */
public class BianarySearchTree <@NonNull
E extends Comparable<E>>{

	/**
	 * Loops through the BianarySearchTree
	 * @param node the root node of the current tree or sub-tree
	 * @param consumer The function to perform on each node
	 */
	private  static <@NonNull E extends Comparable<E>>void forEachPost(final Node<E> node, final Consumer<E> consumer){
		if(node==null) return;
		BianarySearchTree.forEachPost(node.getLeft(), consumer);
		BianarySearchTree.forEachPost(node.getRight(), consumer);
		consumer.accept(node.getValue());
	}

	/**
	 * Loops through the BianarySearchTree
	 * @param node the root node of the current tree or sub-tree
	 * @param consumer The function to perform on each node
	 */
	private  static <@NonNull E extends Comparable<E>>void forEachPre(final Node<E> node, final Consumer<E> consumer){

		if(node==null)return;
		consumer.accept(node.getValue());
		BianarySearchTree.forEachPre(node.getLeft(), consumer);
		BianarySearchTree.forEachPre(node.getRight(), consumer);
	}


	/**
	 * Tests if the node is a valid BianarySearchTree
	 *
	 * @param  <E>
	 *                  The type of the node
	 * @param  root
	 *                  The current root of the tree or sub-tree
	 * @return      {@code true} if valid, {@code false} if invalid
	 */
	private static <@NonNull
	E extends Comparable<E>> boolean isBianarySearchTree(final @Nullable Node<E> root){
		if(root==null)return true;

		//Check to see if the sub trees are valid BianarySearchTrees
		if(
			!BianarySearchTree.isBianarySearchTree(root.getRight())
			) return false;
		if(
			BianarySearchTree.isBianarySearchTree(root.getLeft())
			) return false;


		//We know that the sub trees are valid BianarySearchTrees so check the tree
		//Valid if left sub-tree max is less than the root
		if(
			root.getLeft()!=null&&root.compareTo(root.getRight())<=0
			) return false;
		//Valid if right sub-tree min is greater or equal to the root
		if(
			root.getRight()!=null&&root.compareTo(root.getLeft())>0
			) return false;
		return true;
	}

	private static <@NonNull
	E extends Comparable<E>> boolean isMax(final Node<E> root, final E value){
		if(root==null) return true;
		if(root.getValue().compareTo(value)<0) return false;
		if(!BianarySearchTree.isMax(root.getLeft(), value)) return false;
		return BianarySearchTree.isMax(root.getRight(), value);
	}


	private static <@NonNull
	E extends Comparable<E>> boolean
	isMin(final Node<E> root, final E value){
		if(root==null) return true;
		if(root.getValue().compareTo(value)>=0) return false;
		if(!BianarySearchTree.isMin(root.getLeft(), value)
			) return false;
		return BianarySearchTree.isMin(root.getRight(), value);
	}

	@Nullable
	private Node<E> root=null;


	/**
	 * Default Constructor
	 *
	 */
	public BianarySearchTree(){
		//Do nothing
	}

	/**
	 * Counts the amount of leaves in the tree<br>
	 * The nodes that do not have children
	 *
	 * @return the number of leaves
	 * @see    tree.Node#countLeaves()
	 */
	@SuppressWarnings("null")
	public long countLeaves(){
		if(this.root==null)return 0;
		return this.root.countLeaves();
	}

	/**
	 * Counts the amount of internal nodes in the tree<br>
	 * The nodes that do have children
	 *
	 * @return the number of internal nodes
	 * @see    tree.Node#countNodes()
	 */
	@SuppressWarnings("null")
	public long countNodes(){
		if(this.root==null)return 0;
		return this.root.countNodes();
	}

	/**
	 * Loops through the BianarySearchTree in order
	 * @param consumer The function to perform on each node
	 */
	@SuppressWarnings("null")
	public void forEach(final Consumer<Node<E>> consumer){
		if(this.root==null){
			return;
		}
		this.root.forEach(consumer);
	}


	/**
	 * Loops through the BianarySearchTree
	 * @param consumer The function to perform on each node
	 */
	public void forEachPost(final Consumer<E> consumer){
		BianarySearchTree.forEachPost(this.root, consumer);
	}


	/**
	 * Loops through the BianarySearchTree
	 * @param consumer The function to perform on each node
	 */
	public void forEachPre(final Consumer<E> consumer){
		BianarySearchTree.forEachPre(this.root, consumer);
	}

	/**
	 * Returns the height of the tree<br>
	 * The deepest node's depth plus 1
	 *
	 * @return The height of the tree
	 * @see    tree.Node#height()
	 */
	@SuppressWarnings("null")
	public long height(){
		if(this.root==null)return 0;
		return this.root.height();
	}

	/**
	 * Inserts the value in the appropriate spot in the tree
	 *
	 * @param value
	 *                  The value to insert
	 * @see         tree.Node#insert(java.lang.Comparable)
	 */
	@SuppressWarnings("null")
	public void insert(@NonNull
		final
		E value){
		if(this.root==null) this.root=new Node<>(value);
		else this.root.insert(value);
	}

	/**
	 * Inserts the value in the appropriate spot in the tree
	 *
	 * @param values
	 *                   The values to insert
	 * @see          tree.Node#insert(java.lang.Comparable)
	 */
	@SuppressWarnings("unchecked")
	public void insert(@NonNull
		final E... values){
		for(int i=0; i<values.length; i++){
			this.insert(values[i]);
		}
	}

	/**
	 * Tests if the node is a valid BianarySearchTree
	 *
	 * @return {@code true} if valid, {@code false} if invalid
	 */
	public boolean isBianarySearchTree(){
		return BianarySearchTree.isBianarySearchTree(this.root);
	}

	/**
	 * Removes the given value
	 *
	 * @param  value
	 *                   The value to remove
	 * @return       {@code true} if it exists and was removed {@code false} if it is not found
	 * @see          tree.Node#remove2(java.lang.Comparable)
	 */
	@SuppressWarnings("null")
	public boolean remove(@NonNull
		final
		E value){
		if(this.root==null) return false;
		return this.root.remove(value);
	}

	@Override
	public String toString(){
		final StringBuilder builder=new StringBuilder(
			(int)(this.countNodes()*5)
			);
		builder.append("BianarySearchTree [");
		this.forEach(x->{
			builder.append(x).append(", ");
		});
		return new StringBuilder(builder.substring(0, builder.length()-2))
			.append(']').toString();
	}
}

