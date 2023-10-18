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

     public void displayActiveCreature(Creature CCreature) 
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

    public Creature findCreaturebyIndex(ArrayList<Creature> aCapturedArray, int nCreatureIndex, int nLength) //this is assuming the index being entered is +1 (no 0 index)
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
<<<<<<< HEAD
    
=======

>>>>>>> dd14999d7f84c2c28136a659c2a713ea912e4790
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
<<<<<<< HEAD
         // CInventory.displayActive(aCapturedArray.get(i));
=======
          CInventory.displayActiveCreature(aCapturedArray.get(i));
>>>>>>> dd14999d7f84c2c28136a659c2a713ea912e4790
          System.out.print("\n");

        }
     }
<<<<<<< HEAD
     public int displayInventory(Inventory CInventory, int nlength, ArrayList<Creature> aArray){
=======

     public int displayInventory(Inventory CInventory, int nlength, ArrayList<Creature> aCapturedArray){
      Scanner CInputScanner = new Scanner(System.in);
>>>>>>> dd14999d7f84c2c28136a659c2a713ea912e4790

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
       // CInputScanner.nextLine();

        if (nInput == 1)
        {
          //CInputScanner.nextLine();
          return nInput;
        }
        else if(nInput == 2) 
        {
          //CInputScanner.nextLine();
          bInputOver = true;
          return nInput;
        } 
        else 
            System.out.println("Invalid Inventory Menu Action");
        
        CInputScanner.close();
      }

      CInputScanner.close();
    
      return nInput;
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
