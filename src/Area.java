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

 
    public Area(Player CPlayer)
    {
        this.CPlayer = CPlayer; 
        this.CEnemy = null; 
        this.nAreaLevel = 0; 
        this.nXDim = 0; 
        this.nYDim = 0; 
    }
	

	public int loadArea(Game CGame) 
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
			nMovement=0;
            nChecker = 0;	

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

            double dChance = 0.40; 


            if(dChance == 0.40)
            {
                System.out.print("\n\n[SYSTEM MESSAGE]: You've encountered an enemy!! Press any button to proceed");
                CReader.nextLine(); 
                System.out.println("\n\n\n\n");
                this.CEnemy = getRandomCreature(CGame.getAllCreatures());
                battle(this.CEnemy);
            } 



        }while(nMovement != 5);

        return nMovement; 

    }


    public void run(Game CGame) 
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
			nMovement = loadArea(CGame);
		}while(nMovement != 5);


    }


    public void battle(Creature CEnemy)
    {
        Scanner CReader = new Scanner(System.in);
        int nMovesLeft = 3; 
        int nEnemyHealth = 100; 
        int nBattleMove = 0; 

        do{
            System.out.println("\n\n\t\t\t================BATTLE=================\n"+
                            "\t\t\t\tMoves left: "+ nMovesLeft +
                            "\n\t\t\tEnemy Health: " + nEnemyHealth + 

                             "\t\t\t======================================="+

                         "\n\n\n\t\t\t[1]  ATTACK \n" + 
                          "\t\t\t[2]  SWAP \n"+
                        "\t\t\t[3]  CATCH \n" +
                        "\t\t\t[4]  SKIP CREATURE \n");
                       
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
                        nEnemyHealth=attack(nEnemyHealth);
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
                        break;
            }
            
           
	
        }while(nMovesLeft >= 1 && nEnemyHealth >0);
        
    }


    public int attack(int nEnemyHealth)
    {
        Random CRand = new Random();
        int nMax = 10; 
        int nMin = 1;
        int nRandom = CRand.nextInt(nMax - nMin + 1) + nMin;
        int nDamage = nRandom * 1;// 1 should be the creatures level 

        return nEnemyHealth-nDamage;
    }

    public Creature getRandomCreature(Creature[] MasterInventory)
    {
        Random CRand = new Random();
        char cRandom = (char)(CRand.nextInt('G'-'A') + 'A');
        int nFound = -1;
        int nIndex = 0;
        
        do{
            if(MasterInventory[nIndex].getFamily() == cRandom && MasterInventory[nIndex].getLevel() == this.nAreaLevel)
                nFound = nIndex;
            
            nIndex++;

        }while(nFound == -1 && nIndex < 9);

        return MasterInventory[nFound];
        
    }

    
}