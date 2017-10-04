import java.util.*;

public class Spiel
{
    private Magier magier;
    private Schuetze schütze;
    private Krieger krieger;
    private Parser parser;
    public static Welt neueWelt;
    public static Held neuerHeld;
    private Mauer mauer;
    private Baum baum;
    private Fluss fluss;
    private Stadtmauer stadtmauer;
    private Kampf kampf;

    public Spiel() 
    {
        WeltErstellen();
        parser = new Parser();
        neuerHeld = new Krieger("Held",2,10,1,1,1,1,1,1,1,46,27,1,1);

    }

    private void WeltErstellen()
    {
        neueWelt = new Welt();

    }

    public static void main(String[] args) {

        Spiel neuesSpiel = new Spiel();
        neuesSpiel.play();  

    }

    public void play() 
    {            
        sagWillkommen();

        boolean fertig = false;

        while (fertig==false) {
            Command command = parser.getCommand();
            fertig = processCommand(command);
            Kämpfen();

        }
        System.out.println("Danke fürs Spielen! Tschüss.");
        Pause(1000);
        System.exit(0 );
    }

    private  void sagWillkommen()
    {
        System.out.println();
        System.out.println("Willkommen in unserem Adventure Game!");
        System.out.println();
        System.out.println("Wähle eine Klasse, indem du entweder Magier, Schütze oder Krieger in das Textfeld einträgst.");
        System.out.println();
        System.out.println("Schreib 'hilfe' in das Textfeld, wenn du Hilfe brauchst.");
        System.out.println();

    }

    private boolean processCommand(Command command) 
    {
        boolean WillDasSpielVerlassen = false;

        if(command.isUnknown()) {
            System.out.println("Ich weiß nicht, was du meinst.");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("hilfe")) {
            sagHilfe(command);
        }
        else if (commandWord.equals("gehNord")) {
            gehNord(command);
        }
        else if (commandWord.equals("gehSued")) {
            gehSued(command);
        }
        else if (commandWord.equals("gehOst")) {
            gehOst(command);
        }
        else if (commandWord.equals("gehWest")) {
            gehWest(command);
        }
        else if (commandWord.equals("nimm")) {
            nimm(command);
        }
        else if (commandWord.equals("rucksack")) {
            rucksack(command);
        }
        else if (commandWord.equals("umsehen")) {
            umsehen(command);
        }
        else if (commandWord.equals("fallenlassen")) {
            fallenlassen(command);
        }
        else if (commandWord.equals("inHandTun")) {
            inHandTun(command);
        }
        else if (commandWord.equals("zeigHand")) {
            zeigHand(command);
        }
        else if (commandWord.equals("ausHandTun")) {
            ausHandTun(command);
        }
        else if (commandWord.equals("Magier")) {
            Magier(command);
        }
        else if (commandWord.equals("Schütze")) {
            Schütze(command);
        }
        else if (commandWord.equals("Krieger")) {
            Krieger(command);
        }
        else if (commandWord.equals("weiter")) {

        }
        else if (commandWord.equals("Position")) {
            Position(command);
        }
        else if (commandWord.equals("beenden")) {
            WillDasSpielVerlassen = quit(command);
        }

        return WillDasSpielVerlassen;
    }

    private void Kämpfen(){

        int x= neuerHeld.getxPos();
        int y= neuerHeld.getyPos();
        if(neueWelt.welt[x][y].inhalt[0]!=null){
            if(neueWelt.welt[x][y].inhalt[0].getMonster()==true){
                Kampf.Kampf(neueWelt.welt[x][y].getInhalt());

            }
        }

    }

    private void sagHilfe(Command command) 
    {
        System.out.println();
        System.out.println("Hier hast du eine Übersicht der Befehle:");
        System.out.println();
        System.out.println("gehNord, gehSued, gehWest, gehOst");
        System.out.println();
        System.out.println("beenden, hilfe, weiter, Position");
        System.out.println();
        System.out.println("rucksack, umsehen, zeigHand");
        System.out.println();
        System.out.println("nimm, ausHandTun 1-10, fallenlassen 1-10/Hand, inHandTun 1-10");
        System.out.println();
    }

    private void Magier(Command command){ 
        magier = new Magier("Magier",2,10,1,1,1,1,1,1,1,46,27,1,1);
        System.out.println("Du bist nun ein Magier.");
    }

    private void Schütze(Command command){ 
        schütze = new Schuetze("Schütze",2,10,1,1,1,1,1,1,1,46,27,1,1);
        System.out.println("Du bist nun ein Schütze.");
    }

