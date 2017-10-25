public abstract class Verbrauchsgegenstaende extends Gegenstaende
{
    private int aB;
    private boolean entz;
    public Verbrauchsgegenstaende(String pKlasse,int pAW, String pName, int pAB, boolean pEntz, boolean pAnziehbar)
    {       
        super(pKlasse,pAW,pName,pAnziehbar);
        aB=pAB;
        entz=pEntz;
    }

    public int getAB(){
        return aB;
    }

    public void setAnzahlBenutzungn(int neuAB){
        aB=neuAB;
    }

    public boolean istEntzuendbar(){
        return entz;
    }

    public void setEntzuendbarkeit(boolean neuEntz){
        entz = neuEntz;
    }

    public String getKlasse(){
        return klasse;
    }

    public void setKlasse(String pKlasse){
        klasse=pKlasse;
    }
}
