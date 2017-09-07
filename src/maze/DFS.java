package maze;

import stack.Stack;

public class DFS {
	static int[][] maze = { { 1, 1, 1, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1, 0 }, { 0, 0, 1, 0, 1, 1, 1 },
			{ 1, 0, 0, 1, 0, 1, 0 }, { 1, 1, 0, 1, 1, 1, 0 }, { 1, 0, 0, 1, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
	static Postion start = new Postion(0, 0);
	static Postion end = new Postion(6, 6);
	static Postion[] dic = { new Postion(1, 0), new Postion(0, 1), new Postion(-1, 0), new Postion(0, -1) };
	static boolean allComplete = false;
	static Stack<Postion> s = new Stack<Postion>(49);

	public static void show(int[][] maze) {
		System.out.println("显示迷宫：");
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++)
				if (maze[i][j] == 1)
					System.out.print("# ");
				else if (maze[i][j] == 0)
					System.out.print("@ ");
				else
					System.out.print("^ ");
			System.out.println();
		}
	}

	public static void visit(Postion p) {
		maze[p.y][p.x] = -1;
	}

	public static boolean check(Postion p) {
		if (p.x > 6 || p.y > 6 || p.x < 0 || p.y < 0)
			return false;
		if (maze[p.y][p.x] != 1)
			return false;
		if (p.x == end.x && p.y == end.y) {
			allComplete = true;
			return true;
		} else {
			return true;
		}
	}

	public static String getPath() {
		String path = "";
		s.push(start);
		visit(start);
		Postion pointer = null;
		w: while (!s.isEmpty() && !allComplete) {
			pointer = new Postion(s.top().x, s.top().y);
			//System.out.println(pointer);
			for (int i = 0; i < 4; i++) {
				pointer.add(dic[i]);
				// System.out.println(contains(pointer));;
				if (check(pointer) && !contains(pointer)) {
					s.push(new Postion(pointer.x, pointer.y));
					visit(pointer);
					continue w;
				} else if (!check(pointer)) {
					pointer.minus(dic[i]);
				}
			}
			//System.out.println(s.toString());
			s.pop();
		}
		//System.out.println("S: " + s.size());
		while (!s.isEmpty()) {
			pointer = s.pop();
			path = "--->" + "(" + pointer.x + ", " + pointer.y + ") " + path;
		}
		return path;
	}

	public static boolean contains(Postion p) {
		Postion tmPos = s.getPre();
		//System.out.println(tmPos);
		if (tmPos == null)
			return false;
		if (p.x == tmPos.x && p.y == tmPos.y)
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		show(maze);
		System.out.println(getPath());
		/*
		 * ArrayList<Pos> list = new ArrayList<>(); list.add(start);
		 * System.out.println(list.contains(new Pos(0, 0)));
		 */
		show(maze);
	}
}
