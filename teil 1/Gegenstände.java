public abstract class Gegenstände
{
    //aW=Angriffswert;sW=Schutzwert;ge=gewicht;gr=Größe;name=Name;aB=Anzahl Benutzungen;entz=Entzündbarkeit;sä=Sättigungswert;iA=ist an;
    private int ge;
    private int gr;
    private String name;
    private int aW;
    
    public Gegenstände(int pAW,int pGe, int pGr, String pName)
    {
       
       ge = pGe;
       gr = pGr;
       name = pName;
       aW=pAW;
    }
    
    public int getGe(){
        return ge;
    }
    
    public void setGe(int neuGe){
        ge=neuGe;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String neuName){
        name=neuName;
    }
    
    public int getGr(){
        return gr;
    }
    
    public void setGr(int neuGr){
        gr=neuGr;
    }
    
    public int getAW(){
        return aW;
    }

    public void setAW(int neuAW){
        aW=neuAW;
    }
    
    
}
