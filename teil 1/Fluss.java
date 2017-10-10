
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
