package com.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Vertex<T>
{
	T key;
	boolean visited;
	
	public Vertex(T key){
		this.key = key;
	}
}

public class Graph<T> {

	Map<Vertex<T>,List<Vertex<T>>> vertices;
	
	Graph(){
	
		vertices = new HashMap<Vertex<T>,List<Vertex<T>>>();
	}
	
	public Vertex<T> getVertex(T key)
	{
		for(Vertex<T> v:vertices.keySet())
		{
			if (v.key == key) return v;
		}
		
		return null;
	}
	
	
	public List<Vertex<T>> getAdjacentVertices(T key)
	{
		return vertices.get(getVertex(key));
	}
	public void addVertex(T data){
		
		Vertex<T> newVextex = new Vertex<T>(data);
		vertices.put(newVextex,new ArrayList<Vertex<T>>());
	}
	
	
	public void addEdge(T vertex1,T vertex2)
	{
		Vertex<T> v1 = getVertex(vertex1);
		Vertex<T> v2 = getVertex(vertex2);
		
		vertices.get(v1).add(v2);
		vertices.get(v2).add(v1);
	}
	
	public void printGraph(){
		
		for(Vertex<T> v: vertices.keySet()){
			
			System.out.print(v.key+" : ");
			for(Vertex<T> adjVertex:vertices.get(v))
			{
				
				System.out.print(adjVertex.key+" , ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {

		Graph<String> graph = new Graph<String>();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		
		graph.addEdge("A", "B");
		graph.addEdge("C", "A");
		graph.addEdge("D", "B");
		
		graph.printGraph();
		Graph<Integer> graph1 = new Graph<Integer>();
		graph1.addVertex(1);
		graph1.addVertex(2);
		graph1.addVertex(3);
		graph1.addVertex(4);
        graph1.addEdge(1,2);
        graph1.addEdge(2,4);
		graph1.printGraph();
		
		
		
	}

}
