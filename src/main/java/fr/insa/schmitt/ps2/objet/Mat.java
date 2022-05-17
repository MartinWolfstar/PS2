/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2.objet;

/**
 *
 * @author schmi
 */
public class Mat {
    
    private int nbrLigne;
    private int nbrCol;
    private double[][] coeffs;
    
    // Constructeurs avec arguments
    public Mat(int nl, int nc){
        this.nbrLigne = nl;
        this.nbrCol = nc;
        this.coeffs = new double[nl][nc];
    }

    public Mat remplir0(){

        double[][] matnulle = new double[this.nbrLigne][this.nbrCol];
        for (int i = 0; i < this.nbrLigne; i++){
            for ( int j = 0; j < this.nbrCol; j++){
                matnulle[i][j] = 0;
            }
        }
        
        this.coeffs = matnulle;
        
        return this;
    }
    
    public Mat concat(Mat mat1, Mat mat2){
        
        int l = mat1.nbrLigne;
        int c = mat1.nbrCol + mat2.nbrCol;
        
        double[][] tab1 = mat1.coeffs;
        double[][] tab2 = mat2.coeffs;
        double[][] tab3 = new double[l][c];
        
        for (int i = 0; i < l; i++){
            for (int j = 0; j < mat1.nbrCol; j++){
                tab3[i][j] = tab1[i][j];
            }
        }
        for (int i = 0; i < l; i++){
            for (int j = 0; j < mat2.nbrCol; j++){
                tab3[i][mat1.nbrCol + j] = tab2[i][j];
            }
        }
        /*String str = "";
        for (int i = 0; i< l ; i++){
            for (int j = 0; j < c ; j++){
                str = str + tab3[i][j] + "|";
            }
            str = str +"\n";
        }
        System.out.println(str);*/
        
        Mat mat3 = new Mat(l,c);
        mat3.coeffs = tab3;
        
        
        return mat3;
    }
    
    
    
    /**
     * @return the nbrLigne
     */
    public int getNbrLigne() {
        return nbrLigne;
    }

    /**
     * @param nbrLigne the nbrLigne to set
     */
    public void setNbrLigne(int nbrLigne) {
        this.nbrLigne = nbrLigne;
    }

    /**
     * @return the nbrCol
     */
    public int getNbrCol() {
        return nbrCol;
    }

    /**
     * @param nbrCol the nbrCol to set
     */
    public void setNbrCol(int nbrCol) {
        this.nbrCol = nbrCol;
    }

    /**
     * @return the coeffs
     */
    public double[][] getCoeffs() {
        return coeffs;
    }

    /**
     * @param coeffs the coeffs to set
     */
    public void setCoeffs(double[][] coeffs) {
        this.coeffs = coeffs;
    }
    
    public void setOneCoeff(int i, int j, double val){
        this.coeffs[i][j] = val;
    }

    @Override
    public String toString(){
        String str = "";
        for (int i = 0; i< this.nbrLigne ; i++){
            for (int j = 0; j < this.nbrCol ; j++){
                str = str + this.coeffs[i][j] + "|";
            }
            str = str +"\n";
        }
        return str;
    }
    
}
