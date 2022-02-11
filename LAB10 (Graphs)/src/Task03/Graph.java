package Task03;

import java.util.*;

// Determines if a vertex is reachable from another vertex in a directed graph
public class Graph {
	private List<List<Integer>> adjList = null;
	private int numVertices;

	public Graph(List<Edge> edges, int numVertices) {
		this.numVertices = numVertices;
		adjList = new ArrayList<>();
		for (int i = 0; i < numVertices; i++) {
			adjList.add(new ArrayList<>());
		}
		for (Edge edge : edges) {
			int src = edge.source;
			int dest = edge.dest;

			adjList.get(src).add(dest);
		}
	}
	public boolean isReachable(int src, int dest) {
		boolean[] visited = new boolean[numVertices];
		return isReachable(src, dest, visited);
	}
	private boolean isReachable(int src, int dest, boolean[] visited) {
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		queue.add(src);
		visited[src - 1] = true;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (current == dest) {
				return true;
			}
			for (int i : adjList.get(current)) {
				if (visited[i] == false) {
					queue.add(i);
					visited[i - 1] = true;
				}
			}
		}
		return false;
	}
}