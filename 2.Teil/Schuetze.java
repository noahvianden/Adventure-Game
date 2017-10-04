

public class Schuetze extends Held{
    private int P;
    private int Pr;
    
    public Schuetze(String pName,int pAD,int pHP,int pHPr,int pH,int pD,int pG,int pMvs,int pT,int pGe,int pxPos, int pyPos, int pP, int pPr){
        super(pName, pAD, pHP, pHPr, pH, pD, pG, pMvs, pT, pGe, pxPos, pyPos);
        P = pP;
        Pr = pPr;
    }
    public void setP(int pP){
        P = pP; 
    }
    public int getP(){
        return P;
    }
    public void setPr(int pPr){
        Pr = pPr; 
    }
    public int getPr(){
        return Pr;
    }
}