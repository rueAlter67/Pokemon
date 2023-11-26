import java.lang.*; 
import java.util.Scanner;

import javax.crypto.Cipher;

import java.util.ArrayList;
import java.util.Random;


/**
 * Area is the base class for all the area
 * that allows the application to 
 */
public class Area{

    /**
     * The area level that the player 
     */
    private int nAreaLevel; 
    private int nXDim=5; // default to 0 later
    private int nYDim=1;
    private Enemy CEnemy; 
    private Player CPlayer; 
    private ArrayList<Creature> CMasterInventory; 
 
    public Area(Player CPlayer, ArrayList<Creature> CMasterInventory)
    {
        this.CMasterInventory = CMasterInventory;
        this.CPlayer = CPlayer; 
        this.CEnemy = null; 
        this.nAreaLevel = 0; 
        this.nXDim = 0; 
        this.nYDim = 0; 
    }

    /**
     * Returns the movement of the Player within the area screen of the game. 
     * <p>
     * This method returns 1-5 and only stops loading the area once the input is 5
     * 
     * @param aCaptured     the array list containing the creatures captured by the Player
     * @param CInventory    the instance of Inventory Class used by the Player
     * @return              the nMovement made by the paler
     */	
	public int loadArea(ArrayList<CapturedCreature> aCaptured, Inventory CInventory) 
    {
        Scanner CReader = new Scanner(System.in);
        Random CRandom = new Random();
        int nCol; 
        int nRow; 
		int nMovement=0;   
        int nChecker=0;  
        boolean bPlayer=true; 
        CapturedCreature CActive = CInventory.getTheActiveCreature(aCaptured);

        do{
            for(nCol = 0; nCol < this.nYDim; nCol++)
        
            {
              System.out.printf("\n\n\t\t\t");
                for(nRow = 0; nRow < this.nXDim; nRow++)
                {
                    if(nRow ==  this.CPlayer.getPosX() && nCol == this.CPlayer.getPosY())
                        System.out.printf(" O ");
                    else 
                        System.out.printf(" + ");
                }

                System.out.print("\n\n");
            }
			
		    System.out.printf("\n\t\t\t=====MOVEMENTS====");
		    System.out.println("\n\t\t\t[1] UP" + 
                                "\n\t\t\t[2] DOWN" + 
                                "\n\t\t\t[3] LEFT" + 
                                "\n\t\t\t[4] RIGHT" + 
                                "\n\t\t\t[5] EXIT AREA\n");
			nMovement=0;
            nChecker=0;	

    		while(nChecker == 0)
            {
        
                System.out.print("\n\t\t\t[INPUT]: ");
            
                if(CReader.hasNextInt())
                {
                    nMovement = CReader.nextInt();   
                    if(nMovement >= 1 && nMovement <= 5)
                    {
                        nChecker = 1; 
                        CReader.nextLine();
                    }
                    else
                    {
                        System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Choose 1 to 5 only.\n");
                         CReader.nextLine();
                    
                    }
                }
                else
                {
                    System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Invalid Input. Input must be an integer.\n");
                     CReader.nextLine();  
                }

            }
           // CReader.nextLine();

		    switch(nMovement)
            {
                case 1: 
                        bPlayer = this.CPlayer.goUp(nXDim,nYDim);
                        break;
                case 2: 
                        bPlayer = this.CPlayer.goDown(nXDim,nYDim);
                        break;
                case 3:
                        bPlayer = this.CPlayer.goLeft(nXDim,nYDim);
                        break;
                case 4: 
                        bPlayer = this.CPlayer.goRight(nXDim,nYDim);
                        break;
                case 5: 
                        bPlayer = false;
                        break;
            }

            double dChance = CRandom.nextDouble();

            if(dChance <= 0.40 && bPlayer == true && nMovement != 5 )
            {
                System.out.print("\n\n\t\t\t[SYSTEM MESSAGE]: You've encountered an enemy! Press any button to proceed");
                CReader.nextLine(); 
                System.out.println("\n\n\n\n");
                int nIndex = 0;
                nIndex++;
                this.CEnemy = getRandomCreature(CMasterInventory);
                this.CEnemy.setHealth(50);
                battle(this.CEnemy, aCaptured,CInventory);
            } 

        }while(nMovement != 5);

        return nMovement; 

    }


    /**
     * This method runs opens the Area for the player where they can choose 
     * which area to choose. The chosen area would then assign the <nXDim> and <nYDim> 
     * coordinate used to <loadArea>
     */
    public void run() 
    {
        Scanner CReader = new Scanner(System.in);
        int nAreaChoice=0;
        int nChecker =0;; 

        System.out.println("\n\n\t\t\t=======CHOOSE AREA=======\n"+
                         "\n\t\t\t[1]  AREA 1\n" + 
                          "\t\t\t[2]  AREA 2\n"+
                        "\t\t\t[3]  AREA 3\n" +
                        "\t\t\t=======================");
        
        while(nChecker == 0)
        {
            System.out.print("\n\t\t\t[INPUT]: ");
            if(CReader.hasNextInt())
               {
                    nAreaChoice = CReader.nextInt();   
                    if(nAreaChoice >= 1 && nAreaChoice <= 3)
                    {
                        nChecker = 1; 
                        CReader.nextLine();
                    }
                    else
                    {
                        System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Choose 1 to 5 only.\n");
                        CReader.nextLine();
                    
                    }
                }
                else
                {
                    System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Invalid Input. Input must be an integer.\n");
                    CReader.nextLine();  
                }

        }

		    switch(nAreaChoice)
            {
                case 1: 
                        this.nXDim = 5; 
		                this.nYDim = 1; 
                        break;
                case 2: 
                        this.nXDim = 5; 
		                this.nYDim = 1; 
                        break;
                case 3:
                        this.nXDim = 5; 
		                this.nYDim = 1; 
                        break;
    
            }
        
    }

