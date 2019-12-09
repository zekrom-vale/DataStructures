package mst_weighted_undirected;

class Vertex
{
	public char label;        // label (e.g. 'A')
	public boolean isMarked;
	//-------------------------------------------------------------
	public Vertex(char lab)   // constructor
	   {
		   label = lab;
		   isMarked = false;
	   }
	//-------------------------------------------------------------
}  // end class Vertex