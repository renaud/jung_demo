package ch.fhnw.jung.bc;

import edu.uci.ics.jung.algorithms.scoring.EigenvectorCentrality;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.io.MatrixFile;

public class EigenvectorCentralityDemo {

	public static void main(String[] args) {

		String graphFile = "adjMat_2.txt";

		@SuppressWarnings({ "unchecked", "rawtypes" })
		MatrixFile<Vertex, Edge> mf = new MatrixFile(null,
				Factories.graphFactory, Factories.vertexFactory,
				Factories.edgeFactory);
		Graph<Vertex, Edge> g = mf.load(graphFile);
		System.out.println("Loaded Graph:\n" + g);

		EigenvectorCentrality<Vertex, Edge> ec = new EigenvectorCentrality<Vertex, Edge>(
				g);
		for (Vertex v : g.getVertices()) {
			System.out.println("EigenvectorCentrality for\t" + v + "\t"
					+ ec.getVertexScore(v));
		}
	}
}
