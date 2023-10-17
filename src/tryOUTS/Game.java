 
import java.util.Scanner;
public class Game{
    
    private Creature[] CMasterInventory = new Creature[9]; // will contain all the creatures 
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
    Creature COshacone = new Creature(999, 8,"Oshacone",'I',"Water",1,false);

    // public void setMasterInventory(int nHealth){
    //     this.CMasterInventory = CMasterInventory;
    // }
    
    // public Creature getMasterInventory(){
    //     return CMasterInventory;
    // }

    public void run() // instantiation ng mga class na need natin 
    {
        CMasterInventory[0] = CStrawander;
        CMasterInventory[1] = CChocowool;
        CMasterInventory[2] = CParfwit;
        CMasterInventory[3] = CBrownisaur;
        CMasterInventory[4] = CFrubat;
        CMasterInventory[5] = CMalts;
        CMasterInventory[6] = CSquirpie;
        CMasterInventory[7] = CChocolite;
        CMasterInventory[8] = COshacone;
        //this.CMasterInventory = new Creature; 
        //this.CPlayer = new Player(); 
        this.CPlayer = new Player(); 
        this.CArea = new Area(this.CPlayer);

    }

    public Creature getCStrawander()
    {
        return CMasterInventory[0];
    }

    // get players starter creature 


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
			// display inventory
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