/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
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
    private MenuItem edit1Item;
    private MenuItem edit2Item;
    private MenuItem helpItem;
    private MenuItem aproposItem;

    /**
     * Default Constructor.
     */
    public MenuHaut() {
        this.menuBar = new MenuBar();

        buildFiles();
        buildEdit();
        buildHelp();
        this.getMenus().addAll(filesMenu, editMenu, helpMenu);
        
        
    }
    private void buildFiles() {
            
        this.filesMenu = new Menu("File");
        this.newItem = new MenuItem("New");
        this.openFilesItem = new MenuItem("Open File");
        this.exitItem = new MenuItem("Exit");
            
        filesMenu.getItems().addAll(newItem, openFilesItem, exitItem);
        
        //Files item:
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));

        exitItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));

        newItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Stage nouveau = new Stage();
                nouveau.setTitle("Nouveau");
                Scene sc = new Scene(new MainPanel(), 1000, 700);
                nouveau.setScene(sc);
                nouveau.show();
            }
        });
        openFilesItem.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));

        openFilesItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("open Clicked.");
            }
        });
    }
    private void buildEdit() {
        
        this.editMenu = new Menu("Edit");
        this.edit1Item = new MenuItem("edit1");
        this.edit2Item = new MenuItem("edit2");
        editMenu.getItems().addAll(edit1Item,edit2Item);
        
        //Edit item:
        edit1Item.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
        
        edit1Item.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("edit1 Clicked.");
            }
        });
        edit2Item.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
        
        edit2Item.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("edit2 Clicked.");
            }
        });
        
    }
    private void buildHelp() {
        this.helpMenu = new Menu("Help");
        
        this.helpItem = new MenuItem("Help me!!!");
        this.aproposItem = new MenuItem("à propos...");
        helpMenu.getItems().addAll(helpItem,aproposItem);
        
        //HELP item:
        helpItem.setAccelerator(KeyCombination.keyCombination("Ctrl+H"));
        
        helpItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("help Clicked.");
            }
        });
        
        aproposItem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("A propos");
                alert.setHeaderText(null);
                alert.setContentText("Application Tréllis\n"
                        + "blablabla\n");

                alert.showAndWait();
            }
        });
    }
}
