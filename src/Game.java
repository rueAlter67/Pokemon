 
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
    Creature CStrawander = new Creature(999, 0, "Strawander",'A',"Fire",1,false);
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
        this.CArea = new Area(this.CPlayer,getAllCreatures() );
    }

        //+++++++++++
    /* chooseStarterCreature will display a list of EL1 creature
     * from the MasterInventory and then 
     * add this Creature to the inventory
     * if addingStarter creature is successful add to 
     * Inventory of the player. 
     */
    public boolean chooseStarterCreature()
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
            CPlayerInventory.displayCreatureImage(aStarterCreatures.get(i));
            System.out.print("\t");
            CPlayerInventory.displayCreatureNames(aStarterCreatures.get(i));
            System.out.print("\t");
            CPlayerInventory.displayCreatureType(aStarterCreatures.get(i));
            System.out.print("\t");
            CPlayerInventory.displayCreatureFamilies(aStarterCreatures.get(i));
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
            Creature CStarterCreature = CPlayerInventory.findCreatureByFamily(aStarterCreatures, cFamily, aStarterCreatures.size());
                if (CStarterCreature != null) 
                {
                CPlayerInventory.addCreature(aCapturedCreatures, CStarterCreature.copyCreatureInfo());
                aCapturedCreatures.get(0).setActiveCreature(true);
                //CCharScanner.close();
                }
        } else {
         chooseStarterCreature();
         //CCharScanner.close();
        }


        return true; 
    }

    public void displayMenu() 
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
            CPlayerInventory.addCreature(aCapturedCreatures,CChosenCreature.copyCreatureInfo());
            CPlayerInventory.addCreature(aCapturedCreatures,CChosenCreature2.copyCreatureInfo()); //for testing of aCapturedCreatures not empty
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

                    Creature CChosenCreatureA = CPlayerInventory.findCreaturebyIndex(aCapturedCreatures, nCreatureA, nlength);
                    Creature CChosenCreatureB = CPlayerInventory.findCreaturebyIndex(aCapturedCreatures, nCreatureB, nlength);
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
                displayMenu();
            }
        }
		else if(nMenuChoice == 2)
		{ 
			CArea.run();    
            do{
                nMovement = CArea.loadArea(CPlayerInventory.getAllCapturedCreatures(aCapturedCreatures), CPlayerInventory);
            }while(nMovement != 5);

            if(nMovement == 5)
                displayMenu();
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

    public void exitGame()
    {
        System.out.println("\n\n\t\t[FINAL MESSAGE]:You have exited the game.");
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

    public Creature[] getAllCreatures()
    {
        return  this.CMasterInventory;
    }

 


}
