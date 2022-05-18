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
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public abstract class Trellis extends GlobalObject{
    
    private List<Barres> barres;
    private List<Noeud> noeud;
    public static Color COULEUR_SELECTION = Color.RED;
    /**
     * null si aucun vide
     */
    private Groupe groupe;


    /**
     * @return the barres
     */
    public List<Barres> getBarres() {
        return barres;
    }

    /**
     * @param barres the barres to set
     */
    public void setBarres(List<Barres> barres) {
        this.barres = barres;
    }

    /**
     * @return the noeud
     */
    public List<Noeud> getNoeud() {
        return noeud;
    }

    /**
     * @param noeud the noeud to set
     */
    public void setNoeud(List<Noeud> noeud) {
        this.noeud = noeud;
    }
    
    public Trellis (){
        
        this.noeud = new ArrayList<>();
        this.barres = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "barres de ce Trellis :" + this.barres + "\n noeuds de ce trellis; " + this.noeud;
    }
    
    public int maxIdNoeud (){
        int max = 0;
        for(int i = 0 ; i < noeud.size(); i++)
            if (noeud.get(i).getIdentificateur() > max){
                max = noeud.get(i).getIdentificateur();
            }
        return max;
    }
    public int maxIdBarres (){
        int max = 0;
        for(int i = 0 ; i < barres.size(); i++)
            if (barres.get(i).getIdentificateur() > max){
                max = barres.get(i).getIdentificateur();
            }
        return max;
    }
    
    public void ajouteNoeud(Noeud n){
        for(Noeud inoeud : noeud){
            if ((n.getPx() == inoeud.getPx())&&(n.getPy() == inoeud.getPy())) {
                throw new Error("figure déjà");
            }
        }
        int idmax = maxIdNoeud ();
        int idnew = idmax + 1;
        
        n.setIdentificateur(idnew);
        noeud.add(n);
    }

    
    public void ajouteBarres(Barres b){
        
        Noeud noeud1 = b.getNd();
        Noeud noeud2 = b.getNa();
        
        for(Noeud inoeud : noeud){
            if ((noeud1.getPx() != inoeud.getPx())||(noeud1.getPy() != inoeud.getPy())) {
                ajouteNoeud(noeud1);
            }
            if ((noeud2.getPx() != inoeud.getPx())||(noeud2.getPy() != inoeud.getPy())) {
                ajouteNoeud(noeud2);
            }
        }
        
        for(Barres ibarres : barres){
            if ((b.getNd() == ibarres.getNd())&&(b.getNa() == ibarres.getNa())) {
                throw new Error("figure déjà");
            }
        }
        int idmax = maxIdBarres ();
        int idnew = idmax + 1;
        
        b.setIdentificateur(idnew);
        barres.add(b);
    }

    /**
     * @return the groupe
     */
    public Groupe getGroupe() {
        return groupe;
    }

    /**
     * @param groupe the groupe to set
     * il est pas en public!
     */
    void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
    
    public abstract double maxX();
    public abstract double minX();
    public abstract double maxY();
    public abstract double minY();
    public abstract double distanceNoeud(Noeud p);
    
    public abstract void dessine(GraphicsContext context);
    public abstract void afficheResume();
    public abstract void dessineSelection(GraphicsContext context);
    public abstract void changeCouleur(Color value);
    public abstract void setForce(Vecteur2D v);
    public abstract Vecteur2D getForce();
    public abstract String affListe();
    
    //public abstract void save(Writer w, Numeroteur<Trellis> num)throws IOException;

    /*public void sauvegarde(File fout) throws IOException {
        Numeroteur<Trellis> num = new Numeroteur<>();
        try (BufferedWriter bout = new BufferedWriter(new FileWriter(fout))) {
            this.save(bout, num);
        }
    }   */
    
    /*public static Trellis lecture(File fin) throws IOException {
        Numeroteur<Trellis> num = new Numeroteur<>();
        Trellis derniere = null;
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
                        Trellis fig = num.getObject(idSous);
                        ng.add(fig);
                    }
                    derniere = ng;
                }
            }

        }
        return derniere;
    }*/
        
}
