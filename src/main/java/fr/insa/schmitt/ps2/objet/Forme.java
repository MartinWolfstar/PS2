/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public abstract class Forme extends Trellis{
    
    private Color couleur;
    public static double RAYON_IN_DRAW = 5;
    
    public Forme(Color couleur) {
        this.couleur = couleur;
    }
    public Forme() {
        this.couleur = Color.TEAL;
        //turquoise,tan,mint,mauve
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
    
    @Override
    public void changeCouleur(Color value) {
        this.setCouleur(value);
    }
    
    public static String saveColor(Color c){
        return c.getRed()+";"+c.getGreen()+";"+c.getBlue();
    }
    public static Color parseColor(String sr, String sg, String sb) {
       double rouge = Double.parseDouble(sr);
       double vert = Double.parseDouble(sg);
       double bleu = Double.parseDouble(sb);
       return Color.color(rouge, vert, bleu);
    }
}
