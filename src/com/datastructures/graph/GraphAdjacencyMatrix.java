package com.datastructures.graph;

import java.awt.PrintGraphics;

public class GraphAdjacencyMatrix {
	Integer[][] graph;
	int noOfVertices;
	
	GraphAdjacencyMatrix(int noOfVertices){
		graph = new Integer[noOfVertices][noOfVertices];
		this.noOfVertices=noOfVertices;
		
		

    	for(int i=0;i< noOfVertices;i++){
    	
    	for(int j=0;j< noOfVertices;j++){
    		graph[i][j]=0;
    	}
    	
    	}
	}
	
	 public void addEdge(int v1,int v2){
		 
		 graph[v1-1][v2-1] = 1;
		 graph[v2-1][v1-1] = 1;
	 }
	 
	 
    public void removeEdge(int v1,int v2){
		 
		 graph[v1-1][v2-1] = 0;
		 graph[v2-1][v1-1] = 0;
	 }
	 
    
    public void printGraph(){
    	
    	
    	for(int i=0;i< noOfVertices;i++){
    	
    	for(int j=0;j< noOfVertices;j++){
    		System.out.print(graph[i][j]+",");	
    	}
    	System.out.println();
    	}
    	
    }
	 
	public static void main(String[] args) {
		GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(4);
		graph.addEdge(1,2);
		graph.addEdge(3,2);
		graph.printGraph();
	
	}

}
