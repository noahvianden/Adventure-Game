public class Tuer extends SpielObjekte
{
    private String beschreibungWennZu;
    private String beschreibungAufschließen; 
    private int richtungOeffnen; //1=Norden,2=Osten,3=Süden,4=Westen
    private boolean istOffen;

    public Tuer(boolean pIstOffen, String pBeschreibungWennZu, String pBeschreibungAufschließen, int pRichtungOeffnen)
    {
        super(true,true,"Tür");
        gegner = new Gegner[1];
        inhalt = new Gegenstaende[1];
        beschreibungWennZu=pBeschreibungWennZu;
        beschreibungAufschließen=pBeschreibungAufschließen;
        richtungOeffnen=pRichtungOeffnen;
        istOffen = pIstOffen;
    }

    public String getName(){
        return name;
    }

    public void setName(String neuName){
        name=neuName;
    }

    public void setHelligkeit(boolean pHell){
        helligkeit = pHell;
    }

    public boolean getHelligkeit(){
        return helligkeit;
    }

    public void setZugaenglichkeit(boolean pZugaenglich){
        zugaenglichkeit = pZugaenglich;
    }

    public boolean getZugaenglichkeit(){
        return zugaenglichkeit;
    }

    public void setInhalt(Gegenstaende pGegenstand){
        inhalt[0]=pGegenstand;
    }

    public Gegenstaende getInhalt (){
        return inhalt[0];
    }

    public void setGegner(Gegner pGegner){
        gegner[0]=pGegner;
    }

    public LebendigeSpielObjekte getGegner(){
        return gegner[0];
    }

    public String getTextWennZu(){
        return beschreibungWennZu;
    }

    public String getTextAufschließen(){
        return beschreibungAufschließen;
    }
    
    public int getRichtungOeffnen(){
        return richtungOeffnen;
    }
    
    public boolean istOffen(){
        return istOffen;
    }
    
    public void aufmachen(){
        istOffen=true;
    }
}
