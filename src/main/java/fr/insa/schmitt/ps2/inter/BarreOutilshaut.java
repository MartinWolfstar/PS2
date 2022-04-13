/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public class BarreOutilshaut extends HBox{
    
    private ColorPicker couleur;
    private Button zoomIn;
    private Button zoomOut;
    
    public BarreOutilshaut() {
        this.couleur = new ColorPicker(Color.BLACK);
        this.zoomIn = new Button("Zoom *2");
        this.zoomOut = new Button("Zoom /2");
        
        this.getChildren().add(this.couleur);
        this.getChildren().add(this.zoomIn);
        this.getChildren().add(this.zoomOut);
        
    }
}
