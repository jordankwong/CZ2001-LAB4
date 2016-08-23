package CZ2001_Lab4;

import java.util.Random;

public class Graph {

	int i, j, len = 0;

	Vertex[] adjList;

	Random r = new Random();

	public Graph(int len, int numOfEdges) {

		this.len = len;
		adjList = new Vertex[len];
		for (int v = 0; v < adjList.length; v++) {
			adjList[v] = new Vertex(v, null);
		}
		for (i = 0; i < numOfEdges; i++) {
			int v1 = r.nextInt(len);
			int v2 = r.nextInt(len);

			while (contains(adjList[v1].adjList, v2) || v1 == v2)
				v2 = r.nextInt(len);

			adjList[v1].adjList = new NextVertex(v2, adjList[v1].adjList);
			adjList[v2].adjList = new NextVertex(v1, adjList[v2].adjList);
		}
	}

	public void display() {
		System.out.println();
		for (int v = 0; v < adjList.length; v++) {
			System.out.print(adjList[v].num);
			for (NextVertex nbr = adjList[v].adjList; nbr != null; nbr = nbr.next) {
				System.out.print(" -> " + adjList[nbr.Num].num);
			}
			System.out.println("\n");
		}
	}

	public int len() {
		return len;
	}

	public void displayOneVertex(int vertex) {
		System.out.println();
		System.out.print(adjList[vertex].num);
		for (NextVertex nbr = adjList[vertex].adjList; nbr != null; nbr = nbr.next) {
			System.out.print(" -> " + adjList[nbr.Num].num);
		}
		System.out.println("\n");
	}

	public boolean contains(NextVertex nbr, int newV) {
		while (nbr != null) {
			if (nbr.Num == newV)
				return true;
			nbr = nbr.next;
		}
		return false;
	}
}
