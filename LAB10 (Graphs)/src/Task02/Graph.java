package Task02;

import java.util.*;

class Graph {
	int numVertices;
	LinkedList<String>[] adjacencyList;
	String[] labels;

	Graph(int numVertices, String[] labels) {
		this.numVertices = numVertices;
		this.labels = labels;
		adjacencyList = new LinkedList[numVertices];
		for (int i = 0; i < numVertices; i++) {
			adjacencyList[i] = new LinkedList<>();
		}
	}

	void addDirectedEdge(int v, int w) {
		adjacencyList[v].add(labels[w]);
	}

	void addUndirectedEdge(int v, int w) {
		adjacencyList[v].add(labels[w]);
		adjacencyList[w].add(labels[v]);
	}

	void displayGraph() {
		for (int i = 0; i < adjacencyList.length; i++) {
			System.out.println(labels[i] + " ----> " + adjacencyList[i]);
		}
	}
}
