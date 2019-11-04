package tree;

import org.eclipse.jdt.annotation.NonNull;

@SuppressWarnings("hiding")
public class Node<@Nonnull E extends Comparable<E>>{
	@Nonnull
	E value;
	
	@Nullable
	Node<E> right;
	
	@Nullable
	Node<E> left;
	
	public Node(Node<E> left, E value, Node<E> right){
		this.left=left;
		this.value=value;
		this.right=right;
	}
	
	public Node(E value){
		this(null, value, null);
	}
	
	public Node(Node<E> left, E value){
		this(left, value, null);
	}
	
	public Node(E value, Node<E> right){
		this(null, value, right);
	}
	
	protected void insert(E value){
		if(this.value.compareTo(value)<0){
			if(this.left==null){
				this.left=new Node(value);
				return;
			}
			this.left.insert(value);
			return;
		}
		if(this.right==null){
			this.right=new Node(value);
			return;
		}
		this.right.insert(value);
	}
	
	protected boolean remove(E value){
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
	
	protected void removeRight(@Nonnull Node<E> parent){
		parent.right=this.right;
		this.leftMost().left=this.left;
	}
	
	protected void removeLeft(@Nonnull Node<E> parent){
		parent.left=this.right;
		this.leftMost().left=this.left;
	}
	
	public Node<E> leftMost(){
		if(this.left==null)return this;
		return this.left.leftMost();
	}
	
	public Node<E> rightMost(){
		if(this.right==null)return this;
		return this.right.rightMost();
	}
	
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
	
	public long height(){
		if(this.right==null){
			if(this.left==null)return 1;
			return this.left.height()+1;
		}
		if(this.left==null)return this.right.height()+1;
		return Math.max(this.left.height(), this.right.height())+1;
	}
}
