package com.datastructures.tree;





public class IsBalanced {

	
public static int maxDepth(Node node){
		
		if(node == null) return 0;
		
		return Math.max(1+maxDepth(node.left), 1+maxDepth(node.right));
		
	}

	public static boolean isBalanced(Node node){
		
	    if(node == null ) 
	    	{
	    	System.out.println(" Null Node !");
	    	return true;}
	    
	    System.out.println("Checking for node :"+node.data);
	    if(isBalanced(node.left) && isBalanced(node.right)
	    	 && Math.abs(maxDepth(node.left)-maxDepth(node.right))<=1 )
	    {
	    	System.out.println("Returning for node :"+node.data);
        return true;
	    }
        return false;
	}
	
	
	
	public static void main(String args[]){
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.addNode(10,bst.root);
		bst.addNode(20,bst.root);
		/*bst.addNode(5,bst.root);
		bst.addNode(2,bst.root);*/
		bst.addNode(40,bst.root);
		bst.printTree(bst.root);
		bst.delete(5,bst.root);
		//System.out.println(bst.search(225, bst.root));
		System.out.println();
		bst.printTree(bst.root);
		
		System.out.println(isBalanced(bst.root));
		
		
		
		
	}
}
