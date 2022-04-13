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
    private BarreOutilsGauche BarreOutilsGauche;
    private ZoneDessin dessin;
    
    public MainPanel() {
        this.BarreOutilshaut = new BarreOutilshaut();
        this.BarreOutilsGauche = new BarreOutilsGauche();
        this.dessin = new ZoneDessin();
        
        this.setTop(this.BarreOutilshaut);
        this.setLeft(this.BarreOutilsGauche);
        this.setCenter(this.dessin);
    }
    
}
