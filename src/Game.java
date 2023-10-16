 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//import java.util.*;
public class Game{
    
 
    private Player CPlayer;
    private int nMenuChoice; 
    private Inventory CPlayerInventory = new Inventory();
    private Area CArea;
    /*
    list bellow is instantiation of initial creature list
    999 cause unlimited health, would have to change it for the enemy creatures health
    sa image ID i assigned it muna sa index nila sa MasterInventory
    */
    Creature CStrawander = new Creature(999, 0, "Strawander",'A',"Fire",1,true);
    Creature CChocowool = new Creature(999, 1,"Chocowool",'B',"Fire",1,false);
    Creature CParfwit = new Creature(999, 2,"Parfwit",'C',"Fire",1,false);
    Creature CBrownisaur = new Creature(999, 3,"Brownisaur",'D',"Grass",1,false);
    Creature CFrubat = new Creature(999, 4,"Frubat",'E',"Grass",1,false);
    Creature CMalts = new Creature(999, 5,"Malts",'F',"Grass",1,false);
    Creature CSquirpie = new Creature(999, 6,"Squirpie",'G',"Water",1,false);
    Creature CChocolite = new Creature(999, 7,"Chocolite",'H',"Water",1,false);
    Creature COshacone = new Creature(999, 8, "Oshacone",'I',"Water",1,false); 

    private Creature[] CMasterInventory = {
        CStrawander, 
        CChocowool,
        CParfwit,
        CBrownisaur,
        CFrubat,
        CMalts,
        CSquirpie,
        CChocolite,
        COshacone,
    };
        ArrayList<Creature> aStarterCreatures = new ArrayList<>(Arrays.asList(CMasterInventory));
        ArrayList<Creature> aCapturedCreatures = new ArrayList<Creature>();

        int nIndex = 0; //for testing
        int nIndex2 = 1; //for testing

        Creature CChosenCreature = CMasterInventory[nIndex]; //for testing
        Creature CChosenCreature2 = CMasterInventory[nIndex2]; //for testing (scroll down to nMenuChoice == 1 for reference)

    public void run() // instantiation ng mga class na need natin 
    {
        //this.CPlayer = new Player(); 
        this.CPlayer = new Player(); 
        this.CArea = new Area(this.CPlayer);

    }

    public void displayMenu() 
    {

        Scanner CReader = new Scanner(System.in);
        int nMenuChoice = 0; 
        int nValid = 0;  
        int nAreaChoice = 0; 
        System.out.print("\n\n\t\t\t=======MAIN MENU=======\n"+
                         "\t\t\t[1]  View Inventory\n" + 
                          "\t\t\t[2]  Area\n"+
                        "\t\t\t[3]  Evolve Creature\n" +
                        "\t\t\t[4]  Exit\n" +
                        "\t\t\t=======================\n");
        while(nValid == 0)
        {
            System.out.print("\n\t\t\t[INPUT]: ");

            if(CReader.hasNextInt())
            {   
                nMenuChoice = CReader.nextInt();
                if(nMenuChoice >= 1 && nMenuChoice <= 4)
                    nValid = 1;
                else
                    System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Choose 1 to 4 only.\n");
            }
            else
                System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Invalid Input. Input must be an integer.\n");
        }
            CReader.nextLine(); // buffer
        
        if(nMenuChoice==1)
        {
            CPlayerInventory.addCreature(aCapturedCreatures,CChosenCreature); //for testing of aCapturedCreatures not empty
            CPlayerInventory.addCreature(aCapturedCreatures,CChosenCreature2); //for testing of aCapturedCreatures not empty
            int nlength = aCapturedCreatures.size();
			int nInput = CPlayerInventory.displayInventory(CPlayerInventory,nlength,aCapturedCreatures); 
               
            if(nInput == 1)
            {
                boolean bFlag = false;
                Scanner CStringScanner = new Scanner(System.in);
                System.out.print("Type Name of Creatures to Swap: "+ "\n");
                System.out.print("Creature 1: ");
                String strCreatureA = CStringScanner.nextLine();
                System.out.print("Creature 2: ");
                String strCreatureB = CStringScanner.nextLine();

                while(bFlag == false)
                {
                Creature CChosenCreatureA = CPlayerInventory.findCreature(aCapturedCreatures, strCreatureA, nlength);
                Creature CChosenCreatureB = CPlayerInventory.findCreature(aCapturedCreatures, strCreatureB, nlength);

                if(CChosenCreatureA != null && CChosenCreatureB  != null)
                {
                    CPlayerInventory.swapCreature(CChosenCreatureA, CChosenCreatureB);
                    bFlag = true;
                    System.out.print("Active Creature Changed.");
                }
                else
                    System.out.print("Invalid Creature (Check Name or if Active)");
                }
                CPlayerInventory.displayInventory(CPlayerInventory,nlength,aCapturedCreatures);
            }
            else if(nInput == 2)
            {
                CPlayerInventory.returnToMainMenu();
            }
            else
                System.out.print("Invalid Action");
		}
		else if(nMenuChoice == 2)
		{ 
			CArea.run();
		}
		else if(nMenuChoice == 3)
		{
			System.out.println("\n\t\t\t\t[SYSTEM MESSAGE]: FEATURE NOT YET AVAILABLE");
		} 
        else 
			exitGame();
    }

    public void exitGame()
    {
        System.out.println("\n\n\t\tYou have exited the game.");
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
