 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//import java.util.*;
public class Game{
    
    private Player CPlayer;
    private int nMenuChoice; 
    private Area CArea;

    Inventory CMasterInventory = new Inventory();
    
    /**
     * This method starts the entire game. 
     */
    public void run()
    {
         for (int i=0;i<27;i++) {
        CMasterInventory.addCreature(new Creature(0, "Strawander",'A',"Fire",1));
        CMasterInventory.addCreature(new Creature(1,"Chocowool",'B',"Fire",1));
        CMasterInventory.addCreature(new Creature(2,"Parfwit",'C',"Fire",1));
        CMasterInventory.addCreature(new Creature( 3,"Brownisaur",'D',"Grass",1));
        CMasterInventory.addCreature(new Creature(4,"Frubat",'E',"Grass",1));
        CMasterInventory.addCreature(new Creature(5,"Malts",'F',"Grass",1));
        CMasterInventory.addCreature(new Creature(6,"Squirpie",'G',"Water",1));
        CMasterInventory.addCreature(new Creature(7,"Chocolite",'H',"Water",1));
        CMasterInventory.addCreature(new Creature(8, "Oshacone",'I',"Water",1));
        CMasterInventory.addCreature(new Creature(9, "Strawleon",'A',"Fire",2));
        CMasterInventory.addCreature(new Creature(10, "Chocofluff",'B',"Fire",2));
        CMasterInventory.addCreature(new Creature(11, "Parfure",'C',"Fire",2));
        CMasterInventory.addCreature(new Creature(12, "Chocosaur",'D',"Grass",2));
        CMasterInventory.addCreature(new Creature(13, "Golberry",'E',"Grass",2));
        CMasterInventory.addCreature(new Creature(14, "Kirlicake",'F',"Grass",2));
        CMasterInventory.addCreature(new Creature(15, "Tartortle",'G',"Water",2));
        CMasterInventory.addCreature(new Creature(16, "Chocolish",'H',"Water",2));
        CMasterInventory.addCreature(new Creature(17, "Dewice",'I',"Water",2));
        CMasterInventory.addCreature(new Creature(18, "Strawizard",'A',"Fire",3));
        CMasterInventory.addCreature(new Creature(19, "Candaros",'B',"Fire",3));
        CMasterInventory.addCreature(new Creature(20, "Parfelure",'C',"Fire",3));
        CMasterInventory.addCreature(new Creature(21, "Fudgasaur",'D',"Grass",3));
        CMasterInventory.addCreature(new Creature(22, "Croberry",'E',"Grass",3));
        CMasterInventory.addCreature(new Creature(23, "Velvevoir",'F',"Grass",3));
        CMasterInventory.addCreature(new Creature(24, "Piestoise",'G',"Water",3));
        CMasterInventory.addCreature(new Creature(25, "Icesundae",'H',"Water",3));
        CMasterInventory.addCreature(new Creature(26, "Samurcone",'I',"Water",3));
    }

        this.CPlayer = new Player(CMasterInventory.getAllCapturedCreatures()); 
        this.CArea = new Area(this.CPlayer, CPlayer.getAllCapturedCreatures());
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
            CMasterInventory.displayCreatureImage(CMasterInventory.getCreature(i));
            System.out.print("\t");
            CMasterInventory.displayCreatureNames(CMasterInventory.getCreature(i));
            System.out.print("\t");
            CMasterInventory.displayCreatureType(CMasterInventory.getCreature(i));
            System.out.print("\t");
            CMasterInventory.displayCreatureFamilies(CMasterInventory.getCreature(i));
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
            Creature CStarterCreature = CMasterInventory.findCreatureByFamily(CMasterInventory.getAllCapturedCreatures(), cFamily, CMasterInventory.getInventorySize());
                if (CStarterCreature instanceof Creature) 
                {
                CPlayer.addCreature(CStarterCreature);
                CPlayer.getCreature(0).setActiveCreature(true);
                //CCharScanner.close();
                }
        } else {
         chooseStarterCreature();
         //CCharScanner.close();
        }

        return true; 
    }

    /**
     * This method displays the Main Menu of the game 
     */
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

            int nlength = CPlayer.getPlayerInventorySize();

            boolean bExitInventory = false;
            while (!bExitInventory) 
            {
                int nInput = CMasterInventory.displayInventory(CPlayer); 
               
                if(nInput == 1)
                {
                    Scanner CIntScanner = new Scanner(System.in);
                    System.out.print("Type Numbers of Creatures to Swap: "+ "\n");
                    System.out.print("Creature 1: ");
                    int nCreatureA = CIntScanner.nextInt();
                    System.out.print("Creature 2: ");
                    int nCreatureB = CIntScanner.nextInt();
                    CIntScanner.nextLine();

                    CapturedCreature CChosenCreatureA = CPlayer.findCreaturebyIndex(nCreatureA, nlength);
                    CapturedCreature CChosenCreatureB = CPlayer.findCreaturebyIndex(nCreatureB, nlength);
                    boolean bCreatureAActive = CChosenCreatureA.getActiveCreature();
                    boolean bCreatureBActive = CChosenCreatureB.getActiveCreature();

                    if(CChosenCreatureA != null && CChosenCreatureB != null && bCreatureAActive == true || bCreatureBActive == true)
                    {
                        CPlayer.swapCreature(CChosenCreatureA, CChosenCreatureB);
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
                nMovement = CArea.loadArea(CPlayer.getAllCapturedCreatures(), CMasterInventory);
            }while(nMovement != 5);

            if(nMovement == 5)
                displayMenu();
		}
		else if(nMenuChoice == 3)
		{
            boolean bExitInventory = false;
           
            while(!bExitInventory){
			  boolean playerExit = CPlayer.displayEvolution();
              if(playerExit==true)
              {
                bExitInventory = true;
              }
            }

            if(bExitInventory)
            {
                displayMenu();
            }

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

 
}

