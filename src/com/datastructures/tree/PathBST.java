package com.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class PathBST {


	public static boolean hasPathSum(Node node,int sum){
		
		if(node == null) 
		{
			if (sum == 0) return true;
			else return false;
		}
		sum-=node.data;
		
		if(node.left == null && node.right == null)
		{
			//System.out.println("Sum at Leaf : "+sum);
			if (sum == 0) return true;
			
		}
		return hasPathSum(node.left, sum ) || hasPathSum(node.right, sum);
	}
	
	
	
	public static void printPaths(Node node,List<Integer> pathNodes){
		
		if(node == null) return;
		
		pathNodes.add(node.data);
		
		if(node.left == null && node.right == null)
		{
			System.out.print("Path : ");
			
			for(Integer nodes:pathNodes){
				System.out.print(nodes+" | ");
			}
			
			System.out.println();
			//pathNodes.remove((Integer) (node.data));
				
			
		}
		
		printPaths(node.left, pathNodes);
		printPaths(node.right, pathNodes);
		
		pathNodes.remove((Integer) (node.data));
		
		return;
	}
	
	
	public static boolean hasPathSum2(Node node,int sum){
	
		// return true if we run out of tree and sum==0 
		  if (node == null) { 
		    return(sum == 0); 
		  } 
		  else { 
		  // otherwise check both subtrees 
		    int subSum = sum - node.data; 
		    return(hasPathSum2(node.left, subSum) || hasPathSum2(node.right, subSum)); 
		  } 
	}
	
	public static void printPaths2(Node node, int[] path, int pathLen)
	{
		if (node==null) return;

		  // append this node to the path array 
		  path[pathLen] = node.data; 
		  pathLen++;

		  // it's a leaf, so print the path that led to here 
		  if (node.left==null && node.right==null) { 
		    printArray(path, pathLen); 
		  } 
		  else { 
		  // otherwise try both subtrees 
		    printPaths2(node.left, path, pathLen); 
		    printPaths2(node.right, path, pathLen); 
		  } 
		
	}
	
	/** 
	 Utility that prints ints from an array on one line. 
	*/ 
	private static void printArray(int[] ints, int len) { 
	  int i; 
	  for (i=0; i<len; i++) { 
	   System.out.print(ints[i] + " "); 
	  } 
	  System.out.println(); 
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
		System.out.println(hasPathSum(bst.root, 17));
		
		printPaths(bst.root, new ArrayList<Integer>());
	}
	
}
