package shortest_path_weighted_directed;

/**
 * Class PathApp Tests the Graph's path and paths method
 * 
 * @author Shawn Graven*
 * @date   12/15/19
 */
class PathApp
{
	public static void main(final String[] args)
	{
		final Graph theGraph = new Graph();
		theGraph.addVertex('A');     // 0  (start)
		theGraph.addVertex('B');     // 1
		theGraph.addVertex('C');     // 2
		theGraph.addVertex('D');     // 3
		theGraph.addVertex('E');     // 4

		theGraph.addEdge(0, 1, 50);  // AB 50
		theGraph.addEdge(0, 3, 80);  // AD 80
		theGraph.addEdge(1, 2, 60);  // BC 60
		theGraph.addEdge(1, 3, 90);  // BD 90
		theGraph.addEdge(2, 4, 40);  // CE 40
		theGraph.addEdge(3, 2, 20);  // DC 20
		theGraph.addEdge(3, 4, 70);  // DE 70
		theGraph.addEdge(4, 1, 50);  // EB 50

		System.out.println("Shortest paths");
		theGraph.paths();             // shortest paths
		System.out.println();
	}  // end main()
}  // end class PathApp