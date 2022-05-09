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
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
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
    private Button retrecir;
    private Button agrandir;
    private Button remplir;
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
        buildRetButton();
        buildAgrandirButton();
        buildRemplirButton();
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
        retrecir.setMaxWidth(Double.MAX_VALUE);
        remplir.setMaxWidth(Double.MAX_VALUE);
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
        ssContainer1.getChildren().addAll(retrecir,agrandir);
        OutilsFx.setSimpleBorder(ssContainer1, Color.GRAY, 2);
        ssContainer2.getChildren().addAll(creerPivot,insererNoeud);
        OutilsFx.setSimpleBorder(ssContainer2, Color.GRAY, 2);
        ssContainer3.getChildren().addAll(ajouterForce,modifierForce);
        OutilsFx.setSimpleBorder(ssContainer3, Color.GRAY, 2);
        ssContainer4.getChildren().addAll(agrandirBarre,mesurerBarre);
        OutilsFx.setSimpleBorder(ssContainer4, Color.GRAY, 2);
        ssContainer5.getChildren().addAll(defForme,defCouleur);
        OutilsFx.setSimpleBorder(ssContainer5, Color.GRAY, 2);
        ssContainer6.getChildren().addAll(angle, remplir);
        OutilsFx.setSimpleBorder(ssContainer6, Color.GRAY, 2);
        ssContainer7.getChildren().addAll(uniformiserBarreTaille, ajouterBarres);
        OutilsFx.setSimpleBorder(ssContainer7, Color.GRAY, 2);
        
        
        scontainer.getChildren().addAll(ssContainer1,ssContainer2,ssContainer6,ssContainer3,ssContainer4,ssContainer7,ssContainer5);
        //container.getChildren().add(play);
        
        container.getChildren().add(scontainer);
        
        //Add Container.
        tab.setContent(container);

    }
    
    private void buildRetButton(){
        this.retrecir = new Button("retrecir");
        
        this.retrecir.setOnAction((t) ->{
            this.main.getActionneur().boutonRetrecir(t);
            //this.main.getActionneur().MiseAJour(t);
            System.out.println("retrecir Clicked.");
        });
    }
    private void buildAgrandirButton(){
        this.agrandir = new Button("agrandir");
        
        this.agrandir.setOnAction((t) ->{
            this.main.getActionneur().boutonAgrandir(t);
            //this.main.getActionneur().MiseAJour(t);
            System.out.println("agrandir Clicked.");
        });
    }
    private void buildRemplirButton(){
        this.remplir = new Button("remplir");
        
        this.remplir.setOnAction((t) ->{
            this.main.getActionneur().boutonRemplir(t);
            //this.main.getActionneur().MiseAJour(t);
            System.out.println("remplir Clicked.");
        });
    }
    
    private void buildCPButton(){
        this.creerPivot = new Button("creer Pivot");
        
        this.creerPivot.setOnAction((t) ->{
            //this.main.getActionneur().boutonCreerPivot(t);
            this.main.getActionneur().MiseAJour(t);
            System.out.println("CP Clicked.");
        });
    }
    private void buildINButton(){
        this.insererNoeud = new Button("inserer Noeud");
        
        this.insererNoeud.setOnAction((t) ->{
            this.main.getActionneur().boutonInsererNoeud(t);
            System.out.println("IN Clicked.");
        });
    }
    private void buildAngleButton(){
        this.angle = new Button("angle");
        
        this.angle.setOnAction((t) ->{
            //this.main.getActionneur().boutonAngle(t);
            this.main.getActionneur().MiseAJour(t);
            System.out.println("angle Clicked.");
        });
    }
    private void buildAFButton(){
        this.ajouterForce = new Button("ajouter Force");
        
        this.ajouterForce.setOnAction((t) ->{
            //this.main.getActionneur().boutonAjouterForce(t);
            this.main.getActionneur().MiseAJour(t);
            System.out.println("ajouterForce Clicked.");
        });
    }
    private void buildMFButton(){
        this.modifierForce = new Button("modifier Force");
        
        this.modifierForce.setOnAction((t) ->{
            //this.main.getActionneur().boutonModifierForce(t);
            this.main.getActionneur().MiseAJour(t);
            System.out.println("modifierForce Clicked.");
        });
    }
    private void buildABButton(){
        this.agrandirBarre = new Button("agrandir Barre");
        
        this.agrandirBarre.setOnAction((t) ->{
            //this.main.getActionneur().boutonAgrandirBarre(t);
            this.main.getActionneur().MiseAJour(t);
            System.out.println("agrandirBarre Clicked.");
        });
    }
    private void buildMBButton(){
        this.mesurerBarre = new Button("mesurer Barre");
        
        this.mesurerBarre.setOnAction((t) ->{
            //this.main.getActionneur().boutonMesurerBarre(t);
            this.main.getActionneur().MiseAJour(t);
            System.out.println("mesurerBarre Clicked.");
        });
    }
    private void buildUTButton(){
        this.uniformiserBarreTaille = new Button("uniformiser taille");
        
        this.uniformiserBarreTaille.setOnAction((t) ->{
            //this.main.getActionneur().boutonUniformiserBarreTaille(t);
            this.main.getActionneur().MiseAJour(t);
            System.out.println("uniformiserBarreTaille Clicked.");
        });
    }
    
    //boutons spéciaux
    
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
        this.defCouleur.setOnAction((t) -> {
            this.main.getActionneur().changeColor(this.defCouleur.getValue());
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
        this.ajouterBarres.setOnAction((t) ->{
            this.main.getActionneur().boutonAjouterBarres(t);
            System.out.println("ajouterBarres Clicked.");
        });
    }
}
