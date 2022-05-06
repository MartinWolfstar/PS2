/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import fr.insa.schmitt.ps2.objet.Barres;
import fr.insa.schmitt.ps2.objet.Groupe;
import fr.insa.schmitt.ps2.objet.Noeud;
import fr.insa.schmitt.ps2.objet.NoeudSimple;
import fr.insa.schmitt.ps2.objet.Trellis;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent; 
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public class Actionneur {
    
    private MainPanel main;
    private int etat;
    private List<Trellis> selection;
    private double[] pos1 = new double[2];
    
    public Actionneur(MainPanel main) {
        this.main = main;
        this.selection = new ArrayList<>();
    }
   
    public void changeEtat(int nouvelEtat){
        
        etat = nouvelEtat;
        System.out.println(etat);
        
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
        if (this.etat == 322){
            
            //création Noeud
            double px = t.getX();
            double py =t.getY();
            Groupe model = this.main.getModel();
            model.add(new NoeudSimple(px,py));
            this.main.redrawAll(); 
            
        }else if (this.etat == 100){
           
            //play
            System.out.println(main.getModel());
            this.changeEtat(350);
            
        }else if (this.etat == 150){
            // selection
            Noeud pclic = new NoeudSimple(t.getX(),t.getY());
            Trellis proche = this.main.getModel().plusProche(pclic, Double.MAX_VALUE);
            if (proche != null) {
                if (t.isShiftDown()) {
                    this.getSelection().add(proche);
                } else if (t.isControlDown()) {
                    if (this.getSelection().contains(proche)) {
                        this.getSelection().remove(proche);
                    } else {
                        this.getSelection().add(proche);
                    }
                } else {
                    this.getSelection().clear();
                    this.getSelection().add(proche);
                }
                this.activeBoutonsSuivantSelection();
                this.main.redrawAll();
            }
                
        }else if (this.etat == 343){
            //creer segment
            this.pos1[0] = t.getX();
            this.pos1[1] = t.getY();
            this.changeEtat(344);
        }else if (this.etat == 344){
            //creer segment.2
            double px2 = t.getX();
            double py2 = t.getY();
            this.main.getModel().add(new Barres (new NoeudSimple(this.pos1[0],this.pos1[1]),new NoeudSimple(px2,py2)));
            this.main.redrawAll();
            this.changeEtat(343);
            
        }else{
            System.out.println("clic"); 
        }
        
    }

    
    //bouton provenant d'acceuil:
    void boutonPlay(ActionEvent t){
        this.changeEtat(100);
    }
    void boutonStop(ActionEvent t){
        this.changeEtat(110);
    }
    void boutonRetour(ActionEvent t){
        this.changeEtat(120);
    }
    void boutonAvance(ActionEvent t){
        this.changeEtat(130);
    }
    void boutonSauv(ActionEvent t){
        this.changeEtat(140);
    }
    void boutonSelect(ActionEvent t){
        this.changeEtat(150);
    }
    void boutonDelete(ActionEvent t){
        this.changeEtat(160);
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
    
    //bouton provenant de ZC:
    
    void boutonAjouterZC(ActionEvent t){
        this.changeEtat(200);
    }
    void boutonModifierZC(ActionEvent t){
        this.changeEtat(210);
    }
    
    //bouton provenant de TrellisBarre:
    
    void boutonRotater(ActionEvent t){
        this.changeEtat(300);
    }
    void boutonAgrandir(ActionEvent t){
        this.changeEtat(310);
    }
    void boutonCreerPivot(ActionEvent t){
        this.changeEtat(321);
    }
    void boutonInsererNoeud(ActionEvent t){
        this.changeEtat(322);
    }
    void boutonAngle(ActionEvent t){
        this.changeEtat(323);
    }
    void boutonAjouterForce(ActionEvent t){
        this.changeEtat(330);
    }
    void boutonModifierForce(ActionEvent t){
        this.changeEtat(331);
    }
    void boutonAgrandirBarre(ActionEvent t){
        this.changeEtat(340);
    }
    void boutonMesurerBarre(ActionEvent t){
        this.changeEtat(341);
    }
    void boutonUniformiserBarreTaille(ActionEvent t){
        this.changeEtat(342);
    }
    void boutonAjouterBarres(ActionEvent t){
        this.changeEtat(343);
        //état 344: ajouter barre 2
    }
    
    //bouton provenant de TerrainBarre:
    
    void boutonAjouterAppui(ActionEvent t){
        this.changeEtat(400);
    }
    void boutonModifierAppui(ActionEvent t){
        this.changeEtat(410);
    }
    void boutonDefAppui(ActionEvent t){
        this.changeEtat(420);
    }
    
    private void activeBoutonsSuivantSelection(){
        
    }

    /**
     * @return the selection
     */
    public List<Trellis> getSelection() {
        return selection;
    }
    
    void changeColor(Color value){
        if(this.etat == 150 && this.selection.size() > 0){
            for(Trellis t : this.selection){
                t.changeCouleur(value);
            }
            this.main.redrawAll();
        }
    }
}
