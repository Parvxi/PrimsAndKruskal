/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cpcs324_projectp1;

import java.util.ArrayList;
import java.util.List;


public class Vertex {
    
   

private String label;
private boolean isVisited;
private List<Edge> adjList;
private int key;


    public Vertex(String label) {
        this.label = label;
        this.isVisited = false;
        this.adjList = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<Edge> getAdjList() {
        return adjList;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setAdjList(List<Edge> adjList) {
        this.adjList = adjList;
    }
    


public void addAdjacentVertex(Vertex vertex, int weight) {
    Edge edge = new Edge(vertex, vertex, weight); 
    adjList.add(edge);
}

    public boolean isIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

public void displayInfo() {
    System.out.println("Label: " + label);
    System.out.println("Visited: " + isVisited);
    System.out.println("Adjacent Vertices:");
    for (Edge edge : adjList) {
        
        Vertex vertex = edge.targetVertex;
        if (vertex != null) {
            System.out.println(vertex.getLabel());
        }
    }
}

public boolean searchForVertex(String tLabel) {
    if (tLabel.equals(label)) {
        return true;
    }
    return false;
    

}

boolean searchForVertex(int tLabel) {
    return key == tLabel;
}

    public Vertex(int key, String label) {
        this.key = key;
        // Rest of the constructor
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

}