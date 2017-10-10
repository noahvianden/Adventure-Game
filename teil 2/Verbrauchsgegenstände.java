public abstract class Verbrauchsgegenstände extends Gegenstände
{
    private int aB;
    private boolean entz;
    
     public Verbrauchsgegenstände(boolean pMonster,int pAW,int pGe, int pGr, String pName, int pAB, boolean pEntz)
    {       
       super(pAW,pGe,pGr,pName);
       aB=pAB;
       entz=pEntz;
    }
    
    public int getAB(){
        return aB;
    }
    
    public void setAnzahlBenutzungn(int neuAB){
        aB=neuAB;
    }
    
    public boolean istEntzündbar(){
        return entz;
    }
    
    public void setEntzündbarkeit(boolean neuEntz){
        entz = neuEntz;
    }
}
