/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.scene.control.TabPane;

/**
 *
 * @author schmi
 */
public class Ruban extends TabPane{
    
    private TabPane ruban;

    public Ruban() {

        ruban = new TabPane();
        buildTabs();
    }

    /**
     * get. Return instance of the RibbonBar (TabPane).
     * @return 
     */
    public TabPane get() {
        return this.ruban;
    }

    private void buildTabs() {

        Acceuil acceuil = new Acceuil();
        ZoneConstBarre zoneConstBarre = new ZoneConstBarre();
        TrellisBarre trellis = new TrellisBarre();
        TerrainBarre terrain = new TerrainBarre();

        ruban.getTabs().addAll(acceuil.get(), zoneConstBarre.get(), trellis.get(), terrain.get());
        //ruban.getTabs().addAll(acceuil.get());
    }
}
