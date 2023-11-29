 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//import java.util.*;
public class Game{
    
    private Player CPlayer;
    private int nMenuChoice; 
    private Inventory CPlayerInventory = new Inventory();
    private Area CArea;

    ArrayList<CapturedCreature> aCapturedCreatures = new ArrayList<CapturedCreature>();
    
    /**
     * This method starts the entire game. 
     */
    public void run(ArrayList<Creature> CMasterInventory) // instantiation ng mga class na need natin 
    {
        this.CPlayer = new Player(); 
        this.CArea = new Area(this.CPlayer, CMasterInventory);

    }

        //+++++++++++
    /* chooseStarterCreature will display a list of EL1 creature
     * from the MasterInventory and then 
     * add this Creature to the inventory
     * if addingStarter creature is successful add to 
     * Inventory of the player. 
     */
    public boolean chooseStarterCreature(ArrayList<Creature> CMasterInventory)
    {
        boolean isValidFamily = false;
        Scanner CCharScanner = new Scanner(System.in);
        char cFamily = '0';
        System.out.print("//\\//\\//\\//\\//\\//\\//\\//\n");
        System.out.print("\\Choose Your Starter!\\\n");
        System.out.print("//\\//\\//\\//\\//\\//\\//\\//\n");
        int i;

         for(i=0;i<9;i++)
         {
            CPlayerInventory.displayCreatureImage(CMasterInventory.get(i));
            System.out.print("\t");
            CPlayerInventory.displayCreatureNames(CMasterInventory.get(i));
            System.out.print("\t");
            CPlayerInventory.displayCreatureType(CMasterInventory.get(i));
            System.out.print("\t");
            CPlayerInventory.displayCreatureFamilies(CMasterInventory.get(i));
            System.out.print("\n");
         }
         while (!isValidFamily) {

            System.out.print("Enter Creature Family: ");
             cFamily = CCharScanner.next().charAt(0);
         
                if (cFamily >= 'A' && cFamily <= 'I') 
                {
                    isValidFamily = true;
                } else 
                    System.out.println("[SYSTEM MESSAGE]: Invalid Family");
            }

            System.out.println("[SYSTEM MESSAGE]: Are you sure you want to choose the " + cFamily + " family Creature? [Y]es / [N]o");
            char cAnswer = CCharScanner.next().charAt(0);

         if (cAnswer == 'Y' || cAnswer == 'y') {
            Creature CStarterCreature = CPlayerInventory.findCreatureByFamily(CMasterInventory, cFamily, CMasterInventory.size());
                if (CStarterCreature != null) 
                {
                CPlayerInventory.addCreature(aCapturedCreatures, CStarterCreature);
                aCapturedCreatures.get(0).setActiveCreature(true);
                //CCharScanner.close();
                }
        } else {
         chooseStarterCreature(CMasterInventory);
         //CCharScanner.close();
        }


        return true; 
    }

    /**
     * This method displays the Main Menu of the game 
     */
    public void displayMenu(ArrayList<Creature> CMasterInventory) 
    {

        Scanner CReader = new Scanner(System.in);
        int nMenuChoice = 0; 
        int nValid = 0;  
        int nAreaChoice = 0; 
        int nMovement; 
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
        int nIndex = 0; //for testing
        int nIndex2 = 1; //for testing

        CapturedCreature CChosenCreature = new CapturedCreature(CMasterInventory.get(nIndex));

        CapturedCreature CChosenCreature2 = new CapturedCreature(CMasterInventory.get(nIndex2)); //for testing (scroll down to nMenuChoice == 1 for reference)
            CPlayerInventory.addCreature(aCapturedCreatures,CChosenCreature);
            CPlayerInventory.addCreature(aCapturedCreatures,CChosenCreature2); //for testing of aCapturedCreatures not empty
            int nlength = aCapturedCreatures.size();

            boolean bExitInventory = false;
            while (!bExitInventory) 
            {
                int nInput = CPlayerInventory.displayInventory(CPlayerInventory,nlength,aCapturedCreatures); 
               
                if(nInput == 1)
                {
                    Scanner CIntScanner = new Scanner(System.in);
                    System.out.print("Type Numbers of Creatures to Swap: "+ "\n");
                    System.out.print("Creature 1: ");
                    int nCreatureA = CIntScanner.nextInt();
                    System.out.print("Creature 2: ");
                    int nCreatureB = CIntScanner.nextInt();
                    CIntScanner.nextLine();

                    CapturedCreature CChosenCreatureA = CPlayerInventory.findCreaturebyIndex(aCapturedCreatures, nCreatureA, nlength);
                    CapturedCreature CChosenCreatureB = CPlayerInventory.findCreaturebyIndex(aCapturedCreatures, nCreatureB, nlength);
                    boolean bCreatureAActive = CChosenCreatureA.getActiveCreature();
                    boolean bCreatureBActive = CChosenCreatureB.getActiveCreature();

                    if(CChosenCreatureA != null && CChosenCreatureB != null && bCreatureAActive == true || bCreatureBActive == true)
                    {
                        CPlayerInventory.swapCreature(CChosenCreatureA, CChosenCreatureB);
                        System.out.print("[SYSTEM MESSAGE]:Active Creature Changed.");
                    }
                    else
                        System.out.print("[SYSTEM MESSAGE]:Invalid Creature (Check Number or if Active)");


                }
                else if(nInput == 2)
                {
                    bExitInventory = true;
                }
                else
                    System.out.print("[SYSTEM MESSAGE]: Invalid Action");
		    }

            if(bExitInventory)
            {
                displayMenu(CMasterInventory);
            }
        }
		else if(nMenuChoice == 2)
		{ 
			CArea.run();    
            do{
                nMovement = CArea.loadArea(CPlayerInventory.getAllCapturedCreatures(aCapturedCreatures), CPlayerInventory);
            }while(nMovement != 5);

            if(nMovement == 5)
                displayMenu(CMasterInventory);
		}
		else if(nMenuChoice == 3)
		{
			System.out.println("\n\t\t\t\t[SYSTEM MESSAGE]: FEATURE NOT YET AVAILABLE");
		} 
        else 
        {
            CReader.close();
			exitGame();
        }
            
    }

    /**
     * This method termiantes the game.
     */
    public void exitGame()
    {
        System.out.println("\n\n\t\t[FINAL MESSAGE]:You have exited the game.");
        System.exit(0);
    }

    /**
     * This method sets the choice of the main menu
     * @param nChoice   integer value containing the choice
     */
    public void setnChoice(int nChoice)
    {
        this.nMenuChoice = nChoice;
    }

    /**
     * This method gets the choice of the main menu
     * @return the integer value of choice
     */
    public int getnChoice()
    {
        return this.nMenuChoice;
    }

    // /**
    //  * This method gets all the creatures to be used throughout the game
    //  * @return      an array of creatures 
    //  */
    // public ArrayList<Creature> Game.getAllCreatures(){
        
    //     return this.CMasterInventory;
    // }
}

