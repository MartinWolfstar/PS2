/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.schmitt.ps2;

/**
 *
 * @author schmi
 */
public class Matrice {
    // Attributs
    int nbrLign;
    int nbrCol;
    double[][] coeffs;
    
    // Constructeurs avec arguments
    Matrice(int nl, int nc)
    {
        this.nbrLign = nl;
        this.nbrCol = nc;
        this.coeffs = new double[nl][nc];
    }
        
    Matrice()
        {
            
        }
    
    public static Matrice identite (int n)
        {
            int i;
            Matrice id = new Matrice(n,n);
            
            for (i=0 ; i<n; i++)
            {
                id.coeffs[i][i] = 1;
            }
            
            return id;
        }
        
    public void toAfficheSci()
        {
            int i,j;
            
            for (i=0 ; i<nbrLign ; i++)
            {
                System.out.print('[');
                for (j=0 ; j<nbrCol ; j++)
                {
                    System.out.print(String.format("%4.2E", coeffs[i][j]));
                    if (j != (nbrCol-1))
                    {
                        System.out.print(',');
                    }
                }
                System.out.println(']');
            }
            System.out.println();
        }
        
    public void toAffiche()
        {
            int i,j;
            
            for (i=0 ; i<nbrLign ; i++)
            {
                System.out.print("[ ");
                for (j=0 ; j<nbrCol ; j++)
                {
                    System.out.print(coeffs[i][j]);
                    if (j != (nbrCol-1))
                    {
                        System.out.print(" ");
                    }
                }
                System.out.println(" ]");
            }
            System.out.println();
        }
        
    public void toAfficheInt()
        {
            int i,j,temp;
            
            for (i=0 ; i<nbrLign ; i++)
            {
                System.out.print("[ ");
                for (j=0 ; j<nbrCol ; j++)
                {
                    temp = (int)coeffs[i][j]; // not an error
                    System.out.print(temp);
                    System.out.print(' ');
                }
                System.out.println(']');
            }
            System.out.println();
        }
        
         //Creer mat entier -> convertir double en entiers ou creer mat d'entiers de base
        
    public static int aleaUnOuDeux()
        {
             int i;
             if (Math.random() < 0.5)
             { i = 1; }
             else { i = 2; }
             return i;
        }
        
     public static Matrice matCreaManuel(){
         int i, j, nl, nc;
         char ouiNon;
         double temp;
         System.out.println("Vous allez creer une matrice. Donnez son nombre de lignes :");
         nl = Lire.i();
         System.out.println("Donnez son nombre de colonnes :");
         nc = Lire.i();
         Matrice matC = new Matrice(nl,nc);
         for (i=0; i<nl ; i++)
         {
             for (j=0; j<nc ; j++)
             {
                 System.out.print("Donnez la valeur du coeff ligne ");
                 System.out.println( (i+1) + " et colonne " + (j+1) + " de la matrice.");
                 matC.coeffs[i][j] = Lire.d();
             }
         }
         
        
        System.out.println("Voulez vous afficher la matrice ?");
        System.out.println("Y ou y pour oui, autre touche sinon.");
        ouiNon = Lire.c();
        if ((ouiNon == 'y') || (ouiNon == 'Y'))
        {
            matC.toAffiche();
        }
        return matC;
     }
    
    public static Matrice matAleaZeroUnDeux(int nl,int nc,double pz)
                // VERIFIER PZ
        {
            int i,j;
            Matrice matAlea = new Matrice (nl,nc);
            
            for (i=0 ; i<nl; i++)
            {
                for (j=0 ; j<nc; j++)
                {
                    if (Math.random() < pz)
                    {
                        matAlea.coeffs[i][j] = 0;
                    }
                    
                    else
                    {
                        matAlea.coeffs[i][j] = aleaUnOuDeux();
                    }
                }
            }
            return matAlea;
        }
        
    public static Matrice creeVecteur(double[] compVect)
        {
            int i;
            int nl = compVect.length;
            Matrice matV = new Matrice (nl,1);
             for (i=0 ; i<nl; i++)
             {
                 matV.coeffs[i][0] = compVect[i];
             }
             return matV;
        }
    
    public static Matrice concatLig(Matrice M, Matrice N)
    {
        int i, j;
        Matrice matCon = new Matrice();
        if (M.nbrCol != N.nbrCol)
        {
            throw new Error("Erreur concatLign : Matrices non compatibles");
            
        }
        else{
            matCon = new Matrice((M.nbrLign + N.nbrLign), N.nbrCol);
            for (i=0 ; i <M.nbrLign ; i++)
            {
                for (j=0 ; j <M.nbrCol ; j++)
                {
                    matCon.coeffs[i][j] = M.coeffs[i][j];
                }
            }
            for (i=0 ; i <N.nbrLign ; i++)
            {
                for (j=0 ; j <M.nbrCol ; j++)
                {
                    matCon.coeffs[M.nbrLign+i][j] = N.coeffs[i][j];
                }
            }
        }
        return matCon;
    }
    
