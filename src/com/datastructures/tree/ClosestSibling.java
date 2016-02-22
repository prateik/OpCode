package com.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class ClosestSibling {

	public static void printClosestSibling(Node node, List<Node> levelNodes) {

		if (node == null) return;
		levelNodes.add(node);

		while (!levelNodes.isEmpty() || !(levelNodes.size()==0)) {

			printSiblings(levelNodes);

			levelNodes=replaceWithChildNodes(levelNodes);
		}

	}

	public static List<Node> replaceWithChildNodes(List<Node> levelNodes) {
		List<Node> newLevelNodes = new ArrayList<Node>();

		for (Node node : levelNodes) {

			if (node.left != null) {
				newLevelNodes.add(node.left);
			}
			if (node.right != null) {
				newLevelNodes.add(node.right);
			}
		}

		return newLevelNodes;
	}

	public static void printSiblings(List<Node> levelnodes) {
		
		for (int i = 0; i < levelnodes.size() - 1; i++) {
			System.out.println(levelnodes.get(i).data + ":" + levelnodes.get(i + 1).data);
		}
		System.out.println(levelnodes.get(levelnodes.size()-1).data + ":" + "null");
	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.addNode(10, bst.root);
		bst.addNode(20, bst.root);
		bst.addNode(5, bst.root);
		bst.addNode(2, bst.root);
		bst.addNode(40, bst.root);
		bst.addNode(15, bst.root);
		bst.addNode(8, bst.root);
		System.out.println();
		bst.printTree(bst.root);
		System.out.println();
		printClosestSibling(bst.root, new ArrayList<Node>());

	}

}
