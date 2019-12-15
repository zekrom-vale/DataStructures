package bfs_dfs_and_mst_unweighted_undirected;

public class Driver{

	public static void main(final String[] args){
		Driver.testGraph();
		System.out.println();
		Driver.testGraph2();
	}

	public static void testGraph(){
		final Graph graph=new Graph();
		graph.addVertex('A');//0
		graph.addVertex('B');//1
		graph.addVertex('C');//2
		graph.addVertex('D');//3
		graph.addVertex('E');//4
		graph.addVertex('F');//5
		graph.addVertex('G');//6
		graph.addVertex('H');//7
		graph.addVertex('I');//8
		graph.addVertex('J');//9
		graph.addVertex('K');//10
		graph.addVertex('L');//11

		//From 0
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);

		//From 1
		graph.addEdge(1, 5);
		graph.addEdge(1, 11);

		//From 5
		graph.addEdge(5, 7);

		//From 7
		graph.addEdge(7, 9);

		//From 9
		graph.addEdge(9, 8);

		//From 2
		graph.addEdge(2, 6);
		graph.addEdge(2, 10);

		//From 6
		graph.addEdge(6, 8);

		//From 3
		//Nothing

		graph.mst_dfs(0);
	}

	public static void testGraph2(){
		//Implementation is different as it uses the vertex object instead of associating numbers with each one
		final Graph2 graph=new Graph2();
		final Vertex A=graph.addVertex('A');
		final Vertex B=graph.addVertex('B');
		final Vertex C=graph.addVertex('C');
		final Vertex D=graph.addVertex('D');
		final Vertex E=graph.addVertex('E');
		final Vertex F=graph.addVertex('F');
		final Vertex G=graph.addVertex('G');
		final Vertex H=graph.addVertex('H');
		final Vertex I=graph.addVertex('I');
		final Vertex J=graph.addVertex('J');
		final Vertex K=graph.addVertex('K');
		final Vertex L=graph.addVertex('L');

		//From A
		graph.addEdge(A, B);
		graph.addEdge(A, C);
		graph.addEdge(A, D);
		graph.addEdge(A, E);

		//From B
		graph.addEdge(B, F);
		graph.addEdge(B, L);

		//From F
		graph.addEdge(F, H);

		//From H
		graph.addEdge(H, J);

		//From J
		graph.addEdge(J, I);

		//From C
		graph.addEdge(C, G);
		graph.addEdge(C, K);

		//From G
		graph.addEdge(G, I);

		//From D
		//Nothing

		System.out.println("DFS A:");
		System.out.println(graph.dfs(A));
		System.out.println("BFS A:");
		System.out.println(graph.bfs(A));
		System.out.println("DFS L:");
		System.out.println(graph.dfs(L));

	}
}
