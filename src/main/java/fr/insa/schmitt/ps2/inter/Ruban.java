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

    public Ruban(MainPanel main) {

        this.main = main;
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

        Accueil accueil = new Accueil(main);
        ZoneConstBarre zoneConstBarre = new ZoneConstBarre(main);
        TrellisBarre trellis = new TrellisBarre(main);
        TerrainBarre terrain = new TerrainBarre(main);
        
        //ruban.getTabs().addAll(accueil.get(), zoneConstBarre.get(), trellis.get(), terrain.get());
        ruban.getTabs().addAll( terrain.get(), accueil.get(), trellis.get());
        //ruban.getTabs().addAll(accueil.get());
    }
}
