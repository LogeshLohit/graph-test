package com.logesh.jgrapht;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;

public class JGraphTImpl {

	public static void main(String[] args) throws IOException {
		Graph<String, DefaultEdge> graph = new DirectedAcyclicGraph<>(DefaultEdge.class);

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

//		BreadthFirstIterator<String, DefaultEdge> bfs = new BreadthFirstIterator<>(graph);
//
//		while (bfs.hasNext()) {
//			System.out.println(bfs.next());
//		}
		System.out.println(Graphs.predecessorListOf(graph, "finalRs"));

		JGraphXAdapter<String, DefaultEdge> graphAdapter = new JGraphXAdapter<String, DefaultEdge>(graph);
		mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
		layout.execute(graphAdapter.getDefaultParent());

		BufferedImage image = mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
		File imgFile = new File("D:\\Logesh\\file\\pics\\graph.png");
		ImageIO.write(image, "PNG", imgFile);
	}
}
