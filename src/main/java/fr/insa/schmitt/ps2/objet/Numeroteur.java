/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import java.util.HashMap;

/**
 *
 * @author schmi
 * @param <T>
 */
public class Numeroteur<T> {
    
    private HashMap<Integer, T> map;
    private HashMap<T, Integer> tmap;
    private int nbr;
    
    public Numeroteur (int nbr){
        
        this.map = new HashMap<>();
        this.tmap = new HashMap<>();
        this.nbr = nbr;  
    }
    public Numeroteur (){
        this(0);
    }
    
    public T getObject(int n){
        return this.getMap().get(n);
    }

    public int getIndex(T N){
        return this.getTmap().get(N);       
    }

    public int add(T N){
        if(this.tmap.containsKey(N)){
            throw new Error("Object" + N + "déjà dans le numéroteur");
        }
        this.tmap.put(N, nbr);
        this.map.put(nbr, N);
        this.nbr +=1;
        return this.nbr - 1;
    }

    public boolean objExiste(T N){
        return this.tmap.containsKey(N);
    }
    public boolean idExist(int id) {
        return this.map.containsKey(id);
    }
    
    public int getOrAdd(T N){
        
        if (this.objExiste(N)){
            return this.tmap.get(N);
        }else{
            return this.add(N);
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
    
    public void associe(int id,T N) {
        if (this.idExist(id)) {
            throw new Error("identificateur existant");
        }
        this.map.put(id, N);
        this.tmap.put(N, id);
    }
}
