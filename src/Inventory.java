import java.util.ArrayList;
import java.util.Scanner;


public class Inventory { 
    
  private ArrayList<Creature> CInventory;
 
  /**
   * The constructor the class. It instantiates its fields 
   * CInventory
   */
  public Inventory() {
    CInventory = new ArrayList<>();
  }

  /**
    *  Adds a Creature to the MasterInventory. 
    *
    *  @param (CCreature) is the specific creature whose ImageID is being displayed
    *  
    */

  public void addCreature(Creature CCreature) {
      CInventory.add(CCreature);
  }

  /**
    *  Returns the passed creature. 
    *  @param (CCreature) is the specific creature who is being called
    *  
    */

    /**
     * This returns the creature at a specified index from the Inventory
     * @param index
     * @return Creature from the inventory
     */
  public Creature getCreature(int index){
    return CInventory.get(index);
  }


  /**
   * 
   * @return int the size or total number of cratures in the inventory
   */
  public int getInventorySize(){
    return CInventory.size();
  }

    /**
    *
    *  Displays the image ID of the passed creature. 
    *
    *  @param (CCreature) is the specific creature whose ImageID is being displayed
    *  
    */
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
    public void displayCreatureNames(Creature CCreature){
        System.out.print(CCreature.getCreatureName());
    }

    /**
    *
    *  Displays the family of the passed creature.
    *
    *  @param (CCreature) is the specific creature whose family is being displayed
    *  
    */
    public void displayCreatureFamilies(Creature CCreature){
      System.out.print(CCreature.getFamily());
    }

    /**
    *
    *  Displays the type of the passed creature.
    *
    *  @param (CCreature) is the specific creature whose type is being displayed
    *  
    */
    public void displayCreatureType(Creature CCreature){
      System.out.print(CCreature.getType());
    }

    /**
    *
    *  Displays the evolution level of the passed creature.
    *
    *  @param (CCreature) is the specific creature whose evolution level is being displayed
    *  
    */
    public void displayCreatureLevel(Creature CCreature){
      System.out.print("EL " + CCreature.getLevel());
    }


    /**
    *
    *  Is used to find a creature in an arrayList based on its passed family character.
    *
    *  @param (aCapturedArray) is the specific arrayList (of captured creatures) where the creature is being found
    *  @param (cCreature) is the character to be compared to the families of the aCapturedArray arrayList creature elements
    *  @param (nLength) is the length or amount of elements inside of aCapturedArray arrayList
    *  @returns (Creature) that is found to have the same character as cCreature, null if no creature with that family is found  
    */  
    public Creature findCreatureByFamily(ArrayList<Creature> CMasterInventory, char cCreature, int nLength){
      
      int i;
      for(i=0;i<nLength;i++)
      {
        if(CMasterInventory.get(i).getFamily()==cCreature)
        {
          return CMasterInventory.get(i);
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
    public  ArrayList<Creature> getAllCapturedCreatures()
    {
        return CInventory;
    }

    /**
     *
     *  Is used to display the whole inventory menu, including its actions and the captured creatures arrayList.
     *
     *  @param (CInventory) is the inventory that contains aCapturedArray
     *  @param (nlength) is the length or amount of elements inside of aCapturedArray arrayList
     *  @param (aCapturedArray) is the specific arrayList of captured creatures
     *   
     */ 
    public int displayInventory(Player CPlayer){
      Scanner CInputScanner = new Scanner(System.in);

      int nInput = 0;
      boolean bInputOver = false;

      while (bInputOver == false) 
      {
        System.out.print("\n\n====================INVENTORY====================\n"+
                      "\n\t    Captured Creatures: \n");
      
        CPlayer.displayCapturedCreatures(CPlayer.getPlayerInventorySize());
      
        System.out.print(
        "\n\t[1]  Change Active Creature\n" +
        "\t[2]  Exit Inventory\n" +
        "=================================================\n");
        
        System.out.print("Enter Inventory Action: ");
        nInput = CInputScanner.nextInt();

        if (nInput == 1)
        {
          return nInput;
        }
        else if(nInput == 2) 
        {
          bInputOver = true;
          return nInput;
        } 
        else 
            System.out.println("[SYSTEM MESSAGE]: Invalid Inventory Menu Action");
        
      }

      return nInput;
    }

    /**
     *
     *  Is used to return to the Main Menu.
     *
     *  @return true
     *   
     */ 
    public boolean returnToMainMenu(){
        return true;
    }
}
