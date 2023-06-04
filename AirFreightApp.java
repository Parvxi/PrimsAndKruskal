
// Ghaida Alsayed - 2005501 (CP1)
// Shahad Hatem Balkhashir - 2006676 (B8)
// Amina Rajkhan - 2010077
// Tala Aldhahri - 2009168
// Refrences: https://yuminlee2.medium.com/kruskals-algorithm-minimum-spanning-tree-db96e91d0aed
// (1)	Levitin, A. (2011). Introduction to the Design and Analysis of Algorithms. Pearson Higher Ed.

package AlgorithmProjectPart2;
import graphFramework.Graph;
import graphFramework.SingleSourceSPAlg;
import java.io.File;
import java.io.FileNotFoundException;

public class AirFreightApp {

    public static void main(String[] args) throws FileNotFoundException {

        int verticesNO = 0;
        int edgesNO = 0;
        boolean isDigraph = false;

        // Phase 2: Reading from Graph Function
        System.out.println("\n\n\t\t☆ﾟ.*･｡- Phase#2: Reading from Graph Function -╰(✿˙ᗜ˙)੭━☆ﾟ.*･｡ﾟ\n\n");

        // Read graph from a file
        File graphFile = new File("sampleInput.txt");
        Graph D_graph = new Graph();
        D_graph.readGraphFromFile(graphFile);

        // Perform Dijkstra's algorithm on the graph
        SingleSourceSPAlg dijkstra = new SingleSourceSPAlg(D_graph);
        dijkstra.computeDijkstraAlg(D_graph);
        dijkstra.DisplayResult();

        // Test Dijkstra's algorithm with different graph sizes
        System.out.println("\n\t\t\t");
        int[] vertices = {2000, 3000, 4000, 5000, 6000};
        int[] edges = {10000, 15000, 20000, 25000, 30000};

        for (int i = 0; i < vertices.length; i++) {
            verticesNO = vertices[i];
            edgesNO = edges[i];

            // Create a new graph with specified number of vertices and edges
            D_graph = new Graph(verticesNO, edgesNO, isDigraph);
            D_graph.makeGraph(verticesNO, edgesNO);

            // Perform Dijkstra's algorithm on the graph and measure runtime
            dijkstra = new SingleSourceSPAlg(D_graph);
            long startTime = System.currentTimeMillis();
            dijkstra.computeDijkstraAlg(D_graph);
            long finishTime = System.currentTimeMillis();

            // Print the runtime of Dijkstra's algorithm for the current graph size
            System.out.println("☆ﾟ.*･｡Dijkstra's algorithm completed in " + (finishTime - startTime) +
                    " milliseconds for n = " + verticesNO + " and m = " + edgesNO + "!⚡️\n");
        }
    }
}
