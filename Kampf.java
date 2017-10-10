import java.util.Random;

public class Kampf
{
    private static boolean kannFliehen;
    private static Random zufallszahl;
    private static  int wahrscheinlichkeitZuFliehen=3; //jeh größer die Zahl, desto unwarscheinlicher ist die Flucht

    public Kampf(){
    }

    public static void Kampf()
    {
        int xPos=Spiel.neuerHeld.getxPos();
        int yPos=Spiel.neuerHeld.getyPos();
        System.out.println("Du wirst plötzlich von einer/einem "+Spiel.neueWelt.welt[xPos][yPos].gegner[0].getName()+" angegriffen! Was willst du als erstes tun?");
        System.out.println();
    }

    public static void fliehen()
    {
        int xPos=Spiel.neuerHeld.getxPos();
        int yPos=Spiel.neuerHeld.getyPos();
        zufallszahl = new Random();
        int x= zufallszahl.nextInt(wahrscheinlichkeitZuFliehen);
        int schaden=2;

        if(x==1){
            kannFliehen=true;
        }else{
            kannFliehen=false;
        }

        if(kannFliehen==true){
            if(yPos-1>=0){
                if(Spiel.neueWelt.welt[xPos][yPos-1].getZugänglichkeit()==true){
                    Spiel.neuerHeld.setyPos(yPos-1);
                    System.out.println("Du bist in Richtung Norden entkommen und befindest dich nun auf "+Spiel.neueWelt.welt[xPos][yPos-1].getName()+".");
                    System.out.println();
                }else{
                    if(xPos+1<=49){
                        if(Spiel.neueWelt.welt[xPos+1][yPos].getZugänglichkeit()==true){
                            Spiel.neuerHeld.setxPos(xPos+1);
                            System.out.println("Du bist in Richtung Osten entkommen und befindest dich nun auf "+Spiel.neueWelt.welt[xPos+1][yPos].getName()+".");
                            System.out.println();
                        }else{
                            if(xPos+1<=32){
                                if(Spiel.neueWelt.welt[xPos][yPos+1].getZugänglichkeit()==true){
                                    Spiel.neuerHeld.setyPos(yPos+1);
                                    System.out.println("Du bist in Richtung Süden entkommen und befindest dich nun auf "+Spiel.neueWelt.welt[xPos][yPos+1].getName()+".");
                                    System.out.println();
                                }else{
                                    if(xPos-1>=0){
                                        if(Spiel.neueWelt.welt[xPos-1][yPos].getZugänglichkeit()==true){
                                            Spiel.neuerHeld.setxPos(xPos-1);
                                            System.out.println("Du bist in Richtung Westen entkommen und befindest dich nun auf "+Spiel.neueWelt.welt[xPos-1][yPos].getName()+".");
                                            System.out.println();
                                        }
                                    } 
                                }
                            } else{
                                if(xPos-1>=0){
                                    if(Spiel.neueWelt.welt[xPos-1][yPos].getZugänglichkeit()==true){
                                        Spiel.neuerHeld.setxPos(xPos-1);
                                        System.out.println("Du bist in Richtung Westen entkommen und befindest dich nun auf "+Spiel.neueWelt.welt[xPos-1][yPos].getName()+".");
                                        System.out.println();
                                    }
                                } 
                            } 
                        }
                    } else{
                        if(xPos+1<=32){
                            if(Spiel.neueWelt.welt[xPos][yPos+1].getZugänglichkeit()==true){
                                Spiel.neuerHeld.setyPos(yPos+1);
                                System.out.println("Du bist in Richtung Süden entkommen und befindest dich nun auf "+Spiel.neueWelt.welt[xPos][yPos+1].getName()+".");
                                System.out.println();
                            }else{
                                if(xPos-1>=0){
                                    if(Spiel.neueWelt.welt[xPos-1][yPos].getZugänglichkeit()==true){
                                        Spiel.neuerHeld.setxPos(xPos-1);
                                        System.out.println("Du bist in Richtung Westen entkommen und befindest dich nun auf "+Spiel.neueWelt.welt[xPos-1][yPos].getName()+".");
                                        System.out.println();
                                    }
                                } 
                            }
                        }
                    } 
                }
            } else{
                if(xPos+1<=49){
                    if(Spiel.neueWelt.welt[xPos+1][yPos].getZugänglichkeit()==true){
                        Spiel.neuerHeld.setxPos(xPos+1);
                        System.out.println("Du bist in Richtung Osten entkommen und befindest dich nun auf "+Spiel.neueWelt.welt[xPos+1][yPos].getName()+".");
                        System.out.println();
                    }else{
                        if(xPos+1<=32){
                            if(Spiel.neueWelt.welt[xPos][yPos+1].getZugänglichkeit()==true){
                                Spiel.neuerHeld.setyPos(yPos+1);
                                System.out.println("Du bist in Richtung Süden entkommen und befindest dich nun auf "+Spiel.neueWelt.welt[xPos][yPos+1].getName()+".");
                                System.out.println();
                            }else{
                                if(xPos-1>=0){
                                    if(Spiel.neueWelt.welt[xPos-1][yPos].getZugänglichkeit()==true){
                                        Spiel.neuerHeld.setxPos(xPos-1);
                                        System.out.println("Du bist in Richtung Westen entkommen und befindest dich nun auf "+Spiel.neueWelt.welt[xPos-1][yPos].getName()+".");
                                        System.out.println();
                                    }
                                } 
                            }
                        } else{

                        } 
                    }
                } 
            }
            Spiel.setImKampf(false);
        } else{
            Spiel.neuerHeld.setHP(Spiel.neuerHeld.getHP()-schaden);
            System.out.println("Du hast es nicht geschafft zu fliehen. Beim Versuch hast du "+schaden+" Schaden erlitten und hast noch "+Spiel.neuerHeld.getHP()+" Leben.");
            System.out.println();

            if(Spiel.neuerHeld.getHP()<=0){
                System.out.println("Du wurdest von dem/der "+Spiel.neueWelt.welt[xPos][yPos].gegner[0].getName()+" getötet und hast verloren!");
                Pause(2000);
                System.exit(0 );
            }
        }
    }

