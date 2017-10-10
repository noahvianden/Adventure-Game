public class Magier extends Held{
    private int M;
    private int Mr;

    public Magier(String pName,int pAD,int pHP,int pHPr,int pH,int pD,int pG,int pMvs,int pT,int pGe,int pxPos, int pyPos, int pM, int pMr){
        super(pName, pAD, pHP, pHPr, pH, pD, pG, pMvs, pT, pGe, pxPos, pyPos);
        M = pM;
        Mr = pMr;
    }

    public void setM(int pM){
        M = pM; 
    }

    public int getM(){
        return M;
    }

    public void setMr(int pMr){
        Mr = pMr; 
    }

    public int getMr(){
        return Mr;
    }
}

