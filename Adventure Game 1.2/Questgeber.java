public class Questgeber extends LebendigeSpielObjekte
{
    private boolean questErfuellt = false;
    private String begruessungErste;
    private String begruessungNachErste;
    private String textQuestFertig;
    private String textNachQuest;
    private int anzahlBesuche = 0;
    private int anzahlBesucheNachQuest = 0;
    private String name;

    public Questgeber(String pName, String pBegruessungErste, String pBegruessungNachErste, String pTextQuestFertig, String pTextNachQuest)
    {
        name=pName;
        begruessungErste=pBegruessungErste;
        begruessungNachErste=pBegruessungNachErste;
        textQuestFertig=pTextQuestFertig;
        textNachQuest=pTextNachQuest;
    }

    public String getBegruessungErste(){
        return begruessungErste;
    }

    public String getBegruessungNachErste(){
        return begruessungNachErste;
    }

    public void anzahlBesucheErhoehen(){
        anzahlBesuche++;
    }
    
    public void anzahlBesucheNachQuestErhoehen(){
        anzahlBesucheNachQuest++;
    }

    public int getAnzahlBesuche(){
        return anzahlBesuche;
    }
    
    public int getAnzahlBesucheNachQuest(){
        return anzahlBesucheNachQuest;
    }

    public void setQuestErfuellt(){
        questErfuellt=true;
    }

    public boolean questErfuellt(){
        return questErfuellt;
    }
    
    public String getName(){
        return name;
    }
    
    public String getTextQuestFertig(){
        return textQuestFertig;
    }
    
    public String getTextNachQuest(){
        return textNachQuest;
    }

}
