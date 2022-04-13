/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/**
 *
 * @author schmi
 */
public class MenuHaut extends MenuBar{
    
    private MenuBar menuBar;
    private Menu filesMenu;
    private Menu editMenu;
    private Menu helpMenu;
    private MenuItem newItem;
    private MenuItem openFilesItem;
    private MenuItem exitItem;
    
    
    public MenuHaut() {
        this.menuBar = new MenuBar();
        this.filesMenu = new Menu("File");
        this.editMenu = new Menu("Edit");
        this.helpMenu = new Menu("Help");
        this.newItem = new MenuItem("New");
        this.openFilesItem = new MenuItem("Open File");
        this.exitItem = new MenuItem("Exit");
        
        filesMenu.getItems().addAll(newItem, openFilesItem, exitItem);
        this.getMenus().addAll(filesMenu, editMenu, helpMenu);
        
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));

        // When user click on the Exit item.
        exitItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
    }

    

    
}
