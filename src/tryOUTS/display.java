import java.util.Scanner;

public class display 
{
    public static void main(String[] args) {

        int row, col; 
        int x = 5; 
        int y = 1; 
        int playerX = 0;
        int playerY = 0; 
        System.out.println("\n");
        
        for(col = 0; col < y; col++)
        {
            for(row = 0; row < x; row++)
            {
                if(row == playerX && col == playerY)
                    System.out.print("O ");
                else 
                    System.out.print("+ ");
            }

            System.out.print("\n");
        }
    }
}
