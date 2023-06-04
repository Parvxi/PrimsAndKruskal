package graphFramework;

public class Edge {

    // Data Fields
    int weight;
    Vertex source;
    Vertex target;
    Vertex parent;

    public Edge() {
        source = new Vertex(); // Create a new source vertex
        target = new Vertex(); // Create a new target vertex
        parent = new Vertex(); // Create a new parent vertex
    }

    /**
     * Constructor with parameters.
     *
     * @param source The source vertex of the edge.
     * @param target The target vertex of the edge.
     * @param weight The weight of the edge.
     */
    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        parent = new Vertex();
    }

    // Methods

    /**
     * Display information about the edge.
     */
    public void displayInfo() {
        // Implement the logic to display edge information
    }

} // End of Class
