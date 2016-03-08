package com.datastructures.graph;


/**
 * 
 * @author prateik
 *
 *
 *
 */


public class PrimsMST {

	public static void main(String[] args) {
	
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
