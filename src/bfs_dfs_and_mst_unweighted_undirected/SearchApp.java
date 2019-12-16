package bfs_dfs_and_mst_unweighted_undirected;

public class SearchApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Graph theGraph = new Graph();
	      theGraph.addVertex('A');    // 0  (start for bfs)
	      theGraph.addVertex('B');    // 1
	      theGraph.addVertex('C');    // 2
	      theGraph.addVertex('D');    // 3
	      theGraph.addVertex('E');    // 4

	      theGraph.addEdge(0, 1);     // AB
	      theGraph.addEdge(1, 2);     // BC
	      theGraph.addEdge(0, 3);     // AD
	      theGraph.addEdge(3, 4);     // DE

	      System.out.print("Visits using depth-first search: ");
	      theGraph.dfs();             // depth-first search
	      System.out.println();
	      
	      System.out.print("Visits using breadth-first search: ");
	      theGraph.bfs();             // breadth-first search
	      System.out.println();
	}

} //end class SearchApp
