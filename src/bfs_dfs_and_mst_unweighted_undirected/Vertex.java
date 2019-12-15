package bfs_dfs_and_mst_unweighted_undirected;

import org.eclipse.jdt.annotation.Nullable;

import linkedList.LinkedList;
import queue.Queue;
import queue.Stack;

class Vertex
{
	public char label;
	public LinkedList<@Nullable
	Vertex> list=new LinkedList<>();
	public boolean wasVisited=false;


	public Vertex(final char lab){
		this.label=lab;
	}

	@SuppressWarnings("null")
	public void bfs(final LinkedList<@Nullable
		Vertex> order, final Queue<@Nullable
		Vertex> queue){

		//Start at the given vertex
		//Mark
		this.wasVisited=true;
		//Append to order
		order.insertTail(this);

		this.list.forEachLeft(v->{
			if(
				v!=null&&v.getValue().wasVisited==false
				){
				queue.insert(v.getValue());
			}
		});
		Vertex next=queue.remove();
		//Make sure to not revisit
		while(next!=null&&next.wasVisited==true){
			next=queue.remove();
		}
		if(next!=null){
			next.bfs(order, queue);
		}
		else{
			order.forEachLeft(v->{
				if(v!=null&&v.getValue()!=null) v.getValue().wasVisited=false;
			});
		}
	}

	@SuppressWarnings("null")
	public void dfs(final LinkedList<@Nullable
		Vertex> order, final Stack<@Nullable
		Vertex> stack){


		//Start at the given vertex
		//Mark
		this.wasVisited=true;
		//Append to order
		order.insertTail(this);

		this.list.forEachRight(v->{
			if(v!=null&&v.getValue().wasVisited==false){
				stack.insert(v.getValue());
			}
		});
		Vertex next=stack.remove();
		//Make sure to not revisit
		while(next!=null&&next.wasVisited==true){
			next=stack.remove();
		}
		if(next!=null){
			next.dfs(order, stack);
		}
		else{
			order.forEachLeft(v->{
				if(v!=null&&v.getValue()!=null) v.getValue().wasVisited=false;
			});
		}
	}

	@SuppressWarnings("null")
	public void mstDfs(final LinkedList<@Nullable
		Vertex> order, final Stack<@Nullable
		Vertex> stack){


		//Start at the given vertex
		//Mark
		this.wasVisited=true;
		//Append to order
		order.insertTail(this);

		this.list.forEachRight(v->{
			if(v!=null&&v.getValue().wasVisited==false){
				stack.insert(v.getValue());
			}
		});
		Vertex next=stack.remove();
		//Make sure to not revisit
		while(next!=null&&next.wasVisited==true){
			next=stack.remove();
		}
		if(next!=null){
			next.mstDfs(order, stack);
		}
		else{
			order.forEachLeft(v->{
				if(v!=null&&v.getValue()!=null) v.getValue().wasVisited=false;
			});
		}
	}

	@Override
	public String toString(){
		return this.label+"";
	}
}