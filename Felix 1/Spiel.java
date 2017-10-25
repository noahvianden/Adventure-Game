import java.util.*;

public class Spiel
{
    private Parser parser;
    public static Welt neueWelt;
    public static Held neuerHeld;
    private Mauer mauer;
    private Baum baum;
    private Fluss fluss;
    private Stadtmauer stadtmauer;
    private Kampf kampf;
    private boolean istErstellt=false;
    private static boolean imKampf=false;

    public Spiel() 
    {
        WeltErstellen();
        parser = new Parser();
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
        System.out.println("Wähle als erstes eine Klasse, indem du entweder Magier, Schütze oder Krieger in das Textfeld einträst.");
        System.out.println();
        System.out.println("Schreib 'hilfe' in das Textfeld, wenn du Hilfe brauchst.");
        System.out.println();

    }

    private boolean processCommand(Command command) 
    {
        boolean WillDasSpielVerlassen = false;

        if(command.isUnknown()) {
            System.out.println("Ich weiß nicht, was du meinst.");
            System.out.println();
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
        else if (commandWord.equals("anziehen")) {
            anziehen(command);
        }
        else if (commandWord.equals("ausziehen")) {
            ausziehen(command);
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
            Schuetze(command);
        }
        else if (commandWord.equals("Krieger")) {
            Krieger(command);
        }
        else if (commandWord.equals("Karte")) {
            Karte(command);
        }
        else if (commandWord.equals("angreifen")) {
            angreifen(command);
        }
        else if (commandWord.equals("fliehen")) {
            fliehen(command);
        }
        else if (commandWord.equals("status")) {
            status(command);
        }
        else if (commandWord.equals("kombo")) {
            Magier(command);
            gehNord(command);
            nimm(command);
        }
        else if (commandWord.equals("beenden")) {
            WillDasSpielVerlassen = quit(command);
        }

        return WillDasSpielVerlassen;
    }

    private void sagHilfe(Command command) 
    {
        System.out.println();
        System.out.println("Hier hast du eine Übersicht der Befehle:");
        System.out.println();
        System.out.println("gehNord, gehSued, gehWest, gehOst");
        System.out.println();
        System.out.println("beenden, hilfe, weiter, status");
        System.out.println();
        System.out.println("rucksack, umsehen, zeigHand");
        System.out.println();
        System.out.println("nimm, ausHandTun 1-10, fallenlassen 1-10/Hand/Rüstung, inHandTun 1-10, anziehen 1-10, ausziehen 1-10");
        System.out.println();
        System.out.println("angreifen, fliehen");
        System.out.println();
    }

    private void Magier(Command command){ 
        if(istErstellt==false){
            neuerHeld = new Held("Magier","Magier",2,10,46,27,10);
            System.out.println("Du bist nun ein Magier.");
            System.out.println();
            istErstellt=true;
        }else{
            System.out.println("Du hast bereits eine Klasse gewählt.");
            System.out.println();
        }
    }

    private void Schuetze(Command command){ 
        if(istErstellt==false){
            neuerHeld = new Held("Schuetze","Schuetze",2,10,46,27,10);
            System.out.println("Du bist nun ein Schütze.");
            System.out.println();
            istErstellt=true;
        }else{
            System.out.println("Du hast bereits eine Klasse gewählt.");
            System.out.println();
        }
    }

    private void Krieger(Command command){
        if(istErstellt==false){
            neuerHeld = new Held("Krieger","Krieger",2,10,46,27,10);
            System.out.println("Du bist nun ein Krieger.");
            System.out.println();
            istErstellt=true;
        }else{
            System.out.println("Du hast bereits eine Klasse gewählt.");
            System.out.println();
        }
    }

    private void Karte(Command command){
        if(istErstellt==true){
            for(int j=0;j<33;j++){
                for(int i=0;i<50;i++){
                    if(neueWelt.welt[i][j].getName()=="Gras"){
                        System.out.print("G ");
                    }else{
                        if(neueWelt.welt[i][j].getName()=="Baum"){
                            System.out.print("B ");
                        }else{
                            if(neueWelt.welt[i][j].getName()=="Fluss"){
                                System.out.print("F ");
                            }else{
                                if(neueWelt.welt[i][j].getName()=="See"){
                                    System.out.print("S ");
                                }else{
                                    if(neueWelt.welt[i][j].getName()=="Mauer"){
                                        System.out.print("M ");
                                    }else{
                                        if(neueWelt.welt[i][j].getName()=="Hausboden"){
                                            System.out.print("  ");
                                        }else{
                                            if(neueWelt.welt[i][j].getName()=="Steinweg"){
                                                System.out.print("W ");
                                            }else{
                                                if(neueWelt.welt[i][j].getName()=="Stadtmauer"){
                                                    System.out.print("T ");
                                                }else{ 
                                                    if(neueWelt.welt[i][j].getName()=="Tür"){
                                                        System.out.print("E ");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println("");
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }

    private void gehNord(Command command) 
    {
        if(istErstellt==true){
            int x= neuerHeld.getxPos();
            int y= neuerHeld.getyPos()-1;
            if(imKampf==false){
                if(y>=0){
                    if((neueWelt.welt[x][y].getZugaenglichkeit()== false)){  
                        System.out.println("Hier kannst du nicht lang gehen! Hier befindet sich ein/e "+neueWelt.welt[x][y].getName()+".");
                        System.out.println();
                    }else {
                        neuerHeld.setyPos(y);
                        System.out.println("Du befindest dich nun auf "+neueWelt.welt[x][y].getName()+".");
                        System.out.println();
                    }
                    if(neueWelt.welt[x][y].getGegner()!=null){
                        Kampf.Kampf();
                        imKampf=true;
                    }
                }else{
                    System.out.println("Hier kannst du nicht lang gehen! Hier ist das Ende der Welt");
                    System.out.println();
                }
            }else{
                System.out.println("Du befindest dich gerade in einem Kampf. Wenn du fliehen möchtest benutze folgenden Befehl: fliehen.");
                System.out.println();
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }

    private void gehSued(Command command) 
    {
        if(istErstellt==true){
            int x= neuerHeld.getxPos();
            int y= neuerHeld.getyPos()+1;
            if(imKampf==false){
                if(y<=32){
                    if((neueWelt.welt[x][y].getZugaenglichkeit()== false)){  
                        System.out.println("Hier kannst du nicht lang gehen! Hier befindet sich ein/e "+neueWelt.welt[x][y].getName()+".");
                        System.out.println();
                    }else {
                        neuerHeld.setyPos(y);
                        System.out.println("Du befindest dich nun auf "+neueWelt.welt[x][y].getName()+".");
                        System.out.println();
                    }
                    if(neueWelt.welt[x][y].getGegner()!=null){
                        Kampf.Kampf();
                        imKampf=true;
                    }
                }
                else{
                    System.out.println("Hier kannst du nicht lang gehen! Hier ist das Ende der Welt");
                    System.out.println();
                }
            }else{
                System.out.println("Du befindest dich gerade in einem Kampf. Wenn du fliehen möchtest benutze folgenden Befehl: fliehen.");
                System.out.println();
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }           

    private void gehOst(Command command) 
    {
        if(istErstellt==true){
            int x= neuerHeld.getxPos()+1;
            int y= neuerHeld.getyPos();
            if(imKampf==false){
                if(x<=49){
                    if((neueWelt.welt[x][y].getZugaenglichkeit()== false)){ 
                        System.out.println("Hier kannst du nicht lang gehen! Hier befindet sich ein/e "+neueWelt.welt[x][y].getName()+".");
                        System.out.println();
                    }else {
                        neuerHeld.setxPos(x);
                        System.out.println("Du befindest dich nun auf "+neueWelt.welt[x][y].getName()+".");
                        System.out.println();
                    }
                    if(neueWelt.welt[x][y].getGegner()!=null){
                        Kampf.Kampf();
                        imKampf=true;
                    }
                }else{
                    System.out.println("Hier kannst du nicht lang gehen! Hier ist das Ende der Welt");
                    System.out.println();
                }
            }else{
                System.out.println("Du befindest dich gerade in einem Kampf. Wenn du fliehen möchtest benutze folgenden Befehl: fliehen.");
                System.out.println();
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }

    private void gehWest(Command command) 
    {
        if(istErstellt==true){
            int x= neuerHeld.getxPos()-1;
            int y= neuerHeld.getyPos();
            if(imKampf==false){
                if(x>=0){
                    if((neueWelt.welt[x][y].getZugaenglichkeit()== false)){  
                        System.out.println("Hier kannst du nicht lang gehen! Hier befindet sich ein/e "+neueWelt.welt[x][y].getName()+".");
                        System.out.println();
                    }else {
                        neuerHeld.setxPos(x);
                        System.out.println("Du befindest dich nun auf "+neueWelt.welt[x][y].getName()+".");
                        System.out.println();
                    }
                    if(neueWelt.welt[x][y].getGegner()!=null){
                        Kampf.Kampf();
                        imKampf=true;
                    }
                } else{
                    System.out.println("Hier kannst du nicht lang gehen! Hier ist das Ende der Welt");
                    System.out.println();
                }
            }else{
                System.out.println("Du befindest dich gerade in einem Kampf. Wenn du fliehen möchtest benutze folgenden Befehl: fliehen.");
                System.out.println();
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }

    private void nimm(Command command){
        if(istErstellt==true){
            int x= neuerHeld.getxPos();
            int y= neuerHeld.getyPos();
            if(imKampf==true){
                System.out.println("Du musst den Kampf zuerst beenden, bevor du etwas aufheben kannst.");
                System.out.println();
            }else{
                if(neueWelt.welt[x][y].getInhalt()!=null){
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
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }

    private void rucksack(Command command){
        if(istErstellt==true){
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
    }

    private void umsehen(Command command){
        if(istErstellt==true){
            int x= neuerHeld.getxPos();
            int y= neuerHeld.getyPos();
            if(imKampf==false){
                if(neueWelt.welt[x][y].getInhalt()!=null){
                    System.out.println("Hier befindet sich ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+".");
                    System.out.println();
                }else{
                    System.out.println("Hier ist nichts.");
                    System.out.println();
                }
            }else{
                System.out.println("Wenn du den/die/das "+neueWelt.welt[x][y].gegner[0].getName()+" besiegst kommst du an eine/n "+neueWelt.welt[x][y].inhalt[0].getName()+" heran.");
                System.out.println();
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    } 

    private void fallenlassen(Command command){
        if(istErstellt==true){
            int x= neuerHeld.getxPos();
            int y= neuerHeld.getyPos();
            if(neueWelt.welt[x][y].inhalt[0]==null){
                if(!command.hasSecondWord()) {
                    System.out.println("Aus welchem Fach aus deinem Rucksack soll etwas fallengelassen werden? Oder aus deiner Hand? Oder deine Rüstung?");
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
                if(fach.equals("Rüstung")) {
                    if(neuerHeld.getRuestung()!=null){
                        neueWelt.welt[x][y].setInhalt(neuerHeld.getRuestung());
                        System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+" fallengelassen.");
                        System.out.println();
                        neuerHeld.setRuestung(null);
                    }else{
                        System.out.println("Du hast keine Rüstung an.");
                        System.out.println();
                    }
                }
                System.out.println();
            }else{
                System.out.println("Hier liegt bereits ein/eine "+neueWelt.welt[x][y].inhalt[0].getName()+" suche dir einen anderen Ort zum ablegen.");
                System.out.println();
            }

        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }

    private void inHandTun(Command command){
        if(istErstellt==true){
            if(!command.hasSecondWord()) {
                System.out.println("Aus welchem Fach aus deinem Rucksack soll etwas in deine Hand gelegt werden?");
                System.out.println();
                return;
            }

            String fach = command.getSecondWord();

            if(fach.equals("1")) {
                if(neuerHeld.getRucksack(0)!=null){
                    if(neuerHeld.Rucksack[0].getKlasse()==neuerHeld.getKlasse()||neuerHeld.Rucksack[0].getKlasse()=="alle"){
                        neuerHeld.setHand(neuerHeld.getRucksack(0));
                        System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[0].getName()+".");
                        System.out.println();
                        neuerHeld.setRucksack(null,0);
                    }else{
                        System.out.println("Du kannst "+neuerHeld.Rucksack[0].getName()+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[0].getKlasse()+" bist.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("2")) {
                if(neuerHeld.getRucksack(1)!=null){
                    if(neuerHeld.Rucksack[1].getKlasse()==neuerHeld.getKlasse()||neuerHeld.Rucksack[1].getKlasse()=="alle"){
                        neuerHeld.setHand(neuerHeld.getRucksack(1));
                        System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[1].getName()+".");
                        System.out.println();
                        neuerHeld.setRucksack(null,1);
                    }else{
                        System.out.println("Du kannst "+neuerHeld.Rucksack[1].getName()+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[1].getKlasse()+" bist.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("3")) {
                if(neuerHeld.getRucksack(2)!=null){
                    if(neuerHeld.Rucksack[2].getKlasse()==neuerHeld.getKlasse()||neuerHeld.Rucksack[2].getKlasse()=="alle"){
                        neuerHeld.setHand(neuerHeld.getRucksack(2));
                        System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[2].getName()+".");
                        System.out.println();
                        neuerHeld.setRucksack(null,2);
                    }else{
                        System.out.println("Du kannst "+neuerHeld.Rucksack[2].getName()+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[2].getKlasse()+" bist.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                }
            }
            if(fach.equals("4")) {
                if(neuerHeld.getRucksack(3)!=null){
                    if(neuerHeld.Rucksack[3].getKlasse()==neuerHeld.getKlasse()||neuerHeld.Rucksack[3].getKlasse()=="alle"){
                        neuerHeld.setHand(neuerHeld.getRucksack(3));
                        System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[3].getName()+".");
                        System.out.println();
                        neuerHeld.setRucksack(null,3);
                    }else{
                        System.out.println("Du kannst "+neuerHeld.Rucksack[3].getName()+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[3].getKlasse()+" bist.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("5")) {
                if(neuerHeld.getRucksack(4)!=null){
                    if(neuerHeld.Rucksack[4].getKlasse()==neuerHeld.getKlasse()||neuerHeld.Rucksack[4].getKlasse()=="alle"){
                        neuerHeld.setHand(neuerHeld.getRucksack(4));
                        System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[4].getName()+".");
                        System.out.println();
                        neuerHeld.setRucksack(null,4);
                    }else{
                        System.out.println("Du kannst "+neuerHeld.Rucksack[4].getName()+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[4].getKlasse()+" bist.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("6")) {
                if(neuerHeld.getRucksack(5)!=null){
                    if(neuerHeld.Rucksack[5].getKlasse()==neuerHeld.getKlasse()||neuerHeld.Rucksack[5].getKlasse()=="alle"){
                        neuerHeld.setHand(neuerHeld.getRucksack(5));
                        System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[5].getName()+".");
                        System.out.println();
                        neuerHeld.setRucksack(null,5);
                    }else{
                        System.out.println("Du kannst "+neuerHeld.Rucksack[5].getName()+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[5].getKlasse()+" bist.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("7")) {
                if(neuerHeld.getRucksack(6)!=null){
                    if(neuerHeld.Rucksack[6].getKlasse()==neuerHeld.getKlasse()||neuerHeld.Rucksack[6].getKlasse()=="alle"){
                        neuerHeld.setHand(neuerHeld.getRucksack(6));
                        System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[6].getName()+".");
                        System.out.println();
                        neuerHeld.setRucksack(null,6);
                    }else{
                        System.out.println("Du kannst "+neuerHeld.Rucksack[6].getName()+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[6].getKlasse()+" bist.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("8")) {
                if(neuerHeld.getRucksack(7)!=null){
                    if(neuerHeld.Rucksack[7].getKlasse()==neuerHeld.getKlasse()||neuerHeld.Rucksack[7].getKlasse()=="alle"){
                        neuerHeld.setHand(neuerHeld.getRucksack(7));
                        System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[7].getName()+".");
                        System.out.println();
                        neuerHeld.setRucksack(null,7);
                    }else{
                        System.out.println("Du kannst "+neuerHeld.Rucksack[7].getName()+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[7].getKlasse()+" bist.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("9")) {
                if(neuerHeld.getRucksack(8)!=null){
                    if(neuerHeld.Rucksack[8].getKlasse()==neuerHeld.getKlasse()||neuerHeld.Rucksack[8].getKlasse()=="alle"){
                        neuerHeld.setHand(neuerHeld.getRucksack(8));
                        System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[8].getName()+".");
                        System.out.println();
                        neuerHeld.setRucksack(null,8);
                    }else{
                        System.out.println("Du kannst "+neuerHeld.Rucksack[8].getName()+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[8].getKlasse()+" bist.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("10")) {
                if(neuerHeld.getRucksack(9)!=null){
                    if(neuerHeld.Rucksack[9].getKlasse()==neuerHeld.getKlasse()||neuerHeld.Rucksack[9].getKlasse()=="alle"){
                        neuerHeld.setHand(neuerHeld.getRucksack(9));
                        System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[9].getName()+".");
                        System.out.println();
                        neuerHeld.setRucksack(null,9);
                    }else{
                        System.out.println("Du kannst "+neuerHeld.Rucksack[9].getName()+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[9].getKlasse()+" bist.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            System.out.println();
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }

    private void anziehen(Command command){
        if(istErstellt==true){
            if(!command.hasSecondWord()) {
                System.out.println("Aus welchem Fach deines Rucksacks soll etwas angezogen werden?");
                System.out.println();
                return;
            }

            String fach = command.getSecondWord();

            if(fach.equals("1")) {
                if(neuerHeld.getRucksack(0)!=null){
                    if(neuerHeld.Rucksack[0].getAnziehbar()==true){
                        if(neuerHeld.Rucksack[0].getKlasse()==neuerHeld.getKlasse()){
                            neuerHeld.setRuestung((Ruestung)neuerHeld.getRucksack(0));
                            System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[0].getName()+" angezogen.");
                            System.out.println();
                            neuerHeld.setRucksack(null,0);
                        }else{
                            System.out.println("Du musst ein "+neuerHeld.Rucksack[0].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[0].getName()+" anzuziehen.");
                            System.out.println();
                        }
                    }else{
                        System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[0].getName()+" nicht anziehen.");
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("2")) {
                if(neuerHeld.getRucksack(1)!=null){
                    if(neuerHeld.Rucksack[1].getAnziehbar()==true){
                        if(neuerHeld.Rucksack[1].getKlasse()==neuerHeld.getKlasse()){
                            neuerHeld.setRuestung((Ruestung)neuerHeld.getRucksack(1));
                            System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[1].getName()+" angezogen.");
                            System.out.println();
                            neuerHeld.setRucksack(null,1);
                        }else{
                            System.out.println("Du musst ein "+neuerHeld.Rucksack[1].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[1].getName()+" anzuziehen.");
                            System.out.println();
                        }
                    }else{
                        System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[0].getName()+" nicht anziehen.");
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("3")) {
                if(neuerHeld.getRucksack(2)!=null){
                    if(neuerHeld.Rucksack[2].getAnziehbar()==true){
                        if(neuerHeld.Rucksack[2].getKlasse()==neuerHeld.getKlasse()){
                            neuerHeld.setRuestung((Ruestung)neuerHeld.getRucksack(2));
                            System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[2].getName()+" angezogen.");
                            System.out.println();
                            neuerHeld.setRucksack(null,2);
                        }else{
                            System.out.println("Du musst ein "+neuerHeld.Rucksack[2].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[2].getName()+" anzuziehen.");
                            System.out.println();
                        }
                    }else{
                        System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[2].getName()+" nicht anziehen.");
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                }
            }
            if(fach.equals("4")) {
                if(neuerHeld.getRucksack(3)!=null){
                    if(neuerHeld.Rucksack[3].getAnziehbar()==true){
                        if(neuerHeld.Rucksack[3].getKlasse()==neuerHeld.getKlasse()){
                            neuerHeld.setRuestung((Ruestung)neuerHeld.getRucksack(3));
                            System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[3].getName()+" angezogen.");
                            System.out.println();
                            neuerHeld.setRucksack(null,3);
                        }else{
                            System.out.println("Du musst ein "+neuerHeld.Rucksack[3].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[3].getName()+" anzuziehen.");
                            System.out.println();
                        }
                    }else{
                        System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[3].getName()+" nicht anziehen.");
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("5")) {
                if(neuerHeld.getRucksack(4)!=null){
                    if(neuerHeld.Rucksack[4].getAnziehbar()==true){
                        if(neuerHeld.Rucksack[4].getKlasse()==neuerHeld.getKlasse()){
                            neuerHeld.setRuestung((Ruestung)neuerHeld.getRucksack(4));
                            System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[4].getName()+" angezogen.");
                            System.out.println();
                            neuerHeld.setRucksack(null,4);
                        }else{
                            System.out.println("Du musst ein "+neuerHeld.Rucksack[4].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[4].getName()+" anzuziehen.");
                            System.out.println();
                        }
                    }else{
                        System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[4].getName()+" nicht anziehen.");
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("6")) {
                if(neuerHeld.getRucksack(5)!=null){
                    if(neuerHeld.Rucksack[5].getAnziehbar()==true){
                        if(neuerHeld.Rucksack[5].getKlasse()==neuerHeld.getKlasse()){
                            neuerHeld.setRuestung((Ruestung)neuerHeld.getRucksack(5));
                            System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[5].getName()+" angezogen.");
                            System.out.println();
                            neuerHeld.setRucksack(null,5);
                        }else{
                            System.out.println("Du musst ein "+neuerHeld.Rucksack[5].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[5].getName()+" anzuziehen.");
                            System.out.println();
                        }
                    }else{
                        System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[5].getName()+" nicht anziehen.");
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("7")) {
                if(neuerHeld.getRucksack(6)!=null){
                    if(neuerHeld.Rucksack[6].getAnziehbar()==true){
                        if(neuerHeld.Rucksack[6].getKlasse()==neuerHeld.getKlasse()){
                            neuerHeld.setRuestung((Ruestung)neuerHeld.getRucksack(6));
                            System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[6].getName()+" angezogen.");
                            System.out.println();
                            neuerHeld.setRucksack(null,6);
                        }else{
                            System.out.println("Du musst ein "+neuerHeld.Rucksack[6].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[6].getName()+" anzuziehen.");
                            System.out.println();
                        }
                    }else{
                        System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[6].getName()+" nicht anziehen.");
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("8")) {
                if(neuerHeld.getRucksack(7)!=null){
                    if(neuerHeld.Rucksack[7].getAnziehbar()==true){
                        if(neuerHeld.Rucksack[7].getKlasse()==neuerHeld.getKlasse()){
                            neuerHeld.setRuestung((Ruestung)neuerHeld.getRucksack(7));
                            System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[7].getName()+" angezogen.");
                            System.out.println();
                            neuerHeld.setRucksack(null,7);
                        }else{
                            System.out.println("Du musst ein "+neuerHeld.Rucksack[7].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[7].getName()+" anzuziehen.");
                            System.out.println();
                        }
                    }else{
                        System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[7].getName()+" nicht anziehen.");
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("9")) {
                if(neuerHeld.getRucksack(8)!=null){
                    if(neuerHeld.Rucksack[8].getAnziehbar()==true){
                        if(neuerHeld.Rucksack[8].getKlasse()==neuerHeld.getKlasse()){
                            neuerHeld.setRuestung((Ruestung)neuerHeld.getRucksack(8));
                            System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[8].getName()+" angezogen.");
                            System.out.println();
                            neuerHeld.setRucksack(null,8);
                        }else{
                            System.out.println("Du musst ein "+neuerHeld.Rucksack[8].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[8].getName()+" anzuziehen.");
                            System.out.println();
                        }
                    }else{
                        System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[8].getName()+" nicht anziehen.");
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            if(fach.equals("10")) {
                if(neuerHeld.getRucksack(9)!=null){
                    if(neuerHeld.Rucksack[9].getAnziehbar()==true){
                        if(neuerHeld.Rucksack[9].getKlasse()==neuerHeld.getKlasse()){
                            neuerHeld.setRuestung((Ruestung)neuerHeld.getRucksack(9));
                            System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[9].getName()+" angezogen.");
                            System.out.println();
                            neuerHeld.setRucksack(null,9);
                        }else{
                            System.out.println("Du musst ein "+neuerHeld.Rucksack[9].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[9].getName()+" anzuziehen.");
                            System.out.println();
                        }
                    }else{
                        System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[9].getName()+" nicht anziehen.");
                    }
                }else{
                    System.out.println("Dieses Fach ist leer.");
                    System.out.println();
                }
            }
            System.out.println();
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }

    private void ausziehen(Command command){
        if(istErstellt==true){
            if(!command.hasSecondWord()) {
                System.out.println("In welches Fach in deinem Rucksack soll etwas was du ausziehst gelegt werden?");
                System.out.println();
                return;
            }

            String fach = command.getSecondWord();

            if(fach.equals("1")) {
                if(neuerHeld.getRuestung()!=null){
                    if(neuerHeld.getRucksack(0)==null){
                        neuerHeld.setRucksack(neuerHeld.getRuestung(),0);
                        System.out.println("In Fach 1/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+".");
                        System.out.println();
                        neuerHeld.setHand(null);
                    }else{
                        System.out.println("In diesem Fach ist bereits etwas.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Du hast gerade nichts an.");
                    System.out.println();
                }
            }
            if(fach.equals("2")) {
                if(neuerHeld.getRuestung()!=null){
                    if(neuerHeld.getRucksack(1)==null){
                        neuerHeld.setRucksack(neuerHeld.getRuestung(),1);
                        System.out.println("In Fach 2/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+".");
                        System.out.println();
                        neuerHeld.setHand(null);
                    }else{
                        System.out.println("In diesem Fach ist bereits etwas.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Du hast gerade nichts an.");
                    System.out.println();
                }
            }
            if(fach.equals("3")) {
                if(neuerHeld.getRuestung()!=null){
                    if(neuerHeld.getRucksack(2)==null){
                        neuerHeld.setRucksack(neuerHeld.getRuestung(),2);
                        System.out.println("In Fach 3/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+".");
                        System.out.println();
                        neuerHeld.setHand(null);
                    }else{
                        System.out.println("In diesem Fach ist bereits etwas.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Du hast gerade nichts an.");
                    System.out.println();
                }
            }
            if(fach.equals("4")) {
                if(neuerHeld.getRuestung()!=null){
                    if(neuerHeld.getRucksack(3)==null){
                        neuerHeld.setRucksack(neuerHeld.getRuestung(),3);
                        System.out.println("In Fach 4/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+".");
                        System.out.println();
                        neuerHeld.setHand(null);
                    }else{
                        System.out.println("In diesem Fach ist bereits etwas.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Du hast gerade nichts an.");
                    System.out.println();
                }
            }
            if(fach.equals("5")) {
                if(neuerHeld.getRuestung()!=null){
                    if(neuerHeld.getRucksack(4)==null){
                        neuerHeld.setRucksack(neuerHeld.getRuestung(),4);
                        System.out.println("In Fach 5/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+".");
                        System.out.println();
                        neuerHeld.setHand(null);
                    }else{
                        System.out.println("In diesem Fach ist bereits etwas.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Du hast gerade nichts an.");
                    System.out.println();
                }
            }
            if(fach.equals("6")) {
                if(neuerHeld.getRuestung()!=null){
                    if(neuerHeld.getRucksack(5)==null){
                        neuerHeld.setRucksack(neuerHeld.getRuestung(),5);
                        System.out.println("In Fach 6/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+".");
                        System.out.println();
                        neuerHeld.setHand(null);
                    }else{
                        System.out.println("In diesem Fach ist bereits etwas.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Du hast gerade nichts an.");
                    System.out.println();
                }
            }
            if(fach.equals("7")) {
                if(neuerHeld.getRuestung()!=null){
                    if(neuerHeld.getRucksack(6)==null){
                        neuerHeld.setRucksack(neuerHeld.getRuestung(),6);
                        System.out.println("In Fach 7/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+".");
                        System.out.println();
                        neuerHeld.setHand(null);
                    }else{
                        System.out.println("In diesem Fach ist bereits etwas.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Du hast gerade nichts an.");
                    System.out.println();
                }
            }
            if(fach.equals("8")) {
                if(neuerHeld.getRuestung()!=null){
                    if(neuerHeld.getRucksack(7)==null){
                        neuerHeld.setRucksack(neuerHeld.getRuestung(),7);
                        System.out.println("In Fach 8/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+".");
                        System.out.println();
                        neuerHeld.setHand(null);
                    }else{
                        System.out.println("In diesem Fach ist bereits etwas.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Du hast gerade nichts an.");
                    System.out.println();
                }
            }
            if(fach.equals("9")) {
                if(neuerHeld.getRuestung()!=null){
                    if(neuerHeld.getRucksack(8)==null){
                        neuerHeld.setRucksack(neuerHeld.getRuestung(),8);
                        System.out.println("In Fach 9/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+".");
                        System.out.println();
                        neuerHeld.setHand(null);
                    }else{
                        System.out.println("In diesem Fach ist bereits etwas.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Du hast gerade nichts an.");
                }
            }
            if(fach.equals("10")) {
                if(neuerHeld.getRuestung()!=null){
                    if(neuerHeld.getRucksack(9)==null){
                        neuerHeld.setRucksack(neuerHeld.getRuestung(),9);
                        System.out.println("In Fach 10/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+".");
                        System.out.println();
                        neuerHeld.setHand(null);
                    }else{
                        System.out.println("In diesem Fach ist bereits etwas.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Du hast gerade nichts an.");
                    System.out.println();
                }
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }

    private void ausHandTun(Command command){
        if(istErstellt==true){
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
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }

    private void zeigHand(Command command){
        if(istErstellt==true){
            if(neuerHeld.getHand()!=null){
                System.out.println("In deiner Hand befindet sich ein/e "+neuerHeld.Hand[0].getName()+".");
                System.out.println();
            }else{
                System.out.println("In deiner Hand befindet sich nichts.");
                System.out.println();
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
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

    private void angreifen(Command command){
        if(istErstellt==true){
            if(imKampf==true){
                Kampf.angreifen();
            }else{
                System.out.println("Du befindest dich gerade nicht in einem Kampf.");
                System.out.println();
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    } 

    private void fliehen(Command command){
        if(istErstellt==true){
            if(imKampf==true){
                Kampf.fliehen();
            }else{
                System.out.println("Du befindest dich gerade nicht in einem Kampf.");
                System.out.println();
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    } 

    private void status(Command command){
        if(istErstellt==true){
            System.out.println("Hier hast du einen Statusbericht über deine Werte:");
            System.out.println();
            System.out.println("X-Position: "+neuerHeld.getxPos());
            System.out.println("Y-Position: "+neuerHeld.getyPos());
            System.out.println("Untergrund: "+ neueWelt.welt[neuerHeld.getxPos()][neuerHeld.getyPos()].getName());
            System.out.println("Leben: "+neuerHeld.getHP());
            if(neuerHeld.getKlasse()=="Magier"){
                System.out.println("Mana: "+neuerHeld.getAusdauer());
            }else{
                if(neuerHeld.getKlasse()=="Krieger"){
                    System.out.println("Wut: "+neuerHeld.getAusdauer());
                }else{
                    System.out.println("Pfeile: "+neuerHeld.getAusdauer());
                }
            }

            if(neuerHeld.getHand()!=null){
                System.out.println("In deiner Hand ist ein/e "+neuerHeld.Hand[0].getName());
            }else{
                System.out.println("Du hast gerade nichts in deiner Hand");
            }

            if(neuerHeld.getRuestung()!=null){
                System.out.println("Du hast gerade ein/e "+neuerHeld.Ruestung[0].getName()+" an");
                System.out.println();
            }else{
                System.out.println("Du trägst gerade keine Rüstung");      
                System.out.println();
            }

        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    } 

    public static void setImKampf(boolean pImKampf){
        imKampf=pImKampf;
    }

    public static boolean getImKampf(){
        return imKampf;
    }

    public static void Pause(int M) {
        try {Thread.sleep(M);}
        catch(InterruptedException e) {return;}
    }
}