    private void Krieger(Command command){
        krieger = new Krieger("Krieger",2,10,1,1,1,1,1,1,1,46,27,1,1);
        System.out.println("Du bist nun ein Krieger.");
    }

    private void Position(Command command){
        System.out.println("Du befindest dich auf "+ neueWelt.welt[neuerHeld.getxPos()][neuerHeld.getyPos()].getName()+" bei "+neuerHeld.getxPos()+"/"+neuerHeld.getyPos()+".");
        System.out.println();
    }

    private void gehNord(Command command) 
    {
        int x= neuerHeld.getxPos();
        int y= neuerHeld.getyPos()-1;
        if(y>=0){
            if((neueWelt.welt[x][y].getZugänglichkeit()== false)){  
                System.out.println("Hier kannst du nicht lang gehen! Hier befindet sich ein/e "+neueWelt.welt[x][y].getName()+".");
                System.out.println();
            }else {
                neuerHeld.setyPos(y);
                System.out.println("Du befindest dich nun auf "+neueWelt.welt[x][y].getName()+".");
                System.out.println();
            }
        }else{
            System.out.println("Hier kannst du nicht lang gehen! Hier ist das Ende der Welt");
        }
    }

    private void gehSued(Command command) 
    {
        int x= neuerHeld.getxPos();
        int y= neuerHeld.getyPos()+1;
        if(y<=32){
            if((neueWelt.welt[x][y].getZugänglichkeit()== false)){  
                System.out.println("Hier kannst du nicht lang gehen! Hier befindet sich ein/e "+neueWelt.welt[x][y].getName()+".");
                System.out.println();
            }else {
                neuerHeld.setyPos(y);
                System.out.println("Du befindest dich nun auf "+neueWelt.welt[x][y].getName()+".");
                System.out.println();
            }
        }
        else{
            System.out.println("Hier kannst du nicht lang gehen! Hier ist das Ende der Welt");
        }
    }			

    private void gehOst(Command command) 
    {
        int x= neuerHeld.getxPos()+1;
        int y= neuerHeld.getyPos();
        if(x<=49){
            if((neueWelt.welt[x][y].getZugänglichkeit()== false)){ 
                System.out.println("Hier kannst du nicht lang gehen! Hier befindet sich ein/e "+neueWelt.welt[x][y].getName()+".");
                System.out.println();
            }else {
                neuerHeld.setxPos(x);
                System.out.println("Du befindest dich nun auf "+neueWelt.welt[x][y].getName()+".");
                System.out.println();
            }
        }else{
            System.out.println("Hier kannst du nicht lang gehen! Hier ist das Ende der Welt");
        }
    }

    private void gehWest(Command command) 
    {
        int x= neuerHeld.getxPos()-1;
        int y= neuerHeld.getyPos();
        if(x>=0){
            if((neueWelt.welt[x][y].getZugänglichkeit()== false)){  
                System.out.println("Hier kannst du nicht lang gehen! Hier befindet sich ein/e "+neueWelt.welt[x][y].getName()+".");
                System.out.println();
            }else {
                neuerHeld.setxPos(x);
                System.out.println("Du befindest dich nun auf "+neueWelt.welt[x][y].getName()+".");
                System.out.println();
            }
        } else{
            System.out.println("Hier kannst du nicht lang gehen! Hier ist das Ende der Welt");
        }
    }

