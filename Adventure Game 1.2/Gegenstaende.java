public abstract class Gegenstaende
{
    //aW=Angriffswert;sW=Schutzwert;name=Name;aB=Anzahl Benutzungen;sae=Saettigungswert;
    private String name;
    private int aW;
    private boolean anziehbar;
    private boolean konsumierbar;
    private int preis;
    public String klasse;
    private int ID;
    private boolean istSchluessel;
    private String text;

    public Gegenstaende(String pKlasse,int pAW, String pName, boolean pAnziehbar, int pID, boolean pIstSchluessel, int pPreis, String pText)
    {
        name = pName;
        aW=pAW;
        anziehbar=pAnziehbar;
        klasse=pKlasse;
        ID=pID;
        istSchluessel=pIstSchluessel;
        preis=pPreis;
        text=pText;
    }

    public String getName(){
        return name;
    }

    public void setName(String neuName){
        name=neuName;
    }

    public int getAW(){
        return aW;
    }

    public void setAW(int neuAW){
        aW=neuAW;
    }

    public int getPreis(){
        return preis;
    }

    public void setPreis(int pPreis){
        preis=pPreis;
    }

    public int getID(){
        return ID;
    }

    public void setAnziehbar(boolean pAnziehbar){
        anziehbar=pAnziehbar;
    }

    public boolean getAnziehbar(){
        return anziehbar;
    }

    public boolean istSchluessel(){
        return istSchluessel;
    }

    public String getKlasse(){
        return klasse;
    }

    public void setKlasse(String pKlasse){
        klasse=pKlasse;
    }

    public String getText(){
        return text;
    }

    public void setText(String pText){
        text=pText;
    }
}