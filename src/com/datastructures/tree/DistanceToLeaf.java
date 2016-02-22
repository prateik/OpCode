package com.datastructures.tree;

public class DistanceToLeaf {

	public static int getShortestDistanceToLeaf(Node node)

	{

		if (node == null)
			return 0;

		if (node.left == null && node.right == null) {
			return 0;
		}

		return Math.min(getShortestDistanceToLeaf(node.left) + 1, getShortestDistanceToLeaf(node.right) + 1);

	}

	public static Node fetchNodeReference(Node node, int x) {
		if (node == null)
			return null;
		if (node.data == x)
			return node;

		if (x <= node.data)
			return fetchNodeReference(node.left, x);

		else {
			return fetchNodeReference(node.right, x);
		}

	}

	public static int getShortestDistanceToLeafFromRoot(Node node, Node x)

	{

		if (node == null)
			return 0;

		if (node.left == null && node.right == null) {
			return 0;
		}

		if (node.left == x)
			return 1 + getShortestDistanceToLeafFromRoot(node.right, x);

		else
			return getShortestDistanceToLeafFromRoot(node.left, x) + 1;

	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.addNode(10, bst.root);

		bst.addNode(20, bst.root);
		bst.addNode(5, bst.root);
		bst.addNode(2, bst.root);
		bst.addNode(25, bst.root);
		bst.addNode(15, bst.root);
		bst.addNode(7, bst.root);
		bst.printTree(bst.root);
		// bst.delete(5,bst.root);
		// System.out.println(bst.search(225, bst.root));
		System.out.println();
		Node node = fetchNodeReference(bst.root, 10);
		bst.printTree(bst.root);
		System.out.println();
		System.out.println(getShortestDistanceToLeaf(node));

	}

}
