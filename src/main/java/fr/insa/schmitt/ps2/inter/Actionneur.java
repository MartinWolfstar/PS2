/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import fr.insa.schmitt.ps2.objet.Groupe;
import fr.insa.schmitt.ps2.objet.NoeudSimple;
import fr.insa.schmitt.ps2.objet.Trellis;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author schmi
 */
public class Actionneur {
    
    private MainPanel vue;
    private int etat;
    private List<Trellis> selection;
    
    public Actionneur(MainPanel vue) {
        this.vue = vue;
        this.selection = new ArrayList<>();
    }
   
    public void changeEtat(int nouvelEtat){
        if (nouvelEtat == 100) {
            
        }
        if (nouvelEtat == 200) {
            
        }
        if (nouvelEtat == 300) {
            
        }
        if (nouvelEtat == 400) {
            
        }
        if (nouvelEtat == 500) {
            
        }
    }

    void clicDansZoneDessin(MouseEvent t) {
        double px = t.getX();
        double py =t.getY();
        Groupe model = this.vue.getModel();
        model.add(new NoeudSimple(px,py));
        this.vue.redrawAll();
    }
    
}
