/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author schmi
 */
public class Accueil {
    
   private Tab tab;
   private ColorPicker couleur;
   private Button play;
   private Button stop;
   private Button retour;
   private Button avance;
   private Button sauv;
   private Button select;
   private Action action;
   private Button delete;

    /**
     * Default Constructor.
     */
    public Accueil() {
        tab = new Tab("accueil");
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

        //The container holds all toolbar sections specific to a Tab.
        HBox container = new HBox();
        container.setPrefHeight(10);
        container.setSpacing(6);
        
        VBox ssContainer1 = new VBox();
        ssContainer1.setSpacing(6);
        VBox ssContainer2 = new VBox();
        ssContainer2.setSpacing(6);
        VBox ssContainer3 = new VBox();
        ssContainer3.setSpacing(6);

        //Add the Actions Ribbon Component
        //this.action = new Action();
        //container.getChildren().add(action.get());
        
        //BarreOutilsGauche bar = new BarreOutilsGauche();
        
        this.play = new BoutonIcon("icon/play.png",32,32);
        this.stop = new BoutonIcon("icon/pause.png",32,32);
        this.retour = new BoutonIcon("icon/retour.png",32,32);
        this.avance = new BoutonIcon("icon/avance.png",32,32);
        this.sauv = new BoutonIcon("icon/sauv.png",32,32);
        this.select = new BoutonIcon("icon/selec.png",32,32);
        this.delete = new BoutonIcon("icon/delete.png",32,32);

        
        /*this.stop = new Button("stop");
        this.retour = new Button("retour");
        this.avance = new Button("avance");
        this.sauv = new Button("sauv");
        this.select = new Button("selec");*/
         
        /*ssContainer1.getChildren().addAll(play,stop);
        ssContainer2.getChildren().addAll(retour,avance);
        ssContainer3.getChildren().addAll(sauv,select);
        container.getChildren().addAll(ssContainer1,ssContainer2,ssContainer3);*/
        //container.getChildren().add(play);
        container.getChildren().addAll(play,stop,retour,avance,sauv,select,delete);
        
        //Add Container.
        tab.setContent(container);

    }

}