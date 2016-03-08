package com.datastructures.tree;

public class Predecessor {
	
	
	
	public static Node getPredecessorNotWorking(Node node){
		
		if(node.left == null) return null;
		
		return findRightMostNode(node.left);
	}
	
	
	public static Node getPredecessor(Node node,Node root){
		
		
		
		if(node == null) return null;
		
		//if(root.data == node.data && root.left!= null) return root.left;
	
		if(node.left!= null) return findRightMostNode(node.left);
		
		Node curr = root;
		
		Node predecessor = curr;
		
		while(curr != null)
		{
			if( node.data < curr.data) 
				{
				
				 curr = curr.left;
				}
			
			else curr = curr.right;
			
			if(curr.left != null && curr.left.data == node.data){
				return predecessor;
			}
			
			else if(curr.right!=null && curr.right.data == node.data){
				return curr;
			}
			
			predecessor = curr;
		}
		return null;
	}
	
	
	
	public static Node findRightMostNode(Node node)
	{
		
		if (node ==  null) return null;
		//System.out.println(node.data);
		if(node.right == null) return node;
		return findRightMostNode(node.right);
	}
	
public static void main(String args[]){
		
	
	BinarySearchTree bst = new BinarySearchTree();
	bst.root = bst.addNode(10,bst.root);
	bst.addNode(20,bst.root);
	bst.addNode(5,bst.root);
	bst.addNode(2,bst.root);
	Node n = new Node(40);
	//Node n = bst.addNode(40,bst.root);
	bst.addNode(n, bst.root);
	
	Node n2 = new Node(8);
	bst.addNode(n2,bst.root);
	
	Node n1 = new Node(15);
	
	
	bst.addNode(n1,bst.root);
	bst.addNode(9,bst.root);
	bst.printTree(bst.root);
	System.out.println();
	System.out.println(n.data);
	System.out.println(getPredecessor(n2,bst.root).data);
	}

}
