package problem12;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.eclipse.jdt.annotation.Nullable;

import linkedList.LinkedList;
import linkedList.Node;

/**
 * Simple wrapper to hold the vertex and linked vertexes for the adjacency list
 * 
 * @author Shawn Graven
 * @date   12/15/19
 */
public class Wrapper{

	@Nullable
	private LinkedList<@Nullable
	Vertex> list;
	public Vertex vertex;


	public Wrapper(final Vertex vertex){
		this.vertex=vertex;
	}

	/**
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj){
		return this.vertex.equals(obj);
	}

	/**
	 * @param consumer
	 * @see            linkedList.LinkedList#forEachLeft(java.util.function.Consumer)
	 */
	public void forEachLeft(final Consumer<Node<@Nullable
		Vertex>> consumer){
		this.list.forEachLeft(consumer);
	}

	/**
	 * @param op
	 * @see      linkedList.LinkedList#forEachLeft(java.util.function.UnaryOperator)
	 */
	public void forEachLeft(final UnaryOperator<Node<@Nullable
		Vertex>> op){
		this.list.forEachLeft(op);
	}

	/**
	 * @param consumer
	 * @see            linkedList.LinkedList#forEachRight(java.util.function.Consumer)
	 */
	public void forEachRight(final Consumer<Node<@Nullable
		Vertex>> consumer){
		this.list.forEachRight(consumer);
	}

	/**
	 * @param op
	 * @see      linkedList.LinkedList#forEachRight(java.util.function.UnaryOperator)
	 */
	public void forEachRight(final UnaryOperator<Node<@Nullable
		Vertex>> op){
		this.list.forEachRight(op);
	}

	/**
	 * @param  index
	 * @return
	 * @see          linkedList.LinkedList#getHead(int)
	 */
	public @Nullable
	Vertex getHead(final int index){
		return this.list.getHead(index);
	}

	/**
	 * @param  index
	 * @return
	 * @see          linkedList.LinkedCore#getHead(long)
	 */
	public @Nullable
	Vertex getHead(final long index){
		return this.list.getHead(index);
	}

	/**
	 * @return
	 * @see    linkedList.LinkedCore#getSize()
	 */
	public long getSize(){
		return this.list.getSize();
	}

	/**
	 * @param  index
	 * @return
	 * @see          linkedList.LinkedList#getTail(int)
	 */
	public @Nullable
	Vertex getTail(final int index){
		return this.list.getTail(index);
	}

	/**
	 * @param  index
	 * @return
	 * @see          linkedList.LinkedCore#getTail(long)
	 */
	public @Nullable
	Vertex getTail(final long index){
		return this.list.getTail(index);
	}

	/**
	 * @param  index
	 * @param  value
	 * @return
	 * @see          linkedList.LinkedList#insertHead(long, java.lang.Object)
	 */
	public boolean insertHead(final long index, @Nullable
		final Vertex value){
		return this.list.insertHead(index, value);
	}

	/**
	 * @param values
	 * @see          linkedList.LinkedList#insertHead(java.lang.Object[])
	 */
	public void insertHead(@Nullable
		final Vertex... values){
		this.list.insertHead(values);
	}

	/**
	 * @param value
	 * @see         linkedList.LinkedList#insertTail(java.lang.Object)
	 */
	public void insertTail(@Nullable
		final Vertex value){
		this.list.insertTail(value);
	}

	/**
	 * @param values
	 * @see          linkedList.LinkedList#insertTail(java.lang.Object[])
	 */
	public void insertTail(@Nullable
		final Vertex... values){
		this.list.insertTail(values);
	}

	/**
	 * @return
	 * @see    linkedList.LinkedCore#isEmpty()
	 */
	public boolean isEmpty(){
		return this.list.isEmpty();
	}

	/**
	 *
	 * @see linkedList.LinkedCore#print()
	 */
	public void print(){
		this.list.print();
	}

	/**
	 * @return
	 * @see    linkedList.LinkedList#removeHead()
	 */
	public @Nullable
	Vertex removeHead(){
		return this.list.removeHead();
	}

	/**
	 * @param  index
	 * @return
	 * @see          linkedList.LinkedList#removeHead(long)
	 */
	public @Nullable
	Vertex removeHead(final long index){
		return this.list.removeHead(index);
	}

	/**
	 * @return
	 * @see    linkedList.LinkedList#removeTail()
	 */
	public @Nullable
	Vertex removeTail(){
		return this.list.removeTail();
	}

	/**
	 * @param  index
	 * @return
	 * @see          linkedList.LinkedList#removeTail(long)
	 */
	public @Nullable
	Vertex removeTail(final long index){
		return this.list.removeTail(index);
	}

	/**
	 * @param  function
	 * @return
	 * @see             linkedList.LinkedList#searchLeft(java.util.function.Predicate)
	 */
	public @Nullable
	Vertex searchLeft(final Predicate<Node<@Nullable
		Vertex>> function){
		return this.list.searchLeft(function);
	}

	/**
	 * @return
	 * @see linkedList.LinkedList#size()
	 */
	public long size(){
		return this.list.size();
	}

}
