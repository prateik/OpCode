package com.datastructures.tree;

public class LeastCommonAncestor {
	
	
	
	
	public static Node LCA(Node node,int n1,int n2){
		
		if (node == null) return null;
		
		if(n1 < node.data && n2 < node.data)
			return LCA(node.left,n1,n2);
		
		if(n1 > node.data && n2 > node.data)
			return LCA(node.right,n1,n2);
		
		return node;
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
		
		
		System.out.println(LCA(bst.root, 2, 9).data);
	}
	
}
