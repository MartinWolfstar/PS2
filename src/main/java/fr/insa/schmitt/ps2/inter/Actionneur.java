/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

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
    
    public void changeEtat(int nouvelEtat) {
        /*if (nouvelEtat == 20) {
            this.vue.getRbSelect().setSelected(true);
            this.selection.clear();
            this.segmentEnCoursDeCreation = null;
            this.vue.redrawAll();
        } else if (nouvelEtat == 30) {
            // creation de points
            this.vue.getRbPoints().setSelected(true);
            this.selection.clear();
            this.segmentEnCoursDeCreation = null;
            this.vue.getbGrouper().setDisable(true);
            this.vue.redrawAll();
        } else if (nouvelEtat == 40) {
            // creation de segments étape 1
            this.vue.getRbSegments().setSelected(true);
            this.selection.clear();
            this.segmentEnCoursDeCreation = null;
            this.vue.getbGrouper().setDisable(true);
            this.vue.redrawAll();
        } else if (nouvelEtat == 41) {
            // creation de segments étape 2
        }
        this.etat = nouvelEtat;
        this.activeBoutonsSuivantSelection();*/
    }
    
    public void clicDansZoneDessin(MouseEvent t) {
        /*if (this.etat == 20) {
            // selection
            Point pclic = this.posInModel(t.getX(), t.getY());
            // pas de limite de distance entre le clic et l'objet selectionné
            Trellis proche = this.vue.getModel().plusProche(pclic, Double.MAX_VALUE);
            // il faut tout de même prévoir le cas ou le groupe est vide
            // donc pas de plus proche
            if (proche != null) {
                if (t.isShiftDown()) {
                    this.selection.add(proche);
                } else if (t.isControlDown()) {
                    if (this.selection.contains(proche)) {
                        this.selection.remove(proche);
                    } else {
                        this.selection.add(proche);
                    }
                } else {
                    this.selection.clear();
                    this.selection.add(proche);
                }
                this.activeBoutonsSuivantSelection();
                this.vue.redrawAll();
            }
        } else if (this.etat == 30) {
            // creation points
            Point pclic = this.posInModel(t.getX(), t.getY());
            Groupe model = this.vue.getModel();
            model.add(pclic);
            this.vue.redrawAll();
        } else if (this.etat == 40) {
            // creation segment premier point
            this.point1DansModel = this.posInModel(t.getX(), t.getY());
            this.segmentEnCoursDeCreation = new Segment(this.point1DansModel,
                    new Point(this.point1DansModel),
                    this.vue.getCpCouleur().getValue());
            this.changeEtat(41);
        } else if (this.etat == 41) {
            // creation de segment deuxieme point
            Point pclic = this.posInModel(t.getX(), t.getY());
            Segment ns = new Segment(this.point1DansModel, pclic,
                    this.vue.getCpCouleur().getValue());
            this.vue.getModel().add(ns);
            this.segmentEnCoursDeCreation = null;
            this.vue.redrawAll();
            this.changeEtat(40);
        }*/
    }

    public void boutonSelect(ActionEvent t) {
        this.changeEtat(20);
    }

    public void boutonPoints(ActionEvent t) {
        this.changeEtat(30);
    }

    public void boutonSegments(ActionEvent t) {
        this.changeEtat(40);
    }
    
    //Ici mettre tous les boutons avec le numéro de leur changement d'état
    //pour les boutons qui ne change pas l'état du clic sur la zone de dessin on peut juste directement mettre l'action ici

    public void deplacerGauche() {
        /*this.vue.setZoneModelVue(this.vue.getZoneModelVue().translateGauche(0.8));
        this.vue.redrawAll();*/
   }

    public void deplacerDroite() {
        /*this.vue.setZoneModelVue(this.vue.getZoneModelVue().translateDroite(0.8));
        this.vue.redrawAll();*/
   }

    public void deplacerHaut() {
        /*this.vue.setZoneModelVue(this.vue.getZoneModelVue().translateHaut(0.8));
        this.vue.redrawAll();*/
   }

    public void deplacerBas() {
        /*this.vue.setZoneModelVue(this.vue.getZoneModelVue().translateBas(0.8));
        this.vue.redrawAll();*/
   }

}
