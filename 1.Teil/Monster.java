import java.util.Random;
public class Monster extends Gegenstände
{
    int leben;
    int angriffsschaden;
    private int BAD;
    private int PB;
    private Random zufallszahl;
    
    public Monster(boolean pMonster,int pLeben,int pAngriffsschaden, String pName)
    {
        super(true,1,2,1,pName);
        leben=pLeben;
        angriffsschaden=pAngriffsschaden;
    }
    
    public int Bonusschaden(){
    int pBAD = BAD;
   
    zufallszahl = new Random();
    pBAD = zufallszahl.nextInt(2);
    
    
    return pBAD;
    }
    
    public int Parrierbonus(){
    int pPB = PB;
   
    zufallszahl = new Random();
    pPB = zufallszahl.nextInt(2);
    
    
    return pPB;
    }

     public int getLeben(){
        return leben;
    }

    public void setLeben(int neuLeben){
        leben=neuLeben;
    }
    
     public int getAS(){
        return angriffsschaden;
    }

    public void setAS(int neuAW){
        angriffsschaden=neuAW;
    }
}
