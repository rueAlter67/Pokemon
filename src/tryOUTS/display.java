import java.util.ArrayList;
import java.lang.Integer;
import java.util.Scanner;

public class display 
{
    public static void main(String[] args) 
    {
        
        Scanner CReader = new Scanner(System.in);
        int nNum; 

        if(CReader.hasNextInt())
        {
            nNum = CReader.nextInt();
            CReader.nextLine();
            System.out.println("VALID number " +nNum );
        }
        else
            System.out.println( "EROOR");


        if(CReader.hasNextLine())   
            System.out.println("There's an extra space");
        else    
            System.out.println("NO MORE SPACE");

    }
}