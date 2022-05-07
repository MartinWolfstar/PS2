/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import fr.insa.schmitt.ps2.objet.Groupe;
import java.io.File;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
    
    private Stage inStage;
    private File curFile;
    
    private Groupe model;
    private Actionneur actionneur;
    
    public MainPanel(Stage inStage) {
        this(inStage, new Groupe());
    }

    public MainPanel(Stage inStage, Groupe model) {
        this(inStage, null, model);
    }
    public MainPanel(Stage inStage,File fromFile, Groupe model) {
        this.inStage = inStage;
        this.curFile = fromFile;
        this.model = model;
        this.BarreOutilshaut = new BarreOutilshaut(this);
        this.BarreOutilsGauche = new BarreOutilsGauche(this);
        this.dessin = new DessinCanvas(this);
        this.menuBar = new MenuHaut(this);
        this.ruban = new Ruban(this);
        this.actionneur = new Actionneur(this);

        
        //this.setTop(ruban.get());
        this.setTop(this.BarreOutilshaut);
        this.setLeft(this.BarreOutilsGauche);
        this.setCenter(this.dessin);
        //this.setTop(menuBar);
        this.actionneur.changeEtat(000);
    }

    public void redrawAll(){
        this.getDessin().redrawAll();
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
     * @return the dessin
     */
    public DessinCanvas getDessin() {
        return dessin;
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

    /**
     * @param model the model to set
     */
    public void setModel(Groupe model) {
        this.model = model;
    }

    /**
     * @return the inStage
     */
    public Stage getInStage() {
        return inStage;
    }

    /**
     * @return the curFile
     */
    public File getCurFile() {
        return curFile;
    }

    /**
     * @param curFile the curFile to set
     */
    public void setCurFile(File curFile) {
        this.curFile = curFile;
    }
    
    
}
