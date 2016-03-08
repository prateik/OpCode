package com.datastructures.tree;

public class Successor {

	public static Node getSuccessorNotWorking(Node node) {

		if (node.right == null)
			return null;

		return findLeftMostNode(node.right);
	}

	public static Node getSuccessor(Node root, Node node)

	{
		
		System.out.println("Finding Sucessor of : "+node.data);

		if (node == null)
			return null;

		if (node.right != null) {
			return findLeftMostNode(node.right);

		}

		Node successor = null;
		Node curr = root;

		while (curr != null) {
			if (curr.data > node.data) {
				successor = curr;
				curr = curr.left;
			} else if (curr.data < node.data) {
				curr = curr.right;
			} else
				break;

		}

		return successor;

	}

	public static Node findLeftMostNode(Node node) {
		if (node == null)
			return null;
		if (node.left == null)
			return node;
		return findLeftMostNode(node.left);
	}

	public static void main(String args[]) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.addNode(10, bst.root);
		bst.addNode(20, bst.root);
		bst.addNode(5, bst.root);
		bst.addNode(2, bst.root);
		Node n = new Node(40);
		// Node n = bst.addNode(40,bst.root);
		bst.addNode(n, bst.root);

		Node n2 = new Node(8);
		bst.addNode(n2, bst.root);

		Node n1 = new Node(15);

		bst.addNode(n1, bst.root);
		bst.addNode(9, bst.root);
		
		Traversals.levelOrder(bst.root);
		//bst.printTree(bst.root);
		
		//System.out.println();
		//System.out.println(n.data);
		System.out.println(getSuccessor(bst.root, n).data);
		
	 
	}

}
