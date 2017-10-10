public abstract class Essen extends Gegenstände
{
    private int sä;
    
     public Essen(boolean pMonster,int pAW,int pGe, int pGr, String pName, int pSä)
    {       
       super(pAW,pGe,pGr,pName);
       sä=pSä;
    }

    public int getSä(){
        return sä;
    }
    
    public void setSä(int neuSä){
        sä=neuSä;
    }
}
