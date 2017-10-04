

public class Krieger extends Held{
    private int W;
    private int Wa;
    
    public Krieger(String pName,int pAD,int pHP,int pHPr,int pH,int pD,int pG,int pMvs,int pT,int pGe,int pxPos, int pyPos, int pW, int pWa){
        super(pName, pAD, pHP, pHPr, pH, pD, pG, pMvs, pT, pGe, pxPos, pyPos);
        W = pW;
        Wa = pWa;
    }
    public void setW(int pW){
        W = pW; 
    }
    public int getW(){
        return W;
    }
    public void setWa(int pWa){
        Wa = pWa; 
    }
    public int getWa(){
        return Wa;
    }
}