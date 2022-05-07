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
    private MenuItem saveItem;
    private MenuItem saveAsItem;
    private MenuItem exitItem;
    private MenuItem edit1Item;
    private MenuItem edit2Item;
    private MenuItem helpItem;
    private MenuItem aproposItem;
    private MainPanel main;

    /**
     * Default Constructor.
     */
    public MenuHaut(MainPanel main) {
        this.main = main;
        this.menuBar = new MenuBar();

        buildFiles();
        buildEdit();
        buildHelp();
        this.getMenus().addAll(filesMenu, editMenu, helpMenu);
        
        
    }
    private void buildFiles() {
            
        this.filesMenu = new Menu("File");
        this.newItem = new MenuItem("New");
        this.saveItem = new MenuItem("Save");
        this.saveAsItem = new MenuItem("Save as");
        this.openFilesItem = new MenuItem("Open File");
        this.exitItem = new MenuItem("Exit");
            
        filesMenu.getItems().addAll(newItem, openFilesItem, saveItem, saveAsItem, exitItem);
        
        //Files item:
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        this.exitItem.setOnAction((t) ->{
            this.main.getActionneur().boutonExitItem(t);
        });
        
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        this.newItem.setOnAction((t) ->{
            this.main.getActionneur().boutonNewItem(t);
        });
        
        openFilesItem.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        this.openFilesItem.setOnAction((t) ->{
            this.main.getActionneur().boutonOpenFilesItem(t);
        });
        
        saveItem.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        this.saveItem.setOnAction((t) ->{
            this.main.getActionneur().boutonSaveItem(t);
        });
        
        saveAsItem.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
        this.saveAsItem.setOnAction((t) ->{
            this.main.getActionneur().boutonSaveAsItem(t);
        });
    }
    private void buildEdit() {
        
        this.editMenu = new Menu("Edit");
        this.edit1Item = new MenuItem("edit1");
        this.edit2Item = new MenuItem("edit2");
        editMenu.getItems().addAll(edit1Item,edit2Item);
        
        //Edit item:
        edit1Item.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
        this.edit1Item.setOnAction((t) ->{
            this.main.getActionneur().MiseAJour(t);
            System.out.println("edit1 Clicked.");
        });
        edit2Item.setAccelerator(KeyCombination.keyCombination("Ctrl+F"));
        this.edit2Item.setOnAction((t) ->{
            this.main.getActionneur().MiseAJour(t);
            System.out.println("edit2 Clicked.");
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
