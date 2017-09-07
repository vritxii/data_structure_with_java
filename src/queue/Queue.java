package queue;

import java.util.ArrayList;

public class Queue<T> {
	ArrayList<T> list;
	int Max;

	public Queue(int Max) {
		// TODO Auto-generated constructor stub
		this.list = new ArrayList<>();
		this.Max = Max;
	}

	public T dequeue() {
		if (list.size() > 0) {
			T val = list.get(0);
			list.remove(0);
			return val;
		} else {
			System.out.println("队列空");
			return null;
		}
	}

	public void enqueue(T val) {
		if (list.size() < Max) {
			list.add(val);
		} else {
			System.out.println("队列满");
		}
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	public void makeEmapty() {
		while (list.size() > 0) {
			list.remove(0);
		}
	}

	public T front() {
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	public T rear() {
		return list.get(list.size()-1);
	}
	public int size() {
		return list.size();
	}

	public ArrayList<T> getList() {
		return list;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = "";
		for (int i = list.size() - 1; i >= 0; i--) {
			string += list.get(i) + " ";
		}
		return string;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new Queue<>(10);
		for(int i=0; i<10; i++){
			q.enqueue(i);
		}
		System.out.println(q.isEmpty());
	}

}
