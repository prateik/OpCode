package com.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class Traversals {

	public static void preOrder(Node node){
	
		if(node == null) return;
		
		System.out.print(node.data+" | ");
		
		preOrder(node.left);
		
		preOrder(node.right);
	}
	
	
	public static void postOrder(Node node){
		
		if(node == null) return;
		
		
		
		preOrder(node.left);
		
		preOrder(node.right);
		
		System.out.print(node.data+" | ");
		
	} 
	
	
     public static void InOrder(Node node){
		
		if(node == null) return;
		
		preOrder(node.left);
		
		System.out.print(node.data+" | ");
		
		preOrder(node.right);
			
	} 
	
     
     public static void levelOrder(Node node){
 		
    	 
    	 if(node == null) return;
    	 
    	 List<Node> levelNodes = new ArrayList<Node>();
    	 Node temp = node;
    	 
    	 System.out.println(" Level Nodes : "+temp.data);
    	 
    	 levelNodes.add(node.left);
    	 levelNodes.add(node.right);
    	 
    	print(levelNodes);
    	
    	levelNodes.removeAll(levelNodes);
    	
        
    	 
 	} 
	
     
     public static void print(List<Node> nodes){
    	 
    	 for(Node node:nodes)
    		 System.out.print(node.data+" | ");
    	 
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
		//bst.printTree(bst.root);
		
		preOrder(bst.root);
		System.out.println();
		postOrder(bst.root);
		System.out.println();
		InOrder(bst.root);
		System.out.println();
		levelOrder(bst.root);
	}
	
	
}
