
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
	
	protected void insert(@Nonnull Node<E> root, E value){
		if(this.root.value.compareTo(value)<0){
			if(this.root.left==null){
				this.root.left=new Node(value);
				return;
			}
			this.insert(root.left, value);
			return;
		}
		if(this.root.right==null){
			this.root.right=new Node(value);
			return;
		}
		this.insert(root.right, value);
	}
	
	protected boolean remove(@Nonnull Node<E> root, E value){
		if(this.root.value.compareTo(value)<0){
			if(this.root.left==null)return false;
			if(this.root.left.value.compareTo(value)==0){
				this.remove(root.left, root);
				return true;
			}
			return this.remove(root.left, value);
		}
		else{
			if(this.root.right==null)return false;
			if(this.root.right.value.compareTo(value)==0){
				this.remove(root.right, root);
				return true;
			}
			return this.remove(root.right, value);
		}
	}
	
	protected void remove(@Nonnull Node<E> node, @Nonnull Node<E> parent){
		
	}
}
