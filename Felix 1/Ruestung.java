public abstract class Ruestung extends Gegenstaende
{
    private int sW;
    public Ruestung(String pKlasse,int pAW, String pName, int pSW, boolean pAnziehbar)
    {       
        super(pKlasse,pAW,pName,pAnziehbar);
        sW=pSW;
    }

    public int getSW(){
        return sW;
    }

    public void setSW(int neuSW){
        sW=neuSW;
    }
    
}
