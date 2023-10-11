import java.util.Scanner;
public class Game {
    
    private Creature[] CMasterInventory; // will contain all the creatures 
    private Player CPlayer;
    private int nMenuChoice; 

    public void run()
    {
        this.CMasterInventory = new Creature; 
        this.CPlayer = new Player(); 
    }

    public void displayPreMenu() 
    {
        int nChoice; 

        System.out.print();
    }

    public void displayMenu() 
    {
        Scanner CReader = new Scanner(System.in);

        int nMenuChoice;
        int nValid = 0;  
        System.out.print("\n\n\t\t\t=======MAIN MENU=======\n"+
                         "\t\t\t[1]  View Inventory\n" + 
                          "\t\t\t[2]  Area\n"+
                        "\t\t\t[2]  Area\n" +
                        "\t\t\t=======================\n");
        while(nValid == 0 )
        {
            System.out.println("\n\t\t\t[INPUT]: ");

            if(CReader.hasNextInt())
            {
                nMenuChoice = CReader.nextInt();
                nValid = 1; 
                CReader.nextLine(); // buffer
                this.nMenuChoice = nMenuChoice;
            }
            else
            {
                System.err.println("[SYSTEM MESSAGE]: Invalid Input.\n Input must be an integer only.\n");
                CReader.nextLine(); //buffer
            }
        }


        switch(this.nMenuChoice)
        {
            case 1: 
                    System.out.println("you are no in inventory interface");
                    break;
            case 2: 
                    System.out.println("you are no in area interface");
                    break;
            case 3: System.out.println"FEATURE NOT YET AVAILABLE");
                    break;
            case 4: 
                    exitGame();
                    break;
        }
    }

    public void exitGame()
    {
        System.out.println("You have exited the game.");

    }

    























    // setters and getters 
    public void setnChoice(int nChoice) 
    {
        this.nChoice = nChoice;
    }
    public int getnChoice() 
    {
        return nChoice;
    }
}
