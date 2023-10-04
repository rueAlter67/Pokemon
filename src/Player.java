public class Player 
{
    //attributes/fields/state
    private int nStarterCreature;
    private Creature[] CCreaturesCatpured;
    private int nPosX; 
    private int nPosY; 



    // behaviors 
    public boolean chooseStarterCreature()
    {
        return true; 
    }




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