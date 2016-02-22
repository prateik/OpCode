package com.datastructures.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstSearch {

	
	public static void BFS(GraphAdjacencyList graph,int sourceVertex){
		
		boolean[] visited = new boolean[graph.size()];
		
		Queue<Integer> adjacentVerticesQueue = new LinkedBlockingQueue<Integer>();
		adjacentVerticesQueue.add(sourceVertex);
		visited[sourceVertex-1]= true;
		while(!adjacentVerticesQueue.isEmpty()){
	
			Integer current = adjacentVerticesQueue.poll();
			  System.out.println("Visited "+current);
			   
			for(Integer vertex : graph.vertices.get(current)){
		        if(!visited[vertex-1]){
		        	//System.out.println(" Adding .. "+vertex);
				adjacentVerticesQueue.add(vertex);
				visited[vertex-1]=true;
				}
			}
			
		}
		
	}
	
	public static void main(String args[]){
	GraphAdjacencyList graph =  new GraphAdjacencyList();
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		
		graph.addVertex(5);
		graph.addVertex(6);
		graph.addVertex(7);
		graph.addVertex(8);
		
		graph.addVertex(9);
		graph.addVertex(10);
		graph.addVertex(11);
		graph.addVertex(12);
		
		graph.addVertex(13);
		graph.addVertex(14);
		graph.addVertex(15);
		graph.addVertex(16);
		graph.addEdge(1, 2);
		graph.addEdge(15, 3);
		graph.addEdge(14, 4);
		graph.addEdge(12, 4);
		graph.addEdge(5, 2);
		graph.addEdge(13, 3);
		graph.addEdge(11, 4);
		graph.addEdge(9, 4);
		graph.addEdge(6, 2);
		graph.addEdge(7, 3);
		graph.addEdge(8, 4);
		graph.addEdge(2, 4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 4);
		graph.printGraph();
		BFS(graph, 1);
		
	}
}
