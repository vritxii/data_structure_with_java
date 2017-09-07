//Test git

import java.util.ArrayList;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HEllo");
		ArrayList<Pos> list = new ArrayList<>();
		list.add(new Pos(0, 0));
		Pos pos = new Pos(list.get(0).x, list.get(0).y);
		pos.add(new Pos(1, 1));
		System.out.println(list.get(0));
	}

}
class Pos {
	int x, y;
	int level;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
		this.level = 0;
	}

	public void add(Pos that) {
		this.x += that.x;
		this.y += that.y;
	}

	public void minus(Pos that) {
		this.x -= that.x;
		this.y -= that.y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")"+" ";
	}
}
