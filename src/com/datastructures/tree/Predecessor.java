package com.datastructures.tree;

public class Predecessor {
	
	
	
	public static Node getPredecessor(Node node){
		
		if(node.left == null) return null;
		
		return findRightMostNode(node.left);
	}
	
	
	public static Node findRightMostNode(Node node)
	{
		if (node ==  null) return null;
		if(node.right == null) return node;
		return findRightMostNode(node.right);
	}
	
public static void main(String args[]){
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.addNode(10,bst.root);
		bst.addNode(20,bst.root);
		bst.addNode(5,bst.root);
		bst.addNode(2,bst.root);
		bst.addNode(40,bst.root);
		bst.addNode(8,bst.root);
		bst.printTree(bst.root);
		//bst.delete(5,bst.root);
		//System.out.println(bst.search(225, bst.root));
		System.out.println();
		bst.printTree(bst.root);
		
		System.out.println(getPredecessor(bst.root).data);
	}

}
