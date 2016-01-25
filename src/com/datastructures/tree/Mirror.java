package com.datastructures.tree;

public class Mirror {
	
	
	public static Node mirror(Node node){
		
		if(node == null) return null;
		
		
		if(node.left ==  null){
		node.left = node.right;
		node.right = null;
		}
		
		
		if(node.right ==  null){
			node.right = node.left;
			node.left = null;
		}
		
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		
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
		//bst.delete(5,bst.root);
		//System.out.println(bst.search(225, bst.root));
		System.out.println();
		bst.printTree(bst.root);
		System.out.println();
		bst.root = mirror(bst.root);
		bst.printTree(bst.root);
		
	}

}
