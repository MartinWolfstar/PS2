/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import fr.insa.schmitt.ps2.objet.Groupe;
import fr.insa.schmitt.ps2.objet.NoeudAppuiDouble;
import fr.insa.schmitt.ps2.objet.NoeudAppuiSimple;
import fr.insa.schmitt.ps2.objet.NoeudSimple;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public class BarreOutilsGauche extends VBox{
    
    private Button bSelect;
    private Label bLabel;
    private TextArea textArea;
    
    private MainPanel main;
    
    public BarreOutilsGauche(MainPanel main) {
        this.main = main;

        buildTextArea();
        buildSelecButton();
        
        this.bLabel = new Label("ps: la zone ici est encore à faire");
        
        bSelect.setMaxWidth(Double.MAX_VALUE);
        
        this.getChildren().addAll(new Label("Search something:"),textArea,this.bSelect);
        OutilsFx.setSimpleBorder(this, Color.GRAY, 2);
        
    }
    private void buildTextArea(){
        this.textArea = new TextArea();
        textArea.setMaxSize(200,40);
    }
    private void buildSelecButton(){
        this.bSelect = new Button("entrer");
        
        bSelect.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("entrer Clicked.");
                String commande = textArea.getText();
                defCommande(commande);
                
            }
        });
    } 
    private void defCommande(String commande){
        String[] bouts = commande.split(" ");
        if (commande.equalsIgnoreCase("rule1")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("rule 1");
            alert.setHeaderText(null);
            alert.setContentText("Do not talk about");
            alert.showAndWait();
        }
        if (commande.equalsIgnoreCase("rule2")) {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("rule 2");
            alert.setHeaderText(null);
            alert.setContentText("Do NOT talk about");
            alert.showAndWait();
        }
        if (commande.equalsIgnoreCase("/import model0")) {
            main.setModel(Groupe.groupeTest0());
            main.redrawAll();
        }
        if (commande.equalsIgnoreCase("/import model1")) {
            main.setModel(Groupe.groupeTest1());
            main.redrawAll();
        }
        if (commande.equalsIgnoreCase("/import model2")) {
            main.setModel(Groupe.groupeTest2());
            main.redrawAll();
        }
        if (bouts[0].equalsIgnoreCase("/createNoeudSimple")) {
            try{
                double px = Double.parseDouble(bouts[1]);
                double py = Double.parseDouble(bouts[2]);
                Groupe model = main.getModel();
                model.add(new NoeudSimple(px,py));
                model.addN(new NoeudSimple(px,py));
                this.main.redrawAll();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        if (bouts[0].equalsIgnoreCase("/createNoeudAppuiSimple")) {
            try{
                double px = Double.parseDouble(bouts[1]);
                double py = Double.parseDouble(bouts[2]);
                Groupe model = main.getModel();
                model.add(new NoeudAppuiSimple(px,py));
                model.addN(new NoeudAppuiSimple(px,py));
                this.main.redrawAll();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        if (bouts[0].equalsIgnoreCase("/createNoeudAppuiDouble")) {
            try{
                double px = Double.parseDouble(bouts[1]);
                double py = Double.parseDouble(bouts[2]);
                Groupe model = main.getModel();
                model.add(new NoeudAppuiDouble(px,py));
                model.addN(new NoeudAppuiDouble(px,py));
                this.main.redrawAll();
            }catch(Exception e){
                System.out.println(e);
            }
        }

        
        
        
    }

    /**
     * @param bLabel the bLabel to set
     */
    public void setbLabel(Label bLabel) {
        this.bLabel = bLabel;
    }
}
