package com.datastructures.tree;

public class MinMAxValueinBST {
	
	
	public static Node getMinimum(Node node)
	{
		
		if (node == null) return null;
		
	    if(node.left == null) return node;
	    
	    return getMinimum(node.left);
		
		
	}
	
	
	public static Node getMaximum(Node node)
	{
		
		if (node == null) return null;
		
	    if(node.right == null) return node;
	    
	    return getMaximum(node.right);
		
		
	}
	
	
	public static Node getMin(Node node)
	{
		if(node == null)return null;
		
		if(node.left!= null) return getMin(node.left);
		
		return node;
		
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
		
		
		System.out.println((getMinimum(bst.root)).data);
		
		
		System.out.println((getMin(bst.root)).data);
		System.out.println((getMaximum(bst.root)).data);
	}

}
