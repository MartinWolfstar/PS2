/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
/**
 *
 * @author schmi
 */
public class TrellisBarre {
    
    private Tab tab;
    private Button rotater;
    private Button agrandir;
    private Button creerPivot;
    private Button insererNoeud;
    private Button angle;
    private Button ajouterForce;
    private Button modifierForce;
    private Button agrandirBarre;
    private Button mesurerBarre;
    private Button uniformiserBarreTaille;
    private Button defForme;
    private Button defCouleur;
    

    /**
     * Default Constructor.
     */
    public TrellisBarre() {
        tab = new Tab("Trellis");
        buildTab();
    }

    /**
     * get. Returns an instance of the Home Tab. This will be added to the 
     * TabPane in the RibbonBar class.
     * @return 
     */
    public Tab get() {
        return this.tab;
    }

    /**
     * buildTab. Helper method to build the Home Tab UI.
     */
    private void buildTab() {

        //Do not allow tab to close.
        tab.setClosable(false);

        VBox container = new VBox();
        container.setAlignment(Pos.CENTER);
        
        HBox scontainer = new HBox();
        scontainer.setAlignment(Pos.CENTER);
        scontainer.setSpacing(8);
        
        VBox ssContainer1 = new VBox();
        ssContainer1.setSpacing(3);
        VBox ssContainer2 = new VBox();
        ssContainer2.setSpacing(3);
        VBox ssContainer3 = new VBox();
        ssContainer3.setSpacing(3);
        VBox ssContainer4 = new VBox();
        ssContainer4.setSpacing(3);
        VBox ssContainer5 = new VBox();
        ssContainer5.setSpacing(3);
        VBox ssContainer6 = new VBox();
        ssContainer6.setSpacing(3);
        VBox ssContainer7 = new VBox();
        ssContainer7.setSpacing(3);
        
        //BarreOutilsGauche bar = new BarreOutilsGauche();
        
        this.rotater = new Button("tourner");
        this.agrandir = new Button("agrandir");
        this.creerPivot = new Button("creer Pivot");
        this.insererNoeud = new Button("inserer Noeud");
        this.angle = new Button("angle");
        this.ajouterForce = new Button("ajouter Force");
        this.modifierForce = new Button("modifier Force");
        this.agrandirBarre = new Button("agrandir Barre");
        this.mesurerBarre = new Button("mesurer Barre");
        this.uniformiserBarreTaille = new Button("uniformiser taille");
        this.defForme = new Button("def Forme");
        this.defCouleur = new Button("def Couleur");
         
        ssContainer1.getChildren().addAll(rotater,agrandir);
        OutilsFx.setSimpleBorder(ssContainer1, Color.GRAY, 2);
        ssContainer2.getChildren().addAll(creerPivot,insererNoeud);
        OutilsFx.setSimpleBorder(ssContainer2, Color.GRAY, 2);
        ssContainer3.getChildren().addAll(ajouterForce,modifierForce);
        OutilsFx.setSimpleBorder(ssContainer3, Color.GRAY, 2);
        ssContainer4.getChildren().addAll(agrandirBarre,mesurerBarre);
        OutilsFx.setSimpleBorder(ssContainer4, Color.GRAY, 2);
        ssContainer5.getChildren().addAll(defForme,defCouleur);
        OutilsFx.setSimpleBorder(ssContainer5, Color.GRAY, 2);
        ssContainer6.getChildren().addAll(angle);
        OutilsFx.setSimpleBorder(ssContainer6, Color.GRAY, 2);
        ssContainer7.getChildren().addAll(uniformiserBarreTaille);
        OutilsFx.setSimpleBorder(ssContainer7, Color.GRAY, 2);
        
        
        scontainer.getChildren().addAll(ssContainer1,ssContainer2,ssContainer6,ssContainer3,ssContainer4,ssContainer7,ssContainer5);
        //container.getChildren().add(play);
        
        container.getChildren().add(scontainer);
        
        //Add Container.
        tab.setContent(container);

    }
}
