package bfs_dfs_and_mst_unweighted_undirected;

import org.eclipse.jdt.annotation.Nullable;

import queue.Queue;
import queue.Stack;

/*
 * demonstrates depth-first search (DFS), breath-first search (BFS),
 * 	and minimum spanning tree (MST)
 */
class Graph
{
	private final int adjMat[][];      // adjacency matrix
	private final int MAX_VERTS = 20;
	private int nVerts;          // current number of vertices
	private final Queue<@Nullable
	Integer> theQueue;
	private final Stack<@Nullable
	Integer> theStack;
	private final Vertex vertexList[]; // list of vertices
	public Graph()               // constructor
	{
		this.vertexList=new Vertex[this.MAX_VERTS];
		// adjacency matrix
		this.adjMat=new int[this.MAX_VERTS][this.MAX_VERTS];
		this.nVerts=0;
		for(int y=0; y<this.MAX_VERTS; y++)      // set adjacency
			for(int x=0; x<this.MAX_VERTS; x++)   //    matrix to 0
				this.adjMat[x][y]=0;
		this.theStack=new Stack<>();
		this.theQueue=new Queue<>();
	}  // end constructor
	public void addEdge(final int start, final int end)
	{
		this.adjMat[start][end] = 1;
		this.adjMat[end][start] = 1;
	}
	public void addVertex(final char lab)
	{
		this.vertexList[this.nVerts++] = new Vertex(lab);
	}
	//------------------------------------------------------------
	public void bfs(){                                // begin at vertex 0
		this.vertexList[0].wasVisited = true; // mark it
		this.displayVertex(0);                // display it
		this.theQueue.insert(0);              // insert at tail
		int v2;

		while( !this.theQueue.isEmpty() )     // until queue empty,
		{
			final int v1 = this.theQueue.remove();   // remove vertex at head
			// until it has no unvisited neighbors
			while( (v2=this.getAdjUnvisitedVertex(v1)) != -1 )
			{                                  // get one,
				this.vertexList[v2].wasVisited = true;  // mark it
				this.displayVertex(v2);                 // display it
				this.theQueue.insert(v2);               // insert it
			}   // end while
		}  // end while(queue not empty)

		// queue is empty, so we're done
		for(int j=0; j<this.nVerts; j++)             // reset flags
			this.vertexList[j].wasVisited = false;
	}  // end bfs()
	//------------------------------------------------------------
	public void dfs()  // depth-first search
	{                                 // begin at vertex 0
		this.vertexList[0].wasVisited=true;  // mark it
		this.displayVertex(0);                 // display it
		this.theStack.insert(0);                 // push it

		while(!this.theStack.isEmpty())      // until stack empty,
		{
			// get an unvisited vertex adjacent to stack top
			final int v=this.getAdjUnvisitedVertex(this.theStack.peek());
			if(v == -1)                    // if no such vertex,
				this.theStack.remove();
			else                           // if it exists,
			{
				this.vertexList[v].wasVisited=true;  // mark it
				this.displayVertex(v);                 // display it
				this.theStack.insert(v);                 // push it
			}
		}  // end while

		// stack is empty, so we're done
		for(int j=0; j<this.nVerts; j++)          // reset flags
			this.vertexList[j].wasVisited=false;
	}  // end dfs
	//------------------------------------------------------------
	public void displayVertex(final int v)
	{
		System.out.print(this.vertexList[v].label);
	}
	//--------------------------------------------------------------
	// returns an unvisited vertex adj to v
	public int getAdjUnvisitedVertex(final int v)
	{
		for(int j=0; j<this.nVerts; j++)
			if(this.adjMat[v][j]==1 && this.vertexList[j].wasVisited==false)
				return j;
		return -1;
	}  // end getAdjUnvisitedVertex()
	//------------------------------------------------------------
	// -------------------------------------------------------------
	public void mst_dfs()  // minimum spanning tree (depth first)
	{                                  // start at 0
		this.vertexList[0].wasVisited = true;   // mark it
		this.theStack.insert(0);                  // push it

		while( !this.theStack.isEmpty() )       // until stack empty
		{                               // get stack top
			final int currentVertex = this.theStack.peek();
			// get next unvisited neighbor
			final int v = this.getAdjUnvisitedVertex(currentVertex);
			if(v == -1)                     // if no more neighbors
				this.theStack.remove();              //    pop it away
			else                            // got a neighbor
			{
				this.vertexList[v].wasVisited = true;  // mark it
				this.theStack.insert(v);                 // push it
				// display edge
				this.displayVertex(currentVertex);     // from currentV
				this.displayVertex(v);                 // to v
				System.out.print(" ");
			}
		}  // end while(stack not empty)

		// stack is empty, so we're done
		for(int j=0; j<this.nVerts; j++)          // reset flags
			this.vertexList[j].wasVisited = false;
	}  // end mst_dfs()
}  // end class Graph

