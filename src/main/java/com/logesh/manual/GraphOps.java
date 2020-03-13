package com.logesh.manual;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphOps {

	public  Map<Attribute, List<Attribute>> adjacentAttributes;

	public GraphOps(Map<Attribute, List<Attribute>> adjacentAttributes) {
		super();
		this.adjacentAttributes = adjacentAttributes;
	}

	public GraphOps() {
		this.adjacentAttributes = new LinkedHashMap<Attribute, List<Attribute>>();
	}

	public void addVertex(String attribute) {
		adjacentAttributes.putIfAbsent(new Attribute(attribute), new LinkedList<Attribute>());
	}

	public void addEdge(String source, String destination) {
		Attribute src = new Attribute(source);
		Attribute dest = new Attribute(destination);
		adjacentAttributes.get(src).add(dest);
		adjacentAttributes.get(dest).add(src);
	}

	public List<Attribute> getAdjVertices(String label) {
		return adjacentAttributes.get(new Attribute(label));
	}

	public Map<Attribute, List<Attribute>> getAdjacentAttributes() {
		return adjacentAttributes;
	}

	public void setAdjacentAttributes(Map<Attribute, List<Attribute>> adjacentAttributes) {
		this.adjacentAttributes = adjacentAttributes;
	}

	@Override
	public String toString() {
		return  adjacentAttributes+" ";
	}
	

}
