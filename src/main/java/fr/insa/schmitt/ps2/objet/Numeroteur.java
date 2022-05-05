/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author schmi
 */
public class Numeroteur<T> {
    
    private HashMap<Integer, T> map;
    private HashMap<T, Integer> tmap;
    private int nbr;
    
    public Numeroteur (){
        
        map = new HashMap<Integer, T>();
        tmap = new HashMap<T, Integer>();
        nbr = 0;
        
    }
    
    public T getObject(int n){
        return getMap().get(n);
    }

    public int getIndex(T N){
        return getTmap().get(N);       
    }

    public void add(T N){
        getTmap().put(N, nbr);
        getMap().put(nbr, N);
        nbr +=1;
    }

    public void getOrAdd(T N){
        
        if (getTmap().get(N) == null){
            this.add(N);
        }else{
            this.getIndex(N);
        }
    }

    /**
     * @return the map
     */
    public HashMap<Integer, T> getMap() {
        return map;
    }
    /**
     * @return the tmap
     */
    public HashMap<T, Integer> getTmap() {
        return tmap;
    }
    
}
