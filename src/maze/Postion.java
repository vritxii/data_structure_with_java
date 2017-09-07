package maze;

public class Postion {
	int x, y;
	Postion pre;

	public Postion(int x, int y) {
		this.x = x;
		this.y = y;
		this.pre = null;
	}

	public void add(Postion that) {
		this.x += that.x;
		this.y += that.y;
	}

	public void minus(Postion that) {
		this.x -= that.x;
		this.y -= that.y;
	}

	public String toString() {
		return "(" + x + ", " + y + ")" + " ";
	}
}
