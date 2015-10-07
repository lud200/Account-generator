package AccountGenerator;

public class bsttodll {
	public static void main(String args[]){
		BinaryTree b1=new BinaryTree();
		b1.insert(5);
		b1.insert(3);
		b1.insert(7);
		b1.insert(1);
		b1.insert(4);
		b1.insert(8);
		b1.insert(6);
		b1.treeToList();	
	}
}
class BinaryTree{
	
	private class Node{
		Node left;
		Node right;
		int data;
		Node(int newdata){
			left=null;
			right=null;
			data=newdata;
		}
	}
	private Node root;
	public void BinaryTree(){
		root=null;
	}
	//Insert
	public void insert(int data){
		Node temp=root;
		Node newnode=new Node(data);
		newnode.left=null;
		newnode.right=null;
		newnode.data=data;
		root=insert(root, newnode);
	}
	public Node insert(Node temp, Node newnode){
		int data;
		if(temp==null){
			temp=newnode;
		}
		else{
			if(temp.data<=newnode.data){
				insert(temp.right, newnode);
				if(temp.right==null)
					temp.right=newnode;
			}
			else{
				insert(temp.left, newnode);
				if(temp.left==null)
					temp.left=newnode;
			}
		}
		return temp;
	}
	
	//Inplace DLL from tree
	/*This method converts the tree to double linked list inplace. 
	 * No need to create a new double linked list as the tree already has left and right pointers.
	 * In this approach, we convert a tree to double linked list by using a prev node. 
	 * as follows....
	 */
	public void treeToList(){
		Node head = null;
		treeToList(root, head);
	}

	public void treeToList(Node root, Node head){
		if(root == null){
			return;
		}
		Node prev = null;
		treeToList(root.left, head);
		if(prev == null){
			head = root;
		}
		else{
			root.left = prev;
			prev.right = root;
		}
		System.out.print(root.data+"->");
		prev = head;
		treeToList(root.right, head);
	}
	//Search a node
	/* The procedure begins and searches for the node downwards in the tree
	 * For each node encountered it compares it with the val
	 * if val==node.data, then the loop terminates and value is returned
	 * if the value is less than the root value, it goes to the left sub tree else to the 
	 * right sub tree. 
	 * Hence the recursion forms the path downwards from the root of the tree. 
	 * Thus run time of the tree is O(h). Where h is the height of the tree.
	 */
	public void search(){
		search(root, 11);
	}
	public void search(Node tree, int val){
		if(tree==null){
			System.out.println("Empty tree");
		}
		else if(tree.data==val){
			System.out.println("Value found");
		}
		else if(val<tree.data){
			search(tree.left, val);
		}
		else{
			search(tree.right, val);
		}
	}
	/*Minimum and Maximum from a tree
	 * The minimum from a tree would be the left child from root until we 
	 * encounter NULL. 
	 * The maximum from a tree would be the right child from root until we
	 * encounter NULL.
	 * The time complexity for both the searches would be O(h) where h is
	 * the height of the tree.
	 */
	public void minimum(){
		minimum(root);
	}
	public void minimum(Node node){
		while(node.left!=null){
			node=node.left;
		}
		System.out.print("Minimum value of the tree is:");
		System.out.println(node.data);
	}
	public void maximum(){
		maximum(root);
	}
	public void maximum(Node node){
		while(node.right!=null){
			node=node.right;
		}
		System.out.print("Maximum value of the tree is:");
		System.out.println(node.data);
	}
	
	//Pre Order
	public String preorder(){
		return preorder(root);
	}
	String s1=" ";
	public void dll(){
		dll(root);
	}
	public void dll(Node node){
		BinaryTree doubleLinkedList = new BinaryTree();
		if(node != null){
			dll(node.left);
			dll(node.right);
			if(node.left==null && node.right==null){
				doubleLinkedList.insert(node.data);
			}
		}
		doubleLinkedList.inorder();
	}
	public String preorder(Node node){
		if(node==null)
		{
			return null;
		}
			System.out.print(node.data+"\t");
			s1=s1+node.data;
			String pre=s1;
			preorder(node.left);
			preorder(node.right);
			return pre;
	}
	String s2=" ";
	//Inorder
	public String inorder(){
		return inorder(root);
	}
	public String inorder(Node node){
		if(node==null)
		{
			return null;
		}
		inorder(node.left);
		System.out.print(node.data+"\t");
		s2=s2+node.data;
		String in=s2;
		inorder(node.right);
		return in;
	}
	
	/*See if a tree is balanced*/
	public void isBalanced(){
		isBalanced(root);
	}
	public void isBalanced(Node root){
		int maxDepth=maxDepth(root);
		int minDepth=minDepth(root);
		System.out.println("Min Height:"+minDepth);
		System.out.println("Max height:"+maxDepth);
		if(maxDepth-minDepth<=1){
			System.out.println("Balanced Tree");
		}
		else{
			System.out.println("Unbalanced Tree");
		}
	}
	public int maxDepth(Node node){
		if(node==null){
			return 0;
		}
		int maxLeft=maxDepth((Node)node.left);
		int maxRight=maxDepth((Node)node.right);
		int max=Math.max(maxLeft, maxRight);
		return 1+max;
	}
	public int minDepth(Node node){
		if(node==null){
			return 0;
		}
		int minLeft=minDepth((Node)node.left);
		int minRight=minDepth((Node)node.right);
		int min=Math.min(minLeft, minRight);
		return 1+min;
	}
	
	//If we want to check if a tree is a subtree of parent tree then 
	//do the inorder, preorder of parent, sub trees and if the parent inrder contains subtree inorder
	//or parent preorder contains subtree preorder, then a tree is subtree 
}
