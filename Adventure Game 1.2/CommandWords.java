
public class CommandWords
{

    private static final String[] validCommands = {
            "lesen","loeschen","status","fliehen","angreifen","aufschliessen","Magier","Schütze","Krieger","ausHand","w","s","a","d", "beenden", "hilfe", "nimm","rucksack","umsehen", "zeigHand","inHand","anziehen","ausziehen", "fallenlassen","kombo","kaufen","verkaufen","waren"};

    public CommandWords()
    {

    }

    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }

        return false;
    }
}
