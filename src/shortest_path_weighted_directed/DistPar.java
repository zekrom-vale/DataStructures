package shortest_path_weighted_directed;
/*
 * Keep tracking the parent with distance
 * the resulting object put into the sPath[] array (shortest-path array)
 */
class DistPar             
{                      
	public int distance;   // distance from start to this vertex
	public int parentVert; // current parent of this vertex
	//-------------------------------------------------------------
	public DistPar(int pv, int d)  // constructor
	{
		distance = d;
		parentVert = pv;
	}
	//-------------------------------------------------------------
}  // end class DistPar