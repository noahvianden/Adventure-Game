
public class Fluss extends SpielObjekte
{
    public Fluss(){
        super(true,false,"Fluss");
        gegner = new Gegner[1];
    }
       
    public void setHelligkeit(boolean pHell){
        helligkeit = pHell;
    }
    
     public String getName(){
        return name;
    }
    
    public void setName(String neuName){
        name=neuName;
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
