/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import fr.insa.schmitt.ps2.*;
import java.io.IOException;
import java.io.Writer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

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
    public NoeudAppuiSimple (double px, double py, Color couleur){ 
        super(px,py,couleur);
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
    public void dessineSelection(GraphicsContext context) {
        context.setFill(Trellis.COULEUR_SELECTION);
        context.fillOval(this.getPx()-RAYON_IN_DRAW, this.getPy()-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
        //context.drawImage(frameimage,0,0,image.getFitWidth()+20,image.getFitHeight()+20);
    }
    
    @Override
    public void save(Writer w, Numeroteur<GlobalObject> num)throws IOException{
        if(! num.objExiste(this)){
            int id = num.add(this);
            w.append("NoeudAppuiSimple;"+id+";"+this.getPx()+";"+this.getPy()+
                    ";" + Forme.saveColor(this.getCouleur()) + "\n");
        }
    }
    
    @Override
    public void afficheResume() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ceci est un Noeud appui Simple");
                alert.setHeaderText(null);
                alert.setContentText("px = " + this.getPx() + "\n"
                        + "py = " + this.getPy() + " \n" 
                        + "forces appliqués à ce noeud " + this.getForce() + " \n"
                        + "° \n" 
                );

                alert.showAndWait();
    }
}
