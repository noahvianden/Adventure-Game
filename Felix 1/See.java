
public class See extends SpielObjekte
  {
     public See(){
        super(true,false,"See");
        gegner = new Gegner[1];
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