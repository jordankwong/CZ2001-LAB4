package CZ2001_Lab4;

public class NextVertex {
	public NextVertex next;
	public int Num;

	// constructor
	public NextVertex(int num, NextVertex nxt) {
		this.Num = num;
		next = nxt;
	}
}
