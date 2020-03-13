package com.logesh.manual;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.Multigraph;

public class TestGraphOps {

	public static void main(String[] args) {

		GraphOps graph = new GraphOps();

		graph.addVertex("ctnInv");
		graph.addVertex("portInd");
		graph.addVertex("minFinder");
		graph.addVertex("nlFiltered");
		graph.addVertex("minUpdated");
		graph.addVertex("finalRs");

		graph.addEdge("ctnInv", "portInd");
		graph.addEdge("portInd", "minFinder");
		graph.addEdge("portInd", "nlFiltered");
		graph.addEdge("minFinder", "finalRs");
		graph.addEdge("nlFiltered", "minFinder");
		graph.addEdge("nlFiltered", "minUpdated");
		graph.addEdge("minUpdated", "finalRs");

		System.out.println("Dfs" + depthFirstTraversal(graph, "ctnInv"));
		;

		System.out.println("bfs:" + breadthFirstTraversal(graph, "ctnInv"));
		;

	}

	static Set<String> depthFirstTraversal(GraphOps graph, String root) {
		Set<String> visited = new LinkedHashSet<String>();
		Stack<String> stack = new Stack<String>();
		stack.push(root);
		while (!stack.isEmpty()) {
			String attribute = stack.pop();
			if (!visited.contains(attribute)) {
				visited.add(attribute);
				for (Attribute v : graph.getAdjVertices(attribute)) {
					stack.push(v.getElementName());
				}
			}
		}
		return visited;
	}

//[ctnInv, portInd, nlFiltered, minUpdated, finalRs, minFinder]
//	 bfs:[ctnInv, portInd, minFinder, nlFiltered, finalRs, minUpdated]

	static Set<String> breadthFirstTraversal(GraphOps graph, String root) {
		Graph<String, DefaultEdge> g = new Multigraph<>(DefaultEdge.class);
		
		Set<String> visited = new LinkedHashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.add(root);
		visited.add(root);
		while (!queue.isEmpty()) {
			String vertex = queue.poll();
			for (Attribute v : graph.getAdjVertices(vertex)) {
				if (!visited.contains(v.getElementName())) {
					visited.add(v.getElementName());
					queue.add(v.getElementName());
				}
			}
		}
		return visited;
	}
}
