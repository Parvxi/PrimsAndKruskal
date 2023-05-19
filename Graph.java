package com.mycompany.cpcs324_projectp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//-------------------------------------------------------------------------------------------------
public class Graph {
    private int verticesNo = 0;
    private int edgeNo;
    private boolean isDigraph;
    private List<Vertex> vertices;

    public Graph() {
        this.verticesNo = 0;
        this.edgeNo = 0;
        this.isDigraph = false;
        this.vertices = new ArrayList<>();
    }
    
    public Graph(int verticesNo, int edgeNo) { 
     this.edgeNo = edgeNo; 
     this.verticesNo = verticesNo; 
 
    } 
    
    public void setIsDigraph(boolean isDigraph) { 
        this.isDigraph = isDigraph; 
    } 
 
    public void setVerticesNo(int verticesNo) { 
        this.verticesNo = verticesNo; 
    } 
 
    public void setEdgeNo(int edgeNo) { 
        this.edgeNo = edgeNo; 
    } 
 
    public int getEdgeNo() { 
        return edgeNo; 
    } 
 
    
//-------------------------------------------------------------------------------------------------
public void makeGraph(int numVertices, int numEdges, boolean isDigraph) {
    vertices.clear(); // Clear the vertices list before creating a new graph
     int verticesNo = numVertices;
     int edgesNo = numEdges;

        int edgeCount = 0;
        


        for (int i = 0; i < verticesNo; i++) {//While loop \ 
            vertices.add(new Vertex(Integer.toString(i))); // to fill vertices array with all expected verexices 
            //vertices.get(i).setKey(i); 
            System.out.println(vertices.get(i).getKey()); 
        } 
        int sLabel; 
        int tLabel;
    // Create vertices with random labels
    for (int i = 0; i < numVertices; i++) {
        String label = generateRandomLabel();
        Vertex vertex = new Vertex(label);
        vertices.add(vertex);
    }
    
          // System.out.println("looop"); 
        //System.out.println("Edge no " + edgesNo); 
        for (int i = 0; i < edgesNo; i++) { 
            sLabel = (int) (Math.random() * verticesNo); 
            tLabel = (int) (Math.random() * verticesNo); 
 
            int weight = (int) (1 + Math.random() * 20); 
 
            // System.out.println("sLabel " + sLabel + " tLabel " + tLabel); 
if ((sLabel == tLabel) || vertices.get(sLabel).searchForVertex(tLabel)) {
    // Since this iteration should not be counted, decrease i
    // System.out.println("ignore " + sLabel + " and " + tLabel);

    i--;
    continue; // Skip this iteration
}
Edge edge = new Edge(vertices.get(sLabel),vertices.get(tLabel), weight);
vertices.get(sLabel).getAdjList().add(edge);

edge = new Edge(vertices.get(sLabel),vertices.get(tLabel), weight);
vertices.get(tLabel).getAdjList().add(edge);

edgeCount++;


        } 
        
        
        
System.out.println("MAKE GRAPH RESULT");
for (int i = 0; i < vertices.size(); i++) {
    System.out.println("Source " + vertices.get(i).getLabel());
    for (int j = 0; j < vertices.get(i).getAdjList().size(); j++) {
        System.out.println("  Target: " + vertices.get(i).getAdjList().get(j).getTargetVertex().getLabel() + ", Weight: " + vertices.get(i).getAdjList().get(j).getWeight());
    }
}

 
//        System.out.println("inner "+ inner); 
        System.out.println("edgeCount " + edgeCount); 
  
    } 


//-------------------------------------------------------------------------------------------------

public void readGraphFromFile(String fileName) throws FileNotFoundException {
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);

    String type = scanner.nextLine(); // Read the type of graph (graph or digraph)
    isDigraph = type.equalsIgnoreCase("digraph");
    System.out.println(type);
    verticesNo = scanner.nextInt();
    edgeNo = scanner.nextInt();
    scanner.nextLine();
    // Second loop for adding edges
while (scanner.hasNextLine()) {
    String line = scanner.nextLine(); // Read the entire line
    String[] parts = line.split(" ");
    String sourceLabel = parts[0]; // Extract the source label
    String targetLabel = parts[1]; // Extract the target label
    int weight = Integer.parseInt(parts[2]); // Extract the weight and convert it to an integer
    
    Vertex sourceVert = getVertexByLabel(sourceLabel);
    Vertex targetVert = getVertexByLabel(targetLabel);
    addEdge(sourceVert, targetVert, weight);
    
        System.out.println("Source Vertex: " + sourceLabel);
        System.out.println("Target Vertex: " + targetLabel);
       // System.out.println("Parent Vertex: " + parentVertex.getLabel());
        System.out.println("Weight: " + weight);
    
}
}



//-------------------------------------------------------------------------------------------------
    
private void addEdge(Vertex sourceVert, Vertex targetVert, int weight) {
    if (sourceVert != null && targetVert != null) {
        Edge edge = new Edge(sourceVert, targetVert, weight);
        sourceVert.getAdjList().add(edge);

        if (!isDigraph) {
            edge = new Edge(targetVert, sourceVert, weight);
            targetVert.getAdjList().add(edge);
        }
    }
}
//-------------------------------------------------------------------------------------------------
private String generateRandomLabel() {
    Random random = new Random();
    int alphabetSize = 26; // Total number of letters in the alphabet
    char randomLetter = (char) ('A' + random.nextInt(alphabetSize)); // Generate a random letter from A to Z
    return String.valueOf(randomLetter); // Convert the letter to a string and return it as the label
}

//-------------------------------------------------------------------------------------------------
    private void connectGraph() {
        // Connect the graph to ensure it is connected
        // You can implement your own logic here based on the graph requirements
        // This is just a simple example to connect all vertices together

        for (int i = 0; i < verticesNo - 1; i++) {
            addEdge(vertices.get(i), vertices.get(i + 1), generateRandomWeight());
        }
        if (!isDigraph) {
            addEdge(vertices.get(verticesNo - 1), vertices.get(0), generateRandomWeight());
        }
    }
//-------------------------------------------------------------------------------------------------
public Vertex getVertexByLabel(String label) {
    for (Vertex vertex : vertices) {
        if (vertex.getLabel().equals(label)) {
            return vertex;
        }
    }
    return null; // Vertex with the specified label not found
}


    public int getVerticesNo() { 
        return verticesNo; 
    } 
 
    public int getVerticesSize() { 
        return vertices.size(); 
    } 
 
    public Vertex getVertex(int inx) { 
        return vertices.get(inx); 
    } 

 int generateRandomWeight() {
    Random random = new Random();
    return random.nextInt(10) + 1; // Random weight from 1 to 10
}
    public List<Vertex> getVertices() {
        return vertices;
    }



public Vertex getVertexByNo(int i) {
    String label = String.valueOf((char) ('A' + i));
    for (Vertex element : vertices) {
        if (element.getLabel().equals(label)) {
            return element;
        }
    }
    return null;
}

}