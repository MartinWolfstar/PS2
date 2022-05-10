/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public class BarreOutilshaut extends VBox{
    
    private ColorPicker couleur;
    private Button zoomIn;
    private Button zoomOut;
    private MenuHaut menuBar; 
    private Ruban ruban;
    private VBox line;
    
    private MainPanel main;
    
    public BarreOutilshaut(MainPanel main) {
        this.main = main;
        /*this.couleur = new ColorPicker(Color.BLACK);
        this.zoomIn = new Button("Zoom *2");
        this.zoomOut = new Button("Zoom /2");*/
        this.menuBar = new MenuHaut(main);
        this.ruban = new Ruban(main);
        this.line = new VBox();
        
        OutilsFx.setSimpleBorder(line, Color.GRAY, 2);
         
        this.getChildren().addAll(menuBar,ruban.get(),line);
        //OutilsFx.setSimpleBorder(this, Color.BLACK, 2);
        
    }
}
