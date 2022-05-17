/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import fr.insa.schmitt.ps2.Lire;
import java.io.IOException;
import java.io.Writer;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;

/**
 *
 * @author schmi
 */
public class Groupe extends Trellis{

    /**
     * @return the contientNoeud
     */
    public List<Noeud> getContientNoeud() {
        return contientNoeud;
    }

    /**
     * @return the contientBarres
     */
    public List<Barres> getContientBarres() {
        return contientBarres;
    }

    /**
     * @return the contient
     */
    public List<Trellis> getContient() {
        return contient;
    }
    
    private List<Trellis> contient;
    private List<Noeud> contientNoeud;
    private List<Barres> contientBarres;
    private Trellis trel1;
    
    public Groupe(){
        this.contient = new ArrayList<Trellis>();
        this.contientNoeud = new ArrayList<Noeud>();
        this.contientBarres = new ArrayList<Barres>();
    }
    
    public void add(Trellis t){
        if(t.getGroupe() != this){
            if(t.getGroupe() != null){
                throw new Error("figure déjà dans un autre groupe");
            }
            this.getContient().add(t);
            t.setGroupe(this);
        }
    }
    
    public void addN(Noeud t){
        if(t.getGroupe() != this){
            if(t.getGroupe() != null){
                throw new Error("figure déjà dans un autre groupe");
            }
            this.getContientNoeud().add(t);
            t.setGroupe(this);
        }
    }
    public void addB(Barres t){
        if(t.getGroupe() != this){
            if(t.getGroupe() != null){
                throw new Error("figure déjà dans un autre groupe");
            }
            this.getContientBarres().add(t);
            t.setGroupe(this);
        }
    }
    
