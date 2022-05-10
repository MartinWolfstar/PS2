/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author schmi
 */
public class Accueil {
    
   private Tab tab;
   private ColorPicker couleur;
   private ToggleButton play;
   private ToggleButton stop;
   private Button retour;
   private Button avance;
   private Button sauv;
   private Button select;
   private Button selectPoint;
   private Button delete;
   private SplitMenuButton direction;
   private MenuItem haut;
   private MenuItem bas;
   private MenuItem gauche;
   private MenuItem droite;
   
   private MainPanel main;

    /**
     * Default Constructor.
     */
    public Accueil(MainPanel main) {
        this.main = main;
        tab = new Tab("accueil");
        buildTab();
    }

    /**
     * get. Returns an instance of the Home Tab.
     * @return 
     */
    public Tab get() {
        return this.tab;
    }

    /**
     * buildTab.
     */
    private void buildTab() {

        //Do not allow tab to close.
        tab.setClosable(false);

        //Create Box
        HBox container = new HBox();
        container.setPrefHeight(70);
        container.setSpacing(10);
        container.setAlignment(Pos.CENTER);
        
        //Create Button
        buildPlayButton();
        buildStopButton();
        buildRetourButton();
        buildAvanceButton();
        buildSauvButton();
        buildSelecButton();
        buildSelecPButton();
        buildDeleteButton();
        buildDirectionMenuButton();
        
        //Add to ToggleGroup
        ToggleGroup toggle1 = new ToggleGroup();
        this.play.setToggleGroup(toggle1);
        this.stop.setToggleGroup(toggle1);
        
        //Add Button
        container.getChildren().addAll(play,stop,retour,avance,sauv,select,selectPoint,delete,direction);
        
        //Add Container.
        tab.setContent(container); 
    }

    /**
     * Creating Button.
     */
    
    private void buildPlayButton(){
        
        this.play = new ToggleButton();
        this.play.setText("play");
        this.play.setContentDisplay(ContentDisplay.TOP);

        String imgPath = "icon/play.png";
        Image clipboard = new Image(this.getClass().getResourceAsStream(imgPath),
                32, 32, true, true);

        ImageView imageView = new ImageView(clipboard);

        this.play.setGraphicTextGap(5.0);
        this.play.setGraphic(imageView);

        this.play.setOnAction((t) ->{
            this.main.getActionneur().boutonPlay(t);
            System.out.println("play Clicked.");
        });
        
    }
    private void buildStopButton(){
        this.stop = new ToggleButton();
        this.stop.setText("stop");
        this.stop.setContentDisplay(ContentDisplay.TOP);
        String imgPath = "icon/pause.png";
        Image clipboard = new Image(this.getClass().getResourceAsStream(imgPath),
                32, 32, true, true);
        ImageView imageView = new ImageView(clipboard);
        this.stop.setGraphicTextGap(5.0);
        this.stop.setGraphic(imageView);

        this.stop.setOnAction((t) ->{
            this.main.getActionneur().boutonStop(t);
            //this.main.getActionneur().MiseAJour(t);
            System.out.println("stop Clicked.");
        });
        
    }
    private void buildRetourButton(){
        this.retour = new BoutonIcon("icon/retour.png",32,32);
        this.retour.setText("retour");
        this.retour.setContentDisplay(ContentDisplay.TOP);

        this.retour.setOnAction((t) ->{
            //this.main.getActionneur().boutonRetour(t);
            this.main.getActionneur().MiseAJour(t);
            System.out.println("retour Clicked.");
        });
    }
    private void buildAvanceButton(){
        this.avance = new BoutonIcon("icon/avance.png",32,32);
        this.avance.setText("suivant");
        this.avance.setContentDisplay(ContentDisplay.TOP);

        this.avance.setOnAction((t) ->{
            //this.main.getActionneur().boutonAvance(t);
            this.main.getActionneur().MiseAJour(t);
            System.out.println("avance Clicked.");
        });
        
    }
    private void buildSauvButton(){
        this.sauv = new BoutonIcon("icon/sauv.png",32,32);
        this.sauv.setText("sauvgarder");
        this.sauv.setContentDisplay(ContentDisplay.TOP);

        this.sauv.setOnAction((t) ->{
            this.main.getActionneur().boutonSaveItem(t);
            System.out.println("sauv Clicked.");
        });
    }
    private void buildSelecButton(){
        this.select = new BoutonIcon("icon/selec.png",32,32);
        this.select.setText("selectioner");
        this.select.setContentDisplay(ContentDisplay.TOP);

        this.select.setOnAction((t) ->{
            this.main.getActionneur().boutonSelect(t);
            System.out.println("select Clicked.");
        });
    }
    private void buildSelecPButton(){
        this.selectPoint = new BoutonIcon("icon/selec.png",32,32);
        this.selectPoint.setText("selectioner B");
        this.selectPoint.setContentDisplay(ContentDisplay.TOP);

        this.selectPoint.setOnAction((t) ->{
            this.main.getActionneur().boutonSelectPoint(t);
            System.out.println("selectP Clicked.");
        });
    }
    private void buildDeleteButton(){
        this.delete = new BoutonIcon("icon/delete.png",32,32);
        this.delete.setText("supprimer");
        this.delete.setContentDisplay(ContentDisplay.TOP);

        this.delete.setOnAction((t) ->{
            this.main.getActionneur().boutonDelete(t);
            //this.main.getActionneur().MiseAJour(t);
            System.out.println("delete Clicked.");
        });
    }
    
    /**
     * Creating a SplitMenuButton.
     */
    private void buildDirectionMenuButton() {

        this.direction = new SplitMenuButton();
        this.direction.setText("direction");
        //Set alignment of button to text. This puts btn text below the image icon.
        this.direction.setContentDisplay(ContentDisplay.TOP);

        //Retrieve and set image of clipboard. I will set image size to 24x24,
        //preserve the ratio and enable smoothing in the Image constructor.
        String imgPath = "icon/deplacer.png";
        Image clipboard = new Image(this.getClass().getResourceAsStream(imgPath),
                32, 32, true, true);

        //Create an ImageView for showing image.
        ImageView imageView = new ImageView(clipboard);

        //Set the gap b/n graphic and text. Assign the ImageView to the button.
        this.direction.setGraphicTextGap(5.0);
        this.direction.setGraphic(imageView);

        //Create all MenuItem
        this.haut = new MenuItem("haut");
        this.bas = new MenuItem("bas");
        this.droite = new MenuItem("droite");
        this.gauche = new MenuItem("gauche");
        
        //Add all MenuItems to the MenuSplitButton's menu options.
        direction.getItems().addAll(haut, bas, droite, gauche);
        
        this.haut.setOnAction((t) ->{
            this.main.getActionneur().boutonHaut(t);
            System.out.println("haut Clicked.");
        });

        this.bas.setOnAction((t) ->{
            this.main.getActionneur().boutonBas(t);
            System.out.println("bas Clicked.");
        });

        this.droite.setOnAction((t) ->{
            this.main.getActionneur().boutonDroite(t);
            System.out.println("droite Clicked.");
        });
        
        this.gauche.setOnAction((t) ->{
            this.main.getActionneur().boutonGauche(t);
            System.out.println("gauche Clicked.");
        });
        
        this.direction.setOnAction((t) ->{
            this.main.getActionneur().boutonCentre(t);
            System.out.println("centre Clicked.");
        });
        
    }

}