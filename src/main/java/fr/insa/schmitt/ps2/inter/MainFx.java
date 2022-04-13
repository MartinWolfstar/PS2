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
        
        HBox h1 = new HBox();
        Button btn1 = new Button("First");
        
        h1.getChildren().addAll(btn1);
        
        Scene sc = new Scene(h1,600,400);
        fen.setScene(sc);
        fen.setTitle("Application");
        fen.show(); 
        
    }
    public static void main(String[]args){
        launch();
    }
    
}
