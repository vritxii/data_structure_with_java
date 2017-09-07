package tree;

public class BinaryTree {
	private BNode root; // 根节点
	private BNode pointer;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(BNode root) {
		this.root = root;
	}

	// 实现广度优先遍历二叉树
	public void BreadthFirstTraverse() {
		queque q = new queque();
		q.enQue(root);// 让根节点入队
		// 如果队列非空则一直循环
		while (!q.isEmpty()) {
			pointer = q.deQue();// 队首出队并打印
			System.out.print(pointer.getData() + " ");
			if (pointer.getLeftChild() != null) {
				// 如果之前出队的队首节点有左子节点，则入队
				q.enQue(pointer.getLeftChild());
				if (pointer.getRightChild() != null) {
					// 如果之前出队的队首节点有右子节点，则入队
					q.enQue(pointer.getRightChild());
				}
			}
		}
	}

	/*
	 * 深度优先遍历 前、中、后序 递归、非递归
	 */
	// 先序遍历非递归
	public void preOrderTra() {
		stack s = new stack();
		BNode p = root;
		while (p != null || !s.isEmpty()) {

			while (p != null) {
				System.out.print(p.getData() + " ");
				s.push(p);
				p = p.getLeftChild();
			}
			if (!s.isEmpty()) {
				p = s.pop();
				p = p.getRightChild();
			}
		}
		System.out.println();
	}

	// 中序遍历非递归
	public void inOrderTra() {
		stack s = new stack();
		BNode p = root;
		while (p != null || !s.isEmpty()) {
			while (p != null) {
				s.push(p);
				p = p.getLeftChild();
			}
			if (!s.isEmpty()) {
				p = s.pop();
				System.out.print(p.getData() + " ");
				p = p.getRightChild();
			}
		}
		System.out.println();
	}

	// 后序遍历非递归
	public void postOrderTra() {
		stack s = new stack();
		BNode cur = null; // 当前节点
		BNode pre = null; // 前一次访问的节点

		s.push(root);
		while (!s.isEmpty()) {
			cur = s.top();
			// 如果当前节点没有子节点或者子节点都已经被访问过了
			if (cur.getLeftChild() == null && cur.getRightChild() == null
					|| (pre != null && (pre == cur.getLeftChild() || pre == cur.getRightChild()))) {
				System.out.print(cur.getData() + " ");
				s.pop();
				pre = cur;
			} else {
				if (cur.getRightChild() != null) {
					s.push(cur.getRightChild());
				}
				if (cur.getLeftChild() != null) {
					s.push(cur.getLeftChild());
				}
			}
		}
		System.out.println();

	}

	// 建立栈结构
	class stack {
		BNode[] st = new BNode[100];
		int top;
		int size;

		public stack() {
			top = 0;
			size = 0;
		}

		// 入栈
		public void push(BNode node) {
			st[top++] = node;
		}

		// 出栈
		public BNode pop() {
			return st[--top];
		}

		// 返回栈顶元素
		public BNode top() {
			return st[top - 1];
		}

		public boolean isEmpty() {
			return top == 0;
		}
	}
}

// 建立一个队列
class queque {
	BNode[] arr = new BNode[100];
	int front = 0;
	int rear = 0;

	public boolean isEmpty() {
		return front == rear;
	}

	public void enQue(BNode node) {
		arr[rear] = node;
		rear = (rear + 1) % 100;
	}

	public BNode deQue() {
		BNode pointer = arr[front];
		front = (front + 1) % 100;
		return pointer;
	}
}

class BNode {
	private char data;
	private BNode leftChild;
	private BNode rightChild;

	public BNode(char newData) {
		leftChild = null;
		rightChild = null;
		data = newData;
	}

	public BNode(char data, BNode left, BNode right) {
		this.data = data;
		this.leftChild = left;
		this.rightChild = right;
	}

	public void setData(char d) {
		this.data = d;
	}

	public char getData() {
		return data;
	}

	public void setLeftChild(BNode l) {
		this.leftChild = l;
	}

	public BNode getLeftChild() {
		return leftChild;
	}

	public void setRightChild(BNode r) {
		this.rightChild = r;
	}

	public BNode getRightChild() {
		return rightChild;
	}
}
