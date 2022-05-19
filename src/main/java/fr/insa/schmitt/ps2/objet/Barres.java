/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import static fr.insa.schmitt.ps2.objet.Noeud.RAYON_IN_DRAW;
import java.io.IOException;
import java.io.Writer;
import static java.lang.Math.atan;
import static java.lang.Math.sqrt;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public class Barres extends Forme{
    
    private Noeud nd;
    private Noeud na;
    private int identificateur;
    
    private int TC;// traction max
    private int CM;//compression max
    private int prix; //prix au mètre

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
        this.prix = 4;
        this.na = narrive;
        this.nd = ndepart;
        this.nd.getBarresDepart().add(this);
        this.na.getBarresArrivee().add(this);
        this.nd.getBarresIncidente().add(this);
        this.na.getBarresIncidente().add(this);
    }
    public Barres (Noeud ndepart, Noeud narrive, Color couleur){
        
        super(couleur);
        this.CM = 0;
        this.TC = 0;
        this.identificateur = -1;
        this.prix = 4;
        this.na = narrive;
        this.nd = ndepart;
        this.nd.getBarresDepart().add(this);
        this.nd.getBarresIncidente().add(this);
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
        this.nd.getBarresDepart().add(this);
        this.na.getBarresArrivee().add(this);
        this.nd.getBarresIncidente().add(this);
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
    public double anglex (){
        
        double angle = 0;

        //faire arctan en fonction des signes de xb-xa et yb-ya
        double x1 = this.getNd().getPx();
        double x2 = this.getNa().getPx();
        double y1 = this.getNd().getPy();
        double y2 = this.getNa().getPy();
        
        double Dx = x2 - x1;
        double Dy = y2 - y1;
        
        if((Dx > 0)&&(Dy > 0)){
            angle = atan(Dy/Dx);
        }else if((Dx > 0)&&(Dy < 0)){
            angle = atan(-Dy/Dx);
        }else if((Dx < 0)&&(Dy > 0)){
            angle = atan(-Dy/Dx);
        }else{
            angle = atan(Dy/Dx);
        }
        
        return angle;
    }
    
    @Override
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
    public double longeurBarres(){
        double l = 0;
        
        double a =(this.getNa().getPx() - this.getNd().getPx())*(this.getNa().getPx() - this.getNd().getPx());
        double b = (this.getNa().getPy() - this.getNd().getPy())*(this.getNa().getPy() - this.getNd().getPy());
        
        l = sqrt(a + b);
        
        return l;
    }

    @Override
    public double maxX() {
        return Math.max(this.getNd().getPx(), this.getNa().getPx());
    }
    @Override
    public double minX() {
        return Math.min(this.getNd().getPx(), this.getNa().getPx());
    }
    @Override
    public double maxY() {
        return Math.max(this.getNd().getPy(), this.getNa().getPy());
    }
    @Override
    public double minY() {
        return Math.min(this.getNd().getPy(), this.getNa().getPy());
    }
    @Override
    public void setForce(Vecteur2D v) {
        //inutilisé, les vérifications sont effectuées avant
    }
    @Override
    public Vecteur2D getForce() {
        //inutilisé, les vérifications sont effectuées avant
        Vecteur2D v = new Vecteur2D(0,0);
        return v;
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
    public void save(Writer w, Numeroteur<GlobalObject> num) throws IOException {
        if (!num.objExiste(this)) {
            int id = num.add(this);
            this.nd.save(w, num);
            this.na.save(w, num);
            w.append("Barres;" + id + ";" +
                    num.getIndex(this.nd) + ";" + num.getIndex(this.na) +
                    ";" + Forme.saveColor(this.getCouleur())+"\n");
        }
    }
    
    @Override
    public void afficheResume() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ceci est une Barre");
                alert.setHeaderText(null);
                alert.setContentText("Noeud 1 : (" + this.getNd().getPx() + "," + this.getNd().getPy() + ") \n"
                        + "Noeud 2 : (" + this.getNa().getPx() + "," + this.getNa().getPy() + ") \n"
                        + "le prix de cette barre est de : " + this.getPrix()*this.longeurBarres() + "$ \n"
                        + "° \n" 
                );

                alert.showAndWait();
    }
    public String affListe() {
        String str = "";
        
        return str;
    }

} 
