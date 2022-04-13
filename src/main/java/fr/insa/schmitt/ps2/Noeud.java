/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author schmi
 */
public abstract class Noeud extends Trellis{ 
    
    private int identificateur;
    private double px;
    private double py;
    private Vecteur2D force;
    private List<Barres> barresDepart;
    private List<Barres> barresArrivee;
    private List<Barres> barresIncidente;
    
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
     * @return the px
     */
    public double getPx() {
        return px;
    }

    /**
     * @param px the px to set
     */
    public void setPx(double px) {
        this.px = px;
    }

    /**
     * @return the py
     */
    public double getPy() {
        return py;
    }

    /**
     * @param py the py to set
     */
    public void setPy(double py) {
        this.py = py;
    }
    
    /**
     * @return the force
     */
    public Vecteur2D getForce() {
        return force;
    }

    /**
     * @param force the force to set
     */
    public void setForce(Vecteur2D force) {
        this.force = force;
    }
    
        /**
     * @return the barresDepart
     */
    public List<Barres> getBarresDepart() {
        return barresDepart;
    }

    /**
     * @param barresDepart the barresDepart to set
     */
    public void setBarresDepart(List<Barres> barresDepart) {
        this.barresDepart = barresDepart;
    }

    /**
     * @return the barresArrivee
     */
    public List<Barres> getBarresArrivee() {
        return barresArrivee;
    }

    /**
     * @param barresArrivee the barresArrivee to set
     */
    public void setBarresArrivee(List<Barres> barresArrivee) {
        this.barresArrivee = barresArrivee;
    }
    
        /**
     * @return the barresIncidente
     */
    public List<Barres> getBarresIncidente() {
        return barresIncidente;
    }

    /**
     * @param barresIncidente the barresIncidente to set
     */
    public void setBarresIncidente(List<Barres> barresIncidente) {
        this.barresIncidente = barresIncidente;
    }
    
    public Noeud (double vx, double vy, int id, Vecteur2D v2d){
        
        this.px = px;
        this.py = py;
        this.identificateur = id;
        this.force = v2d;
        this.barresDepart = new ArrayList<Barres>();
        this.barresArrivee = new ArrayList<Barres>();
        this.barresIncidente = new ArrayList<Barres>();
    }
    public Noeud (double px, double py){
        
        this.px = px;
        this.py = py;
        this.identificateur = -1;
        this.force = new Vecteur2D(0,0);
        this.barresDepart = new ArrayList<Barres>();
        this.barresArrivee = new ArrayList<Barres>();
        this.barresIncidente = new ArrayList<Barres>();
    }
    
    @Override
    public String toString() {
        return "(" + this.px + "," + this.py + ")" + " id:" + identificateur + " force:" + getForce();
    }

}
