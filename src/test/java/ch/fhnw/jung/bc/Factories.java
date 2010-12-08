package ch.fhnw.jung.bc;

import org.apache.commons.collections15.Factory;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;

public class Factories {

	public static Factory<Graph<Vertex, Edge>> graphFactory = new Factory<Graph<Vertex, Edge>>() {
		public Graph<Vertex, Edge> create() {
			return new SparseGraph<Vertex, Edge>();
		}
	};

	public static Factory<Vertex> vertexFactory = new Factory<Vertex>() {
		int n = 0;

		public Vertex create() {
			return new Vertex(n++);
		}
	};

	public static Factory<Edge> edgeFactory = new Factory<Edge>() {
		int n = 0;

		public Edge create() {
			return new Edge(n++);
		}
	};
}
