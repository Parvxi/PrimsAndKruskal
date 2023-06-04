
package AlgorithmProjectPart2;

import graphFramework.Edge;
import graphFramework.Graph;
import graphFramework.Vertex;


public class AFRouteMap extends Graph {

	public AFRouteMap() {
		// TODO Auto-generated constructor stub
	}

	// Create Vertex
	@Override
	public Vertex createVertex(int label) {
		return new Location(label);
	}

	// Create Edge
	@Override
	public Edge createEdge(Vertex source, Vertex target, int weight) {
		return new Route(source, target, weight);
	}

}