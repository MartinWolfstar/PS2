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
    private DessinCanvas dessin;
    private MenuHaut menuBar; 
    private Ruban ruban;
    //private Actionneur actionneur;
    //private RectangleDessin zoneDessin;
    
    public MainPanel() {
        this.BarreOutilshaut = new BarreOutilshaut();
        this.BarreOutilsGauche = new BarreOutilsGauche();
        this.dessin = new DessinCanvas();
        this.menuBar = new MenuHaut();
        this.ruban = new Ruban();
        //this.actionneur = new Actionneur(this);

        
        //this.setTop(ruban.get());
        this.setTop(this.BarreOutilshaut);
        this.setLeft(this.BarreOutilsGauche);
        this.setCenter(this.dessin);
        //this.setTop(menuBar);
    }

    /**
     * @return the BarreOutilshaut
     */
    public BarreOutilshaut getBarreOutilshaut() {
        return BarreOutilshaut;
    }

    /**
     * @return the BarreOutilsGauche
     */
    public BarreOutilsGauche getBarreOutilsGauche() {
        return BarreOutilsGauche;
    }

    /**
     * @return the dessin
     */
    /*public ZoneDessin getDessin() {
        return dessin;
    }*/

    /**
     * @return the menuBar
     */
    public MenuHaut getMenuBar() {
        return menuBar;
    }

    /**
     * @return the ruban
     */
    public Ruban getRuban() {
        return ruban;
    }
/*
    public Actionneur getActionneur() {
        return actionneur;
    }

    public RectangleDessin getZoneDessin() {
        return zoneDessin;
    }

    public void setZoneDessin(RectangleDessin zoneDessin) {
        this.zoneDessin = zoneDessin;
    }
   */ 
}
