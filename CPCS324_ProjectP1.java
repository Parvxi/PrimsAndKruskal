/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cpcs324_projectp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *
 * @author SHAD
 */
public class CPCS324_ProjectP1 {
 
    public static void main(String[] args) throws FileNotFoundException {
        
        
        Graph graph = new Graph();
        String fileName;
        fileName = "C:\\Users\\Desktop\\PROJECTTEXT.txt\\";
        graph.readGraphFromFile(fileName);
   Scanner sc= new Scanner(System.in);
    }
    {
          
    
                Scanner sc= new Scanner(System.in);
		System.out.println("enter the number of vertex");
		int n=sc.nextInt(); // no of nodes in a graph
		System.out.println("enter the no of edges ");
		int m=sc.nextInt(); // no of edges in a graph
		int i=0;
		
               Graph obj = new Graph();
               obj.makeGraph(n, m, false);
	}
    }

    

