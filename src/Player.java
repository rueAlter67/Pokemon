import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player 
{
    
    private int nPosX; 
    private int nPosY; 

    /**
     * Upon creation the Player's location(<nPosX>, <nPosY>) is set to 0,0
     */
    public Player()
    {
        this.nPosX = 0; 
        this.nPosY = 0; 
    } 


    //+++++++++++ PLAYER'S INTERACTION WITH AREA
    /**
     * This method enables the player to move up.
     * It returns a boolean value true if the player is able to go up and false if they can't. 
     * 
     * @param nXLimit   the integer value corresponding to the x-coordinate dimension limit of the Area
     * @param nYLimit   the integer value corresponding to the y-coordinate dimension limit of the Area
     * @return          an boolean value if the movement was successful or not. 
     * 
     */
    public boolean goUp(int nXLimit, int nYLimit)
    {

        System.err.print("\n\n\t\t\t[ERROR]: Player can't move up anymore");   
        return false; 
    }

     //+++++++++++ PLAYER'S INTERACTION WITH AREA
    /**
     * This method enables the player to move  down.
     * It returns a boolean value true if the player is able to go down and false if they can't 
     * 
     * @param nXLimit   the integer value corresponding to the x-coordinate dimension limit of the Area
     * @param nYLimit   the integer value corresponding to the y-coordinate dimension limit of the Area
     * @return          an boolean value if the movement was successful or not. 
     * 
     */
    public boolean goDown(int nXLimit, int nYLimit)
    {
        System.err.print("\n\n\t\t\t[ERROR]: Player can't move down anymore");   
        return false; 
    }

     //+++++++++++ PLAYER'S INTERACTION WITH AREA
    /**
     * This method enables the player to move left.
     * It returns a boolean value true if the player is able to go left and false if they can't 
     * 
     * @param nXLimit   the integer value corresponding to the x-coordinate dimension limit of the Area
     * @param nYLimit   the integer value corresponding to the y-coordinate dimension limit of the Area
     * @return          an boolean value if the movement was successful or not. 
     * 
     */
    public boolean goLeft(int nXLimit, int nYLimit)
    {
        boolean bMove = true; 


        if(this.nPosX > 0)
            this.nPosX-=1; 
        else
        {
            bMove = false; 
            System.err.print("\n\n\t\t\t[ERROR]: Player can't move anymore to the left");
        }

        return bMove; 
    }

     //+++++++++++ PLAYER'S INTERACTION WITH AREA
    /**
     * This method enables the player to move right.
     * It returns a boolean value true if the player is able to go right and false if they can't 
     * 
     * @param nXLimit   the integer value corresponding to the x-coordinate dimension limit of the Area
     * @param nYLimit   the integer value corresponding to the y-coordinate dimension limit of the Area
     * @return          an boolean value if the movement was successful or not. 
     * 
     */
    public boolean goRight(int nXLimit, int nYLimit)
    {
        boolean bMove = true; 

        if(this.nPosX <nXLimit-1)
            this.nPosX+=1; 
        else
        {
            bMove = false;
            System.err.print("\n\n\t\t\t[ERROR]: Player can't move anymore to the left");

        }
        

        return bMove; 
    }

    /**
     * This method enables the player to attack the enemy using their active creature. 
     * 
     * @param CEnemy            an enemy <Creature>
     * @param CActiveCreature   a creature used by the player
     */
    public void attack(Creature CEnemy, Creature CActiveCreature)
    {
        Random CRand = new Random();
        int nMax = 10; 
        int nMin = 1;
        int nRandom = CRand.nextInt(nMax - nMin + 1) + nMin;
        double nDamage = nRandom * 1;// 1 the creature's level 

        System.out.print("\n\t\t\tINITIAL DAMAGE: "+ nDamage + "\n");
        if(CActiveCreature.getType() == "Fire")
        {   
            if(CEnemy.getType() == "Grass")
                nDamage*= 1.5; 
        }
        else if(CActiveCreature.getType() == "Grass")
        {
            if(CEnemy.getType() == "Water")
                nDamage*= 1.5;
        } 
        else if(CActiveCreature.getType() == "Water")
        {
              if(CEnemy.getType() == "Fire")
                 nDamage*= 1.5;
        }

        System.out.println("\n\t\t\tFINALDAMAGE: "+ nDamage + "\n");

        CEnemy.setHealth(CEnemy.getHealth() - nDamage);
    }

    /**
     * This method enables the player to catch a creature they encounter in the area. 
     * It either successfully captures it or it fails to capture. 
     * 
     * @param CEnemy        the creature enemy
     * @param aCaptured     the array list of creatures containing the captured creatures
     * @param CInventory    the inventory
     * @return              the success indicator
     */
    public boolean catchCreature(Creature CEnemy,ArrayList<Creature> aCaptured, Inventory CInventory)
    {
        Random CRandom = new Random();
        boolean bCaught = false; 
        double dChance = CRandom.nextDouble();
        double dCatchRate = (40+50-CEnemy.getHealth())/100;

        if(dChance <= dCatchRate)
        {
            CInventory.addCreature(aCaptured, CEnemy);
            bCaught = true; 
        }
        return bCaught;
    }

    /**
     * This method enables the player to swap creatures when they are in the battle phase
     * It always returns a 0 or 1 to indicate the success of a swap 
     * 
     * @param aCaptured     the array list of creatures
     * @param CInventory    the inventory
     * @return              the boolean to indicate if it was successful or not
     */
    public boolean swap(ArrayList<Creature> aCaptured, Inventory CInventory)
    {
        boolean bSwapped= false; 
        int nInput= CInventory.displayInventory(CInventory,aCaptured.size(),aCaptured);
        boolean bExitInventory = false;

        if(nInput == 1)
        {
            Scanner CIntScanner = new Scanner(System.in);
            System.out.print("Type Numbers of Creatures to Swap: "+ "\n");
            System.out.print("Creature 1: ");
            int nCreatureA = CIntScanner.nextInt();
            System.out.print("Creature 2: ");
            int nCreatureB = CIntScanner.nextInt();
            CIntScanner.nextLine();

            Creature CChosenCreatureA = CInventory.findCreaturebyIndex(aCaptured, nCreatureA, aCaptured.size());
            Creature CChosenCreatureB = CInventory.findCreaturebyIndex(aCaptured, nCreatureB, aCaptured.size());
            boolean bCreatureAActive = CChosenCreatureA.getActiveCreature();
            boolean bCreatureBActive = CChosenCreatureB.getActiveCreature();

            if(CChosenCreatureA != null && CChosenCreatureB != null && bCreatureAActive == true || bCreatureBActive == true)
            {
                CInventory.swapCreature(CChosenCreatureA, CChosenCreatureB);
                System.out.print("\n\t\t\t[SYSTEM MESSAGE]: Active Creature Changed.");
                bSwapped = true; 
            }
            else
                System.out.print("\n\t\t\t[SYSTEM MESSAGE]: Invalid Creature (Check Number or if Active)");

        }
        else if(nInput == 2)
        {
            bExitInventory = true;
        }
        else
            System.out.print("\n\t\t\t[SYSTEM MESSAGE]: Invalid Action");


        return bSwapped; 
    }

  /**
   * This method returns the current x-coordinate position of the player
   * @return    the x-coordinate position of the player 
   */
    public int getPosX()
    {
        return this.nPosX;
    }

    /**
   * This method returns the current y-coordinate position of the player
   * @return    the y-coordinate position of the player 
   */
    public int getPosY() {
        return nPosY;
    }

  

}