import java.util.ArrayList;

public class Driver 
{
    /**
     * This program kick starts the entire program
     * @param args
     */
    public static void main(String[] args)
    {
        Game CGame = new Game();

        CGame.run();
        CGame.chooseStarterCreature();
        CGame.displayMenu();
    }

}