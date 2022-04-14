/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author schmi
 */
public class MainFx extends Application{
    @Override
    public void start (Stage fen){
        
        MainPanel main = new MainPanel();
        
        Scene sc = new Scene(main, 1000, 700);
        fen.setScene(sc);
        fen.setTitle("Application Tréllis");
        fen.show(); 
        
    }
    public static void main(String[]args){
        launch();
    }
    
}
