import java.util.ArrayList;
import java.util.Scanner;


public class Inventory { 

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
    *  Is used to add the passed creature into a specific arrayList.
    *
    *  @param (CCreature) is the specific creature whose being added to the specific arrayList
    *  
    */
    public void addCreature(ArrayList<CapturedCreature> aArray, Creature CCreature) 
    {
            CapturedCreature NewCreature = new CapturedCreature((Creature)CCreature);

          aArray.add(NewCreature);
           
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
    public CapturedCreature findCreaturebyIndex(ArrayList<CapturedCreature> aCapturedArray, int nCreatureIndex, int nLength)
    {
      int i;
      for(i=0;i<nLength;i++)
      {
        if((i+1)==nCreatureIndex)
        {
          return aCapturedArray.get(i);
        }
      }
      return null;
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
    public Creature findCreatureByFamily(ArrayList<Creature> aCapturedArray, char cCreature, int nLength)
    {
      int i;
      for(i=0;i<nLength;i++)
      {
        if(aCapturedArray.get(i).getFamily()==cCreature)
        {
          return aCapturedArray.get(i);
        }
      }
      return null;
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
    *
    *  Is used to display all information of captured creatures in the inventory.
    *
    *  @param (nlength) is the length or amount of elements inside of aCapturedArray arrayList
    *  @param (aCapturedArray) is the specific arrayList of captured creatures
    *  @param (CInventory) is the inventory that contains aCapturedArray
    *   
    */ 
     public void displayCapturedCreatures(int nlength, ArrayList<CapturedCreature> aCapturedArray, Inventory CInventory) 
     {
        int i;
        for(i=0;i<nlength;i++)
        {
         
          System.out.print("\nCreature " + (i+1) + ": ");
          CInventory.displayCreatureImage(aCapturedArray.get(i));
          System.out.print("\nName: ");
          CInventory.displayCreatureNames(aCapturedArray.get(i));
          System.out.print(" - Type: ");
          CInventory.displayCreatureType(aCapturedArray.get(i));
          System.out.print(" - Family ");
          CInventory.displayCreatureFamilies(aCapturedArray.get(i));
          System.out.print(" - ");
          CInventory.displayCreatureLevel(aCapturedArray.get(i));
          System.out.print(" ");
          CInventory.displayActiveCreature(aCapturedArray.get(i));
          System.out.print("\n");

        }
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
     public int displayInventory(Inventory CInventory, int nlength, ArrayList<CapturedCreature> aCapturedArray){
      Scanner CInputScanner = new Scanner(System.in);

      int nInput = 0;
      boolean bInputOver = false;

      while (bInputOver == false) 
      {
        System.out.print("\n\n====================INVENTORY====================\n"+
                      "\n\t    Captured Creatures: \n");
      
        CInventory.displayCapturedCreatures(nlength, aCapturedArray, CInventory);
      
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
     *  Is used to check amoung the ArrayList which creature is currently active.
     *
     *  @param (aArray) is the specific arrayList of captured creatures
     *  @return the (CActive) creature who is currently active
     *   
     */ 
    public CapturedCreature getTheActiveCreature(ArrayList<CapturedCreature> aArray)
    {
        int k;
        CapturedCreature CActive=null; 

        for(k=0 ; k< aArray.size(); k++)
        {
            if(aArray.get(k).getActiveCreature() == true)
                CActive = aArray.get(k);
        }

        return CActive;
    }

    /**
     *
     *  Is used to get all the captured creatures from the arrayList.
     *
     *  @param (aCapturedCreatures) is the specific arrayList of captured creatures
     *  @return (aCapturedCreatures) arrayList of captured creatures
     *   
     */ 
    public  ArrayList<CapturedCreature> getAllCapturedCreatures(ArrayList<CapturedCreature> aCapturedCreatures)
    {
        return aCapturedCreatures;
    }

    /**
     *
     *  Is used to return to the Main Menu.
     *
     *  @return true
     *   
     */ 
    public boolean returnToMainMenu()
    {
        return true;
    }
}
