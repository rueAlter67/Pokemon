import java.util.Scanner; 


public class Area{

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
        Scanner CReader = new Scanner(System.in);
        int nArea = 0; 
        int nValid = 0; 
        int nAreaChoice; 

        System.out.println("\n\n\t\t\t=======CHOOSE AREA=======\n"+
                         "\n\t\t\t[1]  AREA 1\n" + 
                          "\t\t\t[2]  AREA 2\n"+
                        "\t\t\t[3]  AREA 3\n" +
                        "\t\t\t=======================\n");

            nArea = CReader.nextInt()
            if(Integer.bitCount(nArea) >0 )
            {
              // nArea = CReader.nextInt();
                CReader.nextLine();
                System.out.println("VALID");
            }
            else
            {
                System.out.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Only Area 1 is available.\n");
            }
      //  }while(nValid == 0);


    }

}