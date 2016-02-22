package com.datastructures.tree;

public class DepthAndSize {
	
	
	public static int size(Node node){
		if (node == null) return 0;
		
		return 1+size(node.left)+size(node.right);
		
	}
	
	
	public static int maxDepth(Node node){
		
		if(node == null) return 0;
		
		return Math.max(1+maxDepth(node.left), 1+maxDepth(node.right));
		
	}
	
	
	//running time O(n)
	
	public static int getSize(Node node){
		
		if(node == null) return 0;
		
		return 1+getSize(node.left)+getSize(node.right);
	}
	
public static void main(String args[]){
		
		
		
		
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.addNode(10,bst.root);
		bst.addNode(20,bst.root);
		bst.addNode(5,bst.root);
		bst.addNode(2,bst.root);
		bst.addNode(40,bst.root);
		bst.printTree(bst.root);
		bst.delete(5,bst.root);
		//System.out.println(bst.search(225, bst.root));
		System.out.println();
		bst.printTree(bst.root);
		
		System.out.println("Size : "+size(bst.root));
		
		System.out.println("Size : "+getSize(bst.root));
		
		System.out.println("Max depth : "+maxDepth(bst.root));
	}

}
