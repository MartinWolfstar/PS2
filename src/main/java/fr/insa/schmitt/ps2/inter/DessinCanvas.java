/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import fr.insa.schmitt.ps2.objet.Groupe;
import fr.insa.schmitt.ps2.objet.Terrain;
import fr.insa.schmitt.ps2.objet.Trellis;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Transform;

/**
 *
 * @author schmi
 */
public class DessinCanvas extends Pane{
    
    private MainPanel main;
    private Canvas realCanvas;
    private RectangleVue zoneVue;
    
    public DessinCanvas(MainPanel main){
        this.main = main;
        this.realCanvas = new Canvas(this.getWidth(), this.getHeight());
        //this.zoneVue = new RectangleVue(0, 0, this.getWidth(), this.getHeight());
        this.zoneVue = new RectangleVue(0, 0, this.getWidth(),this.getHeight());
        this.getChildren().add(this.realCanvas);
        //System.out.println("w = " + this.getWidth() + "h = " + this.getHeight());
        this.realCanvas.heightProperty().bind(this.heightProperty());
        this.realCanvas.heightProperty().addListener((o) -> {
            //System.out.println("w = " + this.realCanvas.getWidth() + "h = " + this.realCanvas.getHeight());
            this.redrawAll();
        });
        this.realCanvas.widthProperty().bind(this.widthProperty());
        this.realCanvas.widthProperty().addListener((o) -> {
            //System.out.println("w = " + this.realCanvas.getWidth() + "h = " + this.realCanvas.getHeight());
            this.redrawAll();
        });
        this.realCanvas.setOnMouseClicked(t ->{
            Actionneur actionneur = this.main.getActionneur();
            actionneur.clicDansZoneDessin(t);
        });
        
        this.redrawAll();
        //System.out.println(zoneVue);
    }
    
    public void concatenateTransform(Transform trans) {
        Transform oldTrans = this.realCanvas.getGraphicsContext2D().getTransform();
        Transform newTrans = oldTrans.createConcatenation(trans);
        this.setTransform(newTrans);
    }

    public void setTransform(Transform trans) {
        this.realCanvas.getGraphicsContext2D().setTransform(new Affine(trans));
    }

    public Transform getTransform() {
        return this.realCanvas.getGraphicsContext2D().getTransform();
    }
    
    public void redrawAll(){
        GraphicsContext context = this.realCanvas.getGraphicsContext2D();
        //context.setFill(Color.LIGHTGRAY);
        //context.fillRect(0,0, this.realCanvas.getWidth(), this.realCanvas.getHeight());    
        
        //gestion des zooms/:
        context.setTransform(new Affine());
        context.clearRect(0,0,this.realCanvas.getWidth(),this.realCanvas.getHeight());
        this.zoneVue.setxMax(this.realCanvas.getWidth());
        this.zoneVue.setyMax(this.realCanvas.getHeight());
        /*Transform curTrans = this.main.getZoneVue().fitTransform(this.zoneVue);
        this.setTransform(curTrans);*/
        //System.out.println(zoneVue);
        
        Groupe model = this.main.getModel();
        model.dessine(context);
        Terrain terrain = this.main.getTerrain();
        terrain.dessine(context);
        
        //on dessine autrement les objets selectionés:
        List<Trellis> select = this.main.getActionneur().getSelection();
        if (!select.isEmpty()){
            for (Trellis t: select){
                t.dessineSelection(context);
            }
        }
        
    }

}
