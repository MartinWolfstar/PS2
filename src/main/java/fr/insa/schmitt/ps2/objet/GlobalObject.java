/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public abstract class GlobalObject {
    
    private Trellis trellis;
    private Terrain terrain;
    
    public GlobalObject(){
        
    }
    
    @Override
    public String toString() {
        return "objet de cette application";
    }

    /**
     * @return the trellis
     */
    public Trellis getTrellis() {
        return trellis;
    }

    /**
     * @return the terrain
     */
    public Terrain getTerrain() {
        return terrain;
    }
    
    public abstract void save(Writer w, Numeroteur<GlobalObject> num)throws IOException;
    
    public void sauvegarde(File fout, boolean ecraser) throws IOException {
        Numeroteur<GlobalObject> num = new Numeroteur<>();
        try (BufferedWriter bout = new BufferedWriter(new FileWriter(fout,ecraser))) {
            this.save(bout, num);
        }
    }
    
    public  static GlobalObject[] lecture(File fin) throws IOException {
        Numeroteur<Trellis> num = new Numeroteur<>();
        GlobalObject derniere = null;
        Terrain ter = new Terrain(5);
        try (BufferedReader bin = new BufferedReader(new FileReader(fin))) {
            String line;
            while ((line = bin.readLine()) != null && line.length() != 0) {
                String[] bouts = line.split(";");
                if (bouts[0].equals("NoeudSimple")) {
                    int id = Integer.parseInt(bouts[1]);
                    double px = Double.parseDouble(bouts[2]);
                    double py = Double.parseDouble(bouts[3]);
                    Color col = Forme.parseColor(bouts[4], bouts[5], bouts[6]);
                    NoeudSimple np = new NoeudSimple(px, py, col);
                    num.associe(id, np);
                    derniere = np;
                } else if (bouts[0].equals("NoeudAppuiDouble")) {
                    int id = Integer.parseInt(bouts[1]);
                    double px = Double.parseDouble(bouts[2]);
                    double py = Double.parseDouble(bouts[3]);
                    Color col = Forme.parseColor(bouts[4], bouts[5], bouts[6]);
                    NoeudAppuiDouble np = new NoeudAppuiDouble(px, py, col);
                    num.associe(id, np);
                    derniere = np;
                    //System.out.println("test2");
                }else if (bouts[0].equals("NoeudAppuiSimple")) {
                    int id = Integer.parseInt(bouts[1]);
                    double px = Double.parseDouble(bouts[2]);
                    double py = Double.parseDouble(bouts[3]);
                    Color col = Forme.parseColor(bouts[4], bouts[5], bouts[6]);
                    NoeudAppuiSimple np = new NoeudAppuiSimple(px, py, col);
                    num.associe(id, np);
                    derniere = np;
                    //System.out.println("test2");
                } else if (bouts[0].equals("Barres")) {
                    int id = Integer.parseInt(bouts[1]);
                    int idP1 = Integer.parseInt(bouts[2]);
                    int idP2 = Integer.parseInt(bouts[3]);
                    Color col = Forme.parseColor(bouts[4], bouts[5], bouts[6]);
                    NoeudSimple p1 = (NoeudSimple) num.getObject(idP1);
                    NoeudSimple p2 = (NoeudSimple) num.getObject(idP2);
                    Barres ns = new Barres(p1, p2, col);
                    num.associe(id, ns);
                    derniere = ns;
                    //System.out.println("test3");
                }else if (bouts[0].equals("Groupe")) {
                    int id = Integer.parseInt(bouts[1]);
                    Groupe ng = new Groupe();
                    num.associe(id, ng);
                    for (int i = 2; i < bouts.length; i++) {
                        int idSous = Integer.parseInt(bouts[i]);
                        Trellis fig = num.getObject(idSous);
                        ng.add(fig);
                    }
                    //erreur par ici lors de la lecture
                    derniere = ng;
                }else if (bouts[0].equals("Terrain")) {
                    List<Double> x = new ArrayList<>();
                    int taille;
                    for(int i = 1; i < bouts.length ; i++) {
                        x.add(Double.parseDouble(bouts[i])); 
                    }
                    System.out.println(x.size());
                    System.out.println(ter.getXi().get(0));
                    ter.getXi().set(0, x.get(0));
                    ter.getYi().set(0, x.get(1));
                    ter.getXi().set(1, x.get(2));
                    ter.getYi().set(1, x.get(3));
                    x.remove(0);
                    x.remove(0);
                    x.remove(0);
                    x.remove(0);
                    taille = x.size();
                    System.out.println(taille);
                    if (taille > 1){
                        for(int i = 0; i< taille/2;i++){
                            ter.getXi().add(x.get(i));
                            ter.getYi().add(x.get(i+1));
                        }
                    }   
                }
            }
        }
        GlobalObject[] ret = { derniere , ter };
        return ret;
    }
}
