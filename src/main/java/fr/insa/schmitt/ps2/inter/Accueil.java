/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.event.Event;
import javafx.event.EventHandler;
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
   private SplitMenuButton direction;

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
        this.play.setText("play");
        this.play.setContentDisplay(ContentDisplay.TOP);
        
        this.stop = new BoutonIcon("icon/pause.png",32,32);
        this.stop.setText("pause");
        this.stop.setContentDisplay(ContentDisplay.TOP);
        
        this.retour = new BoutonIcon("icon/retour.png",32,32);
        this.retour.setText("retour");
        this.retour.setContentDisplay(ContentDisplay.TOP);
        
        this.avance = new BoutonIcon("icon/avance.png",32,32);
        this.avance.setText("suivant");
        this.avance.setContentDisplay(ContentDisplay.TOP);
        
        this.sauv = new BoutonIcon("icon/sauv.png",32,32);
        this.sauv.setText("sauvgarder");
        this.sauv.setContentDisplay(ContentDisplay.TOP);
        
        this.select = new BoutonIcon("icon/selec.png",32,32);
        this.select.setText("selectioner");
        this.select.setContentDisplay(ContentDisplay.TOP);
        
        this.delete = new BoutonIcon("icon/delete.png",32,32);
        this.delete.setText("supprimer");
        this.delete.setContentDisplay(ContentDisplay.TOP);
        
        
        buildDirectionMenuButton();

        
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
        container.getChildren().addAll(play,stop,retour,avance,sauv,select,delete,direction);
        
        //Add Container.
        tab.setContent(container);
        
        
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
        String imgPath = "icon/play.png";
        Image clipboard = new Image(this.getClass().getResourceAsStream(imgPath),
                32, 32, true, true);

        //Create an ImageView for showing image.
        ImageView imageView = new ImageView(clipboard);

        //Set the gap b/n graphic and text. Assign the ImageView to the button.
        this.direction.setGraphicTextGap(5.0);
        this.direction.setGraphic(imageView);

        //haut Menu Item
        MenuItem haut = new MenuItem("haut");
        haut.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                System.out.println("haut clicked.");
            }

        });

        //bas Menu Item
        MenuItem bas = new MenuItem("bas");
        bas.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                System.out.println("bas clicked.");
            }

        });

        //droite Menu Item
        MenuItem droite = new MenuItem("droite");
        droite.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                System.out.println("droite clicked.");
            }

        });
        
        //gauche Menu Item
        MenuItem gauche = new MenuItem("gauche");
        gauche.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                System.out.println("gauche clicked.");
            }

        });

        //Add all MenuItems to the MenuSplitButton's menu options.
        this.direction.getItems().addAll(haut,bas,droite,gauche);

        //Set the click event of the Button itself. 
        this.direction.setOnAction(new EventHandler() {
            @Override
            public void handle(Event arg0) {
                System.out.println("center Clicked.");
            }
        });

    }

}