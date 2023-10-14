import java.io.CharArrayReader;
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
        int nAreaChoice; 

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

        if(this.nAreaLevel == 1)
        {
            this.nXDim = 5; 
            this.nYDim = 1;
        }
        else if(this.nAreaLevel == 2)
        {
            this.nXDim = 3; 
            this.nYDim = 3;
        }
        else
        {
            this.nXDim = 4; 
            this.nYDim = 4;
        }
        System.out.println("CHECKPOINT");

        do{
            nAreaChoice = loadArea(CPlayer);
        }while(nAreaChoice != 5);

        if(nAreaChoice == 5)
        {
            System.out.print("\n\n\t\t\t[SYSTEM MESSAGE]: Press any button to go back to Main Menu.");
            CReader.nextLine(); 
            //CGame.displayMenu();
        }

    }

    public int loadArea(Player CPlayer)
    {
        int nCol; 
        int nRow; 
        int nValid = 0; 
        int nMovement; 
        //Scanner CReader = new Scanner(System.in);

        for(nCol = 0; nCol < this.nYDim; nCol++)
        {
            System.out.println("\n\t\t\t");
            for(nRow = 0; nRow < this.nXDim; nRow++)
            {
                if(nRow ==  CPlayer.getPosX() && nCol == CPlayer.getPosY())
                    System.out.print(" O ");
                else 
                    System.out.print(" + ");
            }

            System.out.print("\n");
        }


        while(nValid == 0)
        {
            System.out.println("\n\t\t\t=====MOVEMENTS====");
            System.out.println("\n\t\t\t[1] UP" + 
                                "\n\t\t\t[2] DOWN" + 
                                "\n\t\t\t[3] LEFT" + 
                                "\n\t\t\t[4] RIGHT" + 
                                "\n\t\t\t[5] EXIT AREA");

            System.out.print("\n\t\t\t[INPUT]: ");

            if(CReader.hasNextInt())
            {   
                nMovement = CReader.nextInt();
                if(nMovement >= 1 && nMovement <= 5)
                {
                    nValid = 1; 
                    CReader.nextLine(); // buffer
                }
                else
                {
                    System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Choose 1 to 4 only.\n");
                    CReader.nextLine(); //buffer
                }
            }
            else
            {
                System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Invalid Input. Input must be an integer.\n");
                CReader.nextLine(); //buffer
            }
        }

        switch(nMovement)
        {
            case 1: 
                    CPlayer.goUp(CPlayer.getPosX(),CPlayer.getPosY(),nXDim,nYDim);
                    return nMovement;
                    break;
            case 2: 
                    CPlayer.goDown(CPlayer.getPosX(),CPlayer.getPosY(),nXDim,nYDim);
                    return nMovement;
                    break;
            case 3:
                    CPlayer.goLeft(CPlayer.getPosX(),CPlayer.getPosY(),nXDim,nYDim);
                    return nMovement;
                    break;
            case 4: 
                    CPlayer.goRight(CPlayer.getPosX(),CPlayer.getPosY(),nXDim,nYDim);
                    return nMovement;
                    break;
            case 5: 
                    CReader.close();
                    return nMovement;
        }



    }






}
