public abstract class Rüstung extends Gegenstände
{
    private int sW;
     public Rüstung(boolean pMonster,int pAW,int pGe, int pGr, String pName, int pSW)
    {       
       super(pAW,pGe,pGr,pName);
       sW=pSW;
    }
    
    public int getSW(){
        return sW;
    }
    
    public void setSW(int neuSW){
        sW=neuSW;
    }
}
