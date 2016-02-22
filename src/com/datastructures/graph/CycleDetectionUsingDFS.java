package com.datastructures.graph;

import java.util.Stack;

public class CycleDetectionUsingDFS {
	
	
	public static boolean isCycleDetected(Graph<Integer> graph,Stack stack,Integer source)
	{

		stack.push(source);
		graph.getVertex(source).visited = true;
		
	   for(Vertex<Integer> v: graph.getAdjacentVertices(source))
	   {
		   if(v.key == source)
		   {
			   System.out.println(" Self loop detected");
			   return true;
		   }
		   
		   if(stack.contains(v)){
			   System.out.println(" Loop detected!");
			   return true;
		   }	
		   if(!v.visited){
			stack.push(v);
			v.visited = true;
		   return isCycleDetected(graph, stack, v.key);
		   }
	   }
	   
	   //System.out.println(" No Loop detected!");
		
		return false;
		
	}
	
	
	

	public static void main(String[] args) {

		
		
Graph<Integer> graph =  new Graph<Integer>();

graph.addVertex(1);
graph.addVertex(2);
graph.addVertex(3);
graph.addVertex(4);
graph.addVertex(5);



graph.addEdge(1, 2);
graph.addEdge(2, 3);
graph.addEdge(3, 4);
//graph.addEdge(4, 1);
graph.addEdge(4, 5);
graph.addEdge(1, 1);
graph.printGraph();		
		
System.out.println(isCycleDetected(graph,new Stack<Integer>(),1));


	}

}
