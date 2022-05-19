 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.inter;

import static fr.insa.schmitt.ps2.inter.OutilsFx.Lagrange;
import fr.insa.schmitt.ps2.objet.Barres;
import fr.insa.schmitt.ps2.objet.GlobalObject;
import fr.insa.schmitt.ps2.objet.Groupe;
import fr.insa.schmitt.ps2.objet.Noeud;
import fr.insa.schmitt.ps2.objet.NoeudAppuiDouble;
import fr.insa.schmitt.ps2.objet.NoeudAppuiSimple;
import fr.insa.schmitt.ps2.objet.NoeudSimple;
import fr.insa.schmitt.ps2.objet.Terrain;
import fr.insa.schmitt.ps2.objet.Trellis;
import fr.insa.schmitt.ps2.objet.Vecteur2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent; 
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.RED;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author schmi
 */
public class Actionneur {
    
    private MainPanel main;
    private int etat;
    private List<Trellis> selection;
    private double[] pos1 = new double[2];
    private double[] pos2 = new double[2];
    private Noeud sauvN;
    private Noeud sauvN2;
    private Trellis trel1;
    private Barres sauvB;
    private List<Double> pos3x;
    private List<Double> pos3y;
    private int etatSecondaire;
    
    public Actionneur(MainPanel main) {
        this.main = main;
        this.selection = new ArrayList<>();
        this.pos3x = new ArrayList<>();
        this.pos3y = new ArrayList<>();
    }
   
    public void changeEtat(int nouvelEtat){
        
        etat = nouvelEtat;
        System.out.println(etat);
        
        if (nouvelEtat == 100) {
            
        }
        if (nouvelEtat == 200) {
            
        }
        if (nouvelEtat == 300) {
            
        }
        if (nouvelEtat == 400) {
            
        }
        if (nouvelEtat == 500) {
            
        }
    }
    
    public void changeEtatSecondaire(int nouvelEtat){
        etatSecondaire = nouvelEtat;
        System.out.println(etatSecondaire);
    }

