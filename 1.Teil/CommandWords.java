

public class CommandWords
{
    
    private static final String[] validCommands = {
        "Position","weiter","Magier","Schütze","Krieger","ausHandTun","gehNord","gehSued","gehWest","gehOst", "beenden", "hilfe", "nimm","rucksack","umsehen", "zeigHand","inHandTun", "fallenlassen", 
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
