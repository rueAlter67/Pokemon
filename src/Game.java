import java.util.Scanner;
public class Game{
    
    private Creature[9] CMasterInventory; // will contain all the creatures 
    private Player CPlayer;
    private int nMenuChoice; 

    public void run() // instantiation ng mga class na need natin 
    {
       // this.CMasterInventory = new Creature; 
        //this.CPlayer = new Player(); 
    
    }

    // get players starter creature 


    public void displayMenu() 
    {
        Scanner CReader = new Scanner(System.in);
        int nMenuChoice = 0; 
        int nValid = 0;  
        System.out.print("\n\n\t\t\t=======MAIN MENU=======\n"+
                         "\t\t\t[1]  View Inventory\n" + 
                          "\t\t\t[2]  Area\n"+
                        "\t\t\t[2]  Area\n" +
                        "\t\t\t=======================\n");
        while(nValid == 0 )
        {
            System.out.print("\n\t\t\t[INPUT]: ");

            if(CReader.hasNextInt())
            {   
                nMenuChoice = CReader.nextInt();
                if(nMenuChoice >= 1 && nMenuChoice <= 4)
                {
                    nValid = 1; 
                    CReader.nextLine(); // buffer
                }
                else
                {
                    System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Choose 1 to 4 only.\n");
                    CReader.nextLine(); //buffer
                }
            }
            else
            {
                System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Invalid Input. Input must be an integer.\n");
                CReader.nextLine(); //buffer
            }
        }


        switch(nMenuChoice)
        {
            case 1: 
                    System.out.println("you are no in inventory interface");
                    break;
            case 2: 
                    System.out.println("you are no in area interface");
                    break;
            case 3: 
                    System.out.println("FEATURE NOT YET AVAILABLE");
                    break;
            case 4: 
                    exitGame();
                    break;
        }
    }

    public void exitGame()
    {
        System.out.println("You have exited the game.");
        System.exit(0);
    }

    

    // setters and getters 
    public void setnChoice(int nChoice) 
    {
        this.nMenuChoice = nChoice;
    }
    public int getnChoice() 
    {
        return this.nMenuChoice;
    }
}