    /**
     * This method is where the battle phase of the game occurs. 
     * 
     * @param CEnemy        the <CEnemy> creature of the player
     * @param aCaptured     the array list of captured creatures
     * @param CInventory    the Inventory of the player
     */
    public void battle(Enemy CEnemy, ArrayList<CapturedCreature> aCaptured, Inventory CInventory)
    {
        Scanner CReader = new Scanner(System.in);
        int nMovesLeft = 3; 
        int nBattleMove = 0; 
        boolean bCaught = false; 
        boolean bSwapped = false; 
        int nLeave = 0; 

        do{
            System.out.println("\n\n\t\t\t================BATTLE=================\n"+
                            "\t\t\tMoves left: "+ nMovesLeft +
                            "\n\t\t\tEnemy Health: " + this.CEnemy.getHealth() + 
                             "\n\t\t\t======================================="+
                             "\n\n\t\t\tActive Creature: " + CInventory.getTheActiveCreature(CInventory.getAllCapturedCreatures(aCaptured)).getCreatureName()+"\tType: "+ 
                                                            CInventory.getTheActiveCreature(CInventory.getAllCapturedCreatures(aCaptured)).getType()+
                             "\n\t\t\tEnemy Creature: " + this.CEnemy.getCreatureName()+"\tType: "+ this.CEnemy.getType()+
                             
                         "\n\n\t\t\t[1]  ATTACK \n" + 
                          "\t\t\t[2]  SWAP \n"+
                        "\t\t\t[3]  CATCH \n" +
                        "\t\t\t[4]  SKIP CREATURE \n");

            nBattleMove=0;
            int nChecker = 0;	

    		while(nChecker == 0)
            {
                System.out.print("\n\t\t\t[INPUT]: ");
            
                if(CReader.hasNextInt())
                {
                    nBattleMove = CReader.nextInt();   
                    if(nBattleMove >= 1 && nBattleMove <= 4)
                    {
                        nChecker = 1; 
                        nMovesLeft-=1;
                        CReader.nextLine();
                    }
                    else
                    {
                        System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Choose 1 to 4 only.\n");
                         CReader.nextLine();
                    }
                }
                else
                {
                    System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Invalid Input. Input must be an integer.\n");
                     CReader.nextLine();  
                }

            }

            switch(nBattleMove)
            {
                case 1: 
                        CPlayer.attack(this.CEnemy, CInventory.getTheActiveCreature(CInventory.getAllCapturedCreatures(aCaptured)));
                        break;
                case 2: 
                        if(aCaptured.size() == 1)
                        {
                            System.out.println("[SYSTEM MESSAGE]: You can't swap if you only have 1 creature in your inventory\n" );

                        }
                        else
                        {
                            bSwapped = CPlayer.swap(aCaptured,CInventory);

                            if(bSwapped && nMovesLeft >= 1)
                            {
                                System.out.println("\n\t\t\t[SYSTEM MESSAGE]: Swapping successful! Press any button to continue playing");
                                CReader.nextLine();
                            }
                            else
                            {
                                System.out.println("\n\t\t\t[SYSTEM MESSAGE]: Swapping successful! Press any button to return to Area");
                                CReader.nextLine();
                            }
    

                        }

                        break;
                case 3:
                       bCaught = CPlayer.catchCreature(this.CEnemy,aCaptured, CInventory);
        
                       if(bCaught)
                       {
                            System.out.println("\n\t\t\t[SYSTEM MESSAGE]: You caught a creature. Press any button to go back to Area.\n");
                            CReader.nextLine();
                       }
                       else
                       {
                            System.out.println("\n\t\t\t[SYSTEM MESSAGE]: You failed to catch a creature. Press any button to continue playing.\n");
                            CReader.nextLine();
                       }
                       break;
                case 4: 
                       loadArea(CInventory.getAllCapturedCreatures(aCaptured) , CInventory);
                       break;
            }
            
           
        }while(nMovesLeft >= 1 && CEnemy.getHealth() >0 && bCaught != true);
    
            
    }

    /**
     * This methods returns a random creature
     * 
     * @param MasterInventory   an array of creatures containing all of the creatures of the game
     * @return <CEnemy>         the enemy creature of the player
     */
    public Enemy getRandomCreature(ArrayList<Creature> MasterInventory)
    {
        Random CRand = new Random();
        int nRandom = (char)(CRand.nextInt(9-1) + 1);
      
        return new Enemy(MasterInventory.get(nRandom));
    }

}