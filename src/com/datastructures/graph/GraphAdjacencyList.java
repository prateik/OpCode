package com.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class GraphAdjacencyList {

	Map<Integer,List<Integer>> vertices =  new HashMap<Integer,List<Integer>>();
	
    public void addVertex(int key){
    	vertices.put(key, new ArrayList<Integer>());
    	
    }
    
    
    public void addEdge(int v1,int v2){
    	if(!vertices.get(v1).contains(v2) && !vertices.get(v2).contains(v1)){
    	vertices.get(v1).add((Integer)v2);
    	vertices.get(v2).add((Integer)v1);
    	}
    	
    	else{
    		System.out.println(" Edge already Exists!");
    	}
    }
    
    
    public void removeEdge(int v1,int v2){
    	vertices.get(v1).remove((Integer)v2);
    	vertices.get(v2).remove((Integer)v1);
    	    }
    
    
    public int size(){
    	return vertices.size();
    }
    
	public void printGraph(){
		
		
		for (Map.Entry<Integer, List<Integer>> entry : vertices.entrySet()) {
		    Integer key = entry.getKey();
		    System.out.print("Vertex : "+key +" -> ");
		   
		    
		    for(Integer val:entry.getValue()){
		    	System.out.print(" "+val+" ,");
		    }
		   System.out.println();
		}
		System.out.println();
	}
	
	
	
public void printGraph2(){
		
		
		for (Map.Entry<Integer, List<Integer>> entry : vertices.entrySet()) {
		    Integer key = entry.getKey();
		    System.out.print("Vertex : "+key +" -> ");
		   
		    
		    for(Integer val:entry.getValue()){
		    	System.out.print(" "+val+" ,");
		    }
		   System.out.println();
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {

		
		GraphAdjacencyList graph =  new GraphAdjacencyList();
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		
		graph.addEdge(1, 2);
		
		
		graph.printGraph();
	}

}
