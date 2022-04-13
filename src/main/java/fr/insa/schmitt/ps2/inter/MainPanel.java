/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.scene.layout.BorderPane;

/**
 *
 * @author schmi
 */
public class MainPanel extends BorderPane {

    
    private BarreOutilshaut BarreOutilshaut;
    
    public MainPanel() {
        this.BarreOutilshaut = new BarreOutilshaut();
        
        this.setTop(this.BarreOutilshaut);
    }
    
}
