/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import fr.insa.schmitt.ps2.Lire;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public class Groupe extends Trellis{
    
    private List<Trellis> contient;
    
    public Groupe(){
        this.contient = new ArrayList<Trellis>();
    }
    
    public void add(Trellis t){
        if(t.getGroupe() != this){
            if(t.getGroupe() != null){
                throw new Error("figure déjà dans un autre groupe");
            }
            this.contient.add(t);
            t.setGroupe(this);
        }
    }
    public void remove(Trellis f) {
        if (f.getGroupe() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.contient.remove(f);
        f.setGroupe(null);
    }

    public void removeAll(List<Trellis> lf) {
        for (Trellis f : lf) {
            this.remove(f);
        }
    }
    
    public Groupe sousGroupe(List<Trellis> lf) {
        // verifie que les figures font actuellement partie du groupe
        // et les enleve du groupe
        for (int i = 0; i < lf.size(); i++) {
            Trellis t = lf.get(i);
            if (t.getGroupe() != this) {
                throw new Error(t + " n'appartient pas au groupe " + this);
            }
            this.contient.remove(t);
            t.setGroupe(null);
        }
        Groupe ssg = new Groupe();
        for (int i = 0; i < lf.size(); i++) {
            ssg.add(lf.get(i));
        }
        this.add(ssg);
        return ssg;
    }
    
    public static String indente(String toIndente, String prefix){
        return prefix + toIndente.replaceAll("\n", "\n" + prefix);
    }
    
    @Override
    public String toString(){
        String res = "Groupe(\n";
        for (int i = 0; i < this.contient.size(); i++){
            res = res + indente(this.contient.get(i).toString(), " ") + "\n";
        }
        return res + ")";
    }
    
    public static Groupe groupeTest0(){
        NoeudSimple p1 = new NoeudSimple(100, 300);
        NoeudSimple p2 = new NoeudSimple(100, 100);
        NoeudSimple p3 = new NoeudSimple(300, 300);
        NoeudSimple p4 = new NoeudSimple(340, 50);
        NoeudSimple p5 = new NoeudSimple(10, 50);
        Barres b1 = new Barres(p1,p2);
        Barres b2 = new Barres(p3,p2);
        Barres b3 = new Barres(p1,p3);
        Barres b4 = new Barres(p4,p2);
        Groupe triangle = new Groupe();
        triangle.add(b1);
        triangle.add(b2);
        triangle.add(b3);
        Groupe res = new Groupe();
        res.add(p5);
        res.add(p4);
        res.add(triangle);
        return res;
    }
    public static Groupe groupeTest1(){
        Groupe res = new Groupe();
        return res;
    }
    
    public static void test1() {
        System.out.println("goupe test: \n" + Groupe.groupeTest0());
    }
    
    public static void testMenu() {
//        Groupe g = groupeTest();
        Groupe g = new Groupe();
        g.menuTexte();
    }
    
    public NoeudSimple choisiNoeud() {
        List<NoeudSimple> lp = new ArrayList<>();
        System.out.println("liste des points disponibles : ");
        int nbr = 0;
        for (int i = 0; i < this.contient.size(); i++) {
            Trellis f = this.contient.get(i);
            if (f instanceof NoeudSimple) {
                nbr++;
                lp.add((NoeudSimple) f);
                System.out.println(nbr + ") " + f);
            }
        }
        if (nbr == 0) {
            System.out.println("Aucun point disponible");
            return null;
        } else {
            int rep = -1;
            while (rep < 0 || rep > nbr) {
                System.out.println("votre choix (0 pour annuler) : ");
                rep = Lire.i();
            }
            if (rep == 0) {
                return null;
            } else {
                return lp.get(rep - 1);
            }
        }
    }
    
    public List<Trellis> choisiTrellis() {
        List<Trellis> res = new ArrayList<>();
        int rep = -1;
        while (rep != 0) {
            System.out.println("liste des figures disponibles : ");
            for (int i = 0; i < this.contient.size(); i++) {
                System.out.println((i + 1) + ") " + this.contient.get(i));
            }
            System.out.println("votre choix (0 pour finir) : ");
            rep = Lire.i();
            if (rep > 0 && rep <= this.contient.size()) {
                Trellis f = this.contient.get(rep - 1);
                if (res.contains(f)) {
                    System.out.println("déja selectionnée !!");
                } else {
                    res.add(f);
                }
                System.out.println(res.size() + " figure(s) séléctionnée(s)");
            }
        }
        return res;
    }
    
    public void menuTexte(){
        int rep = -1;
        while (rep != 0){
            System.out.println("1) afficher le groupe");
            System.out.println("2) ajouter un NoeudSimple");
            System.out.println("3) ajouter une Barre avec deux nouveaux NoeudSimple");
            System.out.println("4) ajouter une Barre sur deux NoeudSimple existants");
            System.out.println("5) créer un sous-groupe");
            System.out.println("6) afficher le rectangle englobant");
            System.out.println("7) calculer la distance à un point");
            System.out.println("8) retirer des figures du groupe");
            System.out.println("0) quitter");
            System.out.println("votre choix : ");
            rep = Lire.i();
            if (rep == 1){
                System.out.println(this);
            } else if (rep == 2){
                NoeudSimple np = NoeudSimple.demandeNoeud();
                this.add(np);
            }else if (rep == 3){
                Barres ns = Barres.demandeBarres();
                this.add(ns);
            }
            else if (rep == 4){
                System.out.println("choississez le debut du segment");
                NoeudSimple deb = this.choisiNoeud();
                if (deb != null){
                    System.out.println("choississez la fin de la barre");
                    NoeudSimple fin = this.choisiNoeud();
                    Barres ns = new Barres(deb,fin);
                    this.add(ns);
                }
            }else if (rep == 5){
                List<Trellis> select = this.choisiTrellis();
                this.sousGroupe(select);
            }else if (rep == 6) {
                System.out.println("maxX = " + this.maxX() + " ; "
                        + "minX = " + this.minX() + "\n"
                        + "maxY = " + this.maxY() + " ; "
                        + "minY = " + this.minY() + "\n");
            } else if (rep == 7) {
                System.out.println("entrez un point :");
                Noeud p = NoeudSimple.demandeNoeud();
                System.out.println("distance : " + this.distanceNoeud(p));
            } else if (rep == 8) {
                List<Trellis> select = this.choisiTrellis();
                this.removeAll(select);
            }
        }
    }

    @Override
    public double maxX() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double max = this.contient.get(0).maxX();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).maxX();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }
    
    @Override
    public double minX() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double min = this.contient.get(0).minX();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).minX();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
    }

    @Override
    public double maxY() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double max = this.contient.get(0).maxY();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).maxY();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }
    @Override
    public double minY() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double min = this.contient.get(0).minY();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).minY();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
    }
    @Override
    public double distanceNoeud(Noeud p) {
        if (this.contient.isEmpty()) {
            return new NoeudSimple(0, 0).distanceNoeud(p);
        } else {
            double dist = this.contient.get(0).distanceNoeud(p);
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).distanceNoeud(p);
                if (cur < dist) {
                    dist = cur;
                }
            }
            return dist;
        }
    }
    
    public Trellis plusProche(Noeud p, double distMax) {
        if (this.contient.isEmpty()) {
            return null;
        } else {
            Trellis fmin = this.contient.get(0);
            double min = fmin.distanceNoeud(p);
            for (int i = 1; i < this.contient.size(); i++) {
                Trellis fcur = this.contient.get(i);
                double cur = fcur.distanceNoeud(p);
                if (cur < min) {
                    min = cur;
                    fmin = fcur;
                }
            }
            if (min <= distMax) {
                return fmin;
            } else {
                return null;
            }
        }
    }
    
    @Override
    public void dessine(GraphicsContext context) {
        for (Trellis t : this.contient) {
            t.dessine(context);
        }
    }
    @Override
    public void dessineSelection(GraphicsContext context) {
        for (Trellis t : this.contient) {
            t.dessineSelection(context);
        }
    }
    @Override
    public void changeCouleur(Color value) {
        for (Trellis t : this.contient) {
            t.changeCouleur(value);
        }
    }

    
}
