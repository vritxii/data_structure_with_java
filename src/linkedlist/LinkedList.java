package linkedlist;

public class LinkedList {
	Node root;
	private int size;
	int Max;
	public LinkedList(int Max) {
		// TODO Auto-generated constructor stub
		this.size = 0;
		this.root = new Node();
		this.Max = Max;
	}
	
	public int find(int pos) {
		Node pointer = this.root.next;
		int k = 0;
		while(k < (size-pos) && pointer != null){
			pointer = pointer.next;
		}
		return pointer.value;
	}
	
	public void insert(int value) {
		if(size<Max){
			Node node = new Node(value);
			node.next = root.next;
			root.next = node;
			size++;
		}else {
			System.out.println("链表满");
		}
	}
	
	public int length() {
		return size;
	}
	
	public int delete(int key) {
		Node pointer = root;
		while(pointer!= null){
			if(pointer.next.value == key){
				pointer.next = pointer.next.next;
				size--;
				return 0;
			}
			pointer = pointer.next;
		}	
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
class Node{
	int value;
	Node next;
	public Node(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
		this.next = null;
	}
	public Node() {
		// TODO Auto-generated constructor stub
		this.next = null;
	}
}