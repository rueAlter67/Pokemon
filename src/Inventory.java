import java.util.ArrayList;

public class Inventory {

   // private Creature CActiveCreature;

   //comment bellow this = how to make a arraylist getter template
   /* public final class DataHolder {
        private final ArrayList<Creature> aCapturedCreatures = new ArrayList<>();
      
        public ArrayList<Creature> getCapturedCreatures() {
          return aCapturedCreatures;
        }
      }
      */


    //Creature CActiveCreature
    
        //this.aCapturedCreatures = new ArrayList<Creature>();
       // this.CActiveCreature = CActiveCreature; 
    
    
    // methods 
    // displays the inventory functions
    public void display() //[insert arraylist as parameter]
    {
        System.out.print("\n\n\t\t\t=======INVENTORY=======\n"+
                         "\t\t\t[1]  View Caught Creatures\n" + 
                          "\t\t\t[2]  Change Active Creature\n"+
                        "\t\t\t[3]  Return\n" +
                        "\t\t\t=======================\n");
    }

   // ArrayList<Creature> aCaptured = new ArrayList<Creature>();

  //  aCaptured.add(getCStrawander);
  //  aCaptured.add(CChocowool);
  //  aCaptured.add(CParfwit);
  //  aCaptured.add(CBrownisaur);

    //int 

    public boolean returnToMainMenu()
    {
        return true;
    }
}