    public void remove(Trellis f) {
        if (f.getGroupe() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.getContient().remove(f);
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
            this.getContient().remove(t);
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
        for (int i = 0; i < this.getContient().size(); i++){
            res = res + indente(this.getContient().get(i).toString(), " ") + "\n";
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
    public static Groupe groupeTest2(){
        
        NoeudSimple p1 = new NoeudSimple(0, 0,6,new Vecteur2D(2,2));
        Groupe res = new Groupe();
        res.add(p1);
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
        for (int i = 0; i < this.getContient().size(); i++) {
            Trellis f = this.getContient().get(i);
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
            for (int i = 0; i < this.getContient().size(); i++) {
                System.out.println((i + 1) + ") " + this.getContient().get(i));
            }
            System.out.println("votre choix (0 pour finir) : ");
            rep = Lire.i();
            if (rep > 0 && rep <= this.getContient().size()) {
                Trellis f = this.getContient().get(rep - 1);
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
        if (this.getContient().isEmpty()) {
            return 0;
        } else {
            double max = this.getContient().get(0).maxX();
            for (int i = 1; i < this.getContient().size(); i++) {
                double cur = this.getContient().get(i).maxX();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }
    
    @Override
    public double minX() {
        if (this.getContient().isEmpty()) {
            return 0;
        } else {
            double min = this.getContient().get(0).minX();
            for (int i = 1; i < this.getContient().size(); i++) {
                double cur = this.getContient().get(i).minX();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
    }

    @Override
    public double maxY() {
        if (this.getContient().isEmpty()) {
            return 0;
        } else {
            double max = this.getContient().get(0).maxY();
            for (int i = 1; i < this.getContient().size(); i++) {
                double cur = this.getContient().get(i).maxY();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
    }
    @Override
    public double minY() {
        if (this.getContient().isEmpty()) {
            return 0;
        } else {
            double min = this.getContient().get(0).minY();
            for (int i = 1; i < this.getContient().size(); i++) {
                double cur = this.getContient().get(i).minY();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
    }
    @Override
    public double distanceNoeud(Noeud p) {
        if (this.getContient().isEmpty()) {
            return new NoeudSimple(0, 0).distanceNoeud(p);
        } else {
            double dist = this.getContient().get(0).distanceNoeud(p);
            for (int i = 1; i < this.getContient().size(); i++) {
                double cur = this.getContient().get(i).distanceNoeud(p);
                if (cur < dist) {
                    dist = cur;
                }
            }
            return dist;
        }
    }
    
    public Trellis plusProche(Noeud p, double distMax) {
        if (this.getContient().isEmpty()) {
            return null;
        } else {
            Trellis fmin = this.getContient().get(0);
            double min = fmin.distanceNoeud(p);
            for (int i = 1; i < this.getContient().size(); i++) {
                Trellis fcur = this.getContient().get(i);
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
    public Noeud noeudPlusProche(Noeud p, double distMax) {
        if (this.getContientNoeud().isEmpty()) {
            return null;
        } else {
            Noeud fmin = this.getContientNoeud().get(0);
            double min = fmin.distanceNoeud(p);
            for (int i = 1; i < this.getContientNoeud().size(); i++) {
                Noeud fcur = this.getContientNoeud().get(i);
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
    public Barres barresPlusProche(Noeud p, double distMax) {
        if (this.getContientBarres().isEmpty()) {
            return null;
        } else {
            Barres fmin = this.getContientBarres().get(0);
            double min = fmin.distanceNoeud(p);
            for (int i = 1; i < this.getContientBarres().size(); i++) {
                //
                Barres fcur = this.getContientBarres().get(i);
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
    
    /*public Trellis noeudPlusProche(Noeud p, double distMax) {
        int a = 0;
        double test = MAX_VALUE;
        //la il peut y avoir un problème si la liste est vide
        Trellis NoeudInitial = this.contient.get(0);
        
        for (int i = 0; i < this.contient.size(); i++) {
            if (this.contient.get(i).getClass() == NoeudSimple.class){
                test = this.contient.get(i).distanceNoeud(p);
                NoeudInitial = this.contient.get(i);
                a += 1;
            }
        }
        //
        System.out.println(a);
        //
        if (a == 0) {
            return null;
        } else {
            
            for (int i = 0; i < this.contient.size(); i++) {
                if (this.contient.get(i).getClass() == NoeudSimple.class){
                    Trellis fcur = this.contient.get(i);
                    double cur = fcur.distanceNoeud(p);
                    if (cur < test) {
                        test = cur;
                        NoeudInitial = fcur;
                    }
                }
            }
            if (test <= distMax) {
                double u = NoeudInitial.maxX();
                return NoeudInitial;
            } else {
                return null;
            }
        }
    }*/
    
    @Override
    public void dessine(GraphicsContext context) {
        for (Trellis t : this.getContient()) {
            t.dessine(context);
        }
    }
    @Override
    public void dessineSelection(GraphicsContext context) {
        for (Trellis t : this.getContient()) {
            t.dessineSelection(context);
        }
    }
    @Override
    public void changeCouleur(Color value) {
        for (Trellis t : this.getContient()) {
            t.changeCouleur(value);
        }
    }
    @Override
    public void setForce(Vecteur2D v) {
        //inutile, les vérifications sont effectuées avant
    }
    @Override
    public Vecteur2D getForce() {
        //inutile, les vérifications sont effectuées avant
        Vecteur2D v = new Vecteur2D(0,0);
        return v;
    }

    @Override
    public void save(Writer w, Numeroteur<GlobalObject> num) throws IOException {
        if (!num.objExiste(this)) {
            int id = num.add(this);
            for (Trellis f : this.getContient()) {
                f.save(w, num);
            }
            w.append("Groupe;" + id);
            for (Trellis t : this.getContient()) {
                w.append(";" + num.getIndex(t));
            }
            w.append("\n");
        }
        //rajouter les deux autres listes
    }
    
    @Override
    public void afficheResume() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ceci est une Barre");
                alert.setHeaderText(null);
                alert.setContentText("info \n"
                        + "info \n"
                        + "info \n"
                        + "° \n" 
                );

                alert.showAndWait();
    }
    
    public void gestionForce(){
        
        
        int nbrNS = 0;
        int nbrNAD = 0;
        int nbrNAS = 0;
        int nbrNB = 0;
        int nbrN = 0;
        
        for(int i = 0; i < this.contient.size() ; i++){
            if(this.contient.get(i).getClass().equals("NoeudSimple")){
                nbrNS +=1;
            }else if(this.contient.get(i).getClass().equals("NoeudAppuiDouble")){
                nbrNAD +=1;
            }else if(this.contient.get(i).getClass().equals("NoeudAppuiSimple")){
                nbrNAS +=1;
            }else if(this.contient.get(i).getClass().equals("Barres")){
                nbrNB +=1;
            }
        }
        System.out.println("je passe par ici");
        nbrN = nbrNS + nbrNAD + nbrNAS;
        
        boolean testinversible = (2*nbrN == nbrNB + nbrNAS + 2*nbrNAD);
        
        if (nbrNAD > 1){
            testinversible = false;
        }
        
        if (testinversible == true){
            Mat mat = new Mat (nbrN * 2, nbrN * 2+1);
            
            int indice = 0;
            for (int i = 0; i < this.contientNoeud.size(); i++) {
                Noeud n = this.contientNoeud.get(i);
                for (int j = 0; j < this.contientBarres.size() ; j++){
                    Barres b1 = this.contientBarres.get(j);
                    for (int k = 0; k < n.getBarresIncidente().size() ; k++){
                        Barres b2 = n.getBarresIncidente().get(k);
                        if (b1 == b2 ){
                            mat.setOneCoeff(indice, j, cos(b2.anglex())); 
                            mat.setOneCoeff(indice + 1 , j, sin(b2.anglex()));
                        }else{
                            mat.setOneCoeff(indice , j, 0); 
                            mat.setOneCoeff(indice + 1 , j, 0);
                        }
                    }
                }
                if(n.getClass().equals("NoeudAppuiDouble")){
                    for (int a = this.contientBarres.size(); a < nbrN * 2; a++){
                        mat.setOneCoeff(indice , a , 0);
                        mat.setOneCoeff(indice + 1 , a , 0);
                    }
                }else if(n.getClass().equals("NoeudAppuiSimple")){
                    for (int a = this.contientBarres.size(); a < nbrN * 2; a++){
                        mat.setOneCoeff(indice , a , 0);
                        mat.setOneCoeff(indice + 1 ,a , 0); //tangeante TODO
                    }
                }else{
                    for (int a = this.contientBarres.size(); a < nbrN * 2; a++){
                        mat.setOneCoeff(indice , a , 0);
                        mat.setOneCoeff(indice + 1, a , 0);
                    }
                }
                
                mat.setOneCoeff(i , nbrN * 2 , 0);
                indice +=2;
            }
            System.out.println(mat);
        }else{
            System.out.println("Matrice non inversible");
        }
        System.out.println("je passe par la");
        
        /*public void solve(){
        Matrice mat =new Matrice(barres.size()+3,barres.size()+4);
        for (int i = 0; i < this.contient.size(); i++) {
            if (this.contientNoeud.get(i).getClass().equals("Noeud Appui Simple")){
                mat.set(2*i, contientBarres.size()+2 ,0);//Rbx=0
                mat.set((2*i)+1, contientBarres.size()+2,1);//Rby=1
            }
            else if (noeuds.get(i).getType().equals("Noeud Appui Double")) {
                mat.set(2*i, barres.size(),1);//Rax=1
                mat.set((2*i)+1, barres.size()+1,1);//Ray=1
            }
            for (int j = 0; j < barres.size(); j++) {
                if(noeuds.get(i).barresIncidentes().contains(barres.get(j))){
                    mat.set(2*i, j,Math.cos(barres.get(j).angle(noeuds.get(i))));
                    mat.set((2*i)+1, j,Math.sin(barres.get(j).angle(noeuds.get(i))));
                }
            }
            mat.set(2*i, barres.size()+3 ,-noeuds.get(i).getF));//Rbx=0
            mat.set((2*i)+1, barres.size()+3,-noeuds.get(i).getF));
        }
        System.out.println(mat);
        mat.gauss();
        System.out.println(mat);*/
        
        
    }
    public void gestionForce2test(){
        int nbrNS = 0;
        int nbrNAD = 0;
        int nbrNAS = 0;
        int nbrNB = 0;
        int nbrN = 0;
        
        for(int i = 0; i < this.contient.size() ; i++){
            String str = this.contient.get(i).getClass().getName();
            //System.out.println(str);
            if(str.equals("fr.insa.schmitt.ps2.objet.NoeudSimple")){
                nbrNS +=1;
            }else if(str.equals("fr.insa.schmitt.ps2.objet.NoeudAppuiDouble")){
                nbrNAD +=1;
            }else if(str.equals("fr.insa.schmitt.ps2.objet.NoeudAppuiSimple")){
                nbrNAS +=1;
            }else if(str.equals("fr.insa.schmitt.ps2.objet.Barres")){
                nbrNB +=1;
            }
        }
        nbrN = nbrNS + nbrNAD + nbrNAS;
        
        /*System.out.println("nombre noeud: " + nbrN + "\n"
        + "nombre noeud simple: " + nbrNS + "\n"
        + "nombre noeud a double: " + nbrNAD + "\n"
        + "nombre noeud a simple: " + nbrNAS + "\n"
        + "nombre noeud barres: " + nbrNB + "\n");*/

        boolean testinversible = (2*nbrN == nbrNB + nbrNAS + 2*nbrNAD);
        if (nbrNAD > 1){
            testinversible = false;
        }
        //System.out.println(testinversible); 
        testinversible = true;
        if (testinversible == true){
            //on créer les matrices:
            Mat matfinale = new Mat (nbrN * 2, nbrN * 2+1);
            Mat mat1 = new Mat (nbrN*2, nbrNB);
            //System.out.println(mat1);
            Mat mat2 = new Mat (nbrN*2, 2);
            Mat mat3 = new Mat (nbrN*2, nbrNAS);
            Mat mat4 = new Mat (nbrN*2, 1);
            
            //on les préremplis:
            mat1.remplir0();
            //System.out.println(mat1);
            mat2.remplir0();
            //System.out.println(mat2);
            mat3.remplir0();
            //System.out.println(mat3);
            mat4.remplir0();
            //System.out.println(mat4);
            //on les remplis:
            //mat1:
            int indice = 0;
            for (int i = 0; i < this.contientNoeud.size(); i++) {
                Noeud n = this.contientNoeud.get(i);
                System.out.println("noeud" + i);
                

                for (int k = 0; k < n.getBarresIncidente().size() ; k++){
                    Barres b2 = n.getBarresIncidente().get(k);    

                    for (int j = 0; j < this.contientBarres.size() ; j++){
                        Barres b1 = this.contientBarres.get(j);
                        //System.out.println("b1: " + b1 + "b2: " + b2);
                        if (b1 == b2 ){
                            System.out.println("je rajoute la barre" + (j+1));
                            mat1.setOneCoeff(indice, j, cos(b1.anglex())); 
                            mat1.setOneCoeff(indice + 1 , j, sin(b1.anglex()));
                            
                        }
                    }
                }
                indice +=2;
            }
            System.out.println(mat1);
            //mat2:
            indice = 0;
            for (int i = 0; i < this.contientNoeud.size(); i ++) {
                Noeud n = this.contientNoeud.get(i);
                String str = this.contient.get(i).getClass().getName();
                if (str.equals("fr.insa.schmitt.ps2.objet.NoeudAppuiDouble")){
                    mat2.setOneCoeff(indice,0,1);
                    mat2.setOneCoeff(indice + 1,1,1);
                }
                indice += 2;
            }
            //System.out.println(mat2);
            //mat3:
            indice = 0;
            int indice2 = 0;
            for (int i = 0; i < this.contientNoeud.size(); i ++) {
                Noeud n = this.contientNoeud.get(i);
                String str = this.contient.get(i).getClass().getName();
                if (str.equals("fr.insa.schmitt.ps2.objet.NoeudAppuiSimple")){
                    mat3.setOneCoeff(indice,indice2,0);
                    mat3.setOneCoeff(indice + 1,indice2,1);
                    indice2 += 1;
                }
                indice += 2;
            }
            //System.out.println(mat3);
            //mat4:
            indice = 0;
            for (int i = 0; i < this.contientNoeud.size(); i ++) {
                Noeud n = this.contientNoeud.get(i);
                this.getRealpoint(n.getPx(), n.getPy());
                mat4.setOneCoeff(indice,0,trel1.getForce().getVx());
                mat4.setOneCoeff(indice + 1,0,trel1.getForce().getVy());
                indice += 2;
            }
            //System.out.println(mat4);
            
            //on les concat:
            //mat1.concat(mat1,mat1);
            //System.out.println(mat1);
            matfinale = mat1;
            if (nbrNAD > 0){
                
                matfinale = matfinale.concat(matfinale,mat2);
                //System.out.println(matfinale);
            }
            if (nbrNAS > 0){
                matfinale = matfinale.concat(matfinale,mat3);
                //System.out.println(matfinale);
            }
            matfinale = matfinale.concat(matfinale,mat4);
            //et on obtient la matrice à inverser:
            //verifier qu'elle a quand meme la bonne taille!!
            //System.out.println(matfinale);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Matrice du système:");
                alert.setHeaderText(null);
                alert.setContentText(matfinale.toString());

                alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Matrice du système:");
                alert.setHeaderText(null);
                alert.setContentText("le trellis n'est pas isostatique!");

                alert.showAndWait();
        }
    }
    
    private void getRealpoint (double x,double y){
        
        Noeud pclic = new NoeudSimple(x,y);
            //max value est peut etre trop grand ici
            Noeud proche = this.noeudPlusProche(pclic, Double.MAX_VALUE);  
            //il y a un petite erreur dans le programme donc ce passage sert à le compenser:
            for (int i = 0; i < this.getContient().size(); i++ ){
                if ((proche.getPx() == this.getContient().get(i).maxX())&&(proche.getPx() == this.getContient().get(i).minX())){
                    //System.out.println(this.getContient().get(i).getClass().getName());
                    this.trel1 = this.getContient().get(i);
                    //System.out.println(trel1 + "donc c'est bon");
                }
            }
    }
}
