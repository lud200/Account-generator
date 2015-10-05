package AccountGenerator;

public class dll {
	public static void main(String[] args){
		doubleLinkedList dll = new doubleLinkedList();
		dll.insert(3);
		dll.insert(5);
		dll.insert(9);
		dll.insert(23);
		dll.print();
	}
}

class doubleLinkedList{
	private class Node{
		int data;
		Node next;
		Node previous;
	}
	
	Node head = null;
	
	public void insert(int data){
		Node node = new Node();
		Node temp = head;
		if(head == null){
			head = node;
			head.data = data;
			head.previous = null;
			head.next = null;
		}
		else{
			while(temp.next != null){
				temp = temp.next;
			}
			node.previous=temp;
			node.data=data;
			node.next = null;
			temp.next=node;
		}
	}
	
	public void print(){
		Node n = head;
		while(n != null){
			System.out.print(n.data+"->");
			n=n.next;
		}
	}
}