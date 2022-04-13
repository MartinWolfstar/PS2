/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author schmi
 */
public class Trellis {
    
    private List<Barres> barres;
    private List<Noeud> noeud;

    /**
     * @return the barres
     */
    public List<Barres> getBarres() {
        return barres;
    }

    /**
     * @param barres the barres to set
     */
    public void setBarres(List<Barres> barres) {
        this.barres = barres;
    }

    /**
     * @return the noeud
     */
    public List<Noeud> getNoeud() {
        return noeud;
    }

    /**
     * @param noeud the noeud to set
     */
    public void setNoeud(List<Noeud> noeud) {
        this.noeud = noeud;
    }
    
    public Trellis (){
        
        this.noeud = new ArrayList<Noeud>();
        this.barres = new ArrayList<Barres>();

    }
    
    @Override
    public String toString() {
        return "barres de ce Trellis :" + this.barres + "\n noeuds de ce trellis; " + this.noeud;
    }
    
    public int maxIdNoeud (){
        int max = 0;
        for(int i = 0 ; i < noeud.size(); i++)
            if (noeud.get(i).getIdentificateur() > max){
                max = noeud.get(i).getIdentificateur();
            }
        return max;
    }
    public int maxIdBarres (){
        int max = 0;
        for(int i = 0 ; i < barres.size(); i++)
            if (barres.get(i).getIdentificateur() > max){
                max = barres.get(i).getIdentificateur();
            }
        return max;
    }
    
    public void ajouteNoeud(Noeud n){
        for(Noeud inoeud : noeud){
            if ((n.getPx() == inoeud.getPx())&&(n.getPy() == inoeud.getPy())) {
                throw new Error("figure déjà");
            }
        }
        int idmax = maxIdNoeud ();
        int idnew = idmax + 1;
        
        n.setIdentificateur(idnew);
        noeud.add(n);
    }

    
    public void ajouteBarres(Barres b){
        
        Noeud noeud1 = b.getNd();
        Noeud noeud2 = b.getNa();
        
        for(Noeud inoeud : noeud){
            if ((noeud1.getPx() != inoeud.getPx())||(noeud1.getPy() != inoeud.getPy())) {
                ajouteNoeud(noeud1);
            }
            if ((noeud2.getPx() != inoeud.getPx())||(noeud2.getPy() != inoeud.getPy())) {
                ajouteNoeud(noeud2);
            }
        }
        
        for(Barres ibarres : barres){
            if ((b.getNd() == ibarres.getNd())&&(b.getNa() == ibarres.getNa())) {
                throw new Error("figure déjà");
            }
        }
        int idmax = maxIdBarres ();
        int idnew = idmax + 1;
        
        b.setIdentificateur(idnew);
        barres.add(b);
    }
}
