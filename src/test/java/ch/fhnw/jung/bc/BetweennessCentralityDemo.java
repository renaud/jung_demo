package ch.fhnw.jung.bc;

import edu.uci.ics.jung.algorithms.scoring.BetweennessCentrality;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.io.MatrixFile;

public class BetweennessCentralityDemo {

	public static void main(String[] args) {

		@SuppressWarnings({ "unchecked", "rawtypes" })
		MatrixFile<Vertex, Edge> mf = new MatrixFile(null,
				Factories.graphFactory, Factories.vertexFactory,
				Factories.edgeFactory);
		Graph<Vertex, Edge> g = mf.load("adjMat_ref.txt");
		System.out.println("Loaded Graph:\n" + g);

		BetweennessCentrality<Vertex, Edge> bc = new BetweennessCentrality<Vertex, Edge>(
				g);
		for (Vertex v : g.getVertices()) {
			System.out.println("BetweennessCentrality for\t" + v + "\t" + bc.getVertexScore(v));
		}
	}
}
