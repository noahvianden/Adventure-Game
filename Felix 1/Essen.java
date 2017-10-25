public abstract class Essen extends Gegenstaende
{
    private int sae;

    public Essen(String pKlasse,int pAW, String pName, int pSae, boolean pAnziehbar)
    {       
        super(pKlasse,pAW,pName,pAnziehbar);
        sae=pSae;
    }

    public int getSae(){
        return sae;
    }

    public void setSae(int neuSae){
        sae=neuSae;
    }
    
}
