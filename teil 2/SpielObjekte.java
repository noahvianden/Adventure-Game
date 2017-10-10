
public abstract class SpielObjekte
{
    public String name;
    public boolean helligkeit;
    Gegenstände[]inhalt;
    Gegner[]gegner;
    public boolean zugänglichkeit;
    public SpielObjekte(boolean pHelligkeit, boolean pZugänglichkeit,String pName){
        helligkeit=pHelligkeit;
        zugänglichkeit=pZugänglichkeit;
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

    public void setZugänglichkeit(boolean pZugänglich){
        zugänglichkeit = pZugänglich;
    }

    public boolean getZugänglichkeit(){
        return zugänglichkeit;
    }

    public void setInhalt(Gegenstände pGegenstand){
        inhalt[0]=pGegenstand;
    }

    public Gegenstände getInhalt (){
        return inhalt[0];
    }

    public void setGegner(Gegner pGegner){
        gegner[0]=pGegner;
    }

    public LebendigeSpielObjekte getGegner(){
        return gegner[0];
    }
}
