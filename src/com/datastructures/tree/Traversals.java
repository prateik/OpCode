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
		
		postOrder(node.left);
		
		postOrder(node.right);
		
		System.out.print(node.data+" | ");
		
	} 
	
	
     public static void InOrder(Node node){
		
		if(node == null) return;
		
		InOrder(node.left);
		
		System.out.print(node.data+" | ");
		
		InOrder(node.right);
			
	} 
	
     
     public static void levelOrder(Node node){
 		
    	 
    	 if(node == null) return;
    	 
    	 List<Node> levelNodes = new ArrayList<Node>();
    	 Node temp = node;
    	 
         levelNodes.add(temp);
    	
         while(!levelNodes.isEmpty())
         {
        	 System.out.print(" Level Nodes : ");
        	 
        	 for(Node levelNode:levelNodes){
        		 System.out.print(levelNode.data+" | ");
        	 }
        	 
        	 levelNodes = replacewithchildNodes(levelNodes);
        	 System.out.println();
         }
 
 	} 
     
     public static List<Node> replacewithchildNodes(List<Node> levelNodes){
      	
    	 List<Node> nextlevelNodes = new ArrayList<Node>();
    	 for(Node node:levelNodes){
    	 
         if(node.left!= null )nextlevelNodes.add(node.left);
         if(node.right!= null )nextlevelNodes.add(node.right);
    	 }
    	 return nextlevelNodes;
     }
     
  
     public static void inOrder2(Node node){
    	 
    	 
    	 if(node == null) return;
    	 
    	 System.out.print(" N : "+node.data);
    	 inOrder2(node.left);
    	 inOrder2(node.right);
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
		bst.addNode(6,bst.root);
		bst.addNode(9,bst.root);
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
		inOrder2(bst.root);
	}
	
	
}
