import java.util.ArrayList;
import java.util.Scanner;
import java.util.ListIterator;

public class Inventory { // check if parameters = needed cause cant get info from field or class
    
    // displays the inventory functions

    public void displayCreatureImage(Creature CCreature) //Can be used for aStarterCreatures aCapturedCreatures
     {
      
        System.out.print("Image ID " + CCreature.getImageID());
    
     }
     
    public void displayCreatureNames(Creature CCreature) //Can be used for aStarterCreatures aCapturedCreatures
     {
      
        System.out.print(CCreature.getCreatureName());
    
     }
     public void displayCreatureFamilies(Creature CCreature) //Can be used for aStarterCreatures and aCapturedCreatures
     {
      
      System.out.print(CCreature.getFamily());
      
     }

     public void displayCreatureType(Creature CCreature) //Can be used for aStarterCreatures and aCapturedCreatures
     {
      
      System.out.print(CCreature.getType());
      
     }

     public void displayCreatureLevel(Creature CCreature) //Can be used for aStarterCreatures and aCapturedCreatures
     {
      
      System.out.print("EL " + CCreature.getLevel());
      
     }

     public void displayActive(Creature CCreature) //Can be used for aStarterCreatures and aCapturedCreatures
     {
      if(CCreature.getActiveCreature()==true)
      {
         System.out.print("(Active Creature)");
      }
     }
     
     //will still need to create separate displays for each information, I separated them kasi baka sa starters di pakita everything
     //can make one with multiple info if needed

    public void addCreature(ArrayList<Creature> aArray, Creature CCreature)  //used to add Creatures to diff arrayLists
    {
           aArray.add(CCreature);
    }

    public Creature findCreature(ArrayList<Creature> aArray, String strCreature, int nLength)
    {
      int i;
      for(i=0;i<nLength;i++)
      {
        if(aArray.get(i).getCreatureName().compareTo(strCreature)==0)
        {
          return aArray.get(i);
        }
      }
      return null;
    }

     public void swapCreature(Creature CCreatureA, Creature CCreatureB)
     {
        if(CCreatureA.getActiveCreature()==true && CCreatureA.getActiveCreature()==false)
        {
          CCreatureA.setActiveCreature(false);
          CCreatureB.setActiveCreature(true);
        }
        else if(CCreatureA.getActiveCreature()==false && CCreatureA.getActiveCreature()==true)
        {
          CCreatureA.setActiveCreature(true);
          CCreatureB.setActiveCreature(false);
        }
     }

     public void displayCapturedCreatures(int nlength, ArrayList<Creature> aCapturedArray, Inventory CInventory) //show which creature is active
     {
        int i;
        for(i=0;i<nlength;i++)
        {
          CInventory.displayCreatureImage(aCapturedArray.get(i));
          System.out.print("\n");
          CInventory.displayCreatureNames(aCapturedArray.get(i));
          System.out.print("\t");
          CInventory.displayCreatureType(aCapturedArray.get(i));
          System.out.print("\t");
          CInventory.displayCreatureFamilies(aCapturedArray.get(i));
          System.out.print("\t");
          CInventory.displayCreatureLevel(aCapturedArray.get(i));
          System.out.print("\t");
          CInventory.displayActive(aCapturedArray.get(i));
          System.out.print("\n");
        }
     }

     public int displayInventory(Inventory CInventory, int nlength, ArrayList<Creature> aArray){

      System.out.print("\n\n\t\t\t=======INVENTORY=======\n"+
                      "\t\t\t Captured Creatures: \n");  
      
      CInventory.displayCapturedCreatures(nlength, aArray, CInventory);

      System.out.print(
                      "\n\t\t\t[1]  Change Active Creature\n" +
                      "\t\t\t[2]  Exit Inventory\n" +
                      "\t\t\t=======================\n");
        
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

    public boolean returnToMainMenu()
    {
        return true;
    }
}