    public static void angreifen()
    {
        int xPos=Spiel.neuerHeld.getxPos();
        int yPos=Spiel.neuerHeld.getyPos();
        int aWHeld;
        int aWGegner;

        if(Spiel.neuerHeld.Hand[0]!=null){
            if(Spiel.neuerHeld.getAD()+Spiel.neuerHeld.Bonusschaden()-Spiel.neueWelt.welt[xPos][yPos].gegner[0].Parrierbonus()+Spiel.neuerHeld.Hand[0].getAW()>=0){
                aWHeld=Spiel.neuerHeld.getAD()+Spiel.neuerHeld.Bonusschaden()-Spiel.neueWelt.welt[xPos][yPos].gegner[0].Parrierbonus()+Spiel.neuerHeld.Hand[0].getAW();
            }else{
                aWHeld=0;
            }
        }else{
            if(Spiel.neuerHeld.getAD()+Spiel.neuerHeld.Bonusschaden()-Spiel.neueWelt.welt[xPos][yPos].gegner[0].Parrierbonus()>=0){
                aWHeld=Spiel.neuerHeld.getAD()+Spiel.neuerHeld.Bonusschaden()-Spiel.neueWelt.welt[xPos][yPos].gegner[0].Parrierbonus();
            }else{
                aWHeld=0;
            }
        }

        if(Spiel.neueWelt.welt[xPos][yPos].gegner[0].getAS()-Spiel.neuerHeld.Parrierbonus()+Spiel.neueWelt.welt[xPos][yPos].gegner[0].Bonusschaden()>=0){
            aWGegner=Spiel.neueWelt.welt[xPos][yPos].gegner[0].getAS()-Spiel.neuerHeld.Parrierbonus()+Spiel.neueWelt.welt[xPos][yPos].gegner[0].Bonusschaden();
        }else{
            aWGegner=0;
        }
        Spiel.neueWelt.welt[xPos][yPos].gegner[0].setLeben(Spiel.neueWelt.welt[xPos][yPos].gegner[0].getLeben()-aWHeld);
        System.out.println("Du greifst den/die/das "+Spiel.neueWelt.welt[xPos][yPos].gegner[0].getName()+" an und machst "+aWHeld+" Schaden. Der/Die/Das "+Spiel.neueWelt.welt[xPos][yPos].gegner[0].getName()+" hat jetzt noch "+Spiel.neueWelt.welt[xPos][yPos].gegner[0].getLeben()+" Leben.");
        System.out.println();
        Pause(500);
        Spiel.neuerHeld.setHP(Spiel.neuerHeld.getHP()-aWGegner);
        System.out.println("Der/Die/Das "+Spiel.neueWelt.welt[xPos][yPos].gegner[0].getName()+" greift dich an und macht "+aWGegner+" Schaden. Du hast jetzt noch "+Spiel.neuerHeld.getHP()+" Leben.");
        System.out.println();

        if(Spiel.neueWelt.welt[xPos][yPos].gegner[0].getLeben()<=0){
            System.out.println("Du hast den/das "+Spiel.neueWelt.welt[xPos][yPos].gegner[0].getName()+" getötet. Durch diese Heldentat kannst du jetzt eine/n "+Spiel.neueWelt.welt[xPos][yPos].inhalt[0].getName()+" aufheben.");
            System.out.println();
            Spiel.neueWelt.welt[xPos][yPos].setGegner(null);
            Spiel.setImKampf(false);
        }

        if(Spiel.neuerHeld.getHP()<=0){
            System.out.println("Du wurdest von dem/der "+Spiel.neueWelt.welt[xPos][yPos].gegner[0].getName()+" getötet und hast verloren!");
            Pause(2000);
            System.exit(0 );
        }
    }

    public static void Pause(int M) {
        try {Thread.sleep(M);}
        catch(InterruptedException e) {return;}
    }
}

