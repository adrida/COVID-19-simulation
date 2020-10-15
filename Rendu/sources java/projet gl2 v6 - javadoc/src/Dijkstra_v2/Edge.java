package Dijkstra_v2;

// TODO: Auto-generated Javadoc
/**
 * The Class Edge.
 */
public class Edge {
	
    /** The weight. */
    private double weight;
    
    /** The start vertex. */
    private Vertex startVertex;
    
    /** The target vertex. */
    private Vertex targetVertex;

    /**
     * Instantiates a new edge.
     *
     * @param weight the weight
     * @param startVertex the start vertex
     * @param targetVertex the target vertex
     */
    public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    /**
     * Gets the weight.
     *
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
	public String toString() {
		return "Edge [weight=" + weight + ", startVertex=" + startVertex.toString() + ", targetVertex=" + targetVertex.toString() + "]";
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Gets the start vertex.
     *
     * @return the start vertex
     */
    public Vertex getStartVertex() {
        return startVertex;
    }

    /**
     * Sets the start vertex.
     *
     * @param startVertex the new start vertex
     */
    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    /**
     * Gets the target vertex.
     *
     * @return the target vertex
     */
    public Vertex getTargetVertex() {
        return targetVertex;
    }

    /**
     * Sets the target vertex.
     *
     * @param targetVertex the new target vertex
     */
    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }
}