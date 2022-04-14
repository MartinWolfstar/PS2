/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

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

    public ZoneConstBarre() {
        tab = new Tab("Zone Constructible");
        buildTab();
    }

    public Tab get() {
        return this.tab;
    }

    private void buildTab() {

        //Do not allow tab to close.
        tab.setClosable(false);

        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);
        container.setSpacing(8);

        this.ajouter = new BoutonIcon("icon/ajouter.png",32,32);
        this.ajouter.setText("ajouter");
        this.ajouter.setContentDisplay(ContentDisplay.TOP);
        
        this.modifier = new BoutonIcon("icon/modifier.png",32,32);
        this.modifier.setText("modifier");
        this.modifier.setContentDisplay(ContentDisplay.TOP);

        container.getChildren().addAll(ajouter,modifier);
        //Add Container.
        tab.setContent(container);

    }
}
