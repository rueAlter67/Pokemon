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


    // behaviors 

    //+++++++++++ PLAYER'S INTERACTION WITH ENEMY
    /* swapCreature changes the 
     * activecreature of the player with
     * one of the creatures in its inventory
     */

    // public boolean catchCreature(Creature CEnemy)
    // {

    //     return true; 
    // }


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

        if(this.nPosX <nXLimit-1)
        {
            this.nPosX+=1; 
        }
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

        if(this.nPosX > 0)
            this.nPosX-=1; 
        else
        {
            bMove = false; 
            System.err.print("\n\n\t\t\t[ERROR]: Player can't move anymore to the right");
        }

        return true; 
    }

    public void attack(Creature CEnemy, Creature CActiveCreature)
    {
        Random CRand = new Random();
        int nMax = 10; 
        int nMin = 1;
        int nRandom = CRand.nextInt(nMax - nMin + 1) + nMin;
        int nDamage = nRandom * 1;// 1 the creature's level 

        // insert additional damage 

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
        System.out.println("\n\t\t\tDAMAGE: "+ nDamage + "\n");
        CEnemy.setHealth(CEnemy.getHealth() - nDamage);
    }

    public boolean catchCreature(Creature CEnemy)
    {
        double dCatchRate = 0; 
        return true; 
    }

  //+++++++++++ setters and getters
    public int getPosX()
    {
        return this.nPosX;
    }
    
    public int getPosY() {
        return nPosY;
    }

    // public Creature getnStarterCreature() {
    //     return nStarterCreature;
    // }


}