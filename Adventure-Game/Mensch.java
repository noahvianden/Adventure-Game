public class Mensch
{
    // HP = Lebenspunkte; HPr = Lebensregeneration; H = Hunger; D = Durst; G = Gold; Do = Dodge; Mvs = Movementspeed; T = Tragfähigkeit; Ge = Geschicklichkeit;
    
    public String Name;
    public int HP;
    public int HPr;
    public int H;
    public int D;
    public int G;
    public int Do;
    public int Mvs;
    public int T;
    public int Ge;
    
    public Mensch Krieger;
    public Mensch Magier;
    public Mensch Schütze;
    
    public void Start()
    {
        Krieger = new Mensch();
        Magier = new Mensch();
        Schütze = new Mensch();
    }
}
