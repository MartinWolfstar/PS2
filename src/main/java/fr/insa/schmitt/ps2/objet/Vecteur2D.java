/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import fr.insa.schmitt.ps2.*;
import java.awt.Color;

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
}
