public class Driver 
{

    public static void main(String[] args)
    {
        Game CGame = new Game();

        CGame.run();
        
        do{
            CGame.displayMenu();
        }while(CGame.getnChoice() != 4);

    }


}