package Task03;

import java.util.*;

public class GraphDriver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Edge> edges = Arrays.asList(Edge.getEdge(0, 3), Edge.getEdge(1, 0), Edge.getEdge(1, 2), Edge.getEdge(1, 4),
				Edge.getEdge(2, 7), Edge.getEdge(3, 4), Edge.getEdge(3, 5), Edge.getEdge(4, 3), Edge.getEdge(4, 6),
				Edge.getEdge(5, 6), Edge.getEdge(6, 7));

		// Number of nodes in the graph (labelled from 0 to N-1)
		int numVertices = 8;
		Graph g = new Graph(edges, numVertices);
		System.out.print("Enter the source vertex [0 - " + (numVertices - 1) + "]: ");
		int src = scanner.nextInt();
		System.out.print("Enter the destination vertex [0 - " + (numVertices - 1) + "]: ");
		int dest = scanner.nextInt();
		if (g.isReachable(src, dest) != false) {
			System.out.println("Path exists from vertex " + src + " vertex " + dest);
		} else {
			System.out.println("No path exists between vertices " + src + " and " + dest);

		}

	}
}