    void clicDansZoneDessin(MouseEvent t) {
        double px = t.getX();
        double py =t.getY();
        /*px = px + (main.getWidth()/10);
        py = py + (main.getHeight()/10);*/
        /*px = px -100;
        py = py -100;*/
        /*px = px + (main.GetZoneVue().getxMax());
        py = py + (main.getHeight()/10);*/
        
        if (this.etat == 322){
            
            ///----------création Noeud
            Groupe model = this.main.getModel();
            model.add(new NoeudSimple(px,py));
            model.addN(new NoeudSimple(px,py));
            this.main.redrawAll(); 
            
        }else if (this.etat == 100){
           
            ///----------play
            
            System.out.println(main.getModel());
            System.out.println("terrain : \n" + this.main.getTerrain().toString());
            this.changeEtat(350);
            
        }else if (this.etat == 150){
            ///----------selection
            Noeud pclic = new NoeudSimple(t.getX(),t.getY());
            //max value est peut etre trop grand ici
            Trellis proche = this.main.getModel().plusProche(pclic, Double.MAX_VALUE);
            if (proche != null) {
                if (t.isShiftDown()) {
                    this.getSelection().add(proche);
                } else if (t.isControlDown()) {
                    if (this.getSelection().contains(proche)) {
                        this.getSelection().remove(proche);
                    } else {
                        this.getSelection().add(proche);
                    }
                } else {
                    this.getSelection().clear();
                    this.getSelection().add(proche);
                }
                this.activeBoutonsSuivantSelection();
                this.main.redrawAll();
            }
                
        }else if (this.etat == 151){
            /*----------selectionPoint
            Noeud pclic = new NoeudSimple(t.getX(),t.getY());
            //max value est peut etre trop grand ici
            Noeud proche = this.main.getModel().noeudPlusProche(pclic, Double.MAX_VALUE);  */
           
            selectRealpoint(t);
            
            this.getSelection().clear();
            this.getSelection().add(trel1);
            //System.out.println(trel1);
            this.activeBoutonsSuivantSelection();
            this.main.redrawAll();
            
            selectRealpoint(t);
                
        }else if (this.etat == 152){
            /*----------selectionBarres
            Noeud pclic = new NoeudSimple(t.getX(),t.getY());
            //max value est peut etre trop grand ici
            Barres proche = this.main.getModel().barresPlusProche(pclic, Double.MAX_VALUE);  */
           
            selectRealBarres(t);
            
            this.getSelection().clear();
            this.getSelection().add(trel1);
            //System.out.println(trel1);
            this.activeBoutonsSuivantSelection();
            this.main.redrawAll();
                
        }else if (this.etat == 323){
            //----------mesure de l'angle entre 3 Noeud (le centre est saisi en 2)
            Noeud pclic = new NoeudSimple(t.getX(),t.getY());
            //max value est peut etre trop grand ici
            Noeud proche = this.main.getModel().noeudPlusProche(pclic, Double.MAX_VALUE);
            sauvN = proche;
            this.changeEtat(324);
            
        }else if (this.etat == 324){
            //----------mesure de l'angle
            Noeud pclic = new NoeudSimple(t.getX(),t.getY());
            //max value est peut etre trop grand ici
            Noeud proche = this.main.getModel().noeudPlusProche(pclic, Double.MAX_VALUE);
            sauvN2 = proche;
            this.changeEtat(325);
            
        }else if (this.etat == 325){
            //----------mesure de l'angle
            Noeud pclic = new NoeudSimple(t.getX(),t.getY());
            //max value est peut etre trop grand ici
            Noeud proche = this.main.getModel().noeudPlusProche(pclic, Double.MAX_VALUE);
            
            double angle = sauvN2.angle(sauvN,proche);
            System.out.println(angle);
            angle = angle * 57.2958;

            System.out.println(angle);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mesure de l'angle");
                alert.setHeaderText(null);
                alert.setContentText("l'angle est de:\n"
                        + angle + "° \n");

                alert.showAndWait();
            this.changeEtat(323);
            
        }else if (this.etat == 330){
            
            this.selectRealpoint(t);
            //sauvN = proche;
            //this.sauvN.setCouleur(RED);
            //this.trel1.setCouleur(RED);
            
            String entrerUtilisateur = "";   
            Vecteur2D v = new Vecteur2D(50,50);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("A propos");
                alert.setHeaderText(null);
                VBox box = new VBox();
                TextArea entrer = new TextArea();
                box.getChildren().add(entrer);
                alert.getDialogPane().setContent(box);
                //il n'affiche pas le texte, problème
                alert.setContentText("entrer les forces qui s'exercent sur ce point\n"
                        + "forme : double;double\n");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get() == null) {
                    //System.out.println("test1");
                } else if (option.get() == ButtonType.OK) {
                    //System.out.println("test2");
                    try{
                        entrerUtilisateur = entrer.getText();
                        String[] bouts = entrerUtilisateur.split(";");
                        //System.out.println(bouts[0]);
                        double fx = Double.parseDouble(bouts[0]);
                        double fy = Double.parseDouble(bouts[1]);
                        //System.out.println("fx:" + fx + "fy:" + fy);
                        v = new Vecteur2D(fx,fy);
                        /*sauvN.setForce(v);
                        System.out.println(sauvN);*/
                        //proche.setForce(v);
                        //trel1.setForce(v);
                        //proche.setIdentificateur(6);
                        //System.out.println(trel1);
                        
                    }catch(Exception E){
                        //System.out.println(E);
                    }
                    this.trel1.setForce(v);
                    //this.sauvN.setIdentificateur(4856);
                    System.out.println(this.trel1);
   
                } else if (option.get() == ButtonType.CANCEL) {
                    //System.out.println("test3");
                } else {
                    //System.out.println("test4");
                }
                //alert.showAndWait();
            
            this.changeEtat(323);
            
        }else if (this.etat == 341){
            //----------mesurer barres
            Noeud pclic = new NoeudSimple(t.getX(),t.getY());
            //max value est peut etre trop grand ici
            Barres proche = this.main.getModel().barresPlusProche(pclic, Double.MAX_VALUE);
            double distance = proche.longeurBarres();
            //System.out.println(distance);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mesure de la barre");
                alert.setHeaderText(null);
                alert.setContentText("Mesure de la barre:\n"
                        + distance + "\n");

                alert.showAndWait();
            
        }else if (this.etat == 343){
            //----------creer segment
            this.pos1[0] = px;
            this.pos1[1] = py;
            this.changeEtat(344);
        }else if (this.etat == 344){
            //----------creer segment.2
            double px2 = px;
            double py2 = py;
            
            this.main.getModel().add(new Barres (new NoeudSimple(this.pos1[0],this.pos1[1]),new NoeudSimple(px2,py2)));
            this.main.getModel().add(new NoeudSimple(this.pos1[0],this.pos1[1]));
            this.main.getModel().add(new NoeudSimple(px2,py2));
            this.main.getModel().addB(new Barres (new NoeudSimple(this.pos1[0],this.pos1[1]),new NoeudSimple(px2,py2)));
            this.main.getModel().addN(new NoeudSimple(this.pos1[0],this.pos1[1]));
            this.main.getModel().addN(new NoeudSimple(px2,py2));
            this.main.redrawAll();
            
            /*Groupe model = this.main.getModel();
            
            NoeudSimple ns = new NoeudSimple(this.pos1[0],this.pos1[1]);
            NoeudSimple ns2 = new NoeudSimple(px2,py2);
            model.add(ns);
            model.addN(ns);
            model.add(ns2);
            model.addN(ns2);
            
            model.add(new Barres (ns,ns2));
            model.addB(new Barres (ns,ns2));
            
            this.main.redrawAll();*/
            this.changeEtat(343);
 
        }else if (this.etat == 345){
            //----------creer segment à partie d'un point partie 1
            Noeud pclic = new NoeudSimple(t.getX(),t.getY());
            //max value est peut etre trop grand ici
            Noeud proche = this.main.getModel().noeudPlusProche(pclic, Double.MAX_VALUE);  
            sauvN = proche;
            this.changeEtat(346);
            
        }else if (this.etat == 346){
            //----------creer segment à partie d'un point partie 1
            //il selectionne un endroit et ça creer la barre
            double px2 = px;
            double py2 = py;
            this.main.getModel().add(new Barres (sauvN,new NoeudSimple(px2,py2)));
            this.main.getModel().add(new NoeudSimple(px2,py2));
            this.main.getModel().addB(new Barres (sauvN,new NoeudSimple(px2,py2)));
            this.main.getModel().addN(new NoeudSimple(px2,py2));
            this.main.redrawAll();
            
            this.main.redrawAll();
            this.changeEtat(345);
            
        }else if (this.etat == 347){
            //----------creer segment entre deux points partie 1
            Noeud pclic = new NoeudSimple(t.getX(),t.getY());
            //max value est peut etre trop grand ici
            Noeud proche = this.main.getModel().noeudPlusProche(pclic, Double.MAX_VALUE);  
            sauvN = proche;
            this.changeEtat(348);
            
        }else if (this.etat == 348){
            //----------creer segment entre deux points partie 2
            Noeud pclic = new NoeudSimple(t.getX(),t.getY());
            //max value est peut etre trop grand ici
            //il selectionne un autre noeud et ça creer la barre
            Noeud proche = this.main.getModel().noeudPlusProche(pclic, Double.MAX_VALUE);
            
            this.main.getModel().add(new Barres (sauvN,proche));
            this.main.getModel().addB(new Barres (sauvN,proche));
            
            this.main.redrawAll();
            this.changeEtat(347);
            
        }else if (this.etat == 400){

            this.pos1[0] = px;
            this.pos1[1] = py;
            this.changeEtat(401);
            
        }else if (this.etat == 401){

            this.pos2[0] = px;
            this.pos2[1] = py;
            //main.getTerrain().getXi().clear();
            this.changeEtat(402);
                    
        }else if (this.etat == 402){

            if (main.getTerrain().getXi().size() <= 10){
                this.pos3x.add(px);
                this.pos3y.add(py);
                this.main.redrawAll();
            }
            
            
        }else if (this.etat == 420){

            Groupe model = this.main.getModel();
            py = Lagrange(px, this.main.getTerrain().getXi(), this.main.getTerrain().getYi());
            System.out.println(px + ";" + py);
            model.add(new NoeudAppuiDouble(px,py));
            model.addN(new NoeudAppuiDouble(px,py));
            this.main.redrawAll(); 
            
            
        }else if (this.etat == 430){

            Groupe model = this.main.getModel();
            py = Lagrange(px, this.main.getTerrain().getXi(), this.main.getTerrain().getYi());
            System.out.println(px + ";" + py);
            model.add(new NoeudAppuiSimple(px,py));
            model.addN(new NoeudAppuiSimple(px,py));
            this.main.redrawAll(); 
            
            
        }else{
            System.out.println("clic"); 
        }
        
    }

    
    //----------bouton provenant d'acceuil:
    void boutonPlay(ActionEvent t){
        Groupe model = this.main.getModel();
        main.getModel().gestionForce2test();
        //this.changeEtat(100);
    }
    void boutonStop(ActionEvent t){
        //System.out.println(this.selection);
        //this.changeEtat(110);
        this.changeEtat(100);
    }
    void boutonRetour(ActionEvent t){
        this.changeEtat(120);
        
    }
    void boutonAvance(ActionEvent t){
        this.changeEtat(130);
    }
    
    //bouton sauv est renvoyé dans les menus
    
    void boutonSelect(ActionEvent t){
        this.changeEtat(150);
    }
    void boutonSelectPoint(ActionEvent t){
        this.changeEtat(151);
        this.changeEtatSecondaire(1);
    }
    void boutonSelectBarres(ActionEvent t){
        this.changeEtat(152);
        //this.changeEtatSecondaire(1);
    }
    void boutonDelete(ActionEvent t){
        if (((this.etat == 150)||(this.etat == 151)) && !this.selection.isEmpty()) {
            this.main.getModel().removeAll(this.selection);
            this.selection.clear();
            this.activeBoutonsSuivantSelection();
            this.main.redrawAll();
        }
    }
    void boutonHaut(ActionEvent t){
        this.main.setZoneVue(this.main.getZoneVue().translateBas(0.8));
        this.main.redrawAll();
    }
    void boutonBas(ActionEvent t){
        this.main.setZoneVue(this.main.getZoneVue().translateHaut(0.8));
        this.main.redrawAll();
    }
    void boutonDroite(ActionEvent t){
        this.main.setZoneVue(this.main.getZoneVue().translateGauche(0.8));
        this.main.redrawAll();
    }
    void boutonGauche(ActionEvent t){
        this.main.setZoneVue(this.main.getZoneVue().translateDroite(0.8));
        this.main.redrawAll();
    }
    void boutonCentre(ActionEvent t){
        this.main.fitAll();
        this.main.redrawAll();
    }
    
    //----------bouton provenant de ZC:
    
    void boutonAjouterZC(ActionEvent t){
        this.changeEtat(200);
    }
    void boutonModifierZC(ActionEvent t){
        this.changeEtat(210);
    }
    
    //----------bouton provenant de TrellisBarre:
    
    void boutonRetrecir(ActionEvent t){
        this.main.setZoneVue(this.main.getZoneVue().scale(2));
        this.main.redrawAll();
    }
    void boutonAgrandir(ActionEvent t){
        this.main.setZoneVue(this.main.getZoneVue().scale(0.5));
        this.main.redrawAll();
    }
    void boutonInformer(ActionEvent t){
        if(((this.etat == 150)||(this.etat == 151)) && this.selection.size() > 0){
            for(Trellis obj : this.selection){
                obj.afficheResume();
                System.out.println(obj.affListe());
            }
        }
    }
    void boutonCreerPivot(ActionEvent t){
        this.changeEtat(321);
    }
    void boutonInsererNoeud(ActionEvent t){
        this.changeEtat(322);
    }
    void boutonAngle(ActionEvent t){
        this.changeEtat(323);
        //324 : angle partie 2
        //325 : angle partie 3
    }
    void boutonAjouterForce(ActionEvent t){   
        this.changeEtat(330);
    }
    void boutonModifierForce(ActionEvent t){
        this.changeEtat(331);
    }
    void boutonAgrandirBarre(ActionEvent t){
        this.changeEtat(340);
    }
    void boutonMesurerBarre(ActionEvent t){
        this.changeEtat(341);
    }
    void boutonUniformiserBarreTaille(ActionEvent t){
        this.changeEtat(342);
    }
    void boutonAjouterBarres(ActionEvent t){
        this.changeEtat(343);
        //état 344: ajouter barre partie 2
    }
    void creerBarreSP(ActionEvent t){
        this.changeEtat(343);
        //état 344: ajouter barre partie 2
    }
    void creerBarreA1P(ActionEvent t){
        this.changeEtat(345);
        //this.changeEtatSecondaire(2);
        //état 346: ajouter barre partie 2
    }
    void creerBarreA2P(ActionEvent t){
        this.changeEtat(347);
        //this.changeEtatSecondaire(3);
        //état 348: ajouter barre partie 2
    }
    
    //----------bouton provenant de TerrainBarre:
    
    void boutonAjouterAppui(ActionEvent t){
        this.changeEtat(400);
    }
    void boutonValider(ActionEvent t){
        main.getTerrain().RAYON_IN_DRAW = 5;
        main.getTerrain().getXi().set(0, pos1[0]);
        main.getTerrain().getYi().set(0, pos1[1]);
        main.getTerrain().getXi().set(1, pos2[0]);
        main.getTerrain().getYi().set(1, pos2[1]);
        
        if(pos3x.size() != 0){
            for (int i = 0; i < pos3x.size(); i++){
                main.getTerrain().getXi().add(pos3x.get(i));
                main.getTerrain().getYi().add(pos3y.get(i));
            }
        }
        
        this.changeEtat(150);
        this.main.redrawAll();
    }
    void boutonModifierAppui(ActionEvent t){
        this.changeEtat(410);
    }
    void boutonDefAppui(ActionEvent t){
        this.changeEtat(420);
    }
    void boutonDefAppuiSimple(ActionEvent t){
        this.changeEtat(430);
    }
    
    private void activeBoutonsSuivantSelection(){
        //si on veut désactiver un bouton quand select est activée
    }

    //----------bouton provenant du menu:
    
    void boutonNewItem(ActionEvent t){
        Stage nouveau = new Stage();
        nouveau.setTitle("Nouveau");
        Scene sc = new Scene(new MainPanel(nouveau), 1000, 700);
        nouveau.setScene(sc);
        nouveau.show();
    }
    void boutonExitItem(ActionEvent t){
        System.exit(0);
    }
    void boutonOpenFilesItem(ActionEvent t){
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(this.main.getInStage());
        if (f != null) {
            try {
                //System.out.println("test1");
                GlobalObject[] lue = GlobalObject.lecture(f);
                //System.out.println("test2");
                Groupe glu = (Groupe) lue[0];
                //System.out.println("test3");
                Terrain terrain = (Terrain) lue[1];
                //System.out.println("test4");
                Stage nouveau = new Stage();
                //System.out.println("test5");
                nouveau.setTitle(f.getName());
                //System.out.println("test6");
                Scene sc = new Scene(new MainPanel(nouveau, f, glu, terrain), 1000, 700);
                //System.out.println("test7");
                nouveau.setScene(sc);
                nouveau.show();
            } catch (Exception ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Problème durant la sauvegarde");
                alert.setContentText(ex.getLocalizedMessage());
                System.out.println(ex.getLocalizedMessage());

                alert.showAndWait();
            } finally {
                this.changeEtat(350);
            }
        }
    }
    void boutonSaveItem(ActionEvent t){
        if (this.main.getCurFile() == null) {
            this.boutonSaveAsItem(t);
        } else {
            this.realSave(this.main.getCurFile());
        }
    }
    void boutonSaveAsItem(ActionEvent t){
        FileChooser chooser = new FileChooser();
        File f = chooser.showSaveDialog(this.main.getInStage());
        if (f != null) {
            this.realSave(f);
        }
    }
    private void realSave(File f) {
        try {
            this.main.getModel().sauvegarde(f,false);
            this.main.getTerrain().sauvegarde(f,true);
            this.main.setCurFile(f);
            this.main.getInStage().setTitle(f.getName());
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Problème durant la sauvegarde");
            alert.setContentText(ex.getLocalizedMessage());

            alert.showAndWait();
        } finally {
            this.changeEtat(20);
        }
    }
    void MiseAJour(ActionEvent t) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mise à jour indisponible");
                alert.setHeaderText(null);
                alert.setContentText("Application Tréllis\n"
                        + "Ce bouton sera disponible dans une prochaine mise à jour\n");

                alert.showAndWait();
    }
    
    
    /**
     * @return the selection
     */
    public List<Trellis> getSelection() {
        return selection;
    }
    
    //----------Autre:
    
    void changeColor(Color value){
        if(((this.etat == 150)||(this.etat == 151)) && this.selection.size() > 0){
            for(Trellis t : this.selection){
                t.changeCouleur(value);
                //t.afficheResume();
            }
            this.main.redrawAll();
        }
    }
    
    private void selectRealpoint (MouseEvent t){
        
        Noeud pclic = new NoeudSimple(t.getX(),t.getY());
            //max value est peut etre trop grand ici
            Noeud proche = this.main.getModel().noeudPlusProche(pclic, Double.MAX_VALUE);  
            //il y a un petite erreur dans le programme donc ce passage sert à le compenser:
            for (int i = 0; i < this.main.getModel().getContient().size(); i++ ){
                if ((proche.getPx() == this.main.getModel().getContient().get(i).maxX())&&(proche.getPx() == this.main.getModel().getContient().get(i).minX())){
                    this.trel1 = this.main.getModel().getContient().get(i);
                    //System.out.println(trel1 + "donc c'est bon");
                }
            }
    }
    private void selectRealBarres (MouseEvent t){
        
        Noeud pclic = new NoeudSimple(t.getX(),t.getY());
            //max value est peut etre trop grand ici
            Barres proche = this.main.getModel().barresPlusProche(pclic, Double.MAX_VALUE); 
            //il y a un petite erreur dans le programme donc ce passage sert à le compenser:
            for (int i = 0; i < this.main.getModel().getContient().size(); i++ ){
                if ((proche.maxX() == this.main.getModel().getContient().get(i).maxX())&&(proche.minX() == this.main.getModel().getContient().get(i).minX())){
                    this.trel1 = this.main.getModel().getContient().get(i);
                    //System.out.println(trel1 + "donc c'est bon");
                }
            }
    }
    
}
