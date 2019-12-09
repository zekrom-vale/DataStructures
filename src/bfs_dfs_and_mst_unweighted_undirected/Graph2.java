package bfs_dfs_and_mst_unweighted_undirected;



import org.eclipse.jdt.annotation.Nullable;

import linkedList.LinkedList;
import queue.Queue;
import queue.Stack;

/*
 * demonstrates depth-first search (DFS), breath-first search (BFS),
 * 	and minimum spanning tree (MST)
 */
class Graph2
{
	private final Queue<@Nullable
	Vertex> queue=new Queue<>();
	private final int size=0;          // current number of vertices
	private final Stack<@Nullable
	Vertex> stack=new Stack<>();
	/**
	 * list of vertices<br>
	 * Also includes the adjacency list
	 */
	private final LinkedList<@Nullable
	Vertex> vertexList=new LinkedList<>();

	public Graph2(){
		//Do nothing
	}

	public void addEdge(final Vertex vertex1, final Vertex vertex2){
		vertex1.list.insertTail(vertex2);
		vertex2.list.insertTail(vertex1);
	}

	public void addVertex(final char lab)
	{
		this.vertexList.insertTail(new Vertex(lab));
	}

	public void bfs(final Vertex vertex){
		final LinkedList<@Nullable Vertex> order=new LinkedList<>();
		vertex.bfs(order, this.queue);

	}

	public void dfs(final Vertex vertex){
		final LinkedList<@Nullable
		Vertex> order=new LinkedList<>();
		vertex.dfs(order, this.stack);
	}

	public void displayVertex(final Vertex v){
		System.out.print(v.label);
	}
}

