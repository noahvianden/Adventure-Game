import java.util.Random;
public class Held{
    private String Name;
    private int AD;
    private int HP;
    private int xPos;
    private int yPos;
    private Random zufallszahl;
    private String klasse;
    private int ausdauer;
    private int geld=10;

    private int BAD; //Bonusschaden
    private int PB; //ParrierBonus
    public Gegenstaende Rucksack[] = new Gegenstaende[10];
    public static Gegenstaende Hand[] = new Gegenstaende[1];
    public static Ruestung Ruestung[] = new Ruestung[1];

    public Held(String pName,String pKlasse, int pAD,int pHP,int pxPos, int pyPos, int pAusdauer){
        Name = pName;
        klasse = pKlasse;
        AD = pAD;
        HP = pHP;
        xPos = pxPos;
        yPos = pyPos;
        ausdauer=pAusdauer;
    }

    public int Bonusschaden(){
        int pBAD = BAD;

        zufallszahl = new Random();
        pBAD = zufallszahl.nextInt(5);

        return pBAD;
    }

    public int Parrierbonus(){
        int pPB = PB;

        zufallszahl = new Random();
        pPB = zufallszahl.nextInt(2);

        return pPB;
    }

    public Gegenstaende getHand(){
        return Hand[0];
    }

    public void setName(String pName){
        Name=pName;
    }

    public String getName(){
        return Name;
    }

    public void setKlasse(String pKlasse){
        klasse=pKlasse;
    }

    public String getKlasse(){
        return klasse;
    }

    public void setHand(Gegenstaende pGegenstand){
        Hand[0] = pGegenstand;
    }

    public Gegenstaende getRucksack(int i){
        return Rucksack[i];
    }

    public void setRucksack(Gegenstaende pGegenstand, int i){
        Rucksack[i] = pGegenstand;
    }

    public void setRuestung(Ruestung pRuestung){
        Ruestung[0] = pRuestung;
    }

    public Ruestung getRuestung(){
        return Ruestung[0];
    }

    public void setxPos(int pxPos){
        xPos = pxPos;
    }

    public int getxPos(){
        return xPos;
    }

    public void setyPos(int pyPos){
        yPos = pyPos; 
    }

    public int getyPos(){
        return yPos;
    }

    public void setAD(int pAD){
        AD = pAD; 
    }

    public int getAD(){
        return AD;
    }

    public void setHP(int pHP){
        HP = pHP; 
    }

    public int getHP(){
        return HP;
    }

    public void setAusdauer(int pAusdauer){
        ausdauer = pAusdauer; 
    }

    public int getAusdauer(){
        return ausdauer;
    }

    public void setGeld(int pGeld){
        geld = pGeld;
    }

    public int getGeld(){
        return geld;
    }

}
