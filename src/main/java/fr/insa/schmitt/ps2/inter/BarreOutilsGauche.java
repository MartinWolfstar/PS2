/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public class BarreOutilsGauche extends VBox{
    
    private ToggleButton bSelect;
    private ToggleButton bPoint;
    private ToggleButton bSegment;
    
    public BarreOutilsGauche() {
        this.bSelect = new ToggleButton("select");
        this.bPoint = new ToggleButton("point");
        this.bSegment = new ToggleButton("segment");
        
        ToggleGroup gBoutons = new ToggleGroup();
        this.bSelect.setToggleGroup(gBoutons);
        this.bPoint.setToggleGroup(gBoutons);
        this.bSegment.setToggleGroup(gBoutons);
        
        this.getChildren().addAll(this.bSelect,this.bPoint,this.bSegment);
        OutilsFx.setSimpleBorder(this, Color.BLACK, 2);
        
    }
}
