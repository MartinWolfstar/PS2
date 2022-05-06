/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import fr.insa.schmitt.ps2.objet.Groupe;
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
    
    private Groupe model;
    private Actionneur actionneur;
    
    public MainPanel() {
        this(new Groupe());
    }
    public MainPanel(Groupe model) {
        this.model = model;
        this.BarreOutilshaut = new BarreOutilshaut(this);
        this.BarreOutilsGauche = new BarreOutilsGauche(this);
        this.dessin = new DessinCanvas(this);
        this.menuBar = new MenuHaut();
        this.ruban = new Ruban(this);
        this.actionneur = new Actionneur(this);

        
        //this.setTop(ruban.get());
        this.setTop(this.BarreOutilshaut);
        this.setLeft(this.BarreOutilsGauche);
        this.setCenter(this.dessin);
        //this.setTop(menuBar);
        this.actionneur.changeEtat(100);
    }

    public void redrawAll(){
        this.dessin.redrawAll();
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

    public Actionneur getActionneur() {
        return actionneur;
    }

    /**
     * @return the model
     */
    public Groupe getModel() {
        return model;
    }
    
    
}
