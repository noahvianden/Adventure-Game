   public class Kampf
{
   
   
    public static void Kampf(Gegenstände pMonster)
    {
        
        int x= Spiel.neuerHeld.getxPos();
        int y= Spiel.neuerHeld.getyPos();
        Spiel.neueWelt.welt[x][y].inhalt[0] = pMonster;
        int lebenHeld=Spiel.neuerHeld.getHP();
        int lebenMonster=Welt.monster.getLeben();
        int schadenMonster=(Welt.monster.getAS()+Welt.monster.Bonusschaden())-Spiel.neuerHeld.Parrierbonus();
        int schadenHeld=(Spiel.neuerHeld.getAD()+Spiel.neuerHeld.Bonusschaden())-Welt.monster.Parrierbonus();
        if(Spiel.neuerHeld.Hand[0]!=null){
           schadenHeld=schadenHeld+Spiel.neuerHeld.Hand[0].getAW();
        }
        
        
        
        
            System.out.println("Dich greift ein "+Spiel.neueWelt.welt[x][y].inhalt[0].getName() +" an.");
            System.out.println();
            Pause(2000);
            lebenHeld=lebenHeld-schadenMonster;
            Spiel.neuerHeld.setHP(lebenHeld);
            System.out.println("Der "+Spiel.neueWelt.welt[x][y].inhalt[0].getName() +" hat "+schadenMonster+" Schaden gemacht und du hast noch "+lebenHeld+" Leben.");
            System.out.println();
            Pause(2000);
            lebenMonster=lebenMonster-schadenHeld;
            Welt.monster.setLeben(lebenMonster);
            System.out.println("Du hast "+schadenHeld+" Schaden gemacht und der "+Spiel.neueWelt.welt[x][y].inhalt[0].getName() +" hat noch "+lebenMonster +" Leben.");
            System.out.println();
        
        if(lebenMonster<=0){
            System.out.println("Du hast den "+Spiel.neueWelt.welt[x][y].inhalt[0].getName() +" besiegt!");
            Spiel.neueWelt.welt[Spiel.neuerHeld.getxPos()][Spiel.neuerHeld.getyPos()].setInhalt(null);
            Welt.monster.setLeben(10);
            lebenMonster = Welt.monster.getLeben();
            schadenMonster = Welt.monster.getAS();
        }if(lebenHeld<=0){
            System.out.println("Du bist gestorben!");
            Pause(1000);
            System.exit( 0 );
        }else{
            System.out.println("Möchstest du weiter kämpfen?");
            System.out.println();
        }
    }
     
    public static void Pause(int M) {
     try {Thread.sleep(M);}
     catch(InterruptedException e) {return;}
    }
    }

    

