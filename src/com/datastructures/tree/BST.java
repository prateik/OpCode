package com.datastructures.tree;


class NodeX<T extends Comparable<T> >{
	
	T data;
	NodeX<T> left;
	NodeX<T> right;
	
	
	public NodeX(T data){
		this.data = data;
		this.left = null;
		this.right= null;
	}
}

public class BST<T extends Comparable<T>> {
	
	NodeX<T> root;
	

	public NodeX<T> insert(T data,NodeX<T> node)
	{
		NodeX<T> newNode = new NodeX<T>(data);
		
		if(node == null) 
		{
			node = newNode;
			if(root == null) root = node;
			return node;
		}
		
		else if (newNode.c)
		{
			return insert(data,node.left);
		}
		else{
			return insert (data,node.right);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
