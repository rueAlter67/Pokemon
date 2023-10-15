import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

       public void addCreature(ArrayList<Creature> alArray, Creature CCreature) {
           alArray.add(CCreature);
       }
    
    // displays the inventory functions
    public int displayInventory(){
        
        Scanner CInputScanner = new Scanner(System.in);
        System.out.print("Enter Inventory Menu Action: ");
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
          else if(nInput == 3)
          {
            nActionChosen = 3;
            bInputOver = true;
            return nActionChosen;
          }
        else
          System.out.print("Invalid Inventory Menu Action");
        }

        CInputScanner.close();
        return nActionChosen;
    }

     public void displayCreatureNames(Creature CCreature) //Can be used for aStarterCreatures aCapturedCreatures
     {
      
        System.out.print(CCreature.getCreatureName() + "\t");
    
     }
     public void displayCreatureFamilies(Creature CCreature) //Can be used for aStarterCreatures and aCapturedCreatures
     {
     
      System.out.print(CCreature.getFamily());
      
     }

     //will still need to create separate displays for each information, I separated them kasi baka sa starters di pakita everything
     //can make one with multiple info if needed

    public void addCreature(int nIndex, Creature[] CCreature, ArrayList<Creature> alArray) //used to add Creatures to diff arrayLists
    {
      alArray.add(CCreature[nIndex]);
    }

    public boolean returnToMainMenu()
    {
        return true;
    }
}
