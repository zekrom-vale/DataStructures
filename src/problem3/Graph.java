package problem3;


/**
 * demonstrates shortest path with weighted, directed graphs
 *
 * @author Shawn Graven*
 * @date   12/15/19
 *
 * @see    #paths()
 * @see    #path(int)
 */
public class Graph{
	private final int adjMat[][];      // adjacency matrix
	private int currentVert;     // current vertex
	private final int INFINITY=1_000_000_000;
	private final int MAX_VERTS=20;
	private int nTree;           // number of verts in tree
	private int nVerts;          // current number of vertices
	private final DistPar sPath[];     // array for shortest-path data
	private int startToCurrent;  // distance to currentVert
	private final Vertex vertexList[]; // list of vertices
	//-------------------------------------------------------------


	public Graph()               // constructor
	{
		this.vertexList=new Vertex[this.MAX_VERTS];
		// adjacency matrix
		this.adjMat=new int[this.MAX_VERTS][this.MAX_VERTS];
		this.nVerts=0;
		this.nTree=0;
		for(int j=0; j<this.MAX_VERTS; j++)     // set adjacency
			for(int k=0; k<this.MAX_VERTS; k++)  //     matrix
				this.adjMat[j][k]=this.INFINITY;     //     to infinity
		this.sPath=new DistPar[this.MAX_VERTS];    // shortest paths
	}  // end constructor
	//-------------------------------------------------------------

	public void addEdge(final int start, final int end, final int weight){
		this.adjMat[start][end]=weight;  // (directed)
	}

	//-------------------------------------------------------------
	public void addVertex(final char lab){
		this.vertexList[this.nVerts++]=new Vertex(lab);
	}

	//-------------------------------------------------------------
	public void adjust_sPath()  //updating shortest-path array column by column
	{
		// adjust values in shortest-path array sPath
		int column=1;                // skip starting vertex
		while(column<this.nVerts)         // go across columns
		{
			// if this column's vertex already in tree, skip it
			if(this.vertexList[column].isInTree){
				column++;
				continue;
			}
			// calculate distance for one sPath entry
			// get edge from currentVert to column
			final int currentToFringe=this.adjMat[this.currentVert][column];
			// add distance from start
			final int startToFringe=this.startToCurrent+currentToFringe;
			// get distance of current sPath entry
			final int sPathDist=this.sPath[column].distance;

			// compare distance from start with sPath entry
			if(startToFringe<sPathDist)   // if shorter,
			{                            // update sPath
				this.sPath[column].parentVert=this.currentVert;
				this.sPath[column].distance=startToFringe;
			}
			column++;
		}  // end while(column < nVerts)
	}  // end adjust_sPath()
	//-------------------------------------------------------------

	public void displayPaths(){
		for(int j=0; j<this.nVerts; j++) // display contents of sPath[]
		{
			System.out.print(this.vertexList[j].label+"="); // B=
			if(this.sPath[j].distance==this.INFINITY) System.out.print("inf");                  // inf
			else System.out.print(this.sPath[j].distance);      // 50
			final char parent=this.vertexList[this.sPath[j].parentVert].label;
			System.out.print("("+parent+") ");       // (A)
		}
		System.out.println("");
	}

	//-------------------------------------------------------------
	//-------------------------------------------------------------
	public int getMin()               // get entry from sPath with minimum distance
	{
		int minDist=this.INFINITY;        // assume minimum
		int indexMin=0;
		for(int j=1; j<this.nVerts; j++) if(
			!this.vertexList[j].isInTree&&  // smaller than old one
			this.sPath[j].distance<minDist
			){
			minDist=this.sPath[j].distance;
			indexMin=j;            // update minimum
		}
		return indexMin;               // return index of minimum
	}  // end getMin()
	//-------------------------------------------------------------

	public void path(final int index)                // find all shortest paths
	{
		final int startTree=index;             // start at index
		this.vertexList[startTree].isInTree=true;
		this.nTree=1;                     // put it in tree

		// transfer row of distances from adjMat to sPath
		for(int j=0; j<this.nVerts; j++){
			final int tempDist=this.adjMat[startTree][j];
			this.sPath[j]=new DistPar(startTree, tempDist);
		}

		// until all vertices are in the tree
		while(this.nTree<this.nVerts){
			final int indexMin=this.getMin();    // get minimum from sPath
			final int minDist=this.sPath[indexMin].distance;

			if(minDist==this.INFINITY)     // if all infinite
			{                        // it means all vertices are in tree,
				System.out.println("There are unreachable vertices");
				break;                   // sPath is complete
			}
			else{                        // reset currentVert
				this.currentVert=indexMin;  // to closest vert
				this.startToCurrent=this.sPath[indexMin].distance;  // minimum distance from startTree to currentVert
			}
			// put current vertex in tree
			this.vertexList[this.currentVert].isInTree=true;
			this.nTree++;
			this.adjust_sPath();             // update sPath[] array
		}  // end while(nTree<nVerts)

		this.displayPaths();                // display sPath[] contents

		this.nTree=0;                     // clear tree
		for(int j=0; j<this.nVerts; j++) this.vertexList[j].isInTree=false;
	}  // end path()

	public void paths(){
		//Simply loop for each vertex and call path(i)
		for(int i=0; i<this.nVerts; i++){
			System.out.print(this.vertexList[i].label+"\t");
			this.path(i);
			System.out.println();
		}
	}
}  // end class Graph
