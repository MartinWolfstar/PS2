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
    private MenuHaut menuBar; 
    private Ruban ruban;
    
    public MainPanel() {
        this.BarreOutilshaut = new BarreOutilshaut();
        this.BarreOutilsGauche = new BarreOutilsGauche();
        this.dessin = new ZoneDessin();
        this.menuBar = new MenuHaut();
        this.ruban = new Ruban();
        
        //this.setTop(ruban.get());
        this.setTop(this.BarreOutilshaut);
        //this.setLeft(this.BarreOutilsGauche);
        //this.setCenter(this.dessin);
        //this.setTop(menuBar);
    }
    
}
