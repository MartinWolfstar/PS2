/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2;

/**
 *
 * @author schmi
 */
public class NoeudSimple extends Noeud{
    
    private int nbrInconnu;
    
    public NoeudSimple (double px, double py){ 
        super(px,py);
        this.nbrInconnu = 0;
    }
    @Override
    public String toString() {
        return "(" + this.getPx() + "," + this.getPy() + ")" + " id:" + getIdentificateur() + " force:" + getForce() + " inconnu :" + nbrInconnu;
    }
}
