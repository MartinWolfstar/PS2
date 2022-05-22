/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import static java.lang.Math.acos;
import static java.lang.Math.asin;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public class Vecteur2D {
    
    private double vx;
    private double vy;

    /**
     * @return the vx
     */
    public double getVx() {
        return vx;
    }

    /**
     * @param vx the vx to set
     */
    public void setVx(double vx) {
        this.vx = vx;
    }

    /**
     * @return the vy
     */
    public double getVy() {
        return vy;
    }

    /**
     * @param vy the vy to set
     */
    public void setVy(double vy) {
        this.vy = vy;
    }
    
    public Vecteur2D (double vx, double vy){
        this.vx = vx;
        this.vy = vy;
    }
    
    @Override
    public String toString() {
        return "(" + this.vx + "," + this.vy + ")" ;
    }
    
    public void dessine(GraphicsContext context,double xi,double yi) {
        if((vx == 0)&&(vy == 0)){
            context.setGlobalAlpha(0);
        }else{
            context.setGlobalAlpha(0.7);
        }
        context.setStroke(Color.PURPLE);
        context.setFill(Color.PURPLE);
        context.strokeLine(xi,yi,xi + vx/10,yi + vy/10);
        context.strokeLine(xi,yi,xi + vx/10,yi + vy/10);
        context.fillOval(xi + vx/10 -2,yi + vy/10 -2, 4, 4);
        context.setGlobalAlpha(1);
    }
}
