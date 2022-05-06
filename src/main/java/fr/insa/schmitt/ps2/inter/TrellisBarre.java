/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Button ajouterBarres;
    private SplitMenuButton defForme;
    private ColorPicker defCouleur;
    
    private MainPanel main;
    
    /**
     * Default Constructor.
     */
    public TrellisBarre(MainPanel main) {
        this.main = main;
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

        //Create all Box
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
        

        //Create all Button
        buildRotButton();
        buildAgrandirButton();
        buildCPButton();
        buildINButton();
        buildAngleButton();
        buildAFButton();
        buildMFButton();
        buildABButton();
        buildMBButton();
        buildUTButton();
        buildDefFormeButton();
        buildDefCouleurButton();
        buildAjouterBarresButton();
        
        //Esthetique
        agrandir.setMaxWidth(Double.MAX_VALUE);
        rotater.setMaxWidth(Double.MAX_VALUE);
        creerPivot.setMaxWidth(Double.MAX_VALUE);
        insererNoeud.setMaxWidth(Double.MAX_VALUE);
        angle.setMaxWidth(Double.MAX_VALUE);
        ajouterForce.setMaxWidth(Double.MAX_VALUE);
        modifierForce.setMaxWidth(Double.MAX_VALUE);
        agrandirBarre.setMaxWidth(Double.MAX_VALUE);
        mesurerBarre.setMaxWidth(Double.MAX_VALUE);
        uniformiserBarreTaille.setMaxWidth(Double.MAX_VALUE);
        defForme.setMaxWidth(Double.MAX_VALUE);
        defCouleur.setMaxWidth(Double.MAX_VALUE);
        ajouterBarres.setMaxWidth(Double.MAX_VALUE);

        angle.setAlignment(Pos.CENTER);
        uniformiserBarreTaille.setAlignment(Pos.CENTER);
         
        //Add all Things
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
        ssContainer7.getChildren().addAll(uniformiserBarreTaille, ajouterBarres);
        OutilsFx.setSimpleBorder(ssContainer7, Color.GRAY, 2);
        
        
        scontainer.getChildren().addAll(ssContainer1,ssContainer2,ssContainer6,ssContainer3,ssContainer4,ssContainer7,ssContainer5);
        //container.getChildren().add(play);
        
        container.getChildren().add(scontainer);
        
        //Add Container.
        tab.setContent(container);

    }
    
    private void buildRotButton(){
        this.rotater = new Button("tourner");
        
        rotater.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("rot Clicked.");
            }
            
        });
    }
    private void buildAgrandirButton(){
        this.agrandir = new Button("agrandir");
        
        agrandir.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("ag Clicked.");
            }
        });
    }
    private void buildCPButton(){
        this.creerPivot = new Button("creer Pivot");
        
        creerPivot.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("CP Clicked.");
            }
        });
    }
    private void buildINButton(){
        this.insererNoeud = new Button("inserer Noeud");
        
        insererNoeud.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("IN Clicked.");
            }
        });
    }
    private void buildAngleButton(){
        this.angle = new Button("angle");
        
        angle.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("angle Clicked.");
            }
        });
    }
    private void buildAFButton(){
        this.ajouterForce = new Button("ajouter Force");
        
        ajouterForce.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("ajouterForce Clicked.");
            }
        });
    }
    private void buildMFButton(){
        this.modifierForce = new Button("modifier Force");
        
        modifierForce.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("modifierForce Clicked.");
            }
        });
    }
    private void buildABButton(){
        this.agrandirBarre = new Button("agrandir Barre");
        
        agrandirBarre.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("agrandirBarres Clicked.");
            }
        });
    }
    private void buildMBButton(){
        this.mesurerBarre = new Button("mesurer Barre");
        
        mesurerBarre.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("mesurerBarre Clicked.");
            }
        });
    }
    private void buildUTButton(){
        this.uniformiserBarreTaille = new Button("uniformiser taille");
        
        uniformiserBarreTaille.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("uniformiserBarreTaille Clicked.");
            }
        });
    }
    private void buildDefFormeButton(){
        /*this.defForme = new Button("def Forme");
        
        defForme.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("defForme Clicked.");
            }
        });*/
        
        this.defForme = new SplitMenuButton();
        this.defForme.setText("forme barre");

        //forme4 Menu Item
        MenuItem forme4 = new MenuItem("forme4");
        forme4.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                System.out.println("forme4 clicked.");
            }

        });

        //forme3 Menu Item
        MenuItem forme3 = new MenuItem("forme3");
        forme3.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                System.out.println("forme3 clicked.");
            }

        });

        //forme2 Menu Item
        MenuItem forme2 = new MenuItem("forme2");
        forme2.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                System.out.println("forme2 clicked.");
            }

        });
        
        //forme1 Menu Item
        MenuItem forme1 = new MenuItem("forme1");
        forme1.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                System.out.println("forme1 clicked.");
            }

        });

        //Add all MenuItems to the MenuSplitButton's menu options.
        this.defForme.getItems().addAll(forme1,forme2,forme3,forme4);

    }
    private void buildDefCouleurButton(){
        this.defCouleur = new ColorPicker(Color.BLACK);
        
        defCouleur.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("defCouleur Clicked.");
            }
        });
    }
    private void buildAjouterBarresButton(){
        this.ajouterBarres = new Button("ajouter Barre");
        
        ajouterBarres.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("ajouterBarres Clicked.");
            }
        });
    }
}
