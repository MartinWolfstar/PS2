/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import fr.insa.schmitt.ps2.Lire;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public abstract class Noeud extends Forme{ 
    
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
    public void setIdentificateur(int identificateur) {
        this.identificateur = identificateur;
    }
    public double getPx() {
        return px;
    }
    public void setPx(double px) {
        this.px = px;
    }
    public double getPy() {
        return py;
    }
    public void setPy(double py) {
        this.py = py;
    }
    public Vecteur2D getForce() {
        return force;
    }
    public void setForce(Vecteur2D force) {
        this.force = force;
    }
    
        /**
     * @return the barresDepart
     */
    public List<Barres> getBarresDepart() {
        return barresDepart;
    }
    public void setBarresDepart(List<Barres> barresDepart) {
        this.barresDepart = barresDepart;
    }
    public List<Barres> getBarresArrivee() {
        return barresArrivee;
    }
    public void setBarresArrivee(List<Barres> barresArrivee) {
        this.barresArrivee = barresArrivee;
    }
    public List<Barres> getBarresIncidente() {
        return barresIncidente;
    }
    public void setBarresIncidente(List<Barres> barresIncidente) {
        this.barresIncidente = barresIncidente;
    }
    
    public Noeud (double vx, double vy, int id, Vecteur2D v2d, Color couleur){
        
        super(couleur);
        this.px = px;
        this.py = py;
        this.identificateur = id;
        this.force = v2d;
        this.barresDepart = new ArrayList<Barres>();
        this.barresArrivee = new ArrayList<Barres>();
        this.barresIncidente = new ArrayList<Barres>();
    }
    public Noeud (double vx, double vy, Color couleur){
        
        super(couleur);
        this.px = px;
        this.py = py;
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
    
    public Noeud() {
        this(0, 0);
    }
    
    @Override
    public String toString() {
        return "(" + this.px + "," + this.py + ")" + " id:" + identificateur + " force:" + getForce();
    }
    
    public void dessine(GraphicsContext context) {
        context.setFill(this.getCouleur());
        context.fillOval(this.px-RAYON_IN_DRAW, this.py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }
    
    @Override
    public double distanceNoeud(Noeud p) {
        double dx = this.getPx() - p.getPx();
        double dy = this.getPy() - p.getPy();
        return Math.sqrt(dx*dx+dy*dy);

    }

}
