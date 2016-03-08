package com.datastructures.tree;

import java.lang.reflect.Array;

public class TreeReview {
	
	
	public static int getHeight(Node node)
	{
		if(node == null) return 0;
		
		return Math.max(1+getHeight(node.left),1+getHeight(node.right));
	}
	
	public static boolean checkIfBalanced(Node node)
	{
		
		if(node == null) return true;
		
		if(checkIfBalanced(node.left) && checkIfBalanced(node.right)
		&&  !(Math.abs(getHeight(node.left)-getHeight(node.right)) > 1))
		return true;
		
		return false;
	}
	
	
	public static Node buildTreeFromSortedArray(int[] array,int low,int high)
	{
		
		if(low > high){ return null;}
		
		int mid = (low+high)/2;
		//System.out.println(" Adding : "+array[mid]);
		 
		Node node =  new Node(array[mid]);
		 
		node.left = buildTreeFromSortedArray(array, low, mid-1);
		node.right = buildTreeFromSortedArray(array, mid+1, high);
		
		return node;
	
		
	}
	
	
	public static void levelOrder(Node node)
	{
       if(node == null) return;
       
       System.out.println(""+node.data);
    
		
	}
	
	
	public static Node leftMostNode(Node node)
	{
		if(node == null) return null;
		if(node.left == null) return node;
		return leftMostNode(node.left);
		
	}
	public static Node getSuccessor(Node node,Node root)
	{
	 if(node == null) return null;
	 
	 if(node.right!= null){
		 return leftMostNode(node.right);
	 }
	 
	 Node curr = root;
	 Node successor = curr;
	 
	 while(curr != null){
		 
		if(curr.data == node.data) break;
		 
		 if(node.data < curr.data)
		 {
			 successor = curr;
			 curr= curr.left;
		 }
		 
		 else if (node.data > curr.data){
			 successor = curr;
			 curr= curr.right;
		 } 
		 
	 }
	 
	 return successor;
	}
	
	
	public void leastCommonAncestor(Node a,Node b){
		
		
		
	}
	
	public static void main(String[] args) {
		
	

			BinarySearchTree bst = new BinarySearchTree();
			bst.root = bst.addNode(10, bst.root);
			bst.addNode(20, bst.root);
			bst.addNode(5, bst.root);
			bst.addNode(2, bst.root);
			Node n = new Node(40);
			// Node n = bst.addNode(40,bst.root);
			bst.addNode(n, bst.root);

			Node n2 = new Node(8);
			bst.addNode(n2, bst.root);

			Node n1 = new Node(15);

			bst.addNode(n1, bst.root);
			bst.addNode(9, bst.root);
			//bst.addNode(10, bst.root);
			Traversals.levelOrder(bst.root);
			//bst.printTree(bst.root);
			System.out.println("Balanced :"+checkIfBalanced(bst.root));
			System.out.println(getSuccessor(n1, bst.root).data);
			
			BinarySearchTree bst1 = new BinarySearchTree();
			int[] array = new int[] {2,3,4,7,10,15,18};
			Node n11 = buildTreeFromSortedArray(array, 0, array.length-1);
			
			Traversals.levelOrder(n11);
			
		
		}

	}


