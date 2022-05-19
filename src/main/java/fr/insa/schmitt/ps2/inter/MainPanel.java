/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import fr.insa.schmitt.ps2.objet.Groupe;
import fr.insa.schmitt.ps2.objet.Terrain;
import java.io.File;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author schmi
 */
public class MainPanel extends BorderPane {

    private Actionneur actionneur;
    private BarreOutilshaut BarreOutilshaut;
    private BarreOutilsGauche BarreOutilsGauche;
    
    private MenuHaut menuBar; 
    private Ruban ruban;
    
    private Stage inStage;
    private File curFile;
    
    private Groupe model;
    private Terrain terrain;
    private DessinCanvas dessin;
    private RectangleVue zoneVue;
    
    private static double MULT_POUR_FIT_ALL = 1.1;
    
    public MainPanel(Stage inStage) {
        this(inStage, new Groupe(), new Terrain());
    }

    public MainPanel(Stage inStage, Groupe model, Terrain terrain) {
        this(inStage, null, model, terrain);
    }
    public MainPanel(Stage inStage,File fromFile, Groupe model, Terrain terrain) {
        this.inStage = inStage;
        this.actionneur = new Actionneur(this);
        this.curFile = fromFile;
        this.model = model;
        this.terrain = terrain;
        this.fitAll();
        this.BarreOutilshaut = new BarreOutilshaut(this);
        this.BarreOutilsGauche = new BarreOutilsGauche(this);
        this.dessin = new DessinCanvas(this);
        this.menuBar = new MenuHaut(this);
        this.ruban = new Ruban(this);
        
        this.setTop(this.BarreOutilshaut);
        this.setLeft(this.BarreOutilsGauche);
        this.setCenter(this.dessin);

        this.actionneur.changeEtat(000);
    }

    public void redrawAll(){
        this.getDessin().redrawAll();
    }
    
    public void fitAll() {
        this.setZoneVue(new RectangleVue(this.model.minX(),
                this.model.maxX(), this.model.minY(), this.model.maxY()));
        this.setZoneVue(this.getZoneVue().scale(MULT_POUR_FIT_ALL));
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

    /**
     * @return the zoneVue
     */
    public RectangleVue getZoneVue() {
        return zoneVue;
    }

    /**
     * @param zoneVue the zoneVue to set
     */
    public void setZoneVue(RectangleVue zoneVue) {
        this.zoneVue = zoneVue;
    }

    /**
     * @return the terrain
     */
    public Terrain getTerrain() {
        return terrain;
    }

    /**
     * @param terrain the terrain to set
     */
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
    
    
}
