package graphFramework;

import java.util.Iterator;
public class SingleSourceSPAlg extends ShortestPathAlgorithm {

 

    public SingleSourceSPAlg(Graph graph) {
        super(graph);
    }

    /**
     * Computes the shortest paths using Dijkstra's algorithm.
     * 
     * @param graph The graph to compute the shortest paths on.
     */
    public void computeDijkstraAlg(Graph graph) {
        distance = new int[graph.vertices.length];
        path = new String[graph.vertices.length];

        for (int i = 0; i < graph.vertices.length; i++) {
            distance[i] = infinity;
        }

        distance[0] = 0;
        Vertex src = graph.vertices[0].adjList.get(0).source;
        path[0] = src.displayInfo();

        for (int i = 0; i < graph.vertices.length - 1; i++) {
            int u = findMinDistance(distance);
            graph.vertices[u].isVisited = true;

            Iterator<Edge> iterator = graph.vertices[u].adjList.iterator();

            while (iterator.hasNext()) {
                Edge edge = iterator.next();

                if (!graph.vertices[edge.target.label].isVisited && edge.weight != infinity && edge.weight != 0) {
                    if (distance[u] + edge.weight < distance[edge.target.label]) {
                        distance[edge.target.label] = distance[u] + edge.weight;
                        path[edge.target.label] = path[u] + " - " + edge.target.displayInfo();
                    }
                }
            }
        }
    }

    /**
     * Finds the vertex with the minimum distance value.
     * 
     * @param smallestDistance The array of distances.
     * @return The index of the vertex with the minimum distance.
     */
    public int findMinDistance(int[] smallestDistance) {
        int u = 0;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < graph.vertices.length; i++) {
            if (!graph.vertices[i].isVisited && smallestDistance[i] < minDistance) {
                minDistance = smallestDistance[i];
                u = i;
            }
        }
        return u;
    }

    /**
     * Displays the computed shortest paths and their route lengths.
     */
    public void DisplayResult() {
        String routerName = String.valueOf((char) (graph.vertices[0].label + 65));
        System.out.println("The starting point location is " + routerName);
        System.out.println("\nThe routes from location " + routerName + " to the rest of the locations are:");

        for (int i = 1; i < graph.numberOfVertices; i++) {
            System.out.println("\nRoute from " + path[0] + " to " + path[i]);
            System.out.println("Route: " + path[i] + " (Route Length: " + distance[i] + ")");
        }
    }
}
