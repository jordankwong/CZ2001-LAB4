package CZ2001_Lab4;

public class Vertex {
	NextVertex adjList;
	int num;
	boolean[] mark;

	Vertex(int num, NextVertex next) {
		this.num = num;
		this.adjList = next;
		mark = new boolean[1];
	}
}
