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
import javafx.event.ActionEvent;
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
            System.out.println("état 100");
        }
        if (nouvelEtat == 200) {
            System.out.println("état 200");
        }
        if (nouvelEtat == 300) {
            System.out.println("état 300");
        }
        if (nouvelEtat == 400) {
            System.out.println("état 400");
        }
        if (nouvelEtat == 500) {
            System.out.println("état 500");
        }
        if (nouvelEtat == 600) {
            System.out.println("état 600");
        }
        if (nouvelEtat == 700) {
            System.out.println("état 700");
        }
    }

    void clicDansZoneDessin(MouseEvent t) {
        double px = t.getX();
        double py =t.getY();
        Groupe model = this.vue.getModel();
        model.add(new NoeudSimple(px,py));
        this.vue.redrawAll();
    }
    
    void boutonPlay(ActionEvent t){
        this.changeEtat(100);
    }
    void boutonStop(ActionEvent t){
        this.changeEtat(200);
    }
    void boutonRetour(ActionEvent t){
        this.changeEtat(300);
    }
    void boutonAvance(ActionEvent t){
        this.changeEtat(400);
    }
    void boutonSauv(ActionEvent t){
        this.changeEtat(500);
    }
    void boutonSelect(ActionEvent t){
        this.changeEtat(600);
    }
    void boutonDelete(ActionEvent t){
        this.changeEtat(700);
    }
    /*void boutonHaut(ActionEvent t){
        this.changeEtat(10);
    }
    void boutonBas(ActionEvent t){
        this.changeEtat(10);
    }
    void boutonDroite(ActionEvent t){
        this.changeEtat(10);
    }
    void boutonGauche(ActionEvent t){
        this.changeEtat(10);
    }*/
    
    
}
