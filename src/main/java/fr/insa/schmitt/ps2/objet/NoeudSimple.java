/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import fr.insa.schmitt.ps2.*;
import java.io.IOException;
import java.io.Writer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public class NoeudSimple extends Noeud{
    
    private int nbrInconnu;
    public static final double TAILLE_POINT = 5;
    
    public NoeudSimple (double px, double py){ 
        super(px,py);
        this.nbrInconnu = 0;
    }
    public NoeudSimple (double px, double py, Color couleur){ 
        super(px,py,couleur);
        this.nbrInconnu = 0;
    }
    @Override
    public String toString() {
        return "(" + this.getPx() + "," + this.getPy() + ")" + " id:" + getIdentificateur() + " force:" + getForce() + " inconnu :" + nbrInconnu;
    }
    public static NoeudSimple demandeNoeud() {
        System.out.println("abscisse :");
        double px = Lire.d();
        System.out.println("ordonné :");
        double py = Lire.d();
        return new NoeudSimple(px,py);
        
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
    public void dessineSelection(GraphicsContext context) {
        context.setFill(Trellis.COULEUR_SELECTION);
        context.fillOval(this.getPx()-RAYON_IN_DRAW, this.getPy()-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }
    
    @Override
    public void save(Writer w, Numeroteur<Trellis> num)throws IOException{
        if(! num.objExiste(this)){
            int id = num.add(this);
            w.append("NoeudSimple;"+id+";"+this.getPx()+";"+this.getPy()+
                    ";" + Forme.saveColor(this.getCouleur()) + "\n");
        }
    }
}
