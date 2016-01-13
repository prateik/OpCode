package com.datastructures.tree;


class Node{
	
	int data;
	Node left;
	Node right;
	
	Node(){
		
	}
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BinarySearchTree {

	Node root;
	
	public void  BinarySearchTree(){
		root = new Node();
	}
	
	public Node addNode(int data,Node node){
		if(node == null){
			return new Node(data);
		}
	
		else if(data <= node.data)
		{
			node.left = addNode(data, node.left);
		}
		
		else{
			
			node.right = addNode(data, node.right);
		}
		return node;
	}
	
	public boolean search(int data,Node node){
		
		if(node == null) return false;
		
		if(node.data == data) return true;
		
		if(data <= node.data) 
			return search(data,node.left);
		
		else {
			return search(data,node.right);
		}
		
	}
	
	public Node  getSuccessor(Node node){
		
		if(node == null)
			return null;
	    if(node.left == null){
	    	return node;
	    }
		
		return getSuccessor(node.left);
	}
	
	public Node delete(int data,Node node){
		
		if(node == null) return null;
		
		
		if(node.data == data){
			
			// case 1 : no child nodes
			if(node.left == null && node.right == null) {
				return null;
		        }
		
			
			else if(node.left == null){
				return node.right;
			}
			
			else if(node.right == null){
				return node.left;
			}
			
			else{
				Node successor = getSuccessor(node);
				node.data = successor.data;
				successor = null;
				return node;
				
			}	
			
		}
		
		
		else{
			
			if(data <= node.data){
				node.left = delete(data, node.left);
			}
			
			else{
				node.right = delete(data,node.right);
			}
			
                return node;			
		}
	

	}
	public void printTree(Node root){ 
		
		if(root == null){
			System.out.println("End of Tree");
			
		}
		else{
		System.out.print(root.data+" | ");
		
		}
		if(root.left!=null)
		printTree(root.left);
		if(root.right!=null)
		printTree(root.right);
		
	
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
	}
	
}
