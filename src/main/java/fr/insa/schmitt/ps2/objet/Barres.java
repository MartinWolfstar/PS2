/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import fr.insa.schmitt.ps2.*;
import java.lang.Math ;

/**
 *
 * @author schmi
 */
public class Barres extends Trellis{
    
    private Noeud nd;
    private Noeud na;
    private int identificateur;
    private int TC;
    private int CM;
    private int prix;

    /**
     * @return the nd
     */
    public Noeud getNd() {
        return nd;
    }

    /**
     * @param nd the nd to set
     */
    public void setNd(Noeud nd) {
        this.nd = nd;
        
    }

    /**
     * @return the na
     */
    public Noeud getNa() {
        return na;
    }

    /**
     * @param na the na to set
     */
    public void setNa(Noeud na) {
        this.na = na;
        
    }

    /**
     * @return the identificateur
     */
    public int getIdentificateur() {
        return identificateur;
    }

    /**
     * @param identificateur the identificateur to set
     */
    public void setIdentificateur(int identificateur) {
        this.identificateur = identificateur;
    }

    /**
     * @return the TC
     */
    public int getTC() {
        return TC;
    }

    /**
     * @param TC the TC to set
     */
    public void setTC(int TC) {
        this.TC = TC;
    }

    /**
     * @return the CM
     */
    public int getCM() {
        return CM;
    }

    /**
     * @param CM the CM to set
     */
    public void setCM(int CM) {
        this.CM = CM;
    }

    /**
     * @return the prix
     */
    public int getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    public Barres (Noeud ndepart, Noeud narrive){
        
        this.CM = 0;
        this.TC = 0;
        this.identificateur = -1;
        this.prix = 0;
        this.na = narrive;
        this.nd = ndepart;
        this.na.getBarresDepart().add(this);
        this.na.getBarresArrivee().add(this);
        this.na.getBarresIncidente().add(this);
    }
    public Barres (Noeud ndepart, Noeud narrive, int id, int cout, int tractionMax, int compressionMax){
        
        this.CM = compressionMax;
        this.TC = tractionMax;
        this.identificateur = id ;
        this.prix = cout ;
        this.na = narrive;
        this.nd = ndepart;
        this.na.getBarresDepart().add(this);
        this.na.getBarresArrivee().add(this);
        this.na.getBarresIncidente().add(this);
    }
    
    @Override
    public String toString() {
        return "(" + this.nd + ";|;" + this.na + ")" + " id:" + identificateur + " prix" + prix;
    }
    
    public Noeud noeudOppose (Barres b, Noeud n){
        
        if (n == b.getNa()) {
            return b.getNd();
        }else{
            return b.getNa();
        }
    }
    
    public double angle (Noeud n1){
        
        double angle;
        Noeud n2 = noeudOppose(this,n1);
        
        double x1 = n1.getPx();
        double x2 = n2.getPx();
        double y1 = n1.getPy();
        double y2 = n2.getPy();
        
        double r = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
        angle = Math.acos((x2 - x1)/(r));
        
        return angle;
    }
    
    
    
    
    
}
