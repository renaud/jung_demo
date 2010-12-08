package ch.fhnw.jung.bc;

class Vertex {
	int id;

	public Vertex(int id) {
		this.id = id;
	}

	public String toString() {
		return "V" + id;
	}
}