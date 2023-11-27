import java.util.ArrayList;

public class Driver 
{

    
    /** 
     * @param args
     */
    public static void main(String[] args)
    {
        Game CGame = new Game();

        ArrayList<Creature> CMasterInventory = new ArrayList<>();

        CGame.run(CMasterInventory);
        CGame.chooseStarterCreature(CMasterInventory);
        CGame.displayMenu(CMasterInventory);
       
    }

}