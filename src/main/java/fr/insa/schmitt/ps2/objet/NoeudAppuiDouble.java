/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import fr.insa.schmitt.ps2.*;
import static fr.insa.schmitt.ps2.objet.Noeud.RAYON_IN_DRAW;
import java.io.IOException;
import java.io.Writer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;

/**
 *
 * @author schmi
 */
public class NoeudAppuiDouble extends NoeudAppui{
    
    private int nbrInconnu;
    
    public NoeudAppuiDouble (double px, double py){ 
        super(px,py);
        this.nbrInconnu = 2;
    }
    
    @Override
    public String toString() {
        return "(" + this.getPx() + "," + this.getPy() + ")" + " id:" + getIdentificateur() + " force:" + getForce() + " inconnu :" + nbrInconnu;
    }
    public static NoeudAppuiDouble demandePoint() {
        System.out.println("abscisse :");
        double px = Lire.d();
        System.out.println("ordonné :");
        double py = Lire.d();
        return new NoeudAppuiDouble(px,py); 
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
    public void save(Writer w, Numeroteur<GlobalObject> num)throws IOException{
        if(! num.objExiste(this)){
            int id = num.add(this);
            w.append("NoeudAppuiDouble;"+id+";"+this.getPx()+";"+this.getPy()+
                    ";" + Forme.saveColor(this.getCouleur()) + "\n");
        }
    }
    
    @Override
    public void afficheResume() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ceci est un Noeud appui double");
                alert.setHeaderText(null);
                alert.setContentText("px = " + this.getPx() + "\n"
                        + "py = " + this.getPy() + " \n" 
                        + "forces appliqués à ce noeud " + this.getForce() + " \n"
                        + "° \n" 
                );

                alert.showAndWait();
    }
}

