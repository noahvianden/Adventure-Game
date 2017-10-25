
public abstract class SpielObjekte
{
    public String name;
    public boolean helligkeit;
    Gegenstaende[]inhalt;
    Gegner[]gegner;
    public boolean zugaenglichkeit;
    public SpielObjekte(boolean pHelligkeit, boolean pZugaenglichkeit,String pName){
        helligkeit=pHelligkeit;
        zugaenglichkeit=pZugaenglichkeit;
        name=pName;
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
}
