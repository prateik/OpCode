package com.datastructures.tree;

public class CheckIFBST {
	
	
	public static boolean isBST(Node node,int min,int max){
		
		if(node == null) return true;
		
		if(node.data >= min && node.data < max)
		{
			
			return isBST(node.left,min,node.data) && isBST(node.right,node.data,max);
		}
		
			return false;
		
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
		
		System.out.println(isBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
	}

}
