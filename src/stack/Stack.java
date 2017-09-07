package stack;

import java.util.ArrayList;

public class Stack<T> {
	private ArrayList<T> list;
	int Max;
	
	public Stack(int Max) {
		// TODO Auto-generated constructor stub
		this.list = new ArrayList<>();
		this.Max = Max;
	}
	
	public T pop() {
		if(list.size()>0){
			T val = list.get(list.size()-1);
			list.remove(list.size()-1);
			return val;
		}
		else {
			System.out.println("栈空");
			return null;
		}
	}
	
	public void push(T val) {
		if(list.size() < Max){
			list.add(val);
		}else {
			System.out.println("栈满");
		}
	}
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
	
	public void makeEmapty() {
		while (list.size()>0) {
			list.remove(0);
		}
	}
	
	public T getPre() {
		if(list.size()>1)
			return list.get(list.size()-2);
		else 
			return null;
	}
	
	public T top() { 
		if(list.size() > 0){
			return list.get(list.size()-1);
		}
		else 
			return null;
	}
	
	public int size() {
		return list.size();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String string = "";
		for(T ele: list){
			string += ele + " ";
		}
		return string;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
