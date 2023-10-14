import java.util.Scanner;

public class Area {

    // fields
    private int nAreaLevel;
    private int nXDim; 
    private int nYDim;
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

    public void run()
    {
        System.out.print("\n\n\n");
        Scanner CReader = new Scanner(System.in);
        int nArea=0;
        int nValid = 0;  

    
        System.out.print("\n\n\t\t\t=======CHOOSE AREA=======\n"+
                         "\t\t\t[1]  AREA 1\n" + 
                          "\t\t\t[2]  AREA 2\n"+
                        "\t\t\t[3]  AREA 3\n" +
                        "\t\t\t=======================\n");

        while(nValid == 0 )
        {
            System.out.print("\n\t\t\t[INPUT]: ");

            if(CReader.hasNextInt())
            {   
                nArea = CReader.nextInt();
                if(nArea == 1 )
                {
                    nValid = 1; 
                    CReader.nextLine(); // buffer
                }
                else
                {
                    System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Only Area 1 is available.\n");
                    CReader.nextLine(); //buffer
                }
            }
            else
            {
                System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Invalid Input. Input must be an integer.\n");
                CReader.nextLine(); //buffer
            }
        }

        
        this.nAreaLevel = nArea;

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

        CReader.close();
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
