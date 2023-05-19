/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cpcs324_projectp1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SHAD
 */
public abstract class MSTAlgorithm {
    
    
    
    List<Edge> MSTResultList;

    public MSTAlgorithm() {
        MSTResultList = new ArrayList<>();
    }

    public abstract void displayResultingMST();
  
}
    
    
    
    

