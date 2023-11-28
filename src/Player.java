import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player 
{
    
    private int nPosX; 
    private int nPosY; 
    private ArrayList<CapturedCreature> aCapturedCreatures;
    private Inventory CPlayerInventory;

    /**
     * Upon creation the Player's location(<nPosX>, <nPosY>) is set to 0,0
     */
    public Player()
    {
        this.nPosX = 0; 
        this.nPosY = 0; 
        aCapturedCreatures = new ArrayList<CapturedCreature>();
    } 


    /**
    *
    *  Is used to add the passed creature into the players inventory arrayList.
    *
    *  @param (CCreature) is the specific creature whose being added to the specific arrayList
    *  
    */
    public void addCreature(Enemy CEnemy) 
    {
        CapturedCreature NewCreature = new CapturedCreature((Creature)CEnemy);

        aCapturedCreatures.add(NewCreature);
           
    }

  
    public CapturedCreature getCreature(int index) 
    {
      return aCapturedCreatures.get(index);
    }

    public int getPlayerInventorySize(){

        return aCapturedCreatures.size();
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
     * @param CEnemy            an enemy
     * @param CActiveCreature   a creature used by the player
     */
    public void attack(Enemy CEnemy, CapturedCreature CActiveCreature)
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
    public boolean catchCreature(Enemy CEnemy)
    {
        Random CRandom = new Random();
        boolean bCaught = false; 
        double dChance = CRandom.nextDouble();
        double dCatchRate = (40+50-CEnemy.getHealth())/100;

        if(dChance <= dCatchRate)
        {
            this.addCreature(CEnemy);
            bCaught = true; 
        }
        return bCaught;
    }

    public void displayCreatureImage(Creature CCreature) 
     {
      
        System.out.print("Image ID " + CCreature.getImageID());
    
     }

    /**
    *
    *  Displays the name of the passed creature.
    *
    *  @param (CCreature) is the specific creature whose name is being displayed
    *  
    */
    public void displayCreatureNames(Creature CCreature)
     {
      
        System.out.print(CCreature.getCreatureName());
    
     }

    /**
    *
    *  Displays the family of the passed creature.
    *
    *  @param (CCreature) is the specific creature whose family is being displayed
    *  
    */
     public void displayCreatureFamilies(Creature CCreature) 
     {
      
      System.out.print(CCreature.getFamily());
      
     }

    /**
    *
    *  Displays the type of the passed creature.
    *
    *  @param (CCreature) is the specific creature whose type is being displayed
    *  
    */
     public void displayCreatureType(Creature CCreature) 
     {
      
      System.out.print(CCreature.getType());
      
     }

    /**
    *
    *  Displays the evolution level of the passed creature.
    *
    *  @param (CCreature) is the specific creature whose evolution level is being displayed
    *  
    */
     public void displayCreatureLevel(Creature CCreature) 
     {
      
      System.out.print("EL " + CCreature.getLevel());
      
     }

    /**
    *
    *  Displays if the passed creature is the active creature.
    *
    *  @param (CCreature) is the specific creature whose active status is being checked and displayed
    *  
    */
     public void displayActiveCreature(CapturedCreature CCreature) 
     {
      if(CCreature.getActiveCreature()==true)
      {
         System.out.print("(Active Creature)");
      }
     }


       /**
    *
    *  Is used to display all information of captured creatures in the inventory.
    *
    *  @param (nlength) is the length or amount of elements inside of aCapturedArray arrayList
    *  @param (aCapturedArray) is the specific arrayList of captured creatures
    *  @param (CInventory) is the inventory that contains aCapturedArray
    *   
    */ 
    public void displayCapturedCreatures(int nlength, ArrayList<CapturedCreature> aCapturedArray) 
    {
       int i;
       for(i=0;i<nlength;i++)
       {
        
         System.out.print("\nCreature " + (i+1) + ": ");
         CPlayerInventory.displayCreatureImage(aCapturedArray.get(i));
         System.out.print("\nName: ");
         CPlayerInventory.displayCreatureNames(aCapturedArray.get(i));
         System.out.print(" - Type: ");
         CPlayerInventory.displayCreatureType(aCapturedArray.get(i));
         System.out.print(" - Family ");
         CPlayerInventory.displayCreatureFamilies(aCapturedArray.get(i));
         System.out.print(" - ");
         CPlayerInventory.displayCreatureLevel(aCapturedArray.get(i));
         System.out.print(" ");
         this.displayActiveCreature(aCapturedArray.get(i));
         System.out.print("\n");

       }
    }

    /**
    *
    *  Is used to find a creature in an arrayList based on the passed index.
    *
    *  @param (aCapturedArray) is the specific arrayList (of captured creatures) where the creature is being found
    *  @param (nCreatureIndex) is the index to be compared to the indices of the aCapturedArray arrayList
    *  @param (nLength) is the length or amount of elements inside of aCapturedArray arrayList
    *  @returns (Creature) that is found to have the same index as nCreatureIndex, null if no creature of the same index is found  
    */    
    public CapturedCreature findCreaturebyIndex(int nCreatureIndex, int nLength)
    {
      int i;
      for(i=0;i<nLength;i++)
      {
        if((i+1)==nCreatureIndex)
        {
          return aCapturedCreatures.get(i);
        }
      }
      return null;
    }

    /**
     *
     *  Is used to get all the captured creatures from the arrayList.
     *
     *  @param (aCapturedCreatures) is the specific arrayList of captured creatures
     *  @return (aCapturedCreatures) arrayList of captured creatures
     *   
     */ 
    public  ArrayList<CapturedCreature> getAllCapturedCreatures()
    {
        return aCapturedCreatures;
    }

        /**
    *
    *  Is used to swap the current active creature by changing two creatures active boolean indicators.
    *
    *  @param (CCreatureA) is the first specific creature whose active boolean indicator is being swapped with CCreatureB
    *  @param (CCreatureB) is the second specific creature whose active boolean indicator is being swapped with CCreatureA
    *   
    */  
    public void swapCreature(CapturedCreature CCreatureA, CapturedCreature CCreatureB)
    {
         boolean bActiveCreatureA = CCreatureA.getActiveCreature();
         boolean bActiveCreatureB = CCreatureB.getActiveCreature();

         CCreatureA.setActiveCreature(bActiveCreatureB);
         CCreatureB.setActiveCreature(bActiveCreatureA);
    }
    /**
     * This method enables the player to swap creatures when they are in the battle phase
     * It always returns a 0 or 1 to indicate the success of a swap 
     * 
     * @param aCaptured     the array list of creatures
     * @param CInventory    the inventory
     * @return              the boolean to indicate if it was successful or not
     */
    public boolean swap(Inventory CInventory)
    {
        boolean bSwapped= false; 
        int nInput= CInventory.displayInventory(aCapturedCreatures.size(), aCapturedCreatures);
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

            CapturedCreature CChosenCreatureA = this.findCreaturebyIndex(nCreatureA, aCapturedCreatures.size());
            CapturedCreature CChosenCreatureB = this.findCreaturebyIndex(nCreatureB, aCapturedCreatures.size());
            boolean bCreatureAActive = CChosenCreatureA.getActiveCreature();
            boolean bCreatureBActive = CChosenCreatureB.getActiveCreature();

            if(CChosenCreatureA != null && CChosenCreatureB != null && bCreatureAActive == true || bCreatureBActive == true)
            {
                this.swapCreature(CChosenCreatureA, CChosenCreatureB);
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

    public CapturedCreature getTheActiveCreature()
    {
        int k;
        CapturedCreature CActive=null; 

        for(k=0 ; k< aCapturedCreatures.size(); k++)
        {
            if(aCapturedCreatures.get(k).getActiveCreature() == true)
                CActive = aCapturedCreatures.get(k);
        }

        return CActive;
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