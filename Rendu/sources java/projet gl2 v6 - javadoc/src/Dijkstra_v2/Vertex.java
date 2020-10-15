package Dijkstra_v2;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Vertex.
 */
public class Vertex implements Comparable<Vertex> {
    
    /** The name. */
    private String name;
    
    /** The edges. */
    private List<Edge> edges;
    
    /** The visited. */
    private boolean visited;
    
    /** The previos vertex. */
    private Vertex previosVertex;
    
    /** The min distance. */
    private double minDistance = Double.MAX_VALUE;

    /**
     * Instantiates a new vertex.
     *
     * @param name the name
     */
    public Vertex(String name) {
        this.name = name;
        this.edges = new ArrayList<>();
    }

    /**
     * Adds the neighbour.
     *
     * @param edge the edge
     */
    public void addNeighbour(Edge edge) {
        this.edges.add(edge);
    }

    /**
     * Gets the edges.
     *
     * @return the edges
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * Sets the edges.
     *
     * @param edges the new edges
     */
    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    /**
     * Checks if is visited.
     *
     * @return true, if is visited
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Sets the visited.
     *
     * @param visited the new visited
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Gets the previos vertex.
     *
     * @return the previos vertex
     */
    public Vertex getPreviosVertex() {
        return previosVertex;
    }

    /**
     * Sets the previos vertex.
     *
     * @param previosVertex the new previos vertex
     */
    public void setPreviosVertex(Vertex previosVertex) {
        this.previosVertex = previosVertex;
    }

    /**
     * Gets the min distance.
     *
     * @return the min distance
     */
    public double getMinDistance() {
        return minDistance;
    }

    /**
     * Sets the min distance.
     *
     * @param minDistance the new min distance
     */
    public void setMinDistance(double minDistance) {
        this.minDistance = minDistance;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Compare to.
     *
     * @param otherVertex the other vertex
     * @return the int
     */
    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.minDistance, otherVertex.minDistance);
    }

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
}