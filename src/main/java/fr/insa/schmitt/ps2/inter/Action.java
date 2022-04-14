/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public class Action extends VBox{

    private VBox box;
    private Button play, stop;

    /**
     * Default Constructor.
     */
    public Action() {
        this.box = new VBox();
        build();
    }

    public VBox get() {
        return this.box;
    }

    private void build() {

        /*GridPane grille = new GridPane();
        grille.setGridLinesVisible(false);
        grille.setHgap(2);
        
        this.buildPlayButton();
        this.buildStopButton();
        
        grille.add(this.play, 0, 0);
        grille.add(this.stop, 1, 0);
        
        //this.container.setAlignment(Pos.CENTER);
        this.getChildren().add(grille);*/
        
        this.buildPlayButton();
        this.buildStopButton();
        
        this.box.getChildren().addAll(this.play,this.stop);
        OutilsFx.setSimpleBorder(this, Color.BLACK, 2);
        
        
    }
    
    private void buildPlayButton() {

        this.play = new Button("play");

        /*//Set the Image above the text.
        this.play.setContentDisplay(ContentDisplay.TOP);

        //Add image.
        String imgPath = "/ui/common/images/new.png";
        Image image = new Image(this.getClass().getResourceAsStream(imgPath),
                24.0, 24.0, true, true);
        ImageView imageView = new ImageView(image);
        this.play.setGraphic(imageView);*/

        /*//Set Tooltip
        this.play.setTooltip(new Tooltip("play"));

        //Set simple Click Event Handler.
        this.play.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                System.out.println("Play Button clicked.");

            }

        });*/
    }
    private void buildStopButton() {
        this.play = new Button("stop");

        /*//Set the Image above the text.
        this.play.setContentDisplay(ContentDisplay.TOP);

        //Add image.
        String imgPath = "/ui/common/images/new.png";
        Image image = new Image(this.getClass().getResourceAsStream(imgPath),
                24.0, 24.0, true, true);
        ImageView imageView = new ImageView(image);
        this.play.setGraphic(imageView);*/

        /*//Set Tooltip
        this.play.setTooltip(new Tooltip("stop"));

        //Set simple Click Event Handler.
        this.play.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                System.out.println("Stop Button clicked.");

            }

        });*/
    }
}