package graphFramework;
import java.util.LinkedList;

public class Vertex {

    // --- Data Fields --- \\
    public int label; 
    Boolean isVisited;
    LinkedList<Edge> adjList; 

    public Vertex() {
        adjList = new LinkedList<>();
    }
    /**
     * Constructor for creating a Vertex with a given label.
     *
     * @param label The label of the vertex.
     */
    public Vertex(int label) {
        this.label = label;
        this.isVisited = false;
        adjList = new LinkedList<>();
    }
    /**
     * Retrieves information about the vertex.
     *
     * @return Information about the vertex.
     */
    public String displayInfo() {
        return null;
    }

}
