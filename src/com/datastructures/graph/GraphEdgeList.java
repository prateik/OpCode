package com.datastructures.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


// undirected weighted graph 

class Edge{
	
	int vertexOne;
	int vertexTwo;
	int edgeWeight;
	
	public Edge(int v1,int v2,int weight){
		this.vertexOne = v1;
		this.vertexTwo = v2;
		this.edgeWeight = weight;
	}

}



public class GraphEdgeList {

	int graphSize;
  List<Edge> edges;
  Set<Integer> vertices;
  
  public GraphEdgeList(int graphSize) {
	  edges = new ArrayList<Edge>();
	  vertices = new HashSet<Integer>();
	  
	  this.graphSize = graphSize;
}
  
  
  public void addVertex(int v){
	  if(vertices.size() < graphSize){
	  vertices.add(new Integer(v));
	  }
  }
  
  
  public void addEdge(int v1,int v2,int edgeWeight){
	  
	  if(vertices.contains((Integer)v1) && vertices.contains((Integer)v2)){
	  edges.add(new Edge(v1,v2,edgeWeight));
	  edges.add(new Edge(v2,v1,edgeWeight));
	  }
  }

  public void printEdges(){
	  for(Edge e:edges) System.out.println("Source : "+e.vertexOne+" Destination : "+e.vertexTwo+" Weight ; "+e.edgeWeight);
  }
  
  
  public void printVertices(){
	  Iterator<Integer> iterator = vertices.iterator();
	  while(iterator.hasNext())
	  {
		  System.out.println(" Vertex :"+iterator.next());
	  }
  }
  
  
  
	public static void main(String[] args) {


		GraphEdgeList graph = new GraphEdgeList(10);
		for(int i=0;i < 10;i++)
		{}
		
	
		
	//	graph.addEdge(v1, v2, edgeWeight);
		
	}

}
