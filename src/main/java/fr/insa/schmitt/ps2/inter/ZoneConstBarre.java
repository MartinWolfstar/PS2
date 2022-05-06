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
public class ZoneConstBarre {
    
    private Tab tab;
    private Button ajouter;
    private Button modifier;
    
       private MainPanel main;

    public ZoneConstBarre(MainPanel main) {
        this.main = main;
        tab = new Tab("Zone Constructible");
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

        //CreateButton
        buildAjouterButton();
        buildModifierButton();

        container.getChildren().addAll(ajouter,modifier);
        //Add Container.
        tab.setContent(container);

    }
    private void buildAjouterButton(){
        this.ajouter = new BoutonIcon("icon/ajouter.png",32,32);
        this.ajouter.setText("ajouter");
        this.ajouter.setContentDisplay(ContentDisplay.TOP);
        
        /*ajouter.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("ajouter Clicked.");
            }
        });*/
        this.ajouter.setOnAction((t) ->{
            this.main.getActionneur().boutonAjouterZC(t);
            System.out.println("ajouter Clicked.");
        });
    }
    private void buildModifierButton(){
        this.modifier = new BoutonIcon("icon/modifier.png",32,32);
        this.modifier.setText("modifier");
        this.modifier.setContentDisplay(ContentDisplay.TOP);
        
        /*modifier.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("modifier Clicked.");
            }
        });*/
        this.modifier.setOnAction((t) ->{
            this.main.getActionneur().boutonModifierZC(t);
            System.out.println("modifier Clicked.");
        });
    }
}
