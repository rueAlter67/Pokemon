import java.lang.*; 
import java.util.Scanner;

import javax.crypto.Cipher;

import java.util.ArrayList;
import java.util.Random;


/**
 * Area is the base class for all the area
 * that allows the application to 
 */
public class Area{
    
    protected int nXDim; 
    protected int nYDim; 
    protected int nAreaLevel;
    /*protected Player CPlayer;
    protected ArrayList<Creature> CMasterInventory
    protected CCreature CEnemy*/

    
 
    public Area(int nAreaLevel)
    {
        //this.CMasterInventory = CMasterInventory;
        //this.CPlayer = CPlayer; 
        //this.CEnemy = null; 
        this.nAreaLevel = 0; 

        this.nAreaLevel = nAreaLevel; 

        if(nAreaLevel == 1)
        {
            this.nXDim = 5; 
            this.nYDim = 1;
        }else if(nAreaLevel == 2){
            this.nXDim = 3;
            this.nYDim = this.nXDim;
        }else{
            this.nXDim = 4;
            this.nYDim = this.nXDim;
        }
    }


    public int getXDimension(){
        return this.nXDim; 
    }

    public int getYDimension(){
        return this.nYDim;
    }
    /* 
    public Player getPlayer(){
        return this.CPlayer; 
    }

    public Creature getEnemyCreature(){
        return this.CEnemy;
    }

    public ArrayList<Creature> getMasterInventory(){

        return ArrayList<Creature> CMasterInventory;
    }
    */
}

    