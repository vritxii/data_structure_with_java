package maze;

import queue.Queue;

public class BFS {
	static int[][] maze = { { 1, 1, 1, 1, 0, 1, 1, 0 }, { 1, 1, 0, 1, 1, 1, 0, 1 }, { 0, 0, 1, 0, 1, 1, 1, 1 },
			{ 1, 0, 0, 1, 0, 1, 0, 0 }, { 1, 1, 0, 1, 1, 1, 0, 0 }, { 1, 0, 0, 1, 0, 0, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };
	static Postion start = new Postion(0, 0);
	static Postion end = new Postion(7, 5);
	static Postion[] dic = { new Postion(1, 0), new Postion(0, 1), new Postion(-1, 0), new Postion(0, -1) };
	static boolean allComplete = false;
	static Queue<Postion> q = new Queue<>(49);

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
		q.enqueue(start);
		visit(start);
		Postion pointer = null;
		while (!q.isEmpty() && !allComplete) {
			for (int i = 0; i < 4; i++) {
				pointer = new Postion(q.front().x, q.front().y);
				pointer.add(dic[i]);
				// System.out.println(contains(pointer));;
				if (check(pointer)) {
					// System.out.println(pointer);
					Postion tPostion = new Postion(pointer.x, pointer.y);
					tPostion.pre = q.front();
					q.enqueue(tPostion);
					visit(pointer);
				}
			}
			q.dequeue();
		}
		pointer = q.rear();
		while (pointer != null) {
			path = "--->" + pointer.toString() + path;
			pointer = pointer.pre;
		}
		return path;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		show(maze);
		System.out.println(getPath());
		show(maze);
	}

}
