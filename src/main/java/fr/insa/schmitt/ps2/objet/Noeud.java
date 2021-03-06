/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

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
    
    public Noeud (double px, double py, int id, Vecteur2D v2d, Color couleur){
        
        super(couleur);
        this.px = px;
        this.py = py;
        this.identificateur = id;
        this.force = v2d;
        this.barresDepart = new ArrayList<>();
        this.barresArrivee = new ArrayList<>();
        this.barresIncidente = new ArrayList<>(); 
    }
    public Noeud (double px, double py, int id, Vecteur2D v2d){
        
        this.px = px;
        this.py = py;
        this.identificateur = id;
        this.force = v2d;
        this.barresDepart = new ArrayList<>();
        this.barresArrivee = new ArrayList<>();
        this.barresIncidente = new ArrayList<>();
    }
    public Noeud (double px, double py, Color couleur){
        
        super(couleur);
        this.px = px;
        this.py = py;
        this.force = new Vecteur2D(0,0);
        this.barresDepart = new ArrayList<>();
        this.barresArrivee = new ArrayList<>();
        this.barresIncidente = new ArrayList<>();
    }
    public Noeud (double px, double py){
        
        this.px = px;
        this.py = py;
        this.identificateur = -1;
        this.force = new Vecteur2D(0,0);
        this.barresDepart = new ArrayList<>();
        this.barresArrivee = new ArrayList<>();
        this.barresIncidente = new ArrayList<>();
    }
    
    public Noeud() {
        this(0, 0);
    }
    
    @Override
    public String toString() {
        return "(" + this.px + "," + this.py + ")" + " id:" + identificateur + " force:" + getForce();
    }
    
    @Override
    public void dessine(GraphicsContext context) {
        context.setFill(this.getCouleur());
        context.fillOval(this.px-RAYON_IN_DRAW, this.py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
        this.force.dessine(context, px, py);
    }
    
    @Override
    public double distanceNoeud(Noeud p) {
        double dx = this.getPx() - p.getPx();
        double dy = this.getPy() - p.getPy();
        return Math.sqrt(dx*dx+dy*dy);

    }
    
    public double angle(Noeud p1, Noeud p2){
        
        double angle;
        
        Barres a = new Barres(this,p1);
        Barres b = new Barres(p1,p2);
        Barres c = new Barres(this,p2);
        
        double la = a.longeurBarres();
        System.out.println(la);
        double lb = b.longeurBarres();
        double lc = c.longeurBarres();
        
        double r = lb*lb - la*la - lc*lc;
        
        angle = Math.acos(r/((-2)*la*lc));
        
        System.out.println(r);
        return angle;
    }

}
