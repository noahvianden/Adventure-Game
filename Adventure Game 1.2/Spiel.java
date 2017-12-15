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

    public static void main() {

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
        System.out.println("Wähle als erstes eine Klasse, indem du entweder Magier, Schütze oder Krieger in das Textfeld einträgst.");
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
        else if (commandWord.equals("w")) {
            w(command);
        }
        else if (commandWord.equals("s")) {
            s(command);
        }
        else if (commandWord.equals("d")) {
            a(command);
        }
        else if (commandWord.equals("a")) {
            d(command);
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
        else if (commandWord.equals("inHand")) {
            inHand(command);
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
        else if (commandWord.equals("ausHand")) {
            ausHand(command);
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
        else if (commandWord.equals("angreifen")) {
            angreifen(command);
        }
        else if (commandWord.equals("fliehen")) {
            fliehen(command);
        }
        else if (commandWord.equals("status")) {
            status(command);
        }
        else if (commandWord.equals("aufschliessen")) {
            aufschliessen(command);
        }
        else if (commandWord.equals("verkaufen")) {
            verkaufen(command);
        }
        else if (commandWord.equals("kaufen")) {
            kaufen(command);
        }
        else if (commandWord.equals("waren")) {
            waren(command);
        }
        else if (commandWord.equals("beenden")) {
            WillDasSpielVerlassen = quit(command);
        }
        else if (commandWord.equals("loeschen")) {
            loeschen(command);
        }
        else if (commandWord.equals("lesen")) {
            lesen(command);
        }

        return WillDasSpielVerlassen;
    }

    private void sagHilfe(Command command) 
    {
        System.out.println();
        System.out.println("Hier hast du eine Übersicht der Befehle (Eine genaue Beschreibung zu jedem Befehl findest du auf unserem Befehleblatt):");
        System.out.println();
        System.out.println("w - geh Norden, s - geh Süden, d - geh Osten, a - geh Westen");
        System.out.println();
        System.out.println("beenden, hilfe, aufschliessen, lesen, status");
        System.out.println();
        System.out.println("rucksack, waren, umsehen, zeigHand, verkaufen 1-10/Hand/Rüstung, kaufen 1-4");
        System.out.println();
        System.out.println("nimm, ausHand 1-10, fallenlassen 1-10/Hand/Rüstung, inHand 1-10, anziehen 1-10, ausziehen 1-10, loeschen 1-10/Hand/Rüstung");
        System.out.println();
        System.out.println("angreifen, fliehen");
        System.out.println();
    }

    private void Magier(Command command){ 
        if(istErstellt==false){
            neuerHeld = new Held("Magier","Magier",2,10,46,13,10);
            System.out.println("Du bist nun ein Magier. Du erwachst ohne jegliche Erinnerungen in einer verschlossenen Scheune.");
            System.out.println();
            System.out.println("Irgendwo muss ein Schlüssel zu finden sein und du siehst einen kleinen Zettel vor dir liegen, vielleicht ein Hinweis?");
            System.out.println();
            System.out.println("Was ist passiert? Wer bist du? Du stehst auf und beginnst dein Abenteuer.");
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
            System.out.println("Du bist nun ein Schütze. Du erwachst ohne jegliche Erinnerungen in einer verschlossenen Scheune.");
            System.out.println();
            System.out.println("Irgendwo muss ein Schlüssel zu finden sein und du siehst einen kleinen Zettel vor dir liegen, vielleicht ein Hinweis?");
            System.out.println();
            System.out.println("Was ist passiert? Wer bist du? Du stehst auf und beginnst dein Abenteuer.");
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
            System.out.println("Du bist nun ein Krieger. Du erwachst ohne jegliche Erinnerungen in einer verschlossenen Scheune.");
            System.out.println();
            System.out.println("Irgendwo muss ein Schlüssel zu finden sein und du siehst einen kleinen Zettel vor dir liegen, vielleicht ein Hinweis?");
            System.out.println();
            System.out.println("Was ist passiert? Wer bist du? Du stehst auf und beginnst dein Abenteuer.");
            System.out.println();
            istErstellt=true;
        }else{
            System.out.println("Du hast bereits eine Klasse gewählt.");
            System.out.println();
        }
    }

    private void w(Command command) 
    {
        if(istErstellt==true){
            int x= neuerHeld.getxPos();
            int y= neuerHeld.getyPos()-1;
            if(imKampf==false){
                if(y>=0){
                    if(neueWelt.welt[x][y+1].getIstTuer()){
                        if(neueWelt.welt[x][y+1].istOffen()){
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
                            if(neueWelt.welt[x][y].getHaendler()!=null){
                                System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+neueWelt.welt[x][y].haendler[0].getTextBegruessung());
                                System.out.println();
                            }

                            if(neueWelt.welt[x][y].getQuestgeber()!=null){
                                questsPruefen();
                                if(neueWelt.welt[x][y].questgeber[0].questErfuellt()==false){
                                    if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesuche()<1){
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungErste());
                                        System.out.println();

                                    }else{
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungNachErste());
                                        System.out.println();
                                    }
                                }else{
                                    if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesucheNachQuest()>0){
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextNachQuest());
                                        System.out.println();
                                        neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextQuestFertig());
                                        System.out.println();
                                        neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                    }
                                }
                                neueWelt.welt[x][y].questgeber[0].anzahlBesucheErhoehen();
                            }

                        }else{
                            if(neueWelt.welt[x][y+1].getRichtungOeffnen()==3){
                                System.out.println("Hier kannst du nicht lang gehen, da die Tür verschlossen ist. Du musst zuerst einen passenden Schlüssel finden und die Tür aufschließen.");
                                System.out.println("");
                            }else{
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
                                if(neueWelt.welt[x][y].getHaendler()!=null){
                                    System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+neueWelt.welt[x][y].haendler[0].getTextBegruessung());
                                    System.out.println();
                                }
                                if(neueWelt.welt[x][y].getQuestgeber()!=null){   
                                    questsPruefen();
                                    if(neueWelt.welt[x][y].questgeber[0].questErfuellt()==false){
                                        if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesuche()<1){
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungErste());
                                            System.out.println();
                                        }else{
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungNachErste());
                                            System.out.println();
                                        }
                                    }else{
                                        if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesucheNachQuest()>0){
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextNachQuest());
                                            System.out.println();
                                            neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                        }else{
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextQuestFertig());
                                            System.out.println();
                                            neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                        }
                                    }
                                    neueWelt.welt[x][y].questgeber[0].anzahlBesucheErhoehen();
                                }
                            }
                        }
                    }else{
                        if((neueWelt.welt[x][y].getZugaenglichkeit()== false)){  
                            System.out.println("Hier kannst du nicht lang gehen! Hier befindet sich ein/e "+neueWelt.welt[x][y].getName()+".");
                            System.out.println();
                        }else {
                            if(neueWelt.welt[x][y].getIstTuer()== true){
                                neuerHeld.setyPos(y);
                                if(neueWelt.welt[x][y].istOffen()== true){
                                    System.out.println("Du kommst an ein/e/n "+neueWelt.welt[x][y].getName()+" die offen ist. Du kannst also einfach durch gehen.");
                                } else{
                                    System.out.println(neueWelt.welt[x][y].getTextWennZu());
                                }
                                System.out.println();
                            }else{
                                neuerHeld.setyPos(y);
                                System.out.println("Du befindest dich nun auf "+neueWelt.welt[x][y].getName()+".");
                                System.out.println();
                            }
                        }
                        if(neueWelt.welt[x][y].getGegner()!=null){
                            Kampf.Kampf();
                            imKampf=true;
                        }
                        if(neueWelt.welt[x][y].getHaendler()!=null){
                            System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+neueWelt.welt[x][y].haendler[0].getTextBegruessung());
                            System.out.println();
                        }
                        if(neueWelt.welt[x][y].getQuestgeber()!=null){   
                            questsPruefen();
                            if(neueWelt.welt[x][y].questgeber[0].questErfuellt()==false){
                                if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesuche()<1){
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungErste());
                                    System.out.println();

                                }else{
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungNachErste());
                                    System.out.println();
                                }
                            }else{
                                if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesucheNachQuest()>0){
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextNachQuest());
                                    System.out.println();
                                    neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                }else{
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextQuestFertig());
                                    System.out.println();
                                    neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                }
                            }
                            neueWelt.welt[x][y].questgeber[0].anzahlBesucheErhoehen();
                        }
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

    private void s(Command command) 
    {
        if(istErstellt==true){
            int x= neuerHeld.getxPos();
            int y= neuerHeld.getyPos()+1;
            if(imKampf==false){
                if(y<=32){
                    if(neueWelt.welt[x][y-1].getIstTuer()){
                        if(neueWelt.welt[x][y-1].istOffen()){
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
                            if(neueWelt.welt[x][y].getHaendler()!=null){
                                System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+neueWelt.welt[x][y].haendler[0].getTextBegruessung());
                                System.out.println();
                            }
                            if(neueWelt.welt[x][y].getQuestgeber()!=null){              
                                questsPruefen();
                                if(neueWelt.welt[x][y].questgeber[0].questErfuellt()==false){
                                    if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesuche()<1){
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungErste());
                                        System.out.println();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungNachErste());
                                        System.out.println();
                                    }
                                }else{
                                    if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesucheNachQuest()>0){
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextNachQuest());
                                        System.out.println();
                                        neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextQuestFertig());
                                        System.out.println();
                                        neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                    }
                                }
                                neueWelt.welt[x][y].questgeber[0].anzahlBesucheErhoehen();
                            }
                        }else{
                            if(neueWelt.welt[x][y-1].getRichtungOeffnen()==1){
                                System.out.println("Hier kannst du nicht lang gehen, da die Tür verschlossen ist. Du musst zuerst einen passenden Schlüssel finden und die Tür aufschließen.");
                                System.out.println("");
                            }else{
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
                                if(neueWelt.welt[x][y].getHaendler()!=null){
                                    System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+neueWelt.welt[x][y].haendler[0].getTextBegruessung());
                                    System.out.println();
                                }
                                if(neueWelt.welt[x][y].getQuestgeber()!=null){       
                                    questsPruefen();
                                    if(neueWelt.welt[x][y].questgeber[0].questErfuellt()==false){
                                        if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesuche()<1){
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungErste());
                                            System.out.println();

                                        }else{
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungNachErste());
                                            System.out.println();
                                        }
                                    }else{
                                        if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesucheNachQuest()>0){
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextNachQuest());
                                            System.out.println();
                                            neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                        }else{
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextQuestFertig());
                                            System.out.println();
                                            neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                        }
                                    }
                                    neueWelt.welt[x][y].questgeber[0].anzahlBesucheErhoehen();
                                }
                            }
                        }
                    }else{
                        if((neueWelt.welt[x][y].getZugaenglichkeit()== false)){  
                            System.out.println("Hier kannst du nicht lang gehen! Hier befindet sich ein/e "+neueWelt.welt[x][y].getName()+".");
                            System.out.println();
                        }else {
                            if(neueWelt.welt[x][y].getIstTuer()== true){
                                neuerHeld.setyPos(y);
                                if(neueWelt.welt[x][y].istOffen()== true){
                                    System.out.println("Du kommst an ein/e/n "+neueWelt.welt[x][y].getName()+" die offen ist. Du kannst also einfach durch gehen.");
                                } else{
                                    System.out.println(neueWelt.welt[x][y].getTextWennZu());
                                }
                                System.out.println();
                            }else{
                                neuerHeld.setyPos(y);
                                System.out.println("Du befindest dich nun auf "+neueWelt.welt[x][y].getName()+".");
                                System.out.println();
                            }
                        }
                        if(neueWelt.welt[x][y].getGegner()!=null){
                            Kampf.Kampf();
                            imKampf=true;
                        }
                        if(neueWelt.welt[x][y].getHaendler()!=null){
                            System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+neueWelt.welt[x][y].haendler[0].getTextBegruessung());
                            System.out.println();
                        }
                        if(neueWelt.welt[x][y].getQuestgeber()!=null){        
                            questsPruefen();
                            if(neueWelt.welt[x][y].questgeber[0].questErfuellt()==false){
                                if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesuche()<1){
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungErste());
                                    System.out.println();

                                }else{
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungNachErste());
                                    System.out.println();
                                }
                            }else{
                                if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesucheNachQuest()>0){
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextNachQuest());
                                    System.out.println();
                                    neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                }else{
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextQuestFertig());
                                    System.out.println();
                                    neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                }
                            }
                            neueWelt.welt[x][y].questgeber[0].anzahlBesucheErhoehen();
                        }
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

    private void a(Command command) 
    {
        if(istErstellt==true){
            int x= neuerHeld.getxPos()+1;
            int y= neuerHeld.getyPos();
            if(imKampf==false){
                if(x<=49){
                    if(neueWelt.welt[x-1][y].getIstTuer()){
                        if(neueWelt.welt[x-1][y].istOffen()){
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
                            if(neueWelt.welt[x][y].getHaendler()!=null){
                                System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+neueWelt.welt[x][y].haendler[0].getTextBegruessung());
                                System.out.println();
                            }
                            if(neueWelt.welt[x][y].getQuestgeber()!=null){           
                                questsPruefen();
                                if(neueWelt.welt[x][y].questgeber[0].questErfuellt()==false){
                                    if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesuche()<1){
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungErste());
                                        System.out.println();

                                    }else{
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungNachErste());
                                        System.out.println();
                                    }
                                }else{
                                    if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesucheNachQuest()>0){
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextNachQuest());
                                        System.out.println();
                                        neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextQuestFertig());
                                        System.out.println();
                                        neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                    }
                                }
                                neueWelt.welt[x][y].questgeber[0].anzahlBesucheErhoehen();
                            }
                        }else{
                            if(neueWelt.welt[x][y+1].getRichtungOeffnen()==4){
                                System.out.println("Hier kannst du nicht lang gehen, da die Tür verschlossen ist. Du musst zuerst einen passenden Schlüssel finden und die Tür aufschließen.");
                                System.out.println("");
                            }else{
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
                                if(neueWelt.welt[x][y].getHaendler()!=null){
                                    System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+neueWelt.welt[x][y].haendler[0].getTextBegruessung());
                                    System.out.println();
                                }
                                if(neueWelt.welt[x][y].getQuestgeber()!=null){     
                                    questsPruefen();
                                    if(neueWelt.welt[x][y].questgeber[0].questErfuellt()==false){
                                        if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesuche()<1){
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungErste());
                                            System.out.println();

                                        }else{
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungNachErste());
                                            System.out.println();
                                        }
                                    }else{
                                        if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesucheNachQuest()>0){
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextNachQuest());
                                            System.out.println();
                                            neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                        }else{
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextQuestFertig());
                                            System.out.println();
                                            neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                        }
                                    }
                                    neueWelt.welt[x][y].questgeber[0].anzahlBesucheErhoehen();
                                }
                            }
                        }
                    }else{
                        if((neueWelt.welt[x][y].getZugaenglichkeit()== false)){  
                            System.out.println("Hier kannst du nicht lang gehen! Hier befindet sich ein/e "+neueWelt.welt[x][y].getName()+".");
                            System.out.println();
                        }else {
                            if(neueWelt.welt[x][y].getIstTuer()== true){
                                neuerHeld.setxPos(x);
                                if(neueWelt.welt[x][y].istOffen()== true){
                                    System.out.println("Du kommst an ein/e/n "+neueWelt.welt[x][y].getName()+" die offen ist. Du kannst also einfach durch gehen.");
                                } else{
                                    System.out.println(neueWelt.welt[x][y].getTextWennZu());
                                }
                                System.out.println();
                            }else{
                                neuerHeld.setxPos(x);
                                System.out.println("Du befindest dich nun auf "+neueWelt.welt[x][y].getName()+".");
                                System.out.println();
                            }
                        }
                        if(neueWelt.welt[x][y].getGegner()!=null){
                            Kampf.Kampf();
                            imKampf=true;
                        }
                        if(neueWelt.welt[x][y].getHaendler()!=null){
                            System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+neueWelt.welt[x][y].haendler[0].getTextBegruessung());
                            System.out.println();
                        }
                        if(neueWelt.welt[x][y].getQuestgeber()!=null){          
                            questsPruefen();
                            if(neueWelt.welt[x][y].questgeber[0].questErfuellt()==false){
                                if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesuche()<1){
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungErste());
                                    System.out.println();

                                }else{
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungNachErste());
                                    System.out.println();
                                }
                            }else{
                                if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesucheNachQuest()>0){
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextNachQuest());
                                    System.out.println();
                                    neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                }else{
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextQuestFertig());
                                    System.out.println();
                                    neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                }
                            }
                            neueWelt.welt[x][y].questgeber[0].anzahlBesucheErhoehen();
                        }
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

    private void d(Command command) 
    {
        if(istErstellt==true){
            int x= neuerHeld.getxPos()-1;
            int y= neuerHeld.getyPos();
            if(imKampf==false){
                if(x>=0){
                    if(neueWelt.welt[x+1][y].getIstTuer()){
                        if(neueWelt.welt[x+1][y].istOffen()){
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
                            if(neueWelt.welt[x][y].getHaendler()!=null){
                                System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+neueWelt.welt[x][y].haendler[0].getTextBegruessung());
                                System.out.println();
                            }
                            if(neueWelt.welt[x][y].getQuestgeber()!=null){   
                                questsPruefen();
                                if(neueWelt.welt[x][y].questgeber[0].questErfuellt()==false){
                                    if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesuche()<1){
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungErste());
                                        System.out.println();

                                    }else{
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungNachErste());
                                        System.out.println();
                                    }
                                }else{
                                    if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesucheNachQuest()>0){
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextNachQuest());
                                        System.out.println();
                                        neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextQuestFertig());
                                        System.out.println();
                                        neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                    }
                                }
                                neueWelt.welt[x][y].questgeber[0].anzahlBesucheErhoehen();
                            }
                        }else{
                            if(neueWelt.welt[x][y+1].getRichtungOeffnen()==2){
                                System.out.println("Hier kannst du nicht lang gehen, da die Tür verschlossen ist. Du musst zuerst einen passenden Schlüssel finden und die Tür aufschließen.");
                                System.out.println("");
                            }else{
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
                                if(neueWelt.welt[x][y].getHaendler()!=null){
                                    System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+neueWelt.welt[x][y].haendler[0].getTextBegruessung());
                                    System.out.println();
                                }
                                if(neueWelt.welt[x][y].getQuestgeber()!=null){        
                                    questsPruefen();
                                    if(neueWelt.welt[x][y].questgeber[0].questErfuellt()==false){
                                        if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesuche()<1){
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungErste());
                                            System.out.println();

                                        }else{
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungNachErste());
                                            System.out.println();
                                        }
                                    }else{
                                        if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesucheNachQuest()>0){
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextNachQuest());
                                            System.out.println();
                                            neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                        }else{
                                            System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextQuestFertig());
                                            System.out.println();
                                            neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                        }
                                    }
                                    neueWelt.welt[x][y].questgeber[0].anzahlBesucheErhoehen();
                                }
                            }
                        }
                    }else{
                        if((neueWelt.welt[x][y].getZugaenglichkeit()== false)){  
                            System.out.println("Hier kannst du nicht lang gehen! Hier befindet sich ein/e "+neueWelt.welt[x][y].getName()+".");
                            System.out.println();
                        }else {
                            if(neueWelt.welt[x][y].getIstTuer()== true){
                                neuerHeld.setxPos(x);
                                if(neueWelt.welt[x][y].istOffen()== true){
                                    System.out.println("Du kommst an ein/e/n "+neueWelt.welt[x][y].getName()+" die offen ist. Du kannst also einfach durch gehen.");
                                } else{
                                    System.out.println(neueWelt.welt[x][y].getTextWennZu());
                                }
                                System.out.println();
                            }else{
                                neuerHeld.setxPos(x);
                                System.out.println("Du befindest dich nun auf "+neueWelt.welt[x][y].getName()+".");
                                System.out.println();
                            }
                        }
                        if(neueWelt.welt[x][y].getGegner()!=null){
                            Kampf.Kampf();
                            imKampf=true;
                        }
                        if(neueWelt.welt[x][y].getHaendler()!=null){
                            System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+neueWelt.welt[x][y].haendler[0].getTextBegruessung());
                            System.out.println();
                        }
                        if(neueWelt.welt[x][y].getQuestgeber()!=null){             
                            questsPruefen();
                            if(neueWelt.welt[x][y].questgeber[0].questErfuellt()==false){
                                if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesuche()<1){
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungErste());
                                    System.out.println();

                                }else{
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getBegruessungNachErste());
                                    System.out.println();
                                }
                            }else{
                                if(neueWelt.welt[x][y].questgeber[0].getAnzahlBesucheNachQuest()>0){
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextNachQuest());
                                    System.out.println();
                                    neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                }else{
                                    System.out.println(neueWelt.welt[x][y].questgeber[0].getName()+": "+neueWelt.welt[x][y].questgeber[0].getTextQuestFertig());
                                    System.out.println();
                                    neueWelt.welt[x][y].questgeber[0].anzahlBesucheNachQuestErhoehen();
                                }
                            }
                            neueWelt.welt[x][y].questgeber[0].anzahlBesucheErhoehen();
                        }
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
                                    System.out.println("Ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" befindet sich nun in Fach "+b+"/10 in deinem Rucksack.");
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
                    System.out.println("In Fach "+b+"/10 befindet sich: "+neuerHeld.Rucksack[i].getName()+"("+neuerHeld.Rucksack[i].getPreis()+" Münzen).");
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
                    System.out.println("Hier befindet sich ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+".");
                    System.out.println();
                }else{
                    System.out.println("Hier ist nichts.");
                    System.out.println();
                }
            }else{
                System.out.println("Wenn du den/die/das "+neueWelt.welt[x][y].gegner[0].getName()+" besiegst kommst du an eine/n "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" heran.");
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
                        System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" fallengelassen.");
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
                        System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" fallengelassen.");
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
                        System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" fallengelassen.");
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
                        System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" fallengelassen.");
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
                        System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" fallengelassen.");
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
                        System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" fallengelassen.");
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
                        System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" fallengelassen.");
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
                        System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" fallengelassen.");
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
                        System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" fallengelassen.");
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
                        System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" fallengelassen.");
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
                        System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" fallengelassen.");
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
                        System.out.println("Du hast ein/e "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" fallengelassen.");
                        System.out.println();
                        neuerHeld.setRuestung(null);
                    }else{
                        System.out.println("Du hast keine Rüstung an.");
                        System.out.println();
                    }
                }
                System.out.println();
            }else{
                System.out.println("Hier liegt bereits ein/eine "+neueWelt.welt[x][y].inhalt[0].getName()+"("+neueWelt.welt[x][y].inhalt[0].getPreis()+" Münzen)"+" suche dir einen anderen Ort zum ablegen.");
                System.out.println();
            }

        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }

    private void inHand(Command command){
        if(istErstellt==true){
            if(!command.hasSecondWord()) {
                System.out.println("Aus welchem Fach aus deinem Rucksack soll etwas in deine Hand gelegt werden?");
                System.out.println();
                return;
            }

            String fach = command.getSecondWord();
            if(neuerHeld.Hand[0]==null){
                if(fach.equals("1")) {
                    if(neuerHeld.getRucksack(0)!=null){
                        if(neuerHeld.Rucksack[0].getKlasse()==neuerHeld.getKlasse()||neuerHeld.Rucksack[0].getKlasse()=="alle"){
                            neuerHeld.setHand(neuerHeld.getRucksack(0));
                            System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[0].getName()+"("+neuerHeld.Rucksack[0].getPreis()+" Münzen)"+".");
                            System.out.println();
                            neuerHeld.setRucksack(null,0);
                        }else{
                            System.out.println("Du kannst "+neuerHeld.Rucksack[0].getName()+"("+neuerHeld.Rucksack[0].getPreis()+" Münzen)"+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[0].getKlasse()+" bist.");
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
                            System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[1].getName()+"("+neuerHeld.Rucksack[1].getPreis()+" Münzen)"+".");
                            System.out.println();
                            neuerHeld.setRucksack(null,1);
                        }else{
                            System.out.println("Du kannst "+neuerHeld.Rucksack[1].getName()+"("+neuerHeld.Rucksack[1].getPreis()+" Münzen)"+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[1].getKlasse()+" bist.");
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
                            System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[2].getName()+"("+neuerHeld.Rucksack[2].getPreis()+" Münzen)"+".");
                            System.out.println();
                            neuerHeld.setRucksack(null,2);
                        }else{
                            System.out.println("Du kannst "+neuerHeld.Rucksack[2].getName()+"("+neuerHeld.Rucksack[2].getPreis()+" Münzen)"+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[2].getKlasse()+" bist.");
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
                            System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[3].getName()+"("+neuerHeld.Rucksack[3].getPreis()+" Münzen)"+".");
                            System.out.println();
                            neuerHeld.setRucksack(null,3);
                        }else{
                            System.out.println("Du kannst "+neuerHeld.Rucksack[3].getName()+"("+neuerHeld.Rucksack[3].getPreis()+" Münzen)"+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[3].getKlasse()+" bist.");
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
                            System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[4].getName()+"("+neuerHeld.Rucksack[4].getPreis()+" Münzen)"+".");
                            System.out.println();
                            neuerHeld.setRucksack(null,4);
                        }else{
                            System.out.println("Du kannst "+neuerHeld.Rucksack[4].getName()+"("+neuerHeld.Rucksack[4].getPreis()+" Münzen)"+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[4].getKlasse()+" bist.");
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
                            System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[5].getName()+"("+neuerHeld.Rucksack[5].getPreis()+" Münzen)"+".");
                            System.out.println();
                            neuerHeld.setRucksack(null,5);
                        }else{
                            System.out.println("Du kannst "+neuerHeld.Rucksack[5].getName()+"("+neuerHeld.Rucksack[5].getPreis()+" Münzen)"+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[5].getKlasse()+" bist.");
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
                            System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[6].getName()+"("+neuerHeld.Rucksack[6].getPreis()+" Münzen)"+".");
                            System.out.println();
                            neuerHeld.setRucksack(null,6);
                        }else{
                            System.out.println("Du kannst "+neuerHeld.Rucksack[6].getName()+"("+neuerHeld.Rucksack[6].getPreis()+" Münzen)"+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[6].getKlasse()+" bist.");
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
                            System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[7].getName()+"("+neuerHeld.Rucksack[7].getPreis()+" Münzen)"+".");
                            System.out.println();
                            neuerHeld.setRucksack(null,7);
                        }else{
                            System.out.println("Du kannst "+neuerHeld.Rucksack[7].getName()+"("+neuerHeld.Rucksack[7].getPreis()+" Münzen)"+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[7].getKlasse()+" bist.");
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
                            System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[8].getName()+"("+neuerHeld.Rucksack[8].getPreis()+" Münzen)"+".");
                            System.out.println();
                            neuerHeld.setRucksack(null,8);
                        }else{
                            System.out.println("Du kannst "+neuerHeld.Rucksack[8].getName()+"("+neuerHeld.Rucksack[8].getPreis()+" Münzen)"+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[8].getKlasse()+" bist.");
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
                            System.out.println("In deiner Hand befindet sich nun ein/e "+neuerHeld.Rucksack[9].getName()+"("+neuerHeld.Rucksack[9].getPreis()+" Münzen)"+".");
                            System.out.println();
                            neuerHeld.setRucksack(null,9);
                        }else{
                            System.out.println("Du kannst "+neuerHeld.Rucksack[9].getName()+"("+neuerHeld.Rucksack[9].getPreis()+" Münzen)"+" nicht in die Hand nehmen, weil du kein "+neuerHeld.Rucksack[9].getKlasse()+" bist.");
                            System.out.println();
                        }
                    }else{
                        System.out.println("Dieses Fach ist leer.");
                        System.out.println();
                    }
                }
            }else{
                System.out.println("Du hast bereits etwas in deiner Hand, leg es zuerst weg.");
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

            if(neuerHeld.Rucksack[0]==null){
                if(fach.equals("1")) {
                    if(neuerHeld.getRucksack(0)!=null){
                        if(neuerHeld.Rucksack[0].getAnziehbar()==true){
                            if(neuerHeld.Rucksack[0].getKlasse()==neuerHeld.getKlasse()){
                                neuerHeld.setRuestung((Ruestung)neuerHeld.getRucksack(0));
                                System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[0].getName()+"("+neuerHeld.Rucksack[0].getPreis()+" Münzen)"+" angezogen.");
                                System.out.println();
                                neuerHeld.setRucksack(null,0);
                            }else{
                                System.out.println("Du musst ein "+neuerHeld.Rucksack[0].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[0].getName()+"("+neuerHeld.Rucksack[0].getPreis()+" Münzen)"+" anzuziehen.");
                                System.out.println();
                            }
                        }else{
                            System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[0].getName()+"("+neuerHeld.Rucksack[0].getPreis()+" Münzen)"+" nicht anziehen.");
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
                                System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[1].getName()+"("+neuerHeld.Rucksack[1].getPreis()+" Münzen)"+" angezogen.");
                                System.out.println();
                                neuerHeld.setRucksack(null,1);
                            }else{
                                System.out.println("Du musst ein "+neuerHeld.Rucksack[1].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[1].getName()+"("+neuerHeld.Rucksack[1].getPreis()+" Münzen)"+" anzuziehen.");
                                System.out.println();
                            }
                        }else{
                            System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[1].getName()+"("+neuerHeld.Rucksack[1].getPreis()+" Münzen)"+" nicht anziehen.");
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
                                System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[2].getName()+"("+neuerHeld.Rucksack[2].getPreis()+" Münzen)"+" angezogen.");
                                System.out.println();
                                neuerHeld.setRucksack(null,2);
                            }else{
                                System.out.println("Du musst ein "+neuerHeld.Rucksack[2].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[2].getName()+"("+neuerHeld.Rucksack[2].getPreis()+" Münzen)"+" anzuziehen.");
                                System.out.println();
                            }
                        }else{
                            System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[2].getName()+"("+neuerHeld.Rucksack[2].getPreis()+" Münzen)"+" nicht anziehen.");
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
                                System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[3].getName()+"("+neuerHeld.Rucksack[3].getPreis()+" Münzen)"+" angezogen.");
                                System.out.println();
                                neuerHeld.setRucksack(null,3);
                            }else{
                                System.out.println("Du musst ein "+neuerHeld.Rucksack[3].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[3].getName()+"("+neuerHeld.Rucksack[3].getPreis()+" Münzen)"+" anzuziehen.");
                                System.out.println();
                            }
                        }else{
                            System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[3].getName()+"("+neuerHeld.Rucksack[3].getPreis()+" Münzen)"+" nicht anziehen.");
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
                                System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[4].getName()+"("+neuerHeld.Rucksack[4].getPreis()+" Münzen)"+" angezogen.");
                                System.out.println();
                                neuerHeld.setRucksack(null,4);
                            }else{
                                System.out.println("Du musst ein "+neuerHeld.Rucksack[4].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[4].getName()+"("+neuerHeld.Rucksack[4].getPreis()+" Münzen)"+" anzuziehen.");
                                System.out.println();
                            }
                        }else{
                            System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[4].getName()+"("+neuerHeld.Rucksack[4].getPreis()+" Münzen)"+" nicht anziehen.");
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
                                System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[5].getName()+"("+neuerHeld.Rucksack[5].getPreis()+" Münzen)"+" angezogen.");
                                System.out.println();
                                neuerHeld.setRucksack(null,5);
                            }else{
                                System.out.println("Du musst ein "+neuerHeld.Rucksack[5].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[5].getName()+"("+neuerHeld.Rucksack[5].getPreis()+" Münzen)"+" anzuziehen.");
                                System.out.println();
                            }
                        }else{
                            System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[5].getName()+"("+neuerHeld.Rucksack[5].getPreis()+" Münzen)"+" nicht anziehen.");
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
                                System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[6].getName()+"("+neuerHeld.Rucksack[6].getPreis()+" Münzen)"+" angezogen.");
                                System.out.println();
                                neuerHeld.setRucksack(null,6);
                            }else{
                                System.out.println("Du musst ein "+neuerHeld.Rucksack[6].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[6].getName()+"("+neuerHeld.Rucksack[6].getPreis()+" Münzen)"+" anzuziehen.");
                                System.out.println();
                            }
                        }else{
                            System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[6].getName()+"("+neuerHeld.Rucksack[6].getPreis()+" Münzen)"+" nicht anziehen.");
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
                                System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[7].getName()+"("+neuerHeld.Rucksack[7].getPreis()+" Münzen)"+" angezogen.");
                                System.out.println();
                                neuerHeld.setRucksack(null,7);
                            }else{
                                System.out.println("Du musst ein "+neuerHeld.Rucksack[7].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[7].getName()+"("+neuerHeld.Rucksack[7].getPreis()+" Münzen)"+" anzuziehen.");
                                System.out.println();
                            }
                        }else{
                            System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[7].getName()+"("+neuerHeld.Rucksack[7].getPreis()+" Münzen)"+" nicht anziehen.");
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
                                System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[8].getName()+"("+neuerHeld.Rucksack[8].getPreis()+" Münzen)"+" angezogen.");
                                System.out.println();
                                neuerHeld.setRucksack(null,8);
                            }else{
                                System.out.println("Du musst ein "+neuerHeld.Rucksack[8].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[8].getName()+"("+neuerHeld.Rucksack[8].getPreis()+" Münzen)"+" anzuziehen.");
                                System.out.println();
                            }
                        }else{
                            System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[8].getName()+"("+neuerHeld.Rucksack[8].getPreis()+" Münzen)"+" nicht anziehen.");
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
                                System.out.println("Du hast nun eine/n "+neuerHeld.Rucksack[9].getName()+"("+neuerHeld.Rucksack[9].getPreis()+" Münzen)"+" angezogen.");
                                System.out.println();
                                neuerHeld.setRucksack(null,9);
                            }else{
                                System.out.println("Du musst ein "+neuerHeld.Rucksack[9].getKlasse()+" sein um ein/e "+neuerHeld.Rucksack[9].getName()+"("+neuerHeld.Rucksack[9].getPreis()+" Münzen)"+" anzuziehen.");
                                System.out.println();
                            }
                        }else{
                            System.out.println("Du kannst eine/n "+neuerHeld.Rucksack[9].getName()+"("+neuerHeld.Rucksack[9].getPreis()+" Münzen)"+" nicht anziehen.");
                        }
                    }else{
                        System.out.println("Dieses Fach ist leer.");
                        System.out.println();
                    }
                }
            }else{
                System.out.println("Du hast schon was an. Zieh es aus, bevor du was neues anziehst.");
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
                        System.out.println("In Fach 1/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+"("+neuerHeld.Ruestung[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 2/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+"("+neuerHeld.Ruestung[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 3/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+"("+neuerHeld.Ruestung[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 4/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+"("+neuerHeld.Ruestung[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 5/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+"("+neuerHeld.Ruestung[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 6/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+"("+neuerHeld.Ruestung[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 7/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+"("+neuerHeld.Ruestung[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 8/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+"("+neuerHeld.Ruestung[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 9/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+"("+neuerHeld.Ruestung[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 10/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Ruestung[0].getName()+"("+neuerHeld.Ruestung[0].getPreis()+" Münzen)"+".");
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

    private void ausHand(Command command){
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
                        System.out.println("In Fach 1/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+"("+neuerHeld.Hand[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 2/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+"("+neuerHeld.Hand[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 3/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+"("+neuerHeld.Hand[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 4/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+"("+neuerHeld.Hand[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 5/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+"("+neuerHeld.Hand[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 6/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+"("+neuerHeld.Hand[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 7/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+"("+neuerHeld.Hand[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 8/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+"("+neuerHeld.Hand[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 9/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+"("+neuerHeld.Hand[0].getPreis()+" Münzen)"+".");
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
                        System.out.println("In Fach 10/10 deines Rucksacks befindet sich nun ein/e "+neuerHeld.Hand[0].getName()+"("+neuerHeld.Hand[0].getPreis()+" Münzen)"+".");
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
                System.out.println("In deiner Hand befindet sich ein/e "+neuerHeld.Hand[0].getName()+"("+neuerHeld.Hand[0].getPreis()+" Münzen)"+".");
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

    private void loeschen(Command command){
        if(istErstellt==true){
            String ort = command.getSecondWord();

            if(!command.hasSecondWord()) {
                System.out.println("Von wo soll etwas gelöscht werden?");
                System.out.println();
                return;
            }

            if(ort.equals("1")){
                neuerHeld.Rucksack[0]=null;
            }
            if(ort.equals("2")){
                neuerHeld.Rucksack[1]=null;
            }
            if(ort.equals("3")){
                neuerHeld.Rucksack[2]=null;
            }
            if(ort.equals("4")){
                neuerHeld.Rucksack[3]=null;
            }
            if(ort.equals("5")){
                neuerHeld.Rucksack[4]=null;
            }
            if(ort.equals("6")){
                neuerHeld.Rucksack[5]=null;
            }
            if(ort.equals("7")){
                neuerHeld.Rucksack[6]=null;
            }
            if(ort.equals("8")){
                neuerHeld.Rucksack[7]=null;
            }
            if(ort.equals("9")){
                neuerHeld.Rucksack[8]=null;
            }
            if(ort.equals("10")){
                neuerHeld.Rucksack[9]=null;
            }
            if(ort.equals("Hand")){
                neuerHeld.Hand[0]=null;
            }
            if(ort.equals("Rüstung")){
                neuerHeld.Ruestung[0]=null;
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
            System.out.println("Geld: "+neuerHeld.getGeld()+" Münzen");
            System.out.println("Leben: "+neuerHeld.getHP());

            if(neuerHeld.getHand()!=null){
                System.out.println("In deiner Hand ist ein/e "+neuerHeld.Hand[0].getName()+"("+neuerHeld.Hand[0].getPreis()+" Münzen)");
            }else{
                System.out.println("Du hast gerade nichts in deiner Hand");
            }

            if(neuerHeld.getRuestung()!=null){
                System.out.println("Du hast gerade ein/e "+neuerHeld.Ruestung[0].getName()+"("+neuerHeld.Ruestung[0].getPreis()+" Münzen)"+" an");
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

    private void aufschliessen(Command command){
        if(istErstellt==true){
            if(neuerHeld.getHand()==null){
                System.out.println("Du hast nichts in deiner Hand, wie willst du da etwas aufschließen?");
                System.out.println();
            }else{
                if(neuerHeld.Hand[0].istSchluessel()){
                    if(neueWelt.welt[neuerHeld.getxPos()][neuerHeld.getyPos()].getIstTuer()){
                        if(neueWelt.welt[neuerHeld.getxPos()][neuerHeld.getyPos()].getID()==neuerHeld.Hand[0].getID()){
                            neueWelt.welt[neuerHeld.getxPos()][neuerHeld.getyPos()].aufmachen();
                            System.out.println(neueWelt.welt[neuerHeld.getxPos()][neuerHeld.getyPos()].getTextAufschließen());
                            System.out.println();
                        }else{
                            System.out.println("Du versuchst den Schlüssel in das Schloss zu stecken, aber er will einfach nicht hinein passen. Vielleicht solltest du einen anderen Schlüssel ausprobieren.");
                            System.out.println();
                        }
                    }else{
                        System.out.println("Hier ist nichts, was du aufschließen könntest.");
                        System.out.println();
                    }
                }else{
                    System.out.println("Hiermit kann man nichts aufschließen: "+neuerHeld.Hand[0].getName()+"("+neuerHeld.Hand[0].getPreis()+" Münzen)"+".");
                    System.out.println();
                }
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    } 

    private void lesen(Command command){
        if(istErstellt==true){
            if(neuerHeld.getHand()==null){
                System.out.println("Du hast nichts in deiner Hand, was willst du da lesen?");
                System.out.println();
            }else{
                if(neuerHeld.Hand[0].getText()==""){
                    System.out.println("Hier steht nichts drauf: "+neuerHeld.Hand[0].getName());
                    System.out.println();
                }else{
                    System.out.println("Auf dem Gegenstand in deiner Hand steht: "+ neuerHeld.Hand[0].getText());
                    System.out.println();
                }
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    } 

    private void waren(Command command){
        if(istErstellt==true){
            int x= neuerHeld.getxPos();
            int y= neuerHeld.getyPos();
            if(neueWelt.welt[x][y].haendler[0]==null){
                System.out.println("Hier ist kein Händler!");
                System.out.println();
            }else{
                System.out.println("Die Fächer des Händlers:");
                System.out.println();
                for(int i=1;i<5;i++){
                    if(neueWelt.welt[x][y].haendler[0].Waren[i-1]==null){
                        System.out.println("In Fach "+i+"/4 Fach liegt nichts.");
                        System.out.println();
                    }else{
                        System.out.println("In Fach "+i+"/4 Fach liegt: "+neueWelt.welt[x][y].haendler[0].Waren[i-1].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[i-1].getPreis()+")");
                        System.out.println();
                    }
                }
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }

    private void kaufen(Command command){
        if(istErstellt==true){
            int x= neuerHeld.getxPos();
            int y= neuerHeld.getyPos();
            if(neueWelt.welt[x][y].haendler[0]==null){
                System.out.println("Hier ist kein Händler!");
                System.out.println();
            }else{
                if(!command.hasSecondWord()) {
                    System.out.println("Welche Ware des Händlers willst du kaufen?");
                    System.out.println();
                    return;
                }

                String warennummer = command.getSecondWord();

                if(warennummer.equals("1")) {
                    if(neueWelt.welt[x][y].haendler[0].Waren[0]==null){
                        System.out.println("In diesem Ladenfach liegt nichts.");
                        System.out.println();
                    }else{
                        if(neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()>neuerHeld.getGeld()){
                            System.out.println("Du hast nur "+neuerHeld.getGeld()+" Münzen, brauchst aber "+"("+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+")"+"." );
                            System.out.println();
                        }else{
                            if(neuerHeld.Rucksack[0]==null){
                                System.out.println("Im Fach 1 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+")");
                                System.out.println();
                                neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                                System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                System.out.println();
                                neuerHeld.Rucksack[0]=neueWelt.welt[x][y].haendler[0].Waren[0];
                                neueWelt.welt[x][y].haendler[0].Waren[0]=null;
                            }else{
                                if(neuerHeld.Rucksack[1]==null){
                                    System.out.println("Im Fach 2 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+")");
                                    System.out.println();
                                    neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                                    System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                    System.out.println();
                                    neuerHeld.Rucksack[1]=neueWelt.welt[x][y].haendler[0].Waren[0];
                                    neueWelt.welt[x][y].haendler[0].Waren[0]=null;
                                }else{
                                    if(neuerHeld.Rucksack[2]==null){
                                        System.out.println("Im Fach 3 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+")");
                                        System.out.println();
                                        neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                                        System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                        System.out.println();
                                        neuerHeld.Rucksack[2]=neueWelt.welt[x][y].haendler[0].Waren[0];
                                        neueWelt.welt[x][y].haendler[0].Waren[0]=null;
                                    }else{
                                        if(neuerHeld.Rucksack[3]==null){
                                            System.out.println("Im Fach 4 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+")");
                                            System.out.println();
                                            neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                                            System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                            System.out.println();
                                            neuerHeld.Rucksack[3]=neueWelt.welt[x][y].haendler[0].Waren[0];
                                            neueWelt.welt[x][y].haendler[0].Waren[0]=null;
                                        }else{
                                            if(neuerHeld.Rucksack[4]==null){
                                                System.out.println("Im Fach 5 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+")");
                                                System.out.println();
                                                neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                                                System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                System.out.println();
                                                neuerHeld.Rucksack[4]=neueWelt.welt[x][y].haendler[0].Waren[0];
                                                neueWelt.welt[x][y].haendler[0].Waren[0]=null;
                                            }else{
                                                if(neuerHeld.Rucksack[5]==null){
                                                    System.out.println("Im Fach 6 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+")");
                                                    System.out.println();
                                                    neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                                                    System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                    System.out.println();
                                                    neuerHeld.Rucksack[5]=neueWelt.welt[x][y].haendler[0].Waren[0];
                                                    neueWelt.welt[x][y].haendler[0].Waren[0]=null;
                                                }else{
                                                    if(neuerHeld.Rucksack[6]==null){
                                                        System.out.println("Im Fach 7 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+")");
                                                        System.out.println();
                                                        neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                                                        System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                        System.out.println();
                                                        neuerHeld.Rucksack[6]=neueWelt.welt[x][y].haendler[0].Waren[0];
                                                        neueWelt.welt[x][y].haendler[0].Waren[0]=null;
                                                    }else{
                                                        if(neuerHeld.Rucksack[7]==null){
                                                            System.out.println("Im Fach 8 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+")");
                                                            System.out.println();
                                                            neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                                                            System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                            System.out.println();
                                                            neuerHeld.Rucksack[7]=neueWelt.welt[x][y].haendler[0].Waren[0];
                                                            neueWelt.welt[x][y].haendler[0].Waren[0]=null;
                                                        }else{
                                                            if(neuerHeld.Rucksack[8]==null){
                                                                System.out.println("Im Fach 9 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+")");
                                                                System.out.println();
                                                                neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                                                                System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                                System.out.println();
                                                                neuerHeld.Rucksack[8]=neueWelt.welt[x][y].haendler[0].Waren[0];
                                                                neueWelt.welt[x][y].haendler[0].Waren[0]=null;
                                                            }else{
                                                                if(neuerHeld.Rucksack[9]==null){
                                                                    System.out.println("Im Fach 10 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+")");
                                                                    System.out.println();
                                                                    neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                                                                    System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                                    System.out.println();
                                                                    neuerHeld.Rucksack[9]=neueWelt.welt[x][y].haendler[0].Waren[0];
                                                                    neueWelt.welt[x][y].haendler[0].Waren[0]=null;
                                                                }else{
                                                                    System.out.println("Du hast keinen Platz in deinem Rucksack!");
                                                                    System.out.println();
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
                        }
                    }
                }
                if(warennummer.equals("2")) {
                    if(neueWelt.welt[x][y].haendler[0].Waren[1]==null){
                        System.out.println("In diesem Ladenfach liegt nichts.");
                        System.out.println();
                    }else{
                        if(neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()>neuerHeld.getGeld()){
                            System.out.println("Du hast nur "+neuerHeld.getGeld()+" Münzen, brauchst aber "+"("+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+")"+"." );
                            System.out.println();
                        }else{
                            if(neuerHeld.Rucksack[0]==null){
                                System.out.println("Im Fach 1 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+")");
                                System.out.println();
                                neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                System.out.println();
                                neuerHeld.Rucksack[0]=neueWelt.welt[x][y].haendler[0].Waren[1];
                                neueWelt.welt[x][y].haendler[0].Waren[1]=null;
                            }else{
                                if(neuerHeld.Rucksack[1]==null){
                                    System.out.println("Im Fach 2 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+")");
                                    System.out.println();
                                    neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                    System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                    System.out.println();
                                    neuerHeld.Rucksack[1]=neueWelt.welt[x][y].haendler[0].Waren[1];
                                    neueWelt.welt[x][y].haendler[0].Waren[1]=null;
                                }else{
                                    if(neuerHeld.Rucksack[2]==null){
                                        System.out.println("Im Fach 3 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+")");
                                        System.out.println();
                                        neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                        System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                        System.out.println();
                                        neuerHeld.Rucksack[2]=neueWelt.welt[x][y].haendler[0].Waren[1];
                                        neueWelt.welt[x][y].haendler[0].Waren[1]=null;
                                    }else{
                                        if(neuerHeld.Rucksack[3]==null){
                                            System.out.println("Im Fach 4 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+")");
                                            System.out.println();
                                            neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                            System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                            System.out.println();
                                            neuerHeld.Rucksack[3]=neueWelt.welt[x][y].haendler[0].Waren[1];
                                            neueWelt.welt[x][y].haendler[0].Waren[1]=null;
                                        }else{
                                            if(neuerHeld.Rucksack[4]==null){
                                                System.out.println("Im Fach 5 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+")");
                                                System.out.println();
                                                neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                                System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                System.out.println();
                                                neuerHeld.Rucksack[4]=neueWelt.welt[x][y].haendler[0].Waren[1];
                                                neueWelt.welt[x][y].haendler[0].Waren[1]=null;
                                            }else{
                                                if(neuerHeld.Rucksack[5]==null){
                                                    System.out.println("Im Fach 6 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+")");
                                                    System.out.println();
                                                    neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                                    System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                    System.out.println();
                                                    neuerHeld.Rucksack[5]=neueWelt.welt[x][y].haendler[0].Waren[1];
                                                    neueWelt.welt[x][y].haendler[0].Waren[1]=null;
                                                }else{
                                                    if(neuerHeld.Rucksack[6]==null){
                                                        System.out.println("Im Fach 7 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+")");
                                                        System.out.println();
                                                        neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                                        System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                        System.out.println();
                                                        neuerHeld.Rucksack[6]=neueWelt.welt[x][y].haendler[0].Waren[1];
                                                        neueWelt.welt[x][y].haendler[0].Waren[1]=null;
                                                    }else{
                                                        if(neuerHeld.Rucksack[7]==null){
                                                            System.out.println("Im Fach 8 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+")");
                                                            System.out.println();
                                                            neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                                            System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                            System.out.println();
                                                            neuerHeld.Rucksack[7]=neueWelt.welt[x][y].haendler[0].Waren[1];
                                                            neueWelt.welt[x][y].haendler[0].Waren[1]=null;
                                                        }else{
                                                            if(neuerHeld.Rucksack[8]==null){
                                                                System.out.println("Im Fach 9 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+")");
                                                                System.out.println();
                                                                neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                                                System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                                System.out.println();
                                                                neuerHeld.Rucksack[8]=neueWelt.welt[x][y].haendler[0].Waren[1];
                                                                neueWelt.welt[x][y].haendler[0].Waren[1]=null;
                                                            }else{
                                                                if(neuerHeld.Rucksack[9]==null){
                                                                    System.out.println("Im Fach 10 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+")");
                                                                    System.out.println();
                                                                    neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                                                    System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                                    System.out.println();
                                                                    neuerHeld.Rucksack[9]=neueWelt.welt[x][y].haendler[0].Waren[1];
                                                                    neueWelt.welt[x][y].haendler[0].Waren[1]=null;
                                                                }else{
                                                                    System.out.println("Du hast keinen Platz in deinem Rucksack!");
                                                                    System.out.println();
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
                        }
                    }
                }
                if(warennummer.equals("3")) {
                    if(neueWelt.welt[x][y].haendler[0].Waren[2]==null){
                        System.out.println("In diesem Ladenfach liegt nichts.");
                        System.out.println();
                    }else{
                        if(neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()>neuerHeld.getGeld()){
                            System.out.println("Du hast nur "+neuerHeld.getGeld()+" Münzen, brauchst aber "+"("+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+")"+"." );
                            System.out.println();
                        }else{
                            if(neuerHeld.Rucksack[0]==null){
                                System.out.println("Im Fach 1 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+")");
                                System.out.println();
                                neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                System.out.println();
                                neuerHeld.Rucksack[0]=neueWelt.welt[x][y].haendler[0].Waren[2];
                                neueWelt.welt[x][y].haendler[0].Waren[2]=null;
                            }else{
                                if(neuerHeld.Rucksack[1]==null){
                                    System.out.println("Im Fach 2 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+")");
                                    System.out.println();
                                    neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                    System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                    System.out.println();
                                    neuerHeld.Rucksack[1]=neueWelt.welt[x][y].haendler[0].Waren[2];
                                    neueWelt.welt[x][y].haendler[0].Waren[2]=null;
                                }else{
                                    if(neuerHeld.Rucksack[2]==null){
                                        System.out.println("Im Fach 3 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+")");
                                        System.out.println();
                                        neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                        System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                        System.out.println();
                                        neuerHeld.Rucksack[2]=neueWelt.welt[x][y].haendler[0].Waren[2];
                                        neueWelt.welt[x][y].haendler[0].Waren[2]=null;
                                    }else{
                                        if(neuerHeld.Rucksack[3]==null){
                                            System.out.println("Im Fach 4 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+")");
                                            System.out.println();
                                            neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                            System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                            System.out.println();
                                            neuerHeld.Rucksack[3]=neueWelt.welt[x][y].haendler[0].Waren[2];
                                            neueWelt.welt[x][y].haendler[0].Waren[2]=null;
                                        }else{
                                            if(neuerHeld.Rucksack[4]==null){
                                                System.out.println("Im Fach 5 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+")");
                                                System.out.println();
                                                neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                                System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                System.out.println();
                                                neuerHeld.Rucksack[4]=neueWelt.welt[x][y].haendler[0].Waren[2];
                                                neueWelt.welt[x][y].haendler[0].Waren[2]=null;
                                            }else{
                                                if(neuerHeld.Rucksack[5]==null){
                                                    System.out.println("Im Fach 6 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+")");
                                                    System.out.println();
                                                    neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                                    System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                    System.out.println();
                                                    neuerHeld.Rucksack[5]=neueWelt.welt[x][y].haendler[0].Waren[2];
                                                    neueWelt.welt[x][y].haendler[0].Waren[2]=null;
                                                }else{
                                                    if(neuerHeld.Rucksack[6]==null){
                                                        System.out.println("Im Fach 7 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+")");
                                                        System.out.println();
                                                        neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                                        System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                        System.out.println();
                                                        neuerHeld.Rucksack[6]=neueWelt.welt[x][y].haendler[0].Waren[2];
                                                        neueWelt.welt[x][y].haendler[0].Waren[2]=null;
                                                    }else{
                                                        if(neuerHeld.Rucksack[7]==null){
                                                            System.out.println("Im Fach 8 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+")");
                                                            System.out.println();
                                                            neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                                            System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                            System.out.println();
                                                            neuerHeld.Rucksack[7]=neueWelt.welt[x][y].haendler[0].Waren[2];
                                                            neueWelt.welt[x][y].haendler[0].Waren[2]=null;
                                                        }else{
                                                            if(neuerHeld.Rucksack[8]==null){
                                                                System.out.println("Im Fach 9 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+")");
                                                                System.out.println();
                                                                neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                                                System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                                System.out.println();
                                                                neuerHeld.Rucksack[8]=neueWelt.welt[x][y].haendler[0].Waren[2];
                                                                neueWelt.welt[x][y].haendler[0].Waren[2]=null;
                                                            }else{
                                                                if(neuerHeld.Rucksack[9]==null){
                                                                    System.out.println("Im Fach 10 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+")");
                                                                    System.out.println();
                                                                    neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                                                    System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                                    System.out.println();
                                                                    neuerHeld.Rucksack[9]=neueWelt.welt[x][y].haendler[0].Waren[2];
                                                                    neueWelt.welt[x][y].haendler[0].Waren[2]=null;
                                                                }else{
                                                                    System.out.println("Du hast keinen Platz in deinem Rucksack!");
                                                                    System.out.println();
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
                        }
                    }
                }
                if(warennummer.equals("4")) {
                    if(neueWelt.welt[x][y].haendler[0].Waren[3]==null){
                        System.out.println("In diesem Ladenfach liegt nichts.");
                        System.out.println();
                    }else{
                        if(neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()>neuerHeld.getGeld()){
                            System.out.println("Du hast nur "+neuerHeld.getGeld()+" Münzen, brauchst aber "+"("+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+")"+"." );
                            System.out.println();
                        }else{
                            if(neuerHeld.Rucksack[0]==null){
                                System.out.println("Im Fach 1 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+")");
                                System.out.println();
                                neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                System.out.println();
                                neuerHeld.Rucksack[0]=neueWelt.welt[x][y].haendler[0].Waren[3];
                                neueWelt.welt[x][y].haendler[0].Waren[3]=null;
                            }else{
                                if(neuerHeld.Rucksack[1]==null){
                                    System.out.println("Im Fach 2 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+")");
                                    System.out.println();
                                    neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                    System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                    System.out.println();
                                    neuerHeld.Rucksack[1]=neueWelt.welt[x][y].haendler[0].Waren[3];
                                    neueWelt.welt[x][y].haendler[0].Waren[3]=null;
                                }else{
                                    if(neuerHeld.Rucksack[2]==null){
                                        System.out.println("Im Fach 3 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+")");
                                        System.out.println();
                                        neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                        System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                        System.out.println();
                                        neuerHeld.Rucksack[2]=neueWelt.welt[x][y].haendler[0].Waren[3];
                                        neueWelt.welt[x][y].haendler[0].Waren[3]=null;
                                    }else{
                                        if(neuerHeld.Rucksack[3]==null){
                                            System.out.println("Im Fach 4 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+")");
                                            System.out.println();
                                            neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                            System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                            System.out.println();
                                            neuerHeld.Rucksack[3]=neueWelt.welt[x][y].haendler[0].Waren[3];
                                            neueWelt.welt[x][y].haendler[0].Waren[3]=null;
                                        }else{
                                            if(neuerHeld.Rucksack[4]==null){
                                                System.out.println("Im Fach 5 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+")");
                                                System.out.println();
                                                neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                                System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                System.out.println();
                                                neuerHeld.Rucksack[4]=neueWelt.welt[x][y].haendler[0].Waren[3];
                                                neueWelt.welt[x][y].haendler[0].Waren[3]=null;
                                            }else{
                                                if(neuerHeld.Rucksack[5]==null){
                                                    System.out.println("Im Fach 6 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+")");
                                                    System.out.println();
                                                    neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                                    System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                    System.out.println();
                                                    neuerHeld.Rucksack[5]=neueWelt.welt[x][y].haendler[0].Waren[3];
                                                    neueWelt.welt[x][y].haendler[0].Waren[3]=null;
                                                }else{
                                                    if(neuerHeld.Rucksack[6]==null){
                                                        System.out.println("Im Fach 7 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+")");
                                                        System.out.println();
                                                        neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                                        System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                        System.out.println();
                                                        neuerHeld.Rucksack[6]=neueWelt.welt[x][y].haendler[0].Waren[3];
                                                        neueWelt.welt[x][y].haendler[0].Waren[3]=null;
                                                    }else{
                                                        if(neuerHeld.Rucksack[7]==null){
                                                            System.out.println("Im Fach 8 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+")");
                                                            System.out.println();
                                                            neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                                            System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                            System.out.println();
                                                            neuerHeld.Rucksack[7]=neueWelt.welt[x][y].haendler[0].Waren[3];
                                                            neueWelt.welt[x][y].haendler[0].Waren[3]=null;
                                                        }else{
                                                            if(neuerHeld.Rucksack[8]==null){
                                                                System.out.println("Im Fach 9 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+")");
                                                                System.out.println();
                                                                neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                                                System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                                System.out.println();
                                                                neuerHeld.Rucksack[8]=neueWelt.welt[x][y].haendler[0].Waren[3];
                                                                neueWelt.welt[x][y].haendler[0].Waren[3]=null;
                                                            }else{
                                                                if(neuerHeld.Rucksack[9]==null){
                                                                    System.out.println("Im Fach 10 deines Rucksacks befindet sich jetzt: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName()+"("+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+")");
                                                                    System.out.println();
                                                                    neuerHeld.setGeld(neuerHeld.getGeld()-neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                                                    System.out.println("Und du hast noch "+neuerHeld.getGeld()+" Münzen übrig.");
                                                                    System.out.println();
                                                                    neuerHeld.Rucksack[9]=neueWelt.welt[x][y].haendler[0].Waren[3];
                                                                    neueWelt.welt[x][y].haendler[0].Waren[3]=null;
                                                                }else{
                                                                    System.out.println("Du hast keinen Platz in deinem Rucksack!");
                                                                    System.out.println();
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
                        }
                    }
                }
            }
        }else{
            System.out.println("Du musst zuerst eine Klasse wählen!");
            System.out.println();
        }
    }

    private void verkaufen(Command command){
        if(istErstellt==true){
            int x= neuerHeld.getxPos();
            int y= neuerHeld.getyPos();
            if(neueWelt.welt[x][y].haendler[0]==null){
                System.out.println("Hier ist kein Händler!");
                System.out.println();
            }else{
                if(!command.hasSecondWord()) {
                    System.out.println("Aus welchem Fach aus deinem Rucksack soll etwas verkauft werden? Oder aus deiner Hand? Oder deine Rüstung?");
                    System.out.println();
                    return;
                }

                String fach = command.getSecondWord();

                if(fach.equals("1")) {
                    if(neuerHeld.Rucksack[0]!=null){
                        if(neueWelt.welt[x][y].haendler[0].Waren[0]==null){
                            neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[0],0);
                            neuerHeld.Rucksack[0]=null;
                            neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                            System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName());
                            System.out.println();
                            System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+" Münzen bekommen.");
                            System.out.println();
                        }else{
                            if(neueWelt.welt[x][y].haendler[0].Waren[1]==null){
                                neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[0],1);
                                neuerHeld.Rucksack[0]=null;
                                neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName());
                                System.out.println();
                                System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+" Münzen bekommen.");
                                System.out.println();
                            }else{
                                if(neueWelt.welt[x][y].haendler[0].Waren[2]==null){
                                    neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[0],2);
                                    neuerHeld.Rucksack[0]=null;
                                    neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                    System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName());
                                    System.out.println();
                                    System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+" Münzen bekommen.");
                                    System.out.println();
                                }else{
                                    if(neueWelt.welt[x][y].haendler[0].Waren[3]==null){
                                        neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[0],3);
                                        neuerHeld.Rucksack[0]=null;
                                        neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                        System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName());
                                        System.out.println();
                                        System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+" Münzen bekommen.");
                                        System.out.println();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+"Tut mir Leid, aber ich habe gerade keinen Platz für deine Gegenstände.");
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }else{
                        System.out.println("Hier ist nichts zum Verkaufen.");
                        System.out.println();
                    }
                }
                if(fach.equals("2")) {
                    if(neuerHeld.Rucksack[1]!=null){
                        if(neueWelt.welt[x][y].haendler[0].Waren[0]==null){
                            neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[1],0);
                            neuerHeld.Rucksack[1]=null;
                            neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                            System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName());
                            System.out.println();
                            System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+" Münzen bekommen.");
                            System.out.println();
                        }else{
                            if(neueWelt.welt[x][y].haendler[0].Waren[1]==null){
                                neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[1],1);
                                neuerHeld.Rucksack[1]=null;
                                neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName());
                                System.out.println();
                                System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+" Münzen bekommen.");
                                System.out.println();
                            }else{
                                if(neueWelt.welt[x][y].haendler[0].Waren[2]==null){
                                    neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[1],2);
                                    neuerHeld.Rucksack[1]=null;
                                    neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                    System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName());
                                    System.out.println();
                                    System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+" Münzen bekommen.");
                                    System.out.println();
                                }else{
                                    if(neueWelt.welt[x][y].haendler[0].Waren[3]==null){
                                        neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[1],3);
                                        neuerHeld.Rucksack[1]=null;
                                        neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                        System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName());
                                        System.out.println();
                                        System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+" Münzen bekommen.");
                                        System.out.println();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+"Tut mir Leid, aber ich habe gerade keinen Platz für deine Gegenstände.");
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }else{
                        System.out.println("Hier ist nichts zum Verkaufen.");
                        System.out.println();
                    }
                }
                if(fach.equals("3")) {
                    if(neuerHeld.Rucksack[2]!=null){
                        if(neueWelt.welt[x][y].haendler[0].Waren[0]==null){
                            neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[2],0);
                            neuerHeld.Rucksack[2]=null;
                            neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                            System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName());
                            System.out.println();
                            System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+" Münzen bekommen.");
                            System.out.println();
                        }else{
                            if(neueWelt.welt[x][y].haendler[0].Waren[1]==null){
                                neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[2],1);
                                neuerHeld.Rucksack[2]=null;
                                neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName());
                                System.out.println();
                                System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+" Münzen bekommen.");
                                System.out.println();
                            }else{
                                if(neueWelt.welt[x][y].haendler[0].Waren[2]==null){
                                    neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[2],2);
                                    neuerHeld.Rucksack[2]=null;
                                    neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                    System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName());
                                    System.out.println();
                                    System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+" Münzen bekommen.");
                                    System.out.println();
                                }else{
                                    if(neueWelt.welt[x][y].haendler[0].Waren[3]==null){
                                        neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[2],3);
                                        neuerHeld.Rucksack[2]=null;
                                        neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                        System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName());
                                        System.out.println();
                                        System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+" Münzen bekommen.");
                                        System.out.println();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+"Tut mir Leid, aber ich habe gerade keinen Platz für deine Gegenstände.");
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }else{
                        System.out.println("Hier ist nichts zum Verkaufen.");
                        System.out.println();
                    }
                }
                if(fach.equals("4")) {
                    if(neuerHeld.Rucksack[3]!=null){
                        if(neueWelt.welt[x][y].haendler[0].Waren[0]==null){
                            neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[3],0);
                            neuerHeld.Rucksack[3]=null;
                            neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                            System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName());
                            System.out.println();
                            System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+" Münzen bekommen.");
                            System.out.println();
                        }else{
                            if(neueWelt.welt[x][y].haendler[0].Waren[1]==null){
                                neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[3],1);
                                neuerHeld.Rucksack[3]=null;
                                neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName());
                                System.out.println();
                                System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+" Münzen bekommen.");
                                System.out.println();
                            }else{
                                if(neueWelt.welt[x][y].haendler[0].Waren[2]==null){
                                    neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[3],2);
                                    neuerHeld.Rucksack[3]=null;
                                    neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                    System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName());
                                    System.out.println();
                                    System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+" Münzen bekommen.");
                                    System.out.println();
                                }else{
                                    if(neueWelt.welt[x][y].haendler[0].Waren[3]==null){
                                        neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[3],3);
                                        neuerHeld.Rucksack[3]=null;
                                        neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                        System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName());
                                        System.out.println();
                                        System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+" Münzen bekommen.");
                                        System.out.println();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+"Tut mir Leid, aber ich habe gerade keinen Platz für deine Gegenstände.");
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }else{
                        System.out.println("Hier ist nichts zum Verkaufen.");
                        System.out.println();
                    }
                }
                if(fach.equals("5")) {
                    if(neuerHeld.Rucksack[4]!=null){
                        if(neueWelt.welt[x][y].haendler[0].Waren[0]==null){
                            neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[4],0);
                            neuerHeld.Rucksack[4]=null;
                            neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                            System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName());
                            System.out.println();
                            System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+" Münzen bekommen.");
                            System.out.println();
                        }else{
                            if(neueWelt.welt[x][y].haendler[0].Waren[1]==null){
                                neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[4],1);
                                neuerHeld.Rucksack[4]=null;
                                neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName());
                                System.out.println();
                                System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+" Münzen bekommen.");
                                System.out.println();
                            }else{
                                if(neueWelt.welt[x][y].haendler[0].Waren[2]==null){
                                    neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[4],2);
                                    neuerHeld.Rucksack[4]=null;
                                    neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                    System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName());
                                    System.out.println();
                                    System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+" Münzen bekommen.");
                                    System.out.println();
                                }else{
                                    if(neueWelt.welt[x][y].haendler[0].Waren[3]==null){
                                        neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[4],3);
                                        neuerHeld.Rucksack[4]=null;
                                        neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                        System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName());
                                        System.out.println();
                                        System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+" Münzen bekommen.");
                                        System.out.println();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+"Tut mir Leid, aber ich habe gerade keinen Platz für deine Gegenstände.");
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }else{
                        System.out.println("Hier ist nichts zum Verkaufen.");
                        System.out.println();
                    }
                }
                if(fach.equals("6")) {
                    if(neuerHeld.Rucksack[5]!=null){
                        if(neueWelt.welt[x][y].haendler[0].Waren[0]==null){
                            neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[5],0);
                            neuerHeld.Rucksack[5]=null;
                            neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                            System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName());
                            System.out.println();
                            System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+" Münzen bekommen.");
                            System.out.println();
                        }else{
                            if(neueWelt.welt[x][y].haendler[0].Waren[1]==null){
                                neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[5],1);
                                neuerHeld.Rucksack[5]=null;
                                neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName());
                                System.out.println();
                                System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+" Münzen bekommen.");
                                System.out.println();
                            }else{
                                if(neueWelt.welt[x][y].haendler[0].Waren[2]==null){
                                    neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[5],2);
                                    neuerHeld.Rucksack[5]=null;
                                    neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                    System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName());
                                    System.out.println();
                                    System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+" Münzen bekommen.");
                                    System.out.println();
                                }else{
                                    if(neueWelt.welt[x][y].haendler[0].Waren[3]==null){
                                        neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[5],3);
                                        neuerHeld.Rucksack[5]=null;
                                        neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                        System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName());
                                        System.out.println();
                                        System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+" Münzen bekommen.");
                                        System.out.println();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+"Tut mir Leid, aber ich habe gerade keinen Platz für deine Gegenstände.");
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }else{
                        System.out.println("Hier ist nichts zum Verkaufen.");
                        System.out.println();
                    }
                }
                if(fach.equals("7")) {
                    if(neuerHeld.Rucksack[6]!=null){
                        if(neueWelt.welt[x][y].haendler[0].Waren[0]==null){
                            neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[6],0);
                            neuerHeld.Rucksack[6]=null;
                            neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                            System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName());
                            System.out.println();
                            System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+" Münzen bekommen.");
                            System.out.println();
                        }else{
                            if(neueWelt.welt[x][y].haendler[0].Waren[1]==null){
                                neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[6],1);
                                neuerHeld.Rucksack[6]=null;
                                neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName());
                                System.out.println();
                                System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+" Münzen bekommen.");
                                System.out.println();
                            }else{
                                if(neueWelt.welt[x][y].haendler[0].Waren[2]==null){
                                    neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[6],2);
                                    neuerHeld.Rucksack[6]=null;
                                    neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                    System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName());
                                    System.out.println();
                                    System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+" Münzen bekommen.");
                                    System.out.println();
                                }else{
                                    if(neueWelt.welt[x][y].haendler[0].Waren[3]==null){
                                        neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[6],3);
                                        neuerHeld.Rucksack[6]=null;
                                        neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                        System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName());
                                        System.out.println();
                                        System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+" Münzen bekommen.");
                                        System.out.println();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+"Tut mir Leid, aber ich habe gerade keinen Platz für deine Gegenstände.");
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }else{
                        System.out.println("Hier ist nichts zum Verkaufen.");
                        System.out.println();
                    }
                }
                if(fach.equals("8")) {
                    if(neuerHeld.Rucksack[7]!=null){
                        if(neueWelt.welt[x][y].haendler[0].Waren[0]==null){
                            neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[7],0);
                            neuerHeld.Rucksack[7]=null;
                            neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                            System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName());
                            System.out.println();
                            System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+" Münzen bekommen.");
                            System.out.println();
                        }else{
                            if(neueWelt.welt[x][y].haendler[0].Waren[1]==null){
                                neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[7],1);
                                neuerHeld.Rucksack[7]=null;
                                neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName());
                                System.out.println();
                                System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+" Münzen bekommen.");
                                System.out.println();
                            }else{
                                if(neueWelt.welt[x][y].haendler[0].Waren[2]==null){
                                    neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[7],2);
                                    neuerHeld.Rucksack[7]=null;
                                    neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                    System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName());
                                    System.out.println();
                                    System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+" Münzen bekommen.");
                                    System.out.println();
                                }else{
                                    if(neueWelt.welt[x][y].haendler[0].Waren[3]==null){
                                        neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[7],3);
                                        neuerHeld.Rucksack[7]=null;
                                        neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                        System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName());
                                        System.out.println();
                                        System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+" Münzen bekommen.");
                                        System.out.println();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+"Tut mir Leid, aber ich habe gerade keinen Platz für deine Gegenstände.");
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }else{
                        System.out.println("Hier ist nichts zum Verkaufen.");
                        System.out.println();
                    }
                }
                if(fach.equals("9")) {
                    if(neuerHeld.Rucksack[8]!=null){
                        if(neueWelt.welt[x][y].haendler[0].Waren[0]==null){
                            neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[8],0);
                            neuerHeld.Rucksack[8]=null;
                            neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                            System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName());
                            System.out.println();
                            System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+" Münzen bekommen.");
                            System.out.println();
                        }else{
                            if(neueWelt.welt[x][y].haendler[0].Waren[1]==null){
                                neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[8],1);
                                neuerHeld.Rucksack[8]=null;
                                neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName());
                                System.out.println();
                                System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+" Münzen bekommen.");
                                System.out.println();
                            }else{
                                if(neueWelt.welt[x][y].haendler[0].Waren[2]==null){
                                    neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[8],2);
                                    neuerHeld.Rucksack[8]=null;
                                    neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                    System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName());
                                    System.out.println();
                                    System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+" Münzen bekommen.");
                                    System.out.println();
                                }else{
                                    if(neueWelt.welt[x][y].haendler[0].Waren[3]==null){
                                        neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[8],3);
                                        neuerHeld.Rucksack[8]=null;
                                        neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                        System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName());
                                        System.out.println();
                                        System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+" Münzen bekommen.");
                                        System.out.println();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+"Tut mir Leid, aber ich habe gerade keinen Platz für deine Gegenstände.");
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }else{
                        System.out.println("Hier ist nichts zum Verkaufen.");
                        System.out.println();
                    }
                }
                if(fach.equals("10")) {
                    if(neuerHeld.Rucksack[9]!=null){
                        if(neueWelt.welt[x][y].haendler[0].Waren[0]==null){
                            neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[9],0);
                            neuerHeld.Rucksack[9]=null;
                            neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                            System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName());
                            System.out.println();
                            System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+" Münzen bekommen.");
                            System.out.println();
                        }else{
                            if(neueWelt.welt[x][y].haendler[0].Waren[1]==null){
                                neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[9],1);
                                neuerHeld.Rucksack[9]=null;
                                neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName());
                                System.out.println();
                                System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+" Münzen bekommen.");
                                System.out.println();
                            }else{
                                if(neueWelt.welt[x][y].haendler[0].Waren[2]==null){
                                    neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[9],2);
                                    neuerHeld.Rucksack[9]=null;
                                    neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                    System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName());
                                    System.out.println();
                                    System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+" Münzen bekommen.");
                                    System.out.println();
                                }else{
                                    if(neueWelt.welt[x][y].haendler[0].Waren[3]==null){
                                        neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Rucksack[9],3);
                                        neuerHeld.Rucksack[9]=null;
                                        neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                        System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName());
                                        System.out.println();
                                        System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+" Münzen bekommen.");
                                        System.out.println();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+"Tut mir Leid, aber ich habe gerade keinen Platz für deine Gegenstände.");
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }else{
                        System.out.println("Hier ist nichts zum Verkaufen.");
                        System.out.println();
                    }
                }
                if(fach.equals("Hand")) {
                    if(neuerHeld.Hand[0]!=null){
                        if(neueWelt.welt[x][y].haendler[0].Waren[0]==null){
                            neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Hand[0],0);
                            neuerHeld.Hand[0]=null;
                            neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                            System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName());
                            System.out.println();
                            System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+" Münzen bekommen.");
                            System.out.println();
                        }else{
                            if(neueWelt.welt[x][y].haendler[0].Waren[1]==null){
                                neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Hand[0],1);
                                neuerHeld.Hand[0]=null;
                                neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName());
                                System.out.println();
                                System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+" Münzen bekommen.");
                                System.out.println();
                            }else{
                                if(neueWelt.welt[x][y].haendler[0].Waren[2]==null){
                                    neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Hand[0],2);
                                    neuerHeld.Hand[0]=null;
                                    neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                    System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName());
                                    System.out.println();
                                    System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+" Münzen bekommen.");
                                    System.out.println();
                                }else{
                                    if(neueWelt.welt[x][y].haendler[0].Waren[3]==null){
                                        neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Hand[0],3);
                                        neuerHeld.Hand[0]=null;
                                        neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                        System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName());
                                        System.out.println();
                                        System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+" Münzen bekommen.");
                                        System.out.println();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+"Tut mir Leid, aber ich habe gerade keinen Platz für deine Gegenstände.");
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }else{
                        System.out.println("Hier ist nichts zum Verkaufen.");
                        System.out.println();
                    }
                }
                if(fach.equals("Rüstung")) {
                    if(neuerHeld.Ruestung[0]!=null){
                        if(neueWelt.welt[x][y].haendler[0].Waren[0]==null){
                            neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Ruestung[0],0);
                            neuerHeld.Ruestung[0]=null;
                            neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis());
                            System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[0].getName());
                            System.out.println();
                            System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[0].getPreis()+" Münzen bekommen.");
                            System.out.println();
                        }else{
                            if(neueWelt.welt[x][y].haendler[0].Waren[1]==null){
                                neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Ruestung[0],1);
                                neuerHeld.Ruestung[0]=null;
                                neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis());
                                System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[1].getName());
                                System.out.println();
                                System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[1].getPreis()+" Münzen bekommen.");
                                System.out.println();
                            }else{
                                if(neueWelt.welt[x][y].haendler[0].Waren[2]==null){
                                    neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Ruestung[0],2);
                                    neuerHeld.Ruestung[0]=null;
                                    neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis());
                                    System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[2].getName());
                                    System.out.println();
                                    System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[2].getPreis()+" Münzen bekommen.");
                                    System.out.println();
                                }else{
                                    if(neueWelt.welt[x][y].haendler[0].Waren[3]==null){
                                        neueWelt.welt[x][y].haendler[0].setWaren(neuerHeld.Ruestung[0],3);
                                        neuerHeld.Ruestung[0]=null;
                                        neuerHeld.setGeld(neuerHeld.getGeld()+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis());
                                        System.out.println("Du hast verkauft: "+neueWelt.welt[x][y].haendler[0].Waren[3].getName());
                                        System.out.println();
                                        System.out.println("Und "+neueWelt.welt[x][y].haendler[0].Waren[3].getPreis()+" Münzen bekommen.");
                                        System.out.println();
                                    }else{
                                        System.out.println(neueWelt.welt[x][y].haendler[0].getName()+": "+"Tut mir Leid, aber ich habe gerade keinen Platz für deine Gegenstände.");
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }else{
                        System.out.println("Hier ist nichts zum Verkaufen.");
                        System.out.println();
                    }
                }
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

    private void questsPruefen(){
        if(neueWelt.welt[17][21].questgeber[0].questErfuellt()==false){
            if(neueWelt.welt[13][15].gegner[0]==null){
                neueWelt.welt[17][21].questgeber[0].setQuestErfuellt();
            }
        }
        
        if(neueWelt.welt[46][24].questgeber[0].questErfuellt()==false){
            if(neueWelt.welt[42][24].gegner[0]==null){
                neueWelt.welt[46][24].questgeber[0].setQuestErfuellt();
            }
        }

        if(neueWelt.welt[47][13].questgeber[0].questErfuellt()==false){
            int zaehler=0;
            for(int x=0; x<=49;x++){
                for(int y=0; y<=32;y++){
                    if(neueWelt.welt[x][y].gegner[0]==null){
                        zaehler++;
                    }
                }
            }
            if(zaehler==1650){
                neueWelt.welt[47][13].questgeber[0].setQuestErfuellt();
            }
        } 
    }
}