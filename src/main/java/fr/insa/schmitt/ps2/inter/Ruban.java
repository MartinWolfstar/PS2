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
    private MainPanel main;
    private Accueil accueil;
    private ZoneConstBarre zc;
    private TrellisBarre trellisBarre;
    private TerrainBarre terrainBarre;

    public Ruban(MainPanel main) {

        this.main = main;
        this.accueil = new Accueil(main);
        this.zc = new ZoneConstBarre(main);
        this.trellisBarre = new TrellisBarre(main);
        this.terrainBarre = new TerrainBarre(main);
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

        /*Accueil accueil = new Accueil(main);
        ZoneConstBarre zoneConstBarre = new ZoneConstBarre(main);
        TrellisBarre trellis = new TrellisBarre(main);
        TerrainBarre terrain = new TerrainBarre(main);*/
        
        ruban.getTabs().addAll(getTerrainBarre().get(), getAccueil().get(), getTrellisBarre().get());
        //ruban.getTabs().addAll(accueil.get());
    }

    /**
     * @return the main
     */
    public MainPanel getMain() {
        return main;
    }

    /**
     * @return the accueil
     */
    public Accueil getAccueil() {
        return accueil;
    }

    /**
     * @return the zc
     */
    public ZoneConstBarre getZc() {
        return zc;
    }

    /**
     * @return the trellisBarre
     */
    public TrellisBarre getTrellisBarre() {
        return trellisBarre;
    }

    /**
     * @return the terrainBarre
     */
    public TerrainBarre getTerrainBarre() {
        return terrainBarre;
    }
}
