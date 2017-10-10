import java.util.Random;
public class Gegner extends LebendigeSpielObjekte
{
    int leben;
    int angriffsschaden;
    private int BAD;
    private int PB;
    private Random zufallszahl;
    String name;

    public Gegner(int pLeben,int pAngriffsschaden, String pName)
    {
        leben=pLeben;
        angriffsschaden=pAngriffsschaden;
        name=pName;
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

    public void setName(String neuName){
        name=neuName;
    }

    public String getName(){
        return name;
    }
}
