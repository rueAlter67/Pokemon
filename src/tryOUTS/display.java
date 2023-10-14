import java.util.ArrayList;
import java.util.Scanner;

public class display 
{
    public static void main(String[] args) {
        int nArea; 
        Scanner CReader = new Scanner(System.in);
        int nValid = 0; 
        do
        {
            System.out.print("\n\t\t\t[INPUT]: ");

            if(CReader.hasNextInt())
            {   
                nArea = CReader.nextInt();

                if(nArea == 1)
                {
                    nValid = 1; 
                    //nArea;
                    CReader.nextLine(); // buffer
        
                }
                else
                {
                    System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Only Area 1 is available.\n");
                                CReader.nextLine(); // buffer
                }
            }
            else
            {
                System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Invalid Input. Input must be an integer.\n");
                if(CReader.hasNextLine())
                     CReader.nextLine(); // buffer
            }
            
        }while(nValid == 0 );

    }
}
