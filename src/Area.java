public class Area {

    // fields
    private int nAreaLevel;
    private int nXDim; 
    private int nYDim;
    private Creature CEnemy; 
    
    public Area(int nAreaLevel, int nXDim, int nYDim, Creature CEnemy)
    {
        this.nAreaLevel = nAreaLevel; 
        
        if(nAreaLevel == 1)
        {
            this.nXDim = 5; 
            this.nYDim = 1;
        }
        else if(nAreaLevel == 2)
        {
            this.nXDim = 3; 
            this.nYDim = 3;
        }
        else
        {
            this.nXDim = 4; 
            this.nYDim = 4;
        }

        this.CEnemy = null; 

    }


    public void loadArea(Player CPlayer)
    {
        int nCol; 
        int nRow; 

        for(nCol = 0; nCol < this.nYDim; nCol++)
        {
            for(nRow = 0; nRow < this.nXDim; nRow++)
            {
                if(nRow ==  CPlayer.getPosX() && nCol == CPlayer.getPosY())
                    System.out.print("O ");
                else 
                    System.out.print("+ ");
            }

            System.out.print("\n");
        }
    }

}
