public class Fackel extends Verbrauchsgegenstaende
{
    boolean iA;
     public Fackel(String pKlasse,int pAW,int pGe, int pGr, String pName, int pAB, boolean pEntz, boolean pIA, boolean pAnziehbar)
    {       
       super(pKlasse,pAW,pName,pAB,pEntz,pAnziehbar);
       iA=pIA;
    }
}
