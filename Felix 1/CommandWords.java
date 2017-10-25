
public class CommandWords
{

    private static final String[] validCommands = {
            "status","fliehen","angreifen","Karte","weiter","Magier","Schütze","Krieger","ausHandTun","gehNord","gehSued","gehWest","gehOst", "beenden", "hilfe", "nimm","rucksack","umsehen", "zeigHand","inHandTun","anziehen","ausziehen", "fallenlassen","kombo", 
        };

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
