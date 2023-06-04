/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphFramework;

/**
 *
 * @author SHAD
 */
public class ShortestPathAlgorithm {

    protected int[] distance;
    protected String[] path;
    protected Graph graph;
    protected int infinity;

    public ShortestPathAlgorithm(Graph graph) {
        this.graph = graph;
        infinity = Integer.MAX_VALUE;
    }
    
}