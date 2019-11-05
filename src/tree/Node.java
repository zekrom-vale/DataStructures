package tree;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * @author     Zekrom
 *
 * @param  <E>
 *                 The type of the node
 */
@SuppressWarnings("hiding")
public class Node <@NonNull
E extends Comparable<E>> implements Comparable<Node<E>>{
	@Nullable
	Node<E> left;

	@Nullable
	Node<E> right;

	@NonNull
	E value;


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

	@Override
	public int compareTo(final Node<@NonNull
		E> node){
		return this.value.compareTo(node.value);
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
	 * Counts the amount of internal nodes in the tree<br>
	 * The nodes that do have children
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
		return 0;
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
	 * Returns the height of the tree<br>
	 * The deepest node's depth plus 1
	 *
	 * @return The height of the tree
	 */
	@SuppressWarnings("null")
	public long height(){
		if(this.right==null){
			if(this.left==null)return 1;
			return this.left.height()+1;
		}
		if(this.left==null)return this.right.height()+1;
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
	 * Gets the left most node
	 *
	 * @return The minimum node
	 */
	@SuppressWarnings("null")
	public Node<E> leftMost(){
		if(this.left==null)return this;
		return this.left.leftMost();
	}

	/**
	 * Removes the given value
	 *
	 * @param  value
	 *                   The value to remove
	 * @return       {@code true} if it exists and was removed {@code false} if it is not found
	 */
	@SuppressWarnings("null")
	public boolean remove(final E value){
		if(this.value.compareTo(value)<0){
			if(this.left==null)return false;
			if(this.left.value.compareTo(value)==0){
				this.left.removeLeft(this);
				return true;
			}
			return this.left.remove(value);
		}
		else{
			if(this.right==null)return false;
			if(this.right.value.compareTo(value)==0){
				this.right.removeRight(this);
				return true;
			}
			return this.right.remove(value);
		}
	}

	/**
	 * Removes the current node from the parent
	 *
	 * @param parent
	 *                   The parent of the node
	 */
	protected void removeLeft(@NonNull
		final Node<E> parent){
		parent.left=this.right;
		this.leftMost().left=this.left;
	}

	/**
	 * Removes the current node from the parent
	 *
	 * @param parent
	 *                   The parent of the node
	 */
	protected void removeRight(@NonNull
		final Node<E> parent){
		parent.right=this.right;
		this.leftMost().left=this.left;
	}

	/**
	 * Gets the right most node
	 *
	 * @return The maximum node
	 */
	@SuppressWarnings("null")
	public Node<E> rightMost(){
		if(this.right==null) return this;
		return this.right.rightMost();
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
}
