/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import fr.insa.schmitt.ps2.objet.Trellis;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javax.swing.text.Segment;
import javax.xml.crypto.dsig.Transform;

/**
 *
 * @author schmi
 */
public class ZoneDessin extends Pane {
    
    /*private MainPanel main;
    private Canvas realCanvas;
    private RectangleDessin Rect;

    public ZoneDessin(MainPanel main) {
        
        OutilsFx.setSimpleBorder(this, Color.BLUE, 2);
        this.main = main;
        this.realCanvas = new Canvas(this.getWidth(), this.getHeight());
        this.Rect = new RectangleDessin(0, 0, this.getWidth(), this.getHeight());
        this.getChildren().add(this.realCanvas);
        this.realCanvas.heightProperty().bind(this.heightProperty());
        
        this.realCanvas.heightProperty().addListener((o) -> {
            //this.redrawAll();
        });
        this.realCanvas.widthProperty().bind(this.widthProperty());
        
        this.realCanvas.widthProperty().addListener((o) -> {
            //this.redrawAll();
        });
        
        this.realCanvas.setOnMouseClicked((t) -> {
            Actionneur action = this.main.getActionneur();
            action.clicDansZoneDessin(t);
        });
        
        this.realCanvas.setOnMouseMoved((t) -> {
            //this.main.getControleur().mouseMovedDansZoneDessin(t);
        });
        //this.redrawAll();
    }
    
    //à revoir comment ça fonctionne ici
    public void redrawAll() {
        GraphicsContext context = this.realCanvas.getGraphicsContext2D();
        context.setTransform(new Affine());
        context.clearRect(0, 0, this.realCanvas.getWidth(), this.realCanvas.getHeight());
        this.Rect.setxMax(this.realCanvas.getWidth());
        this.Rect.setyMax(this.realCanvas.getHeight());
        Transform curTrans = this.main.getZoneDessin().fitTransform(this.Rect);
        this.setTransform(curTrans);
        //Groupe model = this.main.getModel();
        //model.dessine(context);
        List<Figure> select = this.main.getControleur().getSelection();
        if (!select.isEmpty()) {
            for (Trellis f : select) {
                f.dessineSelection(context);
            }
        }
        Segment enCOurs = this.main.getControleur().getSegmentEnCoursDeCreation();
        if (enCOurs != null) {
            context.setLineDashes(1, 1);
            enCOurs.dessine(context);
            context.setLineDashes(null);
        }
    }*/
}
