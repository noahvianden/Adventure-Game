public abstract class Gegenstaende
{
    //aW=Angriffswert;sW=Schutzwert;name=Name;aB=Anzahl Benutzungen;entz=Entzündbarkeit;sae=Saettigungswert;iA=ist an;
    private String name;
    private int aW;
    private boolean anziehbar;
    private int Preis;
    public String klasse;
  

    public Gegenstaende(String pKlasse,int pAW, String pName, boolean pAnziehbar)
    {
        name = pName;
        aW=pAW;
        anziehbar=pAnziehbar;
        klasse=pKlasse;
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
        return Preis;
    }

    public void setPreis(int pPreis){
        Preis=pPreis;
    }

    public void setAnziehbar(boolean pAnziehbar){
        anziehbar=pAnziehbar;
    }

    public boolean getAnziehbar(){
        return anziehbar;
    }
    
    public String getKlasse(){
        return klasse;
    }

    public void setKlasse(String pKlasse){
        klasse=pKlasse;
    }
}