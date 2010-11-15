package ch.fhnw.jung;

import java.util.List;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * 
 * @author Dr. Greg M. Bernstein
 */
public class BasicDirectedGraph {

	static int edgeCount = 0;

	DirectedGraph<MyNode, MyLink> g;
	MyNode n1, n2, n3, n4, n5;

	/** Constructs an example directed graph with our vertex and edge classes */
	public void constructGraph() {

		g = new DirectedSparseMultigraph<MyNode, MyLink>();

		// Create some MyNode objects to use as vertices
		n1 = new MyNode(1);
		n2 = new MyNode(2);
		n3 = new MyNode(3);
		n4 = new MyNode(4);
		n5 = new MyNode(5);

		// Add some directed edges along with the vertices to the graph
		g.addEdge(new MyLink(2.0, 48), n1, n2, EdgeType.DIRECTED);
		g.addEdge(new MyLink(2.0, 48), n2, n3, EdgeType.DIRECTED);
		g.addEdge(new MyLink(3.0, 192), n3, n5, EdgeType.DIRECTED);
		g.addEdge(new MyLink(2.0, 48), n5, n4, EdgeType.DIRECTED);
		g.addEdge(new MyLink(2.0, 48), n4, n2); // In a directed graph the
		g.addEdge(new MyLink(2.0, 48), n3, n1); // first node is the source
		g.addEdge(new MyLink(10.0, 48), n2, n5);// and the second the
												// destination
	}

	public void calcUnweightedShortestPath() {

		DijkstraShortestPath<MyNode, MyLink> alg = new DijkstraShortestPath(g);
		List<MyLink> l = alg.getPath(n1, n4);

		System.out.println("Shortest unweighted path from " + n1 + " to " + n4
				+ " is:" + l.toString());
	}

	public void calcWeightedShortestPath() {
		
		Transformer<MyLink, Double> wtTransformer = new Transformer<MyLink, Double>() {
			public Double transform(MyLink link) {
				return link.weight;
			}
		};
		DijkstraShortestPath<MyNode, MyLink> alg = new DijkstraShortestPath(g,
				wtTransformer);
		
		List<MyLink> l = alg.getPath(n1, n4);
		Number dist = alg.getDistance(n1, n4);
		
		System.out.println("The shortest weighted path from " + n1 + " to "
				+ n4 + " is:");
		System.out.println(l.toString());
		System.out.println("and the length of the path is: " + dist);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		BasicDirectedGraph graphDemo = new BasicDirectedGraph();
		graphDemo.constructGraph();
		System.out.println(graphDemo.g.toString());
		graphDemo.calcUnweightedShortestPath();
		graphDemo.calcWeightedShortestPath();
	}

	class MyNode {
		int id;

		public MyNode(int id) {
			this.id = id;
		}

		public String toString() {
			return "V" + id;
		}
	}

	class MyLink {
		double capacity;
		double weight;
		int id;

		public MyLink(double weight, double capacity) {
			this.id = edgeCount++;
			this.weight = weight;
			this.capacity = capacity;
		}

		public String toString() {
			return "E" + id;
		}
	}
}
