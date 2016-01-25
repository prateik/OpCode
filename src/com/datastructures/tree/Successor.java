package com.datastructures.tree;

public class Successor {

public static Node getSuccessor(Node node){
		
		if(node.right== null) return null;
		
		return findLeftMostNode(node.right);
	}
	
	
	public static Node findLeftMostNode(Node node)
	{
		if (node ==  null) return null;
		if(node.left == null) return node;
		return findLeftMostNode(node.left);
	}
	
public static void main(String args[]){
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.addNode(10,bst.root);
		bst.addNode(20,bst.root);
		bst.addNode(5,bst.root);
		bst.addNode(2,bst.root);
		bst.addNode(40,bst.root);
		bst.addNode(8,bst.root);
		bst.addNode(15,bst.root);
		bst.printTree(bst.root);
		//bst.delete(5,bst.root);
		//System.out.println(bst.search(225, bst.root));
		System.out.println();
		bst.printTree(bst.root);
		
		System.out.println(getSuccessor(bst.root).data);
	}

	
}
