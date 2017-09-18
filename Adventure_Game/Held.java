public class Held extends Charaktere{
    protected int H;
    protected int D;
    protected int G;
    protected int Mvs;
    protected int T;
    
    public Held(String pName,int pAD,int pHP,int pHPr,int pH,int pD,int pG,int pMvs,int pT,int pGe){
        super(pName, pAD, pHP, pHPr, pGe);
        H= pH;
        D= pD;
        G= pG;
        Mvs= pMvs;
        T= pT;
        Ge= pGe;
    }
}
