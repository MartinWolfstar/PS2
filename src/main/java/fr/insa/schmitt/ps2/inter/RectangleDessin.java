/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import javafx.scene.transform.Transform;

/**
 *
 * @author schmi
 */
public class RectangleDessin {
    
    /*private double xMin;
    private double xMax;
    private double yMin;
    private double yMax;*/
    
    /*public ZoneDessin() {
        OutilsFx.setSimpleBorder(this, Color.BLUE, 2);
        
    }*/
    
    /*public RectangleDessin(double xMin, double xMax, double yMin, double yMax) {
        //OutilsFx.setSimpleBorder(this, Color.BLUE, 2);
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }*/

    /*@Override
    public String toString() {
        return "RectangleHV{" + "xMin=" + getxMin() + ", xMax=" + getxMax() + ", yMin=" + getyMin() + ", yMax=" + getyMax() + '}';
    }*/
    
        /**
     * Calcule un rectangle ayant même centre, mais des cotés dont la taille
     * est multipliée par facteur.
     * @param facteur
     * @return le nouveau rectangle.
     */
    /*public RectangleDessin scale(double facteur) {
        double dx = this.getxMax() - this.getxMin();
        double dy = this.getyMax() - this.getyMin();
        double cx = (this.getxMax() + this.getxMin()) /2;
        double cy = (this.getyMax() + this.getyMin()) /2;
        double nxmin = cx - (dx / 2) * facteur;
        double nxmax = cx + (dx / 2) * facteur;
        double nymin = cy - (dy / 2) * facteur;
        double nymax = cy + (dy / 2) * facteur;
        return new RectangleDessin(nxmin, nxmax, nymin, nymax);    
    }
    
    
    public Transform fitTransform(RectangleDessin vue) {
        double minX1 = this.xMin;
        double maxX1 = this.xMax;
        double minY1 = this.yMin;
        double maxY1 = this.yMax;
        double dx1 = (maxX1 - minX1);
        double dy1 = (maxY1 - minY1);
        double cx1 = (maxX1 + minX1) / 2;
        double cy1 = (maxY1 + minY1) / 2;
        double minX2 = vue.xMin;
        double minY2 = vue.yMin;
        double maxX2 = vue.xMax;
        double maxY2 = vue.yMax;
        double dx2 = maxX2 - minX2;
        double dy2 = maxY2 - minY2;
        double cx2 = (maxX2 + minX2) / 2;
        double cy2 = (maxY2 + minY2) / 2;
        // je ramène le centre du rectangle 1 en 0,0
        Transform ttrans1 = Transform.translate(-cx1, -cy1);
        // je calcule (si possible) une échelle
        Transform tscale = Transform.scale(1, 1);
        if (dx1 > 0 && dy1 > 0 && dx2 > 0 && dy2 > 0) {
            double scale = Math.min(dx2 / dx1, dy2 / dy1);
            tscale = Transform.scale(scale, scale);
        }
        // je ramène 0 au centre  du rectangle 2
        Transform ttrans2 = Transform.translate(cx2, cy2);
        Transform res = ttrans2.createConcatenation(tscale).createConcatenation(ttrans1);
        return res;
    }*/
    /**
     * calcule un nouveau rectangle décalé en horizontal vers la gauche tel
     * que this et ce nouveau rectangle partage portionConservee surface.
     * Ex si portionConservee = 0, le nouveau rectangle est à gauche de l'ancien.
     * si portionConservee = 0.66, le nouveau rectangle est décalé de ~1/3 vers
     * la gauche, les 2/3 qui étaient à droite de l'ancien rectangle se retrouve
     * à gauche du nouveau.
     * @param portionDeplacee {@code 0 <= portionDeplacee <= 1)
     * @return un nouveau RectangleHV décalé à gauche par rapport à this
     */
    /*public RectangleDessin translateGauche(double portionConservee) {
        double dx = (this.getxMax() - this.getxMin())*(1-portionConservee);
        return new RectangleDessin(this.getxMin()-dx,this.getxMax()-dx, this.getyMin(), this.getyMax());
    }
    
    public RectangleDessin translateDroite(double portionConservee) {
        double dx = (this.getxMax() - this.getxMin())*(1-portionConservee);
        return new RectangleDessin(this.getxMin()+dx,this.getxMax()+dx, this.getyMin(), this.getyMax());
    }
    
    public RectangleDessin translateHaut(double portionConservee) {
        double dy = (this.getyMax() - this.getyMin())*(1-portionConservee);
        return new RectangleDessin(this.getxMin(), this.getxMax(),this.getyMin()-dy,this.getyMax()-dy);
    }
    
   public RectangleDessin translateBas(double portionConservee) {
        double dy = (this.getyMax() - this.getyMin())*(1-portionConservee);
        return new RectangleDessin(this.getxMin(), this.getxMax(),this.getyMin()+dy,this.getyMax()+dy);
    }

    public double getxMin() {
        return xMin;
    }

    public void setxMin(double xMin) {
        this.xMin = xMin;
    }

    public double getxMax() {
        return xMax;
    }

    public void setxMax(double xMax) {
        this.xMax = xMax;
    }


    public double getyMin() {
        return yMin;
    }

    public void setyMin(double yMin) {
        this.yMin = yMin;
    }

    public double getyMax() {
        return yMax;
    }

    public void setyMax(double yMax) {
        this.yMax = yMax;
    }*/
}