    public static Matrice concatCol(Matrice M, Matrice N)
    {
        int i, j;
        Matrice matCon = new Matrice();
        if (M.nbrLign != N.nbrLign)
        {
            throw new Error("Erreur concatCol : Matrices non compatibles");
            
        }
        else{
            matCon = new Matrice(M.nbrLign,(N.nbrCol+M.nbrCol));
            for (i=0 ; i <M.nbrLign ; i++)
            {
                for (j=0 ; j <M.nbrCol ; j++)
                {
                    matCon.coeffs[i][j] = M.coeffs[i][j];
                }
            }
            for (i=0 ; i <M.nbrLign ; i++)
            {
                for (j=0 ; j <N.nbrCol ; j++)
                {
                    matCon.coeffs[i][M.nbrCol+j] = N.coeffs[i][j];
                }
            }
        }
        return matCon;
    }
    // MATRICE SUB LIGNES A TESTER MATRICE SUB LIGNES A TESTER MATRICE SUB LIGNES A TESTER 
    public static Matrice subLignes(Matrice M, int nMin, int nMax)
    {
        Matrice matSub = new Matrice ((nMax-nMin) , M.nbrCol);
        
        int i,j;
     
        for (i=0 ; i <(nMax-nMin) ; i++)
        {
            for (j=0 ; j <M.nbrCol ; j++)
            {
                matSub.coeffs[i][j] = M.coeffs[i+nMin][j];
            }
        }
        return matSub;
    }
    // MATRICE SUB LIGNES A TESTER MATRICE SUB LIGNES A TESTER MATRICE SUB LIGNES A TESTER 
    public static Matrice subCol(Matrice M, int nMin, int nMax)
    {
        Matrice matSub = new Matrice (M.nbrLign , (nMax-nMin));
        
        int i,j;
     
        for (i=0 ; i <M.nbrLign ; i++)
        {
            for (j=0 ; j <(nMax-nMin) ; j++)
            {
                matSub.coeffs[i][j] = M.coeffs[i][j+nMin];
            }
        }
    return matSub;
    }
    
    public static Matrice transposee(Matrice M)
    {
        Matrice matT = new Matrice (M.nbrCol, M.nbrLign);
        
        int i,j;
     
        for (i=0 ; i <M.nbrCol ; i++)
        {
            for (j=0 ; j <M.nbrLign ; j++)
            {
                matT.coeffs[i][j] = M.coeffs[j][i];
            }
        }
    return matT;
    }
    
    public static Matrice add(Matrice M, Matrice N)
    {
        Matrice matAdd = new Matrice (M.nbrLign, M.nbrCol);
        int i,j;
        if ((M.nbrLign != N.nbrLign) || (M.nbrCol != N.nbrCol))
        {
            throw new Error("Erreur (matrice)add : Matrices non compatibles");
            
        } 
        else 
        {
            for (i=0 ; i <M.nbrCol ; i++)
            {
                for (j=0 ; j <M.nbrLign ; j++)
                {
                    matAdd.coeffs[i][j] = (M.coeffs[i][j]+N.coeffs[i][j]);
                }
            }    
        }
    return matAdd;
    }
    public static Matrice opp(Matrice M)
    {
        Matrice matOpp = new Matrice (M.nbrLign, M.nbrCol);
        int i,j;
        for (i=0 ; i <M.nbrLign ; i++)
        {
            for (j=0 ; j <M.nbrCol ; j++)
            {
                matOpp.coeffs[i][j] = ((-1)*M.coeffs[i][j]);
            }
        }
    return matOpp;    
    }
    public static Matrice moins(Matrice M, Matrice N)
    {
        Matrice matMoins = new Matrice (M.nbrLign, M.nbrCol);
        int i,j;
        if ((M.nbrLign != N.nbrLign) || (M.nbrCol != N.nbrCol))
        {
            throw new Error("Erreur (matrice)moins : Matrices non compatibles");
            
        }
        for (i=0 ; i <M.nbrLign ; i++)
        {
            for (j=0 ; j <M.nbrCol ; j++)
            {
                matMoins.coeffs[i][j] = (M.coeffs[i][j]-N.coeffs[i][j]);
            }
        }
        return matMoins;
    }
    public static Matrice mult(Matrice M, Matrice N)
    {
        Matrice matMult = new Matrice (M.nbrLign, N.nbrCol);
        int i,j,k,l;
        double temp;
        if ((M.nbrCol != N.nbrLign))
        {
            throw new Error("Erreur (matrice)mult : Matrices non compatibles");
        }
        for (i=0 ; i <M.nbrLign ; i++)
        {
            for (j=0 ; j <N.nbrCol ; j++)
            {
                temp = 0;
                for (k=0 ; k<M.nbrCol ; k++){
                    temp = temp + (M.coeffs[i][k])*(N.coeffs[k][j]);
                }
                matMult.coeffs[i][j] = temp;
            }
        }
        return matMult;
    }
}
