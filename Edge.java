/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cpcs324_projectp1;

/**
 *
 * @author SHAD
 */


public class Edge implements Comparable<Edge> {

    private int weight;
     Vertex sourceVertex;
     Vertex targetVertex;
    // Vertex parentVertex;
     
     //    Edge edge = new Edge(this, vertex, weight); 
    public Edge(Vertex sourceVertex, Vertex targetVertex, int weight) {
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    public Vertex getSourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(Vertex sourceVertex) {
        this.sourceVertex = sourceVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }
    public Edge(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(weight, o.weight);
    }
    
        public void displayInfo() {
        System.out.println("Source Vertex: " + sourceVertex.getLabel());
        System.out.println("Target Vertex: " + targetVertex.getLabel());
       // System.out.println("Parent Vertex: " + parentVertex.getLabel());
        System.out.println("Weight: " + weight);
    }

}