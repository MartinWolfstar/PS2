/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import fr.insa.schmitt.ps2.*;

/**
 *
 * @author schmi
 */
public class NoeudAppuiDouble extends NoeudAppui{
    
    private int nbrInconnu;
    
    public NoeudAppuiDouble (double px, double py){ 
        super(px,py);
        this.nbrInconnu = 2;
    }
    
    @Override
    public String toString() {
        return "(" + this.getPx() + "," + this.getPy() + ")" + " id:" + getIdentificateur() + " force:" + getForce() + " inconnu :" + nbrInconnu;
    }
}

