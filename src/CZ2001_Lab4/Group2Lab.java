package CZ2001_Lab4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Group2Lab {

	public boolean[] accessed; // marks a node as accessed
	public int[] edges; // array for previous edge on shortest path as described
						// in task 3
	public int[] dist; // numbers of edges on shortest path

	private static final int VSET1 = 5000, VSET2 = 10000;

	public Group2Lab(Graph G, int s) {
		accessed = new boolean[G.len()];
		dist = new int[G.len()];
		edges = new int[G.len()];
		breadthFirstSearch(G, s);
	}

	public void breadthFirstSearch(Graph G, int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < accessed.length; i++) {
			accessed[i] = false;
			edges[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}
		accessed[node] = true;
		dist[node] = 0;
		queue.add(node);
		while (!queue.isEmpty()) {
			int v = queue.peek();
			queue.remove();
			for (NextVertex nbr = G.adjList[v].adjList; nbr != null; nbr = nbr.next)
				if (accessed[nbr.Num] == false) {
					accessed[nbr.Num] = true;
					edges[nbr.Num] = v;
					dist[nbr.Num] = dist[v] + 1;
					queue.add(nbr.Num);
				}
		}
	}

	// shortest length
	public void shortestLength(int s) {
		if (dist[s] == Integer.MAX_VALUE)
			dist[s] = -1;
		System.out.println("Vertex = " + s + "\nMarked = " + accessed[s] + "\nNumber of Edges = " + dist[s] + "\n");
	}

	// shortest path
	public void shortestPath(int s) { // prints path from source to destination
										// vertex
		if (edges[s] != -1) {
			Stack<Integer> stack = new Stack<Integer>();
			int prev;
			stack.push(s);
			if (dist[s] != -1) {
				prev = edges[s];
				while (prev != -1) {
					stack.push(prev);
					prev = edges[prev];
				}
			}
			System.out.print(stack.pop());
			while (!stack.isEmpty()) {
				System.out.print(" -> " + stack.pop());
			}
			System.out.println("\n");
		} else {
			System.out.println("No path Available!\n");
			return;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice, source, destination, printPath, i;
		Graph G;
		Group2Lab main = null, preComputing = null;

		System.out.println("Generating 2 sets of graphs for Example Class 4......\n");

		Graph graph1_1 = new Graph(VSET1, 1000);
		Graph graph1_2 = new Graph(VSET1, 5000);
		Graph graph1_3 = new Graph(VSET1, 10000);
		Graph graph1_4 = new Graph(VSET1, 50000);
		Graph graph1_5 = new Graph(VSET1, 100000);

		Graph graph2_1 = new Graph(VSET2, 1000);
		Graph graph2_2 = new Graph(VSET2, 5000);
		Graph graph2_3 = new Graph(VSET2, 10000);
		Graph graph2_4 = new Graph(VSET2, 50000);
		Graph graph2_5 = new Graph(VSET2, 100000);

		System.out.println("Do you want to precompute all paths? y(1)/n(0) ");
		int pre = sc.nextInt();
		if (pre == 1) {
			System.out.println("\n");
			// first set of graphs
			long startTime = System.nanoTime();
			for (i = 0; i < VSET1; i++)
				preComputing = new Group2Lab(graph1_1, i);
			long taskTimeMs = System.nanoTime() - startTime;
			System.out.println("CPU Time for 1.1: " + taskTimeMs + " ns");

			startTime = System.nanoTime();
			for (i = 0; i < VSET1; i++)
				preComputing = new Group2Lab(graph1_2, i);
			taskTimeMs = System.nanoTime() - startTime;
			System.out.println("CPU Time for 1.2: " + taskTimeMs + " ns");

			startTime = System.nanoTime();
			for (i = 0; i < VSET1; i++)
				preComputing = new Group2Lab(graph1_3, i);
			taskTimeMs = System.nanoTime() - startTime;
			System.out.println("CPU Time for 1.3: " + taskTimeMs + " ns");

			startTime = System.nanoTime();
			for (i = 0; i < VSET1; i++)
				preComputing = new Group2Lab(graph1_4, i);
			taskTimeMs = System.nanoTime() - startTime;
			System.out.println("CPU Time for 1.4: " + taskTimeMs + " ns");

			startTime = System.nanoTime();
			for (i = 0; i < VSET1; i++)
				preComputing = new Group2Lab(graph1_5, i);
			taskTimeMs = System.nanoTime() - startTime;
			System.out.println("CPU Time for 1.5: " + taskTimeMs + " ns");

			// Second set of graphs
			startTime = System.nanoTime();
			for (i = 0; i < VSET2; i++)
				preComputing = new Group2Lab(graph2_1, i);
			taskTimeMs = System.nanoTime() - startTime;
			System.out.println("CPU Time for 2.1: " + taskTimeMs + " ns");

			startTime = System.nanoTime();
			for (i = 0; i < VSET2; i++)
				preComputing = new Group2Lab(graph2_2, i);
			taskTimeMs = System.nanoTime() - startTime;
			System.out.println("CPU Time for 2.2: " + taskTimeMs + " ns");

			startTime = System.nanoTime();
			for (i = 0; i < VSET2; i++)
				preComputing = new Group2Lab(graph2_3, i);
			taskTimeMs = System.nanoTime() - startTime;
			System.out.println("CPU Time for 2.3: " + taskTimeMs + " ns");

			startTime = System.nanoTime();
			for (i = 0; i < VSET2; i++)
				preComputing = new Group2Lab(graph2_4, i);
			taskTimeMs = System.nanoTime() - startTime;
			System.out.println("CPU Time for 2.4: " + taskTimeMs + " ns");

			startTime = System.nanoTime();
			for (i = 0; i < VSET2; i++)
				preComputing = new Group2Lab(graph2_5, i);
			taskTimeMs = System.nanoTime() - startTime;
			System.out.println("CPU Time for 2.5: " + taskTimeMs + " ns");

			System.out.println();

			// Preprocessing of all graphs stops here
		}

		do {
			System.out.println("1: 5000 vertices, 1000 edges");
			System.out.println("2: 5000 vertices, 5000 edges");
			System.out.println("3: 5000 vertices, 10000 edges");
			System.out.println("4: 5000 vertices, 50000 edges");
			System.out.println("5: 5000 vertices, 100000 edges");
			System.out.println("6: 10000 vertices, 1000 edges");
			System.out.println("7: 10000 vertices, 5000 edges");
			System.out.println("8: 10000 vertices, 10000 edges");
			System.out.println("9: 10000 vertices, 50000 edges");
			System.out.println("10: 10000 vertices, 100000 edges");
			System.out.println("11: Exit");
			System.out.print("Please select one graph: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.print("Enter Source: ");
				source = sc.nextInt();
				G = graph1_1;
				Group2Lab main1_1 = new Group2Lab(G, source);
				main = main1_1;
				break;
			case 2:
				System.out.print("Enter Source: ");
				source = sc.nextInt();
				G = graph1_2;
				Group2Lab main1_2 = new Group2Lab(G, source);
				main = main1_2;
				break;
			case 3:
				System.out.print("Enter Source ");
				source = sc.nextInt();
				G = graph1_3;
				Group2Lab main1_3 = new Group2Lab(G, source);
				main = main1_3;
				break;
			case 4:
				System.out.print("Enter Source: ");
				source = sc.nextInt();
				G = graph1_4;
				Group2Lab main1_4 = new Group2Lab(G, source);
				main = main1_4;
				break;
			case 5:
				System.out.print("Enter Source: ");
				source = sc.nextInt();
				G = graph1_5;
				Group2Lab main1_5 = new Group2Lab(G, source);
				main = main1_5;
				break;
			case 6:
				System.out.print("Enter Source: ");
				source = sc.nextInt();
				G = graph2_1;
				Group2Lab main2_1 = new Group2Lab(G, source);
				main = main2_1;
				break;
			case 7:
				System.out.print("Enter Source: ");
				source = sc.nextInt();
				G = graph2_2;
				Group2Lab main2_2 = new Group2Lab(G, source);
				main = main2_2;
				break;
			case 8:
				System.out.print("Enter Source: ");
				source = sc.nextInt();
				G = graph2_3;
				Group2Lab main2_3 = new Group2Lab(G, source);
				main = main2_3;
				break;
			case 9:
				System.out.print("Enter Source: ");
				source = sc.nextInt();
				G = graph2_4;
				Group2Lab main2_4 = new Group2Lab(G, source);
				main = main2_4;
				break;
			case 10:
				System.out.print("Enter Source: ");
				source = sc.nextInt();
				G = graph2_5;
				Group2Lab main2_5 = new Group2Lab(G, source);
				main = main2_5;
				break;
			default:
				System.out.println("Please enter a right choice.");
				break;
			}
			if (choice > 10)
				break;
			else {
				System.out.print("Enter Destination: ");
				destination = sc.nextInt();
				System.out.println();
				main.shortestLength(destination);
				System.out.print("Print out the path? y(1)/n(0): ");
				printPath = sc.nextInt();
				if (printPath == 1)
					main.shortestPath(destination);
			}
		} while (choice < 11);
	}
}
