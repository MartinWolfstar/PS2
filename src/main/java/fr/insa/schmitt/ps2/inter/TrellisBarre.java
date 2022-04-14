/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
/**
 *
 * @author schmi
 */
public class TrellisBarre {
    
    private Tab tab;
    private Button ajouter;
    private Button modifier;
    private Button defAppui;

    public TrellisBarre() {
        tab = new Tab("Trellis");
        buildTab();
    }

    public Tab get() {
        return this.tab;
    }

    private void buildTab() {

        //Do not allow tab to close.
        tab.setClosable(false);

        HBox container = new HBox();
        container.setPrefHeight(90);
        container.setSpacing(5);

        this.ajouter = new BoutonIcon("icon/play.png",32,32);
        this.modifier = new BoutonIcon("icon/pause.png",32,32);
        this.defAppui = new BoutonIcon("icon/pause.png",32,32);

        container.getChildren().addAll(ajouter,modifier,defAppui);
        //Add Container.
        tab.setContent(container);

    }
}
