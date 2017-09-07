package tree;

import java.util.ArrayList;

/**
 * Created by vrit on 16-12-13.
 */
public class ChildTree<T> {
	chiNode[] nodes;
	chiNode pointer;
	int size;
	int Max_Size;

	public ChildTree(int MAX_SIZE) {
		this.Max_Size = MAX_SIZE;
		this.size = 0;
		this.nodes = new chiNode[this.Max_Size];
		this.pointer = null;
	}

	public ChildTree() {
		this.Max_Size = 26;
		this.size = 0;
		this.nodes = new chiNode[this.Max_Size];
		this.pointer = null;
	}

	public void insert(T parVal, T value) {
		int pointer = 0;
		for (; pointer < size; pointer++) {
			if (nodes[pointer].value == parVal) {
				nodes[pointer].childs.add(value);
				pointer += nodes[pointer].childs.size();
				break;
			}
		}

	}

	public void remove(T value) {
		if (size > 0) {
			for (int i = 0; i < size; i++) {

			}
		}
	}
}

class chiNode<T> {
	public ArrayList<T> childs;
	public T value;

	public chiNode() {
		this.childs = new ArrayList<>();
		this.value = null;
	}

	public chiNode(T value) {
		this.childs = new ArrayList<>();
		this.value = value;
	}
}