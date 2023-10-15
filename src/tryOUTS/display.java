import java.util.ArrayList;
import java.lang.Integer;
import java.util.Scanner;

public class display 
{
    public static void main(String[] args) 
    {
        Scanner CReader = new Scanner(System.in);
        int nXDim = 5; 
        int nYDim = 1;
        Player CPlayer = new Player(); 

        int nCol; 
        int nRow; 
        int nMovement;
    do{
        nMovement=0;
        for(nCol = 0; nCol < nYDim; nCol++)
        {
            System.out.printf("\n\n\t\t\t");
            for(nRow = 0; nRow < nXDim; nRow++)
            {
                if(nRow ==  CPlayer.getPosX() && nCol == CPlayer.getPosY())
                    System.out.printf(" O ");
                else 
                    System.out.printf(" + ");
            }

            System.out.print("\n\n");
        }
		
        int nChecker = 0; 
        String buffer;
		
		System.out.println("\n\t\t\t=====MOVEMENTS====");
            System.out.print("\n\t\t\t[1] UP" + 
                                "\n\t\t\t[2] DOWN" + 
                                "\n\t\t\t[3] LEFT" + 
                                "\n\t\t\t[4] RIGHT" + 
                                "\n\t\t\t[5] EXIT AREA\n");
								
		while(nChecker == 0)
        {
            System.out.print("\n\t\t\t[INPUT]: ");
             System.out.println("\nPlayer x-coord : " + CPlayer.getPosX()+
                                 "\nPlayer y-coord : " + CPlayer.getPosY());
            if(CReader.hasNextInt())
            {
                nMovement = CReader.nextInt(); 
                System.out.print("\nNMVEOMENT IS : " + nMovement);
            
                if(nMovement >= 1 && nMovement <= 5)
                {
                    nChecker = 1; 
                    CReader.nextLine(); //buffer
                }
                else
                {
                    System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Choose 1 to 4 only.\n");
                    CReader.nextLine(); //buffer//buffer
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
                    CPlayer.goUp(nXDim,nYDim);
                    break;
            case 2: 
                    CPlayer.goDown(nXDim,nYDim);
                    break;
            case 3:
                    CPlayer.goLeft(nXDim,nYDim);
                    break;
            case 4: 
                    CPlayer.goRight(nXDim,nYDim);
                    break;
            case 5: 
                    break;
        }
	
    }while(nMovement != 5);
		CReader.close(); 

    }
}