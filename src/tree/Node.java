package tree;

import java.util.function.Consumer;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * @author     Zekrom
 *
 * @param  <E>
 *                 The type of the node
 * @see        #countNodes()
 * @see        #countInternalNodes()
 * @see        #countLeaves()
 * @see        #height()
 */
@SuppressWarnings("hiding")
public class Node <@NonNull
E extends Comparable<E>> implements Comparable<Node<E>>{
	/**
	 * The left subtree
	 */
	@Nullable
	private Node<E> left;

	/**
	 * The right subtree
	 */
	@Nullable
	private Node<E> right;

	/**
	 * The value of the current node
	 */
	@NonNull
	private E value;


	/**
	 * Default Constructor
	 *
	 * @param value
	 *                  The value of the node
	 */
	public Node(final E value){
		this(null, value, null);
	}

	/**
	 * Alternate Constructor
	 *
	 * @param left
	 *                  The left Node
	 *
	 * @param value
	 *                  The value of the node
	 * @param right
	 *                  The right Node
	 */
	public Node(final Node<E> left, final E value, final Node<E> right){
		this.left=left;
		this.value=value;
		this.right=right;
	}

	/**
	 * Allows comparison without calling the values if a value is known<br>
	 * Utility method
	 *
	 * @param  value
	 *                   The value to compare with the nodes value
	 * @return       integer
	 */
	public int compareTo(final E value){
		return this.value.compareTo(value);
	}

	/**
	 * Allows comparison without calling the values<br>
	 * Utility method
	 *
	 * @param  node
	 *                  The node to compare with the nodes value
	 * @return      integer
	 */
	@Override
	public int compareTo(final Node<@NonNull
		E> node){
		return this.value.compareTo(node.value);
	}


	/**
	 * Counts the amount of internal nodes in the tree<br>
	 * The nodes that do have children
	 *
	 * @return the number of internal nodes
	 */
	@SuppressWarnings("null")
	public long countInternalNodes(){

		if(this.right!=null){
			if(this.left!=null){
				return this.left.countInternalNodes()+1+
					this.right.countInternalNodes();
			}
			return this.right.countInternalNodes()+1;
		}
		if(this.left!=null){
			return this.left.countInternalNodes()+1;
		}
		return 0;
	}

	/**
	 * Counts the amount of leaves in the tree<br>
	 * The nodes that do not have children
	 *
	 * @return the number of leaves
	 */
	@SuppressWarnings("null")
	public long countLeaves(){
		if(this.right!=null){
			if(this.left!=null){
				return this.left.countLeaves()+this.right.countLeaves();
			}
			return this.right.countLeaves();
		}
		if(this.left!=null){
			return this.left.countLeaves();
		}
		return 1;
	}

	/**
	 * Counts the amount of nodes in the tree
	 *
	 * @return the number of internal nodes
	 */
	@SuppressWarnings("null")
	public long countNodes(){

		if(this.right!=null){
			if(this.left!=null){
				return this.left.countNodes()+1+this.right.countNodes();
			}
			return this.right.countNodes()+1;
		}
		if(this.left!=null){
			return this.left.countNodes()+1;
		}
		return 1;
	}

	/**
	 * Tests if two nodes are equal
	 *
	 * @param  obj
	 *                 The other node
	 * @return     {@code true} if they are the same
	 */
	public boolean equals(final Node<E> obj){
		return this.value.equals(obj.value);
	}

	/**
	 * Tests if this node's value is equal to a value
	 *
	 * @param  obj
	 *                 The other node
	 * @return     {@code true} if they are the same
	 */
	@Override
	public boolean equals(final Object obj){
		return this.value.equals(obj);
	}

	/**
	 * Checks if the value exists in the tree
	 *
	 * @param  value
	 *                   The value to check for
	 * @return       {@code true} if it exists
	 */
	@SuppressWarnings("null")
	public boolean exists(final E value){
		if(this.value.compareTo(value)==0) return true;

		if(this.value.compareTo(value)<0){
			if(this.left==null) return false;
			return this.left.exists(value);
		}
		if(this.right==null) return false;
		return this.right.exists(value);
	}

	/**
	 * Finds the value in the tree and returns the node
	 *
	 * @param  value
	 *                   The value to find
	 * @return       The first node containing the value, {@code null} if not found
	 */
	@SuppressWarnings("null")
	public Node<E> find(final E value){
		if(this.value.compareTo(value)==0) return this;

		if(this.value.compareTo(value)<0){
			if(this.left==null) return null;
			return this.left.find(value);
		}
		if(this.right==null) return null;
		return this.right.find(value);
	}

	/**
	 * Iterates through the tree in order
	 *
	 * @param consumer
	 *                     The operation to do on each node
	 */
	public void forEach(final Consumer<Node<E>> consumer){
		if(this.right!=null) this.right.forEach(consumer);
		consumer.accept(this);
		if(this.left!=null) this.left.forEach(consumer);
	}

	/**
	 * @return the left
	 */
	public Node<E> getLeft(){
		return this.left;
	}

	/**
	 * @return the right
	 */
	public Node<E> getRight(){
		return this.right;
	}

	/**
	 * @return the value
	 */
	public E getValue(){
		return this.value;
	}

	/**
	 * @return The hashcode of the object
	 */
	@Override
	public int hashCode(){
		return this.value.hashCode();
	}

	/**
	 * Returns the height of the tree<br>
	 * The deepest node's depth plus 1
	 *
	 * @return The height of the tree
	 */
	@SuppressWarnings("null")
	public long height(){
		if(this.right==null){
			if(this.left==null) return 1;
			return this.left.height()+1;
		}
		if(this.left==null) return this.right.height()+1;
		return Math.max(this.left.height(), this.right.height())+1;
	}

	/**
	 * Inserts the value in the appropriate spot in the tree
	 *
	 * @param value
	 *                  The value to add
	 */
	@SuppressWarnings("null")
	public void insert(final E value){
		if(this.value.compareTo(value)<0){
			if(this.left==null){
				this.left=new Node<>(value);
				return;
			}
			this.left.insert(value);
			return;
		}
		if(this.right==null){
			this.right=new Node<>(value);
			return;
		}
		this.right.insert(value);
	}

	/**
	 * Inserts the node in the appropriate spot in the tree
	 *
	 * @param   node
	 *                   The node to add
	 * @apiNote      Does not check if the subtree is a valid binary search tree
	 */
	@SuppressWarnings("null")
	public void insert(final Node<E> node){
		if(this.compareTo(node)<0){
			if(this.left==null){
				this.left=node;
				return;
			}
			this.left.insert(node);
			return;
		}
		if(this.right==null){
			this.right=node;
			return;
		}
		this.right.insert(node);
	}

	/**
	 * Checks if the node and dependents are valid BianarySearchTrees
	 *
	 * @return {@code true} if valid, {@code false} if invalid
	 */
	public boolean isValid(){
		//Check to see if the sub trees are valid BianarySearchTrees
		if(this.right!=null&&!this.right.isValid()) return false;
		if(this.left!=null&&!this.left.isValid()) return false;

		//We know that the sub trees are valid BianarySearchTrees so check the tree
		//Valid if left sub-tree max is less than the root
		if(
			this.getLeft()!=null&&this.compareTo(this.getRight())<=0
			) return false;
		//Valid if right sub-tree min is greater or equal to the root
		if(
			this.getRight()!=null&&this.compareTo(this.getLeft())>0
			) return false;

		return false;
	}

	/**
	 * Gets the right most node
	 *
	 * @return The maximum node
	 */
	@SuppressWarnings("null")
	public Node<E> max(){
		if(this.right==null) return this;
		return this.right.max();
	}

	/**
	 * Gets the left most node
	 *
	 * @return The minimum node
	 */
	@SuppressWarnings("null")
	public Node<E> min(){
		if(this.left==null) return this;
		return this.left.min();
	}

	/**
	 * Removes the given value
	 *
	 * @param  value
	 *                   The value to remove
	 * @return       {@code true} if it exists and was removed {@code false} if it is not found
	 *               Referenced
	 *               https://www.java2novice.com/java-interview-programs/delete-node-binary-search-tree-bst/
	 */
	@SuppressWarnings("null")
	public Node<E> remove(final E value){
		if(this.compareTo(value)>0){
			this.left=this.left.remove(value);
		}
		else if(this.compareTo(value)<0){
			this.right=this.right.remove(value);
		}
		else{
			// node with no leaf nodes
			if(this.left==null&&this.right==null){
				return null;
			}
			else if(this.left==null){
				// node with one node (no left node)
				return this.right;
			}
			else if(this.right==null){
				// node with one node (no right node)
				return this.left;
			}
			else{
				// nodes with two nodes
				// search for min number in right sub tree
				this.value=this.right.min().value;
				this.right=this.right.remove(this.value);
			}
		}
		return this;
	}

	/**
	 * @param left
	 *                 the left to set
	 */
	public void setLeft(final Node<E> left){
		this.left=left;
	}

	/**
	 * @param right
	 *                  the right to set
	 */
	public void setRight(final Node<E> right){
		this.right=right;
	}

	/**
	 * @param value
	 *                  the value to set
	 */
	public void setValue(final E value){
		this.value=value;
	}

	/**
	 * Returns a string representation of the node's value
	 */
	@Override
	public String toString(){
		return this.value.toString();
	}
}
