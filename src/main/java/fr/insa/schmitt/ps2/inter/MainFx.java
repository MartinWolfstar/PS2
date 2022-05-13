/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import fr.insa.schmitt.ps2.objet.Groupe;
import fr.insa.schmitt.ps2.objet.Terrain;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author schmi
 */
public class MainFx extends Application{
    @Override
    public void start (Stage fen){
        
        MainPanel main = new MainPanel(fen, Groupe.groupeTest1(), Terrain.ini());
        
        fen.getIcons().setAll(new Image(getClass().getResource("icon/icons8-robot-50.png").toExternalForm()));
        //voici le lien pour les droits d'utilisation de l'icon: https://icons8.com/icon/115633/robot
        
        Scene sc = new Scene(main, 1000, 700);
        fen.setScene(sc);
        fen.setTitle("Application Tréllis");
        fen.show(); 
        
    }
    public static void main(String[]args){
        launch();
    }
    
}
