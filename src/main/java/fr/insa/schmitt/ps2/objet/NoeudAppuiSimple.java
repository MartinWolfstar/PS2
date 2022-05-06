/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import fr.insa.schmitt.ps2.*;
import static fr.insa.schmitt.ps2.objet.Noeud.RAYON_IN_DRAW;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author schmi
 */
public class NoeudAppuiSimple extends NoeudAppui {
    
    private int nbrInconnu;
    
    public NoeudAppuiSimple (double px, double py){ 
        super(px,py);
        this.nbrInconnu = 1;
    }
    @Override
    public String toString() {
        return "(" + this.getPx() + "," + this.getPy() + ")" + " id:" + getIdentificateur() + " force:" + getForce() + " inconnu :" + nbrInconnu;
    }
    
    public static NoeudAppuiSimple demandePoint() {
        System.out.println("abscisse :");
        double px = Lire.d();
        System.out.println("ordonné :");
        double py = Lire.d();
        return new NoeudAppuiSimple(px,py);   
    }
    
    @Override
    public double maxX() {
        return this.getPx();
    }
    @Override
    public double maxY() {
        return this.getPy();
    }
    @Override
    public double minX() {
        return this.getPx();
    }
    @Override
    public double minY() {
        return this.getPy();
    }
    @Override
    public double distanceNoeud(Noeud p) {
        double dx = this.getPx() - p.getPx();
        double dy = this.getPy() - p.getPy();
        return Math.sqrt(dx*dx+dy*dy);

    }
    
    @Override
    public void dessineSelection(GraphicsContext context) {
        context.setFill(Trellis.COULEUR_SELECTION);
        context.fillOval(this.getPx()-RAYON_IN_DRAW, this.getPy()-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }
}
