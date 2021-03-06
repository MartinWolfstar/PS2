/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
/**
 *
 * @author schmi
 */
public class TerrainBarre {
    
    private Tab tab;
    private Button ajouter;
    private Button valider;
    private Button modifier;
    private Button defAppui;
    private Button defAppuiSimple;
    
       private MainPanel main;

    public TerrainBarre(MainPanel main) {
        this.main = main;
        tab = new Tab("Terrain");
        buildTab();
    }

    public Tab get() {
        return this.tab;
    }

    private void buildTab() {

        //Do not allow tab to close.
        tab.setClosable(false);

        //Create Box
        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);
        container.setSpacing(8);

        //Create Button
        buildAjouterButton();
        buildValButton();
        buildModifierButton();
        buildDefAppuiButton();
        buildDefAppuiButtonSimple();

        container.getChildren().addAll(getAjouter(), getValider(),defAppui,defAppuiSimple);
        tab.setContent(container);

    }
    
    private void buildAjouterButton(){
        this.ajouter = new BoutonIcon("icon/ajouter.png",32,32);
        this.getAjouter().setText("ajouter");
        this.getAjouter().setContentDisplay(ContentDisplay.TOP);

        this.getAjouter().setOnAction((t) ->{
            this.main.getActionneur().boutonAjouterAppui(t);
            //this.main.getActionneur().MiseAJour(t);
            System.out.println("ajouter Clicked.");
        });
    }
    private void buildValButton(){
        this.valider = new BoutonIcon("icon/ok.png",32,32);
        this.getValider().setText("valider");
        this.getValider().setContentDisplay(ContentDisplay.TOP);

        this.getValider().setOnAction((t) ->{
            this.main.getActionneur().boutonValider(t);
            //this.main.getActionneur().MiseAJour(t);
            System.out.println("valider Clicked.");
        });
    }
    private void buildModifierButton(){
        this.modifier = new BoutonIcon("icon/modifier.png",32,32);
        this.modifier.setText("modifier");
        this.modifier.setContentDisplay(ContentDisplay.TOP);

        this.modifier.setOnAction((t) ->{
            //this.main.getActionneur().boutonModifierAppui(t);
            this.main.getActionneur().MiseAJour(t);
            System.out.println("modifier Clicked.");
        });
    }
    private void buildDefAppuiButton(){
        this.defAppui = new BoutonIcon("icon/appui2.png",32,32);
        this.defAppui.setText("d??finir appuis Double");
        this.defAppui.setContentDisplay(ContentDisplay.TOP);

        this.defAppui.setOnAction((t) ->{
            this.main.getActionneur().boutonDefAppui(t);
            //this.main.getActionneur().MiseAJour(t);
            System.out.println("defAppui Clicked.");
        });
    }
    private void buildDefAppuiButtonSimple(){
        this.defAppuiSimple = new BoutonIcon("icon/appui2.png",32,32);
        this.defAppuiSimple.setText("d??finir appuis Simple");
        this.defAppuiSimple.setContentDisplay(ContentDisplay.TOP);

        this.defAppuiSimple.setOnAction((t) ->{
            this.main.getActionneur().boutonDefAppuiSimple(t);
            //this.main.getActionneur().MiseAJour(t);
            System.out.println("defAppuiSimple Clicked.");
        });
    }

    /**
     * @return the ajouter
     */
    public Button getAjouter() {
        return ajouter;
    }

    /**
     * @return the valider
     */
    public Button getValider() {
        return valider;
    }
}
