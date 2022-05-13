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
    /*public void sauvegarde2(File fout) throws IOException {
        Numeroteur<GlobalObject> num = new Numeroteur<>();
        try (BufferedReader buf1 = new BufferedReader(new FileReader(fout))) {
            String all = "";
            String line;
            while ((line = buf1.readLine()) != null && line.length() != 0) {
                all = all + "\n" + line;
        }
        try (BufferedWriter bout = new BufferedWriter(new FileWriter(fout))) {
            this.save(bout, num);
            bout.append("\n" + all + "\n");
        }
    }*/
    
    public  static GlobalObject[] lecture(File fin) throws IOException {
        Numeroteur<GlobalObject> num = new Numeroteur<>();
        GlobalObject derniere = null;
        Terrain ter = new Terrain(5);
        try (BufferedReader bin = new BufferedReader(new FileReader(fin))) {
            String line;
            while ((line = bin.readLine()) != null && line.length() != 0) {
                String[] bouts = line.split(";");
                //System.out.println(line);
                if (bouts[0].equals("NoeudSimple")) {
                    int id = Integer.parseInt(bouts[1]);
                    double px = Double.parseDouble(bouts[2]);
                    //System.out.println(px);
                    double py = Double.parseDouble(bouts[3]);
                    Color col = Forme.parseColor(bouts[4], bouts[5], bouts[6]);
                    //System.out.println(px + ";" + py + ";" + col);
                    NoeudSimple np = new NoeudSimple(px, py, col);
                    num.associe(id, np);
                    derniere = np;
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
                } else if (bouts[0].equals("Groupe")) {
                    int id = Integer.parseInt(bouts[1]);
                    Groupe ng = new Groupe();
                    num.associe(id, ng);
                    for (int i = 2; i < bouts.length; i++) {
                        int idSous = Integer.parseInt(bouts[i]);
                        GlobalObject fig = num.getObject(idSous);
                        ng.add(fig);
                    }
                    derniere = ng;
                }else if (bouts[0].equals("Terrain")) {
                    /*for (int i = 2; i < bouts.length; i++) {
                        int idSous = Integer.parseInt(bouts[i]);
                        GlobalObject fig = num.getObject(idSous);
                        ng.add(fig);
                    }
                    derniere = ng;*/
                    //System.out.println("test1");
                    /*int max =(bouts.length-1)/2;
                    System.out.println(max);
                    for(int i = 1; i < 2 ; i++) {
                        System.out.println("test2 " + i);
                        double x = Double.parseDouble(bouts[i]);
                        System.out.println(x);
                        ter.getXi().set(i, x);
                    }
                    if (max >= 3){
                        for(int i = 3; i < max ; i++) {
                            System.out.println("test3");
                            double x = Double.parseDouble(bouts[i]);
                            System.out.println(x);
                            ter.getXi().add(x);
                        }
                    }
                    for(int i = max; i < max + 1 ; i++) {
                        System.out.println("test4 " + i);
                        double y = Double.parseDouble(bouts[i]);
                        System.out.println(y);
                        ter.getXi().set(i, y);
                    }
                    System.out.println("test2.5");
                    for(int i = max + 1; i < bouts.length; i++) {
                        System.out.println("test5");
                        double y = Double.parseDouble(bouts[i]);
                        ter.getYi().add(y);
                    }*/
                    List<Double> x = new ArrayList<>();
                    int taille;
                    for(int i = 1; i < bouts.length ; i++) {
                        x.add(Double.parseDouble(bouts[i])); 
                    }
                    System.out.println(x.size());
                    System.out.println(ter.getXi().get(0));
                    //System.out.println("test1");
                    ter.getXi().set(0, x.get(0));
                    ter.getYi().set(0, x.get(1));
                    ter.getXi().set(1, x.get(2));
                    ter.getYi().set(1, x.get(3));
                    //System.out.println("test2");
                    x.remove(0);
                    //System.out.println("test2");
                    x.remove(0);
                    //System.out.println("test2");
                    x.remove(0);
                    //System.out.println("test2");
                    x.remove(0);
                    //System.out.println("test3");
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
