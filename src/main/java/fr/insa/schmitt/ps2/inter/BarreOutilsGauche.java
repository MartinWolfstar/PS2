/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private Label bLabel;
    private TextArea textArea;
    
    public BarreOutilsGauche() {

        buildTextArea();
        buildSelecButton();
        buildPointButton();
        buildSegmentButton();
        
        this.bLabel = new Label("ps: la zone ici est encore à faire");
        
        ToggleGroup gBoutons = new ToggleGroup();
        this.bSelect.setToggleGroup(gBoutons);
        this.bPoint.setToggleGroup(gBoutons);
        this.bSegment.setToggleGroup(gBoutons);
        
        this.getChildren().addAll(new Label("Search something:"),textArea,this.bSelect,this.bPoint,this.bSegment,this.bLabel);
        OutilsFx.setSimpleBorder(this, Color.GRAY, 2);
        
    }
    private void buildTextArea(){
        this.textArea = new TextArea();
        textArea.setMaxSize(200,40);
    }
    private void buildSelecButton(){
        this.bSelect = new ToggleButton("select");
        
        bSelect.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("select Clicked.");
            }
        });
    }
    private void buildPointButton(){
        this.bPoint = new ToggleButton("point");
        
        bPoint.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("bPoint Clicked.");
            }
        });
    }
    private void buildSegmentButton(){
        this.bSegment = new ToggleButton("segment");
        
        bSegment.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("bSegment Clicked.");
            }
        });
    }
    
}