    private void nimm(Command command){
        int x= neuerHeld.getxPos();
        int y= neuerHeld.getyPos();
        if(neueWelt.welt[x][y].getInhalt()!=null&neueWelt.welt[x][y].getInhalt()!=neueWelt.welt[46][23].getInhalt()){
            if(neuerHeld.getRucksack(0)==null||neuerHeld.getRucksack(1)==null||neuerHeld.getRucksack(2)==null||neuerHeld.getRucksack(3)==null||neuerHeld.getRucksack(4)==null||neuerHeld.getRucksack(5)==null||neuerHeld.getRucksack(6)==null||neuerHeld.getRucksack(7)==null||neuerHeld.getRucksack(8)==null||neuerHeld.getRucksack(9)==null){
                for(int i=0;i<=9;i++){
                    if(neuerHeld.getRucksack(i)==null){
                        if(neueWelt.welt[x][y].getInhalt()!=null){
                            int b=i+1;
                            neuerHeld.setRucksack(neueWelt.welt[x][y].getInhalt(),i);
                            System.out.println("Ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+" befindet sich nun in Fach "+b+"/10 in deinem Rucksack.");
                            System.out.println();
                            neueWelt.welt[x][y].setInhalt(null);
                            i = 11;
                        }
                        else{
                            System.out.println("Hier liegt nicht, was du aufheben könntest.");
                            System.out.println();
                        }
                    }   
                }
            }else{
                System.out.println("Dein Rucksack ist voll.");
                System.out.println();
            }
        }
        else{
            System.out.println("Hier liegt nicht, was du aufheben könntest.");
            System.out.println();
        }

    }

    private void rucksack(Command command){
        for(int i=0;i<=9;i++){
            if(neuerHeld.getRucksack(i)!=null){
                int b=i+1;
                System.out.println("In Fach "+b+"/10 befindet sich ein/e "+neuerHeld.Rucksack[i].getName()+".");
                System.out.println();
            }else{
                int b=i+1;
                System.out.println("In Fach "+b+"/10 befindet sich nichts.");
                System.out.println();
            }
        }
    }

    private void umsehen(Command command){
        int x= neuerHeld.getxPos();
        int y= neuerHeld.getyPos();
        if(neueWelt.welt[x][y].getInhalt()!=null){
            System.out.println("Hier befindet sich ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+".");
            System.out.println();
        }else{
            System.out.println("Hier ist nichts.");
            System.out.println();
        }

    } 

    private void fallenlassen(Command command){
        int x= neuerHeld.getxPos();
        int y= neuerHeld.getyPos();
        if(!command.hasSecondWord()) {
            System.out.println("Aus welchem Fach aus deinem Rucksack soll etwas fallengelassen werden? Oder aus deiner Hand?");
            System.out.println();
            return;
        }

        String fach = command.getSecondWord();

        if(fach.equals("1")) {
            if(neuerHeld.getRucksack(0)!=null){
                neueWelt.welt[x][y].setInhalt(neuerHeld.getRucksack(0));
                System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+" fallengelassen.");
                System.out.println();
                neuerHeld.setRucksack(null,0);
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("2")) {
            if(neuerHeld.getRucksack(1)!=null){             
                neueWelt.welt[x][y].setInhalt(neuerHeld.getRucksack(1));
                System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+" fallengelassen.");
                System.out.println();
                neuerHeld.setRucksack(null,1);              
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("3")) {
            if(neuerHeld.getRucksack(2)!=null){            
                neueWelt.welt[x][y].setInhalt(neuerHeld.getRucksack(2));
                System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+" fallengelassen.");
                System.out.println();
                neuerHeld.setRucksack(null,2);            
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("4")) {
            if(neuerHeld.getRucksack(3)!=null){              
                neueWelt.welt[x][y].setInhalt(neuerHeld.getRucksack(3));
                System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+" fallengelassen.");
                System.out.println();
                neuerHeld.setRucksack(null,3);                
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("5")) {
            if(neuerHeld.getRucksack(4)!=null){              
                neueWelt.welt[x][y].setInhalt(neuerHeld.getRucksack(4));
                System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+" fallengelassen.");
                System.out.println();
                neuerHeld.setRucksack(null,4);              
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("6")) {
            if(neuerHeld.getRucksack(5)!=null){             
                neueWelt.welt[x][y].setInhalt(neuerHeld.getRucksack(5));
                System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+" fallengelassen.");
                System.out.println();
                neuerHeld.setRucksack(null,5);               
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("7")) {
            if(neuerHeld.getRucksack(6)!=null){             
                neueWelt.welt[x][y].setInhalt(neuerHeld.getRucksack(6));
                System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+" fallengelassen.");
                System.out.println();
                neuerHeld.setRucksack(null,6);               
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("8")) {
            if(neuerHeld.getRucksack(7)!=null){             
                neueWelt.welt[x][y].setInhalt(neuerHeld.getRucksack(7));
                System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+" fallengelassen.");
                System.out.println();
                neuerHeld.setRucksack(null,7);                  
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("9")) {
            if(neuerHeld.getRucksack(8)!=null){
                neueWelt.welt[x][y].setInhalt(neuerHeld.getRucksack(8));
                System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+" fallengelassen.");
                System.out.println();
                neuerHeld.setRucksack(null,8);
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("10")) {
            if(neuerHeld.getRucksack(9)!=null){
                neueWelt.welt[x][y].setInhalt(neuerHeld.getRucksack(9));
                System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+" fallengelassen.");
                System.out.println();
                neuerHeld.setRucksack(null,9);
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("Hand")) {
            if(neuerHeld.getHand()!=null){
                neueWelt.welt[x][y].setInhalt(neuerHeld.getHand());
                System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+" fallengelassen.");
                System.out.println();
                neuerHeld.setHand(null);
            }else{
                System.out.println("Du hältst nichts in der Hand.");
                System.out.println();
            }
        }
        System.out.println();
    }

    private void inHandTun(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Aus welchem Fach aus deinem Rucksack soll etwas in deine Hand gelegt werden?");
            System.out.println();
            return;
        }

        String fach = command.getSecondWord();

        if(fach.equals("1")) {
            if(neuerHeld.getRucksack(0)!=null){
                neuerHeld.setHand(neuerHeld.getRucksack(0));
                System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[0].getName()+".");
                System.out.println();
                neuerHeld.setRucksack(null,0);
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("2")) {
            if(neuerHeld.getRucksack(1)!=null){
                neuerHeld.setHand(neuerHeld.getRucksack(1));
                System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[1].getName()+".");
                System.out.println();
                neuerHeld.setRucksack(null,1);
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("3")) {
            if(neuerHeld.getRucksack(2)!=null){
                neuerHeld.setHand(neuerHeld.getRucksack(2));
                System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[2].getName()+".");
                System.out.println();
                neuerHeld.setRucksack(null,2);
            }else{
                System.out.println("Dieses Fach ist leer.");
            }
        }
        if(fach.equals("4")) {
            if(neuerHeld.getRucksack(3)!=null){
                neuerHeld.setHand(neuerHeld.getRucksack(3));
                System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[3].getName()+".");
                System.out.println();
                neuerHeld.setRucksack(null,3);
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("5")) {
            if(neuerHeld.getRucksack(4)!=null){
                neuerHeld.setHand(neuerHeld.getRucksack(4));
                System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[4].getName()+".");
                System.out.println();
                neuerHeld.setRucksack(null,4);
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("6")) {
            if(neuerHeld.getRucksack(5)!=null){
                neuerHeld.setHand(neuerHeld.getRucksack(5));
                System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[5].getName()+".");
                System.out.println();
                neuerHeld.setRucksack(null,5);
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("7")) {
            if(neuerHeld.getRucksack(6)!=null){
                neuerHeld.setHand(neuerHeld.getRucksack(6));
                System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[6].getName()+".");
                System.out.println();
                neuerHeld.setRucksack(null,6);
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("8")) {
            if(neuerHeld.getRucksack(7)!=null){
                neuerHeld.setHand(neuerHeld.getRucksack(7));
                System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[7].getName()+".");
                System.out.println();
                neuerHeld.setRucksack(null,7);
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("9")) {
            if(neuerHeld.getRucksack(8)!=null){
                neuerHeld.setHand(neuerHeld.getRucksack(8));
                System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[8].getName()+".");
                System.out.println();
                neuerHeld.setRucksack(null,8);
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        if(fach.equals("10")) {
            if(neuerHeld.getRucksack(9)!=null){
                neuerHeld.setHand(neuerHeld.getRucksack(9));
                System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[9].getName()+".");
                System.out.println();
                neuerHeld.setRucksack(null,9);
            }else{
                System.out.println("Dieses Fach ist leer.");
                System.out.println();
            }
        }
        System.out.println();
    }

    private void ausHandTun(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("In welches Fach in deinem Rucksack soll etwas aus deiner Hand gelegt werden?");
            System.out.println();
            return;
        }

        String fach = command.getSecondWord();

        if(fach.equals("1")) {
            if(neuerHeld.getHand()!=null){
                if(neuerHeld.getRucksack(0)==null){
                    neuerHeld.setRucksack(neuerHeld.getHand(),0);
                    System.out.println("In Fach 1/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+".");
                    System.out.println();
                    neuerHeld.setHand(null);
                }else{
                    System.out.println("In diesem Fach ist bereits etwas.");
                    System.out.println();
                }
            }else{
                System.out.println("In deiner Hand befindet sich nichts.");
                System.out.println();
            }
        }
        if(fach.equals("2")) {
            if(neuerHeld.getHand()!=null){
                if(neuerHeld.getRucksack(1)==null){
                    neuerHeld.setRucksack(neuerHeld.getHand(),1);
                    System.out.println("In Fach 2/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+".");
                    System.out.println();
                    neuerHeld.setHand(null);
                }else{
                    System.out.println("In diesem Fach ist bereits etwas.");
                    System.out.println();
                }
            }else{
                System.out.println("In deiner Hand befindet sich nichts.");
                System.out.println();
            }
        }
        if(fach.equals("3")) {
            if(neuerHeld.getHand()!=null){
                if(neuerHeld.getRucksack(2)==null){
                    neuerHeld.setRucksack(neuerHeld.getHand(),2);
                    System.out.println("In Fach 3/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+".");
                    System.out.println();
                    neuerHeld.setHand(null);
                }else{
                    System.out.println("In diesem Fach ist bereits etwas.");
                    System.out.println();
                }
            }else{
                System.out.println("In deiner Hand befindet sich nichts.");
                System.out.println();
            }
        }
        if(fach.equals("4")) {
            if(neuerHeld.getHand()!=null){
                if(neuerHeld.getRucksack(3)==null){
                    neuerHeld.setRucksack(neuerHeld.getHand(),3);
                    System.out.println("In Fach 4/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+".");
                    System.out.println();
                    neuerHeld.setHand(null);
                }else{
                    System.out.println("In diesem Fach ist bereits etwas.");
                    System.out.println();
                }
            }else{
                System.out.println("In deiner Hand befindet sich nichts.");
                System.out.println();
            }
        }
        if(fach.equals("5")) {
            if(neuerHeld.getHand()!=null){
                if(neuerHeld.getRucksack(4)==null){
                    neuerHeld.setRucksack(neuerHeld.getHand(),4);
                    System.out.println("In Fach 5/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+".");
                    System.out.println();
                    neuerHeld.setHand(null);
                }else{
                    System.out.println("In diesem Fach ist bereits etwas.");
                    System.out.println();
                }
            }else{
                System.out.println("In deiner Hand befindet sich nichts.");
                System.out.println();
            }
        }
        if(fach.equals("6")) {
            if(neuerHeld.getHand()!=null){
                if(neuerHeld.getRucksack(5)==null){
                    neuerHeld.setRucksack(neuerHeld.getHand(),5);
                    System.out.println("In Fach 6/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+".");
                    System.out.println();
                    neuerHeld.setHand(null);
                }else{
                    System.out.println("In diesem Fach ist bereits etwas.");
                    System.out.println();
                }
            }else{
                System.out.println("In deiner Hand befindet sich nichts.");
                System.out.println();
            }
        }
        if(fach.equals("7")) {
            if(neuerHeld.getHand()!=null){
                if(neuerHeld.getRucksack(6)==null){
                    neuerHeld.setRucksack(neuerHeld.getHand(),6);
                    System.out.println("In Fach 7/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+".");
                    System.out.println();
                    neuerHeld.setHand(null);
                }else{
                    System.out.println("In diesem Fach ist bereits etwas.");
                    System.out.println();
                }
            }else{
                System.out.println("In deiner Hand befindet sich nichts.");
                System.out.println();
            }
        }
        if(fach.equals("8")) {
            if(neuerHeld.getHand()!=null){
                if(neuerHeld.getRucksack(7)==null){
                    neuerHeld.setRucksack(neuerHeld.getHand(),7);
                    System.out.println("In Fach 8/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+".");
                    System.out.println();
                    neuerHeld.setHand(null);
                }else{
                    System.out.println("In diesem Fach ist bereits etwas.");
                    System.out.println();
                }
            }else{
                System.out.println("In deiner Hand befindet sich nichts.");
                System.out.println();
            }
        }
        if(fach.equals("9")) {
            if(neuerHeld.getHand()!=null){
                if(neuerHeld.getRucksack(8)==null){
                    neuerHeld.setRucksack(neuerHeld.getHand(),8);
                    System.out.println("In Fach 9/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+".");
                    System.out.println();
                    neuerHeld.setHand(null);
                }else{
                    System.out.println("In diesem Fach ist bereits etwas.");
                    System.out.println();
                }
            }else{
                System.out.println("In deiner Hand befindet sich nichts.");
            }
        }
        if(fach.equals("10")) {
            if(neuerHeld.getHand()!=null){
                if(neuerHeld.getRucksack(9)==null){
                    neuerHeld.setRucksack(neuerHeld.getHand(),9);
                    System.out.println("In Fach 10/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+".");
                    System.out.println();
                    neuerHeld.setHand(null);
                }else{
                    System.out.println("In diesem Fach ist bereits etwas.");
                    System.out.println();
                }
            }else{
                System.out.println("In deiner Hand befindet sich nichts.");
                System.out.println();
            }
        }
    }

    private void zeigHand(Command command){
        if(neuerHeld.getHand()!=null){
            System.out.println("In deiner Hand befindet sich ein/e "+neuerHeld.Hand[0].getName()+".");
            System.out.println();
        }else{
            System.out.println("In deiner Hand befindet sich nichts.");
            System.out.println();
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
     public static void Pause(int M) {
     try {Thread.sleep(M);}
     catch(InterruptedException e) {return;}
    }
}