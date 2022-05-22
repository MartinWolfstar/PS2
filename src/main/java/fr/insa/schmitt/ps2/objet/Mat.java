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
    private double[][] coeffsId;
    
    // Constructeurs avec arguments
    public Mat(int nl, int nc){
        this.nbrLigne = nl;
        this.nbrCol = nc;
        this.coeffs = new double[nl][nc];
        this.coeffsId = new double[nl][nc];
        this.matSetId();
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
    public void matSetId(){

        double[][] matnulle = new double[this.nbrLigne][this.nbrCol];
        for (int i = 0; i < this.nbrLigne; i++){
            for ( int j = 0; j < this.nbrCol; j++){
                if (i==j){
                    matnulle[i][j] = 1;
                }else{
                    matnulle[i][j] = 0;
                }
            }
        }
        
        this.coeffsId = matnulle;
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
        
        Mat mat3 = new Mat(l,c);
        mat3.coeffs = tab3;
        
        
        return mat3;
    }
    /*public Mat inv(){
        double[][] tab1 = this.coeffs;
        
        
        
        
        return this;
    }*/
    public int lignePlusGrandPivot(int e){
        int ligMax=e;
        //pow = puissance
        double epsilon_pivot=Math.pow(10, -4);
        for (int i=e+1; i<this.getNbrLigne(); i++){
            //abs = valeur absolue
            if(Math.abs(this.getCoeffs()[i][e])> Math.abs(this.getCoeffs()[ligMax][e] )){
                ligMax=i;
            }
        }
        if(Math.abs(this.getCoeffs()[ligMax][e])<=epsilon_pivot) {
            return -1;
        }
        else{
            return ligMax;
        }
    }
    public int permuteLigne(int i1, int i2){
    double temp;
    double temp2;
        int ind=0;
        for(int j=0; j<this.getNbrCol(); j++){
            if(this.getCoeffs()[i1][j]== this.getCoeffs()[i2][j]){
                ind=ind+1;
            }
        }
    if (ind!=this.nbrCol){
        for(int i=0; i<this.getNbrCol(); i++){
            temp=this.getCoeffs()[i1][i];
            temp2=this.getCoeffsId()[i1][i];
            this.setOneCoeff(i1,i,this.getCoeffs()[i2][i]);
            this.setOneCoeffId(i1,i,this.getCoeffsId()[i2][i]);
            this.setOneCoeff(i2,i,temp);
            this.setOneCoeffId(i2,i,temp2);
        }
        return -1;
    }
    else{
        return 1;
    }  
}
    public Mat transvection (int i1, int i2){
        //i2 <-  i2 - p*i1
        if(this.getCoeffs()[i1][i1]==0){
            throw new Error("erreur: division par 0");
        }
        //p = coef de la ligne n / coef de la ligne du pivot
        double p= this.getCoeffs()[i2][i1] / this.getCoeffs()[i1][i1];
        for (int j=0;j<this.getNbrCol();j++){
            if (j==i1){
                this.setOneCoeff(i2,j,0);
                //this.setOneCoeffId(i2,j,0);
                this.setOneCoeffId(i2,j,this.getCoeffsId()[i2][j]-p*this.getCoeffsId()[i1][j]);
            }
            else{
                this.setOneCoeff(i2,j,this.getCoeffs()[i2][j]-p*this.getCoeffs()[i1][j]);
                this.setOneCoeffId(i2,j,this.getCoeffsId()[i2][j]-p*this.getCoeffsId()[i1][j]);
            }
        }
        return this;
    }
    
    public void descenteGauss(){
        int lignepivot;
        for(int i=0; i<Math.min(this.getNbrLigne(),this.getNbrCol()); i++){
            lignepivot = this.lignePlusGrandPivot(i);
            if(lignepivot!=-1){
                this.permuteLigne(i, lignepivot);
                for (int i2=i+1; i2<this.getNbrLigne(); i2++){
                    this.transvection(i, i2);
               
                }
            }
            else{
                System.out.println("la matrice n'est pas inversible");
            }
        }
    }
    public Mat remonteeGauss(){
        for(int i=this.getNbrLigne()-1; i>0; i--){
            for(int j=i-1; j>-1; j--){
                this.transvection(i, j);
            }
        }
    return this;
    }
    public Mat unitaire(){
        for(int i=0;i<this.getNbrLigne(); i++){
            double coef = this.getCoeffs()[i][i];
            for(int j=0;j<this.getNbrCol(); j++){ 
                if (i == j){
                    this.setOneCoeff(i,j,1);
                }
                //System.out.println(coef);
                this.setOneCoeffId(i,j,this.getCoeffsId()[i][j]/coef);
            }
        }
        
    return this;
    }
    
    public Mat mult(Mat mat1, Mat mat2) {
        int m1ColLength = mat1.nbrCol; // m1 columns length
        int m2RowLength = mat2.nbrLigne;    // m2 rows length
        if(m1ColLength != m2RowLength) return null; // mat multiplication is not possible
        int mRRowLength = mat1.nbrLigne;    // m result rows length
        int mRColLength = mat2.nbrCol; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for(int i = 0; i < mRRowLength; i++) {         // rows from m1
            for(int j = 0; j < mRColLength; j++) {     // columns from m2
                for(int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += mat1.getCoeffs()[i][k] * mat2.getCoeffs()[k][j];
                }
            }
        }
        Mat mat3 = new Mat(mat1.nbrLigne,mat2.nbrCol);
        mat3.setCoeffs(mResult);
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
    public void setInverse(){
        this.coeffs = this.coeffsId;
    }
    public void setOneCoeffId(int i, int j, double val){
        this.coeffsId[i][j] = val;
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
    public String toStringId(){
        String str = "";
        for (int i = 0; i< this.nbrLigne ; i++){
            for (int j = 0; j < this.nbrCol ; j++){
                str = str + this.coeffsId[i][j] + "|";
            }
            str = str +"\n";
        }
        return str;
    }

    /**
     * @return the coeffsId
     */
    public double[][] getCoeffsId() {
        return coeffsId;
    }
    
}
