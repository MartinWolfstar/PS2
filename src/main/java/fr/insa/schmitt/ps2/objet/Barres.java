/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import static fr.insa.schmitt.ps2.objet.Noeud.RAYON_IN_DRAW;
import java.io.IOException;
import java.io.Writer;
import java.lang.Math ;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public class Barres extends Forme{
    
    private Noeud nd;
    private Noeud na;
    private int identificateur;
    private int TC;
    private int CM;
    private int prix;

    /**
     * @return the nd
     */
    public Noeud getNd() {
        return nd;
    }
    public void setNd(Noeud nd) {
        this.nd = nd;
        
    }
    public Noeud getNa() {
        return na;
    }
    public void setNa(Noeud na) {
        this.na = na;
        
    }
    public int getIdentificateur() {
        return identificateur;
    }
    void setIdentificateur(int identificateur) {
        this.identificateur = identificateur;
    }
    public int getTC() {
        return TC;
    }
    public void setTC(int TC) {
        this.TC = TC;
    }
    public int getCM() {
        return CM;
    }
    public void setCM(int CM) {
        this.CM = CM;
    }
    public int getPrix() {
        return prix;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    public Barres (Noeud ndepart, Noeud narrive){
        
        this.CM = 0;
        this.TC = 0;
        this.identificateur = -1;
        this.prix = 0;
        this.na = narrive;
        this.nd = ndepart;
        this.na.getBarresDepart().add(this);
        this.na.getBarresArrivee().add(this);
        this.na.getBarresIncidente().add(this);
    }
    public Barres (Noeud ndepart, Noeud narrive, Color couleur){
        
        super(couleur);
        this.CM = 0;
        this.TC = 0;
        this.identificateur = -1;
        this.prix = 0;
        this.na = narrive;
        this.nd = ndepart;
        this.na.getBarresDepart().add(this);
        this.na.getBarresArrivee().add(this);
        this.na.getBarresIncidente().add(this);
    }
    public Barres (Noeud ndepart, Noeud narrive, int id, int cout, int tractionMax, int compressionMax, Color couleur){
        
        super(couleur);
        this.CM = compressionMax;
        this.TC = tractionMax;
        this.identificateur = id ;
        this.prix = cout ;
        this.na = narrive;
        this.nd = ndepart;
        this.na.getBarresDepart().add(this);
        this.na.getBarresArrivee().add(this);
        this.na.getBarresIncidente().add(this);
    }
    private Barres() {
        this(null, null);
    }
    
    @Override
    public String toString() {
        return "(" + this.nd + ";|;" + this.na + ")" + " id:" + identificateur + " prix" + prix;
    }
    
    public Noeud noeudOppose (Barres b, Noeud n){
        
        if (n == b.getNa()) {
            return b.getNd();
        }else{
            return b.getNa();
        }
    }
    
    public double angle (Noeud n1){
        
        double angle;
        Noeud n2 = noeudOppose(this,n1);
        
        double x1 = n1.getPx();
        double x2 = n2.getPx();
        double y1 = n1.getPy();
        double y2 = n2.getPy();
        
        double r = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
        angle = Math.acos((x2 - x1)/(r));
        
        return angle;
    }
    
    public void dessine(GraphicsContext context) {
        context.setStroke(this.getCouleur());
        context.strokeLine(this.getNd().getPx(), this.getNd().getPy(), this.getNa().getPx(), this.getNa().getPy());
        context.setFill(this.getNd().getCouleur());
        context.fillOval(this.getNd().getPx()-RAYON_IN_DRAW, this.getNd().getPy()-RAYON_IN_DRAW, 1.5*RAYON_IN_DRAW, 1.5*RAYON_IN_DRAW);
        context.setFill(this.getNa().getCouleur());
        context.fillOval(this.getNa().getPx()-RAYON_IN_DRAW, this.getNa().getPy()-RAYON_IN_DRAW, 1.5*RAYON_IN_DRAW, 1.5*RAYON_IN_DRAW);
    }
    
    public static Barres demandeBarres() {
        System.out.println("point debut :");
        NoeudSimple deb = NoeudSimple.demandeNoeud();
        System.out.println("point fin :");
        NoeudSimple fin = NoeudSimple.demandeNoeud();
        return new Barres(deb,fin);
        
    }

    @Override
    public double maxX() {
        return Math.max(this.getNd().getPx(), this.getNa().getPx());
    }
    public double minX() {
        return Math.min(this.getNd().getPx(), this.getNa().getPx());
    }
    public double maxY() {
        return Math.max(this.getNd().getPy(), this.getNa().getPy());
    }
    public double minY() {
        return Math.min(this.getNd().getPy(), this.getNa().getPy());
    }
    @Override
    public double distanceNoeud(Noeud p) {
        double x1 = this.nd.getPx();
        double y1 = this.nd.getPy();
        double x2 = this.na.getPx();
        double y2 = this.na.getPy();
        double x3 = p.getPx();
        double y3 = p.getPy();
        double up = ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1))
                / (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (up < 0) {
            return this.nd.distanceNoeud(p);
        } else if (up > 1) {
            return this.na.distanceNoeud(p);
        } else {
            Noeud p4 = new NoeudSimple(x1 + up * (x2 - x1),
                    y1 + up * (y2 - y1));
            return p4.distanceNoeud(p);
        }
    }
    @Override
    public void dessineSelection(GraphicsContext context) {
        context.setStroke(Trellis.COULEUR_SELECTION);
        context.strokeLine(this.getNd().getPx(), this.getNd().getPy(), this.getNa().getPx(), this.getNa().getPy());
    }
    
    @Override
    public void save(Writer w, Numeroteur<Trellis> num) throws IOException {
        if (!num.objExiste(this)) {
            int id = num.add(this);
            this.nd.save(w, num);
            this.na.save(w, num);
            w.append("Segment;" + id + ";" +
                    num.getIndex(this.nd) + ";" + num.getIndex(this.na) +
                    ";" + Forme.saveColor(this.getCouleur())+"\n");
        }
    }
    
} 
