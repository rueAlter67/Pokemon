 
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
     //   this.CInventory = new Inventory(Creature nStarterCreature); 
        this.nPosX = 0; 
        this.nPosY = 0; 
    } 


    // behaviors 

    //+++++++++++
    /* chooseStarterCreature will display a list of EL1 creature
     * from the MasterInventory and then 
     * add this Creature to the inventory
     * if addingStarter creature is successful add to 
     * Inventory of the player. 
     */
    public boolean chooseStarterCreature()
    {

        return true; 
    }

    //+++++++++++ PLAYER'S INTERACTION WITH ENEMY
    /* swapCreature changes the 
     * activecreature of the player with
     * one of the creatures in its inventory
     */
    public boolean swapCreature()
    {

        return true; 

    }

    /* does not interact with the creature  */
    public boolean skip()
    {
        return true; 
    }

    // public boolean catchCreature(Creature CEnemy)
    // {

    //     return true; 
    // }


    //+++++++++++ PLAYER'S INTERACTION WITH AREA
    // players can move ()
     public boolean goUp(int nXLimit, int nYLimit)
    {
        System.err.print("\n\n\t\t\t[ERROR]: Player can't move up anymore");   
        return true; 
    }

    
    public boolean goDown(int nXLimit, int nYLimit)
    {
        System.err.print("\n\n\t\t\t[ERROR]: Player can't move down anymore");   
        return true; 
    }

    public boolean goLeft(int nXLimit, int nYLimit)
    {
        if(this.nPosX <nXLimit-1)
            this.nPosX+=1; 
        else
        {
            System.err.print("\n\n\t\t\t[ERROR]: Player can't move anymore to the left");
        }

        return true; 
    }

    public boolean goRight(int nXLimit, int nYLimit)
    {
        if(this.nPosX > 0)
            this.nPosX-=1; 
        else
        {
            System.err.print("\n\n\t\t\t[ERROR]: Player can't move anymore to the right");
        }

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