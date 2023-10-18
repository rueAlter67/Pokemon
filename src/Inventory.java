import java.util.ArrayList;
import java.util.Scanner;


public class Inventory { 

    public void displayCreatureImage(Creature CCreature) 
     {
      
        System.out.print("Image ID " + CCreature.getImageID());
    
     }
     
    public void displayCreatureNames(Creature CCreature)
     {
      
        System.out.print(CCreature.getCreatureName());
    
     }
     public void displayCreatureFamilies(Creature CCreature) 
     {
      
      System.out.print(CCreature.getFamily());
      
     }

     public void displayCreatureType(Creature CCreature) 
     {
      
      System.out.print(CCreature.getType());
      
     }

     public void displayCreatureLevel(Creature CCreature) 
     {
      
      System.out.print("EL " + CCreature.getLevel());
      
     }

    
     
     //will still need to create separate displays for each information, I separated them kasi baka sa starters di pakita everything
     //can make one with multiple info if needed

    public void addCreature(ArrayList<Creature> aArray, Creature CCreature)  //used to add Creatures to diff arrayLists
    {
           aArray.add(CCreature);
           
    }

    public Creature findCreaturebyIndex(ArrayList<Creature> aArray, int nCreature, int nLength) //this is assuming the index being entered is +1 (no 0 index)
    {
      int i;
      for(i=0;i<nLength;i++)
      {
        if((i+1)==nCreature)
        {
          return aArray.get(i);
        }
      }
      return null;
    }

    public Creature findCreatureByFamily(ArrayList<Creature> aArray, char strCreature, int nLength)
    {
      int i;
      for(i=0;i<nLength;i++)
      {
        if(aArray.get(i).getFamily()==strCreature)
        {
          return aArray.get(i);
        }
      }
      return null;
    }
    
     public void swapCreature(Creature CCreatureA, Creature CCreatureB)
     {
          boolean bActiveCreatureA = CCreatureA.getActiveCreature();
          boolean bActiveCreatureB = CCreatureB.getActiveCreature();

          CCreatureA.setActiveCreature(bActiveCreatureB);
          CCreatureB.setActiveCreature(bActiveCreatureA);
     }
      // displays the inventory functions
     public void displayCapturedCreatures(int nlength, ArrayList<Creature> aCapturedArray, Inventory CInventory) 
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
         // CInventory.displayActive(aCapturedArray.get(i));
          System.out.print("\n");

        }
     }
     public int displayInventory(Inventory CInventory, int nlength, ArrayList<Creature> aArray){

      System.out.print("\n\n====================INVENTORY====================\n"+
                      "\n\t    Captured Creatures: \n");
      
      CInventory.displayCapturedCreatures(nlength, aArray, CInventory);
      
      System.out.print(
        "\n\t[1]  Change Active Creature\n" +
        "\t[2]  Exit Inventory\n" +
        "=================================================\n");
        
        Scanner CInputScanner = new Scanner(System.in);
        System.out.print("Enter Inventory Action: ");
        int nInput = CInputScanner.nextInt();
        boolean bInputOver = false;
        int nActionChosen = 0;

        while(bInputOver == false)
        {
          if(nInput == 1)
          {
            nActionChosen = 1;
            bInputOver = true;
            return nActionChosen;
          }
          else if(nInput == 2)
          {
            nActionChosen = 2;
            bInputOver = true;
            return nActionChosen;
          }
        else
          System.out.print("Invalid Inventory Menu Action");
        }

        CInputScanner.close();
        return nActionChosen;
    }

    
    public Creature getTheActiveCreature(ArrayList<Creature> aArray)
    {
        int k;
        Creature CActive=null; 

        for(k=0 ; k< aArray.size(); k++)
        {
            if(aArray.get(k).getActiveCreature() == true)
                CActive = aArray.get(k);
        }

        return CActive;
    }

    public  ArrayList<Creature> getAllCapturedCreatures( ArrayList<Creature> aCapturedCreatures )
    {
        return aCapturedCreatures;
    }


    public boolean returnToMainMenu()
    {
        return true;
    }
}
