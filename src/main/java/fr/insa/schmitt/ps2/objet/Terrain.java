/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

import static fr.insa.schmitt.ps2.inter.OutilsFx.Lagrange;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;

/**
 *
 * @author schmi
 */
public class Terrain extends GlobalObject{
    
    private List<Double> xi;
    private List<Double> yi;
    public static double RAYON_IN_DRAW = 0.001;

    public Terrain (){
        
        this.xi = new ArrayList<>();
        this.yi = new ArrayList<>();
        
        this.xi.add(0.0);
        this.yi.add(0.0);
        
        this.xi.add(100.0);
        this.yi.add(0.0);
        
        
        /*this.xi.add(150.0);
        this.yi.add(100.0);
        
        this.xi.add(120.0);
        this.yi.add(220.0);*/
        
    }
    public Terrain (double rayon){
        
        this.xi = new ArrayList<>();
        this.yi = new ArrayList<>();
        this.RAYON_IN_DRAW = rayon;
        
        this.xi.add(0.0);
        this.yi.add(0.0);
        
        this.xi.add(100.0);
        this.yi.add(0.0);
        
        
        /*this.xi.add(150.0);
        this.yi.add(100.0);
        
        this.xi.add(120.0);
        this.yi.add(220.0);*/
        
    }
    
    public String toString() {
        
        String valx = "";
        String valy = "";
        for (int i = 0 ; i < this.xi.size(); i++){
            valx = valx + this.xi.get(i) + ";";
            valy = valy + this.yi.get(i) + ";";
        }
        return "xi:" + valx + "\n" + "yi:" + valy ;
    }
    
    public void dessine(GraphicsContext context) {
        double pas = -400;
        double y;
        if (!xi.isEmpty()){
            //System.out.println(xi.size());
            for (int i = 0; i < 400000; i++){
                //System.out.println(i);
                y = Lagrange(pas, xi, yi);
                context.setFill(GREEN);
                context.fillOval(pas-RAYON_IN_DRAW,y-RAYON_IN_DRAW, RAYON_IN_DRAW/2, RAYON_IN_DRAW/2);
                pas += 0.01;
            }
        }else{
            context.setFill(GREEN);
            context.fillOval(1000,1000, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
        }
        /*context.setFill(BLACK);
        context.fillOval(10,10, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);*/

    }
    
    
    /**
     * @return the xi
     */
    public List<Double> getXi() {
        return xi;
    }

    /**
     * @param xi the xi to set
     */
    public void setXi(List<Double> xi) {
        this.xi = xi;
    }

    /**
     * @return the yi
     */
    public List<Double> getYi() {
        return yi;
    }

    /**
     * @param yi the yi to set
     */
    public void setYi(List<Double> yi) {
        this.yi = yi;
    }
    
    @Override
    public void save(Writer w, Numeroteur<GlobalObject> num)throws IOException{
        if(! num.objExiste(this)){
            int id = num.add(this);
            
            w.append("Terrain;");
            for (int i = 0; i < xi.size(); i++){
                w.append(xi.get(i)+ ";");
                w.append(yi.get(i) + ";");
            }
            w.append("\n");
        }

        
    }
    
    public static Terrain ini(){
        Terrain ter = new Terrain();
        return ter;
    }
    
}
