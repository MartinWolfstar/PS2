/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author schmi
 */
public class TerrainBarre {
    
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
    public TerrainBarre() {
        tab = new Tab("Terrain");
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

        HBox container = new HBox();
        container.setPrefHeight(5);
        container.setSpacing(8);
        
        VBox ssContainer1 = new VBox();
        ssContainer1.setSpacing(6);
        VBox ssContainer2 = new VBox();
        ssContainer2.setSpacing(6);
        VBox ssContainer3 = new VBox();
        ssContainer3.setSpacing(6);
        VBox ssContainer4 = new VBox();
        ssContainer4.setSpacing(6);
        VBox ssContainer5 = new VBox();
        ssContainer5.setSpacing(6);
        
        //BarreOutilsGauche bar = new BarreOutilsGauche();
        
        this.rotater = new Button("rotater");
        this.agrandir = new Button("agrandir");
        this.creerPivot = new Button("creerPivot");
        this.insererNoeud = new Button("insererNoeud");
        this.angle = new Button("angle");
        this.ajouterForce = new Button("ajouterForce");
        this.modifierForce = new Button("modifierForce");
        this.agrandirBarre = new Button("agrandirBarre");
        this.mesurerBarre = new Button("mesurerBarre");
        this.uniformiserBarreTaille = new Button("uniformiserBarreTaille");
        this.defForme = new Button("defForme");
        this.defCouleur = new Button("defCouleur");
         
        ssContainer1.getChildren().addAll(rotater,agrandir);
        ssContainer2.getChildren().addAll(creerPivot,insererNoeud,angle);
        ssContainer3.getChildren().addAll(ajouterForce,modifierForce);
        ssContainer4.getChildren().addAll(agrandirBarre,mesurerBarre,uniformiserBarreTaille);
        ssContainer5.getChildren().addAll(defForme,defCouleur);
        container.getChildren().addAll(ssContainer1,ssContainer2,ssContainer3,ssContainer4,ssContainer5);
        //container.getChildren().add(play);
        
        //Add Container.
        tab.setContent(container);

    }
}
