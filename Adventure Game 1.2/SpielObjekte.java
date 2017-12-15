public abstract class SpielObjekte
{
    public String name;
    public boolean helligkeit;
    Gegenstaende[]inhalt;
    Gegner[]gegner;
    Questgeber[]questgeber;
    Haendler[]haendler;
    public boolean zugaenglichkeit;
    public boolean istTuer;

    private String beschreibungWennZu;
    private String beschreibungAufschließen; 
    private int richtungOeffnen; //1=Norden,2=Osten,3=Süden,4=Westen
    private boolean istOffen;
    private int ID;

    public SpielObjekte(boolean pHelligkeit, boolean pZugaenglichkeit, String pName, boolean pIstTuer, boolean pIstOffen, String pBeschreibungWennZu, String pBeschreibungAufschließen, int pRichtungOeffnen,int pID){
        helligkeit=pHelligkeit;
        zugaenglichkeit=pZugaenglichkeit;
        name=pName;
        istTuer=pIstTuer;
        beschreibungWennZu=pBeschreibungWennZu;
        beschreibungAufschließen=pBeschreibungAufschließen;
        richtungOeffnen=pRichtungOeffnen;
        istOffen = pIstOffen;
        ID=pID;
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

    public boolean getIstTuer(){
        return istTuer;
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

    public  boolean istOffen(){
        return istOffen;
    }

    public void aufmachen(){
        istOffen=true;
    }

    public int getID(){
        return ID;
    }
    
    public void setHaendler(Haendler pHaendler){
        haendler[0]=pHaendler;
    }

    public Haendler getHaendler(){
        return haendler[0];
    }
    
    public void setQuestgeber(Questgeber pQuestgeber){
        questgeber[0]=pQuestgeber;
    }

    public Questgeber getQuestgeber(){
        return questgeber[0];
    }
}
