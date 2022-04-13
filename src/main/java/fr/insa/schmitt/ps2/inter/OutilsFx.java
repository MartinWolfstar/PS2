/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

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
}
