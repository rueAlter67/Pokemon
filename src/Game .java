import java.util.Scanner;
public class Game {

    
    private Creature[] CMasterInventory; // will contain all the creatures 
    private Player CPlayer;
    private int nChoice; 

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
        int nMenuChoice;
        int nValid = 0;  
        System.out.print("\n\n\t\t\t=======MAIN MENU=======\n"+
                         "\t\t\t[1]  View Inventory\n" + 
                          "\t\t\t[2]  Area\n"+
                        "\t\t\t[2]  Area\n" +
                        "\t\t\t=======================\n");
        while(nValid)
         "\n\t\t\t[INPUT]: ");
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
