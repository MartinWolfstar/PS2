/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import java.util.List;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
/**
 *
 * @author schmi
 */
public class OutilsFx {
    public static void setSimpleBorder(Region r,Color c,double epaisseur) {
        
        r.setBorder(new Border(new BorderStroke(c, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(epaisseur))));
    }
    public static double Lagrange(double x, List<Double> xi, List<Double> yi){
        double y = 0;
        for (int j = 0; j < yi.size(); j++){
            y = y + yi.get(j) * L(x , xi, j);
        }
        return y;
    }
    public static double L(double x, List<Double> xi, int j){
        double Lj = 1;
        for (int k = 0; k < xi.size(); k++){
            if (k != j){
                Lj = Lj * ((x - xi.get(k))/(xi.get(j) - xi.get(k)));
            }else{
                Lj = Lj + 0;
            }
        }
        return Lj;
    }
}
