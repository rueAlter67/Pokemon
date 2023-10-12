public class Player 
{
    // attributes/fields/state
    private int nStarterCreature;
    private Inventory CInventory; 
    private int nPosX; 
    private int nPosY; 

    // constructor 
    public Player()
    {
        this.CInventory = new Inventory(); 
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

    //+++++++++++ PLAYER'S INTERACTION WITH AREA
    // players can move ()
    public boolean goLeft(int nXLimit, int nYLimit)
    {
        if(this.nPosY < nYLimit)
            this.nPosY+=1; 
        else if(this.nPosY == nYLimit)
        {
            // can't move to the right anymore
        }

        return true; 
    }

    public boolean goRight(int nXLimit, int nYLimit)
    {
        if(this.nPosX < nXLimit)
            this.nPosX-=1; 
        else if(this.nPosX == nXLimit)
        {
            // can't move to the right anymore
        }

        return true; 
    }

    public boolean goUp(int nPosX, int nPosY, int nXLimit, int nYLimit)
    {
        if(this.nPosY < nYLimit)
            this.nPosY+=1; 
        else if(this.nPosY = nYLimit)
        {
            // can't move to the left anymore
        }
        return true; 
    }

    public boolean goDown(int nPosX, int nPosY, int nXLimit, int nYLimit)
    {
        return true; 
    }

}