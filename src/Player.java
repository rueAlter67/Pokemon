import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player 
{
    // attributes/fields/state
   // private Creature nStarterCreature;
   //s private Inventory CInventory; 
    private int nPosX; 
    private int nPosY; 

    // constructor 
    public Player()
    {
        this.nPosX = 0; 
        this.nPosY = 0; 
    } 


    

    //+++++++++++ PLAYER'S INTERACTION WITH AREA
    // players can move ()
    public boolean goUp(int nXLimit, int nYLimit)
    {

        System.err.print("\n\n\t\t\t[ERROR]: Player can't move up anymore");   
        return false; 
    }

    public boolean goDown(int nXLimit, int nYLimit)
    {
        System.err.print("\n\n\t\t\t[ERROR]: Player can't move down anymore");   
        return false; 
    }

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

    public void attack(Creature CEnemy, Creature CActiveCreature)
    {
        Random CRand = new Random();
        int nMax = 10; 
        int nMin = 1;
        int nRandom = CRand.nextInt(nMax - nMin + 1) + nMin;
        double nDamage = nRandom * 1;// 1 the creature's level 

        // insert additional damage 
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

  //+++++++++++ setters and getters
    public int getPosX()
    {
        return this.nPosX;
    }
    
    public int getPosY() {
        return nPosY;
    }

  

}