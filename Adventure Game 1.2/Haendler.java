public class Haendler extends LebendigeSpielObjekte
{
    public Gegenstaende Waren[] = new Gegenstaende[4];
    private String textBegruessung;
    private String name;
    
    public Haendler(String pTextBegruessung, String pName)
    {
        textBegruessung=pTextBegruessung;
        name=pName;
    }

    public String getTextBegruessung(){
        return textBegruessung;
    }
    
    public String getName(){
        return name;
    }
    
    public void setWaren(Gegenstaende pGegenstand, int p){
        Waren[p]=pGegenstand;
    }
    
}
