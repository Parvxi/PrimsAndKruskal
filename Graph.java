
package graphFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import AlgorithmProjectPart2.AFRouteMap;




public class Graph {

// Data Fields
public int numberOfVertices;
int numberOfEdges;
boolean isDirected;
public Vertex[] vertices;


/**
 * Constructor to be used for the Make Graph function.
 * Constructs a graph with the specified number of vertices, edges, and whether it is directed or not.
 * @param numberOfVertices The number of vertices in the graph.
 * @param numberOfEdges The number of edges in the graph.
 * @param isDirected Indicates if the graph is directed or not.
 */
public Graph(int numberOfVertices, int numberOfEdges, boolean isDirected) {
    this.numberOfVertices = numberOfVertices;
    this.numberOfEdges = numberOfEdges;
    this.isDirected = isDirected;
    this.vertices = new Vertex[numberOfVertices];
}

/**
 * Constructor to be used for the Read Graph from File function.
 */
public Graph() {
}

/**
 * Creates a new vertex with the given label.
 * @param label The label of the vertex.
 * @return The created vertex.
 */
public Vertex createVertex(int label) {
    return new Vertex(label);
}

/**
 * Creates a new edge with the given source, target, and weight.
 * @param source The source vertex of the edge.
 * @param target The target vertex of the edge.
 * @param weight The weight of the edge.
 * @return The created edge.
 */
public Edge createEdge(Vertex source, Vertex target, int weight) {
    return new Edge(source, target, weight);
}

/**
 * Adds an edge to the graph between the given vertices with the specified weight.
 * If the graph is undirected, it adds the opposite edge as well.
 * @param v The index of the source vertex.
 * @param u The index of the target vertex.
 * @param weight The weight of the edge.
 * @return The created edge.
 */
public Edge addEdge(int v, int u, int weight) {
    Graph g = new AFRouteMap();

    // Check if the vertices[v] is null to avoid duplicates
    if (vertices[v] == null) {
        numberOfVertices++; // Increment the number of vertices first to avoid size problems
        vertices[v] = g.createVertex(v); // Create a new source vertex in the array of vertices
    }

    // Check if the vertices[u] is null to avoid duplicates
    if (vertices[u] == null) {
        numberOfVertices++; // Increment the number of vertices first to avoid size problems
        vertices[u] = g.createVertex(u); // Create a new target vertex in the array of vertices
    }

    // Create a new edge
    Edge newEdge = g.createEdge(vertices[v], vertices[u], weight);
    numberOfEdges++; // Increase the number of edges

    // Access the vertex's adjacent list and add the edge with its weight
    vertices[v].adjList.add(newEdge);

    // If the graph is undirected
    if (!isDirected) {
        // Add the opposite edge (undirected)
        newEdge = g.createEdge(vertices[u], vertices[v], weight);
        numberOfEdges++; // Increase the number of edges

        // Access the vertex's adjacent list and add the edge with its weight
        vertices[u].adjList.add(newEdge);
    }

    return newEdge;
}

/**
 * Reads a graph from a file and initializes the graph accordingly.
 * @param fileName The name of the file to read from.
 * @throws FileNotFoundException If the file is not found.
 */
public void readGraphFromFile(File fileName) throws FileNotFoundException {
    Scanner input = new Scanner(fileName);

    String graphType = input.nextLine();
    if (graphType.equalsIgnoreCase("digraph 0")) {
        isDirected = false;
    } else if (graphType.equalsIgnoreCase("digraph 1")) {
        isDirected = true;
    }

    int totalNumberOfVertices = input.nextInt();
    int totalNumberOfEdges = input.nextInt();

    if (!isDirected) {
        totalNumberOfEdges *= 2;
    }

    vertices = new Vertex[totalNumberOfVertices];

    while (numberOfEdges < totalNumberOfEdges) {
        char source = input.next().charAt(0);
        char destination = input.next().charAt(0);
        int weight = input.nextInt();

        addEdge(source - 65, destination - 65, weight);
    }

    input.close();
}

/**
 * Constructs a graph with the specified number of vertices and edges.
 * The graph is randomly initialized with vertices' labels, randomly connects the vertices with edges,
 * and assigns random weights to the edges. The resulting graph is connected.
 * @param numberOfVertices The number of vertices in the graph.
 * @param numberOfEdges The number of edges in the graph.
 */
public void makeGraph(int numberOfVertices, int numberOfEdges) {
    for (int i = 0; i < numberOfVertices; i++) {
        vertices[i] = new Vertex(i);
    }

    for (int i = 0; i < numberOfVertices - 1; i++) {
        addEdge(vertices[i].label, vertices[i + 1].label, (int) (1 + Math.random() * 10));
    }

    int i = 0;
    while (i < (numberOfEdges - (numberOfVertices - 1))) {
        int vertexU = (int) (Math.random() * numberOfVertices);
        int vertexV = (int) (Math.random() * numberOfVertices);

        if (vertexU == vertexV) {
            continue;
        }

        for (int j = 0; j < vertices[vertexU].adjList.size(); j++) {
            if (vertices[vertexU].adjList.get(j).target.label != vertexV) {
                break;
            }
        }

        addEdge(vertices[vertexU].label, vertices[vertexV].label, (int) (1 + Math.random() * 10));
        i++;
    }
}
}