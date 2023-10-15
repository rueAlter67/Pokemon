import java.lang.*; 
import java.util.Scanner; 


public class Area{

    // fields 

    private int nAreaLevel; 
    private int nXDim=5; // default to 0 later
    private int nYDim=1;
    private Creature CEnemy; 
    private Player CPlayer; 

 
    public Area(Player CPlayer)
    {
        this.CPlayer = CPlayer; 
        this.CEnemy = null; 
        this.nAreaLevel = 0; 
        this.nXDim = 0; 
        this.nYDim = 0; 
    }
	

	public int loadArea() 
    {
        Scanner CReader = new Scanner(System.in);
        int nCol; 
        int nRow; 
		int nMovement=0;   
        int nChecker=0;   

        do{
        
            for(nCol = 0; nCol < this.nYDim; nCol++)
            {
              System.out.printf("\n\n\t\t\t");
                for(nRow = 0; nRow < this.nXDim; nRow++)
                {
                    if(nRow ==  this.CPlayer.getPosX() && nCol == this.CPlayer.getPosY())
                        System.out.printf(" O ");
                    else 
                        System.out.printf(" + ");
                }

                System.out.print("\n\n");
            }
			
		    System.out.printf("\n\t\t\t=====MOVEMENTS====");
		    System.out.println("\n\t\t\t[1] UP" + 
                                "\n\t\t\t[2] DOWN" + 
                                "\n\t\t\t[3] LEFT" + 
                                "\n\t\t\t[4] RIGHT" + 
                                "\n\t\t\t[5] EXIT AREA\n");
							
    		while(nChecker == 0)
            {
                System.out.print("\n\t\t\t[INPUT]: ");
                System.out.println("\nPlayer x-coord : " + CPlayer.getPosX()+
                                    "\nPlayer y-coord : " + CPlayer.getPosY());
                System.out.print("\n\t\t\t[INPUT]: ");
            
                if(CReader.hasNextInt())
                {
                    nMovement = CReader.nextInt();   
                    if(nMovement >= 1 && nMovement <= 5)
                    {
                        nChecker = 1; 

                    }
                    else
                    {
                        System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Choose 1 to 4 only.\n");
                    
                    }
                }
                else
                {
                    System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Invalid Input. Input must be an integer.\n");
                   
                }

            }
            CReader.nextLine();

		    switch(nMovement)
            {
                case 1: 
                        this.CPlayer.goUp(nXDim,nYDim);
                        break;
                case 2: 
                        this.CPlayer.goDown(nXDim,nYDim);
                        break;
                case 3:
                        this.CPlayer.goLeft(nXDim,nYDim);
                        break;
                case 4: 
                        this.CPlayer.goRight(nXDim,nYDim);
                        break;
                case 5: 
                        break;
            }

        }while(nMovement != 5);

        return nMovement; 
    }


    public void run() 
    {
        int nArea = 0;  
        int nAreaChoice; 
		int nMovement=0;

        System.out.println("\n\n\t\t\t=======CHOOSE AREA=======\n"+
                         "\n\t\t\t[1]  AREA 1\n" + 
                          "\t\t\t[2]  AREA 2\n"+
                        "\t\t\t[3]  AREA 3\n" +
                        "\t\t\t=======================");
	
		//insert I/o FOR THE AREA
		
		this.nXDim = 5; 
		this.nYDim = 1; 
	
		do{
			nMovement = loadArea();
		}while(nMovement != 5);
	}
}