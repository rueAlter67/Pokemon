import java.lang.*; 
import java.util.Scanner; 
import java.util.Random;


public class Area{

    // fields 

    private int nAreaLevel; 
    private int nXDim=5; // default to 0 later
    private int nYDim=1;
    private Creature CEnemy; 
    private Player CPlayer; 
    private Creature[] CMasterInventory; 
 
    public Area(Player CPlayer, Creature[] CMasterInventory)
    {
        this.CMasterInventory = CMasterInventory;
        this.CPlayer = CPlayer; 
        this.CEnemy = null; 
        this.nAreaLevel = 0; 
        this.nXDim = 0; 
        this.nYDim = 0; 
    }
	

	public int loadArea() 
    {
        Scanner CReader = new Scanner(System.in);
        Random CRandom = new Random();
        int nCol; 
        int nRow; 
		int nMovement=0;   
        int nChecker=0;  
        boolean bPlayer=true; 


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
			nMovement=0;
            nChecker=0;	
            bPlayer=true; 

    		while(nChecker == 0)
            {
                System.out.println("\nPlayer x-coord : " + CPlayer.getPosX()+
                                    "\nPlayer y-coord : " + CPlayer.getPosY());
                System.out.print("\n\t\t\t[INPUT]: ");
            
                if(CReader.hasNextInt())
                {
                    nMovement = CReader.nextInt();   
                    if(nMovement >= 1 && nMovement <= 5)
                    {
                        nChecker = 1; 
                        CReader.nextLine();
                    }
                    else
                    {
                        System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Choose 1 to 5 only.\n");
                         CReader.nextLine();
                    
                    }
                }
                else
                {
                    System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Invalid Input. Input must be an integer.\n");
                     CReader.nextLine();  
                }

            }
           // CReader.nextLine();

		    switch(nMovement)
            {
                case 1: 
                        bPlayer = this.CPlayer.goUp(nXDim,nYDim);
                        break;
                case 2: 
                        bPlayer = this.CPlayer.goDown(nXDim,nYDim);
                        break;
                case 3:
                        bPlayer = this.CPlayer.goLeft(nXDim,nYDim);
                        break;
                case 4: 
                        bPlayer = this.CPlayer.goRight(nXDim,nYDim);
                        break;
                case 5: 
                        bPlayer = false;
                        break;
            }

<<<<<<< HEAD
            double dChance = CRandom.nextDouble();
=======
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
>>>>>>> 2cc38e4be947dc858d600d2eae8d987d14841bbd

            if(dChance <= 0.40 && bPlayer == true && nMovement != 5 )
            {
                System.out.print("\n\n[SYSTEM MESSAGE]: You've encountered an enemy!! Press any button to proceed");
                CReader.nextLine(); 
                System.out.println("\n\n\n\n");
                this.CEnemy = getRandomCreature(CMasterInventory);
                this.CEnemy.setHealth(50);
                battle(this.CEnemy);
            } 

        }while(nMovement != 5);

        return nMovement; 

    }

    public void run() 
    {
        Scanner CReader = new Scanner(System.in);
        int nAreaChoice=0;
        int nChecker =0;; 

        System.out.println("\n\n\t\t\t=======CHOOSE AREA=======\n"+
                         "\n\t\t\t[1]  AREA 1\n" + 
                          "\t\t\t[2]  AREA 2\n"+
                        "\t\t\t[3]  AREA 3\n" +
                        "\t\t\t=======================");
        
        while(nChecker == 0)
        {
            System.out.print("\n\t\t\t[INPUT]: ");
            if(CReader.hasNextInt())
               {
                    nAreaChoice = CReader.nextInt();   
                    if(nAreaChoice >= 1 && nAreaChoice <= 3)
                    {
                        nChecker = 1; 
                        CReader.nextLine();
                    }
                    else
                    {
                        System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Choose 1 to 3 only.\n");
                         CReader.nextLine();
                    
                    }
                }
                else
                {
                    System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Invalid Input. Input must be an integer.\n");
                     CReader.nextLine();  
                }

        }
           // CReader.nextLine();

		    switch(nAreaChoice)
            {
                case 1: 
                        this.nXDim = 5; 
		                this.nYDim = 1; 
                        break;
                case 2: 
                        this.nXDim = 5; 
		                this.nYDim = 1; 
                        break;
                case 3:
                        this.nXDim = 5; 
		                this.nYDim = 1; 
                        break;
    
            }
        
    }


    public void battle(Creature CEnemy)
    {
        Scanner CReader = new Scanner(System.in);
        int nMovesLeft = 3; 
        int nBattleMove = 0; 

        do{
            System.out.println("\n\n\t\t\t================BATTLE=================\n"+
                            "\t\t\t\tMoves left: "+ nMovesLeft +
                            "\n\t\t\tEnemy Health: " + this.CEnemy.getHealth() + 
                             "\n\t\t\t======================================="+

                         "\n\n\n\t\t\t[1]  ATTACK \n" + 
                          "\t\t\t[2]  SWAP \n"+
                        "\t\t\t[3]  CATCH \n" +
                        "\t\t\t[4]  SKIP CREATURE \n");

                        System.out.println("Creature: " + this.CEnemy.getCreatureName());
                       
            nBattleMove=0;
            int nChecker = 0;	

    		while(nChecker == 0)
            {
                System.out.print("\n\t\t\t[INPUT]: ");
            
                if(CReader.hasNextInt())
                {
                    nBattleMove = CReader.nextInt();   
                    if(nBattleMove >= 1 && nBattleMove <= 4)
                    {
                        nChecker = 1; 
                        CReader.nextLine();
                        nMovesLeft-=1;
                    }
                    else
                    {
                        System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Input out of bounds. Choose 1 to 5 only.\n");
                        CReader.nextLine();
                    
                    }
                }
                else
                {
                    System.err.println("\n\t\t\t[SYSTEM MESSAGE]: Invalid Input. Input must be an integer.\n");
                     CReader.nextLine();  
                }

            }

            switch(nBattleMove)
            {
                case 1: 
                        CPlayer.attack(this.CEnemy, this.CPlayer);
                        break;
                case 2: 
                       // this.CPlayer.goDown(nXDim,nYDim);
                        break;
                case 3:
                       // this.CPlayer.goLeft(nXDim,nYDim);
                        break;
                case 4: 
                       // this.CPlayer.goRight(nXDim,nYDim);
                        break;
                case 5: 
                        loadArea();
                        break;
            }
            
           
        }while(nMovesLeft >= 1 && CEnemy.getHealth() > 0);
        
        
    }

    public Creature getRandomCreature(Creature[] MasterInventory)
    {
        Random CRand = new Random();
        int nRandom = (char)(CRand.nextInt(9-1) + 1);
      
        return MasterInventory[nRandom];
    }

}