public class Steinweg extends SpielObjekte
{
    public Steinweg(){
        super(true,true,"Steinweg");
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
}