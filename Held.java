import java.util.Random;
public abstract class Held{
    private String Name;
    private int AD;
    private int HP;
    private int HPr;
    private int H;
    private int D;
    private int G;
    private int Mvs;
    private int T;
    private int Ge;
    private int xPos;
    private int yPos;
    private Random zufallszahl;

    private int BAD; //Bonusschaden
    private int PB; //ParrierBonus
    public Gegenstände Rucksack[] = new Gegenstände[10];
    public static Gegenstände Hand[] = new Gegenstände[1];
    public static Rüstung Rüstung[] = new Rüstung[1];

    public Held(String pName,int pAD,int pHP,int pHPr,int pH,int pD,int pG,int pMvs,int pT,int pGe,int pxPos, int pyPos){
        Name = pName;
        AD = pAD;
        HP = pHP;
        HPr = pHPr;
        H = pH;
        D = pD;
        G = pG;
        Mvs = pMvs;
        T = pT;
        Ge = pGe;
        xPos = pxPos;
        yPos = pyPos;
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

    public Gegenstände getHand(){
        return Hand[0];
    }

    public void setHand(Gegenstände pGegenstand){
        Hand[0] = pGegenstand;
    }

    public Gegenstände getRucksack(int i){
        return Rucksack[i];
    }

    public void setRucksack(Gegenstände pGegenstand, int i){
        Rucksack[i] = pGegenstand;
    }
    
    public void setRüstung(Rüstung pRüstung){
        Rüstung[0] = pRüstung;
    }

    public Rüstung getRüstung(){
        return Rüstung[0];
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

    public void setHPr(int pHPr){
        HPr = pHPr; 
    }

    public int getHPr(){
        return HPr;
    }

    public void setH(int pH){
        H = pH; 
    }

    public int getH(){
        return H;
    }

    public void setD(int pD){
        D = pD; 
    }

    public int getD(){
        return D;
    }

    public void setG(int pG){
        G = pG; 
    }

    public int getG(){
        return G;
    }

    public void setMvs(int pMvs){
        Mvs = pMvs; 
    }

    public int getMvs(){
        return Mvs;
    }

    public void setT(int pT){
        T= pT; 
    }

    public int getT(){
        return T;
    }

    public void setGe(int pGe){
        Ge= pGe; 
    }

    public int getGe(){
        return Ge;
    }
    
    
}
